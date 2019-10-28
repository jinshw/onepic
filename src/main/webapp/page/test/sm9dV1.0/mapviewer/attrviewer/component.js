define(function (require, exports, module) {


    //UI控件基类,所有的UI必须实现此类
    DFastUI_Map.AbstractComponent = BaseHelper.Class.create();
    DFastUI_Map.AbstractComponent.prototype = BaseHelper.Class.inherit(BaseHelper.GUID, BaseHelper.Clone, BaseHelper.EventListener, require("drag-ui"), {

        //构造函数
        initialize: function (data) {
            this.element;
            this.viewerContainer;
            this.parent;
            this.validator = require("superValidator");
            this.configData = null;
            this._jsonViewer = null;

            this._property = [{
                FIELD_CNNAME: "ID",
                FIELD_ENNAME: "ID",
                DFASTUI_TYPE: "component-labelInput-ui",
                VALIDATOR_TYPE: "EMPTY_CHECK",
                VALIDATOR_MSG: "字段输入不能为空！",
                DEFAULT_VALUE: this.getGUID(),
                READ_ONLY: "1"
            }, {
                FIELD_CNNAME: "字段中文名称",
                FIELD_ENNAME: "FIELD_CNNAME",
                DFASTUI_TYPE: "component-labelInput-ui",
                VALIDATOR_TYPE: "EMPTY_CHECK",
                VALIDATOR_MSG: "字段输入不能为空！"
            },
			{
			    FIELD_CNNAME: "字段英文名称",
			    FIELD_ENNAME: "FIELD_ENNAME",
			    DFASTUI_TYPE: "component-labelInput-ui",
			    VALIDATOR_TYPE: "EMPTY_CHECK",
			    VALIDATOR_MSG: "字段输入不能为空！"
			},
            {
                FIELD_CNNAME: "默认值",
                FIELD_ENNAME: "DEFAULT_VALUE",
                DFASTUI_TYPE: "component-labelInput-ui",
                VALIDATOR_TYPE: "EMPTY_CHECK",
                VALIDATOR_MSG: "字段输入不能为空！"
            },
			{
			    FIELD_CNNAME: "控件类型",
			    FIELD_ENNAME: "DFASTUI_TYPE",
			    DFASTUI_TYPE: "component-labelInput-ui",
			    VALIDATOR_TYPE: "ISNULL_CHECK",
			    VALIDATOR_MSG: "字段输入不能为空！",
			    DEFAULT_VALUE: this.DFASTUI_TYPE,
			    READ_ONLY: "1"
			},
			{
			    FIELD_CNNAME: "校验规则",
			    FIELD_ENNAME: "VALIDATOR_TYPE",
			    DFASTUI_TYPE: "component-validator-select-ui",
			    VALIDATOR_TYPE: "EMPTY_CHECK",
			    VALIDATOR_MSG: "字段输入不能为空！",
			    DEFAULT_VALUE: ""
			},
			{
			    FIELD_CNNAME: "校验提示",
			    FIELD_ENNAME: "VALIDATOR_MSG",
			    DFASTUI_TYPE: "component-labelInput-ui",
			    VALIDATOR_TYPE: "EMPTY_CHECK",
			    VALIDATOR_MSG: "字段输入不能为空！",
			    DEFAULT_VALUE: "字段输入不能为空！"
			},
			{
			    FIELD_CNNAME: "是否只读",
			    FIELD_ENNAME: "READ_ONLY",
			    DFASTUI_TYPE: "component-radio-ui",
			    VALIDATOR_TYPE: "INTEGER_CHECK",
			    VALIDATOR_MSG: "字段输入不能为空！",
			    DEFAULT_VALUE: "字段输入不能为空！",
			    JSON_DATA: "[{value:#0#,label:#否#},{value:#1#,label:#是#}]",
			    DEFAULT_VALUE: "0"
			},
            {
                FIELD_CNNAME: "是否必填",
                FIELD_ENNAME: "IS_REQUIRED",
                DFASTUI_TYPE: "component-radio-ui",
                VALIDATOR_TYPE: "INTEGER_CHECK",
                VALIDATOR_MSG: "字段输入不能为空！",
                DEFAULT_VALUE: "字段输入不能为空！",
                JSON_DATA: "[{value:#0#,label:#否#},{value:#1#,label:#是#}]",
                DEFAULT_VALUE: "0"
            },
            {
                FIELD_CNNAME: "标签宽度",
                FIELD_ENNAME: "LABEL_WIDTH",
                DFASTUI_TYPE: "component-labelInput-ui",
                VALIDATOR_TYPE: "INTEGER_CHECK",
                VALIDATOR_MSG: "字段输入不能为空！",
                DEFAULT_VALUE: "80"
            },
			{
			    FIELD_CNNAME: "宽度",
			    FIELD_ENNAME: "WIDTH",
			    DFASTUI_TYPE: "component-labelInput-ui",
			    VALIDATOR_TYPE: "INTEGER_CHECK",
			    VALIDATOR_MSG: "输入必须为正整数！",
			    DEFAULT_VALUE: "0"
			},
			{
			    FIELD_CNNAME: "高度",
			    FIELD_ENNAME: "HEIGHT",
			    DFASTUI_TYPE: "component-labelInput-ui",
			    VALIDATOR_TYPE: "INTEGER_CHECK",
			    VALIDATOR_MSG: "输入必须为正整数！",
			    DEFAULT_VALUE: "0"
			},
            {
                FIELD_CNNAME: "行列索引",
                FIELD_ENNAME: "ROW_COL_INDEX",
                DFASTUI_TYPE: "component-labelInput-ui",
                VALIDATOR_TYPE: "EMPTY_CHECK",
                VALIDATOR_MSG: "输入必须为正整数！",
                DEFAULT_VALUE: "-",
                READ_ONLY: "1"
            },
            {
                FIELD_CNNAME: "行跨度rowspan",
                FIELD_ENNAME: "ROW_SPAN",
                DFASTUI_TYPE: "component-labelInput-ui",
                VALIDATOR_TYPE: "INTEGER_CHECK",
                VALIDATOR_MSG: "输入必须为正整数！",
                DEFAULT_VALUE: "1"
            },
            {
                FIELD_CNNAME: "列跨度colspan",
                FIELD_ENNAME: "COL_SPAN",
                DFASTUI_TYPE: "component-labelInput-ui",
                VALIDATOR_TYPE: "INTEGER_CHECK",
                VALIDATOR_MSG: "输入必须为正整数！",
                DEFAULT_VALUE: "1"
            },
            {
                FIELD_CNNAME: "绑定目标事件",
                FIELD_ENNAME: "BINDING_TARGET_EVENT",
                DFASTUI_TYPE: "component-labelTextarea-ui",
                VALIDATOR_TYPE: "JSON_CHECK",
                VALIDATOR_MSG: "",
                DEFAULT_VALUE: "[{ID:'目标控件ID',EVENT_NAME:'事件名称'}]"
            }
            //{ FIELD_CNNAME: "密码", FIELD_ENNAME: "PWD", DFASTUI_TYPE: "component-pwd-combobox-ui", VALIDATOR_TYPE: "PWD_CHECK", VALIDATOR_MSG: "输入必须为正整数！", DEFAULT_VALUE: "0.0" }
			]
        },

        init: function () {

        },

        create: function (configData, iDrag) {
            superCreate(configData, iDrag);
            this.iDrag = iDrag;
        },

        superCreate: function (configData, iDrag) {
            this.iDrag = iDrag;
            this.id = this.getGUID();
            if (configData) {
                this.configData = configData;
                this.elementId = configData.FIELD_ENNAME + this.id;
                this.setProperty(configData);
            }
            else {

                this.elementId = this.id;
            }

            this.innerEventBus();
        },



        setProperty: function (conf) {
            this._jsonViewer = {};
            this.updatePropreryItem(conf);
            if (this.iDrag)
                this.changeProperty(this._property, this._jsonViewer)
        },

        appendTo: function (ele) {

            var ownerComponent = ele.getOwnerComponent();
            ownerComponent.selectTargetEle = ele;

            if (ownerComponent) {
                this.element.addClass("dfastui-drag-bgcolor");
                ownerComponent.append(this.element);
                var rowColIndex = ele.attr("rowColIndex") == undefined ? "-" : ele.attr("rowColIndex");
                this.updatePropreryItem({ "ROW_COL_INDEX": rowColIndex, "COL_SPAN": 1, "ROW_SPAN": 1 });
                this.show();
            }
        },

        _initJsonViewer: function () {
            if (this._jsonViewer == null) {
                this._jsonViewer = {};
                for (var index = 0; index < this._property.length; index++) {
                    var item = this._property[index];
                    this._jsonViewer[item.FIELD_ENNAME] = item.VALUE || item.DEFAULT_VALUE || "";
                }
            }
        },

        updatePropreryItem: function (conf) {
            this._initJsonViewer();
            for (var key in conf) {
                var value = conf[key];
                for (var index = 0; index < this._property.length; index++) {
                    var item = this._property[index]
                    if (item) {
                        if (item["FIELD_ENNAME"] == key) {
                            item["VALUE"] = value;
                            break;
                        }
                    }
                }

                if (this._jsonViewer) {
                    this._jsonViewer[key] = value;
                }
            }
        },

        show: function () {

            this.initializeCallBack();
            this.bindValidator();
            this.resize();

            //this.getValidator();
        },

        resize: function () {
        },

        getValidator: function () {
            return this.validator.check(this.elementId);
        },

        getElement: function () {
            return this.element;
        },

        setElement: function (value) {

        },

        bindValidator: function () {
            if (this.configData && this.configData.VALIDATOR_TYPE) {
                this.validator.bind(this.elementId, this.configData.VALIDATOR_TYPE);
            }
        },

        initializeCallBack: function () {

        },

        getObjectClass: function () {
            if (this.viewerContainer.configData)
                return this.viewerContainer.configData.CLASS;
        },

        getObjectRelationId: function () {
             return this.viewerContainer.relationId;
        },

        getViewerType: function () {
            return this.viewerContainer.viewerType;
        },

        getObjectClassId: function () {
            return this.viewerContainer.id;
        },

        getEntityType: function () {
            return this.viewerContainer.configData.CLASS_TYPE;
        },

        getValue: function () {
            var value = {};

            var el = document.getElementById(this.elementId);

            if (el) {
                value[this.configData.FIELD_ENNAME] = el.value || this.configData.DEFAULT_VALUE || "";
            }

            return value;
        },
        reset: function () {
            var el = document.getElementById(this.elementId);
            if (el)
            el.value = "";
        },

        setValue: function (data) {
            var el = document.getElementById(this.elementId);
            this.currentValue = data;
            if (el) {
                el.value = data[this.configData.FIELD_ENNAME] || this.configData.DEFAULT_VALUE || "";
            }
        },

        setDisabled: function (value) {
            var el = document.getElementById(this.elementId);
            if (el && this.configData.READ_ONLY != 1) {
                if (value)
                    $(el).attr("disabled", "disabled");
                else
                    $(el).removeAttr("disabled", "disabled");
            }
        },

        restore: function () {
            setValue(this.currentValue);
        },

        destroy: function () {

            if (this.parent) this.parent.remove(this);
            if (this.element)
                this.element.remove();

            this.eventMethods = [];
        },

        getViewer: function () {
            return this._jsonViewer;
        },
        setViewer: function (value) {
            this._jsonViewer = value;
        },

        checkValidator: function () {
            if (this.configData) return this.validator.check(this.elementId);
        },

        removeEventAll: function () {
            this.EventBus.removeEventByClassId(this.viewerContainer);
        },

        addProperty: function (item, index) {
            var property = this.getProperty();
            if (index == undefined)
                property.push(item);
            else {
                property.insert(index, item);
            }
        },

        getPropertyByName: function (name) {
            var property = this.getProperty();
            for (var index = 0; index < property.length; index++) {
                var item = property[index];
                if (item) {
                    if (item["FIELD_ENNAME"] == name) {
                        return property[index];
                    }
                }
            }
        },


        getProperty: function () {
            return this._property;
        },

        getPropertyItemCfg: function () {
            var el = document.getElementById(this.elementId);
            if (el)
                this.configData.VALUE = el.value;

            return this.configData;
        },

        changeProperty: function (property, jsonViewer) {

            this.superChangeProperty(property, jsonViewer);
        },

        superChangeProperty: function (property, jsonViewer) {
            this._property = property;
            this._jsonViewer = jsonViewer;
            if (this.element) {
                this.element.css({ width: "100%" })
            }
            if (jsonViewer) {
                if (parseInt(jsonViewer.WIDTH) !== 0) {
                    if (this.element)
                        this.element.css({ width: parseInt(jsonViewer.WIDTH) + "px" })
                }
                if (parseInt(jsonViewer.HEIGHT) !== 0) {
                    if (this.element)
                        this.element.css({ height: parseInt(jsonViewer.HEIGHT) + "px" })
                }
                if (parseInt(jsonViewer.LABEL_WIDTH) !== 0) {
                    $("#label" + this.id).css({ width: jsonViewer.LABEL_WIDTH + "px" })
                }
                if (jsonViewer.FIELD_CNNAME !== "") {
                    $("#label" + this.id).html(jsonViewer.FIELD_CNNAME);
                    this.resetLabel(jsonViewer.FIELD_CNNAME);
                }
            }
            if (this.element) {
                if (this.parent)
                    this.parent.refresh();
            }
        },

        resetLabel: function (value) {
            $("#label" + this.id).html();
        },


        CLASS_NAME: "DFastUI_Map.AbstractComponent"
    });

    module.exports = DFastUI_Map.AbstractComponent;

});