var host = window.isLocal ? window.server : "http://localhost:8090";
var map, url = host + "/iserver/services/map-zhdt/rest/maps/综合地图";
var imageLayer = null;
var canvas = document.getElementById("drawing")
var context = canvas.getContext("2d")
var aPoint = [34.2708359516, 73.4655761719]
var bPoint = [39.2708359516, 80.4655761719]
var cPoint = [44.2708359516, 87.4655761719]
var dPoint = [49.2678045506, 96.4599609375]

var ePoint = [aPoint[0], cPoint[1]]
var fPoint = [bPoint[0], dPoint[1]]
var gPoint = [cPoint[0], aPoint[1]]
var hPoint = [dPoint[0], bPoint[1]]

var requestPoints = [
    {
        _northEast: {lat: bPoint[0], lng: bPoint[1]},
        _southWest: {lat: aPoint[0], lng: aPoint[1]}
    },
    {
        _northEast: {lat: cPoint[0], lng: cPoint[1]},
        _southWest: {lat: bPoint[0], lng: bPoint[1]}
    },
    {
        _northEast: {lat: dPoint[0], lng: dPoint[1]},
        _southWest: {lat: cPoint[0], lng: cPoint[1]}
    },

    {
        _northEast: {lat: fPoint[0], lng: fPoint[1]},
        _southWest: {lat: ePoint[0], lng: ePoint[1]}
    },
    {
        _northEast: {lat: fPoint[0], lng: fPoint[1]},
        _southWest: {lat: cPoint[0], lng: cPoint[1]}
    },
    {
        _northEast: {lat: ePoint[0], lng: ePoint[1]},
        _southWest: {lat: bPoint[0], lng: bPoint[1]}
    },

    {
        _northEast: {lat: hPoint[0], lng: hPoint[1]},
        _southWest: {lat: gPoint[0], lng: gPoint[1]}
    },
    {
        _northEast: {lat: hPoint[0], lng: hPoint[1]},
        _southWest: {lat: cPoint[0], lng: cPoint[1]}
    },
    {
        _northEast: {lat: gPoint[0], lng: gPoint[1]},
        _southWest: {lat: bPoint[0], lng: bPoint[1]}
    }
]


map = L.map('map', {
    crs: L.CRS.EPSG4326,
    center: [42.5463, 86.0553],
    maxZoom: 15,
    zoom: 5
});
L.supermap.tiledMapLayer(url).addTo(map);

