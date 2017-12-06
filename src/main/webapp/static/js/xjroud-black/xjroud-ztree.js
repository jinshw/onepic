/**
 * ztree 模块
 */
var zTreeObj,zTreeObjDZ,zTreeObjJS;
var style = {
    strokeColor: "red",
    strokeWidth: 5,
    fillOpacity: "1"
}
// zTree 的参数配置，深入使用请参考 API 文档（setting 配置详解）
var setting = {
    view: {
        showLine: false,
        selectedMulti: false
    },
    data: {
        simpleData: {
            enable: true,
            idKey: "id",
            pIdKey: "pId",
            rootPId: ""
        }
    },
    callback: {
        onClick: onClick
    }
};

function onClick(event, treeId, treeNode) {
//        vectorLayer.removeAllFeatures();// 去除高亮
    vectorLayer.setVisibility(true)
    removeVectorLayer()
    deactiveAll();//注销点控件

    var feature;
    if (treeNode.gljb != undefined) {
        var queryParam, queryParamGS, queryParamGD, queryParamSD, queryBySQLParams, queryBySQLService;
        if (treeNode.gljb == 'GS') {
            queryParam = new SuperMap.REST.FilterParameter({
                name: "GLGS_1@xj",
                attributeFilter: "SmID = " + treeNode.smId
            });
        } else if (treeNode.gljb == 'GD') {
            queryParam = new SuperMap.REST.FilterParameter({
                //name: "一般国道@交通#2#4",
                name: "GLGD_3@xj",
                attributeFilter: "SmID = " + treeNode.smId
            });
        } else if (treeNode.gljb == 'SD') {
            queryParam = new SuperMap.REST.FilterParameter({
                name: "一般省道@交通#3",
                attributeFilter: "SmID = " + treeNode.smId
            });
        }

        queryBySQLParams = new SuperMap.REST.QueryBySQLParameters({
            queryParams: [queryParam]
        });
        queryBySQLService = new SuperMap.REST.QueryBySQLService(MAPURL.ZJ_ROAD, {
            eventListeners: {
                "processCompleted": function (queryEventArgs) {
                    console.log("-----------")
                       // console.log(queryEventArgs)
                    console.log("-----------")
                    feature = queryEventArgs.result.recordsets[0].features[0]
                    feature.style = style;
                    vectorLayer.addFeatures(feature);
                    map.zoomToExtent(feature.geometry.getBounds())

                    // 显示项目信息
                    if ($("#projectInfoBt").prop("checked")) {
                        $("#projectInfoAreaId").css("display", "block")
                    }
                    // 显示影像核查信息
                    if ($("#yxhcInfoBt").prop("checked")) {
                        $("#yxhcInfoArea").css("display", "block")
                    }
                },
                "processFailed": processFailed
            }
        });
        queryBySQLService.processAsync(queryBySQLParams);
    }

}

vectorLayer = new SuperMap.Layer.Vector("Vector Layer");

var treeNodes = [
    {id: 1, pId: 0, name: "厅本级项目", open: true},
    {id: 11, pId: 1, name: "高速"},
    {id: 12, pId: 1, name: "国道"},
    {id: 13, pId: 1, name: "省道"}
];
var treeNodesDZ = [
    {id: 1, pId: 0, name: "地州级项目", open: true},
    {id: 11, pId: 1, name: "高速"},
    {id: 12, pId: 1, name: "国道"},
    {id: 13, pId: 1, name: "省道"}
];
var treeNodesJS = [
    {id: 1, pId: 0, name: "建设兵团级项目", open: true},
    {id: 11, pId: 1, name: "高速"},
    {id: 12, pId: 1, name: "国道"},
    {id: 13, pId: 1, name: "省道"}
];

var gsFeatures = null;
var gdFeatures = null;
var sdFeatures = null;

$(function () {
    function autoHeight() {
        var winH = $(window).height();
        var footerH = $('.footerWrap').height();
        var headerH = $('.headerWrap').height();
        return winH - footerH - headerH;
    }

    $('.mapWrap').height(autoHeight());
    $(window).resize(function () {
        $('.mapWrap').height(autoHeight());
    });


    $('.mianNav>li').hover(function () {
        $(this).find('ul').show().parent().siblings().find('ul').hide();
    }, function () {
        $(this).find('ul').hide();
    });

    $('.js_drop').click(function () {
        $(this).find('p').toggle();
    });


    var queryParamGS, queryParamGD, queryParamSD, queryBySQLParams, queryBySQLService;
    queryParamGS = new SuperMap.REST.FilterParameter({
        name: "GLGS_1@xj"
    });
    queryParamGD = new SuperMap.REST.FilterParameter({
        // name: "一般国道@交通#2#4"
        name: "GLGD_3@xj"
    });
    queryParamSD = new SuperMap.REST.FilterParameter({
        name: "一般省道@交通#3"
    });
    queryBySQLParams = new SuperMap.REST.QueryBySQLParameters({
        queryParams: [queryParamGS, queryParamGD, queryParamSD],
        queryOption: "ATTRIBUTE"
    });
    queryBySQLService = new SuperMap.REST.QueryBySQLService(MAPURL.ZJ_ROAD, {
        eventListeners: {
            "processCompleted": processCompleted,
            "processFailed": processFailed
        }
    });
    queryBySQLService.processAsync(queryBySQLParams);

})


