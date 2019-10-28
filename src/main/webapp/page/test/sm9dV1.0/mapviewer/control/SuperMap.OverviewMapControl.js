/// <reference path="../../leaflet/plugins/leaflet-miniMap/Control.MiniMap.min.js" />
define(function (require, exports, module) {
    BaseObject.OverviewMapControl = BaseHelper.Class.create();
    BaseObject.OverviewMapControl.prototype = BaseHelper.Class.inherit(BaseObject.Component, {

        initialize: function (globalMap, configData) {
            this.ID = this.getGUID();
            if (globalMap) {
                configData == null ? {} : configData;
                this.init(globalMap, configData);
            }
        },
        setIcon: function (icon) {
            this.icon = icon;
        },
        destroy: function () {

        },
        //初始化信息类
        init: function (globalMap, configData) {
            //alert("加载鹰眼控件");
            var thisCallBack = this;
            this.globalMap = globalMap;
            this.configData = configData;
            //初始化鹰眼控件类
            $("body").append('<script src="' + BaseObject.path+ '/sm9dV1.0/leaflet/plugins/leaflet-miniMap/Control.MiniMap.min.js"></script>')
            $("body").append('<link href="' + BaseObject.path + '/sm9dV1.0/leaflet/plugins/leaflet-miniMap/Control.MiniMap.min.css" rel="stylesheet" />');

            this.globalMap.addEventListener("loadMapCompleted", function (e) {thisCallBack.loadMapCompletedHandler(e, "loadMapCompleted")});
            this.globalMap.addEventListener("changedOverviewMap", function (e) { thisCallBack.loadMapCompletedHandler(e, "changedMapCompleted")});

        },
        loadMapCompletedHandler: function (a, b) {
             
            if (!this.minimap) {
                 var osm2 = L.supermap.tiledMapLayer(decodeURI(this.globalMap.currentMapLayer._url), { minZoom: 0, maxZoom: 13, noWrap: true });
                this.minimap = L.control.minimap(osm2, { mapOptions: { logoControl: false,name:"overviewer" }, toggleDisplay: true }).addTo(this.globalMap.mapObject);
            }
        },
        //初始化位置
        initPosition: function () {

        },
        resize: function () { },
        CLASS_NAME: "BaseObject.OverviewMapControl"
    });
    module.exports = BaseObject.OverviewMapControl;

});