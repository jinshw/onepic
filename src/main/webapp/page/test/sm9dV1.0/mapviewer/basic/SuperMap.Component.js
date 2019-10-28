 
    BaseObject.Component = BaseHelper.Class.create();
    BaseObject.Component.prototype = BaseHelper.Class.inherit(BaseHelper.GUID, BaseHelper.Clone, BaseHelper.EventListener, {
        ID: null,
        initialize: function (a, b) {
            this.ID = this.getGUID();
            this.top = 20;
            this.left = 0;
            this.right = 0;
            this.bottom = 0;
            this.center = 0;
        },

        init: function (configData, globalMap) {
        },

        initializeCallBack: function () {

        },

        hide: function () {
            if (this.element)
            $(this.element).css({ "display": "none" });
        },

        display: function () {
            if (this.element)
            $(this.element).css({ "display": "block" });
        },

        activate: function () {

        },
        resize: function () {
            if (this.configData && this.configData.position) {
                this.left = this.configData.position.left || 0;
                this.top = this.configData.position.top || 0;
                this.bottom = this.configData.position.bottom || 0;
                this.right = this.configData.position.right || 0;
                this.center = this.configData.position.center || 0;
            }
            if ((this.left > 0 && this.right == 0) && this.bottom == 0) {
                var left = $(this.globalMap.mapHandler.container).position().left + this.left;
                var top = $(this.globalMap.mapHandler.container).position().top + this.top;

                $(this.element).css({
                    "left": left + "px",
                    "top": top + "px"
                });
            }
            else if (this.left == 0 && this.right > 0 & this.bottom == 0) {
                var left = $(this.globalMap.mapHandler.container).position().left + $(this.globalMap.mapHandler.container).width() - $(this.element).width() - 2 - this.right;
                var top = $(this.globalMap.mapHandler.container).position().top + this.top;

                $(this.element).css({
                    "left": left + "px",
                    "top": top + "px"
                });
            }

            else if (this.bottom > 0 && this.right > 0) {
                var left = $(this.globalMap.mapHandler.container).position().left + $(this.globalMap.mapHandler.container).width() - $(this.element).width() - 5 - this.right;
                var top = $(this.globalMap.mapHandler.container).height() - $(this.element).height() - this.bottom;

                $(this.element).css({
                    "left": left + "px",
                    "top": top + "px"
                });
            }

            else if (this.bottom > 0 && this.top == 0) {
                var top = $(this.globalMap.mapHandler.container).height() - $(this.element).height() - this.bottom;
                var left = $(this.globalMap.mapHandler.container).position().left + this.left;

                $(this.element).css({ "left": left + "px", "top": top + "px" });
            }
            if (this.center==1) {
                var top = $(this.globalMap.mapHandler.container).height() - $(this.element).height() - this.bottom;
                var left = ($(this.globalMap.mapHandler.container).width() - $(this.element).width()) / 2;

                $(this.element).css({
                    "left": left + "px",
                    "top": top + "px"
                });
            }
        },

        initPosition: function () {
            if (this.configData.position) {
                this.top = this.configData.position.top || this.top;
                this.left = this.configData.position.left || this.left;
                this.right = this.configData.position.right || this.right;
                this.bottom = this.configData.position.bottom || this.bottom;
            }
        },

        setDisabled: function (value) {
            if (this.elementHandler) {
                if (value) {
                    $(this.elementHandler).attr("disabled", true);
                    $(this.elementHandler).addClass("tool_disabled");
                    
                }
                else {
                    $(this.elementHandler).attr("disabled", false);
                    $(this.elementHandler).removeClass("tool_disabled");
                }
            }
        },

        clear: function () {
            this.setDisabled(true);
        },

        destroy: function () {
        },
        initChildren: function () {
        },
        //初始化位置

        CLASS_NAME: "BaseObject.Component"
    });
 