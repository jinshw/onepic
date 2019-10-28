var host = window.isLocal ? window.server : "http://localhost:8090";
var map, url = host + "/iserver/services/map-zhdt/rest/maps/综合地图";
var imageLayer = null;
var imageLayerGroup = new L.layerGroup(),
    radarLayerObjs = new Object();
var times = [], timesObjs = new Object();

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
        _northEast: { lat: bPoint[0], lng: bPoint[1] },
        _southWest: { lat: aPoint[0], lng: aPoint[1] }
    },
    {
        _northEast: { lat: cPoint[0], lng: cPoint[1] },
        _southWest: { lat: bPoint[0], lng: bPoint[1] }
    },
    {
        _northEast: { lat: dPoint[0], lng: dPoint[1] },
        _southWest: { lat: cPoint[0], lng: cPoint[1] }
    },

    {
        _northEast: { lat: fPoint[0], lng: fPoint[1] },
        _southWest: { lat: ePoint[0], lng: ePoint[1] }
    },
    {
        _northEast: { lat: fPoint[0], lng: fPoint[1] },
        _southWest: { lat: cPoint[0], lng: cPoint[1] }
    },
    {
        _northEast: { lat: ePoint[0], lng: ePoint[1] },
        _southWest: { lat: bPoint[0], lng: bPoint[1] }
    },

    {
        _northEast: { lat: hPoint[0], lng: hPoint[1] },
        _southWest: { lat: gPoint[0], lng: gPoint[1] }
    },
    {
        _northEast: { lat: hPoint[0], lng: hPoint[1] },
        _southWest: { lat: cPoint[0], lng: cPoint[1] }
    },
    {
        _northEast: { lat: gPoint[0], lng: gPoint[1] },
        _southWest: { lat: bPoint[0], lng: bPoint[1] }
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
/*
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
*/

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
    context.globalAlpha = 0.4
    //确定浏览器支持<canvas>元素
    if (drawing.getContext) {
        for (var i in obj.heatDatas) {
            var gridItem = obj.heatDatas[i]
            // var point = map.latLngToContainerPoint([latlon[1], latlon[0]])
            context.save()
            context.beginPath()
            var type = $("#btnList li.active").data("type")
            var _style = FillStyle.fillStyle(type, gridItem.value)
            context.strokeStyle = _style
            context.fillStyle = _style
            // context.strokeStyle = getFillStyle(gridItem.value)
            // context.fillStyle = getFillStyle(gridItem.value)
            context.fillRect(gridItem.startPoint.x, gridItem.startPoint.y, gridItem.width, gridItem.height)
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

        // 高斯模糊处理
        // var data = context.getImageData(0, 0, canvas.width, canvas.height);
        // var gaussImage = gaussBlur(data);
        // context.putImageData(gaussImage,0,0)

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
        // imageLayer = L.imageOverlay(image.src, imageBounds)
        // imageLayer.addTo(map)
        imageLayerGroup.addLayer(L.imageOverlay(image.src, imageBounds))
        imageLayerGroup.addTo(map)


    }

}

function downLoad(url) {
    var oA = document.createElement("a");
    oA.download = '';// 设置下载的文件名，默认是'下载'
    oA.href = url;
    document.body.appendChild(oA);
    oA.click();
    oA.remove(); // 下载之后把创建的元素删除
}

var FillStyle = function () {
    // 内部状态
    var States = {
        "rain": function (value) {
            var result = ""
            if (value >= 0.1 && value <= 10) {
                result = "#A3F589";
            } else if (value >= 10 && value <= 25) {
                result = "#39AA00";
            } else if (value >= 25 && value <= 50) {
                result = "#62BAFF";
            } else if (value >= 50) { //50-100
                result = "#0001FB";
            }
            return result;
        },
        "7days": function (value) {
            var result = ""
            if (value > 0 && value < 0.1) {
                result = "rgb(76, 6, 105,0)";
            } else if (value >= 0.1 && value < 10) {
                result = "#7fffff";
            } else if (value >= 10 && value < 25) {
                result = "#23B7FF";
            } else if (value >= 25 && value < 50) {
                result = "#0078B4";
            } else if (value >= 50 && value < 100) {
                result = "#0C28AB";
            } else if (value >= 100 && value < 250) {
                result = "#BF6BFB";
            } else if (value >= 250) {
                result = "#500486";
            }
            return result;
        },
        "livedatas": function (value) {
            var result = ""
            if (value >= 0 && value <= 1) {
                result = "#CDFFFF";
            } else if (value >= 1 && value < 2) {
                result = "#23FFFC";
            } else if (value >= 2 && value < 4) {
                result = "#23B7FF";
            } else if (value >= 4 && value < 6) {
                result = "#0078B4";
            } else if (value >= 6 && value < 8) {
                result = "#0051CA";
            } else if (value >= 8 && value < 10) {
                result = "#092FD1";
            } else if (value >= 10 && value < 20) {
                result = "#4C0669";
            } else if (value >= 20 && value < 50) {
                result = "#6A059F";
            } else if (value >= 50) {
                result = "#4C0669";
            }
            return result;
        }
    }
    function fillStyle(type, value) {
        return States[type](value);
    }
    return {
        fillStyle: fillStyle
    }
}();

function getFillStyle(value) {
    var result = ""
    var type = $("#btnList li.active").data("type")
    if (value > 0 && value <= 10) {
        result = "#A3F589";
    } else if (value >= 10 && value <= 25) {
        result = "#39AA00";
    } else if (value >= 25 && value <= 50) {
        result = "#62BAFF";
    } else if (value >= 50) { //50-100
        result = "#0001FB";
    }
    return result;
}

function getZoomToRenderWidth(data) {
    var zoom = map.getZoom()
    var width = canvas.width
    var height = canvas.height
    // var hItem =  Math.floor(height/data.data.rows)
    // var wItem =  Math.floor(width/data.data.cols)
    var hItem = Math.ceil(height / data.data.rows)
    var wItem = Math.ceil(width / data.data.cols)
    // var minLen = Math.max(width,height)
    // var maxRowCols = Math.min(data.data.cols,data.data.rows)
    var result = Math.max(hItem, wItem)
    if (result < 1) {
        result = 1
    }
    return result
    // var result = 3;
    // if (zoom == 7) {
    //     result = 3;
    // } else if (zoom == 8) {
    //     result = 6;
    // } else if (zoom == 9) {
    //     result = 9;
    // } else if (zoom == 10) {
    //     result = 12;
    // } else if (zoom == 11) {
    //     result = 15;
    // } else if (zoom == 12) {
    //     result = 18;
    // }
    // return result;
}


$(function () {
    $("#btnList li").click(function () {
        $("#btnList li").removeClass()
        $(this).addClass("active")
        var type = $(this).data("type")
        getWeatherByType(type)
    })
    $("#flash").click(function () {
        var type = $("#btnList li.active").data("type")
        getWeatherByType(type)
    })
})

function getWeatherByType(type) {
    // 清除定时器
    clearTimer()
    $(".container-legend div").removeClass("active")
    var _id = type + "Legend";
    $("#" + _id).addClass("active")

    if (type == "radar") {
        initRadar()
    } else if (type == "rain") {
        getRain()
    } else if (type == "7days") {
        init7Days()
        // get7Days()
    } else if (type == "livedatas") {
        getLivedatas()
    }

    //--start 设置时间抽控件位置
    var _windowsWidth = $(window).width()
    var _timeLineWidth = $("#timeLineDIV").width()
    var _left = (_windowsWidth - _timeLineWidth) / 2
    $("#timeLineDIV").css("left", _left)
    //--end 设置时间抽控件位置

}

function initRadar() {
    $("#timeLineDIV").css("display", "block");
    times = []
    timesObjs = []
    radarLayerObjs = []
    for (var i = 10; i >= 0; i--) {
        keyTime = moment().subtract(60 * i, 'minutes').format("MM-DD HH:mm")
        times.push(keyTime);
        startTimeStr = moment().subtract(60 * i + 30, 'minutes').format("YYYYMMDDHHmm");
        endTimeStr = moment().subtract(60 * i - 20, 'minutes').format("YYYYMMDDHHmm");

        timesObjs[keyTime] = {
            startTime: startTimeStr,
            endTime: endTimeStr
        }
        // getRadar({ startTime: startTimeStr,endTime: endTimeStr}, 10-i)
    }

    $("#timeLineDIV").html("")
    if ($("#timeLineDIV").html() == "") {
        $("#timeLineDIV").initTimeLine({
            times: times,
            activeIndex: 0,
            step: 20
        }, function (item) {
            var currYear = $(item).text()
            var currIndex = $(item).data("index");
            console.log(currIndex, currYear, timesObjs[currYear])

            //隐藏radarLayerObjs图层信息
            for (var _index in radarLayerObjs) {
                var _imgLayers = radarLayerObjs[_index];
                for (var i = 0; i < _imgLayers.length; i++) {
                    _imgLayers[i].setOpacity(0)
                }
            }

            //获取雷达图片
            if (radarLayerObjs[currIndex] == undefined) {
                getRadar(timesObjs[currYear], currIndex)
            } else {
                var _imgLayers = radarLayerObjs[currIndex];
                for (var i = 0; i < _imgLayers.length; i++) {
                    _imgLayers[i].setOpacity(0.8)
                }
            }

        });
    }

}

function getRadar(obj, currIndex) {
    // var startTime = moment().subtract(20, 'minutes').format("YYYYMMDDHHmm")
    // var endTime = moment().subtract(1, 'minutes').format("YYYYMMDDHHmm")
    //清除添加的图片图层
    imageLayerGroup.clearLayers()
    $.ajax({
        url: "http://localhost:8081/onepic/weather/getRadarByOne",
        data: {
            startTime: obj.startTime, endTime: obj.endTime
        },
        type: 'get',
        dataType: 'json',
        success: function (data) {
            console.log("success...", data);
            if (data.code != 200) {
                alert("气象接口返回问题：code=" + data.code + " msg=" + data.msg);
                return;
            }
            var host = data.data.host;
            var tobj;
            var imgLayers = []
            for (var i in data.data.values) {
                tobj = data.data.values[i]
                var bbox = tobj.bbox;
                var files = tobj.files
                for (var objIndex in files) {
                    imgLayers.push(setImageToMap(host + files[objIndex], [[bbox[0], bbox[1]], [bbox[2], bbox[3]]]))
                    // setImageToMap(host + files[objIndex], [[bbox[0], bbox[1]], [bbox[2], bbox[3]]])
                }

            }
            if (radarLayerObjs[currIndex] == undefined) {
                radarLayerObjs[currIndex] = imgLayers
            }

        }
    })

}

function getRain() {
    var zoom = map.getZoom();  //获取当前地图的缩放级别

    var bounds = map.getBounds()
    var xy = map.getSize()
    var _northEast = bounds["_northEast"]
    var _southWest = bounds["_southWest"]

    context.clearRect(0, 0, canvas.width, canvas.height)
    var startLat = _northEast.lat
    var startLon = _northEast.lng
    var endLat = _southWest.lat
    var endLon = _southWest.lng

    //清除添加的图片图层
    imageLayerGroup.clearLayers()

    var _latVal = Math.abs(_northEast.lat - _southWest.lat)
    var _lngVal = Math.abs(_northEast.lng - _southWest.lng)

    // if (zoom < 7) {
    if (_latVal >= 10 || _lngVal >= 10) {
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
}

function init7Days() {
    $("#timeLineDIV").css("display", "block");
    times = []
    timesObjs = []
    radarLayerObjs = []
    for (var i = 1; i <= 7; i++) {
        keyTime = moment().subtract(-1 * i, 'days').format("YYYY-MM-DD HH:mm:ss")
        times.push(keyTime);
        // timesObjs[keyTime] = {
        //     forecastTime:keyTime
        // }
        // getRadar({ startTime: startTimeStr,endTime: endTimeStr}, 10-i)
    }

    $("#timeLineDIV").html("")

    if ($("#timeLineDIV").html() == "") {
        $("#timeLineDIV").initTimeLine({
            times: times,
            activeIndex: 0,
            step: 50,
            intervaltime: 6000,
            isPlay: false
        }, function (item) {
            var currYear = $(item).text()
            var currIndex = $(item).data("index");
            console.log(currIndex, currYear)
            get7Days(currYear)
            //隐藏radarLayerObjs图层信息
            // for (var _index in radarLayerObjs) {
            //     var _imgLayers = radarLayerObjs[_index];
            //     for (var i = 0; i < _imgLayers.length; i++) {
            //         _imgLayers[i].setOpacity(0)
            //     }
            // }

            // //获取雷达图片
            // if (radarLayerObjs[currIndex] == undefined) {
            //     getRadar(timesObjs[currYear], currIndex)
            // } else {
            //     var _imgLayers = radarLayerObjs[currIndex];
            //     for (var i = 0; i < _imgLayers.length; i++) {
            //         _imgLayers[i].setOpacity(0.8)
            //     }
            // }

        });
        // 触发第一个时间点
        $($("#timeLineDIV ul").find("li")[0]).trigger("click")
    }

    $("#timeLineDIV").css("display", "block");

}

function get7Days(currYear) {
    var zoom = map.getZoom();  //获取当前地图的缩放级别
    var bounds = map.getBounds()
    var xy = map.getSize()
    var _northEast = bounds["_northEast"]
    var _southWest = bounds["_southWest"]

    context.clearRect(0, 0, canvas.width, canvas.height)
    //清除添加的图片图层
    imageLayerGroup.clearLayers()

    var startLat = _northEast.lat
    var startLon = _northEast.lng
    var endLat = _southWest.lat
    var endLon = _southWest.lng
    var elem = "RAIN"
    var forecastTime = currYear
    // var forecastTime = moment().subtract(-1, 'days').format("YYYY-MM-DD HH:mm:ss")
    var _latVal = Math.abs(_northEast.lat - _southWest.lat)
    var _lngVal = Math.abs(_northEast.lng - _southWest.lng)

    // if (zoom < 7) {
    if (_latVal >= 10 || _lngVal >= 10) {
        for (var index in requestPoints) {
            var tempPoint = requestPoints[index]
            console.log(tempPoint._northEast.lat, tempPoint._northEast.lng)
            console.log(tempPoint._southWest.lat, tempPoint._southWest.lng)

            getEcForecast({
                startLat: tempPoint._northEast.lat, startLon: tempPoint._northEast.lng,
                endLat: tempPoint._southWest.lat, endLon: tempPoint._southWest.lng,
                forecastTime: forecastTime,
                width: xy.x, height: xy.y,
                elem: elem,
                bounds: bounds
            })
        }
    } else {
        getEcForecast({
            startLat: _northEast.lat, startLon: _northEast.lng,
            endLat: _southWest.lat, endLon: _southWest.lng,
            forecastTime: forecastTime,
            width: xy.x, height: xy.y,
            elem: elem,
            bounds: bounds
        })
    }
}

function getLivedatas() {
    var zoom = map.getZoom();  //获取当前地图的缩放级别
    var bounds = map.getBounds()
    var xy = map.getSize()
    var _northEast = bounds["_northEast"]
    var _southWest = bounds["_southWest"]

    context.clearRect(0, 0, canvas.width, canvas.height)
    //清除添加的图片图层
    imageLayerGroup.clearLayers()
    // if (imageLayer != null) {
    //     map.removeLayer(imageLayer)
    // }

    var startLat = _northEast.lat
    var startLon = _northEast.lng
    var endLat = _southWest.lat
    var endLon = _southWest.lng
    var elem = "RAIN"
    var _latVal = Math.abs(_northEast.lat - _southWest.lat)
    var _lngVal = Math.abs(_northEast.lng - _southWest.lng)

    // if (zoom < 7) {
    if (_latVal >= 10 || _lngVal >= 10) {
        for (var index in requestPoints) {
            var tempPoint = requestPoints[index]
            console.log(tempPoint._northEast.lat, tempPoint._northEast.lng)
            console.log(tempPoint._southWest.lat, tempPoint._southWest.lng)

            getCldasReal({
                startLat: tempPoint._northEast.lat, startLon: tempPoint._northEast.lng,
                endLat: tempPoint._southWest.lat, endLon: tempPoint._southWest.lng,
                width: xy.x, height: xy.y,
                elem: elem,
                bounds: bounds
            })
        }
    } else {
        getCldasReal({
            startLat: _northEast.lat, startLon: _northEast.lng,
            endLat: _southWest.lat, endLon: _southWest.lng,
            width: xy.x, height: xy.y,
            elem: elem,
            bounds: bounds
        })
    }
}

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
            var grids = getGridPoint({ latlngs: latlngs, rows: data.data.rows, cols: data.data.cols, data: data })

            //2、经纬度坐标点映射到像素坐标点
            var pixels = new Array()
            var gridItem = null, startPointPX = null, endPointPX = null, width = 0, height = 0;
            for (var index in grids) {
                gridItem = grids[index]
                startPointPX = map.latLngToContainerPoint(gridItem.startPoint)
                endPointPX = map.latLngToContainerPoint(gridItem.endPoint)
                width = (endPointPX.x - startPointPX.x) < 1 ? 1 : (endPointPX.x - startPointPX.x)
                height = (endPointPX.y - startPointPX.y) < 1 ? 1 : (endPointPX.y - startPointPX.y)
                pixels.push({
                    startPoint: { x: startPointPX.x, y: startPointPX.y },
                    width: width, height: height,
                    value: gridItem.value
                })
            }
            drawingImage({
                width: obj.width,
                height: obj.height,
                heatDatas: pixels,
                bounds: obj.bounds,
                latlngs: data.data
            })

        }
    })
}

