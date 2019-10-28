/*
* @description		根据某个字段实现对json数组的排序
* @param	 array	要排序的json数组对象
* @param	 field	排序字段（此参数必须为字符串）
* @param	 reverse  是否倒序（默认为false）
* @return	array	返回排序后的json数组
*/
var Utils = {};
Utils.jsonSort=function (array, field, reverse) {
    //数组长度小于2 或 没有指定排序字段 或 不是json格式数据
    if (array.length < 2 || !field || typeof array[0] !== "object") return array;
    //数字类型排序
    if (typeof array[0][field] === "number") {
        array.sort(function (x, y) { return x[field] - y[field] });
    }
    //字符串类型排序
    if (typeof array[0][field] === "string") {
        array.sort(function (x, y) { return x[field].localeCompare(y[field]) });
    }
    //倒序
    if (reverse) {
        array.reverse();
    }
    return array;
}

 Utils.getGUID=function() {
        var guid = "";
        for (var i = 1; i <= 32; i++) {
            var n = Math.floor(Math.random() * 16.0).toString(16);
            guid += n;
            if ((i == 8) || (i == 12) || (i == 16) || (i == 20)) guid += "";
        }
        return guid;
    }

 Utils.getWKTPoint=function(position) {
        var pointWKT = "POINT("; //"POINT\("			
        var xy = position.split(',');
        position = xy[1] + " " + xy[0];
        pointWKT += position;
        pointWKT += ")";
        position = pointWKT;
        return position;
}


 Utils.wktFormater2SuperMapVector=function(wktString, isclick) {
        //console.info(JSON.stringify(wktString));
        var mapGeometry = null;
        var wkt_c = new OpenLayers.Format.WKT();
        var geometryObj = wkt_c.read(wktString);
        if (geometryObj) {
            var geometry = geometryObj.geometry;
            mapGeometry = Utils.changeWKTGeometry2SuperMapGeometry(geometry, isclick);
        }
        return mapGeometry;
 }
    //包含点线面的处理
 Utils.changeWKTGeometry2SuperMapGeometry=function(geometry, isclick) {
        var points = [];
        var line = null;
        if (geometry.CLASS_NAME == "OpenLayers.Geometry.Point") {//点处理
 //           console.info("---->OpenLayers.Geometry.Point");
//            var xy = lonlat2mercator({
//                x: geometry.x,
//                y: geometry.y
//            });
            var point = new SuperMap.Geometry.Point(geometry.x, geometry.y);
            var pointlayer = new SuperMap.Feature.Vector(point);
            if (isclick) {

                if (BaseObject.SRS == "EPSG:3857")
                    xy = lonlat2mercator(xy);

                map.setCenter(new SuperMap.LonLat(xy.x, xy.y), 10);
            }
            return pointlayer;
        } else if (geometry.CLASS_NAME == "OpenLayers.Geometry.LineString") {//是单线
            //console.info("---->OpenLayers.Geometry.LineString");
            if (geometry.componentTypes.length == 1 && geometry.componentTypes[0] == "OpenLayers.Geometry.Point") {
                var components = geometry.components;
                for (var i in components) {
                    var x = components[i].x;
                    var y = components[i].y;
                    if (BaseObject.SRS == "EPSG:3857")
                    {
                        var xy = lonlat2mercator({ x: x, y: y });
                        x = xy.x;
                        y = xy.y;
                    }

                    points[i] = new SuperMap.Geometry.Point(x, y);
                }
                line = new SuperMap.Geometry.LineString(points);
                var lineVector = new SuperMap.Feature.Vector(line);
                if (isclick) {
                    map.setCenter(new SuperMap.LonLat(roadLine.getCentroid().x, line.getCentroid().y), 10);
                }
                return lineVector;
            }
        } else if (geometry.CLASS_NAME == "OpenLayers.Geometry.Polygon") {//是封闭的曲线
            //console.info("---->OpenLayers.Geometry.Polygon");
            if (geometry.componentTypes.length == 1 && "OpenLayers.Geometry.LinearRing" == geometry.componentTypes[0]) {
                var components = geometry.components[0].components;
                for (var i in components) {
                    var x = components[i].x;
                    var y = components[i].y;

                    if (BaseObject.SRS == "EPSG:3857") {
                        var xy = lonlat2mercator({ x: x, y: y });
                        x = xy.x;
                        y = xy.y;
                    }
                    points[i] = new SuperMap.Geometry.Point(x, y);
                }
                line = new SuperMap.Geometry.LinearRing(points);
                var region = new SuperMap.Geometry.Polygon([line]);
                var polygon = new SuperMap.Feature.Vector(region);
                if (isclick) {
                    map.setCenter(new SuperMap.LonLat(line.getCentroid().x, line.getCentroid().y), 10);
                }
                return polygon;
            }

        } else {//其他
            console.long("else multiline line!");
        }
        return roadLine;
    }

    //经纬度转墨卡托
 Utils.lonlat2mercator=function(lonlat) {
        var mercator = {
            x: 0,
            y: 0
        };
        var x = lonlat.x * 20037508.34 / 180;
        var y = Math.log(Math.tan((90 + lonlat.y) * Math.PI / 360)) / (Math.PI / 180);
        y = y * 20037508.34 / 180;
        mercator.x = x;
        mercator.y = y;
        return mercator;
    }
    //墨卡托转经纬度
 Utils.mercator2lonLat=function(mercator) {
        var lonLat = { x: 0, y: 0 };
        var x = mercator.x / 20037508.34 * 180;
        var y = mercator.y / 20037508.34 * 180;
        y = 180 / Math.PI * (2 * Math.atan(Math.exp(y * Math.PI / 180)) - Math.PI / 2);
        lonLat.x = x;
        lonLat.y = y;
        return lonLat;
    }

    Date.prototype.format = function (format) {
        var date = {
            "M+": this.getMonth() + 1,
            "d+": this.getDate(),
            "h+": this.getHours(),
            "m+": this.getMinutes(),
            "s+": this.getSeconds(),
            "q+": Math.floor((this.getMonth() + 3) / 3),
            "S+": this.getMilliseconds()
        };
        if (/(y+)/i.test(format)) {
            format = format.replace(RegExp.$1, (this.getFullYear() + '').substr(4 - RegExp.$1.length));
        }
        for (var k in date) {
            if (new RegExp("(" + k + ")").test(format)) {
                format = format.replace(RegExp.$1, RegExp.$1.length == 1
                            ? date[k] : ("00" + date[k]).substr(("" + date[k]).length));
            }
        }
        return format;
    }


    Utils.getByteLen = function (val) {
        var len = 0;
        for (var i = 0; i < val.length; i++) {
            var a = val.charAt(i);
            if (a.match(/[^\x00-\xff]/ig) != null) {
                len += 2;
            }
            else {
                len += 1;
            }
        }
        return len;
    }

    Utils.subString = function (str, len, hasDot) {
        var newLength = 0;
        var newStr = "";
        var chineseRegex = /[^\x00-\xff]/g;
        var singleChar = "";
        var strLength = str.replace(chineseRegex, "**").length;
        for (var i = 0; i < strLength; i++) {
            singleChar = str.charAt(i).toString();
            if (singleChar.match(chineseRegex) != null) {
                newLength += 2;
            }
            else {
                newLength++;
            }
            if (newLength > len) {
                break;
            }
            newStr += singleChar;
        }

        if (hasDot && strLength > len) {
            newStr += "...";
        }
        return newStr;
    }




