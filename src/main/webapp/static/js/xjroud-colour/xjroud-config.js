/**
 * 模块：配置信息 注意：需要在文件中第一个加载
 */

// host = document.location.toString().match(/file:\/\//) ?
// "http://localhost:8090" : 'http://' + document.location.host;
var host = "http://172.22.112.149:8090";
var MAPURL = {
    URL : host
	    + "/iserver/services/map-XinJiangYiZhangTu/rest/maps/JSGIST-GL（彩色）",
    URL_DATA : host + "/iserver/services/data-XinJiangYiZhangTu/rest/data",
    ROAD_URL : host
	    + "/iserver/services/map-XinJiangYiZhangTu/rest/maps/JSGIST-GS",// 没用到
    ZJ_ROAD : host + "/iserver/services/map-zaijiandaoluxin2/rest/maps/GLZJ",
    XJ_YX_ALL : host + "/iserver/services/map-XJ_level11/rest/maps/XJ_11",
    YX_2015 : host + "/iserver/services/map-WK20171011/rest/maps/WK2015",
    YX_2016_1 : host + "/iserver/services/map-TWD20171012/rest/maps/TWD2016",
    YX_2016_2 : host + "/iserver/services/map-WK20171011/rest/maps/WK2016",
    YX_2017_05_G216 : host
	    + "/iserver/services/map-G216_20171012/rest/maps/G216_201705GJ",
    YX_2017_05_TWD : host
	    + "/iserver/services/map-TWD20171012/rest/maps/TWD201705",

    YX_2017_06 : host
	    + "/iserver/services/map-G216_20171012/rest/maps/G216_201706GF2",
    YX_2017_07 : host
	    + "/iserver/services/map-G575_20171010/rest/maps/G575_201707",
    YX_2017_08_1 : host
	    + "/iserver/services/map-TWD20171012/rest/maps/TWD201708",
    YX_2017_08_2 : host
	    + "/iserver/services/map-G575_20171010/rest/maps/G575_201708",
    YX_2017_09 : host
	    + "/iserver/services/map-G575_20171010/rest/maps/G575_201709",
    JSJD_URL : host + "/iserver/services/map-jsjd/rest/maps/T500@jsjd",
    JSJD_URL_TWD : host
	    + "/iserver/services/map-jsjdwukui/rest/maps/T500m@jsjdwukui",
    CHANGE_AREA_MAP : host
	    + "/iserver/services/map-G575ChangeArea/rest/maps/G575ChangeArea",
    CHANGE_AREA_DATA : host + "/iserver/services/data-G575ChangeArea/rest/data",
    GF2016_WUYU_URL : host
	    + "/iserver/services/map-G575_20171010/rest/maps/G575_201707",
    GJ2017_WUYU_URL : host
	    + "/iserver/services/map-G575_20171010/rest/maps/G575_201707",
    YX_SL_2017 : host
	    + "/iserver/services/map-G575_20171010/rest/maps/G575_201707",

}