// use event
var mypop = L.popup();
map.on('click', function (e) {
    // var content = '你临幸了这个点：<br>';
    // content += e.latlng.toString();
    // mypop.setLatLng(e.latlng)
    //     .setContent(content)
    //     .openOn(map);
    console.log("当前点击坐标点为==", e.latlng.toString(), e)
    console.log("latLngToLayerPoint==", map.latLngToLayerPoint(e.latlng))
    console.log("latLngToContainerPoint==", map.latLngToContainerPoint(e.latlng))
    console.log("project==", map.project(e.latlng, map.getZoom()))
    console.log(".......start..........")
    var bounds = map.getBounds()
    console.log("bounds==", bounds);
    console.log("latLngToLayerPoint==", bounds["_northEast"], map.latLngToLayerPoint(bounds["_northEast"]));
    console.log("bounds--latLngToContainerPoint==_northEast", bounds["_northEast"], map.latLngToContainerPoint(bounds["_northEast"]));
    console.log("bounds--latLngToContainerPoint==_southWest", bounds["_southWest"], map.latLngToContainerPoint(bounds["_southWest"]));
    console.log("getSize==", map.getSize());
    console.log("getPixelBounds==", map.getPixelBounds());
    console.log("getPixelOrigin==", map.getPixelOrigin());
    console.log(".......end..........")

    var point = e.containerPoint
    // var point = e.layerPoint
    var canvas = document.getElementById("drawing")
    var context = canvas.getContext("2d")
    var xy = map.getSize()
    canvas.width = xy.x
    canvas.height = xy.y
    // context.save()
    // context.beginPath()
    // context.strokeStyle = "red"
    // context.fillStyle = "red"
    // widthHeight = 15
    // // context.rect(point.x, point.y, 4, 4)
    // context.fillRect(point.x, point.y, widthHeight, widthHeight)
    // context.stroke()
    // context.fill()
    // context.closePath()


    var _southWestPoint = map.latLngToContainerPoint([34.2708359516, 73.4655761719])
    // var _southWestPoint = map.latLngToContainerPoint([bounds["_southWest"]["lat"], bounds["_southWest"]["lng"]])
    context.save()
    context.beginPath()
    context.strokeStyle = "red"
    context.fillStyle = "red"
    widthHeight = 15
    // context.rect(point.x, point.y, 4, 4)
    context.arc(_southWestPoint.x, _southWestPoint.y, 20, 0, Math.PI * 2)
    // context.fillRect(_southWestPoint.x, _southWestPoint.y, widthHeight, widthHeight)
    context.stroke()
    context.fill()
    context.closePath()
    var _northEastPoint = map.latLngToContainerPoint([49.2678045506, 96.4599609375])
    // var _northEastPoint = map.latLngToContainerPoint([bounds["_northEast"]["lat"], bounds["_northEast"]["lng"]])
    context.save()
    context.beginPath()
    context.strokeStyle = "red"
    context.fillStyle = "red"
    widthHeight = 15
    // context.rect(point.x, point.y, 4, 4)
    context.arc(_northEastPoint.x, _northEastPoint.y, 20, 0, Math.PI * 2)
    // context.fillRect(_northEastPoint.x, _northEastPoint.y, widthHeight, widthHeight)
    context.stroke()
    context.fill()
    context.closePath()


    for (var index in requestPoints) {
        var tempPoint = requestPoints[index]

        context.save()
        context.beginPath()
        context.strokeStyle = "red"
        context.fillStyle = "red"
        widthHeight = 15
        // context.rect(point.x, point.y, 4, 4)
        var _southWestPoint = map.latLngToContainerPoint([tempPoint._southWest.lat, tempPoint._southWest.lng])
        context.arc(_southWestPoint.x, _southWestPoint.y, 20, 0, Math.PI * 2)
        context.stroke()
        context.fill()
        context.closePath()

        context.save()
        context.beginPath()
        context.strokeStyle = "red"
        context.fillStyle = "red"
        widthHeight = 10
        // context.rect(point.x, point.y, 4, 4)
        var _northEastPoint = map.latLngToContainerPoint([tempPoint._northEast.lat, tempPoint._northEast.lng])
        context.arc(_northEastPoint.x, _northEastPoint.y, 20, 0, Math.PI * 2)
        context.stroke()
        context.fill()
        context.closePath()

        // getRadarRain2H({
        //     startLat: tempPoint._northEast.lat, startLon: tempPoint._northEast.lng,
        //     endLat: tempPoint._southWest.lat, endLon: tempPoint._southWest.lng,
        //     width: xy.x, height: xy.y,
        //     bounds: bounds
        // })
    }

    //取得图像的数据 URI
    var imgURI = drawing.toDataURL("image/png");
    //显示图像
    var image = document.createElement("img");
    image.src = imgURI;

    document.body.appendChild(image);
    var imageBounds = [[bounds["_northEast"]["lat"], bounds["_northEast"]["lng"]], [bounds["_southWest"]["lat"], bounds["_southWest"]["lng"]]]
    L.imageOverlay(image.src, imageBounds).addTo(map);


});


map.on("zoomend", function (e) {
    var zoom = map.getZoom();  //获取当前地图的缩放级别
    console.log(zoom);
    var bounds = map.getBounds()
    // console.log("bounds==", bounds);
    // console.log("latLngToLayerPoint==", bounds["_northEast"], map.latLngToLayerPoint(bounds["_northEast"]));
    // console.log("getSize==", map.getSize());
    // console.log("getPixelBounds==", map.getPixelBounds());
    // console.log("getPixelOrigin==", map.getPixelOrigin());
})


