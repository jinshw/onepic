var DFastUI_Map = {}

DFastUI_Map.Composite = null || {};
DFastUI_Map.Component = null || {};
DFastUI_Map.FunctionButton = null || {};
DFastUI_Map.Widget = null || {};
DFastUI_Map.Remote = null || {};
DFastUI_Map.Utils = null || {};

//全局模块句柄类
jQuery.fn.extend({
    getOwnerComponent: function () {
        if (this[0] != undefined) return this[0].ownerComponent;
        else return null
    },
    setOwnerComponent: function (v) {
        try {
            this[0].ownerComponent = v;
            return this[0].ownerComponent
        }
        catch (e) { }
    }
});
/*
Array.prototype.insert = function (index, item) {
    this.splice(index, 0, item)
};
*/

var BaseHelper = {};
BaseHelper.Class = {
    isPrototype: function () {

    },
    create: function () {
        return function () {
            if (arguments && arguments[0] != BaseHelper.Class.isPrototype) this.initialize.apply(this, arguments);
        }
    },
    inherit: function () {
        var superClass = arguments[0];
        var proto = new superClass(BaseHelper.Class.isPrototype);
        for (var i = 1; i < arguments.length; i++) {

            if (typeof arguments[i] == "function") {
                var mixin = arguments[i];
                arguments[i] = new mixin(BaseHelper.Class.isPrototype);
            }
            extend(proto, arguments[i]);
            if (arguments[i].hasOwnProperty('toString')) {
                proto.toString = arguments[i].toString;
            }
        }
        return proto;
    }
};
extend = function (destination, source) {
    for (property in source) {
        destination[property] = source[property];

        if (property === "initialize") {
            destination[property]()
        }
    }
    return destination;
};

var AppEvent = {};


BaseHelper.EventListener = BaseHelper.Class.create();

BaseHelper.EventListener.prototype = {


    initialize: function () {
        this.ID = "BaseHelper.EventListener";
    },


    addEventListener: function (eventName, listener, id) {
        if (!this.eventMethods) this.eventMethods = []
        this.eventMethods.push({ identifier: id, eventName: eventName, method: listener });
    },

    dispathEvent: function (eventName, data) {
        if (!this.eventMethods) this.eventMethods = []
        for (var index = 0; index < this.eventMethods.length; index++) {
            var item = this.eventMethods[index];

            if (item.eventName == eventName) {
                item.method(data);
            }
        }
    },

    dispathEventAll: function (eventName, data) {
        if (!this.eventMethods) this.eventMethods = []
        for (var index = 0; index < this.eventMethods.length; index++) {
            var item = this.eventMethods[index];

            if (item.eventName == eventName) {
                item.method(data);
            }
        }
    },

    removeEventListener: function (id, eventName, listener) {
        for (var index = 0; index < this._eventMethods.length; index++) {
            var item = this._eventMethods[index];

            if (item.eventName == eventName && item.identifier == id) {
                this.eventMethods.splice(index, 1);
                index--;
            }
        }
    },

    remove: function () {
        this.eventMethods = [];
    },

    destroy: function () {
        this.eventMethods = [];
    },

    init: function () {
    },


    innerEventBus: function () {

        var thisCallBack = this;

        this.EventBus =
            {
                addEventListener: function (eventName, listener) {
                    var list = eventName.split("|");
                    for (var k = 0; k < list.length; k++) {
                        var configData = {
                            target: {
                                identifier: thisCallBack.configData.ID,
                                method: listener,
                                classId: thisCallBack.getObjectClassId(),
                                objectClass: thisCallBack.getObjectClass(),
                                viewerContainer: thisCallBack.viewerContainer,
                                relationshpEvents: thisCallBack.configData.BINDING_TARGET_EVENT == undefined ? [] : JSON.parse(thisCallBack.configData.BINDING_TARGET_EVENT)
                            },
                            eventName: list[k]
                        };
                        GlobalEventBus.addEventListener(configData);
                    }
                },

                addPreloadEvent: function (eventName, data) {

                    var list = eventName.split("|");
                    for (var k = 0; k < list.length; k++) {
                        var eventData = {
                            target: { identifier: thisCallBack.configData.ID,
                                classId: thisCallBack.getObjectClassId(),
                                objectClass: thisCallBack.getObjectClass(),
                                dfastuiType: thisCallBack.DFASTUI_TYPE,
                                relationId: thisCallBack.getObjectRelationId()
                            },
                            eventName: list[k],
                            data: data
                        };
                        GlobalEventBus.addPreloadEvent(eventData);
                    }
                },



                removeEventListener: function (eventName) {
                    var list = eventName.split("|");
                    for (var k = 0; k < list.length; k++) {
                        GlobalEventBus.removeEventListener(list[k], thisCallBack.id);
                    }
                },
                removeEventByClassId: function (id) {
                    GlobalEventBus.removeEventByClassId(id);
                },

                dispathEvent: function (eventName, data) {
                    var list = eventName.split("|");
                    for (var k = 0; k < list.length; k++) {
                        var eventData = {
                            target: { identifier: thisCallBack.configData.ID,
                                classId: thisCallBack.getObjectClassId(),
                                objectClass: thisCallBack.getObjectClass(),
                                dfastuiType: thisCallBack.DFASTUI_TYPE,
                                relationId: thisCallBack.getObjectRelationId()
                            },
                            eventName: list[k],
                            data: data
                        };
                        GlobalEventBus.dispathEvent(list[k], eventData);
                    }
                }
            }
    },

    CLASS_NAME: "BaseHelper.EventListener"
};

