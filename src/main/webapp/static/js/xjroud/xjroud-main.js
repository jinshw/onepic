/**
 * 模块：主要模块
 * 注意：需要在config后加载
 * 主要功能：
 * supermap初始化，图层操作
 */

function init() {
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

    document.getElementById('map').style.height = (document.documentElement.clientHeight - 50 ) + 'px'

    var _oneTime = _layerImageList[0].time
    $('#mapTime').val(_oneTime);
    $('#mapTime').data("layerindex", 0)

    ponitLayer = new SuperMap.Layer.Vector("ponitLayer");
    drawPoint = new SuperMap.Control.DrawFeature(ponitLayer, SuperMap.Handler.Point);
    drawPoint.events.on({
        "featureadded": drawCompleted
    });

    //初始化地图
    map = new SuperMap.Map("map", {
        minZoom: 0,
        maxZoom: 11,
        allOverlays: true,
        controls: [
            new SuperMap.Control.Navigation(),
            new SuperMap.Control.Zoom(),
            new SuperMap.Control.LayerSwitcher(),
            drawPoint
        ]
    });
           map.addControl(new SuperMap.Control.MousePosition());
    mousePosition = new SuperMap.Control.MousePosition({
        id: "mousePositionId",
        autoActivate: true,
        separator: ','
    })
    map.addControl(mousePosition)
    mousePosition.activate()

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
    layerYXALL = new SuperMap.Layer.TiledDynamicRESTLayer("yxall", MAPURL.XJ_YX_ALL, {
        transparent: true,
        cacheEnabled: true
    });
    layer20150913 = new SuperMap.Layer.TiledDynamicRESTLayer("2015年影像", MAPURL.YX_2015, {
        transparent: true,
        cacheEnabled: true
    });
    layer20161210 = new SuperMap.Layer.TiledDynamicRESTLayer("2016年影像_1", MAPURL.YX_2016_1, {
        transparent: true,
        cacheEnabled: true
    });
    layerYX20162 = new SuperMap.Layer.TiledDynamicRESTLayer("2016年影像_2", MAPURL.YX_2016_2, {
        transparent: true,
        cacheEnabled: true
    });
    layerYX201705G216 = new SuperMap.Layer.TiledDynamicRESTLayer("201705G216影像", MAPURL.YX_2017_05_G216, {
        transparent: true,
        cacheEnabled: true
    });
    layerYX201705TWD = new SuperMap.Layer.TiledDynamicRESTLayer("201705TWD影像", MAPURL.YX_2017_05_TWD, {
        transparent: true,
        cacheEnabled: true
    });

    layerYX201706 = new SuperMap.Layer.TiledDynamicRESTLayer("201706影像", MAPURL.YX_2017_06, {
        transparent: true,
        cacheEnabled: true
    });
    layerYX201707 = new SuperMap.Layer.TiledDynamicRESTLayer("201707影像", MAPURL.YX_2017_07, {
        transparent: true,
        cacheEnabled: true
    });
    layerYX2017081 = new SuperMap.Layer.TiledDynamicRESTLayer("201708影像_1", MAPURL.YX_2017_08_1, {
        transparent: true,
        cacheEnabled: true
    });
    layerYX2017082 = new SuperMap.Layer.TiledDynamicRESTLayer("201708影像_2", MAPURL.YX_2017_08_2, {
        transparent: true,
        cacheEnabled: true
    });
    layerYX201709 = new SuperMap.Layer.TiledDynamicRESTLayer("201709影像", MAPURL.YX_2017_09, {
        transparent: true,
        cacheEnabled: true
    });
    layerChangeArea = new SuperMap.Layer.TiledDynamicRESTLayer("变化线路", MAPURL.CHANGE_AREA_MAP, {
        transparent: true,
        cacheEnabled: true
    });
    layerJSJD = new SuperMap.Layer.TiledDynamicRESTLayer("jsjd", MAPURL.JSJD_URL, {
        transparent: true,
        cacheEnabled: true
    });

    layerMQI = new SuperMap.Layer.TiledDynamicRESTLayer("MQI", MAPURL.MQI, {
        transparent: true,
        cacheEnabled: true
    });

    layerJSJDTWD = new SuperMap.Layer.TiledDynamicRESTLayer("layerJSJDTWD", MAPURL.JSJD_URL_TWD, {
        transparent: true,
        cacheEnabled: true
    });

    layerJSJDTWD.events.on({
        "layerInitialized": addLayer
    });

    areaLayer = new SuperMap.Layer.Vector("区域面积高亮");

    //监听图层信息加载完成事件
//            layerT.events.on({
//                "layerInitialized": addLayer1
//            });

    // 选择要素
    var callbacks = {
        click: function (currentFeature) {
            console.log(currentFeature)
            var _html = getPopupMsg(currentFeature.attributes)
            layer.msg(_html);
        }
    }
    vectorLayer = new SuperMap.Layer.Vector("vectorLayer");
    var selectFeature = new SuperMap.Control.SelectFeature(vectorLayer, {
        callbacks: callbacks
    })
    map.addControl(selectFeature);
    selectFeature.activate();
    markers = new SuperMap.Layer.Markers("Markers");
}

