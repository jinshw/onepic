//***********************************************************
//根据原有验证框架进行改进
//使用时候需要给要增加验证的标签增加check属性
//当check="1"的时候,允许录入为空,如果输入数据就按reg属性绑定的正则表达进行验证.
//当check="2"的时候,就直接按照reg绑定的正则表达式进行验证.
//***********************************************************
//获得所有需要验证的标签

//表单验证模块
define(function (require, exports, module) {

    (function ($) {
        $.fn.tooltip = function (options) {
            var getthis = this;
            var opts = $.extend({},
 	$.fn.tooltip.defaults, options);
            //创建提示框
            $('body').append('<table id="dfastui-tooltip-container" class="tableTip"><tr><td  class="leftImage"></td> <td class="contenImage" id="dfastui-tooltip-content-body" align="left"></td> <td class="rightImage"></td></tr></table>');
            //移动鼠标隐藏刚创建的提示框
            //$('body').append('<div class="gips-container" id="dfastui-tooltip-container" style=""><div class="gips-body red" id="dfastui-tooltip-content-body"  style="opacity: 1;"></div><div class="gips-icon gips-icon-top red" style="opacity: 1; top: -12px;"></div></div>');
            $(document).mouseout(function () {
                $('#dfastui-tooltip-container').hide()
            });
            $('#dfastui-tooltip-container').hide()
        };

        $.extend({
            getWidth: function (object) {
                return object.offsetWidth;
            },

            getLeft: function (object) {
                var go = object;
                var oParent, oLeft = go.offsetLeft;
                while (go.offsetParent != null) {
                    oParent = go.offsetParent;
                    oLeft += oParent.offsetLeft;
                    go = oParent;
                }
                return oLeft;
            },

            getTop: function (object) {
                var go = object;
                var oParent, oTop = go.offsetTop;
                while (go.offsetParent != null) {
                    oParent = go.offsetParent;
                    oTop += oParent.offsetTop;
                    go = oParent;
                }
                return oTop + $(object).height() + 5;
            },

            onsubmit: true
        });
        $.fn.tooltip.defaults = {
            onsubmit: true
        };


        $('select[tip],select[check],input[tip],input[check],textarea[tip],textarea[check]').tooltip();

    })(jQuery);
 
    var validatorRules = (function () {

        var constants = {

            INTEGER_CHECK: { "value": "^[0-9]\\d*$", "label": '整数', "tip": '需要整数验证' },
            MONEY_CHECK: {
                "value": '^(-)?(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){1,2})?$',
                "label": unescape('金额'),
                "tip": '需要金额验证'
            },
            FLOAT_CHECK: {
                "value": "^[0-9]+\\.[0-9]+$",
                "label": "浮点型",
                "tip": "需要浮点型验证"
            },
            EMAIL_CHECK: {
                "value": "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$",
                "label": "电子邮件",
                "tip": "需要电子邮件验证"
            },
            ZIPCODE_CHECK: {
                "value": "^\\d{6}$",
                "label": "邮政编码",
                "tip": "需要邮政编码验证"
            },
            MOBILE_CHECK: {
                "value": "^(13|15)[0-9]{9}$",
                "label": "手机",
                "tip": "需要手机验证"
            },
            ID_CHECK: {
                "value": "^[1-9]([0-9]{14}|[0-9]{17})$",
                "label": "身份证",
                "tip": "需要身份验证"
            },
            USERID_CHECK: {
                "value": "^\\w+$",
                "label": "登录帐号",
                "tip": "需要登录帐号验证"
            },
            EMPTY_CHECK: {
                "value": ".*\\S.*",
                "tip": "需要非空验证",
                "label": "非空验证"
            },
            JSON_CHECK: {
                "value": "^[1-9]\\d*$",
                "tip": "需要JSON验证",
                "label": "JSON验证"
            },
            URL_CHECK: {
                "value": "^[\\u4E00-\\u9FA5\\uF900-\\uFA2D]+$",
                "tip": "需要URL验证",
                "label": "URL验证"
            },
            TEL_CHECK: {
                "value": "\\d{3}-\\d{8}|\\d{4}-\\d{7}",
                "tip": "需要匹配国内电话号码(0511-4405222 或 021-87888822)验证",
                "label": "配国内电话号码"
            },
            PWD_CHECK:
            {
                "value": "^[1-9]\\d*$",
                "tip": "密码不能为空且只能为英文或者数字",
                "label": "密码验证"

            },
            ISNULL_CHECK:
            {
                "value": "",
                "tip": "允许为空",
                "label": "允许为空"

            }
        }

        var rules = {};

        rules.getReg = function (type) {

            return constants[type];
        }

        rules.getConstants = function () {

            return constants;
        }

        return rules;

    })();

    DFastUI_Map.Validator = {

        bind: function (validatorString, type) {
            var thisCallBack = this;
            var reg = validatorRules.getReg(type);
            if (reg) {
                validatorStrings = validatorString.split(":");
                try{
                	for (i = 0; i < validatorStrings.length; i++) {
                        if ($("#" + validatorStrings[i])[0].type != undefined) {

                            $("#" + validatorStrings[i]).attr("reg", reg.value);

                            $("#" + validatorStrings[i]).mouseover(
    			        function () {
    			            $('#dfastui-tooltip-container').css({
    			                left: $.getLeft(this) + 'px',
    			                top: $.getTop(this) + 'px'
    			            });
    			            var thisReg = new RegExp($(this).attr('reg'));
    			            if (thisReg.test(this.value)) {
    			              //  $(this).removeClass('tooltipinputerr').addClass('tooltipinputok');

    			                return true;
    			            }
    			            $('#dfastui-tooltip-content-body').html($(this).attr('tip'));
    			            $('#dfastui-tooltip-container').fadeIn("fast");
    			            $('#dfastui-tooltip-container').show();
    			        });

                            $("#" + validatorStrings[i]).focus(function () {
                                $(this).removeClass('tooltipinputerr');
                            }).blur(function () {
                                thisCallBack._proxyValidator(this);
                            });
                        }
                    }
                }catch(e){
                	
                }
            }
        },
        getRules: function () {
            return validatorRules.getConstants();
        },

        check: function (id) {
            var thisCallBack = this;

            if ($("#" + id).attr('tip') != '') {

                $("#" + id).mouseover(

			    function () {
			        if ($("#" + id).hasClass("tooltipinputerr")) {
			            $('#dfastui-tooltip-container').css({
			                left: $.getLeft(this) + 'px',
			                top: $.getTop(this) + 'px'
			            });
			            $('#dfastui-tooltip-content-body').html($(this).attr('tip'));
			            $('#dfastui-tooltip-container').fadeIn("fast");
			        }
			        else {
			            $('#dfastui-tooltip-container').hide()
			        }
			    });

            }
            if ($("#" + id).attr('check') != '' && $("#" + id).attr('check') != undefined) {

                $("#" + id).focus(function () {
                    $(this).removeClass('tooltipinputerr');
                }).blur(function () {
                    thisCallBack._proxyValidator(this);
                });

                var isOK = thisCallBack._proxyValidator(document.getElementById(id));

                return isOK;
            }

        },

        _proxyValidator: function (el) {

            if ($(el).attr('toupper') == 'true') {
                el.value = el.value.toUpperCase();
            }
            if ($(el).attr('check') != '') {

                if ($(el).attr('check') == "1") {

                    if ($(el).attr('value') == null) {
                        $(el).removeClass('tooltipinputerr').addClass('tooltipinputok');
                    } else {

                        var thisReg = new RegExp($(el).attr('reg'));
                        if (thisReg.test(el.value)) {
                            $(el).removeClass('tooltipinputerr').addClass('tooltipinputok');

                            return true;
                        } else {
                            $(el).removeClass('tooltipinputok').addClass('tooltipinputerr');
                            return false;
                        }

                    }
                }
                if ($(el).attr('check') == "2") {
                    var thisReg = new RegExp($(el).attr('reg'));
                    if (thisReg.test(el.value)) {
                        $(el).removeClass('tooltipinputerr').addClass('tooltipinputok');
                        return true;
                    } else {
                        $(el).removeClass('tooltipinputok').addClass('tooltipinputerr');
                        return false;
                    }
                }
            }

        }
    }

    module.exports = DFastUI_Map.Validator;
});

 

 //***************************************************************************************************************************************************