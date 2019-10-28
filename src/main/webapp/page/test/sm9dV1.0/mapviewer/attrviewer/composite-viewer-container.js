define(function (require, exports, module) {


    DFastUI_Map.Composite.ViewerContainer = BaseHelper.Class.create();
    DFastUI_Map.Composite.ViewerContainer.prototype = BaseHelper.Class.inherit(require("composite"), {

        initialize: function (data) {

            this._property = [];
            this._property.push({ FIELD_CNNAME: "关联类型", FIELD_ENNAME: "CLASS_TYPE", DFASTUI_TYPE: "component-dropdown-ui", VALIDATOR_TYPE: "EMPTY_CHECK", VALIDATOR_MSG: "需要输入正确的校验",
                JSON_DATA: '[{ label: "实体模板", value: "NONE" }, { label: "关联模板IN", value: "RELATION_IN"}, { label: "关联模板NOTIN", value: "RELATION_NOTIN"}]', DEFAULT_VALUE: "NONE"
            });
            this._property.push({ FIELD_CNNAME: "控件类型", FIELD_ENNAME: "DEFASTUI_TYPE", DFASTUI_TYPE: "component-labelInput-ui", VALIDATOR_TYPE: "EMPTY_CHECK", VALIDATOR_MSG: "需要输入正确的校验", DEFAULT_VALUE: this.DFASTUI_TYPE, READ_ONLY: "1" });
            this._property.push({ FIELD_CNNAME: "关联实体", FIELD_ENNAME: "CLASS", DFASTUI_TYPE: "component-labelInput-ui", VALIDATOR_TYPE: "EMPTY_CHECK", VALIDATOR_MSG: "需要输入正确的校验" });
            this.relationId = null;
            this.id = this.getGUID();
            return this._property;
        },
        init: function () {

        },


        setElement: function (value) {
            this._components = [];
            jQuery.fn.extend({
                getOwnerComponent: function () {
                    if (this[0] != undefined) return this[0].ownerComponent;
                    else return null
                },
                setOwnerComponent: function (v) {
                    try {
                        this[0].ownerComponent = v;
                        return this[0].ownerComponent
                    }
                    catch (e) { }
                }
            });
            this.element = value;
            this.element.setOwnerComponent(this);
            this.viewerContainer = this;
            this.viewerType = "NONE";
        },

        getViewer: function () {
            var data = {};
            var viewerData = [];
            if (this._jsonViewer) {
                viewerData = this._jsonViewer;
                viewerData.children = [];

                for (var index = 0; index < this._components.length; index++) {
                    var component = this._components[index];
                    var item = component.getViewer();
                    if (item)
                        viewerData.children.push(item);
                }
            }
            data.root = viewerData;
            return data;
        },

        create: function (configData, iDrag) {
            this.iDrag = iDrag == "undefined" ? false : true;
            this.superCreate(configData, iDrag);
            var children = configData.children;
            if (children) {
                var component_manager_facotry = require("component-manager-facotry");
                this.cptFactoryInstance = new component_manager_facotry();
                if (children.length) {
                    for (var index = 0; index < children.length; index++) {
                        var item = children[index];
                        this._createComponent(item, iDrag);
                    }
                }
                else {
                    this._createComponent(children, iDrag);
                }
            }
            this.viewerType = this.configData.CLASS_TYPE;
        },

        ressetElement: function (value) {
            this.setElement($("#" + value));
            this.load(this.configData, false);
        },

        _createComponent: function (item, iDrag) {
            if (!item.DFASTUI_TYPE) return;
            var component = this.cptFactoryInstance.createComponent(item.DFASTUI_TYPE);
            component.parent = this;
            component.viewerContainer = this;
            if (component) {
                if (component.BASEUI_TYPE == "composite")
                    component.cptFactoryInstance = this.cptFactoryInstance;
                this._components.push(component);
                var ele = component.create(item, iDrag);
                component.setProperty(item);
                if (ele && this.element) {
                    this.element.append(ele);
                }

            }
        },

        load: function (configData, iDrag) {
            if (!configData) return;
            this.viewerType = configData.CLASS_TYPE;
            this.clear();
            this.create(configData, iDrag);
            this.setProperty(configData);
            this.show();
            GlobalEventBus.dispathPreloadEvent(this.id);
        },

        clear: function () {
            for (var index = 0; index < this._components.length; index++) {
                var tmpComponent = this._components[index];
                tmpComponent.destroy();
                tmpComponent = null;
                index--;
            }

            this._components.length = 0;
        },

        ///////////////////////////////处理远程服务回掉///////////////////



        DFASTUI_TYPE: "composite-viewer-container",
        CLASS_NAME: "DFastUI_Map.Composite.ViewerContainer"
    });

    module.exports = DFastUI_Map.Composite.ViewerContainer;

});