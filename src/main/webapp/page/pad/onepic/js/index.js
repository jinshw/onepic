/*$(function () {
    var ctx, data, myLineChart, options;
    Chart.defaults.global.responsive = true;
    ctx = $('#jumbotron-line-chart').get(0).getContext('2d');
    options = {
        showScale: false,
        scaleShowGridLines: false,
        scaleGridLineColor: "rgba(0,0,0,.05)",
        scaleGridLineWidth: 0,
        scaleShowHorizontalLines: false,
        scaleShowVerticalLines: false,
        bezierCurve: false,
        bezierCurveTension: 0.4,
        pointDot: false,
        pointDotRadius: 0,
        pointDotStrokeWidth: 2,
        pointHitDetectionRadius: 20,
        datasetStroke: true,
        datasetStrokeWidth: 4,
        datasetFill: true,
        legendTemplate: "<ul class=\"<%=name.toLowerCase()%>-legend\"><% for (var i=0; i<datasets.length; i++){%><li><span style=\"background-color:<%=datasets[i].strokeColor%>\"></span><%if(datasets[i].label){%><%=datasets[i].label%><%}%></li><%}%></ul>"
    };
    data = {
        labels: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul'],
        datasets: [
            {
                label: "My Second dataset",
                fillColor: "rgba(34, 167, 240,0.2)",
                strokeColor: "#22A7F0",
                pointColor: "#22A7F0",
                pointStrokeColor: "#fff",
                pointHighlightFill: "#fff",
                pointHighlightStroke: "#22A7F0",
                data: [28, 48, 40, 45, 76, 65, 90]
            }
        ]
    };
    myLineChart = new Chart(ctx).Line(data, options);
});

$(function () {
    var ctx, data, myBarChart, option_bars;
    Chart.defaults.global.responsive = true;
    ctx = $('#jumbotron-bar-chart').get(0).getContext('2d');
    option_bars = {
        showScale: false,
        scaleShowGridLines: false,
        scaleBeginAtZero: true,
        scaleShowGridLines: true,
        scaleGridLineColor: "rgba(0,0,0,.05)",
        scaleGridLineWidth: 1,
        scaleShowHorizontalLines: false,
        scaleShowVerticalLines: false,
        barShowStroke: true,
        barStrokeWidth: 1,
        barValueSpacing: 7,
        barDatasetSpacing: 3,
        legendTemplate: "<ul class=\"<%=name.toLowerCase()%>-legend\"><% for (var i=0; i<datasets.length; i++){%><li><span style=\"background-color:<%=datasets[i].fillColor%>\"></span><%if(datasets[i].label){%><%=datasets[i].label%><%}%></li><%}%></ul>"
    };
    data = {
        labels: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul'],
        datasets: [
            {
                label: "My First dataset",
                fillColor: "rgba(26, 188, 156,0.6)",
                strokeColor: "#1ABC9C",
                pointColor: "#1ABC9C",
                pointStrokeColor: "#fff",
                pointHighlightFill: "#fff",
                pointHighlightStroke: "#1ABC9C",
                data: [65, 59, 80, 81, 56, 55, 40]
            }, {
                label: "My Second dataset",
                fillColor: "rgba(34, 167, 240,0.6)",
                strokeColor: "#22A7F0",
                pointColor: "#22A7F0",
                pointStrokeColor: "#fff",
                pointHighlightFill: "#fff",
                pointHighlightStroke: "#22A7F0",
                data: [28, 48, 40, 19, 86, 27, 90]
            }
        ]
    };
    myBarChart = new Chart(ctx).Bar(data, option_bars);
});

$(function () {
    var ctx, data, myLineChart, options;
    Chart.defaults.global.responsive = true;
    ctx = $('#jumbotron-line-2-chart').get(0).getContext('2d');
    options = {
        showScale: false,
        scaleShowGridLines: false,
        scaleGridLineColor: "rgba(0,0,0,.05)",
        scaleGridLineWidth: 0,
        scaleShowHorizontalLines: false,
        scaleShowVerticalLines: false,
        bezierCurve: false,
        bezierCurveTension: 0.4,
        pointDot: false,
        pointDotRadius: 0,
        pointDotStrokeWidth: 2,
        pointHitDetectionRadius: 20,
        datasetStroke: true,
        datasetStrokeWidth: 3,
        datasetFill: true,
        legendTemplate: "<ul class=\"<%=name.toLowerCase()%>-legend\"><% for (var i=0; i<datasets.length; i++){%><li><span style=\"background-color:<%=datasets[i].strokeColor%>\"></span><%if(datasets[i].label){%><%=datasets[i].label%><%}%></li><%}%></ul>"
    };
    data = {
        labels: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul'],
        datasets: [
            {
                label: "My First dataset",
                fillColor: "rgba(26, 188, 156,0.2)",
                strokeColor: "#1ABC9C",
                pointColor: "#1ABC9C",
                pointStrokeColor: "#fff",
                pointHighlightFill: "#fff",
                pointHighlightStroke: "#1ABC9C",
                data: [65, 59, 80, 81, 56, 55, 40]
            }, {
                label: "My Second dataset",
                fillColor: "rgba(34, 167, 240,0.2)",
                strokeColor: "#22A7F0",
                pointColor: "#22A7F0",
                pointStrokeColor: "#fff",
                pointHighlightFill: "#fff",
                pointHighlightStroke: "#22A7F0",
                data: [28, 48, 40, 19, 86, 27, 90]
            }
        ]
    };
    myLineChart = new Chart(ctx).Line(data, options);
});*/
var map, lineLayer,
    styleLayer = {
        strokeColor: "#304DBE",
        strokeWidth: 2,
        pointerEvents: "visiblePainted",
        fillColor: "#304DBE",
        fillOpacity: 0.8
    };


