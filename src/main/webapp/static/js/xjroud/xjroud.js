/**
 * Created by Administrator on 2017/7/10 0010.
 */
var infowin = null;
var map, layerT, layerRoad, layerYXALL, layerZJRoad, layerJSJD, layerJSJDTWD,
    layer20150913, layer20161210, layer20170101, layerGF2016WUYU, layerGJ2017WUYU,
    vectorLayer, layerPublic, layerSar2017, ponitLayer, drawPoint, markerlayer, marker, marker2,marker3,
//                host = document.location.toString().match(/file:\/\//) ? "http://localhost:8090" : 'http://' + document.location.host;
    host = "http://localhost:8090";
//        本地测试地址
url = host + "/iserver/services/map-xjsl3/rest/maps/新疆交通一张图";
var ROAD_URL = host + "/iserver/services/map-xjsl3/rest/maps/新疆交通道路"
//        var ZJ_ROAD = host + "/iserver/services/map-zaijiandaolu/rest/maps/GS_1_UTM45_1@test"
var ZJ_ROAD = host + "/iserver/services/map-zaijiandaolu2/rest/maps/GLZJ"
var XJ_YX_ALL = host + "/iserver/services/map-11jiyingxiang6102/rest/maps/新疆维吾尔自治区谷歌卫星_170609225420@11jiyingxiang610"
var YX_2015 = host + "/iserver/services/map-twd20163/rest/maps/GF2_PMS2_E87_9_N43_6_20160620_@tuwuda20161"
var YX_2016 = host + "/iserver/services/map-twd20162/rest/maps/GF2_PMS2_E87_9_N43_6_20160620_@tuwuda20161"
var YX_2017 = host + "/iserver/services/map-twd20162/rest/maps/GF2_PMS2_E87_9_N43_6_20160620_@tuwuda20161"
var JSJD_URL = host + "/iserver/services/map-jsjd/rest/maps/T500@jsjd"
var JSJD_URL_TWD = host + "/iserver/services/map-jsjdwukui/rest/maps/T500m@jsjdwukui"
var GF2016_WUYU_URL = host + "/iserver/services/map-G216_GJ/rest/maps/SV1_20170505_L1B0000071309_SV2@G216_GJ_1"
var GJ2017_WUYU_URL = host + "/iserver/services/map-G216_GJ/rest/maps/SV1_20170505_L1B0000071309_SV2@G216_GJ_1"
var YX_SL_2017 = host + "/iserver/services/map-yxsx2017/rest/maps/Export_Output_14@yxsx2017"
var SAR_2017 = host + "/iserver/services/map-G216_GJ/rest/maps/SV1_20170505_L1B0000071309_SV2@G216_GJ_1"

var DATA_URL = host + "/iserver/services/data-yxsx2017/rest/data"

//        服务器地址
//        url = host + "/iserver/services/map-WS_JSJT/rest/maps/JSGIST-GL";
//        var ROAD_URL = host + "/iserver/services/map-WS_JSJT/rest/maps/JSGIST-GL0"
//        var ZJ_ROAD = host + "/iserver/services/map-zaijiandaolu/rest/maps/GLZJ"
//        var XJ_YX_ALL = host + "/iserver/services/map-11jiyingxiang610/rest/maps/新疆影像地图"
//        var YX_2015 = host + "/iserver/services/map-wukui2015/rest/maps/WK2015@wukui2015"
//        var YX_2016 = host + "/iserver/services/map-twd2016/rest/maps/GF2_PMS2_E87_9_N43_6_20160620_@tuwuda20161"
//        var YX_2017 = host + "/iserver/services/map-twd2017/rest/maps/GF2_PMS1_E87_8_N43_6_20170323_@tuwuda20171"
//        var JSJD_URL = host + "/iserver/services/map-jsjd/rest/maps/T500@jsjd"

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
        minZoom: 2,
        maxZoom: 18,
        allOverlays: true,
        controls: [
            new SuperMap.Control.Navigation(),
            new SuperMap.Control.Zoom(),
            new SuperMap.Control.MousePosition(),
            new SuperMap.Control.LayerSwitcher(),
            drawPoint
        ]
    });

    //初始化图层
    layerT = new SuperMap.Layer.TiledDynamicRESTLayer("ditu", url, {
        transparent: true,
        cacheEnabled: true
    });


    //监听图层信息加载完成事件
    layerT.events.on({
        "layerInitialized": addLayer1
    });

    // 选择要素
    var callbacks = {
        click: function (currentFeature) {
            console.log("..............")
            console.log(currentFeature)
            var _html = getPopupMsg(currentFeature.attributes)
            layer.msg(_html);
            console.log("..............")
        }
    }
    vectorLayer = new SuperMap.Layer.Vector("vectorLayer");
    var selectFeature = new SuperMap.Control.SelectFeature(vectorLayer, {
        callbacks: callbacks
    })
    map.addControl(selectFeature);
    selectFeature.activate();


    // 标记层
    markerlayer = new SuperMap.Layer.Markers("markerLayer");
    // addData()
}
//添加数据
function addData() {
    markerlayer.removeMarker(marker);
    markerlayer.removeMarker(marker2);
    markerlayer.removeMarker(marker3);
    var size = new SuperMap.Size(44, 33);
    var offset = new SuperMap.Pixel(-(size.w / 2), -size.h);
    var icon = new SuperMap.Icon('../../static/images/marker.png', size, offset);
    marker = new SuperMap.Marker(new SuperMap.LonLat(-412961, 4418451), icon);
    marker2 = new SuperMap.Marker(new SuperMap.LonLat(-412135, 4418522), icon);
    markerlayer.addMarker(marker);
    markerlayer.addMarker(marker2);

    var _point = JSON.parse(getPointByLocation(-412961, 4418451,-412135, 4418522,-2))
    console.log(_point)
    marker3 = new SuperMap.Marker(new SuperMap.LonLat(_point.x, _point.y), icon);
    markerlayer.addMarker(marker3);
}