BaseHelper.GUID = BaseHelper.Class.create();
BaseHelper.GUID.prototype = {
    ID: null,
    initialize: function () {
        this.ID = "SuperMap.GUID";
    },

    getGUID: function () {
        var guid = "";
        for (var i = 1; i <= 32; i++) {
            var n = Math.floor(Math.random() * 16.0).toString(16);
            guid += n;
            if ((i == 8) || (i == 12) || (i == 16) || (i == 20)) guid += "";
        }
        return guid;
    },

    //初始化位置

    CLASS_NAME: "BaseHelper.GUID"
};

BaseHelper.Clone = BaseHelper.Class.create();
BaseHelper.Clone.prototype = {
    ID: null,
    initialize: function () {
        this.ID = "BaseHelper.Clone";
    },

    clone: function (data) {
        for (var key in data) {
            if (data.hasOwnProperty(key)) {
                this[key] = data[key];
            }
        }
    },
    //初始化位置

    CLASS_NAME: "BaseHelper.Clone"
};
 
 
 


var PRELOAD_CONFIG_DATA = [];
PRELOAD_CONFIG_DATA.push({ value: "component-labelInput-ui", url: BaseObject.path+"/script/mapviewer/attrviewer/component-labelInput-ui.js" });
PRELOAD_CONFIG_DATA.push({ value: "composite-fieldset-ui", url: BaseObject.path + "/script/mapviewer/attrviewer/composite-fieldset-ui.js" });
PRELOAD_CONFIG_DATA.push({ value: "eventBus", url: BaseObject.path + "/script/mapviewer/attrviewer/EventBus.js" });
PRELOAD_CONFIG_DATA.push({ value: "superValidator",  url:BaseObject.path+"/script/mapviewer/attrviewer/superValidator.js" });
PRELOAD_CONFIG_DATA.push({ value: "jsonXml", url: BaseObject.path+"/script/mapviewer/attrviewer/jsonXml.js" });
PRELOAD_CONFIG_DATA.push({ value: "drag-ui", url:BaseObject.path+"/script/mapviewer/attrviewer/drag-ui.js" });
PRELOAD_CONFIG_DATA.push({ value: "composite", url: BaseObject.path+"/script/mapviewer/attrviewer/composite.js" });
PRELOAD_CONFIG_DATA.push({ value: "composite-viewer-container", url: BaseObject.path+"/script/mapviewer/attrviewer/composite-viewer-container.js" });
PRELOAD_CONFIG_DATA.push({ value: "component-manager-facotry", url: BaseObject.path + "/script/mapviewer/attrviewer/component-facotry-manager.js" });
PRELOAD_CONFIG_DATA.push({ value: "component", url: BaseObject.path+"/script/mapviewer/attrviewer/component.js" });
PRELOAD_CONFIG_DATA.push({ value: "remote-service-attr", url:BaseObject.path+"/script/mapviewer/attrviewer/remote-service.js" });
PRELOAD_CONFIG_DATA.push({ value: "remote-parameter-attr", url: BaseObject.path+"/script/mapviewer/attrviewer/remote-parameter.js" });

 
if (!seajs.config.data.alias) seajs.config.data.alias = [];
for (var index = 0; index < PRELOAD_CONFIG_DATA.length; index++) {
    var item = PRELOAD_CONFIG_DATA[index];
    seajs.config.data.alias[item.value] = item.url;
}
 
