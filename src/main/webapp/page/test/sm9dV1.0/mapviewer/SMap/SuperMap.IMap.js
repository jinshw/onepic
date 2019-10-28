BaseObject.IMap = BaseHelper.Class.create();
BaseObject.IMap.prototype = BaseHelper.Class.inherit(BaseHelper.GUID, BaseHelper.Clone, BaseHelper.EventListener, {
    initialize: function (a, b) {
        this.ID = this.getGUID()
    },
    init: function (configData, globalMap) {
        this.globalMap = globalMap
    },
    updateSize: function () { },
    zoomTo:function(){},
    setViewerBounds: function (coordinates, level) {},
    hide:function(){},
    show:function(){},
    addOverLayer: function (data) { },
    showFeatures: function (features, isDefault, isZoom) { },
    resetLayerIndex: function () { },
    setLocation: function (target, level) { },
    clearLocation: function (target) { },
    setChangeMap: function (code) { },
    removeOverLayer: function (data) { },
    clear: function () { },
    resetBaseMapLayer: function (configMap, callback) { },
    getMapCRS: function (type) { },
    destroy: function () { },
    CLASS_NAME: "BaseObject.IMap"
});