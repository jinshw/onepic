define(function (require, exports, module) {

    //组合容器基类
    DFastUI_Map.AbstractComposite = BaseHelper.Class.create();
    DFastUI_Map.AbstractComposite.prototype = BaseHelper.Class.inherit(BaseHelper.GUID, BaseHelper.Clone, BaseHelper.EventListener, {

        //构造函数
        initialize: function (data) {

            this._components = [];
            this.BASEUI_TYPE = "composite";
            this.id = this.getGUID();
            this.selectTargetEle = null;
            this._property = [];
            this.uiFactoryInstance = null;
            this.viewerContainer = null;
            this.iDrag = true;
        },

        superCreate: function (configData, iDrag) {
            if (configData) {
                this.configData = configData;
                this.elementId = "composite" + this.id;
                this.setProperty(configData);
            }
            else {
                this.elementId = this.id;
            }
        },

        init: function () {

        },

        append: function (child) {
            this.superAppend(child);
        },

        appendTo: function (ele) {
            this.supperAppendTo(ele);
        },

        add: function (component) {
            this.superAdd(component);
        },

        remove: function (component) {
            this.superRemove(component);
        },

        superAdd: function (component) {

            if (component.parent != null) {
                component.parent.remove(component);
            }
            component.parent = this;

            this._components.push(component)
        },

        superAppend: function (child) {
            var ownerComponent = child.getOwnerComponent();

            this.add(ownerComponent);
            if (this.selectTargetEle) {
                this.selectTargetEle.append(child);
                var rowColIndex = this.selectTargetEle.attr("rowColIndex") == undefined ? "-" : this.selectTargetEle.attr("rowColIndex");
                ownerComponent.getProperty();
                ownerComponent.updatePropreryItem({ "ROW_COL_INDEX": rowColIndex, "COL_SPAN": 1, "ROW_SPAN": 1 });
            }
        },
        supperAppendTo: function (ele) {

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


        getComponentById: function (id) {
            for (var index = 0; index < this._components.length; index++) {
                var item = this._components[index];
                if (item.configData.ID == id) {
                    return item;
                }
                else {
                    if (item.BASEUI_TYPE == 'composite' && item.getComponents().length > 0) {
                        return item.getComponentById(id);
                    }
                }
            }
        },

        getValue: function () {

            var data = {};

            for (var index = 0; index < this._components.length; index++) {
                var item = this._components[index];
                var tmpValue = item.getValue();
                for (var key in tmpValue) {
                    data[key] = tmpValue[key];
                }
            }

            return data;
        },

        removeEventAll: function () {
            for (var index = 0; index < this._components.length; index++) {
                var item = this._components[index];
                item.removeEventAll();
            }
        },

        getValidator: function () {

            var isOk = false;

            for (var index = 0; index < this._components.length; index++) {
                var item = this._components[index];
                isOk = item.getValidator();
                if (!isOk) return isOk;
            }

            return isOk;
        },

        reset: function () {
            for (var index = 0; index < this._components.length; index++) {
                var item = this._components[index];
                item.reset()
            }
        },

        setValue: function (data) {

            for (var index = 0; index < this._components.length; index++) {
                var item = this._components[index];
                item.setValue(data)
            }
        },

        setDisabled: function (value) {

            for (var index = 0; index < this._components.length; index++) {
                var item = this._components[index];
                item.setDisabled(value)
            }
        },




        getChild: function () { },

        removeAll: function () { },

        superRemove: function (component) {

            for (var index = 0; index < this._components.length; index++) {
                var tmpComponent = this._components[index];
                if (component.id == tmpComponent.id) {
                    this._components.splice(index, 1);
                    return;
                }
            }
        },

        destroy: function () {

            this.superDestroy();

        },

        changeProperty: function (property, jsonViewer) {
            this._property = property;
            this._jsonViewer = jsonViewer;

            if (parseInt(jsonViewer.WIDTH) !== 0) {
                if (this.element)
                    this.element.css({ width: parseInt(jsonViewer.WIDTH) + "px" })
            }
            else {
                if (this.element)
                    this.element.css({ width: "100%" })
            }

            if (parseInt(jsonViewer.HEIGHT) !== 0) {
                if (this.element)
                    this.element.css({ height: parseInt(jsonViewer.HEIGHT) + "px" })
            }
            if (jsonViewer.TEXT_ALIGN) {
                if (this.element)
                    this.element.css("text-align", jsonViewer.TEXT_ALIGN);
            }
            if (jsonViewer.LEFT_WIDTH != undefined && parseInt(jsonViewer.LEFT_WIDTH) !== 0) {
                var left_container = $("#left" + this.id);
                var right_container = $("#right" + this.id);
                if (left_container && right_container) {

                    left_container.css({ width: parseInt(jsonViewer.LEFT_WIDTH) + "px" })
                    var width = left_container.parent().width() - jsonViewer.LEFT_WIDTH - 2;
                    right_container.css({ width: width + "px" })
                    right_container.css({ "margin-left": parseInt(jsonViewer.LEFT_WIDTH) - 1 + "px" });
                }
            }
            if (jsonViewer.TOP_HEIGHT != undefined && parseInt(jsonViewer.TOP_HEIGHT) !== 0) {
                var top_container = $("#top" + this.id);
                if (top_container) {
                    top_container.css({ height: parseInt(jsonViewer.TOP_HEIGHT) + "px" });
                }
            }
            if ((jsonViewer.BOTTOM_HEIGHT != undefined && parseInt(jsonViewer.BOTTOM_HEIGHT) !== 0)
                  && jsonViewer.TOP_HEIGHT != undefined && parseInt(jsonViewer.TOP_HEIGHT) == 0) {
                var bottom_container = $("#center" + this.id);
                var top_container = $("#top" + this.id);

                if (bottom_container && top_container) {
                    var viewerHeight = top_container.parent().height() - 2;
                    top_container.css({ height: viewerHeight - parseInt(jsonViewer.BOTTOM_HEIGHT) });
                    bottom_container.css({ height: parseInt(jsonViewer.BOTTOM_HEIGHT) + "px" });
                }
            }
            if (this.parent) {
                if (this.element)
                    this.parent.refresh();
            }
        },

        getProperty: function () {
            if (this._property.length == 0) {
                this._property = [{
                    FIELD_CNNAME: "ID",
                    FIELD_ENNAME: "ID",
                    DFASTUI_TYPE: "component-labelInput-ui",
                    VALIDATOR_TYPE: "EMPTY_CHECK",
                    VALIDATOR_MSG: "字段输入不能为空！",
                    DEFAULT_VALUE: this.getGUID(),
                    READ_ONLY: "1"
                }, {
                    FIELD_CNNAME: "控件类型",
                    FIELD_ENNAME: "DFASTUI_TYPE",
                    DFASTUI_TYPE: "component-labelInput-ui",
                    VALIDATOR_TYPE: "EMPTY_CHECK",
                    VALIDATOR_MSG: "字段输入不能为空！",
                    DEFAULT_VALUE: this.DFASTUI_TYPE,
                    READ_ONLY: "1"
                },
                {
                    FIELD_CNNAME: "行数",
                    FIELD_ENNAME: "ROW_COUNT",
                    DFASTUI_TYPE: "component-labelInput-ui",
                    VALIDATOR_TYPE: "INTEGER_CHECK",
                    VALIDATOR_MSG: "输入必须为正整数！",
                    DEFAULT_VALUE: "2",
                    READ_ONLY: "1"
                },
                {
                    FIELD_CNNAME: "列数",
                    FIELD_ENNAME: "COL_COUNT",
                    DFASTUI_TYPE: "component-labelInput-ui",
                    VALIDATOR_TYPE: "INTEGER_CHECK",
                    VALIDATOR_MSG: "输入必须为正整数！",
                    DEFAULT_VALUE: "2",
                    READ_ONLY: "1"
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
                    FIELD_CNNAME: "text-align",
                    FIELD_ENNAME: "TEXT_ALIGN",
                    DFASTUI_TYPE: "component-labelInput-ui",
                    VALIDATOR_MSG: "请输入JSON字符串格式！",
                    VALIDATOR_TYPE: "ISNULL_CHECK",
                    DEFAULT_VALUE: "center"
                },
                {
                    FIELD_CNNAME: "border",
                    FIELD_ENNAME: "BORDER",
                    DFASTUI_TYPE: "component-labelInput-ui",
                    VALIDATOR_MSG: "请输入JSON字符串格式！",
                    VALIDATOR_TYPE: "ISNULL_CHECK",
                    DEFAULT_VALUE: "0px solid #ccc;"
                },
                {
                    FIELD_CNNAME: "border-left",
                    FIELD_ENNAME: "BORDER_LEFT",
                    DFASTUI_TYPE: "component-labelInput-ui",
                    VALIDATOR_MSG: "请输入JSON字符串格式！",
                    VALIDATOR_TYPE: "ISNULL_CHECK",
                    DEFAULT_VALUE: "0px dashed #ccc;"
                }
                 ,
                {
                    FIELD_CNNAME: "border-top",
                    FIELD_ENNAME: "BORDER_TOP",
                    DFASTUI_TYPE: "component-labelInput-ui",
                    VALIDATOR_MSG: "请输入JSON字符串格式！",
                    VALIDATOR_TYPE: "ISNULL_CHECK",
                    DEFAULT_VALUE: "0px dashed #ccc;"
                },
                {
                    FIELD_CNNAME: "border-right",
                    FIELD_ENNAME: "BORDER_RIGHT",
                    DFASTUI_TYPE: "component-labelInput-ui",
                    VALIDATOR_MSG: "请输入JSON字符串格式！",
                    VALIDATOR_TYPE: "ISNULL_CHECK",
                    DEFAULT_VALUE: "0px dashed #ccc;"
                },
                {
                    FIELD_CNNAME: "border-bottom",
                    FIELD_ENNAME: "BORDER_BOTTOM",
                    DFASTUI_TYPE: "component-labelInput-ui",
                    VALIDATOR_MSG: "请输入JSON字符串格式！",
                    VALIDATOR_TYPE: "ISNULL_CHECK",
                    DEFAULT_VALUE: "0px dashed #ccc;"
                }]

            }
            return this._property;
        },

        superDestroy: function () {

            for (var index = 0; index < this._components.length; index++) {
                var tmpComponent = this._components[index];
                tmpComponent.destroy();
                tmpComponent = null;
                index--;
            }

            this._components.length = 0;

            if (this.parent) this.parent.remove(this);
            if (this.element)
                this.element.remove();

        },

        refresh: function () {

        },


        getComponents: function () {
            return this._components;
        },

        createChildren: function (children) {
            if (children) {
                if (children.length && children.length > 0) {
                    for (var index = 0; index < children.length; index++) {
                        var item = children[index];

                        var component = this.uiFactoryInstance.createComponent(item.DFASTUI_TYPE);
                        component.viewerContainer = this.viewerContainer;
                        component.setViewer(item);
                        component.create(item, this.iDrag);
                        component.parent = this;
                        this._components.push(component);
                    }
                }
                else {
                    if (children.DFASTUI_TYPE) {
                        var component = this.uiFactoryInstance.createComponent(children.DFASTUI_TYPE);
                        component.viewerContainer = this.viewerContainer;
                        component.setViewer(children);
                        component.create(children, this.iDrag);
                        component.parent = this;
                        this._components.push(component);
                    }
                }
            }
        },



        show: function () {
            this.superShow();
        },

        superShow: function () {
            for (var index = 0; index < this._components.length; index++) {
                var child = this._components[index];
                child.show();
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

        setProperty: function (conf) {
            this._jsonViewer = {};
            this.getProperty();
            this.updatePropreryItem(conf);
            if (this.iDrag)
                this.changeProperty(this._property, this._jsonViewer);
        },

        updatePropreryItem: function (conf) {
            this._initJsonViewer();
            for (var key in conf) {
                var value = conf[key];
                for (var index = 0; index < this._property.length; index++) {
                    var item = this._property[index]

                    if (item["FIELD_ENNAME"] == key) {
                        item["VALUE"] = value;
                        break;
                    }
                }

                if (this._jsonViewer) {
                    this._jsonViewer[key] = value;
                }
            }
        },

        getElement: function () {
            return this.element;
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
                if (item.FIELD_ENNAME == name) {
                    return item;
                }
            }
        },


        getViewer: function () {

            var viewerData = this._jsonViewer;
            viewerData.children = [];
            for (var index = 0; index < this._components.length; index++) {
                var component = this._components[index];
                var item = component.getViewer();
                if (item) viewerData.children.push(item);
            }
            return viewerData;
        },

        resize: function () {

            for (var index = 0; index < this._components.length; index++) {
                var component = this._components[index];
                component.resize();
            }
        },

        getProxyViewer: function () {

            return this._jsonViewer;
        },

        setViewer: function (value) {
            this._jsonViewer = value;
        },

        CLASS_NAME: "DFastUI_Map.AbstractComposite"
    });

    module.exports = DFastUI_Map.AbstractComposite;

});