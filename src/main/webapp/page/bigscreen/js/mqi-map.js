$(function () {
    initFrame();
    // initToolsListHeight();
})

/**
 * 初始化显示框架大小
 */
function initFrame() {
    var allHeight = document.documentElement.clientHeight;
    // var allHeight =  window.screen.height;
    $(".page-container").height(allHeight);
}


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
    initMap();
})

function initMap() {
    document.getElementById('map').style.height = (document.documentElement.clientHeight) + 'px'
    //初始化地图
    map = new SuperMap.Map("map", {
        minZoom: 0,
        maxZoom: 11,
        allOverlays: true,
        controls: [
            new SuperMap.Control.Navigation(),
            // new SuperMap.Control.Zoom(),
            // new SuperMap.Control.LayerSwitcher()
        ]
    });

    //初始化图层
    layerZTTBLUE = new SuperMap.Layer.TiledDynamicRESTLayer("ditu", MAPURL.ZTT_BLUE, {
        transparent: true,
        cacheEnabled: true
    });
    //监听图层信息加载完成事件
    layerZTTBLUE.events.on({
        "layerInitialized": addLayerMQI
    });

}
function addLayerMQI() {
    layerMQI = new SuperMap.Layer.TiledDynamicRESTLayer("MQI", MAPURL.MQI, {
        transparent: true,
        cacheEnabled: true
    });

    layerMQI.events.on({
        "layerInitialized": addLayer
    });
}

//异步加载图层
function addLayer() {
    map.addLayers([layerZTTBLUE,layerMQI]);
    map.setCenter(new SuperMap.LonLat(85.92614, 41.49396), 2);
}

function processFailed(e) {
    console.log(e)
    alert(e.error.errorMsg);
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
        shadeClose: false
    });
}

function zoomout() {
    map.zoomOut()
}

function zoomin() {
    map.zoomIn()
}
