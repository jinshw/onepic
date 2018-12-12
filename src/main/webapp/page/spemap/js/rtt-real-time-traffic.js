$(function () {

    init();
})

var styleRed = {
    strokeColor: "#FF0D01",
    strokeWidth:2
    // fillColor: "#FF0D01",
    // fillOpacity: "0"
}
var styleYel = {
    strokeColor: "#F7FF01",
    strokeWidth: 2
    // strokeOpacity:"0.5",
    // fillOpacity: "0.5"
}
var styleGre = {
    strokeColor: "#67FF01",
    strokeWidth: 2
    // strokeOpacity:"0.5",
    // fillOpacity: "0.5"
}

function init() {
    //初始化显示框架大小
    initFrame();
    //初始化地图
    initMap();



}
function initRtt(){
    //查询实时路况信息
    // getRttMsg("650100","5");//乌鲁木齐市
    // getRttMsg("650200","5");//克拉玛依市
    // getRttMsg("650400","5");//吐鲁番市
    // getRttMsg("650500","5");//哈密市
    // getRttMsg("652300","5");//昌吉回族自治州
    // getRttMsg("652700","5");//博尔塔拉蒙古自治州
    // getRttMsg("652800","5");//巴音郭楞蒙古自治州
    // getRttMsg("652900","5");//阿克苏地区
    // getRttMsg("653000","5");//克孜勒苏柯尔克孜自治州
    // getRttMsg("653100","5");//喀什地区
    // getRttMsg("653200","5");//和田地区
    // getRttMsg("654000","5");//伊犁哈萨克自治州
    // getRttMsg("654200","5");//塔城地区
    // getRttMsg("654300","5");//阿勒泰地区

    getRttMsg("650100","1");//乌鲁木齐市
    getRttMsg("650200","1");//克拉玛依市
    getRttMsg("650400","1");//吐鲁番市
    getRttMsg("650500","1");//哈密市
    getRttMsg("652300","1");//昌吉回族自治州
    getRttMsg("652700","1");//博尔塔拉蒙古自治州
    getRttMsg("652800","1");//巴音郭楞蒙古自治州
    getRttMsg("652900","1");//阿克苏地区
    getRttMsg("653000","1");//克孜勒苏柯尔克孜自治州
    getRttMsg("653100","1");//喀什地区
    getRttMsg("653200","1");//和田地区
    getRttMsg("654000","1");//伊犁哈萨克自治州
    getRttMsg("654200","1");//塔城地区
    getRttMsg("654300","1");//阿勒泰地区

}

/**
 * 初始化显示框架大小
 */
function initFrame() {
    var allHeight = document.documentElement.clientHeight;
    // var allHeight =  window.screen.height;
    $(".page-container").height(allHeight);
}
var styleLayer = {
    strokeColor: "#304DBE",
    strokeWidth: 2,
    pointerEvents: "visiblePainted",
    fillColor: "#304DBE",
    fillOpacity: 0.8
};
var map,baseLayer,baseDsgsLayer,baseGsLayer,baseSdLayer,baseGdLayer,eventMarksLayer,rttLayer,rttLayerA,rttLayerN,rttLayerG,rttLayerY,rttLayerR,rttLayerH,zdLayerAll,rttMapLayer;

