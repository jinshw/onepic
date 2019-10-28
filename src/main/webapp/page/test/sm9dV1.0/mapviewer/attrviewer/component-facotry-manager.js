define(function (require, exports, module) {

    var isInit = false;

    var UIManagerFactory = BaseHelper.Class.create();
    UIManagerFactory.prototype = BaseHelper.Class.inherit(BaseHelper.GUID, BaseHelper.Clone, BaseHelper.EventListener, {

        //构造函数
        initialize: function (data) {
            this.components = [];
            this.shadowDragUI = require("../attrviewer/shadow-drag-ui");
        },
        init: function () {

        },

        destroy: function () {
        },

        create: function (configData) {


        },

        remove: function (componentId) {
        },

        getComponent: function (componentId) {
        },

        setViewerContainer: function (value) {
            this.viewerContainer = value;
        },

        createComponentAnys: function (type, callback) {
            var that = this;
            require.async([type], function (c) {
                var componentClass = c;

                if (componentClass) {

                    var instance = new componentClass();
                    instance.shadowDragUI = that.shadowDragUI;
                    instance.uiFactoryInstance = that;
                    instance.viewerContainer = that.viewerContainer;

                    return callback(instance);
                }
                else
                    return callback(null);
            });
        },

        createComponent: function (type, callback) {

            componentClass = require(type);
            if (type == "component-validator-select-ui") {
                //alert(type);
            }
            if (componentClass) {

                var instance = new componentClass();
                instance.shadowDragUI = this.shadowDragUI;
                instance.uiFactoryInstance = this;
                instance.viewerContainer = this.viewerContainer;

                return instance;
            }
            else
                return null;

        },
        CLASS_NAME: "UIManagerFactory"
    });

    module.exports = UIManagerFactory;

})

 