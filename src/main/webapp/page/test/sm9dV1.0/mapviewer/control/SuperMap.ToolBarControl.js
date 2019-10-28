define(function (require, exports, module) {
    BaseObject.ToolbarControl = BaseHelper.Class.create();
    BaseObject.ToolbarControl.prototype = BaseHelper.Class.inherit(BaseObject.Component, {

        initialize: function (globalMap, configData) {
            this.top = 20;
            this.left = 0;
            this.right = 1;
            this.bottom = 0;
            this.ID = this.getGUID();
            if (globalMap) {
                configData == null ? {} : configData;
                this.init(globalMap, configData);
            }
        },
        setIcon: function (icon) {
            this.icon = icon;
        },
        //初始化信息类
        init: function (globalMap, configData) {
            this.configData = configData;
            this.globalMap = globalMap;
             
            this.getHtml();
            this.loadTools();

            this.resize();
        },
        addItem: function (tool) {
            this.globalMap.addTool(tool);
            var html = tool.getHtml(true);
            $("#mainContainer").append(html);
        },
  

        //初始化信息类
        getHtml: function () {
            var div = '<div class="mapviewer-sort mapviewer-clearfix" style="z-index:100;"><ul id="mainContainer"></ul></div>';
            this.element = document.createElement("div");
            this.element.id = "component_" + this.ID;
            this.element.style.cssText = "position:absolute;z-index:10000;width:490px";
            $(this.element).append(div);
            $(this.globalMap.viewerContainer).append($(this.element));

        },

        loadTools: function () {
            var thisCallBack = this;
            var tools = [];

            for (var index = 0; index < this.globalMap.configData.tools.length; index++) {
                var item = this.globalMap.configData.tools[index];
                if (item.type == "toolbarCollection") tools.push(item);
            }
            for (var index = 0; index < this.globalMap.configData.widgets.length; index++) {
                var item = this.globalMap.configData.widgets[index];
                if (item.type == "toolbarCollection") tools.push(item);
            }
            load(tools);
            function load(data) {
                if (data.length > 0) {
                    var item = data[0];
                    var url = item.url.split(";")[0];
                    url = (url.indexOf("http://") > -1) ? url : (BaseObject.path + "/" + url);
                    require.async(url,
                    function (a) {
                        data.splice(0, 1);
                        var instance = new a();
                        instance.init(thisCallBack.globalMap, item);
                        thisCallBack.addItem(instance);
                        instance.initializeCallBack();
                        load(data);
                    });
                }
                else
                    $(thisCallBack.element).find("a:last").css("border-right", "none");
            }
        },

        //初始化位置
        initPosition: function () { },
        CLASS_NAME: "BaseObject.ToolbarControl"
    });
    module.exports = BaseObject.ToolbarControl;

});