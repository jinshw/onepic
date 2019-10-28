define(function (require, exports, module) {
    BaseObject.BingTuTheme = BaseHelper.Class.create();
    BaseObject.BingTuTheme.prototype = BaseHelper.Class.inherit(BaseHelper.GUID, BaseHelper.EventListener, {

        initialize: function (globalMap) {
            this.ID = this.getGUID();
            this.title = "饼状专题专题图";
            this.globalMap = globalMap;
            this.positonStatus = "open";
            if (globalMap) {
                var thisCallBack = this;
                this.globalMap.addEventListener("clearAll", function () {
                    thisCallBack.clear();
                });
                this.globalMap.addEventListener("changedMapCompleted", function () {
                    //thisCallBack.active();
                });
                this.globalMap.addEventListener("mapZoomend",
                   function (e) {
                       thisCallBack.mapZoomendCompleted(e)
                   });
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

            title = data.title || "饼状专题图例";
            var html = "<div style=\" border-bottom:1px solid #ccc\">" + title + "</div>";
            html += "<div style=\"text-align:left;margin-top:5px;\">";
           
            var units;
            if (data.target && data.target.NOTE)
                units = data.target.NOTE.split(",");

            for (var index = 0; index < data.headerCodes.length; index++) {
                var item = data.headerCodes[index];
                var name = item.name;
                if (item.name.length > 5)
                    name = item.name.substring(0, 5);

                var unit = units[index] || units[0];
                name += "(" + unit + ")";
                html += "<div class='lenged-inline'><div  class='left' style=' background-color:" + this.colors[index] + "' ></div><div class='right'>" + name + "</div></div>";
            }

            var height = 40+ 20 * data.headerCodes.length;
            //html += "<div class='lenged-inline' style='color:#ccc;font-size:13px'>来源:农业部农药检定所</div>";
            html += "</div>";
            var div = document.createElement("div");
            div.id = "component_" + this.getGUID();
            div.className = "mapviewer-widget mapviewer-clearfix";
            div.style.cssText = "border:1px solid #ccc; font-size:13px;text-align:center;position:absolute;z-index:10000;width:150px; height:" + height + "px;";
            $(div).append(html);

            this.dispathEvent("showLegend", { html: $(div), data: data })

            //$(this.globalMap.viewerContainer).append($(div));
            //var id = "legendWidget" + this.ID;
            //this.legendWidget = $("#" + div.id);
            //this.legendWidget.css({ "top": $(this.globalMap.viewerContainer).height() - height - 8, "bottom": 0 });

            //this.setLegendPosition(this.positonStatus);

        },

        mapZoomendCompleted:function(e)
        {
          
        },
            

        show: function (data) {

            this.clear();
            this.data = data;
            this.colors = ['#FF4500', '#87cefa', '#da70d6', '#32cd32', '#6495ed',
                '#ff69b4', '#ba55d3', '#cd5c5c', '#ffa500', '#40e0d0',
                '#1e90ff', '#ff6347', '#7b68ee', '#00fa9a', '#ffd700',
                '#6699FF', '#ff6666', '#3cb371', '#b8860b', '#30e0e0'];

            var headerData = data.headerData;
            var resultData = data.resultData;
            var target = data.target;
            this.positonStatus = data.positonStatus;
            var headerCodes = [];
            for (var index = 0; index < headerData.length; index++) {
                var item = headerData[index];
                if (item.HEADER_FILED) {
                    headerCodes.push({ code: item.ITEM_CODE, name: item.ITEM_NAME });
                }
            }

            this.initLayer(headerCodes);
            var features = [];

            for (var index = 0; index < resultData.length; index++) {
                var item = resultData[index];
                var district = {};
                if (item.center)
                    district.center = item.center.clone();
                 else
                district = this.globalMap.districtHashtable[item.CODE];
                if (district && district.center) {
                    var feature = new SuperMap.Feature.Vector(district.center);
                    var name = item.LABEL + "\n";

                    for (var i = 0; i < headerCodes.length; i++) {
                        name += headerCodes[i].name + ":" + item[headerCodes[i].code];
                    }
                    item.CNNAMES = headerCodes;
                    item.target = data.target;
                    var geo = district.center.clone();
                    var fea = new SuperMap.Feature.Vector(geo, item);
                    features.push(fea);
                }
            }
            this.themeLayer.addFeatures(features);

            data.headerCodes = headerCodes;
            this.showLegend(data);
        },

        initLayer: function (data) {
            // 创建一个饼状图（Pie）统计专题图图层
            this.themeLayer = new SuperMap.Layer.Graph("ThemeLayer", "Pie");
            this.globalMap.mapObject.addLayer(this.themeLayer);
            this.themeLayer.themeFields = [];
            // 指定用于专题图制作的属性字段
            for (var i = 0; i < data.length; i++) {
                this.themeLayer.themeFields.push(data[i].code);
            }

            // 配置图表参数
            this.configChartsSetting = {
                // width，height，codomain 分别表示图表宽、高、数据值域；此三项参数为必设参数
                width: 60,
                height: 60,
                codomain: [0, 999999999], // 允许图表展示的值域范围，此范围外的数据将不制作图表
              
                // 饼图扇形（表示字段值的图形）样式
                sectorStyle: { fillOpacity: 0.8 },
                sectorStyleByFields: [],
                // 按字段设置饼图扇形 (样式与 themeLayer.themeFields 数组中的字段名称一一对应)
                //  饼图扇形 hover 样式
                sectorHoverStyle: { fillOpacity: 1 }
            };
            //this.themeLayer.isOverLay = false;
            for (var index = 0; index < data.length; index++) {
                this.configChartsSetting.sectorStyleByFields.push({ fillColor: this.colors[index] });
            }
            this.themeLayer.chartsSetting = this.configChartsSetting;
            this.themeLayer.overlayWeightField = data[0].code;
            var thisCallBack = this;
            // 注册专题图 mousemove, mouseout事件(注意：专题图图层对象自带 on 函数，没有 events 对象)
            this.themeLayer.on("mousemove", function (e) { thisCallBack.showInfoWin(e) });
            this.themeLayer.on("mouseout", function (e) { thisCallBack.closeInfoWin(e) });
        },

        showInfoWin: function (e) {
            // e.target 是图形对象，即数据的可视化对象，饼状图中是扇形。
            // 图形对象的 refDataID 属性是数据（feature）的 id 属性，它指明图形对象是由那个数据制作而来;
            // 图形对象的 dataInfo 属性是图形对象表示的具体数据，他有两个属性，field 和 value;
            if (e.target && e.target.refDataID && e.target.dataInfo) {
                this.closeInfoWin();
                // 获取图形对应的数据 (feature)
                var fea = this.themeLayer.getFeatureById(e.target.refDataID);

                var info = e.target.dataInfo;

                // 弹窗内容
                var contentHTML = "<div style='overflow:hidden;width:100%; border-style: solid; white-space: nowrap; z-index: 9999999;transition: left 0.4s cubic-bezier(0.23, 1, 0.32, 1), top 0.4s cubic-bezier(0.23, 1, 0.32, 1); background-color: rgba(50, 50, 50, 0.701961);border-width: 0px;border-color: rgb(51, 51, 51); border-radius: 4px;color: rgb(255, 255, 255);font-style: normal;font-variant: normal;font-weight: normal; font-stretch: normal;font-size: 14px;font-family: \"Microsoft YaHei\"; line-height:21px;padding: 5px;'>";
                contentHTML += "<strong>" + fea.attributes.LABEL + "</strong>";

                contentHTML += "<hr style='margin: 3px'>";
                var units = fea.attributes.target.NOTE.split("，");

                var dataItem;
                for (var index = 0; index < fea.attributes.CNNAMES.length; index++) {
                    var item = fea.attributes.CNNAMES[index];

                    if (item.code == info.field) {
                        var unit = units.length > 2 ? units[index % 2] : units[0]
                        dataItem = item;
                        dataItem.unit = unit;
                    }

                }

                contentHTML += dataItem.name + ":<strong>" + info.value + "（" + dataItem.unit + "）</strong>";

                contentHTML += "</div>";
                var str = dataItem.name + ":" + info.value + "(" + dataItem.unit + ")";
                var len = str.replace(/[^\x00-\xff]/g, "01").length;
                // 弹出框大小
                var infowinSize = (SuperMap.Browser.name == "firefox") ? new SuperMap.Size(len * 8, 105) : new SuperMap.Size(len * 8, 90);
            
                // 弹出窗地理位置
                var lonLat = this.globalMap.mapObject.getLonLatFromPixel(this.globalMap.infowinPosition);
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
              
                } catch (e)
                {
                }
                this.infowin.setBackgroundColor("none");
                this.globalMap.mapObject.addPopup(this.infowin);
            }
        },

        closeInfoWin: function () {
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

            this.configChartsSetting = null;
        },
        CLASS_NAME: "BaseObject.BingTuTheme"
    });
    module.exports = BaseObject.BingTuTheme;

});
 