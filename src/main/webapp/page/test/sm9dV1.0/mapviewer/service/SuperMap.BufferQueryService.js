define(function (require, exports, module) {
    BaseObject.BufferQueryService = BaseHelper.Class.create();
    BaseObject.BufferQueryService.prototype = BaseHelper.Class.inherit(BaseObject.Component, {

        initialize: function (globalMap, configData) {
            this.ID = this.getGUID();
            if (globalMap) {
                configData == null ? {} : configData;
                this.init(globalMap, configData);
            }
        },
        init: function (globalMap, configData) {

            this.globalMap = globalMap;
            this.configData = configData;
        },
        execute: function (data,callback) {
            var thisCallBack = this;
            var datasetNames = data.datasetName || this.globalMap.getOverlayerDatasetNames();
            var bufferDistance = data.bufferDistance;
            var geometry = data.geometry;
            var returnContent = data.returnContent || true;
            var fromIndex=data.fromIndex||0; 
            var toIndex = data.toIndex || 19;
            var isConvert = data.isConvert;
            var attributeFilter=data.attributeFilter ||"1=1";
            var fields = data.fields;
            var maxFeatures = data.maxFeatures || 1000;
            var url = BaseObject.mapDataUrl;
            if (data.refData && data.refData.url)
                url = data.refData.url;

            if (!bufferDistance) {
                bufferDistance = thisCallBack._getZoomBufferDistance();
            }
            if(isConvert)
            var bufferDistance = bufferDistance / (2 * Math.PI * 6371004) * 360;
        
            var geometry = L.circle(geometry, { radius: 0, color: 'red', fillColor: '#f03', fillOpacity: 1 });
           
            var dataSourceName = data.dataSourceName || BaseObject.baseDatasource;
            var thisCallBack = this;

            var datasetArray = [];
            if (typeof (datasetNames) == "object") {
                for (var i = 0; i < datasetNames.length;i++) {
                    if (this.globalMap.hashMapLayers[datasetNames[i]] == undefined || typeof (this.globalMap.hashMapLayers[datasetNames[i]]) == "undefined") {
                        datasetArray.push(dataSourceName + ":" + datasetNames[i])
                    } else {
                        datasetArray.push(this.globalMap.hashMapLayers[datasetNames[i]].DATASOURCE + ":" + datasetNames[i])
                    }
                }
            } else {
                datasetArray.push(dataSourceName + ":" + datasetNames)
            }
            var bufferParam = new SuperMap.GetFeaturesByBufferParameters({
                datasetNames: datasetArray,
                bufferDistance: bufferDistance,
                geometry: geometry || this.globalMap.geometry,
                returnContent: returnContent,
                attributeFilter:attributeFilter,  
                fields: fields,
                maxFeatures:1,
                fromIndex: fromIndex,
                toIndex: toIndex
            });

         
            L.supermap
              .featureService(url)
            .getFeaturesByBuffer(bufferParam, function (serviceResult) {
                thisCallBack.processCompleted(serviceResult);
                if (callback) callback(serviceResult, data);
            });
        },

        _getZoomBufferDistance:function()
        {
            var bufferDistance = 0;
            switch (this.globalMap.mapHandler.mapObject.getZoom()) {
                case 0: bufferDistance = 100000; break;
                case 1: bufferDistance = 50000; break;
                case 2: bufferDistance = 30000; break;
                case 3: bufferDistance = 20000; break;
                case 4: bufferDistance = 12000; break;
                case 5: bufferDistance = 10000; break;
                case 6: bufferDistance = 5000; break;
                case 7: bufferDistance = 3000; break;
                case 8: bufferDistance = 2000; break;
                case 9: bufferDistance = 1000; break;
                case 10: bufferDistance = 800; break;
                case 11: bufferDistance = 600; break;
                case 12: bufferDistance = 500; break;
                case 13: bufferDistance = 300; break;
                case 13: bufferDistance = 200; break;
                default:
                    bufferDistance = 100; break;
            }
            return bufferDistance;
        },
        processCompleted: function (queryEventArgs) {
            //alert("缓冲查询成功");
            var result = queryEventArgs.result;
            //if (result && result.features) {
                this.dispathEvent("processCompleted", queryEventArgs);
            //}
        },
        paging: function (start, end) {
            this.execute(this.layerName, this.bufferNum, start, end)
        },
        processFailed: function (e) {
            alert("缓冲查询失败-->" + e.error.errorMsg);
            this.dispathEvent("processFailed", e);
        },
        //初始化位置
        initPosition: function () { },
        doResize: function () { },
        CLASS_NAME: "BaseObject.BufferQueryService"
    });
    module.exports = BaseObject.BufferQueryService;
});