// 点控件查询
function drawCompleted(drawGeometryArgs) {
    var feature = new SuperMap.Feature.Vector();
    feature.geometry = drawGeometryArgs.feature.geometry,
        feature.style = style;
    ponitLayer.addFeatures(feature);

    var getFeatureParameter, getFeatureService;
    getFeatureParameter = new SuperMap.REST.GetFeaturesByBufferParameters({
        bufferDistance: 30,
        //attributeFilter: "SMID > 0",
        datasetNames: [
            "yxsx2017:Export_Output", "yxsx2017:Export_Output_2", "yxsx2017:Export_Output_3", "yxsx2017:Export_Output_4",
            "yxsx2017:Export_Output_5", "yxsx2017:Export_Output_6", "yxsx2017:Export_Output_7", "yxsx2017:Export_Output_8",
            "yxsx2017:Export_Output_9", "yxsx2017:Export_Output_10", "yxsx2017:Export_Output_11", "yxsx2017:Export_Output_12",
            "yxsx2017:Export_Output_13", "yxsx2017:Export_Output_14", "yxsx2017:Export_Output_15", "yxsx2017:Export_Output_16",
            "yxsx2017:Export_Output_17", "yxsx2017:Export_Output_18", "yxsx2017:Export_Output_19", "yxsx2017:Export_Output_20",
            "yxsx2017:Export_Output_21", "yxsx2017:Export_Output_22"
        ],
        returnContent: true,
        geometry: drawGeometryArgs.feature.geometry
    });
    getFeatureService = new SuperMap.REST.GetFeaturesByBufferService(DATA_URL, {
        eventListeners: {
            "processCompleted": processCompletedPoint,
            "processFailed": processFailed
        }
    });
    getFeatureService.processAsync(getFeatureParameter);
}

function processCompletedPoint(getFeaturesEventArgs) {
    var _feature = getFeaturesEventArgs.result.features[0]
    if (_feature != undefined) {
        var _attr = _feature.attributes
        var _label = "名称：" + _attr.IMG_NAME + "<br>"
            + "类型：" + _attr.LEIXING + "<br>"
            + "拍摄时间：" + _attr.TIME
        layer.msg(_label)
    }
}


function removeVectorLayer() {
    vectorLayer.removeAllFeatures();// 去除高亮
}


//异步加载图层
function addLayer() {
    map.addLayers([layerT, layerYXALL, layer20150913, layer20161210, layer20170101,
        layerGF2016WUYU, layerGJ2017WUYU, layerSar2017, layerRoad, layerZJRoad,
        layerJSJD, layerJSJDTWD, ponitLayer, vectorLayer, markerlayer]);

    //显示地图范围9732011.83931, 5440449.31251
    map.setCenter(new SuperMap.LonLat(597829.62986, 4794549.56123), 2.5);

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
        ponitLayer: false
    })


    useCanvas = layer20150913.useCanvas;
    //获取地图div的宽度
    var mapwidth = map.size.w,
        handle = document.getElementById("handle");
    //初始化卷帘的位置
    handle.style.left = mapwidth * 0.5 + "px";
    //初始化卷帘图层显示范围
    mapTop = "0px";
    mapButtom = map.size.h + "px";
    mapLeft = "0px";
    mapRightBack = mapwidth * 0.5;
    clip(mapwidth * 0.5);
    //卷帘不支持非Canvas图层，非Canvas图层需要手动实现卷帘
    //监听地图拖动事件
    if (!useCanvas) {
        map.events.on({
            "movestart": movestart,
            "move": move
        });
    }

}

