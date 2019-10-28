define(function (require, exports, module) {
    BaseObject.DanZhiFuHao = BaseHelper.Class.create();
    BaseObject.DanZhiFuHao.prototype = BaseHelper.Class.inherit(BaseHelper.GUID, BaseHelper.EventListener, {

        initialize: function (globalMap) {
            this.ID = this.getGUID();
            this.title = "单值符号专题图";
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
                    var code = item.properties.XZQDM.substring(0, 2) + "0000";
                    var feature;
                    if (districtHashtable[code]) feature = districtHashtable[code];
                    else {
                        if (this.globalMap.districtHashtable[code]) {
                            feature = this.globalMap.districtHashtable[code];
                            feature.properties = {};
                            feature.properties.TOTAL = 0;
                            districtHashtable[code] = feature;
                            features.push(feature)
                        } else {
                            //alert("");
                        }
                    }
                    if (feature) {
                        feature.children.push(item);
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
          
 
            this._addToMap(features, headerCodes, configData)
            //this.showLegend(data);
        },

        _addToMap: function (features, headerCodes, configData)
        {
            var isDefault = configData.isDefault || false;
            var isZoom = configData.isZoom || false;
            var isConvert = configData.isConvert || false;
            var thisCallBack = this;
            var map = this.globalMap.mapHandler.mapObject;

            this.themeLayer = L.geoJSON(features, {
                pointToLayer: function (feature, latlng) {
                    var latlng = L.latLng(feature.geometry.coordinates[1], feature.geometry.coordinates[0]);
                    var style = "";
                    if (configData.statusField)
                    {
                        style = thisCallBack.getCustomStyle(feature.properties[configData.statusField], configData.styleList);
                    }
                    return marker = L.marker(latlng, {
                        icon:style 
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

        getCustomStyle:function(statusValue,styleList)
        {
            for (var i = 0; i < styleList.length; i++)
            {
                var item = styleList[i];

                if (item.statusValue == statusValue)
                    return item.style;
            }
        },

        _getHeaderCodes: function (headerData) {
            var headerCodes = [];
            for (var index = 0; index < headerData.length; index++) {
                var item = headerData[index];
                if (item.STATS_FILED) {
                    headerCodes.push({
                        code: item.ITEM_CODE,
                        name: item.ITEM_NAME
                    })
                }
            }
            return headerCodes
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
 
        

        showLegend: function (data) {
            if (this.legendWidget)
                this.legendWidget.remove();

            var title = data.title || "单值专题图例";
            title += data.target != undefined ? "/" + data.target.NOTE : "";

            var html = "<div style=\" border-bottom:1px solid #ccc\">" + title + "</div>";
            html += "<div style=\"text-align:left;margin-top:5px;\">";
            for (var index = 0; index < this.symbolArray.length; index++) {
                var item = this.symbolArray[index];
                html += "<div class='lenged-inline'><div  class='left' style=' background-color:" + item.config.color + "' ></div><div class='right'>" + item.config.name + "</div></div>";
            }

            var height = 52 + 20 * this.symbolArray.length;

            //html += "<div class='lenged-inline' style='color:#ccc;font-size:13px'>来源:农业部农药检定所</div>";
            html += "</div>";
            var div = document.createElement("div");
            div.id = "component_" + this.getGUID();
            div.className = "mapviewer-widget mapviewer-clearfix";
            div.style.cssText = "border:1px solid #ccc; font-size:13px;text-align:center;position:absolute;z-index:10000;width:150px; height:" + height + "px;";
            $(div).append(html);
            this.dispathEvent("showLegend", {
                html: $(div),
                data: data
            })
            //$(this.globalMap.viewerContainer).append($(div));
            //var id = "legendWidget" + this.ID;
            //this.legendWidget = $("#" + div.id);

            //this.legendWidget.css({ "top": $(this.globalMap.viewerContainer).height() - height - 8, "bottom": 1 });
            ////            this.legendWidget.mouseover(function () {
            ////                $(this).css("opacity", 0.92);
            ////            });
            ////            this.legendWidget.mouseout(function () {
            ////                $(this).css("opacity", 0.7);
            ////            });
            //this.setLegendPosition(this.positonStatus);
        },

        initStyle: function (data, type) {
            
            var colors = [];
            colors.push("#313695");
            colors.push("#4575b4");
            colors.push("#74add1");
            colors.push("#abd9e9");
            colors.push("#e0f3f8");
            colors.push("#ffffbf");
            colors.push("#fee090");
            colors.push("#fdae61");
            colors.push("#f46d43");
            colors.push("#d73027");
            colors.push("#a50026");

            if (type == "setting") {
                var rangeData = [];
                for (var i = 0; i < data.length; i++) {
                    item = {}
                    items.statusValue = data[i].STATUS_VALUE;
                    item.color = colors[i];
                    item.name = data[i].LABEL;
                    rangeData.push(item);
                }
                this.resStyleEnumValues = rangeData;
            }

            this.createStyle();
        },

        getStyle: function (statusValue) {
             return style=this.symbolArray[statusValue];
        },

   
        createStyle: function () {
            
        },

        _defaultIconCreateFunction: function (e) {
           
            var divIcon = new L.DivIcon({
                shadowUrl: 'leaf-shadow.png',
                iconSize: [38, 95],
                shadowSize: [50, 64],
                iconAnchor: [22, 94],
                shadowAnchor: [4, 62],
                popupAnchor: [-3, -76]
            });

            return divIcon;
        },
  
        //初始化位置
        clear: function () {
            if (this.themeLayer) {
                this.themeLayer.remove();
                if (this.globalMap.mapHandler.mapObject.hasLayer(this.themeLayer)) this.globalMap.mapHandler.mapObject.removeLayer(this.themeLayer)
            }
        },
        CLASS_NAME: "BaseObject.DanZhiFuHao"
    });
    module.exports = BaseObject.DanZhiFuHao;

});