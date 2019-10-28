define(function (require, exports, module) {

    var isInit = false;

    DFastUI_Map.ShadowDragUI = BaseHelper.Class.create();
    DFastUI_Map.ShadowDragUI.prototype = BaseHelper.Class.inherit(BaseHelper.GUID, BaseHelper.Clone, BaseHelper.EventListener, require("drag-ui"), {

        //构造函数
        initialize: function (data) {
            //定义一私有事件--当前选中的目标元素

        },

        init: function () {
            this.shadowDragDiv = document.createElement("div");
        },

        create: function () {
            if (this.shadowDragDiv === undefined) this.init();
            this.shadowDragDiv.style.display = "block";
            document.body.appendChild(this.shadowDragDiv);

        },

        startDrag: function (event, ele) {
            this.create();
            this.shadowDragDiv.className = "dargui_shadow_div";
            $(this.shadowDragDiv).css({
                left: event.clientX - 30 + 'px',
                top: event.clientY - 30 + 'px'
            });
            // this.shadowDragDiv.mousedown();
            this.dragmousedown(event, this.shadowDragDiv);
            //this._clearSelectedCss(ele);
        },

        _clearSelectedCss: function (ele) {
            var childrenNodes = $(document).find('.dfastui-drag-bgcolor');
            childrenNodes.each(function (i, n) {
                childrenNodes.eq(i).removeClass("dfastui-drag-bgcolor");

            });
        },

        bind: function (ele) {

            //var component = ele.getOwnerComponent();


            var thisCallBack = this;

            var mouseup = function (event) {
                var type = this.dfastuiType;

                thisCallBack.stopDrag(event, ele,
                function (e) {
                    var childrenNodes = $(ele).find('.dfastui-select-target-bgcolor');
                    var hasChildren = false;
                    childrenNodes.each(function (i, n) {
                        if (childrenNodes.eq(i).is(e)) {

                            hasChildren = true;
                            return;
                        }

                    });
                    if (!hasChildren && e.length > 0) {
                        var ownerComponent = e.getOwnerComponent();
                        if (ownerComponent) {
                            ownerComponent.selectTargetEle = e;
                            ownerComponent.append(ele);
                        }
                    }

                    // $(thisCallBack.element).removeClass("dfastui-drag-bgcolor");
                    $(document).unbind("mouseup", mouseup);
                    $(document).unbind("mousemove", mousemove);
                    //$(thisCallBack.element).css({ display: "block" });
                });
            }
            var mousemove = function (event) {
                thisCallBack.moveDrag(event);
                // $(thisCallBack.element).css({ display: "none" });
            }

            ele.mousedown(function (event) {
                $(ele).addClass("dfastui-drag-bgcolor ");
                $(document).unbind("mouseup", mouseup);
                $(document).unbind("mousemove", mousemove);
                $(document).bind("mousemove", mousemove);
                $(document).bind("mouseup", mouseup);
                thisCallBack.startDrag(event, ele);
                event.stopPropagation();

            });

        },

        moveDrag: function (event) {
            if (this.shadowDragDiv === undefined) this.init();
            this.dragmousemove(event, this.shadowDragDiv);
        },

        stopDrag: function (event, ele, callback) {

            this.dragmouseup(event, this.shadowDragDiv,
			function (e) {
			    callback(e);
			});
            this.remove();
            event.stopPropagation();
            event.preventDefault();

            if (ele)
                this.selected(ele);
        },

        selected: function (ele) {
            this._clearSelectedCss(ele);
            if (ele) {
                ele.addClass("dfastui-drag-bgcolor");
                //派发当前选中的元素对象
                this.dispathEvent("selectedCurrentTarget", ele, "property_widget");
            }
        },


        remove: function () {
            //document.body.removeChild(this.shadowDragDiv);
            this.shadowDragDiv.style.display = "none";
        },

        destroy: function () {

        },

        CLASS_NAME: "DFastUI_Map.ShadowDragUI"
    });

    module.exports = new DFastUI_Map.ShadowDragUI();

})