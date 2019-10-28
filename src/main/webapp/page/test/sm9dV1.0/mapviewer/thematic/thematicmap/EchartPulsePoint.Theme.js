define(function (require, exports, module) {
    BaseObject.EchartPulsePoint = BaseHelper.Class.create();
    BaseObject.EchartPulsePoint.prototype = BaseHelper.Class.inherit(BaseHelper.GUID, BaseHelper.EventListener, {
        initialize: function (globalMap) {
            this.ID = this.getGUID();
            this.title = "Echart闪烁点专题图";
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
                    feature = thisCallBack._createPointGeoJson(item, item.properties);
                    features.push(feature);
                    feature.name = feature.properties[configData.labelField];
                })
            }
 
            if (configData.rangeValues) {
                this.initStyle(configData.rangeValues, "setting")
            } else {
                var sumData = this._sum(resultData, headerCodes);
                this.maxValue = sumData[sumData.length - 1];
                this.mixValue = sumData[0];
                this.initStyle(sumData);
            }
            this._addToMap(features, headerCodes, configData)
        },
        _addToMap: function (features, headerCodes, configData) {
            var thisCallBack = this;
            var map = this.globalMap.mapHandler.mapObject;
            var color = configData.color || "#ddb926";
            var topColor = configData.topColor || "#f4e925";
            var topNumber = configData.topNumber || parseInt(features.length * 0.5);
            var isZoom = configData.isZoom || false;
            option = {
                title: {
                    text: '闪烁专题',
                    subtext: 'data from PM25.in',
                    sublink: 'http://www.pm25.in',
                    left: 'center'
                },
                tooltip: {
                    trigger: 'item'
                },
                series: [{
                    name: 'ALL',
                    type: 'scatter',
                    coordinateSystem: 'leaflet',
                    data: features,
                    symbolSize: function (val, target) {
                        var value = thisCallBack._getTotalValue(headerCodes, target.data);
                        var percent = value / thisCallBack.maxValue;
                        if (percent < 0.1) {
                            percent = 0.1;
                        }
                        return percent * 40;
                    },
                    tooltip: {
                        trigger: 'item',
                        formatter: function (params) {
                            var html = thisCallBack._getTooltipHtml(headerCodes, params.data);
                            return html;
                        }
                    },
                    label: {
                        normal: {
                            formatter: '{b}',
                            position: 'right',
                            show: false
                        },
                        emphasis: {
                            show: true
                        }
                    },
                    itemStyle: {
                        normal: {
                            color: color
                        },
                    }
                },
                {
                    name: 'Top',
                    type: 'effectScatter',
                    coordinateSystem: 'leaflet',
                    data: features.sort(function (a, b) {
                        return thisCallBack._getTotalValue(headerCodes, b) - thisCallBack._getTotalValue(headerCodes, a);
                    }).slice(0, topNumber),
                    symbolSize: function (val, target) {
                        return thisCallBack._getTotalValue(headerCodes, target.data) / thisCallBack.maxValue * 40;
                    },
                    showEffectOn: 'render',
                    rippleEffect: {
                        brushType: 'stroke'
                    },
                    tooltip: {
                        trigger: 'item',
                        formatter: function (params) {
                            var html = thisCallBack._getTooltipHtml(headerCodes, params.data);
                            return html;
                        }
                    },
                    hoverAnimation: true,
                    label: {
                        normal: {
                            formatter: '{b}',
                            position: 'right',
                            show: false
                        }
                    },
                    itemStyle: {
                        normal: {
                            color: topColor,
                            shadowBlur: 10,
                            shadowColor: '#333'
                        }
                    },
                    zlevel: 1
                }]
            };
            this.themeLayer = L.supermap.echartsLayer(option).addTo(map);

            if (isZoom) {
                if (this.themeLayer != null && features.length != 0) {
                    if (features.length == 1) {
                        var center = this.themeLayer.getBounds().getCenter();
                        this.globalMap.setView(center, 10);
                    }
                    else {
                        var bounds = [];
                        for (var i = 0; i < features.length; i++)
                            bounds.push([features[i].value[1], features[i].value[0]]);
                         
                        this.globalMap.flyToBounds(bounds);
                    }
 
                }
            }
        },
        initStyle: function (data, type) {

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
                "value": this._getCoordinates(feature),
                "properties": properties
            }
        },
        _getCoordinates: function (feature) {
            var coordinates;
            if (feature.geometry.type == "Point") {
                coordinates= feature.geometry.coordinates;
            }
            else if (feature.geometry.type == "MultiPolygon") {
                coordinates = [feature.center.X,feature.center.Y];
            }
            return coordinates;
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
        _sum: function (data, fields) {
            var sumData = [];
            $.each(data,
            function (index, item) {
                for (var i = 0; i < fields.length; i++) {
                    var field = fields[i];
                    var count = Number(item.properties[field.code]) || 0;
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
                if (this.globalMap.mapHandler.mapObject.hasLayer(this.themeLayer)) this.globalMap.mapHandler.mapObject.removeLayer(this.themeLayer);
                this.themeLayer.remove();
                this.themeLayer = null;
            }
        },
        CLASS_NAME: "BaseObject.EchartPulsePoint"
    });
    module.exports = BaseObject.EchartPulsePoint
});