function getCldasReal(obj) {
    $.ajax({
        url: "http://localhost:8081/onepic/weather/getCldasReal",
        data: {
            startLat: obj.startLat,
            startLon: obj.startLon,
            endLat: obj.endLat,
            endLon: obj.endLon,
            elem: obj.elem
        },
        type: 'post',
        dataType: 'json',
        success: function (data) {
            if (data.code != 200) {
                console.log("server response data error...")
                return
            }
            var latlngs = getRectVertices(data.data)
            var grids = getGridPoint({ latlngs: latlngs, rows: data.data.rows, cols: data.data.cols, data: data })

            //2、经纬度坐标点映射到像素坐标点
            var pixels = new Array()
            var gridItem = null, startPointPX = null, endPointPX = null, width = 0, height = 0;
            for (var index in grids) {
                gridItem = grids[index]
                startPointPX = map.latLngToContainerPoint(gridItem.startPoint)
                endPointPX = map.latLngToContainerPoint(gridItem.endPoint)
                width = (endPointPX.x - startPointPX.x) < 1 ? 1 : (endPointPX.x - startPointPX.x)
                height = (endPointPX.y - startPointPX.y) < 1 ? 1 : (endPointPX.y - startPointPX.y)
                pixels.push({
                    startPoint: { x: startPointPX.x, y: startPointPX.y },
                    width: width, height: height,
                    value: gridItem.value * 1000 // 实况接口返回降雨量单位为米，转为毫米
                })
            }
            drawingImage({
                width: obj.width,
                height: obj.height,
                heatDatas: pixels,
                bounds: obj.bounds,
                latlngs: data.data
            })

        }
    })
}

