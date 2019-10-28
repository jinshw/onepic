define(function (require, exports, module) {


    BaseObject.GisConfigManager = BaseHelper.Class.create();
    BaseObject.GisConfigManager.prototype = (BaseHelper.GUID, BaseHelper.Clone, BaseHelper.EventListener, {

        initialize: function (globalMap) {
            this.ID = "BaseObject.GisConfigManager";
            this.globalMap = globalMap;
        },
        
        load: function (data, callback) {

            var thisCallBack = this;

            if (data.code == "DEFAULT") {
                var configData=BaseObject.GlobalMap.DefaultConfigData;
                parse(configData);
            }
            else {
                if (data.mapUrl == null) {
                    var remoteService = require("mapviewer-remote-service");
                    var remoteParameter = require("mapviewer-remote-parameter"); //

                    remoteParameter.RESOURCE_NAME = "T_PLATFORM_GIS_CONFIG";
                    remoteParameter.REMOTE_METHOD = "getGisConfig";
                    if (data.account) {
                        remoteParameter.FILTER_PARAMENTER = "{'APP_CODE':'" + data.code + "','USER_COUNT':'" + data.account + "'}";
                    }
                    else {
                        remoteParameter.FILTER_PARAMENTER = "{'APP_CODE':'" + data.code + "'}";
                    }

                    var thisCallback = this;
                    remoteService.execute(remoteParameter, function (result) {
                        if (result.status == "1") {
                            parse(result.element);
                        } else {
                            alert("解析地图配置文件失败!");
                        }
                    });
                }
                else {
                    if (!data.isLoad) {
                        var RemoteMapService = require("mapviewer-remote-mapservice");
                        var instance = new RemoteMapService();
                        var url = data.mapUrl.substring(0, data.mapUrl.lastIndexOf("/"));
                        instance.analyticMapInfo(url + "?token=" + BaseObject.TokenKey, function (e) {
                            var mapData = {};
                            mapData.TYPE = e.mapType;
                            mapData.URL = decodeURI(data.mapUrl);
                            mapData.NAME = '地图浏览';
                            mapData.DEFAULT = 1;
                            if (mapData.TYPE == "wms111") {
                                mapData.BOUNDS = $($(e.wmsXml).find("BoundingBox").get(0));
                                if ($(e.wmsXml).find("SRS").length > 0) { mapData.SRS = $(e.wmsXml).find("SRS").get(0).innerText; }
                                mapData.NAME = data.mapUrl.substring(data.mapUrl.lastIndexOf("/") + 1, data.mapUrl.length);
                            }
                            if (mapData.TYPE == "wms130") {
                                mapData.BOUNDS = $($(e.wmsXml).find("BoundingBox").get(0));
                                if ($(e.wmsXml).find("CRS").length > 0) { mapData.CRS = $(e.wmsXml).find("CRS").get(0).innerText; }
                                mapData.NAME = data.mapUrl.substring(data.mapUrl.lastIndexOf("/") + 1, data.mapUrl.length);
                            }
                            else if (mapData.TYPE == "wmts") {
                                mapData.LAYER = $(e.wmsXml).find("owsTitle")[1].innerText;
                                mapData.MATRIXSET = $(e.wmsXml).find("TileMatrixSet")[1].innerText;
                            }
                            var configData = null;
                            if (BaseObject.owner) {
                                configData = BaseObject.GlobalMap.configData;
                            }
                            else
                                configData = BaseObject.GlobalMap.DefaultConfigData;
                            configData.maps = [mapData];
                            parse(configData);

                        });
                    }
                    else {
                        var mapData = {};
                        mapData.TYPE = "rest";
                        mapData.URL = data.mapUrl;
                        mapData.CODE = data.code;
                        mapData.NAME = '地图浏览';
                        mapData.DEFAULT = 1;
                        mapData.ICON = "styles/css_map/themes/images/map-swicth.png";
                        var configData = BaseObject.GlobalMap.DefaultConfigData;
                        configData.maps = [mapData];
                        parse(configData);
                    }

                }
            }
            function parse(data) {
                var configData = {};

                configData.baseMaps = thisCallBack._configMaps(data.maps);
                configData.layers = thisCallBack._configLayer(data.layers);
                configData.controls = thisCallBack._configControls(data.controls);
                configData.tools = thisCallBack._configTools(data.tools);
                configData.widgets = thisCallBack._configWidgets(data.widgets);

                if (callback) callback(configData);
            }


        },
        _configMaps: function (data) {
            var baseMap = [];
            if (data) {
                for (var index = 0; index < data.length; index++) {

                    var item = {
                        center: data[index].CENTER || BaseObject.GlobalMap.DefaultConfigData.center,
                        code: data[index].CODE,
                        isDefault: data[index].DEFAULT,
                        level: data[index].LEVEL || BaseObject.GlobalMap.DefaultConfigData.level,
                        srs: data[index].SRS || "",
                        crs: data[index].CRS || "",
                        id: data[index].ID,
                        icon: data[index].ICON != null ? data[index].ICON.split(";")[0] : "",
                        //icon: "styles/css_map/themes/images/map-swicth.png",
                        matrixSet: data[index].MATRIXSET,
                        bounds: data[index].BOUNDS || BaseObject.GlobalMap.DefaultConfigData.bounds,
                        name: data[index].NAME,
                        type: data[index].TYPE,
                        layer: data[index].LAYER,
                        url: data[index].URL,
                        note: data[index].NOTE||"-",
                        cache: true
                    };
                    //if (data[index].CODE == "zhjt") {
                    //    var id = this.getGLID(data);
                    //    item.id = id;
                    //}
                    baseMap.push(item);
                }
            }

            return baseMap;
        },

        getGLID: function (data) {
            for (var index = 0; index < data.length; index++) {
                var item = data[index];
                if (item.CODE == "gl") {
                    return data[index].ID;
                }
            }
        },
        _configLayer: function (data) {
            if (data) {
            }
        },
        _configControls: function (data) {
            var controls = [];
            if (data) {
                for (var index = 0; index < data.length; index++) {
                    var item = {
                        id: data[index].ID,
                        icon: data[index].ICON || BaseObject.GlobalMap.DefaultConfigData.defaultImg,
                        code: data[index].CODE,
                        name: data[index].NAME,
                        position: data[index].POSITION==null?"":data[index].POSITION,
                        url: data[index].URL
                    };
                    controls.push(item);
                }
            }
            return controls;
        },

        _configTools: function (data) {
            var tools = [];
            if (data) {
                for (var index = 0; index < data.length; index++) {
                    var item = {
                        id: data[index].ID,
                        icon: data[index].ICON,
                        name: data[index].NAME,
                        type: data[index].TYPE,
                        url: data[index].URL,
                        sortIndex: data[index].SORT_INDEX||0
                    };
                    tools.push(item);
                }
            }
            return tools;
        },
        _configWidgets: function (data) {
            var widgets = [];
            if (data) {
                for (var index = 0; index < data.length; index++) {
                    var item = {
                        position: data[index].POSITION,
                        code: data[index].CODE,
                        id: data[index].ID,
                        icon: data[index].ICON,
                        name: data[index].NAME,
                        type: data[index].TYPE,
                        url: data[index].URL,
                        sortIndex: data[index].SORT_INDEX
                    };
                    widgets.push(item);
                }
            }
            return widgets;
        },
        CLASS_NAME: "BaseObject.GisConfigManager"
    });
    module.exports = BaseObject.GisConfigManager;
});