function addLayer1() {
    layerRoad = new SuperMap.Layer.TiledDynamicRESTLayer("road", ROAD_URL, {
        transparent: true,
        cacheEnabled: true
    });
    layerRoad.events.on({
        "layerInitialized": addLayer2
    });
    // layerRoad.setOpacity(0.5);
}
function addLayer2() {
    layerZJRoad = new SuperMap.Layer.TiledDynamicRESTLayer("zjroad", ZJ_ROAD, {
        transparent: true,
        cacheEnabled: true
    });

    layerZJRoad.events.on({
        "layerInitialized": addLayer3
    });
    // layerRoad.setOpacity(0.5);
}
function addLayer3() {
    layerYXALL = new SuperMap.Layer.TiledDynamicRESTLayer("yxall", XJ_YX_ALL, {
        transparent: true,
        cacheEnabled: true
    });

    layerYXALL.events.on({
        "layerInitialized": addlayer20150913
    });
}
function addlayer20150913() {
    layer20150913 = new SuperMap.Layer.TiledDynamicRESTLayer("20150913", YX_2015, {
        transparent: true,
        cacheEnabled: true
    });

    layer20150913.events.on({
        "layerInitialized": addlayer20161210
    });
}
function addlayer20161210() {
    layerPublic = layer20161210 = new SuperMap.Layer.TiledDynamicRESTLayer("20161210", YX_2016, {
        transparent: true,
        cacheEnabled: true
    });

    layer20161210.events.on({
        "layerInitialized": addlayer20170101
    });
}
function addlayer20170101() {
    layer20170101 = new SuperMap.Layer.TiledDynamicRESTLayer("20170101", YX_2017, {
        transparent: true,
        cacheEnabled: true
    });

    layer20170101.events.on({
        "layerInitialized": addlayerJSJD
    });
}
function addlayerJSJD() {
    layerJSJD = new SuperMap.Layer.TiledDynamicRESTLayer("jsjd", JSJD_URL, {
        transparent: true,
        cacheEnabled: true
    });

    layerJSJD.events.on({
        "layerInitialized": addLayerGF2016WUYU
    });
}
function addLayerGF2016WUYU() {
    layerGF2016WUYU = new SuperMap.Layer.TiledDynamicRESTLayer("gf2016wuyu", GF2016_WUYU_URL, {
        transparent: true,
        cacheEnabled: true
    });

    layerGF2016WUYU.events.on({
        "layerInitialized": addLayerGJ2017WUYU
    });
}
function addLayerGJ2017WUYU() {
    layerGJ2017WUYU = new SuperMap.Layer.TiledDynamicRESTLayer("gj2017wuyu", GJ2017_WUYU_URL, {
        transparent: true,
        cacheEnabled: true
    });

    layerGJ2017WUYU.events.on({
        "layerInitialized": addLayerSar2017
    });
}
function addLayerSar2017() {
    layerSar2017 = new SuperMap.Layer.TiledDynamicRESTLayer("layerSar2017", SAR_2017, {
        transparent: true,
        cacheEnabled: true
    });

    layerSar2017.events.on({
        "layerInitialized": addLayerJSJDTWD
    });
}
function addLayerJSJDTWD() {
    layerJSJDTWD = new SuperMap.Layer.TiledDynamicRESTLayer("layerJSJDTWD", JSJD_URL_TWD, {
        transparent: true,
        cacheEnabled: true
    });

    layerJSJDTWD.events.on({
        "layerInitialized": addLayer
    });
}

var positionLayer, lat, lon, geolocate, baseLayer, c, b, leftStart = 0,
    topStart = 0,
    leftEnd = 0,
    topEnd = 0,
    mapTop, mapRight, mapButtom, mapLeft,
    useCanvas, mapRightBack, isFirstDrag = false,
    isZoom = false;

