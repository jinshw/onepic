define(function (require, exports, module) {
    BaseObject.GeometryChooseQuery = BaseHelper.Class.create();
    BaseObject.GeometryChooseQuery.prototype = BaseHelper.Class.inherit(BaseObject.Component, {
        initialize: function (globalMap, configData) {
            this.ID = this.getGUID();
            if (globalMap) {
                configData == null ? {} : configData;
                this.init(globalMap, configData)
            }
        },
        init: function (globalMap, configData) {
            this.globalMap = globalMap;
            this.configData = configData
        },
        execute: function (data, callback) {
            var thisCallBack = this;
            var datasetNames = data.datasetNames || this.globalMap.getOverlayerDatasetNames();
            var spatialQueryMode = data.spatialQueryMode || SuperMap.SpatialQueryMode.INTERSECT;
            var queryParameter = data.queryParameter;
            var geometry = data.geometry;
            var returnContent = data.returnContent || true;
            var fromIndex = data.fromIndex || 0;
            var toIndex = data.toIndex || 19;
            var attributeFilter = data.attributeFilter || "1=1";
            var fields = data.fields || null;
            var maxFeatures = data.maxFeatures || 3000;
       
            var baseDatasource = BaseObject.baseDatasource;
            var thisCallBack = this;
            var datasetArray = [];
            if (typeof (datasetNames) == "object") {
                for (var i in datasetNames) {
                    if (this.globalMap.hashMapLayers[datasetNames[i]] == undefined || typeof (this.globalMap.hashMapLayers[datasetName[i]]) == "undefined") {
                        datasetArray.push(baseDatasource + ":" + datasetNames[i])
                    } else {
                        datasetArray.push(this.globalMap.hashMapLayers[datasetNames[i]].DATASOURCE + ":" + layerdatasetNameName[i])
                    }
                }
            } else {
                datasetArray.push(baseDatasource + ":" + datasetNames)
            }
            var bufferParam = new SuperMap.GetFeaturesByGeometryParameters({
                datasetNames: datasetArray,
                spatialQueryMode: spatialQueryMode,
                geometry: geometry || this.globalMap.geometry,
                returnContent: returnContent,
                attributeFilter: attributeFilter,
                queryParameter:queryParameter ,
                fields: fields,
                maxFeatures: maxFeatures,
                fromIndex: fromIndex,
                toIndex: toIndex
            });
            var url = BaseObject.mapDataUrl;
            L.supermap.featureService(url).getFeaturesByGeometry(bufferParam,
            function (serviceResult) {
                thisCallBack.processCompleted(serviceResult);
                if (callback) callback(serviceResult, data)
            })
        },
        _getZoomBufferDistance: function () {
            var bufferDistance = 0;
            switch (this.globalMap.mapHandler.mapObject.getZoom()) {
                case 0:
                    bufferDistance = 100000;
                    break;
                case 1:
                    bufferDistance = 50000;
                    break;
                case 2:
                    bufferDistance = 30000;
                    break;
                case 3:
                    bufferDistance = 20000;
                    break;
                case 4:
                    bufferDistance = 10000;
                    break;
                case 5:
                    bufferDistance = 8000;
                    break;
                case 6:
                    bufferDistance = 5000;
                    break;
                case 7:
                    bufferDistance = 3000;
                    break;
                case 8:
                    bufferDistance = 2000;
                    break;
                case 9:
                    bufferDistance = 1000;
                    break;
                case 10:
                    bufferDistance = 800;
                    break;
                case 11:
                    bufferDistance = 600;
                    break;
                case 12:
                    bufferDistance = 500;
                    break;
                case 13:
                    bufferDistance = 300;
                    break;
                case 13:
                    bufferDistance = 200;
                    break;
                default:
                    bufferDistance = 100;
                    break
            }
            return bufferDistance
        },
        processCompleted: function (queryEventArgs) {
            var result = queryEventArgs.result;
            if (result && result.features) {
                this.dispathEvent("processCompleted", queryEventArgs)
            }
        },
        paging: function (start, end) {
            this.execute(this.layerName, this.bufferNum, start, end)
        },
        processFailed: function (e) {
            alert("缓冲查询失败-->" + e.error.errorMsg);
            this.dispathEvent("processFailed", e)
        },
        initPosition: function () { },
        doResize: function () { },
        CLASS_NAME: "BaseObject.GeometryChooseQuery"
    });
    module.exports = BaseObject.GeometryChooseQuery
});