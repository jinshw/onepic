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
    document.getElementById('map').style.height = (document.documentElement.clientHeight - 60-24 ) + 'px'

    //初始化地图
    map = new SuperMap.Map("map", {
        minZoom: 0,
        maxZoom: 11,
        allOverlays: true,
        controls: [
            new SuperMap.Control.Navigation(),
            new SuperMap.Control.Zoom(),
            new SuperMap.Control.LayerSwitcher()
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
    layerJSJD = new SuperMap.Layer.TiledDynamicRESTLayer("jsjd", MAPURL.JSJD_URL, {
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

    //异步加载图层
    function addLayer() {
        map.addLayers([
            layerT,
            layerRoad, layerZJRoad]);

        map.setCenter(new SuperMap.LonLat(87.64226, 43.79469), 1);
    }

})
