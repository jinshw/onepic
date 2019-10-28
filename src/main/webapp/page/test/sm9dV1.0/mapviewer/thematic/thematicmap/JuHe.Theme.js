define(function (require, exports, module) {
    BaseObject.JuHeTheme = BaseHelper.Class.create();
    BaseObject.JuHeTheme.prototype = BaseHelper.Class.inherit(BaseHelper.GUID, BaseHelper.EventListener, {
        initialize: function (globalMap) {
            this.ID = this.getGUID();
            this.title = "聚合专题图";
            this.globalMap = globalMap;
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
            }
        },
        active: function () {
            if (this.data) this.show(this.data)
        },
        init: function (globalMap) {
            this.globalMap = globalMap
        },
        showLegend: function (data) {
            if (this.legendWidget) this.legendWidget.remove();
            title = data.title || "柱状专题图例";
            var units;
            if (data.target && data.target.NOTE) units = data.target.NOTE.split(",");
            var html = "<div style=\" border-bottom:1px solid #ccc\">" + title + "</div>";
            html += "<div style=\"text-align:left;margin-top:5px;\">";
            for (var index = 0; index < data.headerCodes.length; index++) {
                var item = data.headerCodes[index];
                var name = item.name;
                if (item.name.length > 5) {
                    name = item.name.substring(0, 5)
                }
                var unit = units[index] || units[0];
                name += "(" + unit + ")";
                html += "<div class='lenged-inline'><div  class='left' style=' background-color:" + this.colors[index] + "' ></div><div class='right'>" + name + "</div></div>"
            }
            var height = 40 + 20 * data.headerCodes.length;
            html += "</div>";
            var div = document.createElement("div");
            div.id = "component_" + this.getGUID();
            div.className = "mapviewer-widget mapviewer-clearfix";
            div.style.cssText = "border:1px solid #CCC; font-size:13px;text-align:center;position:absolute;z-index:10000;width:160px; height:" + height + "px;";
            $(div).append(html);
            this.dispathEvent("showLegend", {
                html: $(div),
                data: data
            })
        },
        mouseover: function (id) {
            var tmpfeature = this.themeLayer.getFeatureById(id);
            var pt = tmpfeature.geometry;
            var lonLat = new SuperMap.LonLat(pt.x, pt.y);
            this.showInfoPopup(tmpfeature, lonLat);
            this.globalMap.mapObject.panTo(lonLat)
        },
        mouseout: function (id) {
            var feature = this.themeLayer.getFeatureById(id);
            this.hideInfoPopup(feature)
        },
        show: function (data) {
            this.clear();
            this.data = data;
            var units;
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
                    var code = item.properties.XZQDM.substring(0, 2) + "0000";
                    var feature;
                    if (districtHashtable[code]) feature = districtHashtable[code];
                    else {
                        if (this.globalMap.districtHashtable[code]) {
                            var cloneObj = this.globalMap.clone(this.globalMap.districtHashtable[code]);
                            feature = this._createPointGeoJson(cloneObj, item.properties);
                            feature.properties.TOTAL = 0;
                            districtHashtable[code] = feature;
                            features.push(feature)
                        }
                    }
                    if (feature) {
                        feature.children.push(item);
                        feature.properties.TOTAL++
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
            } else if (configData.showMethod == 2) {
                features = data.resultData
            } else {
                features = data.resultData;
                this.themeLayer = L.markerClusterGroup({
                    spiderfyOnMaxZoom: false,
                    showCoverageOnHover: false,
                    zoomToBoundsOnClick: false
                });
                features.map(function (feature) {
                    var latLng = L.CRS.EPSG3857.unproject(L.point(feature.geometry.coordinates));
                    this.themeLayer.addLayer(L.marker(latLng))
                });
                this.themeLayer.addTo(map);
                return
            }
            if (configData.rangeValues) {
                this.initStyle(configData.rangeValues, "setting")
            } else {
                var sumData = this._sum(resultData, headerCodes);
                this.initStyle(sumData)
            }
            this._addToMap(features, headerCodes, configData)
        },
        _addToMap: function (features, headerCodes, configData) {
            var thisCallBack = this;
            var map = this.globalMap.mapHandler.mapObject;
            this.themeLayer = L.geoJSON(features, {
                pointToLayer: function (feature, latlng) {
                    var latlng = L.latLng(feature.geometry.coordinates[1], feature.geometry.coordinates[0]);
                    return marker = L.marker(latlng, {
                        icon: thisCallBack._defaultIconCreateFunction({
                            count: thisCallBack._getTotalValue(headerCodes, feature)
                        })
                    })
                },
                onEachFeature: function (feature, layer) {
                    if (!feature.name) feature.name = feature.properties[configData.labelField];
                    layer.on("mouseover",
                    function (e) {
                        var html = thisCallBack._getTooltipHtml(headerCodes, e.target.feature);
                        layer.bindTooltip(html, {
                            permanent: true,
                            offset: [0, 0],
                            direction: "right",
                            className: 'tooltip',
                        }).openTooltip()
                    });
                    layer.on("mouseout",
                    function (e) {
                        layer.closeTooltip()
                    })
                }
            }).addTo(map)
        },
        initStyle: function (data, type) {
            this.symbolArray = [];
            this.resStyleEnumValues = [];
            var styleList = [];
            styleList.push("small");
            styleList.push("medium");
            styleList.push("large");

            if (type == "setting") {
                var rangeData = [];
                for (var i = 0; i < data.length; i++) {
                    item = {}
                    item.rangeValue1 = data[i].value1;
                    item.rangeValue2 = data[i].value2;
                    item.styleList = styleList[i];
                    item.name = data[i].label;
                    rangeData.push(item)
                }
                this.resStyleEnumValues = rangeData
            } else {
                var config = {
                    maxValue: data[data.length - 1],
                    minValue: data[0],
                    styleList:styleList,
                    rangeCount: 3
                };
                if (this.symbolArray == null || this.symbolArray.length == 0) {
                    this._createRangeStyles(config)
                }
            }
        },
        _createRangeStyles: function (config) {
            var rangeCount = config.rangeCount;
            var maxValue = config.maxValue;
            var minValue = config.minValue;
            var styleList = config.styleList;
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
                    item.style = styleList[i];
                    item.name = item.rangeValue1 + "-" + item.rangeValue2;
                    rangeData.push(item)
                } else {
                    item = {}
                    item.rangeValue1 = parseInt(len * i);
                    item.rangeValue2 = parseInt(maxValue) + 1;
                    item.style = styleList[i];
                    item.name = parseInt(len * i) + "-" + item.rangeValue2;
                    rangeData.push(item)
                }
                i++
            }
            this.resStyleEnumValues = rangeData
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
        _getTotalValue: function (headerCodes, feature) {
            var count = 0;
            for (var index = 0; index < headerCodes.length; index++) {
                count += Number(feature.properties[headerCodes[index].code])
            }
            return count
        },
        _createPointGeoJson: function (feature, properties) {
            return {
                "name": feature.name,
                "type": "Feature",
                "children": [],
                "geometry": {
                    "type": "Point",
                    "coordinates": [feature.center.X, feature.center.Y]
                },
                "properties": properties
            }
        },
        _defaultIconCreateFunction: function (e) {
            var resStyleEnumValues = this.resStyleEnumValues;

            var t = e.count,
            i = " marker-cluster-";
            return i += getStyle(t),
            new L.DivIcon({
                html: "<div><span>" + t + "</span></div>",
                className: "marker-cluster" + i,
                iconSize: new L.Point(40, 40)
            });
          
            function getStyle(statusValue) {
                for (var index = 0; index < resStyleEnumValues.length; index++) {
                    var item = resStyleEnumValues[index];
                    if (Number(item.rangeValue1) <= Number(statusValue) && Number(statusValue) <= Number(item.rangeValue2)) {
                        return item.style;
                    }
                }
            }
        },
        _getHeaderCodes: function (headerData) {
            var headerCodes = [];
            for (var index = 0; index < headerData.length; index++) {
                var item = headerData[index];
                if (item.HEADER_FILED) {
                    headerCodes.push({
                        code: item.ITEM_CODE,
                        name: item.ITEM_NAME
                    })
                }
            }
            return headerCodes
        },
        _sum: function (data, fields) {
            var sumData = [];
            $.each(data,
            function (index, item) {
                for (var i = 0; i < fields.length; i++) {
                    var field = fields[i];
                    var count = Number(item.properties[field.code])||0;
                    sumData.push(count)
                }
            });
            function compare(num1, num2) {
                return num1 - num2
            }
            sumData.sort(compare);
            return sumData
        },
        showInfoPopup: function (e, xy) { },
        clear: function () {
            if (this.themeLayer) {
                this.themeLayer.remove();
                if (this.globalMap.mapHandler.mapObject.hasLayer(this.themeLayer)) this.globalMap.mapHandler.mapObject.removeLayer(this.themeLayer)
            }
        },
        CLASS_NAME: "BaseObject.JuHeTheme"
    });
    module.exports = BaseObject.JuHeTheme
});