$(function () {
    /*
        * 不支持canvas的浏览器不能运行该范例
        * android 设备也不能运行该范例*/
    var broz = SuperMap.Util.getBrowser();

    if (!document.createElement('canvas').getContext) {
        alert('您的浏览器不支持 canvas，请升级');
        return;
    } else if (broz.device === 'android') {
        alert('您的设备不支持，请使用pc或其他设备');
        return;
    }
    document.getElementById('map').style.height = (document.documentElement.clientHeight - 60 - 24 ) + 'px'

    //新建线矢量图层
    lineLayer = new SuperMap.Layer.Vector("lineLayer");
    //对线图层应用样式style（前面有定义）
    lineLayer.style = styleLayer;
    //创建画线控制，图层是lineLayer;这里DrawFeature(图层,类型,属性)；multi:true在将要素放入图层之前是否现将其放入几何图层中
    drawLine = new SuperMap.Control.DrawFeature(lineLayer, SuperMap.Handler.Path, {multi: true});
    /*
            注册featureadded事件,触发drawCompleted()方法
            例如注册"loadstart"事件的单独监听
            events.on({ "loadstart": loadStartListener });
            */
    drawLine.events.on({"featureadded": drawCompleted});


    //初始化地图
    map = new SuperMap.Map("map", {
        minZoom: 0,
        maxZoom: 11,
        allOverlays: true,
        controls: [
            new SuperMap.Control.Navigation(),
            drawLine
        ]
    });
    map.addControl(new SuperMap.Control.MousePosition());

    //初始化图层
    //初始化图层
    layerT = new SuperMap.Layer.TiledDynamicRESTLayer("ditu", MAPURL.URL, {
        transparent: true,
        cacheEnabled: true
    });

    layerRoad = new SuperMap.Layer.TiledDynamicRESTLayer("road", MAPURL.ROAD_URL, {
        transparent: true,
        cacheEnabled: true
    });
    layerZJRoad = new SuperMap.Layer.TiledDynamicRESTLayer("zjroad", MAPURL.ZJ_ROAD, {
        transparent: true,
        cacheEnabled: true
    });
    layerZJRoad.events.on({
        "layerInitialized": addLayer
    });

    //异步加载图层
    function addLayer() {
        map.addLayers([
            layerT,
            layerRoad, layerZJRoad, vectorLayer, lineLayer]);

        map.setCenter(new SuperMap.LonLat(87.64226, 43.79469), 2);
    }


    // 选择要素
    var callbacks = {
        click: function (currentFeature) {
            var _html = getPopupMsg(currentFeature.attributes)
            // layer.msg(_html);
            layer.open({
                type: 1
                , content: _html
                , anim: 'up'
                , style: 'position:fixed; bottom:0; left:0; width: 100%; height: 150px; padding:10px 0; border:none;'
            });
        }
    }
    vectorLayer = new SuperMap.Layer.Vector("vectorLayer");
    var selectFeature = new SuperMap.Control.SelectFeature(vectorLayer, {
        callbacks: callbacks
    })
    map.addControl(selectFeature);
    selectFeature.activate();

    // 搜索事件
    $("#searchBtn").click(function () {
        var searchContent = $.trim($("#searchInput").val())
        console.log(searchContent)
        queryRoad(searchContent)

    })
})

/**
 *  左侧道路树查询
 */
var gsFeatures = null;
var gdFeatures = null;
var sdFeatures = null;

