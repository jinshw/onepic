define(function (require, exports, module) {
    BaseObject.LayerEditManage = BaseHelper.Class.create();
    BaseObject.LayerEditManage.prototype = BaseHelper.Class.inherit(BaseObject.Component, {
        initialize: function (globalMap, configData) {
            this.name = "LayerEditManage";
            if (globalMap) {
                configData == null ? {} : configData;
                this.init(globalMap, configData);
            }
        },

        init: function (globalMap) {
            var thisCallBack = this;

            this.globalMap = globalMap;

            this.activate();
            this.globalMap.addEventListener("unselectedFeature", function (e) {
                if (thisCallBack.unselectedFeatureTimer) window.clearInterval(thisCallBack.unselectedFeatureTimer);
                thisCallBack.unselectedFeatureTimer = window.setTimeout(function () {
                    thisCallBack.unselectedFeature(e)
                }, 1000);
            });
            this.globalMap.addEventListener("eidtFeatureCompleted", function (e) { thisCallBack.eidtFeatureCompleted(e) });
            this.globalMap.addEventListener("deleteFeatureCompleted", function (e) { thisCallBack.deleteFeatureCompleted(e) });
            this.globalMap.addEventListener("drawFeatureCompleted", function (e) { thisCallBack.drawFeatureCompleted(e) });
            this.globalMap.addEventListener("revokeFeatureCompleted", function (e) { thisCallBack.revokeFeatureCompleted(e) });

            this.globalMap.addEventListener("recoveryFeature", function (e) { thisCallBack.recoveryFeature(e) });
            this.globalMap.addEventListener("addFeatureCompleted", function (e) { thisCallBack.addFeatureCompleted(e) });
            this.globalMap.addEventListener("selectedFeature", function (e) { thisCallBack.selectedFeature(e) });


            this.globalMap.addEventListener("activeEditFeature", function (e) {
                thisCallBack.activeEditFeature(e.target)
            });
        },

        activeEditFeature: function (target)
        {
            this.target = target;
            this.globalMap.mapHandler.mapObject.pm.toggleGlobalEditMode({
                snappable: !0,
                draggable: !0
            })
        },

         
        setEditLayer: function (code) {
            this.globalMap.editTargetLayer = {
                code: code,
                type: "polygon"
            }
            this.globalMap.editManage.deactivate();
            this.globalMap.dispathEvent("setEditLayer", this.globalMap.editTargetLayer);
        },

        CLASS_NAME: "BaseObject.LayerEditManage"
    });
    module.exports = BaseObject.LayerEditManage;
});