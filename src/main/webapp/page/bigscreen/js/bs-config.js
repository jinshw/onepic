/**
 * 模块：配置信息 注意：需要在文件中第一个加载
 */

// host = document.location.toString().match(/file:\/\//) ?
// "http://localhost:8090" : 'http://' + document.location.host;
var host = "http://127.0.0.1:8090";
// var host = "http://172.22.112.149:8090";
var MAPURL = {
    URL: host + "/iserver/services/map-xinjiang1/rest/maps/XJGIST-GL",
    // URL : host + "/iserver/services/map-xjsl_Final/rest/maps/JSGIST-GL",
    URL_DATA: host + "/iserver/services/data-xinjiang1/rest/data",
    // URL_DATA : host + "/iserver/services/data-xjsl_Final/rest/data",
    ROAD_URL: host + "/iserver/services/map-xjsl_Final/rest/maps/JSGIST-GS",
    ZJ_ROAD: host + "/iserver/services/map-zaijiandaoluxin2/rest/maps/GLZJ",
    // ZJ_ROAD: host + "/iserver/services/map-zaijiandaoluxin/rest/maps/GLZJ",
    XJ_YX_ALL: host + "/iserver/services/map-XJ_level11/rest/maps/XJ_11",
    FSSS_SFZ: host + "/iserver/services/map-xinjiang12/rest/maps/T_收费站",
    FSSS_FWQ: host + "/iserver/services/map-xinjiang12/rest/maps/服务区",
    FSSS_JYZ: host + "/iserver/services/map-xinjiang12/rest/maps/加油站",
    FSSS_TCQ: host + "/iserver/services/map-xinjiang12/rest/maps/停车区",
    FSSS_BRIDGE: host + "/iserver/services/map-xinjiang12/rest/maps/桥梁",
    ZTT_GREEN: host + "/iserver/services/map-xinjiang14/rest/maps/基础地图-绿色",
    ZTT_BLUE: host + "/iserver/services/map-xinjiang14/rest/maps/基础地图-蓝色",
    ZTT_GRAY: host + "/iserver/services/map-xinjiang14/rest/maps/基础地图-灰色",
    ZTT_BAIDU: host + "/iserver/services/map-xinjiang14/rest/maps/基础地图-百度",
    MQI:host + "/iserver/services/map-mqi/rest/maps/1",
    // MQI:host + "/iserver/services/map-xinjiang111/rest/maps/1",
}