function mapLayerClick(obj, ele) {
    var pxystr = mousePosition.div.textContent
    var pxys = pxystr.split(',')
    if (pxys.length == 2) {
        addMarker(pxys[0], pxys[1])
    } else {
        alert("获取坐标点失败")
    }

}

/**
 * 添加标注
 */
var pointx = null, pointy = null, size, offset, icon;

function addMarker(px, py) {
    size = new SuperMap.Size(21, 25);
    offset = new SuperMap.Pixel(-(size.w / 2), -size.h);
    icon = new SuperMap.Icon('../../static/images/marker.gif', size, offset);
    //初始化标记覆盖物类
    marker = new SuperMap.Marker(new SuperMap.LonLat(px, py), icon);
    //添加覆盖物到标记图层
    markers.addMarker(marker);
    //注册 click 事件,触发 mouseClickHandler()方法
    marker.events.on({
        "click": function (event) {
            pointx = event.object.lonlat.lon
            pointy = event.object.lonlat.lat
            $(".drawplot-content").css("display", "block")
            $("#plotContent").val("")
            ajaxRequest.findPlot({pointx: pointx, pointy: pointy}).then(function (data) {
                if (data.status == 200 && data.list.length > 0) {
                    $("#plotContent").val(data.list[0].content)
                }
            })
        }
    });
}

// 标注内容保存
function plotSaveBt() {
    var keycode = "plotcontent";
    var content = $("#plotContent").val()
    if (content.trim() == '') {
        layer.msg("请填写标注的内容")
        return;
    }
    console.log(pointx, pointy)
    // 保存到数据库中
    ajaxRequest.insertPlot({
        pointx: pointx,
        pointy: pointy,
        content: content,
        keycode: keycode
    }).then(function (data) {
        console.log(data)
        if (data.status == 200) {
            layer.msg("保存成功")
        }
    });


}

// 标注内容取消
function plotCancelBt() {
    px = null
    py = null
    $(".drawplot-content").css("display", "none")
    $("#plotContent").val('')
}

function removePlotById() {
    //获取选中的对象
    if (pointx == null || pointy == null) {
        layer.msg("请选择一个标号")
        return;
    }

    layer.confirm('您确定要删除(不可恢复)该标注吗？ ', {
        btn: ['确定', '取消'] //按钮
    }, function () {

        ajaxRequest.deletePlot({pointx: pointx, pointy: pointy}).then(function (data) {
            markers.removeMarker(marker)
            if (data.rint == 0) {
                layer.msg("删除失败")
                return;
            }

            layer.msg("删除成功")
            $("#plotContent").val("")
            $(".drawplot-content").css("display", "none")

        })
    }, function () {
    });


}

function initDatas() {

    var keycode = "plotcontent";
    ajaxRequest.findPlot({}).then(function (data) {
        console.log(data)
        if (data.status == 200) {
            var list = data.list;
            for (var i = 0; i < list.length; i++) {
                let polygonPs = new Array();
                console.log(list[i].pointx, list[i].pointy)
                addMarker(list[i].pointx, list[i].pointy)
            }
        }

    });
}

//== 添加标注


