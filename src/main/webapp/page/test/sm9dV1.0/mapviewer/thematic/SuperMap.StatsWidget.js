define(function (require, exports, module) {
    SuperMap.StatsWidget = BaseHelper.Class.create();
    SuperMap.StatsWidget.prototype = BaseHelper.Class.inherit(BaseObject.Component, {

        initialize: function () {
            this.top = 150;
            this.left = 0;
            this.right = 1;
            this.bottom = 0;
            this.ID = this.getGUID();
            this.disrictHashTable = {};
            this.isAdd = false;
            this.themes = [];
            this.positonStatus = "open";
        },
        init: function (globalMap) {
            this.clear();
            this.globalMap = globalMap;
            this.configData = {};
            var thisCallBack = this;
            if (!this.isAdd) {
                this.globalMap.addEventListener("removeFloatDiv", function (e) {

                });
 
                this.globalMap.addEventListener("changedMapCompleted", function () {
                    thisCallBack.active();
                });
                this.isAdd = true;
            }
            this.globalMap.dispathEvent("removeFloatDiv", { data: this.ID });
        },

        setLegendPosition: function (status) {
            if (this.globalMap) {
                for (var index = 0; index < this.globalMap.layerThemes.length; index++)
                    this.globalMap.layerThemes[index].setLegendPosition(status);
                this.positonStatus = status;
            }
        },

        //初始化信息类
        getHtml: function (data) {
            var div = ' ';
            div += '<ul class="widget_menu">';
            div += '<li class="select" style="float:none;"><a href="#"  id="close_' + this.ID + '" style="border-right:none"><span class="close" title="关闭"></a><a href="#"  id="winMinMax_' + this.ID + '" style="border-right:none"><span class="winMin" title="最小化"></span></a><a style="max-width:150px;border-right:none"><span class="sidebar-dlss"></span>专题统计结果</a></font>';


            //div += '<img style="float:right;margin-left:5px;margin-left:5px" src="' + BaseObject.path + (this.configData.icon ? this.configData.icon : "/styles/css_map/themes/images/9zt-arrow-1.png") + '"   /></a></li>';
            //div += '<div class="content" style="display:none">';
            //div += '<div class="tiaojian">';
            //div += '<div class="tab_chart " ><span class="active" id="danz"><img src="style/themes/css_ctadmin/images/chart_danz.png"> 单值</span><span id="dengj"><img src="style/themes/css_ctadmin/images/chart_dengj.png"> 等级</span><span id="bingt"><img src="style/themes/css_ctadmin/images/chart_bin.png"> 饼状</span><span id="zhut"><img src="style/themes/css_ctadmin/images/chart_zhu.png"> 柱状</span></div>';
            //div += '</div>';

            div += '<div class="info_content">';
            var unit = "";
            div += '<div style="float:left;margin-left:10px;color:#ff0000;font-size:12px;">单位：' + data.NOTE + '</div>';
            div += '<div class="info_chart" style="height:200px;"></div>';
            div += '<div class="info_list"></div>';

            div += '<div>';
            div += '</div>';

            div += '</ul>';

            this.element = document.createElement("div");
            this.element.id = "component_" + this.ID;
            this.element.className = "mapviewer-widget mapviewer-clearfix";

            $(this.element).append(div);
            $(this.globalMap.viewerContainer).append($(this.element));
            var id = "component_" + this.ID;
            this.statsWidget = $("#" + id);

            this.statsWidget.mouseover(function () {
                $(this).css("opacity", 0.98);
            }).mouseout(function () {
                $(this).css("opacity", 0.9);
            }).css({ width: 180 });

            var thisCallBack = this;
            $("#idxSearchBtn").on('click', function () {

            });

            $(".tab_chart").find("span").on("click", function () {
                $(this).parent().find("span").removeClass("active");
                thisCallBack.mapThemeType = $(this).attr("id");
                thisCallBack.showMap(thisCallBack.mapThemeType);
                $(this).addClass("active");
            });
            var height = $(thisCallBack.globalMap.viewerContainer).height();
            $(thisCallBack.element).css({ width: 450, height: height - thisCallBack.top * 2 });
            $(thisCallBack.element).find(".content").css({ "display": "block" });
            $(thisCallBack.element).find(".info_content").css({ "height": height - thisCallBack.top * 2 - 50 });
            this.bindEvent();
        },

        active: function () {
            //this.showMap(this.mapThemeType);
            if (!this.mapThemeType) this.mapThemeType = "danz";
            $(".tab_chart").find("#" + this.mapThemeType).click();
        },

        bindEvent: function () {
            var thisCallBack = this;

            $("#close_" + this.ID).click(function () {
                $(thisCallBack.element).remove();
                thisCallBack.clear();
            }).css({ "border-right": "#cccccc 0px solid" });

            $("#winMinMax_" + this.ID).click(function () {

                if ($(this).find("span").hasClass("winMax")) {

                    var height = $(thisCallBack.globalMap.viewerContainer).height();
                    $(thisCallBack.element).css({ width: 450, height: height - thisCallBack.top * 2 });
                    $(thisCallBack.element).find(".info_content").css({ "display": "block" });
                    $(thisCallBack.element).css({ "height": height - thisCallBack.top * 2});
                    $(this).find("span").removeClass("winMax").addClass("winMin");
                }
                else {

                    $(thisCallBack.element).find(".info_content").css({ "display": "none" });
                    $(thisCallBack.element).css({ "height": 40, "width": 250 });
                    $(this).find("span").removeClass("winMin").addClass("winMax");

                }
                thisCallBack.resize();

            }).css({ "border-right": "#cccccc 0px solid" });
        },

        initializeCallBack: function () {

        },

        getIdxUnit: function (target) {
            var value = target.UNIT.trim();
            switch (value) {
                case '0':
                    return "个";
                    break;
                case '1':
                    return "吨";
                    break;
                case '2':
                    return "万吨";
                    break;
                case '3':
                    return "亿美元";
                    break;
            }
        },
        reset: function () {

            $("#mapContentDiv").show();
            this.globalMap.resize();
            if ($("#sceneControlDiv"))
                $("#sceneControlDiv").remove();
        },


        show: function (type, data) {
            this.clear();
            this.data = data;
            this.target = data.target;
            this.getHtml(data.target);
            this.resize();
            this.showData(data, data.target);
            var thisCallBack = this;
            this.globalMap.addWidget(this);
            this.status = status;
              

            switch (type) {
                case "danz":
                    this.showMapDanZhi();
                    break;
                case "dengj":
                    this.showMapDengJiFuHao();
                    break;
                case "bingt":
                    this.showMapBingTu();
                    break;
                case "zhut":
                    this.showMapZhuTu();
                    break;
            }
        },

        showMapDanZhi: function () {
            var thisCallBack = this;
            if (!this.danzhiTheme) {
                thisCallBack.globalMap.loadjs("thematicmap/DanZhi.Theme.js",
     	          function (a) {
     	              thisCallBack.danzhiTheme = new a(thisCallBack.globalMap);
     	              thisCallBack.danzhiTheme.show(thisCallBack.globalData);
     	              thisCallBack.globalMap.layerThemes.push(thisCallBack.danzhiTheme);
     	          });
            }
            else {
                this.danzhiTheme.show(this.globalData);
            }
        },
        showMapDengJiFuHao: function () {
            var thisCallBack = this;
            if (!this.dengJiFuHaoTheme) {
                thisCallBack.globalMap.loadjs("thematicmap/DengJiFuHao.Theme.js",
     	          function (a) {
     	              thisCallBack.dengJiFuHaoTheme = new a(thisCallBack.globalMap);
     	              thisCallBack.dengJiFuHaoTheme.show(thisCallBack.globalData);
     	              thisCallBack.globalMap.layerThemes.push(thisCallBack.dengJiFuHaoTheme);
     	          });
            }
            else {
                this.dengJiFuHaoTheme.show(this.globalData);
            }
        },

        showMapBingTu: function () {
            var thisCallBack = this;
            if (!this.bingTuTheme) {
                thisCallBack.globalMap.loadjs("thematicmap/BingTu.Theme.js",
     	          function (a) {
     	              thisCallBack.bingTuTheme = new a(thisCallBack.globalMap);
     	              thisCallBack.bingTuTheme.show(thisCallBack.globalData);
     	              thisCallBack.globalMap.layerThemes.push(thisCallBack.bingTuTheme);
     	          });
            }
            else {
                this.bingTuTheme.show(this.globalData);
            }
        },

        showMapZhuTu: function () {
            var thisCallBack = this;
            if (!this.zhuTuTheme) {
                thisCallBack.globalMap.loadjs("thematicmap/ZhuTu.Theme.js",
     	          function (a) {
     	              thisCallBack.zhuTuTheme = new a(thisCallBack.globalMap);
     	              thisCallBack.zhuTuTheme.show(thisCallBack.globalData);
     	              thisCallBack.globalMap.layerThemes.push(thisCallBack.zhuTuTheme);
     	          });
            }
            else {
                this.zhuTuTheme.show(this.globalData);
            }
        },

        showTitle: function (data) {
            if (this.titleWidget)
                this.titleWidget.remove();

            var html = data.CATEGORY_NAME;
            var div = document.createElement("div");
            div.id = "component_" + this.getGUID();
            div.className = "";
            div.style.cssText = "background:#0083CB;color:#fff; border:1px solid #fff; font-size:16px;text-align:center;position:absolute;z-index:10001;width:220px; height:30px;";
            $(div).append(html);

            $(this.globalMap.viewerContainer).append($(div));
            var id = "titleWidget_" + this.ID;
            this.titleWidget = $("#" + div.id);

            this.titleWidget.css({ "top": 0, "left": ($(this.globalMap.mapContainer).width() - 200) / 2 }).css("opacity", 0.8); ;

            this.titleWidget.mouseover(function () {
                $(this).css("opacity", 0.95);
            });
            this.titleWidget.mouseout(function () {
                $(this).css("opacity", 0.8);
            });
        },

        showData: function (data, target) {

            var headerData = data.headerData;
            var resultData = data.resultData;
            var headerCodes = [];
            this.globalData = data;
            this.globalData.target = target;

            for (var index = 0; index < headerData.length; index++) {
                var item = headerData[index];
                if (item.HEADER_FILED) {
                    headerCodes.push({ code: item.ITEM_CODE, name: item.ITEM_NAME });
                }
            }

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

            var unit = this.getIdxUnit(target);
            var html = '<table border="0" cellpadding="0" cellspacing="0" class="tableList">';
            html += '<tbody>';
            for (var index = 0; index < headerData.length; index++) {
                var item = headerData[index];
                html += '<th>' + item.ITEM_NAME + '</th>';
            }
            html += '</tr>';
            var index = 0;
            for (var j = resultData.length - 1; j >= 0; j--) {
                index++;
                html += '<tr>';
                //html += '<td><a href="#" style="border-right:none">' + resultData[j]["LABEL"] + '</a></td>';
                for (var k = 0; k < headerData.length; k++) {

                    var item = headerData[k];
                    if (item.IS_SORT == 1)
                        html += '<td><li><a style="border-right:none"><i span="" class="numb_1">' + index + '</i></li></a></td>';
                    else {
                        if ([item.ITEM_CODE] == "LABEL") {
                            html += '<td><li><a style="border-right:none;color:#000" class="tooltip" value=' + JSON.stringify( resultData[j].center) + '>' + resultData[j][item.ITEM_CODE] + '</li></a></td>';
                        }
                        else
                            html += '<td>' + resultData[j][item.ITEM_CODE] + '</td>';
                    }
                }
                html += '</tr>';
            }
            html += '</tbody></table>';

            $(this.element).find(".info_list").html(html);

            $(this.element).find(".info_list").css({ "width": "400" });
            $(this.element).find(".info_chart").css({ "width": "400", "height": 300, "display": "block" });

            this.showChart(data);

            var thisCallBack = this;
            $(".info_list").find(".tooltip").on("click", function () {
                var val = $(this).attr("value");
                if (val) {
                    thisCallBack.setLocation(val, false);
                }
            })

            //this.showTitle(target);
        },

        setLocation: function (val) {
            //var district = this.globalMap.disrictHashTable[name];
           // clearInterval(this.timer);
            var feature = new SuperMap.Feature.Vector(JSON.parse(val));
            feature.style = {
                strokeColor: "red",
                strokeWidth: 2,
                fillColor: "#fff",
                fontColor: "#FFF0F5",

                fontWeight: "bold",
                fontSize: 13,
                fillOpacity: 0,
                labelYOffset: 1
            };
            //this.globalMap.mapObject.zoomToExtent(feature.geometry.bounds);
            this.globalMap.setLocation(feature);

            var lonLat = new SuperMap.LonLat(JSON.parse(val).x, JSON.parse(val).y);
            this.globalMap.mapObject.setCenter(lonLat, 5);
            //this.globalMap.mapObject.zoomTo(5);
            //if (this.drawVector) {
            //    this.drawVector.removeAllFeatures();
            //    if (this.globalMap.mapObject.getLayer(this.drawVector.id))
            //        this.globalMap.mapObject.removeLayer(this.drawVector);
            //}
            //this.drawVector = new SuperMap.Layer.Vector("dddDrawVector");
            //this.globalMap.mapObject.addLayers([this.drawVector]);
            //this.currentTarget = feature.clone();
            //this.drawVector.addFeatures(this.currentTarget);
            //var count = 0;
            //var thisCallBack = this;
            //this.timer = setInterval(function () {
            //    count++;
            //    if (count % 2)
            //        thisCallBack.drawVector.removeFeatures(thisCallBack.currentTarget);
            //    else
            //        thisCallBack.drawVector.addFeatures(thisCallBack.currentTarget)
            //    if (count > 5) {
            //        clearInterval(thisCallBack.timer);
            //        count = 0;
            //        thisCallBack.drawVector.removeAllFeatures();
            //        thisCallBack.globalMap.mapObject.removeLayer(thisCallBack.drawVector);
            //    }
            //}, 500);
        },


        showChart: function (data) {

            var headerData = data.headerData;
            var resultData = data.resultData;

            var legendData = [];
            var series = [];
            var yAxisData = [];
            var headerCodes = [];
            var colorList = ['#CD2626', '#C1232B',
             '#C1232B', '#B5C334', '#FCCE10', '#E87C25', '#27727B',
             '#FE8463', '#9BCA63', '#FAD860', '#F3A43B', '#60C0DD',
             '#D7504B', '#C6E579', '#F4E001', '#F0805A', '#26C0C0'];

            for (var index = 0; index < headerData.length; index++) {
                var item = headerData[index];
                if (item.HEADER_FILED) {
                    legendData.push(item.ITEM_NAME);
                    headerCodes.push({ code: item.ITEM_CODE, name: item.ITEM_NAME });
                }
            }
            //var maxValue = resultData[resultData.length - 1];
            for (var index = resultData.length - 1; index >= resultData.length - 5; index--) {
                var item = resultData[index];
                if (item.IS_SORT != 1) {
                    yAxisData.push(item.LABEL);
                }
            }

            var tempData = {};
            for (var k = 0; k < headerCodes.length; k++) {
                for (var index = resultData.length - 1; index >= resultData.length - 5; index--) {
                    var item = resultData[index];
                    var value = item[headerCodes[k].code];
                    if (!tempData[headerCodes[k].code])
                        tempData[headerCodes[k].code] = [];
                    tempData[headerCodes[k].code].push(value);
                }
            }
            for (var index = 0; index < headerCodes.length; index++) {
                var item = headerCodes[index];
                var serie = this.getSerie(item.name, tempData[item.code], colorList[index]);
                series.push(serie);
            }

            option = {
                tooltip: {
                    trigger: 'axis'
                },
                grid: {
                    left: '20%',//组件距离容器左边的距离
                    right: '5%',
                    bottom: '7%',
                },
                legend: {
                    data: legendData
                },
                toolbox: {
                    show: true,
                    feature: {
                        magicType: { show: true, type: ['line', 'bar'] }
                    }
                },
                calculable: true,
                xAxis: [
        {
            type: 'category',
            boundaryGap: [0, 0.01],
            data: yAxisData
        }
    ],
                yAxis: [
        {
            type: 'value'

        }
    ],
                series: series
            };

            //--- 折柱 ---
            $(".info_chart").html("");
            var myChart = echarts.init($(".info_chart").css({ "height": 300, "width": 400 })[0], "red");
            myChart.setOption(option);

            var thisCallBack = this;

            function eConsole(param) {
                var mes = '【' + param.type + '】';
                thisCallBack.setLocation(param.name, false);
            }
            myChart.on("click", eConsole);


            //this.showMap("danz");
        },

        getSerie: function (name, data, color) {
            var item = {
                name: name,
                type: 'bar',
                data: data
            };

            return item;
        },

        clearLayer: function () {
            if (this.globalMap) {
                //for (var index = 0; index < this.globalMap.layerThemes.length; index++)
                //    this.globalMap.layerThemes[index].clear();
            };
            if (this.globalMap) {
                this.globalMap.baseDrawVectorLayer.clear();
            }
        },

        //初始化位置
        clear: function () {
            if (this.element)
                $(this.element).remove();
            this.clearLayer();
            if (this.titleWidget)
                this.titleWidget.remove();

            if (this.legendWidget)
                this.legendWidget.remove();
        },
        CLASS_NAME: "SuperMap.StatsWidget"
    });
    module.exports = SuperMap.StatsWidget;

});
 