function getEcForecast(obj) {
    $.ajax({
        url: "http://localhost:8081/onepic/weather/getEcForecast",
        data: {
            startLat: obj.startLat,
            startLon: obj.startLon,
            endLat: obj.endLat,
            endLon: obj.endLon,
            elem: obj.elem,
            forecastTime: obj.forecastTime
        },
        type: 'post',
        dataType: 'json',
        success: function (data) {
            if (data.code != 200) {
                console.log("server response data error...")
                return
            }
            var latlngs = getRectVertices(data.data)
            var grids = getGridPoint({ latlngs: latlngs, rows: data.data.rows, cols: data.data.cols, data: data })

            //2、经纬度坐标点映射到像素坐标点
            var pixels = new Array()
            var gridItem = null, startPointPX = null, endPointPX = null, width = 0, height = 0;
            for (var index in grids) {
                gridItem = grids[index]
                var tempVal = (gridItem.value - 15.97) * 1000;
                if (tempVal > 0) {
                    startPointPX = map.latLngToContainerPoint(gridItem.startPoint)
                    endPointPX = map.latLngToContainerPoint(gridItem.endPoint)
                    width = (endPointPX.x - startPointPX.x) < 1 ? 1 : (endPointPX.x - startPointPX.x)
                    height = (endPointPX.y - startPointPX.y) < 1 ? 1 : (endPointPX.y - startPointPX.y)
                    pixels.push({
                        startPoint: { x: startPointPX.x, y: startPointPX.y },
                        width: width, height: height,
                        value: (gridItem.value - 15.97) * 1000 // 格点未来7天预报接口返回降雨量单位为米，转为毫米(偏移量15.97)
                    })
                }

            }
            drawingImage({
                width: obj.width,
                height: obj.height,
                heatDatas: pixels,
                bounds: obj.bounds,
                latlngs: data.data
            })

        }
    })
}

