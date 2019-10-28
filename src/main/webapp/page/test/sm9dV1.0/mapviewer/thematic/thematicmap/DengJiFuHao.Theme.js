define(function (require, exports, module) {
    BaseObject.DengJiFuHao = BaseHelper.Class.create();
    BaseObject.DengJiFuHao.prototype = BaseHelper.Class.inherit(BaseHelper.GUID,BaseHelper.EventListener, {

        initialize: function (globalMap) {
            this.ID = this.getGUID();
            this.title = "等级符号专题图";
            this.globalMap = globalMap;

            if (globalMap) {
                var thisCallBack = this;
                this.globalMap.addEventListener("clearAll", function () {
                    thisCallBack.clear();
                });

                this.globalMap.addEventListener("resize", function () {
                    thisCallBack.clear();
                });
            }
        },
        init: function (globalMap) {
            this.globalMap = globalMap;
        },

        showLegend: function (data) {
            if (this.legendWidget)
                this.legendWidget.remove();

            title = data.title || "饼状专题图例";
            title += data.target != undefined ? "/" + data.target.NOTE : "";

            var html = "<div style=\" border-bottom:1px solid #ccc\">" + title + "</div>";
            html += "<div style=\"text-align:left;margin-top:5px;\">";
            var tHight = 0;
            var lastSymbom = this.symbolArray[this.symbolArray.length-1]
            for (var index = 0; index < this.symbolArray.length; index++) {
                var item = this.symbolArray[index];
                var divHeight = item.config.radius * 2 < 20 ? 20 : item.config.radius * 2;
                tHight += divHeight;
                var marginLeft = lastSymbom.config.radius - item.config.radius;
                html += "<div class='lenged-inline' style='height:" + divHeight + "px'><div  class='left' style='margin-left:"+marginLeft+"px;width:" + item.config.radius * 2 + "px;height:" + item.config.radius * 2 + "px; border-radius:" + item.config.radius + "px; background-color:" + item.config.color + "' ></div><div class='right' style='height:" + item.config.radius * 2 + "px'>" + item.config.name + "</div></div>";
            }

            var height = 60 + tHight;
            //html += "<div class='lenged-inline' style='color:#ccc;font-size:13px'>来源:农业部农药检定所</div>";
            html += "</div>";
            var div = document.createElement("div");
            div.id = "component_" + this.getGUID();
            div.className = "mapviewer-widget mapviewer-clearfix";
            div.style.cssText = "border:1px solid #ccc; font-size:13px;text-align:center;position:absolute;z-index:10000;width:150px; height:" + height + "px;";
            $(div).append(html);
            this.dispathEvent("showLegend", { html: $(div), data: data });
            //$(this.globalMap.viewerContainer).append($(div));
            //var id = "legendWidget" + this.ID;
            //this.legendWidget = $("#" + div.id);

            //this.legendWidget.css({ "top": $(this.globalMap.viewerContainer).height() - height - 8, "bottom": 1 });
            //this.setLegendPosition(this.positonStatus);
        },

        show: function (data) {

            this.clear();

            var headerData = data.headerData;
            var resultData = data.resultData;
            var target = data.target;
            var headerCodes = [];
            var thisCallBack = this;

            for (var index = 0; index < headerData.length; index++) {
                var item = headerData[index];
                if (item.HEADER_FILED) {
                    headerCodes.push({ code: item.ITEM_CODE, name: item.ITEM_NAME });
                }
            }
            this.positonStatus = data.positonStatus;


            if (data.target.RANGE_VALUES) {
                this.initStyle(data.target.RANGE_VALUES, "setting");
            }
            else {
                //初始化分段样式
                var sumData = this.msum(resultData, headerCodes);
                this.initStyle(sumData);
            }
            // 创建一个圆形符号专题图层
            this.drawVector = new SuperMap.Layer.Vector("DJDrawVector");
            this.globalMap.mapObject.addLayers([this.drawVector]);

            var callbacks = {
                click: function (currentFeature) {
                }, over: function (currentFeature, e) {
                    thisCallBack.showInfoPopup(currentFeature);
                }, out: function (currentFeature) {
                    thisCallBack.hideInfoPopup(currentFeature);
                }
            };


            this.selectFeature = new SuperMap.Control.SelectFeature(this.drawVector,
                {
                    callbacks: callbacks
                });
            this.globalMap.mapObject.addControl(this.selectFeature);
            this.selectFeature.activate();
            // 指定用于专题图制作的属性字段 详看下面 addThemeLayer（）中的feature.attrs.CON2009
            this.drawVector.themeField = headerCodes[0].code;

            var compare = function (obj1, obj2) {
                var val1 = obj1[headerCodes[0].code];
                var val2 = obj2[headerCodes[0].code];
                if (val1 < val2) {
                    return -1;
                } else if (val1 > val2) {
                    return 1;
                } else {
                    return 0;
                }
            }
            resultData.sort(compare);

            // 配置图表参数
            this.drawVector.symbolSetting = {
                //必设参数
                codomain: [0, 40000000], // 允许图形展示的值域范围，此范围外的数据将不制作图图形

                //圆最大半径 默认100
                maxR: 5000,
                //圆最小半径 默认0
                minR: 10,
                // 圆形样式
                circleStyle: { fillOpacity: 0.9 },
                // 符号专题图填充颜色
                fillColor: "blue",
                // 专题图hover 样式
                circleHoverStyle: { fillOpacity: 1 }
            };
            var features = [];
            for (var index = 0; index < resultData.length; index++) {
                var item = resultData[index];
                var district = {};
                if (item.center)
                    district.center = item.center.clone();
                else
                    var district = this.globalMap.districtHashtable[item.CODE] || this.globalMap.districtHashtableN[item.LABEL]
                if (district && district.center) {

                    var geometry = null;
                    if (district.center.CLASS_NAME == "SuperMap.Geometry.Point")
                    {
                        geometry = district.center.clone();
                    }
                    else if (district.center.CLASS_NAME == "SuperMap.Geometry.MultiPolygon")
                    {
                        geometry = district.center.getCentroid()
                    }
                    
                    var feature = new SuperMap.Feature.Vector(geometry);
                    feature.attributes = item;

                    var name = item.LABEL;
                    feature.attributes["name"] = name;
                    var geo = new SuperMap.Geometry.Point(district.center.x, district.center.y);
                    var fea = new SuperMap.Feature.Vector(geo, feature.attributes);
                    fea.attributes = item;
                    fea.id = item.SMID;
                    var count = 0;
                    for (var i = 0; i < headerCodes.length; i++) {
                        count += Number(item[headerCodes[i].code]);
                    }
                    var style = this.getStyle(count);
                    fea.style = style;
                    fea.showStyle = style;
                    fea.targetData = { headerCodes: headerCodes, unit: data.target };
                    //if (count.toString().indexOf(".") > -1) count = count.toFixed(3);
                    //fea.style.label = item.LABEL;
                    features.push(fea);
                  
                    if (style&&style.config.maxLevel)
                    {
                        var marker = this._addFlashMarker(district);
                        marker.attributes = item;
                        marker.showStyle = marker.style;
                        marker.targetData = { headerCodes: headerCodes, unit: data.target };
                        features.push(marker);
                    }
                }
            }
            this.drawVector.addFeatures(features);
            //this.globalMap.mapObject.zoomToExtent(this.drawVector.getDataExtent());
            this.showLegend(data);

        },
        _changeStyle: function (id, status) {
            if (id) {
                var feature = this.drawVector.getFeatureById(id);
                if (feature && feature.style) {
                    if (status == "show") {
                        var style = this.clone(feature.showStyle);
                        style.pointRadius = style.pointRadius + 5;
                        feature.style = style;
                        this.drawVector.addFeatures(feature);
                    }
                    if (status == "hide") {
                        feature.style = feature.showStyle;
                        this.drawVector.addFeatures(feature);
                    }
                }
            }
        },


        _addFlashMarker:function(district)
        {
            var geo = new SuperMap.Geometry.Point(district.center.x, district.center.y);
            var feature = new SuperMap.Feature.Vector(geo, {});
            feature.style = {
                pointRadius: 30,
                externalGraphic: BaseObject.path + "/styles/css_map/red.gif",
                name: "marker"
            };
            return feature;
        },


        showInfoPopup: function (e,xy) {
            if (this.tmpfeature)
                this.hideInfoPopup(this.tmpfeature);

            this.hideInfoPopup(e);
            this.tmpfeature = e;
            var id = e.id;
            this._changeStyle(id, "show");
                var contentHTML = "<div style='overflow:hidden;width:100%; border-style: solid; white-space: nowrap; z-index: 9999999;transition: left 0.4s cubic-bezier(0.23, 1, 0.32, 1), top 0.4s cubic-bezier(0.23, 1, 0.32, 1); background-color: rgba(50, 50, 50, 0.701961);border-width: 0px;border-color: rgb(51, 51, 51); border-radius: 4px;color: rgb(255, 255, 255);font-style: normal;font-variant: normal;font-weight: normal; font-stretch: normal;font-size: 14px;font-family: \"Microsoft YaHei\"; line-height:21px;padding: 5px;'>";
                contentHTML += "<strong>" + e.attributes.name + "</strong>";
                contentHTML += "<br><hr style='margin: 3px'>";
                var count = 0;
                var units = [];
                var targetData = e.targetData;
                if (targetData.unit && targetData.unit.NOTE)
                     units = targetData.unit.NOTE.split(",");
              
                var len = 0;
                var content = "";
                for (var i = 0; i < targetData.headerCodes.length; i++) {
                    var unit = units.length > 2 ? units[i % 2] : units[0];
                    var val = Number(e.attributes[targetData.headerCodes[i].code]);
                    var str = targetData.headerCodes[i].name + ":" + val + "(" + unit + ")" + "\n";
                    var l = str.replace(/[^\x00-\xff]/g, "01").length+5;
                    if (len < l);
                    len = l;

                    count += val;
                    contentHTML += str+"<br/>"
                }
                contentHTML += "</div>";
              
                // 弹出框大小
                var infowinSize = (SuperMap.Browser.name == "firefox") ? new SuperMap.Size(len * 8, 105) : new SuperMap.Size(len * 8, 90);
            // 弹出窗地理位置
           
                var lonLat = this.globalMap.mapObject.getLonLatFromPixel(this.globalMap.infowinPosition);
                if (xy) lonLat = xy;
                this.infowin = new SuperMap.Popup(
                        "infowin",
                        lonLat,
                        infowinSize,
                        contentHTML,
                        false,
                        false,
                        null);
                //this.infowin.setBackgroundColor("#fff");
                this.infowin.setOpacity(0.8);
                try {
                    if (this.infowin) this.globalMap.mapObject.removeAllPopup();

                } catch (e) {
                }
                this.infowin.setBackgroundColor("none");
                this.globalMap.mapObject.addPopup(this.infowin);
           
        },

        mouseover: function (id) {
            var tmpfeature = this.drawVector.getFeatureById(id);
            var pt = tmpfeature.geometry;
            var lonLat = new SuperMap.LonLat(pt.x, pt.y);
            this.showInfoPopup(tmpfeature, lonLat);
            this.globalMap.mapObject.panTo(lonLat);
        },

        mouseout: function (id) {
            var feature = this.drawVector.getFeatureById(id);
            this.hideInfoPopup(feature);
        },

        hideInfoPopup: function (e) {
            if (this.infowin) {
                try {
                    this.globalMap.mapObject.removeAllPopup();
                    if (e)
                        this._changeStyle(e.id, "hide");
                }
                catch (e) {
                    alert(e.message);
                }
            }
        },


        msum: function (data, fields) {
            var sumData = [];

            $.each(data, function (index, item) {
                var count = 0;
                for (var i = 0; i < fields.length; i++) {
                    var field = fields[i];
                    count += Number(item[field.code]);
                }
                sumData.push(count.toFixed(2));
            });
            function compare(num1, num2) {
                return num1 - num2;
            }
            sumData.sort(compare);

            return sumData;
        },



        initStyle: function (data,type) {
            this.symbolArray = [];
            this.resStyleEnumValues = [];
            //var statusValue = value["0000"];
            var colors = [];
            colors.push("#0072e3");
            colors.push("#0072e3");
            colors.push("#0072e3");
            colors.push("#0072e3");
            colors.push("#0072e3");
            if (type == "setting") {
                var rangeData = [];

                var compare = function (obj1, obj2) {
                    var val1 = obj1.VALUE1;
                    var val2 = obj2.VALUE2;
                    if (val1 < val2) {
                        return -1;
                    } else if (val1 > val2) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
                data.sort(compare);
                 
                var maxValue = data[data.length - 1].VALUE2;
                var minValue = data[0].VALUE2;

                for (var i = 0; i < data.length; i++) {
                    item = {}
                    item.rangeValue1 = data[i].VALUE1;
                    item.rangeValue2 = data[i].VALUE2;
                    item.color = colors[i];
                    item.radius = Number(data[i].VALUE2) / (maxValue - minValue) * 25;
                    item.name = data[i].LABEL;
                    rangeData.push(item);
                }
                this.resStyleEnumValues = rangeData;
            }
            else {
                var config = { maxValue: data[data.length - 1], minValue: data[0], rangeCount: 5, colors: colors };
                //分段数
                if (this.symbolArray == null || this.symbolArray.length == 0) {
                    this.createRangeStyles(config);
                }
            }
            this.createStyle();
        },

        getStyle: function (statusValue) {
            for (var index = 0; index < this.symbolArray.length; index++) {
                var item = this.symbolArray[index];
                var config = item.config;
                if (Number(config.rangeValue1) <= Number(statusValue) && Number(statusValue) < Number(config.rangeValue2)) {
                    var cloneStyle = this.clone(item.style);
                    cloneStyle.config = config;
                    return cloneStyle;
                }
            }
        },

        
        clone:function (source) {
            var result = {};
            for (var key in source) {
                if( source[key] !== 'object')    result[key]=source[key];
            }
            return result;
        },

        createRangeStyles: function (config) {
            var rangeCount = config.rangeCount;
            var maxValue = config.maxValue;
            var minValue = config.minValue;
            var colors = config.colors;

            var len = 0;
            var i = 0;

            len = Number((maxValue - minValue) / (rangeCount));
            var rangeData = [];
            var rangeValue1 = 0;
            var rangeValue2 = 0;
            var count = rangeCount;


            while (i < rangeCount) {
                var item = null;
                if (count - 1 > i) {
                    item = {};
                    item.rangeValue1 = parseInt(this.convertValue(len * i));
                    item.rangeValue2 = parseInt(this.convertValue(len * (i + 1)));
                    item.name = item.rangeValue1 + "-" + item.rangeValue2;
                    item.radius = item.rangeValue2 / (maxValue - minValue) * 25;
                    item.color = colors[i];
                    rangeData.push(item);
                }
                else {
                    item = {}
                    item.rangeValue1 = parseInt(this.convertValue(len * i));
                    item.rangeValue2 = this.convertValue(parseInt(maxValue),true);
                    item.maxLevel = true;
                    item.color = colors[i];
                    item.radius = parseInt(maxValue) / (maxValue - minValue) * 25;
                    item.name = item.rangeValue1 + "-" + item.rangeValue2;
                    rangeData.push(item);
                }
                i++;
            }

            this.resStyleEnumValues = rangeData;

            //this.createStyle();
        },
        convertValue: function (val, last) {
            val = parseInt(val);
            var str = val.toString().substring(0, 1);
            var zeroStr = "";
            for (var i = 0; i < val.toString().length - 1; i++)
                zeroStr += "0"
            if (last)
                str = Number(str) + 1;
            str += zeroStr;

            return str;
        },

        createStyle: function () {
            for (var index = 0; index < this.resStyleEnumValues.length; index++) {
                var styleConfig = this.resStyleEnumValues[index];

                var style = {
                    fontColor: '#FFFFFF',
                    strokeColor: "#FFFFFF",
                    strokeWidth: 1,
                    //strokeDashstyle: "dash",
                    fillOpacity: 1,
                    fontColor: "#FFF0F5",

                    fontWeight: "bold",
                    trokeOpacity: 1,
                    fillColor: styleConfig.color,
                    labelYOffset: 1,
                    pointRadius: styleConfig.radius
                };
                var item = { config: styleConfig, style: style };
                this.symbolArray.push(item);
            }
        },
        setLegendPosition: function (status) {
            this.positonStatus = status;

            if (this.legendWidget) {
                if (status == "close") {
                    this.legendWidget.css({ "left": 0, "bottom": 0 });
                }
                else {
                    this.legendWidget.css({ "left": 300, "bottom": 0 });
                }
            }
        },

        //初始化位置
        clear: function () {
            if (this.selectFeature) {
                this.selectFeature.deactivate();
                if (this.globalMap.mapObject.getControl(this.selectFeature.id))
                    this.globalMap.mapObject.removeControl(this.selectFeature);
            }
            if (this.drawVector) {
                this.drawVector.removeAllFeatures();
                if (this.globalMap.mapObject.getLayer(this.drawVector.id))
                    this.globalMap.mapObject.removeLayer(this.drawVector);
            }
            if (this.legendWidget)
                this.legendWidget.remove();
        },
        CLASS_NAME: "BaseObject.DengJiFuHao"
    });
    module.exports = BaseObject.DengJiFuHao;

});
 