function initMap() {
    //初始化地图
    map = new SuperMap.Map("map", {
        minZoom: 0,
        maxZoom: 12,
        controls: [
            new SuperMap.Control.Zoom(),
            new SuperMap.Control.LayerSwitcher(),
            new SuperMap.Control.MousePosition(),
            new SuperMap.Control.Navigation({
                dragPanOptions: {
                    enableKinetic: true
                }
            })],
        allOverlays: true
    });
    //新建线矢量图层
    eventMarksLayer = new SuperMap.Layer.Markers("交通事件");
    rttLayerA = new SuperMap.Layer.Vector("整体路况", {renderers: ["Canvas2"]});
    //rttLayerA = new SuperMap.Layer.Graphics("整体路况");
    rttLayerN = new SuperMap.Layer.Vector("未知道路");
    rttLayerG = new SuperMap.Layer.Vector("通畅道路");
    rttLayerY = new SuperMap.Layer.Vector("缓慢道路");
    rttLayerR = new SuperMap.Layer.Vector("拥堵道路");
    rttLayerH = new SuperMap.Layer.Vector("高亮道路");
    zdLayerAll = new SuperMap.Layer.Markers("阻断信息");

    //初始化图层
    baseLayer = new SuperMap.Layer.TiledDynamicRESTLayer("蓝色地图", MAPURL.URL, {
        transparent: true,
        cacheEnabled: true
    });
    baseLayer.events.on({
        "layerInitialized": addBaseDsgsLayer
    });
    // baseDsgsLayer = new SuperMap.Layer.TiledDynamicRESTLayer("都市高速", MAPURL.RTT_DSGS_URL, {
    //     transparent: true,
    //     cacheEnabled: true
    // });
    // baseGsLayer = new SuperMap.Layer.TiledDynamicRESTLayer("高速", MAPURL.RTT_GS_URL, {
    //     transparent: true,
    //     cacheEnabled: true
    // });
    // baseSdLayer = new SuperMap.Layer.TiledDynamicRESTLayer("省道", MAPURL.RTT_SD_URL, {
    //     transparent: true,
    //     cacheEnabled: true
    // });
    // baseGdLayer = new SuperMap.Layer.TiledDynamicRESTLayer("国道", MAPURL.RTT_GD_URL, {
    //     transparent: true,
    //     cacheEnabled: true
    // });
    // rttBaseLayer.displayOutsideMaxExtent = true;
    // rttLayer.displayOutsideMaxExtent = true;

}

//加载图层
function addBaseDsgsLayer() {
    // 实时路况图
    baseDsgsLayer = new SuperMap.Layer.TiledDynamicRESTLayer("都市高速", MAPURL.RTT_DSGS_URL, {
        transparent: true,
        cacheEnabled: true
    });
    baseDsgsLayer.events.on({
        "layerInitialized": addBaseGsLayer
    });
}
//加载图层
function addBaseGsLayer() {
    // 实时路况图
    baseGsLayer = new SuperMap.Layer.TiledDynamicRESTLayer("高速", MAPURL.RTT_GS_URL, {
        transparent: true,
        cacheEnabled: true
    });
    baseGsLayer.events.on({
        "layerInitialized": addBaseSdLayer
    });
}
//加载图层
function addBaseSdLayer() {
    // 实时路况图
    baseSdLayer = new SuperMap.Layer.TiledDynamicRESTLayer("省道", MAPURL.RTT_SD_URL, {
        transparent: true,
        cacheEnabled: true
    });
    baseSdLayer.events.on({
        "layerInitialized": addBaseGdLayer
    });
}
//加载图层
function addBaseGdLayer() {
    // 实时路况图
    baseGdLayer = new SuperMap.Layer.TiledDynamicRESTLayer("国道", MAPURL.RTT_GD_URL, {
        transparent: true,
        cacheEnabled: true
    });
    baseGdLayer.events.on({
        "layerInitialized": addRttMapLayer
    });
}
//加载实时路况后端更新图层
function addRttMapLayer() {
    // 实时路况图
    rttMapLayer = new SuperMap.Layer.TiledDynamicRESTLayer("实时路况", MAPURL.RTT_MAP_URL, {
        transparent: true,
        cacheEnabled: true
    }, {bufferImgCount:0});//将bufferImgCount设置为0，不使用浏览器缓存（有可能是旧的缓存图层），编辑后，刷新图层，永远请求最新的图片
     rttMapLayer.events.on({
        "layerInitialized": addOtherLayer
    });
}
//加载其他图层
function addOtherLayer() {
    map.addLayers([
        baseLayer,
        //baseDsgsLayer,baseGsLayer,baseSdLayer,baseGdLayer,
        //rttLayerA,
        zdLayerAll,
        rttMapLayer
        //eventMarksLayer

    //rttLayerA, rttLayerN, rttLayerG,
        //rttLayerY, rttLayerR, rttLayerH
    ]);
    map.setCenter(new SuperMap.LonLat(85.92614, 41.49396), 2);//定位到新疆
    //map.setCenter(new SuperMap.LonLat(87.62614, 43.79396), 7);//定位到乌鲁木齐
    map.events.on({"changelayer":contZdLayer}); //添加监听事件

    //初始化阻断信息
    initZd();
    //初始化5分钟轮询一次阻断
    // var zdLoop = function(){
    //     removeZdLayerAll();
    //     //查询阻断信息
    //     initZd()();
    // }
    // setInterval(zdLoop,300000);

    //初始化实时路况
    //initRtt();
    //初始化5分钟轮询一次实时路况
    // var rttLoop = function(){
    //     removeRttLayerAll();
    //     //查询实时路况信息
    //     initRtt();
    // }
    // setInterval(rttLoop,300000);

    //调取后台实时路况地图
    initRttMap();
    //初始化5分钟轮询一次实时路况
    var rttMapLoop = function(){
        //removeRttLayerAll();
        //查询实时路况信息
        initRttMap();
    }
    setInterval(rttMapLoop,300000);
}
//获取市区实时路况信息
function contZdLayer(e) {
    // 刷新实时路况图
    //alert(e.layer.name);
    if(e.layer.name=="阻断信息"){
        if(!e.layer.visibility){
            hideInfoWin();
        }else{
            showInfoWin();
        }
    }
}
//获取市区实时路况信息
function initRttMap() {
    // 刷新实时路况图
    rttMapLayer.redraw();
    console.log("刷新了！");
}
//获取市区实时路况信息
function getRttMsg(areaCode,kindLevel) {
    $.ajax({
        url:"http://localhost:8081/onepic/rtt/getRttByAdcodeJson ",//这里通过设置url属性来获取xml
        type:"post",
        data:{'areaCode':areaCode,'kindLevel':kindLevel},
        dataType:"json",
        //timeout:60000,      //设定超时
        cache:false,       //禁用缓存
        //async: false,//同步
        success:function(resJson){//这里是解析xml
            console.log(resJson.state);
            if(resJson.state =="success"){
                console.log(areaCode+"地区："+"========================================");
                console.log("路况信息长度："+Object.keys(resJson.resultFlow).length);
                console.log("事件信息长度："+Object.keys(resJson.resultEvent).length);
                //根据重组道路实时路况信息，去渲染地图
                //rttFlowLayer(resJson.resultFlow);
                rttFlowLayerBatch(resJson.resultFlow);
                rttEventLayerBatch(resJson.resultEvent);
            }else{
                console.log(areaCode+"地区："+"========================================");
                console.log("异常信息："+resJson.result);
            }
        },
        error:function(data){
            console.log(areaCode+"地区："+"========================================");
            console.log("error信息："+data);
        }
    });
}

