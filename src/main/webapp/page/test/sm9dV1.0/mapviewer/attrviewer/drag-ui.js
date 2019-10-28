define(function (require, exports, module) {

    DFastUI_Map.DragUI = BaseHelper.Class.create();
    DFastUI_Map.DragUI.prototype = BaseHelper.Class.inherit(BaseHelper.GUID, {

        init: function () {

        },

        dragmousedown: function (event, ele, callback) {
            this.move = false; // 移动的初始化 
            this.mDGTargets = $(".dfastui-select-target");
            this.initPos = {
                x: 0,
                y: 0
            },
			this.relPos = {
			    x: 0,
			    y: 0
			},
			this.temPos = {
			    x: 0,
			    y: 0
			};
            // 鼠标 与 目标元素的相对坐标 
            this.relPos.x = event.pageX - $(ele).offset().left;
            this.relPos.y = event.pageY - $(ele).offset().top - $(document).scrollTop(); ;
            this.move = true;
        },

        dragmousemove: function (event, ele, callback) {
            var thisCallBack = this;

            if (!this.move) {
                return false;
            }
            var dragPos = {
                x1: 0,
                x2: 0,
                y1: 0,
                y2: 0
            }; // 拖拽对象的四个坐标;
            var tarDivPos = {
                x1: 0,
                y1: 0,
                x2: 0,
                y2: 0
            }; //目标对象的四个坐标  
            var tarDiv, tarDivHalf = 0,
			wHalf = 0; //拖拽对象 目标对象
            // 下列代码是 if(move)的 程序 
            $(ele).removeClass("dfastui-select-drag-target").addClass("dfastui-select-borp-target");
            // 目标元素随鼠标移动的坐标 
            dragPos.x1 = event.pageX - this.relPos.x;
            dragPos.y1 = event.pageY - this.relPos.y;
            dragPos.x2 = dragPos.x1 + $(ele).innerWidth();
            dragPos.y2 = dragPos.y1 + $(ele).innerHeight();
            $(ele).css({
                left: dragPos.x1 + 'px',
                top: dragPos.y1 + 'px'
            });

            this.mDGTargets.each(function () {
                tarDiv = $(this);
                // 目标对象的坐标 
                tarDivPos.x1 = tarDiv.offset().left;
                tarDivPos.y1 = tarDiv.offset().top;
                tarDivPos.x2 = tarDivPos.x1 + tarDiv.width();
                tarDivPos.y2 = tarDivPos.y1 + tarDiv.height();

                tarDivHalf = $(ele).height() / 2; //临时变量，以便于在if判断中使用 
                wHalf = $(ele).width() / 2;
                //ele.innerHTML = "X:+" + dragPos.x2 + "" + "Y:+" + dragPos.y2 + "" + "xx:+" + parseInt(tarDivPos.x2 + wHalf) + "" + "yy:+" + parseInt(tarDivPos.y2 + tarDivHalf) + "";
                if (dragPos.x2 >= tarDivPos.x1 + wHalf && dragPos.x2 <= tarDivPos.x2 + wHalf && dragPos.y2 >= tarDivPos.y1 + tarDivHalf && dragPos.y2 <= tarDivPos.y2 + tarDivHalf) {
                    var ownerComponent = tarDiv.getOwnerComponent();

                    if (ownerComponent&&ownerComponent.DFASTUI_TYPE == "composite-fieldset-ui") {
                        if (tarDiv.children().length == 0) {
                            if (!tarDiv.hasClass("dfastui-drag-bgcolor")) {
                                tarDiv.removeClass("dfastui-select-target").addClass("dfastui-select-target dfastui-select-target-bgcolor");
                            }
                        } // 解决重叠元素 移动到一个目标元素
                        

                    }
                    else {
                        if (!tarDiv.hasClass("dfastui-drag-bgcolor")) {
                            tarDiv.removeClass("dfastui-select-target").addClass("dfastui-select-target dfastui-select-target-bgcolor");
                        }
                    }

                } else {
                    tarDiv.removeClass("dfastui-select-target-bgcolor");
                }
            });
        },

        dragmouseup: function (event, ele, callback) {
            //initDiv.appendTo($(".bgColor")); // 利用 apppendTo 方法 使拖动元素对象添加到指定的区域。 
            var selectTarget = $(".dfastui-select-target-bgcolor");
            // if (selectTarget.length == 0) return;
            //$(ele).appendTo(selectTarget);
            callback(selectTarget.eq(selectTarget.size() - 1));

            $(ele).removeClass("dfastui-select-borp-target").addClass("dfastui-select-drag-target").removeAttr("style"); //恢复拖拽对象初始的样式 
            selectTarget.removeClass("dfastui-select-target-bgcolor");
            this.move = false;
            event.stopPropagation();
        },

        destroy: function () {

        },

        CLASS_NAME: "DFastUI_Map.DragUI"
    });

    module.exports = DFastUI_Map.DragUI;

})