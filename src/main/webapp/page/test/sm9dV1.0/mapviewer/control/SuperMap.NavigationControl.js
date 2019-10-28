define(function (require, exports, module) {
    BaseObject.NavigationControl = BaseHelper.Class.create();
    BaseObject.NavigationControl.prototype = BaseHelper.Class.inherit(BaseObject.Component, {

        initialize: function (globalMap, configData) {
            this.top = 0;
            this.left = 0;
            this.right = 45;
            this.bottom = 150;
            this.ID = this.getGUID();
            this.showFlag = false;
            this.children = [];
            this.openFlag = false;
            if (globalMap) {
                configData == null ? {} : configData;
                this.init(globalMap, configData);
            }
        },
        init: function (globalMap, configData) {
            this.configData = configData;
            this.globalMap = globalMap;
            this.getHtml();
            this.resize();
            var thisCallBack = this;
            this.globalMap.addEventListener("removeFloatDiv", function (e) {

            });
            this.initializeCallBack();
        },

        //初始化信息类
        getHtml: function () {
            var div = ' <div class="mapzoom" style="display: block;"><div class="mapZoomIn inImg"  id="inImg_' + this.ID + '"></div><div class="mapZoomOut outImg" id="outImg_' + this.ID + '"></div></div>';
            div += '<div class="overview overviewImg" id="overviewImg_' + this.ID + ' style="display: block;"></div>';

            this.element = document.createElement("div");
            this.element.id = "component_" + this.ID;
            this.element.className = "mapviewer-sort mapviewer-clearfix";
            this.element.style.cssText = "position:absolute;z-index:10000;width:0px";
            $(this.element).append(div);
            $(this.globalMap.viewerContainer).append($(this.element));
            var id = "navigationControl" + this.ID;
            this.navigationControlViewer = $("#" + id);
            var thisCallBack = this;
            this.globalMap.addEventListener("loadMapCompleted", function (e) { thisCallBack.bindEvent() });
        },

        bindEvent: function () {
            var thisCallBack = this;
            function zoomIn() {
                thisCallBack.globalMap.mapObject.zoomIn();
            }
            function zoomOut() {
                thisCallBack.globalMap.mapObject.zoomOut();
            }
            function overviewer() {
                thisCallBack.globalMap.fullviewer();
            }
            $(".inImg").unbind();
            $(".outImg").unbind();
            $(".overviewImg").unbind();

            $(".inImg").bind("click", zoomIn);
            $(".outImg").bind("click", zoomOut);
            $(".overviewImg").bind("click", overviewer);
 
        },
        //初始化位置
        clear: function () {

        },
        CLASS_NAME: "BaseObject.NavigationControl"
    });
    module.exports = BaseObject.NavigationControl;

});