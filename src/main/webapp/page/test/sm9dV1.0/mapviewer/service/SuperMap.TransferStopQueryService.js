define(function (require, exports, module) {
    BaseObject.TransferStopQueryService = BaseHelper.Class.create();
	BaseObject.TransferStopQueryService.prototype = BaseHelper.Class.inherit(BaseObject.Component, {
		transferStopQueryService: null,
		mapObject: null,
		conditions:null,
		callBack:null,
		initialize: function(mapObject) {
	    	//alert("加载公交站点查询服务类");
	    	this.mapObject = mapObject;
	    	transferStopQueryService = this;
	    	this.ID = this.getGUID();
	    },
    	//SQL查询
    	query:function(endName,callBack) {
    		//alert("公交站点查询["+endName+"]");
    		this.callBack = callBack;
    		
    		var params = new SuperMap.REST.StopQueryParameters({
				keyWord : endName,
				returnPosition : true
			});
			var iserver = new SuperMap.REST.StopQueryService(BaseObject.serviceList["transferQueryServ"].url,
			{
				eventListeners : {
					processCompleted : this.stopQuerySucceed,
					processFailed : this.stopQueryFailed
				}
			});
			iserver.processAsync(params);
    	},
    	stopQuerySucceed:function(stopQueryEvent) {
    		//alert("站点查询成功");
			//alert(stopQueryEvent.result.transferStopInfos.length);
    		transferStopQueryService.callBack(stopQueryEvent);
    	},
    	stopQueryFailed:function(e){
    		alert("站点查询失败-->"+e.error.errorMsg);
    	},
	    //初始化位置
	    initPosition: function() { },
	    doResize: function() { },
	    CLASS_NAME: "BaseObject.TransferStopQueryService"
	});
	module.exports = BaseObject.TransferStopQueryService;
});