//应用程序公共初始化模块
define(function (require, exports, module) {
    //定义全局变量

    var AttrViewerHandler =
    {
     
        init: function (data, perameter, callBack, divId) {
            var that = this;
         
            if (data.length > 0) {
                var type = data[0].value;
                require.async([type], function (c) {
                    data.splice(0, 1);
                    that.init(data, perameter, callBack, divId);
                });
            }
            else {
                DFastUI_Map.Utils.JsonXml = require("jsonXml");
                //获取设计布局对象

                var compositeViewerContainer = require("composite-viewer-container");
                this.viewerContainer = new compositeViewerContainer();
                //$("#attrDiv").remove();
                //$("<link type='text/css' rel='Stylesheet' href='"+BaseObject.path+"/mapTool/attrviewer/style/attr-viewer.css' /><div id='attrDiv' style='width:100px;height:100px;'></div>").appendTo("body");
                //$("#attrDiv").hide();
                //绑定到当前视图容器
                if (divId == "" || divId == null || divId == undefined) {
                    this.viewerContainer.setElement($("#attrDiv"));
                } else {
                    this.viewerContainer.setElement($("#" + divId));
                }
                //Ajax调用jsonViwer生成视图模板

                var thisCallBack = this;
                var remoteService = require("remote-service-attr");
                var remoteParameter = require("remote-parameter-attr");
                remoteParameter.RESOURCE_NAME = "T_GIS_META_ATTR_VIEWER";
                remoteParameter.FILTER_PARAMENTER = "{shujjbm:'" + perameter + "',colCount:" + this.colCount + "}";
                remoteParameter.REMOTE_METHOD = "getViewerHtml";
                if (!remoteService) return;
                remoteService.execute(remoteParameter, function (result) {
                    if (result.status == 0) {
                        art.dialog.tips(result.message);
                        return;
                    }
                    var jsonXml = require("jsonXml");
                    var content = result.element.replace('<?xml version=\"1.0\" encoding=\"UTF-8\"?>', '');

                    var jsonViewer = jsonXml.xmlToJson(jsonXml.toXmlDom(content));
                    jsonViewer = JSON.parse(jsonViewer);
                    if (jsonViewer == null || jsonViewer == "") { alert("xml转换错误！！！"); return; }
                    thisCallBack.viewerContainer.load(jsonViewer.root, false);
                    if (callBack) {
                        callBack(jsonViewer);
                    }
                    
                })
                $(window).resize(function () {
                    thisCallBack.viewerContainer.resize();
                });
            }
        },

        load: function (perameter, callBack, divId) {
            this.init(PRELOAD_CONFIG_DATA, perameter, callBack, divId);
        },

        getValue: function () {
            if (this.viewerContainer.getValidator()) {
                return this.viewerContainer.getValue();
            }

            return null;
        },

        reset: function () {
            if (this.viewerContainer)
            this.viewerContainer.reset();
        },

        ressetElement: function (value) {
            if (this.viewerContainer)
            this.viewerContainer.ressetElement(value);
        },



        setValue: function (data) {
            if (this.viewerContainer)
            this.viewerContainer.setValue(data);
        },

        setDisabled: function (value) {
            this.viewerContainer.setDisabled(value);
        }

    };
    AttrViewerHandler.colCount = 2;

    module.exports = AttrViewerHandler;
});




   

 





 

 