function queryRoad(content) {
    if (content == undefined) {
        content = ""
    }
    var queryParamGS, queryParamGD, queryParamSD, queryBySQLParams, queryBySQLService;
    queryParamGS = new SuperMap.REST.FilterParameter({
        name: "GLGS_1@xj",
        attributeFilter: "XMMC LIKE '%" + content + "%'"

    });
    queryParamGD = new SuperMap.REST.FilterParameter({
        // name: "一般国道@交通#2#4"
        name: "GLGD_3@xj",
        attributeFilter: "XMMC LIKE '%" + content + "%'"
    });
    queryParamSD = new SuperMap.REST.FilterParameter({
        name: "一般省道@交通#3",
        attributeFilter: "XMMC LIKE '%" + content + "%'"
    });
    queryBySQLParams = new SuperMap.REST.QueryBySQLParameters({
        queryParams: [queryParamGS, queryParamGD, queryParamSD],
        queryOption: "ATTRIBUTE"
    });
    queryBySQLService = new SuperMap.REST.QueryBySQLService(MAPURL.ZJ_ROAD, {
        eventListeners: {
            "processCompleted": processCompleted,
            "processFailed": processFailed
        }
    });
    queryBySQLService.processAsync(queryBySQLParams);
}

// 调用查询道路
queryRoad()

// 查询数据集处理
function processCompleted(queryEventArgs) {
    gsFeatures = queryEventArgs.result.recordsets[0].features
    gdFeatures = queryEventArgs.result.recordsets[1].features
    sdFeatures = queryEventArgs.result.recordsets[2].features

    console.log(">>>>>>>>>>>>>>>>>")
    // console.log(gsFeatures)
    // console.log(gdFeatures)
    // console.log(sdFeatures)
    console.log(">>>>>>>>>>>>>>>>>")
    toggleProjectType(gsFeatures, gdFeatures, sdFeatures)
}

function processFailed(e) {
    console.log(e)
    alert(e.error.errorMsg);
}


$(document).ready(function () {
    $("input[name='projectType']").click(function () {
        console.log($(this).val())
        var projectType = $(this).val()
        changeProjectType(projectType)
    })
})

function changeProjectType(type) {
    displayProjectTypeTree(type)
    queryRoad()
}

function displayProjectTypeTree(type) {
    if (type == 'tbj') {
        $("#tbjTree").css("display", "block")
        $("#dzjTree").css("display", "none")
        $("#jsbtTree").css("display", "none")
    } else if (type == 'dzj') {
        $("#tbjTree").css("display", "none")
        $("#dzjTree").css("display", "block")
        $("#jsbtTree").css("display", "none")
    } else if (type == 'jsbt') {
        $("#tbjTree").css("display", "none")
        $("#dzjTree").css("display", "none")
        $("#jsbtTree").css("display", "block")
    }
}