// 点控件查询
function drawCompleted(drawGeometryArgs) {
    var feature = new SuperMap.Feature.Vector();
    feature.geometry = drawGeometryArgs.feature.geometry,
        feature.style = style;
    ponitLayer.addFeatures(feature);
    var getFeatureParameter, getFeatureService;
   /* getFeatureParameter = new SuperMap.REST.GetFeaturesByBufferParameters({
        bufferDistance: 0.0001,
        //attributeFilter: "SMID > 0",
        datasetNames: [
            "xj:qujingjieRL"
        ],
        returnContent: true,
        geometry: drawGeometryArgs.feature.geometry
    });*/
    getFeatureParameter = new SuperMap.REST.GetFeaturesByBufferParameters({
        bufferDistance: 0.0001,
        //attributeFilter: "SMID > 0",
        datasetNames: [
            "G575ChangeArea:变化线"
        ],
        returnContent: true,
        geometry: drawGeometryArgs.feature.geometry
    });

    // getFeatureParameter = new SuperMap.REST.GetFeaturesByBufferParameters({
    //     bufferDistance: 30,
    //     //attributeFilter: "SMID > 0",
    //     datasetNames: [
    //         "yxsx2017:Export_Output", "yxsx2017:Export_Output_2", "yxsx2017:Export_Output_3", "yxsx2017:Export_Output_4",
    //         "yxsx2017:Export_Output_5", "yxsx2017:Export_Output_6", "yxsx2017:Export_Output_7", "yxsx2017:Export_Output_8",
    //         "yxsx2017:Export_Output_9", "yxsx2017:Export_Output_10", "yxsx2017:Export_Output_11", "yxsx2017:Export_Output_12",
    //         "yxsx2017:Export_Output_13", "yxsx2017:Export_Output_14", "yxsx2017:Export_Output_15", "yxsx2017:Export_Output_16",
    //         "yxsx2017:Export_Output_17", "yxsx2017:Export_Output_18", "yxsx2017:Export_Output_19", "yxsx2017:Export_Output_20",
    //         "yxsx2017:Export_Output_21", "yxsx2017:Export_Output_22"
    //     ],
    //     returnContent: true,
    //     geometry: drawGeometryArgs.feature.geometry
    // });
    // getFeatureService = new SuperMap.REST.GetFeaturesByBufferService(DATA_URL, {
    /*getFeatureService = new SuperMap.REST.GetFeaturesByBufferService(MAPURL.URL_DATA, {
        eventListeners: {
            "processCompleted": processCompletedPoint,
            "processFailed": processFailed
        }
    });*/
    getFeatureService = new SuperMap.REST.GetFeaturesByBufferService(MAPURL.CHANGE_AREA_DATA, {
        eventListeners: {
            "processCompleted": processCompletedPoint,
            "processFailed": processFailed
        }
    });
    getFeatureService.processAsync(getFeatureParameter);
}

function processCompletedPoint(getFeaturesEventArgs) {
    console.log("******************0088")
    console.log(getFeaturesEventArgs)
    var _feature = getFeaturesEventArgs.result.features[0]
    var _attr = _feature.attributes
    layer.msg(_attr.NOTE)
    // layer.msg(_attr.县名)
}

// function processCompletedPoint(getFeaturesEventArgs) {
//     var _feature = getFeaturesEventArgs.result.features[0]
//     if (_feature != undefined) {
//         var _attr = _feature.attributes
//         var _label = "名称：" + _attr.IMG_NAME + "<br>"
//             + "类型：" + _attr.LEIXING + "<br>"
//             + "拍摄时间：" + _attr.TIME
//         layer.msg(_label)
//     }
// }


function removeVectorLayer() {
    vectorLayer.removeAllFeatures();// 去除高亮
}



//异步加载图层
function addLayer() {
    map.addLayers([
        layerT, layerYXALL,
        layer20150913, layer20161210, layerYX20162,
        layerYX201705G216, layerYX201705TWD, layerYX201706, layerYX201707, layerYX2017081, layerYX2017082, layerYX201709, layerChangeArea,
        layerRoad, layerZJRoad,
        layerJSJD, layerJSJDTWD, ponitLayer, vectorLayer, markers,areaLayer,layerMQI]);

    //显示地图范围9732011.83931, 5440449.31251    85.782, 41.344
    map.setCenter(new SuperMap.LonLat(87.64226, 43.79469), 2);

    setLayerVisibility({
        layerT: true,
        layerRoad: false,
        layerYXALL: false,
        layerZJRoad: false,
        layer20150913: false,
        layer20161210: false,
        layer20170101: false,
        vectorLayer: false,
        layerGF2016WUYU: false,
        layerGJ2017WUYU: false,
        layerSar2017: false,
        ponitLayer: false,
    })

}


