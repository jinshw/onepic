/// <reference path="../../bootstrap/js/bootstrap.min.js" />
/// <reference path="../../bootstrap/js/bootstrap.min.js" />
/// <reference path="../../bootstrap/js/bootstrap.min.js" />
/// <reference path="../../bootstrap/js/bootstrap.min.js" />
/// <reference path="../../bootstrap/js/bootstrap.min.js" />
/// <reference path="../../echarts/echarts.min.js" />
/// <reference path="../../echarts/echarts.min.js" />
 
(function () {
    var r = new RegExp("(^|(.*?\\/))(include-leaflet\.js)(\\?|$)"),
        s = document.getElementsByTagName('script'), targetScript;
    for (var i = 0; i < s.length; i++) {
        var src = s[i].getAttribute('src');
        if (src) {
            var m = src.match(r);
            if (m) {
                targetScript = s[i];
                break;
            }
        }
    }

    function inputScript(url) {
        var script = '<script type="text/javascript" src="' + url + '"><' + '/script>';
        document.writeln(script);
    }

    function inputCSS(url) {
        var css = '<link rel="stylesheet" href="' + url + '">';
        document.writeln(css);
    }

    function inArray(arr, item) {
        for (i in arr) {
            if (arr[i] == item) {
                return true;
            }
        }
        return false;
    }

    var BaseObject = {}
    BaseObject.path =  window.isLocal ? window.server : "http://localhost:8081/onepic/page/test";

    //加载类库资源文件
    function load() {
        var includes = (targetScript.getAttribute('include') || "").split(",");
        var excludes = (targetScript.getAttribute('exclude') || "").split(",");
        
        inputCSS(BaseObject.path + "/sm9dV1.0/leaflet/leaflet.css");
        inputScript(BaseObject.path + "/sm9dV1.0/leaflet/leaflet.js");
        inputScript(BaseObject.path + "/sm9dV1.0/leaflet/L.Map.Sync.js");
      
        if (inArray(includes, 'mapv')) {
            inputScript("http://mapv.baidu.com/build/mapv.min.js");
        }
        if (inArray(includes, 'turf')) {
            inputScript("https://cdn.bootcss.com/Turf.js/4.6.1/turf.min.js");
        }
        
        inputScript(BaseObject.path + "/sm9dV1.0/echarts/echarts.min.js");
      
        if (inArray(includes, 'elasticsearch')) {
            inputScript("http://cdn.bootcss.com/elasticsearch/13.0.1/elasticsearch.min.js");
        }
        inputScript(BaseObject.path + "/sm9dV1.0/supermap/dist/iclient9-leaflet.min.js");
        inputCSS(BaseObject.path + "/sm9dV1.0/supermap/dist/iclient9-leaflet.min.css");
      
        
        //if (!inArray(excludes, 'leaflet-icon-pulse')) {
        inputScript(BaseObject.path + "/sm9dV1.0/leaflet/plugins/leaflet-icon-pulse/L.Icon.Pulse.js");
        //}
        //if (inArray(includes, 'leaflet-icon-pulse-css')) {
            inputCSS(BaseObject.path + "/sm9dV1.0/leaflet/plugins/leaflet-icon-pulse/L.Icon.Pulse.css");
        //}

        //if (!inArray(excludes, 'leaflet-icon-pulse')) {
            inputScript(BaseObject.path + "/sm9dV1.0/leaflet/plugins/leaflet.pm/leaflet.pm.min.js");
        //}
        //if (inArray(includes, 'leaflet-icon-pulse-css')) {
            inputCSS(BaseObject.path + "/sm9dV1.0/leaflet/plugins/leaflet.pm/leaflet.pm.min.css");
        //}

        // if (inArray(includes, 'leaflet.heat')) {
        //    inputScript("http://cdn.bootcss.com/leaflet.heat/0.2.0/leaflet-heat.js");
        // }
        inputScript("http://cdn.bootcss.com/leaflet.heat/0.2.0/leaflet-heat.js");

        //if (inArray(includes, 'osmbuildings')) {
        //    inputScript("http://iclient.supermapol.com/libs/osmbuildings/OSMBuildings-Leaflet.js");
        //}
        inputCSS(BaseObject.path + "/sm9dV1.0/leaflet/plugins/leaflet.markercluster/MarkerCluster.Default.css");
        inputCSS(BaseObject.path + "/sm9dV1.0/leaflet/plugins/leaflet.markercluster/MarkerCluster.css");

        inputScript(BaseObject.path + "/sm9dV1.0/leaflet/plugins/leaflet.markercluster/leaflet.markercluster.js");
        inputScript(BaseObject.path + "/sm9dV1.0/leaflet/plugins/leaflet-side-by-side/leaflet-side-by-side.js");


 
        //if (inArray(includes, 'leaflet-icon-pulse')) {
        //    inputCSS("http://iclient.supermapol.com/libs/leaflet/plugins/leaflet-icon-pulse/L.Icon.Pulse.css");
        //    inputScript("http://iclient.supermapol.com/libs/leaflet/plugins/leaflet-icon-pulse/L.Icon.Pulse.js");
        //}
        //if (inArray(includes, 'leaflet.draw')) {
        //    inputCSS("http://cdn.bootcss.com/leaflet.draw/0.4.9/leaflet.draw.css");
        //    inputScript("http://cdn.bootcss.com/leaflet.draw/0.4.9/leaflet.draw.js");
        //}
        //if (inArray(includes, 'leaflet.pm')) {
        //    inputCSS("http://cdn.bootcss.com/leaflet.pm/0.16.0/leaflet.pm.min.css");
        //    inputScript("http://cdn.bootcss.com/leaflet.pm/0.16.0/leaflet.pm.min.js");
        //}
    }
    load();
})();
