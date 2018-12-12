/**
 * 模块：配置信息 注意：需要在文件中第一个加载
 */

// host = document.location.toString().match(/file:\/\//) ?
// "http://localhost:8090" : 'http://' + document.location.host;
var host = "http://localhost:8090";
// var host = "http://172.22.112.149:8090";
var MAPURL = {
    //基本地图专题图--实时路况专题图
    URL : host + "/iserver/services/map-xinjiang12/rest/maps/基础地图黑色",
    //URL : "http://192.168.251.184:8090/iserver/services/map-xinjiang/rest/maps/大屏",
    // URL : host + "/iserver/services/map-xjsl_Final/rest/maps/JSGIST-GL",
    URL_DATA : host + "/iserver/services/data-xinjiang12/rest/data",
    //在建道路专题图
    ZJ_ROAD : host + "/iserver/services/map-zaijiandaoluxin/rest/maps/GLZJ",
    ZJ_ROAD_DATA : host + "/iserver/services/data-zaijiandaoluxin/rest/data",

    RTT_DSGS_URL : host + "/iserver/services/map-road-rtt-xj/rest/maps/都市高速路@road-rtt-xj",
    RTT_GS_URL : host + "/iserver/services/map-road-rtt-xj/rest/maps/高速路@road-rtt-xj",
    RTT_GD_URL : host + "/iserver/services/map-road-rtt-xj/rest/maps/国道@road-rtt-xj",
    RTT_SD_URL : host + "/iserver/services/map-road-rtt-xj/rest/maps/省道@road-rtt-xj",
    RTT_DATA_URL : host + "/iserver/services/data-road-rtt-xj/rest/data",
    //RTT_MAP_URL : host + "/iserver/services/map-XJJT_LUK/rest/maps/XJLK",
    RTT_MAP_URL : "http://localhost:8099/iserver/services/map-XJJT_LUK/rest/maps/XJLK",



    ZD_GD_URL : host + "/iserver/services/map-road-xj/rest/maps/国道@road-xj",
    ZD_SD_URL : host + "/iserver/services/map-road-xj/rest/maps/省道@road-rtt-xj",
    ZD_GS_URL : host + "/iserver/services/map-road-xj/rest/maps/高速公路new@road-xj",
    ZD_GD_R_URL : host + "/iserver/services/map-road-xj/rest/maps/Routes_gd@road-xj",
    ZD_SD_R_URL : host + "/iserver/services/map-road-xj/rest/maps/Routes_sd@road-xj",
    ZD_GS_R_URL : host + "/iserver/services/map-road-xj/rest/maps/Routes_gs@road-xj",
    ZD_DATA_URL : host + "/iserver/services/data-road-xj/rest/data",
    ZD_ROUTES_URL : host + "/iserver/services/spatialAnalysis-road-xj/restjsr/spatialanalyst",



    // URL_DATA : host + "/iserver/services/data-xjsl_Final/rest/data",
    ROAD_URL : host + "/iserver/services/map-xjsl_Final/rest/maps/JSGIST-GS",
    // ZJ_ROAD: host + "/iserver/services/map-zaijiandaoluxin/rest/maps/GLZJ",
    // XJ_YX_ALL : host + "/iserver/services/map-XJ_level11/rest/maps/XJ_11",
    XJ_YX_ALL : host + "/iserver/services/map-xinjiang1/rest/maps/XJGIST-GL",
    FSSS_SFZ : host + "/iserver/services/map-xinjiang13/rest/maps/T_收费站",
    FSSS_FWQ : host + "/iserver/services/map-xinjiang13/rest/maps/服务区",
    FSSS_JYZ : host + "/iserver/services/map-xinjiang13/rest/maps/加油站",
    FSSS_TCQ : host + "/iserver/services/map-xinjiang13/rest/maps/停车区",
    FSSS_BRIDGE : host + "/iserver/services/map-xinjiang13/rest/maps/桥梁",
    ZTT_GREEN: host + "/iserver/services/map-xinjiang12/rest/maps/基础地图-绿色",
    ZTT_BLUE: host + "/iserver/services/map-xinjiang12/rest/maps/基础地图-蓝色",
    ZTT_GRAY: host + "/iserver/services/map-xinjiang12/rest/maps/基础地图-灰色",
    ZTT_BAIDU: host + "/iserver/services/map-xinjiang12/rest/maps/基础地图-百度",
}