//实时路况信息绘图（批量绘图）
function rttFlowLayerBatch(resultFlow) {
    //var resultFlowOs =  new Array();

    var flag = 0;
    var los = 0;

    //var length  = Object.keys(resultFlow).length;
    //var ids =  new Array(length);
    var ids =  "(";
    $.each(resultFlow,function(id,value) {
        //ids.push(id);
        ids = ids +"'" + id +"',";
    });
    ids = ids + "'0')";
    queryRoadByIds(ids);

    function queryRoadByIds(ids) {
        var getFeatureParam1,getFeatureParam2,getFeatureParam3, getFeatureBySQLService, getFeatureBySQLParams;
        getFeatureParam = new SuperMap.REST.FilterParameter({
            //name: "R_一级道路@xinjiang20141202",
            attributeFilter: "ID IN " + ids
        });
        getFeatureBySQLParams = new SuperMap.REST.GetFeaturesBySQLParameters({
            queryParameter: getFeatureParam,
            fields:["ID"],
            fromIndex:0,
            toIndex:-1,
            //datasetNames:["xinjiang20141202:R_一级道路"]
            datasetNames:["road-rtt-xj:都市高速路_cx","road-rtt-xj:高速路_cx","road-rtt-xj:国道_cx","road-rtt-xj:省道_cx"]
            //datasetNames:["xinjiang20141202:R_一级道路","xinjiang20141202:R_二级道路","xinjiang20141202:R_三级道路","xinjiang20141202:R_四级道路","xinjiang20141202:R_五级道路"]
        });
        getFeatureBySQLService = new SuperMap.REST.GetFeaturesBySQLService(MAPURL.RTT_DATA_URL, {
            eventListeners: {"processCompleted": processCompletedFlow, "processFailed": processFailedFlow}});

        getFeatureBySQLService.processAsync(getFeatureBySQLParams);
    }
    function processCompletedFlow(getFeaturesEventArgs) {
        //console.log(los);
        // var p = null, len = null, features = null, feature = null, result = null;
        // result = getFeaturesEventArgs.result;
        var p, len, features, feature, result = getFeaturesEventArgs.result;
        if (result && result.features) {
            features = result.features;
            var lineArr = [];
            for (p=0, len=features.length; p<len; p++) {
                feature = features[p];

                $.each(resultFlow,function(id,value) {
                    if(id==feature.attributes.ID){
                        //查看flow中的los值
                        var los = value.los;
                        if(los=="1"){
                            //feature.style = styleGre;
                            var bezier5Vector = new SuperMap.Feature.Vector(feature.geometry,feature.attributes,styleGre);
                            //rttLayerA.addFeatures([bezier5Vector]);
                            lineArr.push(bezier5Vector);
                        }else if(los=="2"){
                            //feature.style = styleYel;
                            var bezier5Vector = new SuperMap.Feature.Vector(feature.geometry,feature.attributes,styleYel);
                            //rttLayerA.addFeatures([bezier5Vector]);
                            lineArr.push(bezier5Vector);
                        }else if(los=="3") {
                            //feature.style = styleRed;
                            var bezier5Vector = new SuperMap.Feature.Vector(feature.geometry,feature.attributes,styleRed);
                            //rttLayerA.addFeatures([bezier5Vector]);
                            lineArr.push(bezier5Vector);
                        }
                    }
                });

            }
            rttLayerA.addFeatures(lineArr);
            //rttLayerA.addGraphics(lineArr);
        }
    }
    function processFailedFlow(e) {
        console.log(e.error.errorMsg);
    }

}
//实时路况信息绘图（批量绘图）
function rttEventLayerBatch(resultEvent) {
    //var resultEventOs =  new Array();

    //var length  = Object.keys(resultEvent).length;
    //var ids =  new Array(length);
    var ids =  "(";
    $.each(resultEvent,function(id,value) {
        //ids.push(id);
        ids = ids +"'" + id +"',";
    });
    ids = ids + "'0')";
    queryRoadByIds(ids);

    function queryRoadByIds(ids) {
        var getFeatureParam1,getFeatureParam2,getFeatureParam3, getFeatureBySQLService, getFeatureBySQLParams;
        getFeatureParam = new SuperMap.REST.FilterParameter({
            //name: "R_一级道路@xinjiang20141202",
            attributeFilter: "ID IN " + ids
        });
        getFeatureBySQLParams = new SuperMap.REST.GetFeaturesBySQLParameters({
            queryParameter: getFeatureParam,fromIndex:0,toIndex:-1,
            //datasetNames:["xinjiang20141202:R_一级道路"]
            datasetNames:["road-rtt-xj:都市高速路_cx","road-rtt-xj:高速路_cx","road-rtt-xj:国道_cx","road-rtt-xj:省道_cx"]
            //datasetNames:["xinjiang20141202:R_二级道路"]
        });
        getFeatureBySQLService = new SuperMap.REST.GetFeaturesBySQLService(MAPURL.RTT_DATA_URL, {
            eventListeners: {"processCompleted": processCompletedEvent, "processFailed": processFailedEvent}});

        getFeatureBySQLService.processAsync(getFeatureBySQLParams);
    }
    function processCompletedEvent(getFeaturesEventArgs) {
        //console.log(los);
        //var p = null, len = null, features = null, feature = null, result = null;
        // var p, len, features, feature;
        // var result = getFeaturesEventArgs.result;
        var p, len, features, feature, result = getFeaturesEventArgs.result;
        if (result && result.features) {
            features = result.features;

            for (p=0, len=features.length; p<len; p++) {
                feature = features[p];

                $.each(resultEvent,function(id,value) {
                    if(id==feature.attributes.ID){
                        //查看flow中的los值
                        var reasonType = value.reasontype;
                        if(reasonType=="1"){
                            addMarker(feature,"1");
                        }else if(reasonType=="2"){
                            addMarker(feature,"2");
                        }else if(reasonType=="3") {
                            addMarker(feature,"3");
                        }else if(reasonType=="4") {
                            addMarker(feature,"4");
                        }else if(reasonType=="5") {
                            addMarker(feature,"5");
                        }
                    }
                });

            }
        }


    }
    function processFailedEvent(e) {
        console.log(e.error.errorMsg);
    }


}