//使图层显示范围随着卷帘的拖动而变化
function clip(left) {
    mapRight = left + "px";
    //如果在缩放后直接拖动卷帘div，卷帘图层显示范围右侧数值需要进行修正
    if (isZoom && isFirstDrag) {
        mapRight = (left + leftEnd) + "px";
    }
    var rect = "rect(" + mapTop + "," + mapRight + "," + mapButtom + "," + mapLeft + ")";
//            layer20161210.div.style.clip = rect;
    layerPublic.div.style.clip = rect;
}
//拖动卷帘
function drag(e) {
    var objectDiv = document.getElementById("handle");
    //取消事件的默认行为
    e.preventDefault();
    if (document.all) { //鼠标捕获
        objectDiv.setCapture();
    }
    b = e.clientX - parseInt(objectDiv.style.left);
    //鼠标拖动
    document.onmousemove = function (d) {
        if (!d) d = event;
        c = (d.clientX - b);
        //使卷帘在地图内
        if (c > map.size.w - 7) {
            c = map.size.w - 7;
        }
        if (c < 0) {
            c = 0;
        }
        if (objectDiv) {
            objectDiv.style.left = c + "px";
            //如果使用非Canvas图层，在拖动地图后，再次拖动卷帘div，图层显示范围出错，这里修正图层显示范围右侧数值
            if (!useCanvas) {
                mapRightBack = c;
                c = c - leftEnd;
                isFirstDrag = true;
            }
            clip(c);
        }

    };
    //拖动完成后
    document.onmouseup = function () {
        if (document.all) {
            //释放鼠标捕获
            objectDiv.releaseCapture();
        }
        objectDiv = null;

    };
}
//地图drag，pan或者zoom操作开始时执行该函数，此时记录卷帘图层显示范围偏移量
function movestart(evt) {
    var me = this;
    var parsePos = parse(evt.element.childNodes[0].style.left, evt.element.childNodes[0].style.top);
    leftStart = parsePos.left;
    topStart = parsePos.top;
}
//地图drag，pan或者zoom操作开始后执行该函数，此时计算卷帘图层显示范围偏移量，如果没有进行缩放，计算偏移量后，设置卷帘图层left，top，right，bottom显示数值
//如果进行缩放，则left，top，bottom重置为默认值，right设置为当前卷帘div所在位置数值
function move(evt) {
    var me = this;
    if (!evt.zoomChanged) {
        isZoom = false;
        isFirstDrag = false;
        var parsePos = parse(evt.element.childNodes[0].style.left, evt.element.childNodes[0].style.top);
        leftEnd = parsePos.left;
        topEnd = parsePos.top;
        var dx = -(leftEnd - leftStart);
        var dy = -(topEnd - topStart);
        mapMoveClip(dx, dy);
    } else {
        isZoom = true;
        mapTop = "0px";
        mapRight = mapRightBack + "px";
        mapButtom = map.size.h + "px";
        mapLeft = "0px";
        var rect = "rect(" + mapTop + "," + mapRight + "," + mapButtom + "," + mapLeft + ")";
        layer.div.style.clip = rect;
    }
}
//设置非Canvas卷帘图层可见范围
function mapMoveClip(dx, dy) {
    var posString = layerT.div.style.clip.replace(/rect\(|\)|px/g, "");
    var pos = posString.split(" ");
    mapTop = (parseInt(pos[0]) + dy) + "px";
    mapRight = (parseInt(pos[1]) + dx) + "px";
    mapButtom = (parseInt(pos[2]) + dy) + "px";
    mapLeft = (parseInt(pos[3]) + dx) + "px";
    var rect = "rect(" + mapTop + "," + mapRight + "," + mapButtom + "," + mapLeft + ")";
    layerT.div.style.clip = rect;
    leftStart = leftEnd;
    topStart = topEnd;
}
//将传入的数值取整
function parse(left, top) {
    var left = left,
        top = top;
    if (left != undefined && top != undefined) {
        left = parseInt(left.replace(/px/g, ""));
        top = parseInt(top.replace(/px/g, ""));
    } else {
        left = 0;
        top = 0;
    }
    return {
        left: left,
        top: top
    };
}

function preTimeEvent() {

    var _index = parseInt($('#mapTime').data('layerindex'))
    var _oldObj = _layerImageList[_index]
    changeLayerYXTime(_oldObj.id, false)

    var _tempIndex = _index - 1
    if (_tempIndex < 0) {
        _tempIndex = 0
    }
    var _obj = _layerImageList[_tempIndex]
    $('#mapTime').val(_obj.time);
    $('#mapTime').data('layerindex', _tempIndex)
    changeLayerYXTime(_obj.id, true)
}