function drawingImage(obj) {
    console.log("obj---", obj)
    // var canvas = document.getElementById("drawing")
    // var context = canvas.getContext("2d")
    canvas.width = obj.width
    canvas.height = obj.height
    // context.clearRect(0, 0, canvas.width, canvas.height)
    context.globalAlpha = 0.6
    //确定浏览器支持<canvas>元素
    if (drawing.getContext) {
        for (var i in obj.heatDatas) {
            var latlon = obj.heatDatas[i]
            var point = map.latLngToContainerPoint([latlon[1], latlon[0]])
            context.save()
            context.beginPath()
            context.strokeStyle = getFillStyle(latlon[2])
            context.fillStyle = getFillStyle(latlon[2])
            widthHeight = getZoomToRenderWidth()
            // context.rect(point.x, point.y, 4, 4)
            context.fillRect(point.x, point.y, widthHeight, widthHeight)
            context.stroke()
            context.fill()
            context.closePath()
        }

        // var aPointLat = obj.latlngs.startLat
        // var aPointLon = obj.latlngs.startLon
        // var cPointLat = obj.latlngs.endLat
        // var cPointLon = obj.latlngs.endLon
        // var aPoint = map.latLngToContainerPoint([aPointLat, aPointLon])
        // var cPoint = map.latLngToContainerPoint([cPointLat, cPointLon])
        // context.save()
        // context.beginPath()
        // context.strokeStyle = "green"
        // context.fillStyle = "green"
        // context.arc(aPoint.x, aPoint.y, 30, 0, Math.PI * 2)
        // context.stroke()
        // context.fill()
        // context.closePath()
        //
        //
        // context.save()
        // context.beginPath()
        // context.strokeStyle = "green"
        // context.fillStyle = "green"
        // context.arc(cPoint.x, cPoint.y, 30, 0, Math.PI * 2)
        // context.stroke()
        // context.fill()
        // context.closePath()

        //取得图像的数据 URI
        var imgURI = drawing.toDataURL("image/png");
        //显示图像
        var image = document.createElement("img");
        image.src = imgURI;
        // downLoad(imgURI);
        document.body.appendChild(image);

        // var imageBounds = [[aPointLat, aPointLon], [cPointLat, cPointLon]]
        var imageBounds = [[obj.bounds["_northEast"]["lat"], obj.bounds["_northEast"]["lng"]], [obj.bounds["_southWest"]["lat"], obj.bounds["_southWest"]["lng"]]]
        console.log("imageBounds===", imageBounds)
        // L.imageOverlay(image.src, imageBounds).addTo(map);
        // if (imageLayer != null) {
        //     map.removeLayer(imageLayer)
        // }
        imageLayer = L.imageOverlay(image.src, imageBounds)
        imageLayer.addTo(map)

    }

}

/**
 * @author web得胜
 * @param {String} url 需要下载的文件地址
 * */
function downLoad(url) {
    var oA = document.createElement("a");
    oA.download = '';// 设置下载的文件名，默认是'下载'
    oA.href = url;
    document.body.appendChild(oA);
    oA.click();
    oA.remove(); // 下载之后把创建的元素删除
}


function getFillStyle(value) {
    var result = ""
    if (value >= 0 && value <= 10) {
        result = "#A5F38E";
    } else if (value >= 10 && value <= 25) {
        result = "#32AE00";
    } else if (value >= 25 && value <= 50) {
        result = "#62BBFD";
    } else if (value >= 50 && value <= 100) {
        result = "#0002F7";
    } else if (value >= 100) {
        result = "#F906F8";
    }
    return result;
}

function getZoomToRenderWidth() {
    var zoom = map.getZoom()
    var result = 3;
    if (zoom == 7) {
        result = 3;
    } else if (zoom == 8) {
        result = 5;
    } else if (zoom == 9) {

    } else if (zoom == 10) {

    } else if (zoom == 11) {

    } else if (zoom == 12) {

    }
    return result;
}


// var imageUrl = 'http://www.lib.utexas.edu/maps/historical/newark_nj_1922.jpg',
//     imageBounds = [[42.9725015860,81.4526367188], [43.3411600541,87.6489257813]];
// L.imageOverlay(imageUrl, imageBounds,{
//     opacity:1
// }).addTo(map);
//
//  //标记点
//  L.marker(imageBounds[0]).addTo(map);
//  L.marker(imageBounds[1]).addTo(map);