// 查询影像信息
function queryYXInfo(SmID) {
    // 查询影像面数据
    var queryParam, queryParamGS, queryParamGD, queryParamSD, queryBySQLParams, queryBySQLService;
    var queryParam1, queryParam2, queryParam3, queryParam4, queryParam5,
        queryParam6, queryParam7, queryParam8, queryParam9, queryParam10,
        queryParam11, queryParam12, queryParam13, queryParam14, queryParam15,
        queryParam16, queryParam17, queryParam18, queryParam19, queryParam20,
        queryParam21, queryParam22;
    /*queryParam1 = new SuperMap.REST.FilterParameter({
        name: "Export_Output@yxsx2017"
    });
    queryParam2 = new SuperMap.REST.FilterParameter({
        name: "Export_Output_19@yxsx2017"
    });
    queryParam3 = new SuperMap.REST.FilterParameter({
        name: "Export_Output_22@yxsx2017"
    });
    queryParam4 = new SuperMap.REST.FilterParameter({
        name: "Export_Output_5@yxsx2017"
    });
    queryParam5 = new SuperMap.REST.FilterParameter({
        name: "Export_Output_3@yxsx2017"
    });
    queryParam6 = new SuperMap.REST.FilterParameter({
        name: "Export_Output_7@yxsx2017"
    });
    queryParam7 = new SuperMap.REST.FilterParameter({
        name: "Export_Output_9@yxsx2017"
    });
    queryParam8 = new SuperMap.REST.FilterParameter({
        name: "Export_Output_11@yxsx2017"
    });
    queryParam9 = new SuperMap.REST.FilterParameter({
        name: "Export_Output_10@yxsx2017"
    });
    queryParam10 = new SuperMap.REST.FilterParameter({
        name: "Export_Output_13@yxsx2017"
    });
    queryParam11 = new SuperMap.REST.FilterParameter({
        name: "Export_Output_12@yxsx2017"
    });
    queryParam12 = new SuperMap.REST.FilterParameter({
        name: "Export_Output_14@yxsx2017"
    });
    queryParam13 = new SuperMap.REST.FilterParameter({
        name: "Export_Output_8@yxsx2017"
    });
    queryParam14 = new SuperMap.REST.FilterParameter({
        name: "Export_Output_6@yxsx2017"
    });
    queryParam15 = new SuperMap.REST.FilterParameter({
        name: "Export_Output_16@yxsx2017"
    });
    queryParam16 = new SuperMap.REST.FilterParameter({
        name: "Export_Output_2@yxsx2017"
    });
    queryParam17 = new SuperMap.REST.FilterParameter({
        name: "Export_Output_4@yxsx2017"
    });
    queryParam18 = new SuperMap.REST.FilterParameter({
        name: "Export_Output_15@yxsx2017"
    });
    queryParam19 = new SuperMap.REST.FilterParameter({
        name: "Export_Output_18@yxsx2017"
    });
    queryParam20 = new SuperMap.REST.FilterParameter({
        name: "Export_Output_17@yxsx2017"
    });
    queryParam21 = new SuperMap.REST.FilterParameter({
        name: "Export_Output_21@yxsx2017"
    });
    queryParam22 = new SuperMap.REST.FilterParameter({
        name: "Export_Output_20@yxsx2017"
    });*/
    console.log("smid=="+SmID)
    queryParam = new SuperMap.REST.FilterParameter({
        name:"qujingjieRL@xj",
        attributeFilter: "SmID = " + SmID
    })

    queryBySQLParams = new SuperMap.REST.QueryBySQLParameters({
        queryParams: [
            queryParam
        ]
    });
    /*queryBySQLParams = new SuperMap.REST.QueryBySQLParameters({
        queryParams: [
            queryParam1, queryParam2, queryParam3, queryParam4, queryParam5,
            queryParam6, queryParam7, queryParam8, queryParam9, queryParam10,
            queryParam11, queryParam12, queryParam13, queryParam14, queryParam15,
            queryParam16, queryParam17, queryParam18, queryParam19, queryParam20, queryParam21, queryParam22
        ]
    });*/

    areaLayer.removeAllFeatures();
    queryBySQLService = new SuperMap.REST.QueryBySQLService(MAPURL.URL, {
        eventListeners: {
            "processCompleted": function (queryEventArgs) {
                console.log(queryEventArgs)
                var i, j, feature,
                    result = queryEventArgs.result;
                if (result && result.recordsets) {
                    for (i=0; i<result.recordsets.length; i++) {
                        if (result.recordsets[i].features) {
                            for (j=0; j<result.recordsets[i].features.length; j++) {
                                feature = result.recordsets[i].features[j];
                                feature.style = {
                                    strokeColor: "#304DBE",
                                    strokeWidth: 1,
                                    fillColor: "#304DBE",
                                    fillOpacity: "0.8"
                                };
                                areaLayer.addFeatures(feature);
                                map.zoomToExtent(feature.geometry.getBounds())
                            }
                        }
                    }
                }

                /*var _recordsets = queryEventArgs.result.recordsets
                var _feature;
                for (var i = 0; i < _recordsets.length; i++) {
                    _feature = _recordsets[i].features[0]
                    _feature.style = {
                        strokeColor: "#304DBE",
                        strokeWidth: 1,
                        strokeOpacity: "0",
                        fillColor: "#304DBE",
                        fillOpacity: "0"

                    }
                }*/

            },
            "processFailed": processFailed
        }
    });
    queryBySQLService.processAsync(queryBySQLParams);
}



