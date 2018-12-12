$(function () {
    initFrame();
    initToolsListHeight();
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

    // layerRoad = new SuperMap.Layer.TiledDynamicRESTLayer("road", MAPURL.ROAD_URL, {
    //     transparent: true,
    //     cacheEnabled: true
    // });
    layerZJRoad = new SuperMap.Layer.TiledDynamicRESTLayer("zjroad", MAPURL.ZJ_ROAD, {
        transparent: true,
        cacheEnabled: true
    });
    layerSFZ = new SuperMap.Layer.TiledDynamicRESTLayer("收费站", MAPURL.FSSS_SFZ, {
        transparent: true,
        cacheEnabled: true
    });
    layerFWQ = new SuperMap.Layer.TiledDynamicRESTLayer("服务区", MAPURL.FSSS_FWQ, {
        transparent: true,
        cacheEnabled: true
    });
    layerJYZ = new SuperMap.Layer.TiledDynamicRESTLayer("加油站", MAPURL.FSSS_JYZ, {
        transparent: true,
        cacheEnabled: true
    });
    layerTCQ = new SuperMap.Layer.TiledDynamicRESTLayer("停车区", MAPURL.FSSS_TCQ, {
        transparent: true,
        cacheEnabled: true
    });
    layerBRIDGE = new SuperMap.Layer.TiledDynamicRESTLayer("桥梁", MAPURL.FSSS_BRIDGE, {
        transparent: true,
        cacheEnabled: true
    });

    layerSFZ.displayOutsideMaxExtent = true;
    layerFWQ.displayOutsideMaxExtent = true;
    layerJYZ.displayOutsideMaxExtent = true;
    layerTCQ.displayOutsideMaxExtent = true;
    layerBRIDGE.displayOutsideMaxExtent = true;

    // 专题图
    layerZTTGREEN= new SuperMap.Layer.TiledDynamicRESTLayer("ZTT_GREEN", MAPURL.ZTT_GREEN, {
        transparent: true,
        cacheEnabled: true
    });
    layerZTTBLUE= new SuperMap.Layer.TiledDynamicRESTLayer("ZTT_BLUE", MAPURL.ZTT_BLUE, {
        transparent: true,
        cacheEnabled: true
    });
    layerZTTGRAY= new SuperMap.Layer.TiledDynamicRESTLayer("ZTT_GRAY", MAPURL.ZTT_GRAY, {
        transparent: true,
        cacheEnabled: true
    });
    layerZTTBAIDU= new SuperMap.Layer.TiledDynamicRESTLayer("ZTT_BAIDU", MAPURL.ZTT_BAIDU, {
        transparent: true,
        cacheEnabled: true
    });

    layerYXALL = new SuperMap.Layer.TiledDynamicRESTLayer("yxall", MAPURL.XJ_YX_ALL, {
        // transparent: true,
        cacheEnabled: true
    }, {format: "jpg"});
    layerYXALL.events.on({
        "layerInitialized": addLayer
    });

    areaLayer = new SuperMap.Layer.Vector("区域面积高亮");

    //异步加载图层
    function addLayer() {
        map.addLayers([
            layerT,
            layerYXALL, layerZJRoad,
            layerSFZ, layerFWQ,
            layerJYZ, layerTCQ, layerBRIDGE,
            layerZTTGREEN,layerZTTBLUE,layerZTTGRAY,layerZTTBAIDU,
            vectorLayer, lineLayer, areaLayer]);

        map.setCenter(new SuperMap.LonLat(85.92614, 41.49396), 2);
        // map.setCenter(new SuperMap.LonLat(87.64226, 43.79469), 2);
    }


    // 选择要素
    var callbacks = {
        click: function (currentFeature) {
            var _html = getPopupMsg(currentFeature.attributes)
            // layer.msg(_html);
            layer.open({
                type: 0
                , content: _html
                // , anim: 'up'
                // , style: 'position:fixed; bottom:0; left:0; width: 400px; height: 200px; padding:10px 0; border:none;'
            });
            // layer.msg(_html)
        }
    }
    vectorLayer = new SuperMap.Layer.Vector("vectorLayer");
    var selectFeature = new SuperMap.Control.SelectFeature(vectorLayer, {
        callbacks: callbacks
    })
    map.addControl(selectFeature);
    selectFeature.activate();

    /* // 搜索事件
     $("#searchBtn").click(function () {
         var searchContent = $.trim($("#searchInput").val())
         console.log(searchContent)
         queryRoad(searchContent)

     })*/
    layerYXALL.setVisibility(false);

    setLayerVisibilityJTZT({});
    setLayerVisibilityZTT({});
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

function leftToolsHide() {
    $("#leftToolsBar").hide(500)
    $("#leftToolsBt").show(500)

}

function leftToolsShow() {
    $("#leftToolsBar").show(500)
    $("#leftToolsBt").hide(500)
}

/**
 * 初始化项目数据显示高度
 */
function initToolsListHeight() {
    var _height = document.documentElement.clientHeight;
    var _otherHeight = $(".tools-list-search").width();

    var _maxHeight = _height - _otherHeight - 37 * 3;
    $("#gsULTBJ").css("max-height", _maxHeight + "px")
    $("#gdULTBJ").css("max-height", _maxHeight + "px")
    $("#sdULTBJ").css("max-height", _maxHeight + "px")

    $("#gsULDZJ").css("max-height", _maxHeight + "px")
    $("#gdULDZJ").css("max-height", _maxHeight + "px")
    $("#sdULDZJ").css("max-height", _maxHeight + "px")

    $("#gsULJSBT").css("max-height", _maxHeight + "px")
    $("#gdULJSBT").css("max-height", _maxHeight + "px")
    $("#sdULJSBT").css("max-height", _maxHeight + "px")
}

function setLayerVisibilityJTZT(obj) {
    layerSFZ.setVisibility(obj["layerSFZ"] || false)
    layerFWQ.setVisibility(obj["layerFWQ"] || false)
    layerJYZ.setVisibility(obj["layerJYZ"] || false)
    layerTCQ.setVisibility(obj["layerTCQ"] || false)
    layerBRIDGE.setVisibility(obj["layerBRIDGE"] || false)
}

function setLayerVisibilityDT(obj) {
    layerT.setVisibility(obj["layerT"] || false);
    layerYXALL.setVisibility(obj["layerYXALL"] || false);
}

// 专题图隐藏显示设置
function setLayerVisibilityZTT(obj) {
    layerZJRoad.setVisibility(obj["layerZJRoad"] || false);
    layerZTTGREEN.setVisibility(obj["layerZTTGREEN"] || false);
    layerZTTBLUE.setVisibility(obj["layerZTTBLUE"] || false);
    layerZTTGRAY.setVisibility(obj["layerZTTGRAY"] || false);
    layerZTTBAIDU.setVisibility(obj["layerZTTBAIDU"] || false);
}

function setLayerVisibilityALL(obj) {
    setLayerVisibilityDT(obj);
    setLayerVisibilityZTT(obj);
    setLayerVisibilityJTZT(obj);
}