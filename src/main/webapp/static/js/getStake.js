//通过SQL查询路由对象
function CreateRouteObj() {
    var queryParam, queryBySQLParams, queryBySQLService;
    queryParam = new SuperMap.REST.FilterParameter({
        name: "Routes@国省干道",
        attributeFilter: "ID='01deda1a-e0dc-49cf-83b5-4d62421c419b'"
//                attributeFilter: "XZQH=650502"
    });
    queryBySQLParams = new SuperMap.REST.QueryBySQLParameters({
        queryParams: [queryParam],
        startRecord:1,
        expectCount:10
    });
    queryBySQLService = new SuperMap.REST.QueryBySQLService(url1, {
        eventListeners: {
            "processCompleted": processCompleted,
            "processFailed": processFailed
        }
    });
    queryBySQLService.processAsync(queryBySQLParams);
}

//路由对象查询成功，初始化routeObj的值，同时将查询结果绘制在地图上
function processCompleted(queryEventArgs) {
    console.log("kkkkkkkkkk...........");
    console.log(queryEventArgs);
    var features = queryEventArgs.result.recordsets[0].features;

    // routeObj = geo = queryEventArgs.result.recordsets[0].features[0].geometry;
    var geo;
    for (var i = 0; i < features.length; i++) {
        routeObj = geo = features[i].geometry;
        //获取路由
        getStake(geo);
    }


    var feature = new SuperMap.Feature();
    feature.geometry = geo;
    feature.style = lineStyle;
    vectorLayer.addFeatures(feature);
    alert("查询路由对象成功");
}

//路由对象查询失败，显示提示信息
function processFailed() {
    alert("查询路由对象失败");
}

function getStake(geo) {
    var minM = geo.minM;
    var maxM = geo.maxM;
    var tempMinM;
    var count = 0;
    while (minM < maxM) {
        //
        RouteLocator(geo, minM, maxM);
        minM = minM + 1;
        /*if (tempMinM < maxM) {
            minM = tempMinM;
        }*/
        count++;
    }
    console.log(count)

}

//"路由定线"操作，其中将routeObj和里程值作为参数传递到参数对象中
function RouteLocator(routeObj, startM, endM) {
    /* if (feature != null) {
         vectorLayer.removeFeatures(feature);
         feature = null;
     }*/

    if (!routeObj) {
        alert("请通过查询获取路由对象！");
        return;
    }
    var routeLocatorParameters_point = new SuperMap.REST.RouteLocatorParameters({
        "sourceRoute": routeObj,
        "type": "LINE",
        "startMeasure": startM,
        "endMeasure": endM,
        "isIgnoreGap": true
    });
    var routeLocatorService = new SuperMap.REST.RouteLocatorService(url2,
        {
            eventListeners: {
                "processCompleted": function (e) {
                    // feature = new SuperMap.Feature.Vector();
                    var geometry = e.result.resultGeometry;
                    // feature.geometry = geometry;
                    // feature.style = lineStyle2;
                    // vectorLayer.addFeatures(feature);
                    console.log(e)
                    console.log(geometry)
                    console.log("里程定位线成功");

                    var components = geometry.components[0].components;
                    var startPoint, endPoint;
                    if (components.length > 0) {
                        startPoint = components[0];
                        endPoint = components[components.length-1];
                    }
                    console.log("startPoint=", startPoint)
                    console.log("endPoint=", endPoint)

                },
                'processFailed': routeLocatorFailed
            }
        }
    )
    routeLocatorService.processAsync(routeLocatorParameters_point);
}

//"里程定线"操作成功触发该函数，并显示提示信息
function routeLocatorCompleted(e) {
    console.log("123..")
    console.log(e)
    feature = new SuperMap.Feature.Vector();
    var geometry = e.result.resultGeometry;

    feature.geometry = geometry;
    feature.style = lineStyle2;
    vectorLayer.addFeatures(feature);
    alert("里程定位线成功");
}

//"里程定线"操作失败触发该函数，并显示提示信息
function routeLocatorFailed(e) {
    alert("里程定位线失败");
}