// 查询数据集处理
function processCompleted(queryEventArgs) {
    gsFeatures = queryEventArgs.result.recordsets[0].features
    gdFeatures = queryEventArgs.result.recordsets[1].features
    sdFeatures = queryEventArgs.result.recordsets[2].features

    console.log(">>>>>>>>>>>>>>>>>")
       // console.log(gsFeatures)
       // console.log(gdFeatures)
       // console.log(sdFeatures)
    console.log(">>>>>>>>>>>>>>>>>")

    var _obj = null;
    var _count = 0;
    for (var i = 0; i < gsFeatures.length; i++) {
        _obj = gsFeatures[i].attributes
        if (_obj.XMMC == 'G7大黄山至乌鲁木齐段改扩建工程') {
            if (_count == 0) {
                if(_obj.SSJB.trim() == "厅本级"){
                    treeNodes.push({id: i + 2000, pId: 11, name: _obj.XMMC, smId: _obj.SmID, gljb: _obj.GLJB, arrIndex: i})
                }else if(_obj.SSJB.trim() == "地州级"){
                    treeNodesDZ.push({id: i + 2000, pId: 11, name: _obj.XMMC, smId: _obj.SmID, gljb: _obj.GLJB, arrIndex: i})
                }else if(_obj.SSJB.trim() == "建设兵团级"){
                    treeNodesJS.push({id: i + 2000, pId: 11, name: _obj.XMMC, smId: _obj.SmID, gljb: _obj.GLJB, arrIndex: i})
                }
                // treeNodes.push({id: i + 2000, pId: 11, name: _obj.XMMC, smId: _obj.SmID, gljb: _obj.GLJB, arrIndex: i})
            }
            _count = _count + 1;
        } else {
            if(_obj.SSJB.trim() == "厅本级"){
                treeNodes.push({id: i + 2000, pId: 11, name: _obj.XMMC, smId: _obj.SmID, gljb: _obj.GLJB, arrIndex: i})
            }else if(_obj.SSJB.trim() == "地州级"){
                treeNodesDZ.push({id: i + 2000, pId: 11, name: _obj.XMMC, smId: _obj.SmID, gljb: _obj.GLJB, arrIndex: i})
            }else if(_obj.SSJB.trim() == "建设兵团级"){
                treeNodesJS.push({id: i + 2000, pId: 11, name: _obj.XMMC, smId: _obj.SmID, gljb: _obj.GLJB, arrIndex: i})
            }
            // treeNodes.push({id: i + 2000, pId: 11, name: _obj.XMMC, smId: _obj.SmID, gljb: _obj.GLJB, arrIndex: i})
        }

    }
    for (var i = 0; i < gdFeatures.length; i++) {
        _obj = gdFeatures[i].attributes
        // treeNodes.push({id: i + 3000, pId: 12, name: _obj.XMMC, smId: _obj.SmID, gljb: _obj.GLJB, arrIndex: i})
        if(_obj.SSJB.trim() == "厅本级"){
            treeNodes.push({id: i + 3000, pId: 12, name: _obj.XMMC, smId: _obj.SmID, gljb: _obj.GLJB, arrIndex: i})
        }else if(_obj.SSJB.trim() == "地州级"){
            treeNodesDZ.push({id: i + 3000, pId: 12, name: _obj.XMMC, smId: _obj.SmID, gljb: _obj.GLJB, arrIndex: i})
        }else if(_obj.SSJB.trim() == "建设兵团级"){
            treeNodesJS.push({id: i + 3000, pId: 12, name: _obj.XMMC, smId: _obj.SmID, gljb: _obj.GLJB, arrIndex: i})
        }
    }
    for (var i = 0; i < sdFeatures.length; i++) {
        _obj = sdFeatures[i].attributes
        // treeNodes.push({id: i + 4000, pId: 13, name: _obj.XMMC, smId: _obj.SmID, gljb: _obj.GLJB, arrIndex: i})
        if(_obj.SSJB.trim() == "厅本级"){
            treeNodes.push({id: i + 4000, pId: 13, name: _obj.XMMC, smId: _obj.SmID, gljb: _obj.GLJB, arrIndex: i})
        }else if(_obj.SSJB.trim() == "地州级"){
            treeNodesDZ.push({id: i + 4000, pId: 13, name: _obj.XMMC, smId: _obj.SmID, gljb: _obj.GLJB, arrIndex: i})
        }else if(_obj.SSJB.trim() == "建设兵团级"){
            treeNodesJS.push({id: i + 4000, pId: 13, name: _obj.XMMC, smId: _obj.SmID, gljb: _obj.GLJB, arrIndex: i})
        }
    }
    zTreeObj = $.fn.zTree.init($("#treeDemo"), setting, treeNodes);
    zTreeObjDZ = $.fn.zTree.init($("#treeDemoDZ"), setting, treeNodesDZ);
    zTreeObjJS = $.fn.zTree.init($("#treeDemoJS"), setting, treeNodesJS);
}

function processFailed(e) {
    console.log(e)
    alert(e.error.errorMsg);
}