function setImageToMap(imageUrl, imageBounds) {
    console.log(imageUrl, imageBounds)
    // L.imageOverlay(imageUrl, imageBounds, {
    //     opacity: 0.8
    // }).addTo(map);
    _resultLayer = L.imageOverlay(imageUrl, imageBounds, {
        opacity: 0.8
    });
    _resultLayer.addTo(map);
    return _resultLayer;

    // imageLayerGroup.addLayer(L.imageOverlay(imageUrl, imageBounds), {
    //     opacity: 0.8
    // })
    // imageLayerGroup.addTo(map)
}

function getRectVertices(obj) {
    var aPointLat = obj.startLat
    var aPointLon = obj.startLon
    var cPointLat = obj.endLat
    var cPointLon = obj.endLon

    var bPointLon = aPointLon
    var bPointLat = cPointLat
    var dPointLon = cPointLon
    var dPointLat = aPointLat
    // 返回的点应为需要用leaflet渲染，格式为[纬度,经度]
    return [[aPointLat, aPointLon], [bPointLat, bPointLon], [cPointLat, cPointLon], [dPointLat, dPointLon]]
}

function getGridPoint(obj) {
    var latlngs = obj.latlngs
    var rows = obj.rows
    var cols = obj.cols
    var xItem = 0
    var yItem = 0
    xItem = (latlngs[2][1] - latlngs[0][1]) / cols
    yItem = (latlngs[2][0] - latlngs[0][0]) / rows
    // xItemTT = (L.latLng(0, latlngs[2][1]).distanceTo(L.latLng(0, latlngs[0][1]))) / cols
    // yItemTT = (L.latLng(latlngs[2][0], 0).distanceTo(L.latLng(latlngs[0][0], 0))) / rows
    // xItem = (latlngs[1][1] - latlngs[0][1]) / cols
    // yItem = (latlngs[2][0] - latlngs[1][0]) / rows
    // xItemTT = (L.latLng(0, latlngs[1][1]).distanceTo(L.latLng(0, latlngs[0][1]))) / cols
    // yItemTT = (L.latLng(latlngs[2][0], 0).distanceTo(L.latLng(latlngs[1][0], 0))) / rows

    var earthR = 6371.393 * 1000 //m
    var pai = Math.PI
    // xItemN = (xItemTT * 180) / (pai * earthR)
    // yItemN = (yItemTT * 180) / (pai * earthR)

    // console.log("xItem==" + xItem + "   yItem==" + yItem)
    // console.log("xItemTT==" + xItemTT + "   yItemTT==" + yItemTT)
    // console.log("xItemN==" + xItemN + "   yItemN==" + yItemN)

    var grids = new Array()
    for (var i = 0; i < rows; i++) {
        // grids[i] = new Array()
        for (var j = 0; j < cols; j++) {
            if (obj.data.data.values[i][j] > 0) {
                grids.push(
                    getCenterPointItems({
                        rows: rows,
                        cols: cols,
                        row: i,
                        col: j,
                        xItem: xItem,
                        yItem: yItem,
                        startLon: latlngs[0][1],
                        startLat: latlngs[0][0],
                        data: obj.data
                    })
                )
            }
        }
    }
    return grids
}

