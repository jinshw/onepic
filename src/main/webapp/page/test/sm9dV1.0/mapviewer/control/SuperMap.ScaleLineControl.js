﻿define(function (require, exports, module) {
	BaseObject.ScaleLineControl = BaseHelper.Class.create();
	BaseObject.ScaleLineControl.prototype = BaseHelper.Class.inherit(BaseObject.Component,{
		 
	    initialize: function (globalMap, configData) {
            this.top = 0;
            this.left = 100;
            this.right = 0;
            this.bottom = 10;
            this.ID = this.getGUID();
            if (globalMap) {
                configData == null ? {} : configData;
                  this.init(globalMap, configData);
            }
        },
 
	    destroy: function() {
	        
	    },
	     
  
	    //初始化信息类
	    init: function(globalMap,configData) {

            this.configData = configData;
            this.globalMap=globalMap;
            var thisCallBack = this;
            this.globalMap.addEventListener("loadMapCompleted", function (e) { thisCallBack.loadMapCompletedHandler(e, "loadMapCompleted") });
        },
 
	    loadMapCompletedHandler: function (a, b) {
            if (!this.scale) {
	            this.scale = L.control.scale().addTo(this.globalMap.mapHandler.mapObject);
	        }
	    },

	    //初始化位置
	    initPosition: function() { },

	    CLASS_NAME: "BaseObject.ScaleLineControl"
	});
	module.exports = BaseObject.ScaleLineControl;

});