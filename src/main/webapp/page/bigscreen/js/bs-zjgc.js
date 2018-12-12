/**
 * 专题图：在建工程
 */

var style = {
    strokeColor: "#3385ff",
    strokeWidth: 10,
    strokeOpacity:"0.5",
    fillOpacity: "0.5"
}


$(document).ready(function () {
    $("input[name='projectType']").click(function () {
        console.log($(this).val())
        var projectType = $(this).val()
        changeProjectType(projectType)
    })
})

function changeProjectType(type) {
    displayProjectTypeTree(type)
    queryRoad()
}

function displayProjectTypeTree(type) {
    if (type == 'tbj') {
        $("#accordionTBJ").css("display", "block")
        $("#accordionDZJ").css("display", "none")
        $("#accordionSCJS").css("display", "none")
    } else if (type == 'dzj') {
        $("#accordionTBJ").css("display", "none")
        $("#accordionDZJ").css("display", "block")
        $("#accordionSCJS").css("display", "none")
    } else if (type == 'jsbt') {
        $("#accordionTBJ").css("display", "none")
        $("#accordionDZJ").css("display", "none")
        $("#accordionSCJS").css("display", "block")
    }
}

/**
 *  左侧道路树查询
 */
var gsFeatures = null;
var gdFeatures = null;
var sdFeatures = null;