//定义addMarker函数，触发layerInitialized事件会调用此函数
function addMarker(feature,iconObj) {
    var size = new SuperMap.Size(25, 25);
    var offset = new SuperMap.Pixel(-(size.w / 2), -size.h);
    var icon = new SuperMap.Icon('../img/rtt/'+iconObj+'.png', size, offset);

    var len = feature.geometry.components.length;
    var midLen = parseInt(len/2);
    var pointObj = feature.geometry.components[midLen];
    // console.log("点数："+len);
    var lon = null;
    var lat = null;
    // 获取弹框经纬坐标
    if(pointObj.x){
        lon=pointObj.x;
        lat=pointObj.y;
    }else{
        lon=pointObj.components[0].x;
        lat=pointObj.components[0].y;
    }
//初始化标记覆盖物类
    var marker = new SuperMap.Marker(new SuperMap.LonLat(lon, lat), icon);
//添加覆盖物到标记图层
    eventMarksLayer.addMarker(marker);
//注册 click 事件,触发 mouseClickHandler()方法
//     marker.events.on({
//         "click": mouseClickHandler,
//         "touchstart": mouseClickHandler //假如要在移动端的浏览器也实现点击弹框，则在注册touch类事件
//     });
}




//实时路况信息绘图（逐一绘图）
function rttFlowLayer(resultFlow) {
    resultFlowOs = resultFlow;

    var flag = 0;
    var los = 0;
    $.each(resultFlow,function(id,value) {
        // flag++;
        // if(flag==10){
        //     flag=0;
        //     queryRoadById(resultFlow);
        // }
        //los=value.los;
        queryRoadById(id);

    });
    function queryRoadById(id) {
        var getFeatureParam1,getFeatureParam2,getFeatureParam3, getFeatureBySQLService, getFeatureBySQLParams;
        getFeatureParam = new SuperMap.REST.FilterParameter({
            //name: "R_一级道路@xinjiang20141202",
            attributeFilter: "ID = '" + id + "'"
        });
        getFeatureBySQLParams = new SuperMap.REST.GetFeaturesBySQLParameters({
            queryParameter: getFeatureParam,
            //datasetNames:["xinjiang20141202:R_一级道路"]
            datasetNames:["road-rtt-xj:都市高速路_cx","road-rtt-xj:高速路_cx","road-rtt-xj:国道_cx","road-rtt-xj:省道_cx"]
        });
        getFeatureBySQLService = new SuperMap.REST.GetFeaturesBySQLService(MAPURL.URL_DATA, {
            eventListeners: {"processCompleted": processCompleted, "processFailed": processFailed}});

        getFeatureBySQLService.processAsync(getFeatureBySQLParams);
    }
    function processCompleted(getFeaturesEventArgs) {
        //console.log(los);
        var p, len, features, feature, result = getFeaturesEventArgs.result;
        if (result && result.features) {
            features = result.features;
            var lineArr = [];
            for (p=0, len=features.length; p<len; p++) {
                feature = features[p];

                $.each(resultFlowOs,function(id,value) {
                    if(id==feature.attributes.ID){
                        //查看flow中的los值
                        var los = value.los;
                        if(los=="1"){
                            //feature.style = styleGre;
                            var bezier5Vector = new SuperMap.Feature.Vector(feature.geometry,feature.attributes,styleGre);
                            //rttLayerA.addFeatures([bezier5Vector]);
                            lineArr.push(bezier5Vector);

                        }else if(los=="2"){
                            //feature.style = styleYel;
                            var bezier5Vector = new SuperMap.Feature.Vector(feature.geometry,feature.attributes,styleYel);
                            //rttLayerA.addFeatures([bezier5Vector]);
                            lineArr.push(bezier5Vector);
                        }else if(los=="3") {
                            //feature.style = styleRed;
                            var bezier5Vector = new SuperMap.Feature.Vector(feature.geometry,feature.attributes,styleRed);
                            //rttLayerA.addFeatures([bezier5Vector]);
                            lineArr.push(bezier5Vector);
                        }
                    }
                });

            }
            //rttLayerA.addFeatures(lineArr);
            rttLayerA.addGraphics(lineArr);
        }
    }
    function processFailed(e) {
        console.log(e.error.errorMsg);
    }


}
//实时事故信息绘图
function rttEventLayer(resultEvent) {

}
//清除图层数据
function removeRttLayerAll() {
    eventMarksLayer.removeMarker();
    rttLayer.removeAllFeatures();
    rttLayerA.removeAllFeatures();
    //zdLayerAll.removeMarker();
    //rttLayerA.removeAllGraphics();
    //rttLayerA.refresh();
}
//清除图层数据
function removeZdLayerAll() {
    zdLayerAll.removeMarker();

}