function toggleProjectType(gs, gd, sd) {
    var type = $("input[name='projectType']:checked").val()
    var gsStr = "", gdStr = "", sdStr = "";
    for (var i = 0; i < gsFeatures.length; i++) {
        _obj = gsFeatures[i].attributes
        if (_obj.SSJB.trim() == "厅本级" && type == "tbj") {
            gsStr = gsStr + `<li><a href="javascript:void(0)" data-smId="${_obj.SmID}" data-gljb="${_obj.GLJB}">${_obj.XMMC}</a></li>`
        } else if (_obj.SSJB.trim() == "地州级" && type == "dzj") {
            gsStr = gsStr + `<li><a href="javascript:void(0)" data-smId="${_obj.SmID}" data-gljb="${_obj.GLJB}">${_obj.XMMC}</a></li>`
        } else if (_obj.SSJB.trim() == "建设兵团级" && type == "jsbt") {
            gsStr = gsStr + `<li><a href="javascript:void(0)" data-smId="${_obj.SmID}" data-gljb="${_obj.GLJB}">${_obj.XMMC}</a></li>`
        }
    }
    for (var i = 0; i < gdFeatures.length; i++) {
        _obj = gdFeatures[i].attributes
        if (_obj.SSJB.trim() == "厅本级" && type == "tbj") {
            gdStr = gdStr + `<li><a href="javascript:void(0)" data-smId="${_obj.SmID}" data-gljb="${_obj.GLJB}">${_obj.XMMC}</a></li>`
        } else if (_obj.SSJB.trim() == "地州级" && type == "dzj") {
            gdStr = gdStr + `<li><a href="javascript:void(0)" data-smId="${_obj.SmID}" data-gljb="${_obj.GLJB}">${_obj.XMMC}</a></li>`
        } else if (_obj.SSJB.trim() == "建设兵团级" && type == "jsbt") {
            gdStr = gdStr + `<li><a href="javascript:void(0)" data-smId="${_obj.SmID}" data-gljb="${_obj.GLJB}">${_obj.XMMC}</a></li>`
        }
    }
    for (var i = 0; i < sdFeatures.length; i++) {
        _obj = sdFeatures[i].attributes
        if (_obj.SSJB.trim() == "厅本级" && type == "tbj") {
            sdStr = sdStr + `<li><a href="javascript:void(0)" data-smId="${_obj.SmID}" data-gljb="${_obj.GLJB}">${_obj.XMMC}</a></li>`
        } else if (_obj.SSJB.trim() == "地州级" && type == "dzj") {
            sdStr = sdStr + `<li><a href="javascript:void(0)" data-smId="${_obj.SmID}" data-gljb="${_obj.GLJB}">${_obj.XMMC}</a></li>`
        } else if (_obj.SSJB.trim() == "建设兵团级" && type == "jsbt") {
            sdStr = sdStr + `<li><a href="javascript:void(0)" data-smId="${_obj.SmID}" data-gljb="${_obj.GLJB}">${_obj.XMMC}</a></li>`
        }
    }

    if (type == "tbj") {
        $("#gsULTBJ").html(gsStr)
        $("#gdULTBJ").html(gdStr)
        $("#sdULTBJ").html(sdStr)

        $("#gsULTBJ>li>a").click(function () {
            onClick({smId: $(this).data("smid"), gljb: $(this).data("gljb")})
        })
        $("#gdULTBJ>li>a").click(function () {
            onClick({smId: $(this).data("smid"), gljb: $(this).data("gljb")})
        })
        $("#sdULTBJ>li>a").click(function () {
            onClick({smId: $(this).data("smid"), gljb: $(this).data("gljb")})
        })
    } else if (type == "dzj") {
        $("#gsULDZJ").html(gsStr)
        $("#gdULDZJ").html(gdStr)
        $("#sdULDZJ").html(sdStr)
        $("#gsULDZJ>li>a").click(function () {
            onClick({smId: $(this).data("smid"), gljb: $(this).data("gljb")})
        })
        $("#gdULDZJ>li>a").click(function () {
            onClick({smId: $(this).data("smid"), gljb: $(this).data("gljb")})
        })
        $("#sdULDZJ>li>a").click(function () {
            onClick({smId: $(this).data("smid"), gljb: $(this).data("gljb")})
        })
    } else if (type == "jsbt") {
        $("#gsULJSBT").html(gsStr)
        $("#gdULJSBT").html(gdStr)
        $("#sdULJSBT").html(sdStr)
        $("#gsULJSBT>li>a").click(function () {
            onClick({smId: $(this).data("smid"), gljb: $(this).data("gljb")})
        })
        $("#gdULJSBT>li>a").click(function () {
            onClick({smId: $(this).data("smid"), gljb: $(this).data("gljb")})
        })
        $("#sdULJSBT>li>a").click(function () {
            onClick({smId: $(this).data("smid"), gljb: $(this).data("gljb")})
        })
    }

}


var style = {
    strokeColor: "red",
    strokeWidth: 10,
    fillOpacity: "1"
}

function onClick(treeNode) {
    // vectorLayer.removeAllFeatures();// 去除高亮
    vectorLayer.setVisibility(true)
    lineLayer.setVisibility(false)
    // removeVectorLayer()
    // deactiveAll();// 注销点控件
    var feature;
    // 判断海德中是否有数据添加条件 && treeNode.uniqueid != '0' && treeNode.uniqueid != ""
    if (treeNode.gljb != undefined) {
        if (treeNode.uniqueid != "0") {
            // app.checkall(treeNode.uniqueid);
        } else {
            // layer.msg("没有该项目信息");
            console.log("没有该项目信息")
        }
        var queryParam, queryParamGS, queryParamGD, queryParamSD, queryBySQLParams, queryBySQLService;
        if (treeNode.gljb == 'GS') {
            queryParam = new SuperMap.REST.FilterParameter({
                name: "GLGS_1@xj",
                attributeFilter: "SmID = " + treeNode.smId
            });
        } else if (treeNode.gljb == 'GD') {
            queryParam = new SuperMap.REST.FilterParameter({
                // name: "一般国道@交通#2#4",
                name: "GLGD_3@xj",
                attributeFilter: "SmID = " + treeNode.smId
            });
        } else if (treeNode.gljb == 'SD') {
            queryParam = new SuperMap.REST.FilterParameter({
                name: "一般省道@交通#3",
                attributeFilter: "SmID = " + treeNode.smId
            });
        }

        queryBySQLParams = new SuperMap.REST.QueryBySQLParameters({
            queryParams: [queryParam]
        });
        queryBySQLService = new SuperMap.REST.QueryBySQLService(
            MAPURL.ZJ_ROAD,
            {
                eventListeners: {
                    "processCompleted": function (queryEventArgs) {
                        console.log("-----------")
                        // console.log(queryEventArgs)
                        console.log("-----------")
                        feature = queryEventArgs.result.recordsets[0].features[0]
                        feature.style = style;
                        vectorLayer.addFeatures(feature);
                        map.zoomToExtent(feature.geometry.getBounds())

                        // 显示项目信息
                        if ($("#projectInfoBt").prop("checked")) {
                            $("#projectInfoAreaId").css("display", "block")
                        }
                        // 显示影像核查信息
                        if ($("#yxhcInfoBt").prop("checked")) {
                            $("#yxhcInfoArea").css("display", "block")
                        }
                    },
                    "processFailed": processFailed
                }
            });
        queryBySQLService.processAsync(queryBySQLParams);
    } else {
        // layer.msg("系统中没有该项目信息！")
    }

}


