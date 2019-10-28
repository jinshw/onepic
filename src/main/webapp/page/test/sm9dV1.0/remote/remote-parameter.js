//应用程序公共初始化模块
define(function (require, exports, module) {
    //全局模块句柄类
    DFastUI.Remote.Parameter = BaseHelper.Class.create();
    DFastUI.Remote.Parameter.prototype = BaseHelper.Class.inherit(BaseHelper.GUID, {
        //构造函数
        initialize: function () {
            this.START = 1;
            this.LIMIT = 15;
            this.GUID = "-1";
            this.RELATION_TYPE = "IN";
            this.RELATION_GUID = "-1";
            this.FILTER_PARAMENTER = "";
            this.REMOTE_METHOD = "";
            this.RESOURCE_NAME = "";
            this.RETURE_TYPE = "JSON"; //JSON|XML;
        },
    });
    module.exports =new DFastUI.Remote.Parameter;
});


 