// 基本建设信息查询
function infoQuery() {
    pageAreaDisplayOption({
        zjjdTable: "none",
        jdjdTable: "none",
        jcxxList: "block",
        timeLine: "none",
        projectInfo: true,
    })
    $("#leftSider").css("display", "block")
    $("#MainId").removeClass("col-md-12 col-sm-12").addClass("col-md-10 col-sm-10")
    vectorLayer.setVisibility(true)

    echartsToggle('none')

    setLayerVisibility({
        layerT: true,
        layerRoad: true,
        layerYXALL: false,
        layerZJRoad: true,
        layer20150913: false,
        layer20161210: false,
        layer20170101: false,
        vectorLayer: true
    })

}


// 注销点控件
function deactiveAll() {
    drawPoint.deactivate();
    $("#isScanPicInfo").prop("checked", false);
}

// 设置图层显示
function setLayerVisibility(obj) {

    $("#timeListId").css('display', 'none')

    layerT.setVisibility(obj["layerT"] || false)
    layerRoad.setVisibility(obj["layerRoad"] || false)
    layerYXALL.setVisibility(obj["layerYXALL"] || false)
    layerZJRoad.setVisibility(obj["layerZJRoad"] || false)

    layer20150913.setVisibility(obj["layer20150913"] || false)
    layer20161210.setVisibility(obj["layer20161210"] || false)

    layerYX20162.setVisibility(obj["layerYX20162"] || false)

    layerYX201705G216.setVisibility(obj["layerYX201705"] || false)
    layerYX201705TWD.setVisibility(obj["layerYX201705"] || false)
    layerYX201706.setVisibility(obj["layerYX201706"] || false)
    layerYX201707.setVisibility(obj["layerYX201707"] || false)
    layerYX2017081.setVisibility(obj["layerYX2017081"] || false)
    layerYX2017082.setVisibility(obj["layerYX2017082"] || false)

    layerYX201709.setVisibility(obj["layerYX201709"] || false)

    vectorLayer.setVisibility(obj["vectorLayer"] || false)
    layerJSJD.setVisibility(obj["layerJSJD"] || false)
    layerJSJDTWD.setVisibility(obj["layerJSJDTWD"] || false)

    ponitLayer.setVisibility(obj["ponitLayer"] || false)
    markers.setVisibility(obj["markers"] || false)
    areaLayer.setVisibility(obj["areaLayer"] || false)

}

/**
 * 页面显示区域配置
 * obj = {zjjdTable:"block",jdjdTable:"none"}
 * block 显示，none 隐藏
 * @param obj
 */
