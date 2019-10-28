//应用程序公共初始化模块
define(function (require, exports, module) {
    //全局模块句柄类
    //全局模块句柄类
    DFastUI_Map.GlobalEventBus = (function () {

        var globalEventBus = {};
        var EVENT_LIST = [];
        var PRELOAD_EVENT_LIST = [];

        globalEventBus.addEventListener = function (eventData) {
            EVENT_LIST.push(eventData);
        }
        globalEventBus.removeEventListener = function (eventName, id) {
            if (EVENT_LIST.length > 0) {
                for (var index = 0; index < EVENT_LIST.length; index++) {
                    var item = EVENT_LIST[index];
                    if (item.target.identifier == id) {
                        EVENT_LIST.splice(index, 1);
                    }
                }
            }
        }
        globalEventBus.dispathEvent = function (eventName, eventData) {
            if (EVENT_LIST.length > 0) {
                for (var index = 0; index < EVENT_LIST.length; index++) {
                    var item = EVENT_LIST[index];
                    if ((item.target.objectClass == eventData.target.objectClass) && (item.eventName == eventName) && (item.target.classId == eventData.target.classId)) {
                        if (item.target.identifier != eventData.target.identifier) {
                            item.target.method(eventData);
                        }
                    }
                    if (item.target.relationshpEvents && item.target.relationshpEvents.length > 0) {

                        for (var i = 0; i < item.target.relationshpEvents.length; i++) {
                            var targetEvent = item.target.relationshpEvents[i];
                            if ((targetEvent.ID == eventData.target.identifier) && (targetEvent.EVENT_NAME == eventName) && item.eventName == eventName) {
                                item.target.method(eventData);
                            }
                        }
                    }
                }
            }
        }

        globalEventBus.dispathEventAll = function (eventName, data) {
            //未实现此方法
        },

        globalEventBus.removeEventByClassId = function (classId) {
            if (EVENT_LIST.length > 0) {
                for (var index = 0; index < EVENT_LIST.length; index++) {
                    var item = EVENT_LIST[index];
                    if (item.target.classId == classId) {
                        EVENT_LIST.splice(index, 1);
                        index--;
                    }
                }
            }
        },

        globalEventBus.dispathPreloadEvent = function (id) {

            for (var index = 0; index < PRELOAD_EVENT_LIST.length; index++) {

                var item = PRELOAD_EVENT_LIST[index];
                if (item.target.classId==id)
                globalEventBus.dispathEvent(item.eventName, item);
            }
        },

        globalEventBus.addPreloadEvent = function (eventData) {
            PRELOAD_EVENT_LIST.push(eventData);
          
        }

        return globalEventBus;
    })();

    GlobalEventBus = DFastUI_Map.GlobalEventBus;

    module.exports = DFastUI_Map.GlobalEventBus;
});


 
