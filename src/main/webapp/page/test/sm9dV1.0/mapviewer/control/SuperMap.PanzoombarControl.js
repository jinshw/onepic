define(function (require, exports, module) {
    BaseObject.PanzoombarControl = BaseHelper.Class.create();
    BaseObject.PanzoombarControl.prototype = BaseHelper.Class.inherit(BaseObject.Component, {

        initialize: function (globalMap, configData) {
            this.ID = this.getGUID();
            if (globalMap) {
                configData == null ? {} : configData;
                this.init(globalMap, configData);
            }
            this.finish = false;
        },
        setIcon: function (icon) {
            this.icon = icon;
        },
        destroy: function () {

        },
        //初始化信息类
        init: function (globalMap, configData) {
            //alert("加载鱼刺控件");

            this.configData = configData;
            this.globalMap = globalMap;
            this.panzoombarControl = this;
            //初始化复杂缩放控件类
            var panzoombar = new SuperMap.Control.PanZoomBar({
                showSlider: true,
                levelsDesc: {
                    levels: [4, 7, 10, 12],
                    imageSources: [BaseObject.path + '/styles/css_map/themes/images/zoom_street.png',
                                    BaseObject.path + '/styles/css_map/themes/images/zoom_city.png',
                                    BaseObject.path + '/styles/css_map/themes/images/zoom_province.png',
                                    BaseObject.path + '/styles/css_map/themes/images/zoom_country.png']
                }
            });
            this.panzoombar = panzoombar;
            // 是否固定缩放级别为[0,16]之间的整数，默认为false
            panzoombar.forceFixedZoomLevel = true;
            //是否显示滑动条，默认值为false
            panzoombar.showSlider = true;
            /*点击箭头移动地图时，所移动的距离占总距离（上下移动的总距离为高度，左右移动的总距离为宽度）
            的百分比，默认为null。 例如：如果slideRatio 设为0.5, 则垂直上移地图半个地图高度.*/
            panzoombar.slideRatio = 0.5;
            //设置缩放条滑块的高度，默认为120
            panzoombar.sliderBarHeight = 180;
            //设置缩放条滑块的宽度，默认为13
            panzoombar.sliderBarWidth = 17;
            this.globalMap.mapObject.addControl(panzoombar);

            var thisCallBack = this;
            this.globalMap.addEventListener("loadMapCompleted", function (e) { thisCallBack.bindEvent() });
            this.globalMap.addEventListener("changedPosition", function (e) { thisCallBack.changedPosition(e) });

        },
        //初始化位置
        bindEvent: function () {
            $("#SuperMap.Control.PanZoomBar_25").unbind();
            if (!this.finish) {
                var doms = this.panzoombar.getDoms();
                var zoommaxextent = doms.zoommaxextent; //罗盘中心的按钮
                var thisCallBack = this;

                $("#SuperMap.Control.PanZoomBar_25").click(function (event) {

                    var configMap = thisCallBack.globalMap.currentMapConfigData;
                    var boundList = configMap.bounds.split(",");
                    var bounds = new SuperMap.Bounds(boundList[0], boundList[1], boundList[2], boundList[3]);
                    thisCallBack.globalMap.mapObject.zoomToExtent(bounds, 5);
                    event.stopPropagation();

                });
                this.finish = true;    
            }
            //zoommaxextent.onclick = function () { alert("")}
        },

        changedPosition:function(e)
        {
            //this.left=
        },
        resize: function () { },
        CLASS_NAME: "BaseObject.PanzoombarControl"
    });
    module.exports = BaseObject.PanzoombarControl;

});