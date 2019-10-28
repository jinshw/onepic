﻿define(function (require, exports, module) {
	BaseObject.PathAnalysisService = BaseHelper.Class.create();
	BaseObject.PathAnalysisService.prototype = BaseHelper.Class.inherit(BaseObject.Component,{

	   initialize: function (globalMap, configData) {
            this.isActive = false;
            this.ID = this.getGUID();
            if (globalMap) {
                configData == null ? {} : configData;
                this.init(globalMap, configData);
            }
	    },

         init: function (globalMap, configData) {
            this.configData = configData;
            this.globalMap = globalMap;

            
	    	//alert("加载选择起点控件");
	    	this.pathListIndex = 0;
	    	this.routeCompsIndex = 0;
	    	this.style = {
	    				strokeColor : "#304DBE",
	    				strokeWidth : 3,
	    				pointerEvents : "visiblePainted",
	    				fill : false
	    			};
	    	this.styleGuidePoint = {
	    				pointRadius : 0//10//,
	    				//externalGraphic : "./images/walk.png"
	    			};
	    	this.styleGuideLine = {
	    				strokeColor : "#25FF25",
	    				strokeWidth : 6,
	    				fill : false
	    			}
    
            var thisCallBack=this;
            this.drawVector = this.globalMap.getConfigLayer("BaseDrawVector").getLayer();
	    	this.drawHandler = new SuperMap.Control.DrawFeature( this.drawVector,SuperMap.Handler.Point);			
	    	this.selectHandler = new SuperMap.Control.SelectFeature( this.drawVector, {
				onSelect : function(e){thisCallBack.onFeatureSelect},
				onUnselect :function(e){ thisCallBack.onFeatureUnselect}
			});
	    	this.drawHandler.events.on({
				"featureadded" :function(e){ thisCallBack.drawCompleted(e)}
			});			
			this.globalMap.mapObject.addControl(this.drawHandler);
			//this.globalMap.mapObject.addControl(this.selectHandler);
			this.markerLayer = new SuperMap.Layer.Markers("Markers");
			this.globalMap.mapObject.addLayers([this.markerLayer]);
            this.globalMap.markPosition=this;
         },

		findPath:function(startPoint,endPoint) {
			var thisCallBack=this;
			this.drawHandler.deactivate();
		 
			var findPathService, parameter, analystParameter, resultSetting;
			resultSetting = new SuperMap.REST.TransportationAnalystResultSetting({
				returnEdgeFeatures : true,
				returnEdgeGeometry : true,
				returnEdgeIDs : true,
				returnNodeFeatures : true,
				returnNodeGeometry : true,
				returnNodeIDs : true,
				returnPathGuides : true,
				returnRoutes : true
			});
			analystParameter = new SuperMap.REST.TransportationAnalystParameter({
				resultSetting : resultSetting,
				weightFieldName : "smLength"
			});
			this.nodeArray = [];
			this.nodeArray.push(startPoint);
			this.nodeArray.push(endPoint);
			parameter = new SuperMap.REST.FindPathParameters({
				isAnalyzeById : false,
				nodes : this.nodeArray,
				hasLeastEdgeCount : false,
				parameter : analystParameter
			});
			if (this.nodeArray.length <= 1) {
				alert("站点数目有误");
			}
			var mapObj = this.globalMap.configMapData;
			var url =BaseObject.mapPathAnalysisUrl;
			findPathService = new SuperMap.REST.FindPathService(url, {
				eventListeners : {
					"processCompleted" :function(e){ thisCallBack.processCompleted(e)},
					"processFailed" : function(e){thisCallBack.processFailed(e) }
				}
			});
			findPathService.processAsync(parameter);
		},
		processCompleted:function(findPathEventArgs) {
			var result = findPathEventArgs.result;
			this.allScheme(result);
			var items = result.pathList[0].pathGuideItems;
			//alert("分析完成["+result.pathList[0].pathGuideItems.length+"]");
			var paths = []
			var bounds = new SuperMap.Bounds();
			for (var i in items) {
				paths.push(items[i].description);
				
	    		bounds.extend(items[i].geometry.getBounds());
			}
			if (paths.length > 0) {
			    this.globalMap.mapObject.zoomToExtent(bounds);
			}
             this.dispathEvent("processCompleted", findPathEventArgs);
			//this.showResult(findPathEventArgs);
		},
		allScheme:function(result) {
			if (this.pathListIndex < result.pathList.length) {
				this.addPath(result);
			} else {
				this.pathListIndex = 0;
				//线绘制完成后会绘制关于路径指引点的信息
				this.addPathGuideItems(result);
			}
		},
		//以动画效果显示分析结果
		addPath:function(result) {
			if (this.routeCompsIndex < result.pathList[this.pathListIndex].route.components.length) {
				var pathFeature = new SuperMap.Feature.Vector();
				var points = [];
				for (var k = 0; k < 2; k++) {
					if (result.pathList[this.pathListIndex].route.components[this.routeCompsIndex
							+ k]) {
						points
								.push(new SuperMap.Geometry.Point(
										result.pathList[this.pathListIndex].route.components[this.routeCompsIndex
												+ k].x,
										result.pathList[this.pathListIndex].route.components[this.routeCompsIndex
												+ k].y));
					}
				}
				var curLine = new SuperMap.Geometry.LinearRing(points);
				pathFeature.geometry = curLine;
				pathFeature.style = this.style;
				this.drawVector.addFeatures(pathFeature);
				//每隔0.001毫秒加载一条弧段
                var thisCallBack=this;
				this.pathTime = setTimeout(function() {
					thisCallBack.addPath(result);
				}, 0.001);
				this.routeCompsIndex++;
			} else {
				clearTimeout(this.pathTime);
				this.routeCompsIndex = 0;
				this.pathListIndex++;
				this.allScheme(result);
			}
		},
		 processFailed:function(queryEventArgs){
    		//alert("sql查询失败-->"+e.error.errorMsg);
    		this.dispathEvent("processFailed", {refData:this.refData,data:queryEventArgs});
    	},
		addPathGuideItems:function(result) 
            {
		    this.clear();
			//显示每个pathGuideItem和对应的描述信息
			for (var k = 0; k < result.pathList.length; k++) {
				var pathGuideItems = result.pathList[this.pathListIndex].pathGuideItems, len = pathGuideItems.length;
				for (var m = 0; m < len; m++) {
					var guideFeature = new SuperMap.Feature.Vector();
					guideFeature.geometry = pathGuideItems[m].geometry;
					guideFeature.attributes = {
						description : pathGuideItems[m].description
					};
					if (guideFeature.geometry.CLASS_NAME === "SuperMap.Geometry.Point") {
						guideFeature.style = this.styleGuidePoint;
					} else {
						guideFeature.style = this.style;
					}
                    this.features.push(guideFeature);
					
				}
			}
            this.drawVector.addFeatures(this.features);
			this.selectHandler.activate();
		},
		//选中时显示路径指引信息
		onFeatureSelect:function(feature) {
			if (feature.attributes.description) {
				popup = new SuperMap.Popup("chicken", feature.geometry.getBounds()
						.getCenterLonLat(), new SuperMap.Size(200, 30),
						"<div style='font-size:.8em; opacity: 0.8'>"
								+ feature.attributes.description + "</div>", null,
						false);
				feature.popup = popup;
				this.globalMap.mapObject.addPopup(popup);
			}
			if (feature.geometry.CLASS_NAME != "SuperMap.Geometry.Point") {
				feature.style = this.styleGuideLine;
				this.drawVector.redraw();
			}
		},
		//清除要素时调用此函数
		onFeatureUnselect:function(feature) {
			this.globalMap.mapObject.removePopup(feature.popup);
			feature.popup.destroy();
			feature.popup = null;
			if (feature.geometry.CLASS_NAME != "SuperMap.Geometry.Point") {
				feature.style = markPosition.style;
			}
			this.drawVector.redraw();

		},
        clear:function()
        {   
            if(this.features)
          	this.drawVector.removeFeatures(this.features);
            this.features=[];
        },
  
	    //初始化位置
	    initPosition: function() { },
 
	    CLASS_NAME: "BaseObject.PathAnalysisService"
	});
	module.exports = BaseObject.PathAnalysisService;

});