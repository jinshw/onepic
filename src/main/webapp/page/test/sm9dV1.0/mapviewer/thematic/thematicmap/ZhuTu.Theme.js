define(function (require, exports, module) {
    BaseObject.ZhuTuTheme = BaseHelper.Class.create();
    BaseObject.ZhuTuTheme.prototype = BaseHelper.Class.inherit(BaseHelper.GUID, BaseHelper.EventListener, {

        initialize: function (globalMap) {
            this.ID = this.getGUID();
            this.title = "柱状专题专题图";
            this.globalMap = globalMap;

            if (globalMap) {
                var thisCallBack = this;
                this.globalMap.addEventListener("clearAll", function () {
                    thisCallBack.clear();
                });
                this.globalMap.addEventListener("changedMapCompleted", function () {
                    thisCallBack.active();
                });
                //init(globalMap);
            }
        },
        active: function () {
            if (this.data)
                this.show(this.data);
        },
        init: function (globalMap) {
            this.globalMap = globalMap;
        },

        showLegend: function (data) {
            if (this.legendWidget)
                this.legendWidget.remove();
            title = data.title || "柱状专题图例";
            var units;
            if (data.target && data.target.NOTE)
                units = data.target.NOTE.split(",");

            var html = "<div style=\" border-bottom:1px solid #ccc\">" + title + "</div>";
            html += "<div style=\"text-align:left;margin-top:5px;\">";
            for (var index = 0; index < data.headerCodes.length; index++) {
                var item = data.headerCodes[index];
                var name = item.name;
                if (item.name.length > 5) {
                    name = item.name.substring(0, 5);
                }
                var unit = units[index] || units[0];
                name += "(" + unit + ")";

                html += "<div class='lenged-inline'><div  class='left' style=' background-color:" + this.colors[index] + "' ></div><div class='right'>" + name + "</div></div>";
            }

            var height = 40 + 20 * data.headerCodes.length;

            //html += "<div class='lenged-inline' style='color:#ccc;font-size:13px'>来源:农业部农药检定所</div>";
            html += "</div>";
            var div = document.createElement("div");
            div.id = "component_" + this.getGUID();
            div.className = "mapviewer-widget mapviewer-clearfix";
            div.style.cssText = "border:1px solid #CCC; font-size:13px;text-align:center;position:absolute;z-index:10000;width:160px; height:" + height + "px;";
            $(div).append(html);
            this.dispathEvent("showLegend", { html: $(div), data: data })
            //$(this.globalMap.viewerContainer).append($(div));
            //var id = "legendWidget" + this.ID;
            //this.legendWidget = $("#" + div.id);
            //this.legendWidget.css({ "top": $(this.globalMap.viewerContainer).height() - height - 8, "bottom": 0 });

            //this.setLegendPosition(this.positonStatus);
        },

        mouseover: function (id) {
            var tmpfeature = this.themeLayer.getFeatureById(id);
            var pt = tmpfeature.geometry;
            var lonLat = new SuperMap.LonLat(pt.x, pt.y);
            this.showInfoPopup(tmpfeature, lonLat);
            this.globalMap.mapObject.panTo(lonLat);
        },

        mouseout: function (id) {
            var feature = this.themeLayer.getFeatureById(id);
            this.hideInfoPopup(feature);
        },

        show: function (data) {

            this.clear();
            this.data = data;

            this.colors = ["#00FF00", "#00CCFF", "#00FF66", "#CCFF00", "#FF9900", "#FF9900", "#A2945E", "#A2945E", "#669985"];
            var units;
            if (data.target && data.target.NOTE)
                units = data.target.NOTE.split(",");

            var headerData = data.headerData;
            var resultData = data.resultData;
            this.positonStatus = data.positonStatus;
            var headerCodes = [];
            for (var index = 0; index < headerData.length; index++) {
                var item = headerData[index];
                if (item.HEADER_FILED) {

                    headerCodes.push({ code: item.ITEM_CODE, name: item.ITEM_NAME });
                }
            }


            var sumData = this.msum(resultData, headerCodes);
            this.initLayer(headerCodes, sumData);
            var features = [];

            for (var index = 0; index < resultData.length; index++) {
                var item = resultData[index];
                var district = {};
                if (item.center)
                    district.center = item.center.clone();
                else
                    var district = this.globalMap.districtHashtable[item.CODE] || this.globalMap.districtHashtableN[item.LABEL]

                if (district && district.center) {
                    var feature = new SuperMap.Feature.Vector(district.center);
                    var name = item.LABEL + "\n";

                    for (var i = 0; i < headerCodes.length; i++) {
                        name += headerCodes[i].name + ":" + item[headerCodes[i].code] + "\n";
                        if (units)
                            headerCodes[i].unit = units[i] || units[0];
                    }
                    item.CNNAMES = headerCodes;


                    var fea = new SuperMap.Feature.Vector(district.center, item);
                    fea.style = {};
                    fea.id = item.SMID;
                    features.push(fea);
                    fea.style.label = item.LABEL;
                }
            }
            this.themeLayer.addFeatures(features);
            data.headerCodes = headerCodes;

            this.showLegend(data);
        },

        msum: function (data, fields) {
            var sumData = [];

            $.each(data, function (index, item) {
                // var count = 0;
                for (var i = 0; i < fields.length; i++) {
                    var field = fields[i];
                    var count = Number(item[field.code]);
                    sumData.push(count);
                }

            });
            function compare(num1, num2) {
                return num1 - num2;
            }
            sumData.sort(compare);

            return sumData;
        },

        initLayer: function (data, values) {
            // 创建一个饼状图（Pie）统计专题图图层
            this.themeLayer = new SuperMap.Layer.Graph("ThemeLayer", "Bar");
            this.globalMap.mapObject.addLayer(this.themeLayer);
            this.themeLayer.themeFields = [];
            // 指定用于专题图制作的属性字段
            for (var i = 0; i < data.length; i++) {
                this.themeLayer.themeFields.push(data[i].code);
            }
            var maxValue = values[values.length - 1];
            var setp = 0;
            if (maxValue > 0 && maxValue < 20) {
                setp = 3;
            }

            else if (maxValue < 50 && maxValue > 20) {
                setp = 10;
            }
            else if (maxValue < 100 && maxValue > 50) {
                setp = 20;
            }
            else if (maxValue < 500 && maxValue > 100) {
                setp = 100;
            } else if (maxValue < 1000 && maxValue > 500) {
                setp = 200;
            }
            else if (maxValue < 5000 && maxValue > 1000) {
                setp = 1000;
            } else if (maxValue < 10000 && maxValue > 5000) {
                setp = 2000;
            } else {
                setp = 10000;
            }

            var xaxisData = [];
            var yaxisData = [];

            for (var index = 0; index < data.length; index++) {
                if (data.length > 3)
                    xaxisData.push("");
                else
                    xaxisData.push(data[index].name);
                //xaxisData.push(data[index].code);
            }
            for (var index = 4; index >= 0; index--) {
                var value = setp * index;
                yaxisData.push(value);
                //xaxisData.push(data[index].code);
            }


            var width = 20;
            if (xaxisData.length == 1) {
                width = xaxisData.length * 30;
            }

            else if (xaxisData.length == 2)
                width = xaxisData.length * 25;
            else if (xaxisData.length >= 3)
                width = xaxisData.length * 18;

            var blankWidth = 30;
            if (xaxisData.length == 1) {
                blankWidth = 2
                blankWidth = blankWidth / xaxisData.length;
            }
            else if (xaxisData.length == 2) {
                blankWidth = 2
                blankWidth = blankWidth / xaxisData.length;
            }
            else if (xaxisData.length >= 3) {
                blankWidth = 2
                blankWidth = blankWidth / xaxisData.length;
            }
            //this.themeLayer.isOverLay = false;
            // 柱状图表配置
            this.themeLayer.chartsSetting = {
                // width，height，codomain 分别表示图表宽、高、数据值域；此三项参数为必设参数
                width: width,
                height: 100,
                //codomain: [0, 999999999], // 允许图表展示的值域范围，此范围外的数据将不制作图表
                codomain: [0, maxValue + 1], // 允许图表展示的值域范围，此范围外的数据将不制作图表
                barStyle: { fillOpacity: 0.8 }, // 柱状图中柱条的（表示字段值的图形）样式
                barHoverStyle: { fillOpacity: 1 }, // 柱条 hover 样式
                xShapeBlank: [blankWidth, blankWidth, blankWidth], // 水平方向上的空白间距参数
                axisYTick: 0, // y 轴刻度数量
                axisYLabels: yaxisData, // y 轴标签内容
                axisXLabels: xaxisData, // x 轴标签内容
                backgroundStyle: { fillColor: "#CCE8CF", fillOpacity: 0.0 }, // 背景样式
                sectorStyle: { fillOpacity: 0.5 },
                backgroundRadius: [5, 5, 5, 5], // 背景框圆角参数
                XOffset: 0,
                YOffset: -20,
                //阴影开关 默认是打开
                showShadow: false,
                useAxis: false,
                //阴影样式
                barShadowStyle: { shadowBlur: 2, shadowOffsetX: 2, shadowOffsetY: 2, shadowColor: "rgba(100,100,100,0.8)" },
                //按字段设置柱条样式[渐变开始颜色,渐变终止颜色] 与 themeLayer.themeFields 中的字段一一对应）
                //barLinearGradient: [["#00FF00", "#00CD00"], ["#00CCFF", "#5E87A2"], ["#00FF66", "#669985"], ["#CCFF00", "#94A25E"], ["#FF9900", "#A2945E"], ["#FF9900", "#A2945E"], ["#FF9900", "#A2945E"], ["#FF9900", "#A2945E"], ["#FF9900", "#A2945E"]]
            };


            this.themeLayer.overlayWeightField = data[0].code;
            this.colors
            this.themeLayer.chartsSetting.barLinearGradient = [];
            for (var index = 0; index < this.colors.length; index++) {
                this.themeLayer.chartsSetting.barLinearGradient.push([this.colors[index], this.colors[index]]);
            }
            var thisCallBack = this;
            // 注册专题图 mousemove, mouseout事件(注意：专题图图层对象自带 on 函数，没有 events 对象)
            this.themeLayer.on("mousemove", function (e) { thisCallBack.showInfoPopup(e) });
            this.themeLayer.on("mouseout", function (e) { thisCallBack.showInfoPopup(e) });

        },

        showInfoPopup: function (e, xy) {
            if (this.tmpfeature)
                this.hideInfoPopup(this.tmpfeature);

            this.hideInfoPopup(e);
            this.tmpfeature = e;
            // e.target 是图形对象，即数据的可视化对象，饼状图中是扇形。
            // 图形对象的 refDataID 属性是数据（feature）的 id 属性，它指明图形对象是由那个数据制作而来;
            // 图形对象的 dataInfo 属性是图形对象表示的具体数据，他有两个属性，field 和 value;
            if (e.target && e.target.refDataID && e.target.dataInfo) {
                this.hideInfoPopup();
                // 获取图形对应的数据 (feature)
                var fea = this.themeLayer.getFeatureById(e.target.refDataID);

                var info = e.target.dataInfo;

                // 弹窗内容
                var contentHTML = "<div style=' border-style: solid; white-space: nowrap; z-index: 9999999;transition: left 0.4s cubic-bezier(0.23, 1, 0.32, 1), top 0.4s cubic-bezier(0.23, 1, 0.32, 1); background-color: rgba(50, 50, 50, 0.701961);border-width: 0px;border-color: rgb(51, 51, 51); border-radius: 4px;color: rgb(255, 255, 255);font-style: normal;font-variant: normal;font-weight: normal; font-stretch: normal;font-size: 14px;font-family: \"Microsoft YaHei\"; line-height:21px;padding: 5px;'>";
                contentHTML += "<strong>" + fea.attributes.LABEL + "</strong>";

                contentHTML += "<hr style='margin: 3px'>";

                var dataItem;
                for (var index = 0; index < fea.attributes.CNNAMES.length; index++) {
                    var item = fea.attributes.CNNAMES[index];
                    if (item.code == info.field)
                        dataItem = item;

                }

                contentHTML += dataItem.name + ":<strong>" + info.value + "(" + dataItem.unit + ")</strong>";

                contentHTML += "</div>";

                var str = dataItem.name + ":" + info.value + "(" + dataItem.unit + ")";
                var len = str.replace(/[^\x00-\xff]/g, "01").length;
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
                this.infowin.setBackgroundColor("none");
                if (this.infowin) this.globalMap.mapObject.removeAllPopup();
                this.globalMap.mapObject.addPopup(this.infowin);

            }
        },


        hideInfoPopup: function () {
            if (this.infowin) {
                try {
                    this.globalMap.mapObject.removeAllPopup();
                }
                catch (e) {
                    alert(e.message);
                }
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
            if (this.themeLayer) {
                this.themeLayer.clear();
                if (this.globalMap.mapObject.getLayer(this.themeLayer.id))
                    this.globalMap.mapObject.removeLayer(this.themeLayer);
            }
            if (this.legendWidget)
                this.legendWidget.remove();
        },
        CLASS_NAME: "BaseObject.ZhuTuTheme"
    });
    module.exports = BaseObject.ZhuTuTheme;

});