$(function () {
    var latlons = [[75.5419921875, 37.0551771067], [81.1230468750, 44.4337798461]]

    $("#getRadarNum").click(function () {
        getRain(latlons)
    })


    $("#getOne").click(function () {
        var startTime = moment().subtract(20, 'minutes').format("YYYYMMDDHHmm")
        var endTime = moment().subtract(1, 'minutes').format("YYYYMMDDHHmm")
        // var startTime = "201909091450"
        // var endTime = "201909091455"
        $.ajax({
            url: "http://localhost:8081/onepic/weather/getRadarByOne",
            data: {
                startTime: startTime, endTime: endTime
            },
            type: 'get',
            dataType: 'json',
            success: function (data) {
                console.log("success...", data);
                if (data.code != 200) {
                    alert("code=" + data.code + " msg=" + data.msg);
                    return;
                }
                var host = data.data.host;
                var tobj;
                for (var i in data.data.values) {
                    tobj = data.data.values[i]
                    var bbox = tobj.bbox;
                    var files = tobj.files
                    for (var objIndex in files) {
                        setImageToMap(host + files[objIndex], [[bbox[0], bbox[1]], [bbox[2], bbox[3]]])
                    }

                }

            }
        })

    })


    var echartsLayer = null;
    $("#getRadarRain2H").click(function () {
        var zoom = map.getZoom();  //获取当前地图的缩放级别
        // if (zoom < 7) {
        //     console.log("地图的缩放级别别能小于7,即接口请求不能大于10度！");
        //     return;
        // }

        var bounds = map.getBounds()
        var xy = map.getSize()
        var _northEast = bounds["_northEast"]
        var _southWest = bounds["_southWest"]

        context.clearRect(0, 0, xy.x, xy.y)
        var startLat = _northEast.lat
        var startLon = _northEast.lng
        var endLat = _southWest.lat
        var endLon = _southWest.lng


        if (zoom < 7) {
            for (var index in requestPoints) {
                var tempPoint = requestPoints[index]
                console.log(tempPoint._northEast.lat, tempPoint._northEast.lng)
                console.log(tempPoint._southWest.lat, tempPoint._southWest.lng)

                getRadarRain2H({
                    startLat: tempPoint._northEast.lat, startLon: tempPoint._northEast.lng,
                    endLat: tempPoint._southWest.lat, endLon: tempPoint._southWest.lng,
                    width: xy.x, height: xy.y,
                    bounds: bounds
                })
            }
        } else {
            getRadarRain2H({
                startLat: _northEast.lat, startLon: _northEast.lng,
                endLat: _southWest.lat, endLon: _southWest.lng,
                width: xy.x, height: xy.y,
                bounds: bounds
            })
        }


        // $.ajax({
        //     url: "http://localhost:8081/onepic/weather/getRadarRain2H",
        //     data: {
        //         startLat: _northEast.lat,
        //         startLon: _northEast.lng,
        //         endLat: _southWest.lat,
        //         endLon: _southWest.lng
        //     },
        //     type: 'post',
        //     dataType: 'json',
        //     success: function (data) {
        //         console.log("success...", data);
        //
        //         if (data.code != 200) {
        //             console.log("server response data error...")
        //             return
        //         }
        //         var latlngs = getRectVertices(data.data)
        //         var grids = getGridPoint({latlngs: latlngs, rows: data.data.rows, cols: data.data.cols})
        //
        //
        //         var heatDatas = new Array()
        //         for (var i = 0; i < grids.length; i++) {
        //             for (var j = 0; j < grids[0].length; j++) {
        //                 if (data.data.values[i][j] !== 0) {
        //                     grids[i][j].push(data.data.values[i][j])
        //                     heatDatas.push([].concat(grids[i][j]))
        //                 }
        //
        //             }
        //         }
        //
        //
        //         console.log("getSize==", map.getSize());
        //         var xy = map.getSize()
        //         var bounds = map.getBounds()
        //         var xyLng = L.latLng(0, bounds["_northEast"]["lng"]).distanceTo(L.latLng(0, bounds["_southWest"]["lng"]))
        //         var xyLat = L.latLng(bounds["_northEast"]["lat"], 0).distanceTo(L.latLng(bounds["_southWest"]["lat"], 0))
        //         drawingImage({
        //             width: xy.x,
        //             height: xy.y,
        //             heatDatas: heatDatas,
        //             bounds: bounds,
        //             latlngs: data.data
        //         })
        //
        //         // var option = {
        //         //     visualMap: {
        //         //         show: true,
        //         //         top: 'bottom',
        //         //         min: 0,
        //         //         max: 100,
        //         //         seriesIndex: 0,
        //         //         calculable: true,
        //         //         pieces: [
        //         //             {min: 0, max: 20},
        //         //             {min: 21, max: 50},
        //         //             {min: 51, max: 80},
        //         //             {min: 81, max:90},
        //         //             {min: 91, max:100},
        //         //         ],
        //         //         inRange: {
        //         //             color: ['blue', 'blue', 'green', 'yellow', 'red']
        //         //         }
        //         //     },
        //         //     series: [{
        //         //         type: 'heatmap',
        //         //         coordinateSystem: 'leaflet',
        //         //         data: heatDatas,
        //         //         pointSize: 1,
        //         //         blurSize: 1
        //         //     }]
        //         // };
        //         //
        //         // if(echartsLayer != null){
        //         //     map.removeLayer(echartsLayer)
        //         // }
        //         // echartsLayer = L.supermap.echartsLayer(option)
        //         // echartsLayer.addTo(map)
        //         // L.supermap.echartsLayer(option).addTo(map);
        //     }
        // })


    })


})


