define(function (require, exports, module) {
    BaseObject.TransferPathQueryService = BaseHelper.Class.create();
    BaseObject.TransferPathQueryService.prototype = BaseHelper.Class.inherit(BaseObject.Component, {

        initialize: function (globalMap, configData) {
            this.bufferGeometry = null;
            if (globalMap) {
                configData == null ? {} : configData;
                this.init(globalMap, configData);
            }
            this.ID = this.getGUID();
        },
        init: function (globalMap, configData) {

            this.globalMap = globalMap;
            this.configData = configData;
        },
        //查询
        execute: function (points) {
            //alert("交通换乘查询1");
            //points 查询参数有两种形式 ：：[起点ID,终点ID] /  [{"x":44,"y":39},{"x":45,"y":40}]
            var thisCallBack = this;
            this.globalMap.paths = {};
            this.globalMap.paths["points"] = points;
            //配置公交换乘参数
            var params = new SuperMap.REST.TransferSolutionParameters({
                solutionCount: 6, //最大换乘导引数量
                transferTactic: SuperMap.REST.TransferTactic.MIN_DISTANCE, //公交换乘策略类型
                transferPreference: "NONE",
                walkingRatio: 10, //步行与公交的消耗权重比
                points: points
                //起始点坐标
            });
            // 配置公交换乘服务,监听两个事件，processCompleted和processFailed,服务端成功返回查询结果时触发
            //processCompleted 事件，服务端返回查询结果失败时触发 processFailed 事件。
            var iserver = new SuperMap.REST.TransferSolutionService(
    				BaseObject.serviceList["transferQueryServ"].url, {
    				    eventListeners: {
    				        processCompleted: function (e) { thisCallBack.transferSolutionsSucceed(e) },
    				        processFailed: function (e) { thisCallBack.transferSolutionsFailed(e) }
    				    }
    				}
    		);
            iserver.processAsync(params);
        },
        transferSolutionsSucceed: function (event) {
            //alert("交通换乘查询成功");
            //在地图上叠加符号信息
            var transGuide = event.result.transferGuide, transSolutions = event.result.solutionItems, Solutions = [];
            //alert(transSolutions.length);
            if (transSolutions.length > 0) {
                //alert(event.result.solutionItems[0].linesItems[0].lineItems[0].lineName);

                //解析查询结果
                for (var j = 0; j < transSolutions.length; j++) {
                    var linesItems = transSolutions[j].linesItems, transSolution = [];
                    for (var jj = 0; jj < linesItems.length; jj++) {
                        var lineItems = linesItems[jj].lineItems, items = [];
                        for (var jjj = 0; jjj < lineItems.length; jjj++) {
                            var lineItem = lineItems[jjj];
                            items.push("{'lineID':" + lineItem.lineID
									+ ",'startStopIndex':"
									+ lineItem.startStopIndex + ",'endStopIndex':"
									+ lineItem.endStopIndex + "}");
                        }
                        transSolution.push(items);
                    }
                    Solutions.push(transSolution);
                }
                this.globalMap.paths["transSolutions"] = transSolutions;
                this.globalMap.paths["solutions"] = Solutions;
                if (!transGuide || !transSolutions)
                    return;

                var transRes = $("<div class='transferResult'></div>");
                var solution, lines, line, dispStatus = "block", strMessage = "";
                for (var i = 0, iLen = transSolutions.length; i < iLen; i++) {
                    solution = transSolutions[i];
                    var title = "";
                    for (var ii = 0, iiLen = solution.linesItems.length; ii < iiLen; ii++) {
                        lines = solution.linesItems[ii];
                        for (var iii = 0, iiiLen = lines.lineItems.length; iii < iiiLen; iii++) {
                            line = lines.lineItems[iii];
                            if (iii !== iiiLen - 1) {
                                title += line.lineName + "/";
                            } else {
                                title += line.lineName;
                            }
                        }
                        if (ii !== iiLen - 1) {
                            title += " → ";
                        }
                    }
                    //存放默认路径,默认取数组的第一个元素
                    var path = "[", pLine;
                    var pathLines = solution.linesItems;
                    for (var pi = 0, pLen = pathLines.length; pi < pLen; pi++) {
                        pLine = pathLines[pi].lineItems[0];
                        path += "{'lineID':" + pLine.lineID + ",'startStopIndex':"
								+ pLine.startStopIndex + ",'endStopIndex':"
								+ pLine.endStopIndex + "}";
                        if (pi !== pLen - 1)
                            path += ",";
                    }
                    path += "]";
                    var index = "solutions_" + i;
                    this.globalMap.paths[index] = path;

                    $(
							"<div class='transferSolution' id='transferSolution-" + i + "'><span class='transferIndex'>方案"
									+ (i + 1) + "：</span>" + title + "</div>")
							.appendTo(transRes);

                    if (i !== 0) {
                        dispStatus = "none";
                    }
                    var list = $(
							"<div class='transferInfo' id='transferInfo-" + i + "' style='display:" + dispStatus + "'></div>")
							.appendTo(transRes);
                    list.appendTo(transRes);
                }
                strMessage += transRes.html();
                this.dispathEvent("processCompleted", transSolutions);
            
            }
        },
        transferSolutionsFailed: function (e) {
            alert("交通换乘查询失败-->" + e.error.errorMsg);
            this.dispathEvent("transferSolutionsFailed", e);
        },
        //初始化位置
        initPosition: function () { },
 
        CLASS_NAME: "BaseObject.TransferPathQueryService"
    });
    module.exports = BaseObject.TransferPathQueryService;
});