function queryRoad(content) {
    content = $("#sole-input").val();
    content = $.trim(content);
    if (content == undefined) {
        content = ""
    }
    var queryParamGS, queryParamGD, queryParamSD, queryBySQLParams, queryBySQLService;
    queryParamGS = new SuperMap.REST.FilterParameter({
        name: "GLGS_1@xj",
        attributeFilter: "XMMC LIKE '%" + content + "%'"

    });
    queryParamGD = new SuperMap.REST.FilterParameter({
        // name: "一般国道@交通#2#4"
        name: "GLGD_3@xj",
        attributeFilter: "XMMC LIKE '%" + content + "%'"
    });
    queryParamSD = new SuperMap.REST.FilterParameter({
        name: "GLSD@xj#4",
        // name: "一般省道@交通#3",
        attributeFilter: "XMMC LIKE '%" + content + "%'"
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
}

// 调用查询道路
queryRoad()

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
    toggleProjectType(gsFeatures, gdFeatures, sdFeatures)
}


function toggleProjectType(gs, gd, sd) {
    var type = $("input[name='projectType']:checked").val();
    var gsStr = "", gdStr = "", sdStr = "";
    for (var i = 0; i < gsFeatures.length; i++) {
        _obj = gsFeatures[i].attributes
        if (_obj.SSJB.trim() == "厅本级" && type == "tbj") {
            // gsStr = gsStr + `<li><a href="javascript:void(0)" data-smId="${_obj.SmID}" data-gljb="${_obj.GLJB}">${_obj.XMMC}</a></li>`
            gsStr = gsStr + `<li><div class="text-item"><a href="javascript:void(0);" data-smId="${_obj.SmID}" data-gljb="${_obj.GLJB}">${_obj.XMMC}</a></div></li>`;
        } else if (_obj.SSJB.trim() == "地州级" && type == "dzj") {
            // gsStr = gsStr + `<li><a href="javascript:void(0)" data-smId="${_obj.SmID}" data-gljb="${_obj.GLJB}">${_obj.XMMC}</a></li>`
            gsStr = gsStr + `<li><div class="text-item"><a href="javascript:void(0);" data-smId="${_obj.SmID}" data-gljb="${_obj.GLJB}">${_obj.XMMC}</a></div></li>`;
        } else if (_obj.SSJB.trim() == "建设兵团级" && type == "jsbt") {
            // gsStr = gsStr + `<li><a href="javascript:void(0)" data-smId="${_obj.SmID}" data-gljb="${_obj.GLJB}">${_obj.XMMC}</a></li>`
            gsStr = gsStr + `<li><div class="text-item"><a href="javascript:void(0);" data-smId="${_obj.SmID}" data-gljb="${_obj.GLJB}">${_obj.XMMC}</a></div></li>`;
        }
    }
    for (var i = 0; i < gdFeatures.length; i++) {
        _obj = gdFeatures[i].attributes
        if (_obj.SSJB.trim() == "厅本级" && type == "tbj") {
            // gdStr = gdStr + `<li><a href="javascript:void(0)" data-smId="${_obj.SmID}" data-gljb="${_obj.GLJB}">${_obj.XMMC}</a></li>`
            gdStr = gdStr + `<li><div class="text-item"><a href="javascript:void(0);" data-smId="${_obj.SmID}" data-gljb="${_obj.GLJB}">${_obj.XMMC}</a></div></li>`;
        } else if (_obj.SSJB.trim() == "地州级" && type == "dzj") {
            // gdStr = gdStr + `<li><a href="javascript:void(0)" data-smId="${_obj.SmID}" data-gljb="${_obj.GLJB}">${_obj.XMMC}</a></li>`
            gdStr = gdStr + `<li><div class="text-item"><a href="javascript:void(0);" data-smId="${_obj.SmID}" data-gljb="${_obj.GLJB}">${_obj.XMMC}</a></div></li>`;
        } else if (_obj.SSJB.trim() == "建设兵团级" && type == "jsbt") {
            // gdStr = gdStr + `<li><a href="javascript:void(0)" data-smId="${_obj.SmID}" data-gljb="${_obj.GLJB}">${_obj.XMMC}</a></li>`
            gdStr = gdStr + `<li><div class="text-item"><a href="javascript:void(0);" data-smId="${_obj.SmID}" data-gljb="${_obj.GLJB}">${_obj.XMMC}</a></div></li>`;
        }
    }
    for (var i = 0; i < sdFeatures.length; i++) {
        _obj = sdFeatures[i].attributes
        if (_obj.SSJB.trim() == "厅本级" && type == "tbj") {
            // sdStr = sdStr + `<li><a href="javascript:void(0)" data-smId="${_obj.SmID}" data-gljb="${_obj.GLJB}">${_obj.XMMC}</a></li>`
            sdStr = sdStr + `<li><div class="text-item"><a href="javascript:void(0);" data-smId="${_obj.SmID}" data-gljb="${_obj.GLJB}">${_obj.XMMC}</a></div></li>`;
        } else if (_obj.SSJB.trim() == "地州级" && type == "dzj") {
            // sdStr = sdStr + `<li><a href="javascript:void(0)" data-smId="${_obj.SmID}" data-gljb="${_obj.GLJB}">${_obj.XMMC}</a></li>`
            sdStr = sdStr + `<li><div class="text-item"><a href="javascript:void(0);" data-smId="${_obj.SmID}" data-gljb="${_obj.GLJB}">${_obj.XMMC}</a></div></li>`;

        } else if (_obj.SSJB.trim() == "建设兵团级" && type == "jsbt") {
            // sdStr = sdStr + `<li><a href="javascript:void(0)" data-smId="${_obj.SmID}" data-gljb="${_obj.GLJB}">${_obj.XMMC}</a></li>`
            sdStr = sdStr + `<li><div class="text-item"><a href="javascript:void(0);" data-smId="${_obj.SmID}" data-gljb="${_obj.GLJB}">${_obj.XMMC}</a></div></li>`;
        }
    }

    if (type == "tbj") {
        $("#gsULTBJ").html(gsStr);
        $("#gdULTBJ").html(gdStr);
        $("#sdULTBJ").html(sdStr);

        $("#gsULTBJ>li>div>a").click(function () {
            onClick({smId: $(this).data("smid"), gljb: $(this).data("gljb")})
        })
        $("#gdULTBJ>li>div>a").click(function () {
            onClick({smId: $(this).data("smid"), gljb: $(this).data("gljb")})
        })
        $("#sdULTBJ>li>div>a").click(function () {
            onClick({smId: $(this).data("smid"), gljb: $(this).data("gljb")})
        })
    } else if (type == "dzj") {
        $("#gsULDZJ").html(gsStr);
        $("#gdULDZJ").html(gdStr);
        $("#sdULDZJ").html(sdStr);
        $("#gsULDZJ>li>div>a").click(function () {
            onClick({smId: $(this).data("smid"), gljb: $(this).data("gljb")})
        })
        $("#gdULDZJ>li>div>a").click(function () {
            onClick({smId: $(this).data("smid"), gljb: $(this).data("gljb")})
        })
        $("#sdULDZJ>li>div>a").click(function () {
            onClick({smId: $(this).data("smid"), gljb: $(this).data("gljb")})
        })
    } else if (type == "jsbt") {
        $("#gsULJSBT").html(gsStr);
        $("#gdULJSBT").html(gdStr);
        $("#sdULJSBT").html(sdStr);
        $("#gsULJSBT>li>div>a").click(function () {
            onClick({smId: $(this).data("smid"), gljb: $(this).data("gljb")})
        })
        $("#gdULJSBT>li>div>a").click(function () {
            onClick({smId: $(this).data("smid"), gljb: $(this).data("gljb")})
        })
        $("#sdULJSBT>li>div>a").click(function () {
            onClick({smId: $(this).data("smid"), gljb: $(this).data("gljb")})
        })
    }
}

function onClick(treeNode) {
    removeMapAllFeatures();
    vectorLayer.removeAllFeatures();// 去除高亮
    vectorLayer.setVisibility(true)
    lineLayer.setVisibility(false)
    // removeVectorLayer()
    // deactiveAll();// 注销点控件
    var feature;
    // 判断海德中是否有数据添加条件 && treeNode.uniqueid != '0' && treeNode.uniqueid != ""
    if (treeNode.gljb != undefined) {
        if (treeNode.uniqueid != "0") {
            // app.checkall(treeNode.uniqueid);
        } else {
            // layer.msg("没有该项目信息");
            console.log("没有该项目信息")
        }
        var queryParam, queryParamGS, queryParamGD, queryParamSD, queryBySQLParams, queryBySQLService;
        if (treeNode.gljb == 'GS') {
            queryParam = new SuperMap.REST.FilterParameter({
                name: "GLGS_1@xj",
                attributeFilter: "SmID = " + treeNode.smId
            });
        } else if (treeNode.gljb == 'GD') {
            queryParam = new SuperMap.REST.FilterParameter({
                // name: "一般国道@交通#2#4",
                name: "GLGD_3@xj",
                attributeFilter: "SmID = " + treeNode.smId
            });
        } else if (treeNode.gljb == 'SD') {
            queryParam = new SuperMap.REST.FilterParameter({
                name: "GLSD@xj#4",
                // name: "一般省道@交通#3",
                attributeFilter: "SmID = " + treeNode.smId
            });
        }

        queryBySQLParams = new SuperMap.REST.QueryBySQLParameters({
            queryParams: [queryParam]
        });
        queryBySQLService = new SuperMap.REST.QueryBySQLService(
            MAPURL.ZJ_ROAD,
            {
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
    } else {
        // layer.msg("系统中没有该项目信息！")
    }
}