function getRadarRain2H(obj) {
    $.ajax({
        url: "http://localhost:8081/onepic/weather/getRadarRain2H",
        data: {
            startLat: obj.startLat,
            startLon: obj.startLon,
            endLat: obj.endLat,
            endLon: obj.endLon
        },
        type: 'post',
        dataType: 'json',
        success: function (data) {
            if (data.code != 200) {
                console.log("server response data error...")
                return
            }
            var latlngs = getRectVertices(data.data)
            var grids = getGridPoint({latlngs: latlngs, rows: data.data.rows, cols: data.data.cols})

            var heatDatas = new Array()
            for (var i = 0; i < grids.length; i++) {
                for (var j = 0; j < grids[0].length; j++) {
                    if (data.data.values[i][j] !== 0) {
                        grids[i][j].push(data.data.values[i][j])
                        heatDatas.push([].concat(grids[i][j]))
                    }

                }
            }
            // var xy = map.getSize()
            // var bounds = map.getBounds()
            // var xyLng = L.latLng(0, bounds["_northEast"]["lng"]).distanceTo(L.latLng(0, bounds["_southWest"]["lng"]))
            // var xyLat = L.latLng(bounds["_northEast"]["lat"], 0).distanceTo(L.latLng(bounds["_southWest"]["lat"], 0))
            drawingImage({
                width: obj.width,
                height: obj.height,
                heatDatas: heatDatas,
                bounds: obj.bounds,
                latlngs: data.data
            })

        }
    })
}

function setImageToMap(imageUrl, imageBounds) {
    console.log(imageUrl, imageBounds)
    L.imageOverlay(imageUrl, imageBounds, {
        opacity: 0.8
    }).addTo(map);
}

function getRectVertices(obj) {
    var aPointLat = obj.startLat
    var aPointLon = obj.startLon
    var cPointLat = obj.endLat
    var cPointLon = obj.endLon

    var bPointLon = cPointLon
    var bPointLat = aPointLat
    var dPointLon = aPointLon
    var dPointLat = cPointLat
    // 返回的点应为需要用leaflet渲染，格式为[纬度,经度]
    return [[aPointLat, aPointLon], [bPointLat, bPointLon], [cPointLat, cPointLon], [dPointLat, dPointLon]]
}

function getGridPoint(obj) {
    var latlngs = obj.latlngs
    var rows = obj.rows
    var cols = obj.cols
    var xItem = 0
    var yItem = 0
    xItem = (latlngs[1][1] - latlngs[0][1]) / cols
    yItem = (latlngs[2][0] - latlngs[1][0]) / rows
    // yItem = (latlngs[1][0] - latlngs[2][0]) / rows
    // xItem = (L.latLng(0,latlngs[1][1]).distanceTo(L.latLng(0,latlngs[0][1])))/cols
    // yItem = (L.latLng(latlngs[2][0],0).distanceTo(L.latLng(latlngs[1][0],0))) / rows
    xItemTT = (L.latLng(0, latlngs[1][1]).distanceTo(L.latLng(0, latlngs[0][1]))) / cols
    yItemTT = (L.latLng(latlngs[2][0], 0).distanceTo(L.latLng(latlngs[1][0], 0))) / rows

    var earthR = 6371.393 * 1000 //m
    var pai = Math.PI
    xItemN = (xItemTT * 180) / (pai * earthR)
    yItemN = (yItemTT * 180) / (pai * earthR)

    console.log("xItem==" + xItem + "   yItem==" + yItem)
    console.log("xItemTT==" + xItemTT + "   yItemTT==" + yItemTT)
    console.log("xItemN==" + xItemN + "   yItemN==" + yItemN)

    var grids = new Array()
    for (var i = 0; i < rows; i++) {
        grids[i] = new Array()
        for (var j = 0; j < cols; j++) {
            grids[i][j] = getCenterPointItems({
                rows: rows,
                cols: cols,
                row: i,
                col: j,
                xItem: xItemN,
                yItem: -yItemN,
                startLon: latlngs[0][0],
                startLat: latlngs[0][1]
            })
        }
    }
    return grids
}

function getCenterPointItems(obj) {
    var row = obj.row
    var col = obj.col
    var xItem = obj.xItem
    var yItem = obj.yItem
    var startPoint = [obj.startLat, obj.startLon]
    var aPointLon = startPoint[0] + xItem * col + xItem / 2
    var aPointLat = startPoint[1] + yItem * row + yItem / 2
    return [aPointLon, aPointLat]
}