function getCenterPointItems(obj) {
    var row = obj.row
    var col = obj.col
    var xItem = obj.xItem
    var yItem = obj.yItem
    // 左上角原点
    var startPoint = [obj.startLat, obj.startLon]
    var startPointLon = ""
    var startPointLat = ""
    var startPointLon = startPoint[1] + xItem * col
    var startPointLat = startPoint[0] + yItem * row
    var endPointLon = startPoint[1] + xItem * (col + 1)
    var endPointLat = startPoint[0] + yItem * (row + 1)
    // console.log("data values...", obj.data.data.values[row][col])
    return {
        startPoint: [startPointLat, startPointLon],
        endPoint: [endPointLat, endPointLon],
        value: obj.data.data.values[row][col]
    }
}

function gaussBlur(imgData) {
    var pixes = imgData.data;
    var width = imgData.width;
    var height = imgData.height;
    var gaussMatrix = [],
        gaussSum = 0,
        x, y,
        r, g, b, a,
        i, j, k, len;

    var radius = 10;
    var sigma = 5;

    a = 1 / (Math.sqrt(2 * Math.PI) * sigma);
    b = -1 / (2 * sigma * sigma);
    //生成高斯矩阵
    for (i = 0, x = -radius; x <= radius; x++ , i++) {
        g = a * Math.exp(b * x * x);
        gaussMatrix[i] = g;
        gaussSum += g;

    }
    //归一化, 保证高斯矩阵的值在[0,1]之间
    for (i = 0, len = gaussMatrix.length; i < len; i++) {
        gaussMatrix[i] /= gaussSum;
    }
    //x 方向一维高斯运算
    for (y = 0; y < height; y++) {
        for (x = 0; x < width; x++) {
            r = g = b = a = 0;
            gaussSum = 0;
            for (j = -radius; j <= radius; j++) {
                k = x + j;
                if (k >= 0 && k < width) {//确保 k 没超出 x 的范围
                    //r,g,b,a 四个一组
                    i = (y * width + k) * 4;
                    r += pixes[i] * gaussMatrix[j + radius];
                    g += pixes[i + 1] * gaussMatrix[j + radius];
                    b += pixes[i + 2] * gaussMatrix[j + radius];
                    // a += pixes[i + 3] * gaussMatrix[j];
                    gaussSum += gaussMatrix[j + radius];
                }
            }
            i = (y * width + x) * 4;
            // 除以 gaussSum 是为了消除处于边缘的像素, 高斯运算不足的问题
            // console.log(gaussSum)
            pixes[i] = r / gaussSum;
            pixes[i + 1] = g / gaussSum;
            pixes[i + 2] = b / gaussSum;
            // pixes[i + 3] = a ;
        }
    }
    //y 方向一维高斯运算
    for (x = 0; x < width; x++) {
        for (y = 0; y < height; y++) {
            r = g = b = a = 0;
            gaussSum = 0;
            for (j = -radius; j <= radius; j++) {
                k = y + j;
                if (k >= 0 && k < height) {//确保 k 没超出 y 的范围
                    i = (k * width + x) * 4;
                    r += pixes[i] * gaussMatrix[j + radius];
                    g += pixes[i + 1] * gaussMatrix[j + radius];
                    b += pixes[i + 2] * gaussMatrix[j + radius];
                    // a += pixes[i + 3] * gaussMatrix[j];
                    gaussSum += gaussMatrix[j + radius];
                }
            }
            i = (y * width + x) * 4;
            pixes[i] = r / gaussSum;
            pixes[i + 1] = g / gaussSum;
            pixes[i + 2] = b / gaussSum;
        }
    }
    return imgData;
}

function clearTimer() {
    var liActive = $("#btnList").find("li.active");
    var _type = $(liActive).data("type");
    if (_type != "radar") {
        $("#timeLineDIV").clearTimer()
        $("#timeLineDIV").css("display", "none")
    }

    //删除radarLayerObjs图层信息
    for (var _index in radarLayerObjs) {
        var _imgLayers = radarLayerObjs[_index];
        for (var i = 0; i < _imgLayers.length; i++) {
            _imgLayers[i].remove()
        }
    }
}