/**
 * [获取提示内容]
 * @param  {[type]} obj [properties属性]
 * @return {[type]}     [string]
 */
// marker 模板数据
var _markerTepl = '<div class="popup" style="color: #000000;font-size: 14px;">  ' +
    '   <section> ' +
    '       公路名：##name##' +
    '   </section>' +
    '   <section> ' +
    '       全长：##mileage##公里' +
    '   </section> ' +
    '   <section>' +
    '       开工时间：##startTime##' +
    '   </section>' +
    '   <section>' +
    '       竣工时间：##endTime##' +
    '   </section>' +
    '   <section>' +
    '       简介：##jianjie##' +
    '   </section>' +
    '   <section>' +
    '</div>'

function getPopupMsg(obj) {
    var _tempTepl = _markerTepl
    _tempTepl = _tempTepl.replace("##name##", obj.XMMC)
        .replace("##mileage##", "70")
        .replace("##startTime##", "2017-5")
        .replace("##endTime##", "2019-10")
        .replace("##jianjie##", "G575巴里坤-哈密段")
        .replace("##actual##", obj.mileage)

    // _tempTepl = _tempTepl.replace("##name##", obj.XMMC)
    //     .replace("##mileage##", parseInt(obj.length))
    //     .replace("##startTime##", obj.begin_User)
    //     .replace("##endTime##", obj.end_User)
    //     .replace("##jianjie##", obj.jianjie)
    //     .replace("##actual##", obj.mileage)

    return _tempTepl
}

function distanceMeasure() {
    clearFeatures();
    drawLine.activate();
}

//移除图层要素
function clearFeatures() {
    lineLayer.removeAllFeatures();
    lineLayer.setVisibility(false)
}

//绘完触发事件
function drawCompleted(drawGeometryArgs) {
    lineLayer.setVisibility(true)
    //停止画面控制
    drawLine.deactivate();
    //获得图层几何对象
    var geometry = drawGeometryArgs.feature.geometry,
        measureParam = new SuperMap.REST.MeasureParameters(geometry), /* MeasureParameters：量算参数类。 客户端要量算的地物间的距离或某个区域的面积*/
        myMeasuerService = new SuperMap.REST.MeasureService(MAPURL.URL); //量算服务类，该类负责将量算参数传递到服务端，并获取服务端返回的量算结果
    myMeasuerService.events.on({"processCompleted": measureCompleted});

    //对MeasureService类型进行判断和赋值，当判断出是LineString时设置MeasureMode.DISTANCE，否则是MeasureMode.AREA
    myMeasuerService.measureMode = SuperMap.REST.MeasureMode.DISTANCE;
    myMeasuerService.processAsync(measureParam); //processAsync负责将客户端的量算参数传递到服务端。
}

//测量结束调用事件
function measureCompleted(measureEventArgs) {
    var distance = measureEventArgs.result.distance;
    var unit = measureEventArgs.result.unit;
    // alert("量算结果:" + distance + "米");
    console.log("量算结果:" + distance + "米")
    layer.open({
        content: "量算结果:" + distance + "米"
        , btn: '我知道了',
        shadeClose:false
    });
}

function zoomout() {
    map.zoomOut()
}

function zoomin() {
    map.zoomIn()
}

function leftToolsHide() {
    $("#leftToolsBar").hide(500)
    $("#leftToolsBt").show(500)

}

function leftToolsShow() {
    $("#leftToolsBar").show(500)
    $("#leftToolsBt").hide(500)
}

