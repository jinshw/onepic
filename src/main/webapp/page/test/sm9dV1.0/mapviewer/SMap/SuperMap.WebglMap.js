define(function (require, exports, module) {
    BaseObject.WebglMap = BaseHelper.Class.create();
    BaseObject.WebglMap.prototype = BaseHelper.Class.inherit(BaseHelper.GUID, BaseHelper.Clone, BaseHelper.EventListener, {
        initialize: function (a, b) {
            this.ID = this.getGUID()
        },
        init: function (globalMap, configData) {
            this.baseMaps = [];
            this.subjectLayers = [];
            this.handlers = {};
            this.globalMap = globalMap;
            this.configData = configData;

            var mapDiv = document.createElement("div");
            mapDiv.id = "mapDiv_" + this.ID;
            mapDiv.style.cssText = " float:left;display:inline-block;width:100%; height:100%; border:0px solid #0000FF; background: #EFEFEF;";
            mapDiv.className = "viewer-container";
            this.container = $(mapDiv);
            $(this.globalMap.viewerContainer).append(this.container);
            this._initMap();
            this._initConfigLayers();
            this._initPreload(this.configData);
        },
        setLocation: function (target, level, convert) {
            this.handlers["Location"].instance.setLocation(target, level, convert)
        },

        clearLocation: function () {
            this.handlers["Location"].instance.clearLocation()
        },

        showFeatures: function (features, isDefault, isZoom) {
            this.handlers["Location"].instance.show(features, isDefault, isZoom)
        },
        settingConfigMap: function (configMap) {
            this.prevMapCode = configMap.code;

            if (configMap.type == "wmts") {
                this._setWmtsLayer(configMap)
            } else if (configMap.type == "wms111" || configMap.type == "wms130") {
                this._setWmsLayer(configMap)
            } else {
                this._setRestLayer(configMap)
            }
        },
        _initBaseLayerCallBack: function (configMap) {
            this.resetLayerIndex();
            if (this.currentMapInfos) {
                this.mapObject.setView(this.currentMapInfos.center, this.currentMapInfos.level)
            } else {
                this.setViewerBounds(configMap.bounds, configMap.level)
            }
        },
        setViewerBounds: function (coordinates, level) {
            if (level == -1) level = 4;
            if (level != 0) this.mapObject.setZoom(level);
            var miny = coordinates.split(",")[0];
            var minx = coordinates.split(",")[1];
            var maxy = coordinates.split(",")[2];
            var maxx = coordinates.split(",")[3];
            this.mapObject.fitBounds([[Number(minx), Number(miny)], [Number(maxx), Number(maxy)]])
        },
        _setRestLayer: function (configMap) {
            var thisCallBack = this;
            this.resetBaseMapLayer(configMap,
            function () {
                thisCallBack._initBaseLayerCallBack(configMap);
                thisCallBack.loadMapCompleted = true;
                if (configMap.layers != null) {
                    thisCallBack.globalMap.dispathEvent("loadMapCompleted", {
                        data: configMap
                    });
                    thisCallBack.clear()
                } else {
                    thisCallBack.globalMap.loadjs(BaseObject.path + "/sm9dV1.0/mapviewer/service/SuperMap.MapService.js",
                    function (arguments) {
                        var instance = new arguments[0]();
                        instance.init(thisCallBack);
                        instance.getLayerByMapId(configMap.id);
                        instance.addEventListener("processCompleted",
                        function (e) {
                            thisCallBack.clear();
                            configMap.layers = e;
                            thisCallBack.globalMap.dispathEvent("loadMapCompleted", {
                                data: configMap
                            })
                        })
                    })
                }
            })
        },
        updateSize: function () {
            this.mapObject.invalidateSize(true);
        },
        resetBaseMapLayer: function (configMap, callback) {
            var thisCallBack = this;
            this.removeBaseLayer();
            if (configMap.type && configMap.type.toUpperCase() == "TIANDITU") {
                this._addTianDiTuMap(configMap,
                function () {
                    callback()
                });
                return
            }
            if (configMap.type && configMap.type.toUpperCase() == "GOOGLEMAP") {
                this._addGoogleMap(configMap,
                function () {
                    callback()
                });
                return
            } else {
                if (configMap.note) var config = eval(configMap.note);
                this.mapObject.options.src = thisCallBack.getMapCRS(config.crs);
                thisCallBack.currentMapLayer = L.supermap.tiledMapLayer(decodeURI(configMap.url));
                thisCallBack.currentMapLayer.on("add",
                function () {
                    thisCallBack.baseMaps.push(thisCallBack.currentMapLayer);
                    callback()
                });
                thisCallBack.currentMapLayer.addTo(this.mapObject)
            }
        },
        getMapCRS: function (type) {
            var mapcrs;
            switch (type) {
                case "L.CRS.EPSG4326":
                    mapcrs = L.CRS.EPSG4326;
                    break;
                case "L.CRS.EPSG3857":
                    mapcrs = L.CRS.EPSG3857;
                    break;
                case "L.CRS.TianDiTu_Mercator":
                    mapcrs = L.CRS.TianDiTu_Mercator;
                    break;
                case "L.CRS.TianDiTu_WGS84":
                    mapcrs = L.CRS.TianDiTu_WGS84;
                    break;
                default:
                    mapcrs = L.CRS.TianDiTu_WGS84;
                    break
            }
            return mapcrs
        },
        removeBaseLayer: function () {
            for (var index = 0; index < this.baseMaps.length; index++) {
                var item = this.baseMaps[index];
                if (this.mapObject.hasLayer(item)) {
                    this.mapObject.removeLayer(item)
                }
            }
            this.currentMapLayer = null;
            this.baseMaps = []
        },
        _addTianDiTuMap: function (data, callback) {
            var thisCallBack = this;
            var config = eval(data.note);
            var type = config.type || "vec";
            var isLabel = config.isLabel || false;
            var projection = config.projection;
            var xzqhUrl = config.xzqhurl;
            this.mapObject.options.crs = this.getMapCRS(config.crs);
            this.currentMapLayer = L.supermap.tiandituTileLayer({
                layerType: type
            }).addTo(this.mapObject);
            var labelLayer = L.supermap.tiandituTileLayer({
                layerType: type,
                isLabel: isLabel
            }).addTo(this.mapObject);
            this.baseMaps.push(thisCallBack.currentMapLayer);
            this.baseMaps.push(labelLayer);
            if (xzqhUrl) {
                xzqhUrl = xzqhUrl.replace("https://ctsmaps.catsic.com/", "http://172.16.13.178/")
                this._addBaseXqzh(xzqhUrl);
            }
            else {
                this.baseXzqhData = null;
            }
            callback()
        },

        _addBaseXqzh: function (url) {
            if (this.baseXzqhData)
                this.mapObject.removeLayer(this.baseXzqhData.layer);

            var thisCallBack = this;
            var layer = L.supermap.tiledMapLayer(decodeURI(url), {
                transparent: true
            });

            this.baseXzqhData = { layer: layer, url: url }
            layer.on({
                "add": function () {
                    var len = thisCallBack.baseMaps.length;
                    this.setZIndex(len);
                }
            });
            layer.addTo(this.mapObject)
        },

        emableMapBackground: function (val) {
            if (this.baseXzqhData) {
                if (!val) {
                    this.mapObject.removeLayer(this.baseXzqhData.layer);
                }
                else {
                    this.mapObject.addLayer(this.baseXzqhData.layer);
                }
            }
        },

        _addGoogleMap: function (data, callback) {
            var thisCallBack = this;
            clearInterval(thisCallBack.googleMapTimer);
            if (data.note && data.note != "-") {
                var config = eval(data.note);
                var type = config.type;
                var projection = config.projection;
                var label = config.label || "cva";
                var xzqhUrl = config.xzqhurl
            }
            thisCallBack.globalMap.loadjs(BaseObject.path + "/script/mapviewer/networkmap/SuperMap.GoogleMap.js",
            function (a) {
                thisCallBack.googleMapTimer = setInterval(function () {
                    if (GOOGLE_MAP_INIT) {
                        thisCallBack.currentMapLayer = new SuperMap.Layer.Google("", {
                            type: google.maps.MapTypeId.HYBRID,
                            EPSG: 3857
                        });
                        thisCallBack.mapObject.numZoomLevels = 24;
                        thisCallBack.baseMaps.push(thisCallBack.currentMapLayer);
                        thisCallBack.mapObject.addLayers(thisCallBack.baseMaps);
                        clearInterval(thisCallBack.googleMapTimer);
                        callback()
                    }
                },
                100)
            })
        },
        flyToBounds: function (bounds) {
            this.mapObject.flyToBounds(bounds)
        },
        _initMap: function () {
            this.mapObject = L.map(this.container.attr("id"), {
                center: [0, 0],
                zoom: 0,
                zoomControl: false,
                logoControl: false,
                attributionControl: false
            })
        },
        resetLayerIndex: function () {
            for (var index = 0; index < this.baseMaps.length; index++) {
                var item = this.baseMaps[index];
                if (this.mapObject.hasLayer(item)) {
                    item.setZIndex(index)
                }
            }
            if (this.subjectLayers) {
                for (var index = 0; index < this.subjectLayers.length; index++) {
                    var subjectLayer = this.subjectLayers[index];
                    if (subjectLayer.isAdd) {
                        this.mapObject.removeLayer(subjectLayer.getLayer());
                        this.mapObject.addLayer(subjectLayer.getLayer())
                    }
                }
            }
        },
        getConfigLayer: function (name) {
            for (var index = 0; index < this.subjectLayers.length; index++) {
                if (this.subjectLayers[index].name == name) {
                    return this.subjectLayers[index]
                }
            }
        },
        _initConfigLayers: function () {
            var thisCallBack = this;
            this.globalMap.loadjs(BaseObject.path + "/sm9dV1.0/mapviewer/layer/SuperMap.BaseDrawVectorLayer.js",
            function (argments) {
                var instance = new argments[0]();
                thisCallBack.baseDrawVectorLayer = instance;
                instance.init(thisCallBack);
                thisCallBack.drawVector = instance.drawVector;
                thisCallBack.subjectLayers.push(instance)
            })
        },
        hide: function () {
            $(this.container).hide()
        },
        show: function () {
            $(this.container).show()
        },
        addOverLayer: function (item) {
            var thisCallBack = this;
            var bufferImgCount = 0;
            var overlay = L.supermap.tiledMapLayer(decodeURI(item.url), {
                transparent: true
            });
            overlay.id = item.id;
            overlay.sortIndex = item.sortIndex;
            overlay.mapviewerType = item.type;
            overlay.on({
                "add": function () {
                    thisCallBack.globalMap.overLayers[this.id] = this;
                    var len = thisCallBack.baseMaps.length;
                    this.sortIndex = this.sortIndex + len;
                    this.setZIndex(this.sortIndex);
                    if (thisCallBack.mapObject.hasLayer(thisCallBack.drawVector)) {
                        thisCallBack.drawVector.setZIndex(9999)
                    }
                    thisCallBack.globalMap.dispathEvent("addOverLayer_completed", this)
                }
            });
            overlay.addTo(this.mapObject)
        },
        zoomTo: function (level) {
            this.mapObject.zoomTo(level)
        },

        setChangeMap: function (code) {
            if (this.currentMapConfigData && this.currentMapConfigData.code == code) return;
            if (!this.loadMapCompleted) return;
            if (this.currentMapLayer) {
                if (this.mapObject.hasLayer(this.currentMapLayer)) {
                    this.currentMapInfos = {
                        center: this.mapObject.getCenter(),
                        level: this.mapObject.getZoom()
                    }
                    this.removeBaseLayer()
                }
            }
            if ((this.prevMapCode && this.prevMapCode == code) || (code == 'yx' || code == 'dx' || code == 'googlemap')) {
                var thisCallBack = this;
                var configMap = this.globalMap.getConfigMapData(code);
                this.currentMapConfigData = configMap;
                this.resetBaseMapLayer(configMap,
                function () {
                    thisCallBack._initBaseLayerCallBack(configMap);
                    thisCallBack.loadMapCompleted = true;
                    thisCallBack.dispathEvent("changedOverviewMap", {
                        data: configMap
                    })
                })
            } else {
                var thisCallBack = this;
                this.prevMapCode = null;
                if (this.currentMapConfigData) this.prevMapCode = this.currentMapConfigData.code;
                var mapConfigData = this.globalMap.getConfigMapData(code);
                this.currentMapConfigData = mapConfigData;
                this.settingConfigMap(mapConfigData)
            }
            this.dispathEvent("changedMapCompleted", {
                data: this.currentMapConfigData
            })
        },

        removeOverLayer: function (item) {
            this.mapObject.removeLayer(item);
            this.globalMap.dispathEvent("removeOverLayerCompleted", item.id)
        },

        _initPreload: function (configData) {
            var configServices = configData.configServices;
            var tmp = [];
            var list = [];
            if (configServices) {
                for (var k = 0; k < configServices.length; k++) {
                    if (configServices[k].preload) {
                        list.push(BaseObject.path + "/" + configServices[k].url);
                        tmp.push(configServices[k]);
                    }
                }
                var thisCallBack = this;
                this.globalMap.loadjs(list, function (arguments) {
                    for (var i = 0; i < arguments.length; i++) {
                        var instance = new arguments[i](thisCallBack.globalMap, tmp[i]);
                        thisCallBack.handlers[tmp[i].code] = { instance: instance, target: tmp[i], objectClass: arguments[i] };
                    }
                })
            }
        },

        showThematic: function (data) {
            this.handlers["ThematicLayer"].instance.show(data)
        },

        clear: function () {
            for (var index = 0; index < this.subjectLayers.length; index++) {
                this.subjectLayers[index].clear()
            }
        },
        destroy: function () { },
        CLASS_NAME: "BaseObject.WebglMap"
    });
    module.exports = BaseObject.WebglMap
});