function nextTimeEvent() {

    var _index = parseInt($('#mapTime').data('layerindex'))
    var _oldObj = _layerImageList[_index]
    changeLayerYXTime(_oldObj.id, false)

    var _tempIndex = _index + 1
    if (_tempIndex >= _layerImageList.length) {
        _tempIndex = _layerImageList.length - 1
    }
    var _obj = _layerImageList[_tempIndex]
    $('#mapTime').val(_obj.time);
    $('#mapTime').data('layerindex', _tempIndex)
    changeLayerYXTime(_obj.id, true)

}

function changeLayerYXTime(id, isVisib) {
    if (id == 'layer20150913') {
        layer20150913.setVisibility(isVisib)
        layer20161210.setVisibility(!isVisib)
        layer20170101.setVisibility(!isVisib)
    } else if (id == 'layer20161210') {
        layer20150913.setVisibility(!isVisib)
        layer20161210.setVisibility(isVisib)
        layer20170101.setVisibility(!isVisib)
    } else if (id == 'layer20170101') {
        layer20150913.setVisibility(!isVisib)
        layer20161210.setVisibility(!isVisib)
        layer20170101.setVisibility(isVisib)
    }

}

// 图层显示和隐藏
function clickToolBarBT(e, id) {
    var _classNames = e.className
    if (_classNames.indexOf("active") == -1) { //不包含active
        e.className = 'item active'
        layerChange(id, true)
    } else {
        e.className = 'item'
        layerChange(id, false)
    }

}
function layerChange(id, isVisib) {
    if (id == 'yx') {
        layerYXALL.setVisibility(isVisib)

        layerT.setVisibility(!isVisib)
    } else {
        // layerYXALL.setVisibility(false)
        layerT.setVisibility(isVisib)
    }

}
//影像切换
function yxToggle() {
    $("#timeListId").toggle()
}
// 查询影像信息
function queryYXInfo() {
    // 查询影像面数据
    var queryParam, queryParamGS, queryParamGD, queryParamSD, queryBySQLParams, queryBySQLService;
    var queryParam1, queryParam2, queryParam3, queryParam4, queryParam5,
        queryParam6, queryParam7, queryParam8, queryParam9, queryParam10,
        queryParam11, queryParam12, queryParam13, queryParam14, queryParam15,
        queryParam16, queryParam17, queryParam18, queryParam19, queryParam20,
        queryParam21, queryParam22;
    queryParam1 = new SuperMap.REST.FilterParameter({
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
    });

    queryBySQLParams = new SuperMap.REST.QueryBySQLParameters({
        queryParams: [
            queryParam1, queryParam2, queryParam3, queryParam4, queryParam5,
            queryParam6, queryParam7, queryParam8, queryParam9, queryParam10,
            queryParam11, queryParam12, queryParam13, queryParam14, queryParam15,
            queryParam16, queryParam17, queryParam18, queryParam19, queryParam20, queryParam21, queryParam22
        ]
    });
    queryBySQLService = new SuperMap.REST.QueryBySQLService(YX_SL_2017, {
        eventListeners: {
            "processCompleted": function (queryEventArgs) {
                console.log(queryEventArgs)
                var _recordsets = queryEventArgs.result.recordsets
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
                }

            },
            "processFailed": processFailed
        }
    });
    queryBySQLService.processAsync(queryBySQLParams);
}

