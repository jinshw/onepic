define(function (require, exports, module) {
    BaseObject.BaseDrawVectorLayer = BaseHelper.Class.create();
    BaseObject.BaseDrawVectorLayer.prototype = BaseHelper.Class.inherit(BaseObject.Component, {

        initialize: function () {
            this.name = "BaseDrawVector";
            this.isAdd = false;
        },


        init: function (globalMap) {
            this.globalMap = globalMap;
            this.drawVector = L.geoJSON();
            var thisCallBack = this;
            var callbacks = {
                click: function (currentFeature) {
                    thisCallBack.globalMap.dispathEvent("showProperty", currentFeature);
                    thisCallBack.globalMap.dispathEvent("activateEditFeature", currentFeature);
                    thisCallBack.globalMap.dispathEvent("clickFeature", currentFeature);
                }, over: function (currentFeature,e) {
                    if (currentFeature.geometry.CLASS_NAME == "SuperMap.Geometry.Point")
                        thisCallBack.globalMap.dispathEvent("selectedFeature", currentFeature);
                    thisCallBack.showInfoPopup(currentFeature);

                }, out: function (currentFeature) {
                    if (currentFeature.geometry.CLASS_NAME == "SuperMap.Geometry.Point")
                        thisCallBack.globalMap.dispathEvent("unselectedFeature", currentFeature);
                    thisCallBack.hideInfoPopup();
                }
            };
            this.globalMap.addEventListener("mapZoomend", function (e) { thisCallBack.globalMap.hideInfoPopup() });
        },

        deactivate: function () {
            if (this.selectFeature) {
                this.selectFeature.deactivate();
            }
        },
        getLayer: function (status) {
            if (!this.isAdd) {
                this.globalMap.mapObject.addLayer(this.drawVector);
                this.drawVector.setZIndex(999999);
                this.isAdd = true;
            }
            return this.drawVector;
        },
 

        activate: function () {
            
        },

        clear: function () {

            if (this.isAdd) {
                this.drawVector.remove();
                if (this.globalMap.mapObject.hasLayer(this.drawVector))
                    this.globalMap.mapObject.removeLayer(this.drawVector);

                this.isAdd = false;
            }
        },

        CLASS_NAME: "BaseObject.BaseDrawVectorLayer"
    });
    module.exports = BaseObject.BaseDrawVectorLayer;
});