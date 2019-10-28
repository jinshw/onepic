define(function (require, exports, module) {
    BaseObject.ToolCollectionControl = BaseHelper.Class.create();
    BaseObject.ToolCollectionControl.prototype = BaseHelper.Class.inherit(BaseObject.Component, {

        initialize: function (globalMap, configData) {
            this.top = 0;
            this.left = 0;
            this.right = 0;
            this.bottom = 40;
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

            this.configData = configData;
            this.globalMap = globalMap;
            this.getHtml();
            this.loadTools();
            this.resize();
        },

        loadTools: function () {
            var thisCallBack = this;
            var tools = [];
            for (var index = 0; index < this.globalMap.configData.tools.length; index++) {
                tools.push(this.globalMap.configData.tools[index]);
            }
            load(tools);
            function load(data) {
                if (data.length > 0) {
                    var item = data[0];
                    require.async(BaseObject.path + "/" + item.url,
                    function (a) {
                        data.splice(0, 1);

                        var instance = new a();
                        instance.init(thisCallBack.globalMap, item);
                        $("#collectContainer").append(instance.getHtml());
                        instance.initializeCallBack();
                        load(data);
                    });
                }
                else {
                    
                    thisCallBack.resize();
                }
                var count = $("#collectContainer").children().length;
                $("#collectDiv").css({
                    "width": count * 80 + "px"
                });
            };
        },

        getHtml: function () {
            var thisCallBack = this;
            var div = '<div class="cjDiv" style="z-index:10;height:35px;position:absolute;"><ul id="collectContainer" style="list-style:none;float:left;">   </ul></div>';
            this.element = document.createElement("div");
            this.element.id = "component_" + this.ID;
            this.element.style.cssText = "position:relative;z-index:10000;";
            $(this.element).append(div);
            $(this.globalMap.viewerContainer).append($(this.element));

            return this.element;

        },

        resize: function () {
            if (this.configData.position) {
                this.left = this.configData.position.left || 0;
                this.top = this.configData.position.top || 0;
                this.buttom = this.configData.position.buttom || 0;
                this.right = this.configData.position.right || 0;
            }
            if (this.left > 0 && this.right == 0) {
                var left = this.globalMap.mapContainer.position().left + this.left;
                var top = this.globalMap.mapContainer.position().top + this.top;

                $(this.element).css({
                    "left": left + "px",
                    "top": top + "px"
                });
            }
            else if (this.left == 0 && this.right > 0) {
                var left = this.globalMap.mapContainer.position().left + this.globalMap.mapContainer.width() - $(this.element).width() - 5 - this.right;
                var top = this.globalMap.mapContainer.position().top + this.top;

                $(this.element).css({
                    "left": left + "px",
                    "top": top + "px"
                });
            }
            else if (this.bottom > 0 && this.top == 0) {
                var top = this.globalMap.mapContainer.height() - $(this.element).height() - this.bottom;

                var left = this.globalMap.mapContainer.position().left + this.left;

                if (this.left == 0) {
                    left = this.globalMap.mapContainer.position().left + (this.globalMap.mapContainer.width() - this.globalMap.configData.tools.length*80+10) / 2;
                }

                $(this.element).css({
                    "left": left + "px",
                    "top": top + "px"
                });
            }
        },

        //初始化位置
        initPosition: function () { },

        CLASS_NAME: "BaseObject.ToolCollectionControl"
    });
    module.exports = BaseObject.ToolCollectionControl;

});