// 基本建设信息查询
function infoQuery() {
    $('#handle').css('display', 'none');//隐藏卷帘
    $("#leftSider").css("display", "block")
    $("#MainId").removeClass("col-md-12 col-sm-12").addClass("col-md-10 col-sm-10")
    vectorLayer.setVisibility(true)

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

function changeYXTime(e) {
    var _selectBoxs = $("input[class='yx-time']:checked")
    setLayerVisibility({
        layer20150913: false,
        layer20161210: false,
        layer20170101: false,
        layerGF2016WUYU: false,
        layerGJ2017WUYU: false
    })
    if ($("#box2017").prop("checked")) {
        queryYXInfo();// 查询影像数据
    }

    for (var i = 0; i < _selectBoxs.length; i++) {
        var _selId = $(_selectBoxs[i]).attr("id")
        if (_selId == 'box2015') {
            layer20150913.setVisibility(true)
        } else if (_selId == 'box2016') {
            layer20161210.setVisibility(true)
            layerGF2016WUYU.setVisibility(true)
        } else if (_selId == 'box2017') {
            layer20170101.setVisibility(true)
            layerGJ2017WUYU.setVisibility(true)
        } else if (_selId == '2017SAR') {
            layerSar2017.setVisibility(true)
        }
    }


    if (_selectBoxs.length >= 2) {
        $('#handle').css('display', 'block');//隐藏卷帘
        var _id = $(_selectBoxs[_selectBoxs.length - 1]).attr("id")
        if (_id == "box2015") {
        } else if (_id == "box2016") {
            layerPublic = layer20161210
        } else if (_id == "box2017") {
            layerPublic = layer20170101
        } else if (_id == "2017SAR") {
            layerPublic = layerSar2017
        }


    } else {
        $('#handle').css('display', 'none');//隐藏卷帘
    }
}
// 注销点控件
function deactiveAll() {
    drawPoint.deactivate();
    $("#isScanPicInfo").prop("checked", false);
}
// 设置图层显示
function setLayerVisibility(obj) {

    layerJSJD.setVisibility(false)
    layerJSJDTWD.setVisibility(false)
    layerGF2016WUYU.setVisibility(false)
    layerGJ2017WUYU.setVisibility(false)
    layerSar2017.setVisibility(false)
    ponitLayer.setVisibility(false)

    for (var key in obj) {
        if (key == 'layerT') {
            layerT.setVisibility(obj[key])
        } else if (key == 'layerRoad') {
            layerRoad.setVisibility(obj[key])
        } else if (key == 'layerYXALL') {
            layerYXALL.setVisibility(obj[key])
        } else if (key == 'layerZJRoad') {
            layerZJRoad.setVisibility(obj[key])
        } else if (key == 'layer20150913') {
            layer20150913.setVisibility(obj[key])
        } else if (key == 'layer20161210') {
            layer20161210.setVisibility(obj[key])
        } else if (key == 'layer20170101') {
            layer20170101.setVisibility(obj[key])
        } else if (key == 'vectorLayer') {
            vectorLayer.setVisibility(obj[key])
        } else if (key == 'layerJSJD') {
            layerJSJD.setVisibility(obj[key])
            layerJSJDTWD.setVisibility(obj[key])
        } else if (key == 'layerGF2016WUYU') {
            layerGF2016WUYU.setVisibility(obj[key])
        } else if (key == 'layerGJ2017WUYU') {
            layerGJ2017WUYU.setVisibility(obj[key])
        } else if (key == 'layerSar2017') {
            layerSar2017.setVisibility(obj[key])
        } else if (key == 'ponitLayer') {
            ponitLayer.setVisibility(obj[key])
        }
    }
}

$(document).ready(function () {

    $("#yxBT").click(function () {
        $("#timeListId").css('display', 'block')
        $('#handle').css('display', 'block')//显示卷帘
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

        map.setCenter(new SuperMap.LonLat(597829.62986, 4794549.56123), 5);

        setLayerVisibility({
            layerT: false,
            layerRoad: true,
            layerYXALL: true,
            layerZJRoad: true,
            layer20150913: true,
            layer20161210: true,
            layer20170101: false,
            vectorLayer: true,
            layerGF2016WUYU: true,
            layerGJ2017WUYU: false
        })
    })
    $("#timeListId").mouseleave(function () {
        $("#timeListId").css('display', 'none')
    })
    $("#yxBT").mouseenter(function () {
        $("#timeListId").css('display', 'block')
    })

    //进度审核
    $("#jdhcId").click(function () {
        $("#jdhcCloseBt").prop("checked", true)
        $('#handle').css('display', 'none')//显示卷帘
        $("#leftSider").css("display", "block")
        $("#MainId").removeClass("col-md-12 col-sm-12").addClass("col-md-10 col-sm-10")
        vectorLayer.removeAllFeatures();// 去除高亮
        map.setCenter(new SuperMap.LonLat(520677, 4866758.56123), 7);
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
            layerSar2017: false
        })
    })
    $("#jdhcId").mouseenter(function () {
        $("#jdhcBar").css('display', 'block')
    })
    $("#jdhcBar").mouseleave(function () {
        $("#jdhcBar").css('display', 'none')
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

    //点击时间轴
    $(".time-item").click(function () {
        console.log(this)
        $(".time-item").removeClass("active")
        $(this).addClass("time-item active")

    })

    // 点击年
    $(".time-line-year").click(function () {

        var _re = $(".time-line-date").css("display")
        if (_re == undefined || _re == 'block') {
            $(".time-line-date").css("display", "none")
            $(".yx-time-line").css("width", "auto")
            $(".time-line").hide()
            $(".time-line-year-area i").removeClass("fa-caret-left")
            $(".time-line-year-area i").addClass("fa-caret-right")
        } else {
            $(".time-line-date").css("display", "block")
            $(".yx-time-line").css("width", "100%")
            $(".time-line").show()
            $(".time-line-year-area i").removeClass("fa-caret-right")
            $(".time-line-year-area i").addClass("fa-caret-left")
        }
    });
});

/**
 * ztree 初始化
 */
var zTreeObj;
var style = {
    strokeColor: "red",
    strokeWidth: 5,
    fillOpacity: "1"
}
// zTree 的参数配置，深入使用请参考 API 文档（setting 配置详解）
var setting = {
    view: {
        showLine: false,
        selectedMulti: false
    },
    data: {
        simpleData: {
            enable: true,
            idKey: "id",
            pIdKey: "pId",
            rootPId: ""
        }
    },
    callback: {
//            beforeClick: beforeClick,
        onClick: onClick
    }
};
function onClick(event, treeId, treeNode) {
//        vectorLayer.removeAllFeatures();// 去除高亮
    vectorLayer.setVisibility(true)
    removeVectorLayer()
    deactiveAll();//注销点控件

    var feature;
    if (treeNode.gljb != undefined) {
        var queryParam, queryParamGS, queryParamGD, queryParamSD, queryBySQLParams, queryBySQLService;
        if (treeNode.gljb == 'GS') {
            queryParam = new SuperMap.REST.FilterParameter({
                name: "高速@交通#3#2"
            });
        } else if (treeNode.gljb == 'GD') {
            queryParam = new SuperMap.REST.FilterParameter({
                name: "一般国道@交通#2#4",
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
        queryBySQLService = new SuperMap.REST.QueryBySQLService(ZJ_ROAD, {
            eventListeners: {
                "processCompleted": function (queryEventArgs) {

                    feature = queryEventArgs.result.recordsets[0].features[0]
                    feature.style = style;
                    vectorLayer.addFeatures(feature);
                    map.zoomToExtent(feature.geometry.getBounds())

                    console.log("-----------")
                    ajaxRequest.getPointsByLocation({stakeName:feature.attributes.XMMC,location:5000}).then(function (data) {
                        console.log(data)
                        addData()
                    })
                    console.log("-----------")

                },
                "processFailed": processFailed
            }
        });
        queryBySQLService.processAsync(queryBySQLParams);
    }

}
vectorLayer = new SuperMap.Layer.Vector("Vector Layer");

var treeNodes = [
    {id: 1, pId: 0, name: "全部公路", open: true},
    {id: 11, pId: 1, name: "高速"},
    {id: 12, pId: 1, name: "国道"},
    {id: 13, pId: 1, name: "省道"}
];
var treeNodesSQL = [
    {id: 1, pId: 0, name: "全部公路", open: true},
    {id: 11, pId: 1, name: "高速"},
    {id: 12, pId: 1, name: "国道"},
    {id: 13, pId: 1, name: "省道"}
];

var gsFeatures = null;
var gdFeatures = null;
var sdFeatures = null;

$(function () {
    function autoHeight() {
        var winH = $(window).height();
        var footerH = $('.footerWrap').height();
        var headerH = $('.headerWrap').height();
        return winH - footerH - headerH;
    }

    $('.mapWrap').height(autoHeight());
    $(window).resize(function () {
        $('.mapWrap').height(autoHeight());
    });


    $('.mianNav>li').hover(function () {
        $(this).find('ul').show().parent().siblings().find('ul').hide();
    }, function () {
        $(this).find('ul').hide();
    });

    $('.js_drop').click(function () {
        $(this).find('p').toggle();
    });

    ajaxRequest.getRoud({}).then(function (data) {
        console.log(data.list)
        data.list.forEach(function (e, i) {
            if (e.roudtype == 'GS') {
                treeNodesSQL.push({
                    id: e.roudid,
                    pId: 11,
                    name: e.roudname,
                    smId: e.smid,
                    gljb: e.roudtype,
                    arrIndex: i
                })
            } else if (e.roudtype == 'GD') {
                treeNodesSQL.push({
                    id: e.roudid,
                    pId: 12,
                    name: e.roudname,
                    smId: e.smid,
                    gljb: e.roudtype,
                    arrIndex: i
                })
            } else if (e.roudtype == 'SD') {
                treeNodesSQL.push({
                    id: e.roudid,
                    pId: 13,
                    name: e.roudname,
                    smId: e.smid,
                    gljb: e.roudtype,
                    arrIndex: i
                })
            }
        })
        console.log("----------")
        console.log(treeNodesSQL)

        zTreeObj = $.fn.zTree.init($("#treeDemo"), setting, treeNodesSQL);

    })


    /*var queryParamGS, queryParamGD, queryParamSD, queryBySQLParams, queryBySQLService;
     queryParamGS = new SuperMap.REST.FilterParameter({
     name: "高速@交通#3#2"
     });
     queryParamGD = new SuperMap.REST.FilterParameter({
     name: "一般国道@交通#2#4"
     });
     queryParamSD = new SuperMap.REST.FilterParameter({
     name: "一般省道@交通#3"
     });
     queryBySQLParams = new SuperMap.REST.QueryBySQLParameters({
     queryParams: [queryParamGS, queryParamGD, queryParamSD],
     queryOption: "ATTRIBUTE"
     });
     queryBySQLService = new SuperMap.REST.QueryBySQLService(ZJ_ROAD, {
     eventListeners: {
     "processCompleted": processCompleted,
     "processFailed": processFailed
     }
     });
     queryBySQLService.processAsync(queryBySQLParams);*/

})


// 查询数据集处理
function processCompleted(queryEventArgs) {
    gsFeatures = queryEventArgs.result.recordsets[0].features
    gdFeatures = queryEventArgs.result.recordsets[1].features
    sdFeatures = queryEventArgs.result.recordsets[2].features
    var _obj = null;
    var _count = 0;
    for (var i = 0; i < gsFeatures.length; i++) {
        _obj = gsFeatures[i].attributes
        if (_obj.XMMC == 'G7大黄山至乌鲁木齐段改扩建工程') {
            if (_count == 0) {
                treeNodes.push({id: i + 2, pId: 11, name: _obj.XMMC, smId: _obj.SmID, gljb: _obj.GLJB, arrIndex: i})
            }
            _count = _count + 1;
        } else {
            treeNodes.push({id: i + 2, pId: 11, name: _obj.XMMC, smId: _obj.SmID, gljb: _obj.GLJB, arrIndex: i})
        }

    }
    for (var i = 0; i < gdFeatures.length; i++) {
        _obj = gdFeatures[i].attributes
        treeNodes.push({id: i + 200, pId: 12, name: _obj.XMMC, smId: _obj.SmID, gljb: _obj.GLJB, arrIndex: i})
    }
    for (var i = 0; i < sdFeatures.length; i++) {
        _obj = sdFeatures[i].attributes
        treeNodes.push({id: i + 300, pId: 13, name: _obj.XMMC, smId: _obj.SmID, gljb: _obj.GLJB, arrIndex: i})
    }

    zTreeObj = $.fn.zTree.init($("#treeDemo"), setting, treeNodes);
}
function processFailed(e) {
    alert(e.error.errorMsg);
}

/**
 * 数据初始化
 */

/**
 * [获取提示内容]
 * @param  {[type]} obj [properties属性]
 * @return {[type]}     [string]
 */
function getPopupMsg(obj) {
    var _tempTepl = _markerTepl
    _tempTepl = _tempTepl.replace("##name##", obj.XMMC)
        .replace("##mileage##", 200)
        // .replace("##mileage##", parseInt(obj.length))
        .replace("##startTime##", "2017-03-15")
        .replace("##endTime##", "2019-09-20")
        .replace("##jianjie##", "无")
        .replace("##actual##", obj.mileage)
    // .replace("##startTime##", obj.begin_User)
    // .replace("##endTime##", obj.end_User)
    // .replace("##jianjie##", obj.jianjie)
    // .replace("##actual##", obj.mileage)
    return _tempTepl
}

// 卫星影像数组
var _layerImageList = [{
    id: "layer20150913",
    time: "20150913",

}, {
    id: "layer20161210",
    time: "20161210",
}, {
    id: "layer20170101",
    time: "20170101",
}]

// marker 模板数据
var _markerTepl = '<div class="popup" style="color: #FFFFFF;font-size: 14px;">  ' +
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

//---------------------------
/**
 * 获取C点坐标点
 * @param x1 A点 经度
 * @param y1 A点 纬度
 * @param x2 B点 经度
 * @param y2 B点 纬度
 * @param k : CA/BC
 */
function getPointByLocation(x1, y1, x2, y2, k) {
    var obj = {}
    var a = (k*x2 + x1) / (1 + k)
    var b = (k*y2 + y1) / (1 + k)
    obj.x = a
    obj.y = b
    return JSON.stringify(obj)
}
