define(function (require, exports, module) {

    DFastUI_Map.Component.LabelInput = BaseHelper.Class.create();
    DFastUI_Map.Component.LabelInput.prototype = BaseHelper.Class.inherit(require("component"), {


        init: function () {

        },

        create: function (configData, iDrag) {
         
            if (this.element) return this.element;
            this.superCreate(configData, iDrag);
            var labelInput = "";
            var label = "文本框";
            if (configData)
                label = configData.FIELD_CNNAME || label;
            if ((configData) && !(iDrag)) {

                var defaultValue = "";

                if (configData.DEFAULT_VALUE) {
                    if (configData.VALUE) {
                        defaultValue = configData.VALUE || configData.DEFAULT_VALUE;
                    }
                    else
                        defaultValue = configData.DEFAULT_VALUE == "-" ? label : configData.DEFAULT_VALUE;
                }
                else
                    defaultValue = configData.VALUE || "";

                var disabled = configData.READ_ONLY == 1 ? true : false;
                var labelWidth = configData.LABEL_WIDTH || 80;
                var isRequired = configData.IS_REQUIRED == 1 ? true : false;
                var starString = "";
                if (isRequired) {
                    starString = "<font color=red>*</font>";
                }
                if (disabled)
                    labelInput = $('<div class="component-labelInput-ui-div "><table border="0"  cellpadding="0" cellspacing="0" style="width:100%;border:1px solid #ccc" ><tr><td style=\'background: none repeat scroll 0 0 #f8f8f8;\'><label    class="control-label"  style="width:' + labelWidth + 'px;"  for="inputEmail">' + label + starString + '</label></td><td style="width:100%"><input type="text" id="' + this.elementId + '" disabled=' + disabled + ' reg="" class="input disabled" check="2"   value="' + defaultValue + '" tip=' + configData.VALIDATOR_MSG + ' placeholder="' + label + '" ></input></td></tr></table></div>');
                else {
                    labelInput = $('<div class="component-labelInput-ui-div "><table border="0"  cellpadding="0" cellspacing="0" style="width:100%;border:1px solid #ccc" ><tr><td style=\'background: none repeat scroll 0 0 #f8f8f8;\'><label    class="control-label"  style="width:' + labelWidth + 'px;"  for="inputEmail">' + label + starString + '</label></td><td style="width:100%"><input type="text" id="' + this.elementId + '"  reg="" class="input" check="2"   value="' + defaultValue + '" tip=' + configData.VALIDATOR_MSG + ' placeholder="' + label + '"></input></td></tr></table></div>');
                }
            }
            else {

                labelInput = $('<div class="component-labelInput-ui-div"><table  cellpadding="0" cellspacing="0"   style="width:100%;border:1px solid #ccc"><tr><td style=\'background: none repeat scroll 0 0 #f8f8f8;\'><label  class="control-label" id="label' + this.id + '"  for="inputEmail">' + label + '</label></td><td style="width:100%"><input type="text"  id="' + this.elementId + '" reg="" class="input"  check="2"  tip="" placeholder=' + label + '></input></td></tr></table></div>');
                this.shadowDragUI.bind(labelInput);
            }


            this.element = labelInput;

            this.element.setOwnerComponent(this);

            return labelInput;
        },

        getFactory: function () {
            return module.factory();
        },
        DFASTUI_TYPE: "component-labelInput-ui",
        CLASS_NAME: "DFastUI_Map.Component.LabelInput"
    });

    module.exports = DFastUI_Map.Component.LabelInput;


});