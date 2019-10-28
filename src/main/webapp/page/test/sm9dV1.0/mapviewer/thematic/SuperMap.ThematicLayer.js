define(function (require, exports, module) {
    BaseObject.ThematicLayer = BaseHelper.Class.create();
    BaseObject.ThematicLayer.prototype = BaseHelper.Class.inherit(BaseObject.Component, {
        initialize: function (globalMap, configData) {
            this.name = "ThematicLayer";
            this.isAdd = false;
            this.handlers = {};
            if (globalMap) {
                configData == null ? {} : configData;
                this.init(globalMap, configData)
            }
        },
        init: function (globalMap, configData) {
            this.globalMap = globalMap;
            this.globalMap.districtHashtable = [];
            var thisCallBack = this;
            this.globalMap.addEventListener("clearAll", function () {
                thisCallBack.clear()
            });
            this.configData = configData;
            this.load("provice-geo");
            this._initPreload(configData);
            this.globalMap.addCommonComponets(this);
        },
        _initPreload: function (configData) {
            var configServices = configData.configServices;
            var list = [];
            if (configServices) {
                for (var k = 0; k < configServices.length; k++) {
                    this.handlers[configServices[k].code] = {
                        target: configServices[k]
                    }
                    if (configServices[k].preload) {
                        list.push(BaseObject.path + "/" + configServices[k].url);
                        tmp.push(configServices[k]);
                        break
                    }
                }
                this.loadjs(list);
            }
        },

        loadjs: function (list, callback) {
            var thisCallBack = this;
           
            this.globalMap.loadjs(list, function (arguments) {
                for (var i = 0; i < arguments.length; i++) {
                    var target = thisCallBack._getConfigService(list[i]);
                    var instance = new arguments[i](thisCallBack.globalMap, target);
                    thisCallBack.handlers[target.code] = {
                        instance: instance,
                        target: target,
                        objectClass: arguments[i]
                    };
                    instance.addEventListener("clickFeature", function (e) {
                        thisCallBack.clickFeatureHandler(e);
                    });
                }
                if (callback) callback();
            })
        },

        _getConfigService: function (url) {
            var configServices = this.configData.configServices;
            for (var k = 0; k < configServices.length; k++) {
                if ((BaseObject.path+"/"+configServices[k].url) == url) {
                    return configServices[k];
                }
            }
        },

        load: function (geometryName) {
            var thisCallBack = this;
            $.ajax({
                type: 'GET',
                url: BaseObject.path + '/sm9dV1.0/mapviewer/thematic/geometry/' + geometryName + '.txt',
                data: null,
                success: function (result) {
                    var data = JSON.parse(result);
                    var parentId = geometryName.substring(0,6);
                    var parent = thisCallBack.globalMap.districtHashtable[parentId];
                    $.each(data, function (index, item) {
                        thisCallBack.globalMap.districtHashtable[item.id] = item;
                        item.children = [];
                        if (parent && parent.children) parent.children.push(item);
                    })
                },
                error: function (jqXHR) {
                    alert("区域字典加载失败！！")
                }
            });
        },

        show: function (data) {
            this.clear();
            if (this.handlers[data.type] != null) {
                var thisCallBack = this;
                if (this.handlers[data.type].instance)
                    this.handlers[data.type].instance.show(data);
                else
                    this.loadjs([BaseObject.path + "/" + this.handlers[data.type].target.url], function () {
                        thisCallBack.handlers[data.type].instance.show(data);
                    })
            } else {
                alert(data.type + "专题图对象类型未找到！")
            }
        },

        setLocation:function(id)
        {
            var item = this.globalMap.districtHashtable[id];
            var feature = GeoJSON.toLineString(item);
            this.globalMap.setLocation(feature, { isClear: true });
        },

        mouseout: function (id) {
            this.targetThematic.mouseout(id)
        },
        mouseover: function (id) {
            this.targetThematic.mouseover(id)
        },

        clickFeatureHandler:function(e)
        {
            this.globalMap.dispathEvent("clickThemeFeature", e);
            var id = e.id;
            var geometryName=id+"-geo"
            this.load(geometryName, function (children) {

            });
        },
        clear: function () {
            if (this.drawVector) {
                this.drawVector.removeAllFeatures();
                if (this.globalMap.mapObject.getLayer(this.drawVector.id)) {
                    this.globalMap.mapObject.removeLayer(this.drawVector);
                }
            }
            for (var key in this.handlers) {
                if (this.handlers[key].instance)
                    this.handlers[key].instance.clear();
            }
            if (this.statsWidget) {
                this.statsWidget.clear();
            }
            this.isAdd = false;
        },
        CLASS_NAME: "BaseObject.ThematicLayer"
    });
    module.exports = BaseObject.ThematicLayer;
});