function pageAreaDisplayOption(obj) {
    $("#zjjdTable").css('display', obj.zjjdTable || 'none')
    $("#jdjdTable").css('display', obj.jdjdTable || 'none')
    $("#jcxxList").css("display", obj.jcxxList || 'none')
    $("#timeLine").css('display', obj.timeLine || 'none')
    $("#toolbar").css('display', obj.toolbar || 'none')
    $(".echarts-area").css('display', obj.echartsArea || 'none')
    $("#homeCharts").css('display', obj.echartsArea || 'none')
    $("#projectInfoAreaId").css('display', obj.echartsArea || 'none')
    $("#zjGLChartArea").css('display', obj.zjGLChart || 'none')
    $("#projectInfoBt").prop("checked", obj.projectInfo || false)

    $("#yxhcInfoBt").prop("checked", obj.yxhcInfoBt || false)
    $("#yxhcInfoArea").css("display", "none")

}


function timeLineLayer() {
    var checkDate = $("#timeLine div[class='time-item active']").data("layer")

    setLayerVisibility({
        layerYXALL: true,
        layer20150913: false,
        layer20161210: false,
        layerYX20162: false,
        layerYX201705: false,
        layerYX201706: false,
        layerYX201707: false,
        layerYX2017081: false,
        layerYX2017082: false,
        layerYX201709: false,
    })
    if ($("#box2017").prop("checked")) {
        queryYXInfo();// 查询影像数据
    }


    if (checkDate == '2015') {
        layer20150913.setVisibility(true)
    } else if (checkDate == '2016') {
        layer20161210.setVisibility(true)
        layerYX20162.setVisibility(true)
    } else if (checkDate == '201705') {
        layerYX201705G216.setVisibility(true)
        layerYX201705TWD.setVisibility(true)
    } else if (checkDate == '201706') {
        layerYX201706.setVisibility(true)
    } else if (checkDate == '201707') {
        layerYX201707.setVisibility(true)
    } else if (checkDate == '201708') {
        layerYX2017081.setVisibility(true)
        layerYX2017082.setVisibility(true)
    } else if (checkDate == '201709') {
        layerYX201709.setVisibility(true)
    }
}


