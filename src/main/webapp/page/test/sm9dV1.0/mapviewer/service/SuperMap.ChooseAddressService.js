define(function (require, exports, module) {
    BaseObject.ChooseAddress = BaseHelper.Class.create();
    BaseObject.ChooseAddress.prototype = BaseHelper.Class.inherit(BaseObject.Component, {

        initialize: function (globalMap, configData) {
            this.ID = this.getGUID();
            if (globalMap) {
                configData == null ? {} : configData;
                this.init(globalMap, configData);
            }
        },

        init: function (globalMap, configData) {
            //alert("加载选择地址控件");
            var thisCallBack = this;
            this.globalMap = globalMap;
            this.configData = configData;
            this.drawVector = this.globalMap.getConfigLayer("BaseDrawVector").getLayer();
            this.drawHandler = new SuperMap.Control.DrawFeature(this.drawVector, SuperMap.Handler.Point);
            this.drawHandler.events.on({
                "featureadded": function (e) { thisCallBack.drawCompleted(e); }
            });
            this.globalMap.mapObject.addControl(this.drawHandler);
            this.globalMap.addService(this);
        },
        execute: function () {
            this.drawHandler.activate();
        },
        drawCompleted: function (drawGeometryArgs) {
            //由点构建一个圆start
            var sides = 50;
            var result = 50;
            result += this.globalMap.mapObject.getZoom();
            switch (this.globalMap.mapObject.getZoom()) {
                case 0: result = 10000; break;
                case 1: result = 9000; break;
                case 2: result = 8000; break;
                case 3: result = 7000; break;
                case 4: result = 5000; break;
                case 5: result = 2000; break;
                case 6: result = 1000; break;
                case 7: result = 900; break;
                case 8: result = 800; break;
                case 9: result = 700; break;
                case 10: result = 600; break;
                case 11: result = 300; break;
                case 12: result = 200; break;
                case 13: result = 50; break;
            }
            var radius = result / 30.9 / 3600;
            this.drawVector.removeAllFeatures();
            //alert("result["+result+"]<>"+"radius["+radius+"]<>");
            var origin = new SuperMap.Geometry.Point(drawGeometryArgs.feature.geometry.x, drawGeometryArgs.feature.geometry.y);
            var polygon = SuperMap.Geometry.Polygon.createRegularPolygon(origin, radius, sides, 270);
            var style = { strokeColor: "#304DBE", strokeWidth: 1, pointerEvents: "visiblePainted", fillColor: "#304DBE", fillOpacity: 0.5 };
            var tempFeature = new SuperMap.Feature.Vector();
            tempFeature.geometry = polygon;
            tempFeature.style = style;
            this.drawVector.addFeatures(tempFeature);
            //由点构建一个圆end

            var url = BaseObject.mapDataUrl;
            this.drawVector.removeAllFeatures();
            var getFeaturesByGeometryParameters, getFeaturesByGeometryService;
            getFeaturesByGeometryParameters = new SuperMap.REST.GetFeaturesByGeometryParameters({
                datasetNames: [BaseObject.baseDatasource + ":GLLW"],
                spatialQueryMode: SuperMap.REST.SpatialQueryMode.INTERSECT,
                geometry: polygon
            });
            var thisCallBack = this;
            getFeaturesByGeometryService = new SuperMap.REST.GetFeaturesByGeometryService(url, {
                eventListeners: {
                    "processCompleted": function (getFeaturesEventArgs) {
                        if (getFeaturesEventArgs.result.features.length > 0)
                            thisCallBack.globalMap.bufferGeometry = getFeaturesEventArgs.result.features[0].geometry;
                        thisCallBack.processCompleted(getFeaturesEventArgs);
                    },
                    "processFailed": function (e) { thisCallBack.processFailed(e) }
                }
            });
            getFeaturesByGeometryService.processAsync(getFeaturesByGeometryParameters);
        },
        processCompleted: function (getFeaturesEventArgs) {
            //alert("调用服务成功");
             var result = getFeaturesEventArgs.result;
            if (result && result.features) {
                features = result.features;
                this.dispathEvent("processCompleted", getFeaturesEventArgs);
            }
        },

        clear:function() {
            this.drawHandler.deactivate();
        },
        processFailed: function (e) {
            alert("调用服务失败-->" + e.error.errorMsg);
           // art.dialog({ time: 100, content: '调用服务失败!' + e.error.errorMsg });
            this.dispathEvent("processFailed", e);
        },
        //初始化位置
        initPosition: function () { },
        CLASS_NAME: "BaseObject.ChooseAddress"
    });
    module.exports = BaseObject.ChooseAddress;

});