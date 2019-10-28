define(function (require, exports, module) {
    BaseObject.DanZhiTheme = BaseHelper.Class.create();
    BaseObject.DanZhiTheme.prototype = BaseHelper.Class.inherit(BaseHelper.GUID, BaseHelper.EventListener, {

        initialize: function (globalMap) {
            this.ID = this.getGUID();
            this.title = "单值专题图";
            this.globalMap = globalMap;
            this.targetFeature;
            if (globalMap) {
                var thisCallBack = this;
                this.globalMap.addEventListener("clearAll",
                function () {
                    thisCallBack.clear()
                });
                this.globalMap.addEventListener("changedMapCompleted",
                function () {
                    thisCallBack.active()
                })
                this.polygonStyle = {};
                this.polygonStyle["normal"] = {
                    weight: 3,
                    color: '#1874CD',
                    dashArray: '',
                    fillOpacity: 0.5
                };
                this.highlightStyle = {
                    weight: 2,
                    color: '#ff0000',
                    fillColor: '#f03',
                    fillOpacity: 0.2,
                    dashArray: ''
                };
            }
        },
        init: function (globalMap) {
            this.globalMap = globalMap;
        },

        active: function () {
            if (this.data) {
                this.show(this.data);
            }
        },

        show: function (data) {

            this.clear();

            if (data.configData && data.configData.NOTE) units = data.configData.NOTE.split(",");
            var headerData = data.headerData;
            var resultData = data.resultData;
            var configData = data.configData || {};
            var headerCodes = this._getHeaderCodes(headerData);
            var features = [];
            var districtHashtable = {};
            var thisCallBack = this;

            if (configData.showMethod == 0) {
                for (var index = 0; index < resultData.length; index++) {
                    var item = resultData[index];
                    var code = item.properties.XZQDM;
                    var feature;
                    if (districtHashtable[code]) feature = districtHashtable[code];
                    else {
                        if (this.globalMap.districtHashtable[code]) {
                            feature = this.globalMap.districtHashtable[code];
                            feature.properties = {};
                            for (var i = 0; i < headerCodes.length; i++)
                                feature.properties[headerCodes[i].code] = item[headerCodes[i].code];
                            districtHashtable[code] = feature;
                            features.push(feature)
                        } 
                    }
                }
            } else if (configData.showMethod == 1) {
                $.each(resultData,
                function (index, item) {
                    var code = item.properties.XZQDM.substring(0, 2) + "0000";
                    if (thisCallBack.globalMap.districtHashtable[code]) {
                        var cloneObj = thisCallBack.globalMap.clone(thisCallBack.globalMap.districtHashtable[code]);
                        feature = thisCallBack._createPointGeoJson(cloneObj, item.properties);
                        features.push(feature)
                    }
                })
            } else {
                $.each(resultData,
                function (index, item) {
                    features.push(item);
                    item.name = item.properties[configData.labelField];
                })
            }
            
            if (configData.RANGE_VALUES) {
                this.initStyle(configData.RANGE_VALUES, "setting");
            } else {
                //初始化分段样式
                var sumData = this.msum(resultData, headerCodes);
                this.initStyle(sumData);
            }
 
            this._addToMap(features, headerCodes, configData)
            this.showLegend(data);
        },

        _addToMap: function (features, headerCodes, configData)
        {
            var isDefault = configData.isDefault || false;
            var isZoom = configData.isZoom || false;
            var isConvert = configData.isConvert || false;
            var thisCallBack = this;
            var map = this.globalMap.mapHandler.mapObject;

            this.themeLayer = L.geoJSON(features, {
                style: function (feature) {
                    var total = thisCallBack._getTotalValue(headerCodes, feature)
                    return thisCallBack.getStyle(total);
                },
                onEachFeature: function (feature, layer) {
                    feature.configData = configData;
                    thisCallBack.onEachFeature(feature, layer, this);

                    if (configData.labelField) {
                        layer.on("mouseover",
                        function (e) {
                            var html = thisCallBack._getTooltipHtml(headerCodes, e.target.feature);
                            layer.bindTooltip(html, {
                                permanent: true,
                                direction: "right",
                                className: 'tooltip'
                            }).openTooltip()
                        });
                        layer.on("mouseout",
                        function (e) {
                            layer.closeTooltip()
                        });
                    }
                }
            });
            map.addLayer(this.themeLayer);
            if (isZoom) {
                if (this.themeLayer != null && features.length != 0) {
                    if (features.length == 1) {
                        var center = this.themeLayer.getBounds().getCenter();
                        this.globalMap.setView(center, 10);
                    }
                    else
                        this.globalMap.flyToBounds(this.themeLayer.getBounds());
                }
            }
        },

        _getHeaderCodes: function (headerData) {
            var headerCodes = [];
            for (var index = 0; index < headerData.length; index++) {
                var item = headerData[index];
                if (item.STATS_FIELD) {
                    headerCodes.push({
                        code: item.ITEM_CODE,
                        name: item.ITEM_NAME
                    })
                }
            }
            return headerCodes
        },

        _getTotalValue: function (headerCodes, feature) {
            var count = 0;
            for (var index = 0; index < headerCodes.length; index++) {
                count += Number(feature.properties[headerCodes[index].code])
            }
            return count
        },

        _getTooltipHtml: function (headerCodes, feature) {
            var innerHtml = "<div><strong>" + feature.name + "</strong>";
            innerHtml += "<br><hr style='margin: 3px'>";
            for (var index = 0; index < headerCodes.length; index++) {
                innerHtml += headerCodes[index].name + ":" + Number(feature.properties[headerCodes[index].code]);
                innerHtml += "<br>"
            }
            innerHtml += "</div>";
            return innerHtml
        },

        onEachFeature: function (target, layer, geojson) {
            var thisCallBack = this;

            layer.on({
                mouseover: highlightFeature,
                mouseout: resetHighlight,
                click: zoomToFeature
            });
          
            function highlightFeature(e) {
                var layer = e.target;
                layer.feature.status = "highlight";
                layer.setStyle(thisCallBack.highlightStyle);
                if (!L.Browser.ie && !L.Browser.opera && !L.Browser.edge) {
                    layer.bringToFront()
                }
            }
            function resetHighlight(e) {
                thisCallBack.themeLayer.resetStyle(e.target)
            }
            function zoomToFeature(e) {
                var map = thisCallBack.globalMap.mapHandler.mapObject;
                //L.polygon(e.target.getLatLngs()[0], {}).addTo(map);
                thisCallBack.globalMap.fitBounds(e.target.getBounds());
                thisCallBack.dispathEvent("clickFeature", e.target.feature);
            }
        },
  
        msum: function (data, fields) {
            var sumData = [];

            $.each(data, function (index, item) {
                var count = 0;
                for (var i = 0; i < fields.length; i++) {
                    var field = fields[i];
                    if (item.properties[field.code]) count += Number(item.properties[field.code]);
                }
                sumData.push(count.toFixed(2));
            });

            function compare(num1, num2) {
                return num1 - num2;
            }
            sumData.sort(compare);

            return sumData;
        },

        showLegend: function (data) {
            if (this.legendWidget)
                this.legendWidget.remove();

            var title = data.title || "单值专题图例";
            title += data.target != undefined ? "/" + data.target.NOTE : "";

            var html = "<div style=\" border-bottom:1px solid  rgba(5, 48, 68, 0.2);height:20px;margin:2px\">" + title + "</div>";
            html += "<div style=\"text-align:left;margin-top:5px;\">";
            html += "<table><tr>";
            for (var index = 0; index < this.symbolArray.length; index++) {
                var item = this.symbolArray[index];
                html += "<td>";
                html += "<div class='lenged-inline' style='min-width:40px;margin:8px'><div  class='left' style='width:16px;height:16px ;background-color:" + item.config.color + "' ></div><div class='right'>" + item.config.name + "</div></div>";
                html += "</td>";
            }
            html += "</table></tr>";
            //var height = 52 + 20 * this.symbolArray.length;
            var height =70;
            //html += "<div class='lenged-inline' style='color:#ccc;font-size:13px'>来源:农业部农药检定所</div>";
            html += "</div>";
            var div = document.createElement("div");
            div.id = "component_" + this.getGUID();
            div.className = "mapviewer-widget mapviewer-clearfix";
            div.style.cssText = "border:1px solid #ddd; background:rgba(5, 48, 68, 0.2);font-size:13px;text-align:center;position:absolute;z-index:10000;min-width:200px; height:" + height + "px;";
            $(div).append(html);
            this.dispathEvent("showLegend", {
                html: $(div),
                data: data
            })
            $(this.globalMap.viewerContainer).append($(div));
            var id = "legendWidget" + this.ID;
            this.legendWidget = $("#" + div.id);

            this.legendWidget.css({ "left": $(this.globalMap.viewerContainer).width() / 2 - this.legendWidget.width()/2, "top": 65 });
            //            this.legendWidget.mouseover(function () {
            //                $(this).css("opacity", 0.92);
            //            });
            //            this.legendWidget.mouseout(function () {
            //                $(this).css("opacity", 0.7);
            //            });
            //this.setLegendPosition(this.positonStatus);
        },

        initStyle: function (data, type) {
            this.symbolArray = [];
            this.resStyleEnumValues = [];
            var rangeCount =data.rangeCount||5;
            var colors = [];
           
            colors.push("#fee090");
            colors.push("#fdae61");
            colors.push("#f46d43");
            colors.push("#d73027");
            colors.push("#a50026");
            colors.push("#313695");
            colors.push("#4575b4");
            colors.push("#74add1");
            colors.push("#abd9e9");
            colors.push("#e0f3f8");
            colors.push("#ffffbf");

            if (type == "setting") {
                var rangeData = [];
                for (var i = 0; i < data.length; i++) {
                    item = {}
                    item.rangeValue1 = data[i].VALUE1;
                    item.rangeValue2 = data[i].VALUE2;
                    item.color = colors[i];
                    item.name = data[i].LABEL;
                    rangeData.push(item);
                }
                this.resStyleEnumValues = rangeData;
            } else {
                var config = {
                    maxValue: data[data.length - 1],
                    minValue: data[0],
                    rangeCount: rangeCount,
                    colors: colors
                };
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
                if (Number(config.rangeValue1) <= Number(statusValue) && Number(statusValue) <= Number(config.rangeValue2)) {
                    return item.style;
                }
            }
        },

        createRangeStyles: function (config) {

            var rangeCount = config.rangeCount||5;
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
                    item.rangeValue1 = parseInt(len * i);
                    item.rangeValue2 = parseInt(len * (i + 1));
                    item.name = item.rangeValue1 + "-" + item.rangeValue2;
                    item.radius = item.rangeValue2 / (maxValue - minValue) * 18;
                    item.color = colors[i];
                    rangeData.push(item);
                } else {
                    item = {}
                    item.rangeValue1 = parseInt(len * i);
                    item.rangeValue2 = parseInt(maxValue) + 1;
                    item.color = colors[i];
                    item.radius = item.rangeValue2 / (maxValue - minValue) * 18;
                    item.name = parseInt(len * i) + "-" + item.rangeValue2;
                    rangeData.push(item);
                }
                i++;
            }

            this.resStyleEnumValues = rangeData;
        },

        getStyle: function (statusValue) {
            for (var index = 0; index < this.symbolArray.length; index++) {
                var item = this.symbolArray[index];
                var config = item.config;
                if (Number(config.rangeValue1) <= Number(statusValue) && Number(statusValue) < Number(config.rangeValue2)) {
                    return item.style;
                }
            }
            return "";
        },

        createStyle: function () {
            for (var index = 0; index < this.resStyleEnumValues.length; index++) {
                var styleConfig = this.resStyleEnumValues[index];

                var style = 
                {
                    weight: 1,
                    fillColor: styleConfig.color,
                    fillOpacity: 0.7,
                    color: 'white',
                    dashArray: '1'
                }

                var item = {
                    config: styleConfig,
                    style: style
                };
                this.symbolArray.push(item);
            }
        },
  
        //初始化位置
        clear: function () {
            if (this.themeLayer) {
               
                if (this.globalMap.mapHandler.mapObject.hasLayer(this.themeLayer)) this.globalMap.mapHandler.mapObject.removeLayer(this.themeLayer);
                this.themeLayer.remove();
                this.themeLayer = null;
            }
            if (this.legendWidget)
                this.legendWidget.remove();
            this.legendWidget = null;
        },
        CLASS_NAME: "BaseObject.DanZhiTheme"
    });
    module.exports = BaseObject.DanZhiTheme;

});