$(document).ready(function () {
    // 资金进度
    $("#zjjdBt").click(function () {

        var nodes = zTreeObj.getSelectedNodes()
        var nodesDZ = zTreeObjDZ.getSelectedNodes()
        var nodesJS = zTreeObjJS.getSelectedNodes()
        if ( (nodes.length > 0 && nodes[0].id != 1 && nodes[0].id != 11 && nodes[0].id != 12 && nodes[0].id != 13)
            ||(nodesDZ.length > 0 && nodesDZ[0].id != 1 && nodesDZ[0].id != 11 && nodesDZ[0].id != 12 && nodesDZ[0].id != 13)
            || (nodesJS.length > 0 && nodesJS[0].id != 1 && nodesJS[0].id != 11 && nodesJS[0].id != 12 && nodesJS[0].id != 13)
        )
        {
            $("#leftSider").css("display", "block")
            $("#MainId").removeClass("col-md-12 col-sm-12").addClass("col-md-10 col-sm-10")
            vectorLayer.setVisibility(true)
            pageAreaDisplayOption({
                zjjdTable: "block",
                jdjdTable: "none",
                jcxxList: "none",
                timeLine: "none",
                zjGLChart: "block"
            })
            setLayerVisibility({
                layerYXALL: true,
                vectorLayer: true
            })
        } else {
            layer.msg("请选择一条公路后再点击")
        }
        echartsToggle('none')
    });
    // 节点进度
    $("#jdjdBt").click(function () {
        var nodes = zTreeObj.getSelectedNodes()
        var nodesDZ = zTreeObjDZ.getSelectedNodes()
        var nodesJS = zTreeObjJS.getSelectedNodes()
        // if (nodes.length > 0 && nodes[0].id != 1 && nodes[0].id != 11 && nodes[0].id != 12 && nodes[0].id != 13) {
        if ( (nodes.length > 0 && nodes[0].id != 1 && nodes[0].id != 11 && nodes[0].id != 12 && nodes[0].id != 13)
            ||(nodesDZ.length > 0 && nodesDZ[0].id != 1 && nodesDZ[0].id != 11 && nodesDZ[0].id != 12 && nodesDZ[0].id != 13)
            || (nodesJS.length > 0 && nodesJS[0].id != 1 && nodesJS[0].id != 11 && nodesJS[0].id != 12 && nodesJS[0].id != 13)
        )
        {
            $("#leftSider").css("display", "block")
            $("#MainId").removeClass("col-md-12 col-sm-12").addClass("col-md-10 col-sm-10")
            vectorLayer.setVisibility(true)
            pageAreaDisplayOption({zjjdTable: "none", jdjdTable: "block", jcxxList: "none", timeLine: "none"})
            setLayerVisibility({
                layerYXALL: true,
                vectorLayer: true
            })
        } else {
            layer.msg("请选择一条公路后再点击")
        }
        echartsToggle('none')
    });
    // 统计功能
    $("#tjgnBT").click(function () {
        pageAreaDisplayOption({
            zjjdTable: "none",
            jdjdTable: "none",
            jcxxList: "none",
            timeLine: "none",
            toolbar: "none",
            yxhcInfoBt: false
        })
        echartsToggle('block')

        /*$("#leftSider").css("display","none")
        $("#MainId").removeClass("col-md-10 col-sm-10").addClass("col-md-12 col-sm-12")

        $("#mapArea").removeClass("col-md-12 col-sm-12").addClass("col-md-8 col-sm-8")
        $("#echartArea").css("display","block")*/
        echartsResize()
        map.setCenter(new SuperMap.LonLat(87.40448, 43.87231), 0);
        $(".echarts-area").css("display", "none");
        setLayerVisibility({
            areaLayer:true,
            layerT: true,
        })
    });

    $("#yxBT").click(function () {
        pageAreaDisplayOption({
            zjjdTable: "none",
            jdjdTable: "none",
            jcxxList: "none",
            timeLine: "block",
            toolbar: "block",
            yxhcInfoBt: true
        })

        $("#isShowMarker").prop("checked", false)
        $("#isShowMarker").attr("disabled", false)
        $("#delMarkerBT").attr("disabled", false)
        $("#saveMarkerBT").attr("disabled", false)
        $("#cancelMarkerBT").attr("disabled", false)
        $("#plotContent").attr("disabled", false)
        initDatas()

        $("#box2015").prop("checked", true);
        $("#box2016").prop("checked", true);
        $("#box2017").prop("checked", false);

        $("#leftSider").css("display", "block")
        $("#MainId").removeClass("col-md-12 col-sm-12").addClass("col-md-10 col-sm-10")
        vectorLayer.removeAllFeatures();// 去除高亮
        vectorLayer.setVisibility(false)

        if ($("#box2017").prop("checked")) {
            queryYXInfo();// 查询影像数据
        }

        map.setCenter(new SuperMap.LonLat(87.40448, 43.87231), 5);

        setLayerVisibility({
            layerT: false,
            layerRoad: true,
            layerYXALL: true,
            layerZJRoad: true,
            layer20150913: false,
            layer20161210: false,
            layerYX20162: false,
            layerYX201705: false,
            layerYX201706: false,
            layerYX201707: false,
            layerYX2017081: false,
            layerYX2017082: false,
            layerYX201709: true,

            vectorLayer: true,
            layerGF2016WUYU: true,
            layerGJ2017WUYU: false
        })

        // 设置“查看影像信息”开关，必须在setLayerVisibility()方法后执行
        $("#timeListId").css('display', 'block')
        echartsToggle('none')
    })
    $("#timeListId").mouseleave(function () {
//                $("#timeListId").css('display', 'none')
    })
    $("#yxBT").mouseenter(function () {
//                $("#timeListId").css('display', 'block')
    })

    //进度审核
    $("#jdhcId").click(function () {
        pageAreaDisplayOption({
            zjjdTable: "none",
            jdjdTable: "none",
            jcxxList: "none",
            timeLine: "none",
            toolbar: "block"
        });

        initDatas()
        $("#jdhcCloseBt").prop("checked", true)
        $("#leftSider").css("display", "block")
        $("#MainId").removeClass("col-md-12 col-sm-12").addClass("col-md-10 col-sm-10")
        vectorLayer.removeAllFeatures();// 去除高亮
        map.setCenter(new SuperMap.LonLat(87.40448, 43.87231), 5);
        if ($("#box2017").prop("checked")) {
            queryYXInfo();// 查询影像数据
        }
        setLayerVisibility({
            layerT: false,
            layerRoad: true,
            layerYXALL: true,
            layerZJRoad: false,
            layer20150913: false,
            layer20161210: false,
            layer20170101: true,
            vectorLayer: true,
            layerJSJD: true,
            layerSar2017: false,
            layerJSJDTWD: true,
            markers: true,
        })
        $("#isShowMarker").attr("disabled", true)
        $("#isShowMarker").attr("disabled", true)
        $("#delMarkerBT").attr("disabled", true)
        $("#saveMarkerBT").attr("disabled", true)
        $("#cancelMarkerBT").attr("disabled", false)
        $("#plotContent").attr("disabled", true)
        map.events.unregister('click', layer, mapLayerClick);
        echartsToggle('none')
    })
    $("#jdhcCloseBt").change(function () {
        if ($("#jdhcCloseBt").prop("checked")) {
            layerJSJD.setVisibility(true)
            layerJSJDTWD.setVisibility(true)
        } else {
            layerJSJD.setVisibility(false)
            layerJSJDTWD.setVisibility(false)
        }
    })
    $("#isScanPicInfo").change(function () {
        if ($(this).prop("checked")) {
            drawPoint.activate();
        } else {
            deactiveAll()
        }
    })
    $("#isShowMarker").change(function () {
        if ($(this).prop("checked")) {
            map.events.register('click', layer, mapLayerClick);// 注册标注点击事件
            markers.setVisibility(true)
        } else {
            map.events.unregister('click', layer, mapLayerClick);
            markers.setVisibility(false)
            $(this).prop("checked", false);
        }
    })


    //点击时间轴上时间点
    $(".time-item").click(function () {
        console.log(this)
        $(".time-item").removeClass("active")
        $(this).addClass("time-item active")

        timeLineLayer()

    })

    // 点击时间轴
    $(".time-line-year").click(function () {
        var _re = $(".time-line-date").css("display")
        if (_re == undefined || _re == 'block' || _re == 'flex') {
            $(".time-line-date").css("display", "none")
            $(".yx-time-line").css("width", "auto")
            $(".time-line").hide()
            $(".time-line-year-area i").removeClass("fa-caret-left")
            $(".time-line-year-area i").addClass("fa-caret-right")
        } else {
            $(".time-line-date").css("display", "flex")
            $(".yx-time-line").css("width", "85%")
            $(".time-line").show()
            $(".time-line-year-area i").removeClass("fa-caret-right")
            $(".time-line-year-area i").addClass("fa-caret-left")
        }
    });
    $("#timeLine").initTimeLine({
        times: [
            "2015年",
            "2016年",
            "201705",
            "201706",
            "201707",
            "201708",
            "201709"
        ],
        activeIndex:6
    }, function (item) {
        console.log($(item).text())

        var checkDate = $(item).text().trim()

        setLayerVisibility({
            layerYXALL: true,
            layer20150913: false,
            layer20161210: false,
            layerYX20162: false,
            layerYX201705: false,
            layerYX201706: false,
            layerYX201707: false,
            layerYX2017081: false,
            layerYX2017082: false,
            layerYX201709: false,
        })
        if ($("#box2017").prop("checked")) {
            queryYXInfo();// 查询影像数据
        }
        if (checkDate == '2015年') {
            layer20150913.setVisibility(true)
        } else if (checkDate == '2016年') {
            layer20161210.setVisibility(true)
            layerYX20162.setVisibility(true)
        } else if (checkDate == '201705') {
            layerYX201705G216.setVisibility(true)
            layerYX201705TWD.setVisibility(true)
        } else if (checkDate == '201706') {
            layerYX201706.setVisibility(true)
        } else if (checkDate == '201707') {
            layerYX201707.setVisibility(true)
        } else if (checkDate == '201708') {
            layerYX2017081.setVisibility(true)
            layerYX2017082.setVisibility(true)
        } else if (checkDate == '201709') {
            layerYX201709.setVisibility(true)
        }


    })

});