/**********************阻断信息*************************/
//获取阻断信息
function initZd() {
    getZd();
}
//获取阻断信息
function getZd() {
    $.ajax({
        url:"http://localhost:8081/onepic/rttZd/getRttZd",//这里通过设置url属性来获取xml
        type:"post",
        data:{},
        dataType:"json",
        //timeout:60000,      //设定超时
        cache:false,       //禁用缓存
        //async: false,//同步
        success:function(resMap){//这里是解析xml
            console.log(resMap.state);
            if(resMap.state =="success"){
                console.log("阻断："+"========================================");
                console.log("阻断信息长度："+Object.keys(resMap.result).length);
                //根据阻断信息信息，去渲染地图
                zdLayerBatch(resMap.result);

            }else{
                console.log("阻断："+"========================================");
                console.log("异常信息："+resMap.result);
            }
        },
        error:function(data){
            console.log("阻断："+"========================================");
            console.log("error信息："+data);
        }
    });
}
//实时路况信息绘图（批量绘图）
function zdLayerBatch(result) {
    //var resultFlowOs =  new Array();
    $.each(result,function(id,value) {
        var roadCode = value.roadcode;
        var roadCodeLen = roadCode.toString().length;
        var roadCode = roadCode.substring(0,roadCodeLen-6);
        //var xzqh = roadCode.substring(roadCodeLen-6,roadCodeLen);
        var blockedstart = parseInt(value.blockedstart);
        var blockedend = parseInt(value.blockedend);
        var roadZhPoint = (blockedstart+blockedend)/2;

        queryZdByIds(roadCode,roadZhPoint);
        function queryZdByIds(roadCode,roadZhPoint) {
            console.log("路线编码:"+roadCode+"|桩号范围内的点:"+roadZhPoint);
            var getFeatureParam1,getFeatureParam2,getFeatureParam3, getFeatureBySQLService, getFeatureBySQLParams;
            getFeatureParam = new SuperMap.REST.FilterParameter({
                //name: "R_一级道路@xinjiang20141202",
                attributeFilter: "(ROADCODE = '" + roadCode + "' and ROADENDS > " + roadZhPoint + " and ROADSTART < " + roadZhPoint +") or (ROADCODE = '" + roadCode + "' and ROADENDS < " + roadZhPoint + " and ROADSTART > " + roadZhPoint +")"
            });
            getFeatureBySQLParams = new SuperMap.REST.GetFeaturesBySQLParameters({
                queryParameter: getFeatureParam,
                //fields:["ID"],
                fromIndex:0,
                toIndex:-1,
                //datasetNames:["xinjiang20141202:R_一级道路"]
                datasetNames:["road-xj:Routes_gd","road-xj:Routes_sd","road-xj:Routes_gs"]
                //datasetNames:["xinjiang20141202:R_一级道路","xinjiang20141202:R_二级道路","xinjiang20141202:R_三级道路","xinjiang20141202:R_四级道路","xinjiang20141202:R_五级道路"]
            });
            getFeatureBySQLService = new SuperMap.REST.GetFeaturesBySQLService(MAPURL.ZD_DATA_URL, {
                eventListeners: {"processCompleted": processCompletedZd, "processFailed": processFailedZd}});

            getFeatureBySQLService.processAsync(getFeatureBySQLParams);
        }
        function processCompletedZd(getFeaturesEventArgs) {
            RouteLocator(getFeaturesEventArgs.result.features);
        }
        function processFailedZd(e) {
            console.log(e.error.errorMsg);
        }
        //"路由定点"操作，其中将routeObj和里程值作为参数传递到参数对象中
        function RouteLocator(features) {
            console.log("路由距离："+roadZhPoint);
            if(features!=null && features.length>0){
                var routeObj = features[0].geometry;
                if (routeObj==null) {
                    console.log("路由对象不存在！");
                    return;
                }
                var routeLocatorParameters_point = new SuperMap.REST.RouteLocatorParameters({
                    "sourceRoute":routeObj,
                    "type":"POINT",
                    "measure":parseFloat(roadZhPoint),
                    "offset":0,
                    "isIgnoreGap":true
                });
                var routeLocatorService = new SuperMap.REST.RouteLocatorService(MAPURL.ZD_ROUTES_URL,
                    {
                        eventListeners:{
                            "processCompleted":routeLocatorCompleted,
                            'processFailed':routeLocatorFailed
                        }
                    }
                )
                routeLocatorService.processAsync(routeLocatorParameters_point);
            }else{
                console.log("feature为空");
            }

        }

        //"里程定点"操作成功触发该函数，并显示提示信息
        function routeLocatorCompleted(e) {
            var featurePoint = new SuperMap.Feature.Vector();
            var geometry = e.result.resultGeometry;
            featurePoint.geometry = geometry;
            //feature.style = pointStyle;
            addZdMarker(featurePoint);
            //zdLayerAll.addFeatures(feature);
            console.log("里程定位点成功");
        }

        //"里程定点"操作失败触发该函数，并显示提示信息
        function routeLocatorFailed(e) {
            console.log("里程定位点失败");
        }


        //定义addMarker函数，触发layerInitialized事件会调用此函数
        function addZdMarker(feature) {
            var size = new SuperMap.Size(20, 15);
            var offset = new SuperMap.Pixel(-(size.w / 2), -size.h);
            var icon = null;
            var typeCode = value.typecode;
            //console.log("typeCode:"+typeCode);
            if(typeCode=="1"){
                icon = new SuperMap.Icon('../zdIcon/交通管制.png', size, offset);
            }else if(typeCode=="2"){
                icon = new SuperMap.Icon('../zdIcon/事故灾害.png', size, offset);
            }else if(typeCode=="3"){
                icon = new SuperMap.Icon('../zdIcon/施工占路.png', size, offset);
            }else if(typeCode=="4"){
                icon = new SuperMap.Icon('../zdIcon/社会安全事件.png', size, offset);
            }else if(typeCode=="5"){
                icon = new SuperMap.Icon('../zdIcon/交通流量.png', size, offset);
            }else if(typeCode=="6"){
                icon = new SuperMap.Icon('../zdIcon/自然灾害.png', size, offset);
            }else if(typeCode=="7"){
                icon = new SuperMap.Icon('../zdIcon/公共卫生.png', size, offset);
            }else if(typeCode=="8"){
                icon = new SuperMap.Icon('../zdIcon/其他.png', size, offset);
            }else if(typeCode=="9"){
                icon = new SuperMap.Icon('../zdIcon/大中修.png', size, offset);
            }
            var lon = null;
            var lat = null;
            if(feature.geometry.x != null && feature.geometry.x != "" && feature.geometry.y != null && feature.geometry.y != "" ){
                lon = feature.geometry.x;
                lat = feature.geometry.y;

            }else{
                cosole.log(roadCode+",没有获取正确坐标值！");
            }


            //初始化标记覆盖物类
            var marker = new SuperMap.Marker(new SuperMap.LonLat(lon,lat), icon);
            //添加覆盖物到标记图层
            zdLayerAll.addMarker(marker);
            //注册 click 事件,触发 mouseClickHandler()方法
            marker.events.on({
                "mousemove": mouseClickHandler,
                "mouseout": closeInfoWin,
                "touchstart": mouseClickHandler //假如要在移动端的浏览器也实现点击弹框，则在注册touch类事件
            });
            //只显示最新的3条
            if(id < 1){
                //flagOpen++;
                openInfoWin(lon,lat);
            }

        }
        function htmlPopCont(){
            var contentHTML = '<div class="container" style="max-width:320px;border-radius:3px;border: 1px solid #03D8FD;margin-top:0px;margin-left:-5px;font-size: 11px;color:#FFFFFF;background-color: rgba(0,0,0,0.2);">';
            contentHTML += '<div class="row" style="border-bottom: 1px solid #03D8FD;"><div class="col-lg-3"  style="color:#03D8FD; ">路线编号:</div>';
            contentHTML += '<div class="col-lg-9" >'+roadCode+'</div></div>';
            contentHTML += '<div class="row" style="border-bottom: 1px solid #03D8FD;"><div class="col-lg-3 " style="color:#03D8FD; ">路况标题:</div>';
            contentHTML += '<div class="col-lg-9" >'+value.infoname+'</div></div>';
            contentHTML += '<div class="row" style="border-bottom: 1px solid #03D8FD;"><div class="col-lg-3 " style="color:#03D8FD; ">阻断方向:</div>';
            contentHTML += '<div class="col-lg-3">'+value.direction+'</div>';
            contentHTML += '<div class="col-lg-3 " style="color:#03D8FD; ">阻断原因:</div>';
            contentHTML += '<div class="col-lg-3">'+value.reasoncontent+'</div></div>';
            contentHTML += '<div class="row"><div class="col-lg-3 " style="color:#03D8FD; ">发生时间:</div>';
            contentHTML += '<div class="col-lg-3">'+value.starttime.substring(0,10)+'</div>';
            if(value.endtime != null && value.endtime != "NaN/aN/aN aN:aN:aN" ){
                contentHTML += '<div class="col-lg-3 " style="color:#03D8FD; ">结束时间:</div>';
                contentHTML += '<div class="col-lg-3">'+value.endtime.substring(0,10)+'</div></div>';
            }else{
                contentHTML += '<div class="col-lg-3 " style="color:#03D8FD; ">结束时间:</div>';
                contentHTML += '<div class="col-lg-3"></div></div>';
            }
            contentHTML += '<div>';
            //contentHTML += '<div id="chicken_close" class="smPopupCloseBox" style="width: 17px; height: 17px; position: absolute; right: 12px; top: 6px;" onclick="javascript:closeInfoWin();"></div>';
            return contentHTML;
        }
        function openInfoWin(lon,lat){

            var contentHTML = htmlPopCont();
            //初始化popup类
            var popupInfo = new SuperMap.Popup(
                "chicken",
                //new SuperMap.LonLat(event.object.lonlat.lat,event.object.lonlat.lon),
                new SuperMap.LonLat(lon,lat),
                // new SuperMap.LonLat(pointObj.x,pointObj.y),
                new SuperMap.Size(300,170),
                contentHTML,
                false
            );
            popupInfo.autoSize=true;
            popupInfo.keepInMap=true;
            //popupInfo.setOpacity(0.4);
            popupInfo.setBackgroundColor("transparent");
            infowin = popupInfo;
            //添加弹窗到map图层
            map.addPopup(popupInfo);
        }
        function mouseClickHandler(event){
            closeInfoWin();
            var marker = this;
            var lonlat = marker.getLonLat();
            var contentHTML = htmlPopCont();
            //初始化popup类
            popup = new SuperMap.Popup(
                "chicken",
                //new SuperMap.LonLat(event.object.lonlat.lat,event.object.lonlat.lon),
                new SuperMap.LonLat(lonlat.lon,lonlat.lat),
                // new SuperMap.LonLat(pointObj.x,pointObj.y),
                new SuperMap.Size(300,170),
                contentHTML,
                false,
                null
            );
            popup.autoSize=true;
            popup.keepInMap=true;
            //popupInfo.setOpacity(0.4);
            popup.setBackgroundColor("transparent");
            infowin = popup;
            //添加弹窗到map图层
            map.addPopup(popup);
        }
    });




}

//定义mouseClickHandler函数，触发click事件会调用此函数
var infowin = null;

function closeInfoWin(){
    if(infowin){
        try{
            infowin.hide();
            infowin.destroy();
        }
        catch(e){}
    }
}
function hideInfoWin(){
    if(infowin){
        try{
            infowin.hide();
        }
        catch(e){}
    }
}
function showInfoWin(){
    if(infowin){
        try{
            infowin.show();
        }
        catch(e){}
    }
}














//拼接字符串
function PrefixInteger(num, length) {
    return (Array(length).join('0') + num).slice(-length);
}
