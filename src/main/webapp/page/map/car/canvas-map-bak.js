var map, layerChina;
var URL = "http://localhost:8090/iserver/services/map-xinjiang14/rest/maps/基础地图-蓝色";
var uploadedDataURL = "./demo15.json";
var canvas, context, mapDIV, styleClass;
window.onload = function () {
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

    mapDIV = document.getElementById('map')
    mapDIV.style.height = (document.documentElement.clientHeight  ) + 'px'

    //初始化地图
    map = new SuperMap.Map("map", {
        minZoom: 0,
        maxZoom: 11,
        allOverlays: true,
        controls: [
            new SuperMap.Control.Navigation(),
            new SuperMap.Control.Zoom(),
            new SuperMap.Control.LayerSwitcher(),
        ]
    });

    layerChina = new SuperMap.Layer.TiledDynamicRESTLayer("layerJSJDTWD", URL, {
        transparent: true,
        cacheEnabled: true
    });

    layerChina.events.on({
        "layerInitialized": function () {
            map.addLayers([layerChina]);

            //显示地图范围9732011.83931, 5440449.31251    85.782, 41.344
            map.setCenter(new SuperMap.LonLat(85.92614, 41.49396), 2);

            drawData2Canvas()

        }
    });

    //map canvas init
    initCanvas()

}

function initCanvas() {
    canvas = document.getElementById("canvas")
    canvas.width = mapDIV.offsetWidth
    canvas.height = mapDIV.offsetHeight
    context = canvas.getContext("2d")
    context.clearRect(0, 0, canvas.width, canvas.height)
    console.log("sdafsdf....")
    console.log(mapDIV.offsetWidth)
    console.log(mapDIV.offsetHeight)
}

/**
 * 经纬度转换为屏幕像素
 *
 * @param {Array.<number>} geoCoord  经纬度
 * @return {Array.<number>}
 * @public
 */
function geoCoord2Pixel(geoCoord) {
    var point = new SuperMap.LonLat(geoCoord[0], geoCoord[1]);
    var pos = map.getPixelFromLonLat(point);
    return [pos.x, pos.y];
}

/**
 * 屏幕像素转换为经纬度
 *
 * @param {Array.<number>} pixel  像素坐标
 * @return {Array.<number>}
 * @public
 */
function pixel2GeoCoord(pixel) {
    var point = map.getLonLatFromPixel({
        x: pixel[0],
        y: pixel[1]
    });
    return [point.lon, point.lat];
}

function drawCycle(point, r) {
    context.save()
    context.beginPath()
    context.fillStyle = styleClass
    context.strokeStyle = styleClass
    context.arc(point.x, point.y, r, 0, Math.PI * 2)
    context.stroke()
    context.closePath()
    context.restore()
}

function drawData2Canvas() {
    $.get(uploadedDataURL, function (data) {
        var outJson = "";
        var cc = 0;
        for (var i in data) {
            for (var j in data[i].coords) {
                cc = cc + 1;
                // console.log(data[i].coords[j])
                p = geoCoord2Pixel(data[i].coords[j])
                outJson = outJson + data[i].coords[j]+"\r\n";

                if (i % 2 == 1) {
                    styleClass = "#019f2d"
                } else {
                    styleClass = "red"
                }
                drawCycle({x: p[0], y: p[1]}, 0.4)
                // console.log(i,j)
            }
        }
        console.log(outJson)
    });
}

window.onresize = resizeCanvas;

function resizeCanvas() {
    initCanvas()
    drawData2Canvas()
}

$('#canvas').mousewheel(function (event) {
    console.log(event.deltaX, event.deltaY, event.deltaFactor);
    if (event.deltaY >= 1) {
        zoomin()
        resizeCanvas()
    } else {
        zoomout()
        resizeCanvas()
    }
});

function zoomout() {
    map.zoomOut()
}

function zoomin() {
    map.zoomIn()
}

