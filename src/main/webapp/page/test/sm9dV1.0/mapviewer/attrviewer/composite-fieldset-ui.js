define(function (require, exports, module) {


    DFastUI_Map.Composite.FieldSet = BaseHelper.Class.create();
    DFastUI_Map.Composite.FieldSet.prototype = BaseHelper.Class.inherit(require("composite"), {


        init: function () {

        },

        create: function (configData, iDrag) {
            this.iDrag = iDrag;
            this._components = [];
            this.superCreate(configData, iDrag);
            var thisCallBack = this;
            if (this.element) return this.element;
            this.newId = this.getGUID();
            var table = null;
            if (configData) {


                table = this._createConfigTable(configData);

            }
            else {
                table = this._createDefaultTable();

            }
            this.element = table;
            this._bindEvent();

            return table;
        },

        viewerContainer: function (value) {
            this._viewerContainer = value;
        },
        _createDefaultTable: function () {

            var rowCount = 2;
            var cellCount = 2;

            var table = $("<table cellpadding=\"0\" cellspacing=\"0\"  border=\'1px dashed #ccc\' cellspacing=\'0px\'  class='table-ui' cellpadding=\'0px\'  id=table" + this.newId + " style='width:100%;cursor:move;' tableKey='" + key + "' />");
            var key = "table-ui" + this.id;
            for (var i = 0; i < rowCount; i++) {
                var tr = $("<tr tableKey='" + key + "'></tr>");
                tr.appendTo(table);
                for (var j = 0; j < cellCount; j++) {
                    //var td = $("<td >" + i * j + "</td>");

                    var selectTargetId = "dfastui-select-target" + this.id;
                    var rowColIndex = i + "@" + j;
                    var td = $("<td style='text-align:center' rowIndex='" + i + "' tableKey='" + key + "'><div class='dfastui-select-target' rowColIndex='" + rowColIndex + "' style='margin:0px;' id=" + selectTargetId + "/></td>");
                    td.appendTo(tr);
                }

                tr.appendTo(table);
            }

            return table;
        },

        _createConfigTable: function (configData) {



            var ui_manager_facotry = require("component-manager-facotry");
            this.uiFactoryInstance = new ui_manager_facotry();


            var rowCount = configData.ROW_COUNT;
            var cellCount = configData.COL_COUNT;

            this.rowspanArray = [];
            this.colspanArray = [];
            var key = "table-ui" + this.id;

            var table = $("<table   border=\'" + this.configData.BORDER + "\'   style='width:100%;' cellspacing='0px'   cellpadding='0px'  id=table" + this.newId + "   tableKey='" + key + "' />");

            var tmpRowSpan = 0;
            var currentSolspan = 0;
            for (var i = 0; i < rowCount; i++) {
                var tr = $("<tr tableKey='" + key + "'></tr>");
                tr.appendTo(table);
                for (var j = 0; j < cellCount; j++) {
                    //var td = $("<td >" + i * j + "</td>");

                    if (!this._findRowspan(j)) {
                        continue;
                    }
                    else {
                        var selectTargetId = "dfastui-select-target" + this.id;
                        var rowColIndex = i + "@" + j;

                        var td = $("<td   style=\" text-align:center;border-right:" + this.configData.BORDER_RIGHT + "; border-top:" + this.configData.BORDER_TOP + ";border-bottom:" + this.configData.BORDER_BOTTOM + " ;border-left:" + this.configData.BORDER_LEFT + " ; \" rowIndex='" + i + "' tableKey='" + key + "'></td>");
                        var container = "";
                        if (this.iDrag) {
                            container = $("<div class='dfastui-select-target' rowColIndex='" + rowColIndex + "' style='margin:0px;text-align:" + this.configData["TEXT-ALIGN"] + "' id=" + selectTargetId + " />");

                        }
                        else
                            container = $("<div   rowColIndex='" + rowColIndex + "' style=\"min-width:100px;min-height:20px;text-align:" + this.configData["TEXT_ALIGN"] + "\"   id=" + selectTargetId + "/>");
                        td.append(container);
                        td.appendTo(tr);
                        var childComponent = this._getChildrenItem(rowColIndex, configData.children);
                        if (childComponent) {
                            var jsonViewer = childComponent.getViewer();
                            var rowspan = parseInt(jsonViewer["ROW_SPAN"]);
                            var colspan = parseInt(jsonViewer["COL_SPAN"]);
                            var width = jsonViewer["WIDTH"] == 0 ? null : jsonViewer["WIDTH"];
                            if (width) $(td).css({ width: width });
                            if (rowspan > 1) {

                                var newRowspan = rowspan;
                                if ((i + rowspan) > rowCount) {
                                    newRowspan = rowCount - i;
                                    $(td).attr("rowspan", newRowspan);
                                    i = rowCount + 1;

                                }
                                else {
                                    $(td).attr("rowspan", newRowspan);
                                    //i = rowspan + i - 1;
                                }

                                this.rowspanArray.push({ "colIndex": j, "spanCount": newRowspan });
                                childComponent.updatePropreryItem({ "ROW_SPAN": newRowspan });
                            }
                            if (colspan > 1) {
                                var newColspan = colspan;
                                if ((j + colspan) > cellCount) {
                                    newColspan = cellCount - j;
                                    $(td).attr("colspan", newColspan);
                                    j = cellCount + 1;

                                }
                                else {

                                    currentSolspan = colspan;

                                    $(td).attr("colspan", colspan);
                                    if (colspan + j >= cellCount)
                                        j = cellCount;
                                    else
                                        j = j + colspan - 1;
                                }
                                childComponent.updatePropreryItem({ "COL_SPAN": newColspan });
                            }
                            container.append(childComponent.getElement());
                        }
                    }

                    tr.appendTo(table);
                }
            }

            return table;

        },

        _getChildrenItem: function (rowColIndex, children) {
            if (children.length && children.length > 0) {
                for (var index = 0; index < children.length; index++) {
                    var item = children[index];

                    if (item.ROW_COL_INDEX == rowColIndex) {
                        var component = this.uiFactoryInstance.createComponent(item.DFASTUI_TYPE);
                        component.parent = this;
                        component.viewerContainer = this.viewerContainer;
                        component.setViewer(item);
                        this._components.push(component);
                        component.create(item, this.iDrag);
                        return component;
                    }
                }
            }
            else {
                if (children.ROW_COL_INDEX == rowColIndex) {
                    var component = this.uiFactoryInstance.createComponent(children.DFASTUI_TYPE);
                    component.parent = this;
                    component.viewerContainer = this.viewerContainer;
                    component.setViewer(children);
                    this._components.push(component);
                    component.create(children, this.iDrag);
                    return component;
                }
            }

            return null;
        },

        refresh: function () {
            this._refreshDesignTable();
        },

        _refreshDesignTable: function () {
            if (!this.element) return;
//            var rowCount = this.element[0].rows.length;
//            var rowAry = this.element[0].rows;
//            var cellCount = 0;
//            for (var i = 0; i < rowAry.length; i++) {
//                var tmpCell = 0;
//                tmpCell = rowAry[i].cells.length;
//                if (tmpCell > cellCount)
//                    cellCount = tmpCell;
            //            }
            var rowCount = this.getViewer()["ROW_COUNT"];
            var cellCount =this.getViewer()["COL_COUNT"];

            this.rowspanArray = [];
            this.colspanArray = [];
            var key = "table-ui" + this.id;
            var table = $("<table   border=\'1px dashed #ccc\' cellspacing='0px'  class='table-ui' cellpadding='0px'  id=table" + this.newId + " style='width:100%;cursor:move;' tableKey='" + key + "' />");
            this.element.parent().append(table);
            var tmpRowSpan = 0;

            for (var i = 0; i < rowCount; i++) {
                var tr = $("<tr tableKey='" + key + "'></tr>");
                tr.appendTo(table);
                for (var j = 0; j < cellCount; j++) {
                    //var td = $("<td >" + i * j + "</td>");

                    if (!this._findRowspan(j)) {
                        continue;
                    }
                    else {
                        var selectTargetId = "dfastui-select-target" + this.id;
                        var rowColIndex = i + "@" + j;

                        var td = $("<td style='text-align:center' rowIndex='" + i + "' tableKey='" + key + "'></td>");
                        var container = $("<div class='dfastui-select-target' rowColIndex='" + rowColIndex + "' style='margin:0px;text-align:" + this.getViewer()["TEXT-ALIGN"] + "' id=" + selectTargetId + " />");
                        td.append(container);
                        td.appendTo(tr);

                        var childComponent = this._getChildrenComponent(rowColIndex);

                        if (childComponent) {
                            var jsonViewer;
                            if (childComponent.BASEUI_TYPE === "composite")
                                jsonViewer = childComponent.getProxyViewer();
                            else
                                jsonViewer = childComponent.getViewer();
                            var rowspan = parseInt(jsonViewer["ROW_SPAN"]);
                            var colspan = parseInt(jsonViewer["COL_SPAN"]);
                            var width = parseInt(jsonViewer["WIDTH"]) == 0 ? null : parseInt(jsonViewer["WIDTH"]);
                            if (width) {
                                var tableWidth = table.width();
                                $(td).css({ width: parseFloat(tableWidth / width) + "%" });
                            }

                            if (rowspan > 1) {

                                var newRowspan = rowspan;
                                if ((i + rowspan) > rowCount) {
                                    newRowspan = rowCount - i;
                                    $(td).attr("rowspan", newRowspan);
                                    i = rowCount + 1;

                                }
                                else {
                                    $(td).attr("rowspan", newRowspan);

                                    //i = rowspan + i - 1;
                                }

                                this.rowspanArray.push({ "colIndex": j,  "spanCount": newRowspan });
                           
                                childComponent.updatePropreryItem({ "ROW_SPAN": newRowspan });
                            }
                            if (colspan > 1) {
                                var newColspan = colspan;
                                if ((j + colspan) > cellCount) {
                                    newColspan = cellCount - j;
                                    $(td).attr("colspan", newColspan);
                                    j = cellCount + 1;

                                }
                                else {
                                    $(td).attr("colspan", colspan);
                                    if (colspan + j >= cellCount)
                                        j = cellCount;
                                    else
                                        j = j + colspan - 1;
                                }
                                childComponent.updatePropreryItem({ "COL_SPAN": newColspan });
                            }

                            container.append(childComponent.getElement());
                        }
                    }

                    tr.appendTo(table);
                }
            }

            this.element.remove();
            this.element = table;

            this._bindEvent();

            return table;
        },

        _bindEvent: function () {
            if (this.configData == null || this.configData == undefined)
                this.shadowDragUI.bind(this.element);
            if (this.iDrag)
                this.shadowDragUI.bind(this.element);


            this.element.setOwnerComponent(this);
            var childrenNodes = $(this.element).find('.dfastui-select-target');
            var thisCallBack = this;
            childrenNodes.each(function (i, n) {
                var key = "table-ui" + thisCallBack.id;
                if (this.id === "dfastui-select-target" + thisCallBack.id)
                    $(this).setOwnerComponent(thisCallBack);
            });
        },

        _findRowspan: function (colIndex) {
            for (var index = 0; index < this.rowspanArray.length; index++) {
                var item = this.rowspanArray[index];
                if (colIndex == item.colIndex) {
                    if (item.spanCount > 0) {
                        item.spanCount--;
                        if (item.spanCount == 1) {
                            this.rowspanArray.splice(index, 1);
                        }
                        return false;
                    }
                    else {
                        this.rowspanArray.splice(index, 1);
                        return false;
                    }
                }
            }
            return true;
        },

        _getChildrenComponent: function (rowColIndex) {
            for (var index = 0; index < this._components.length; index++) {
                var component = this._components[index];
                if (component._jsonViewer) {
                    if (component._jsonViewer["ROW_COL_INDEX"] == rowColIndex) {
                        return component;
                    }
                }
            }

            return null;
        },
        getElement: function () {
            return this.element;
        },

        DFASTUI_TYPE: "composite-fieldset-ui",
        CLASS_NAME: "DFastUI_Map.Composite.FieldSet"
    });

    module.exports = DFastUI_Map.Composite.FieldSet;
});