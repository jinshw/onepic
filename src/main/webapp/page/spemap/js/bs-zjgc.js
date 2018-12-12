/**
 * 专题图：在建工程
 */

var style = {
    strokeColor: "#3385ff",
    strokeWidth: 8
    // strokeOpacity:"0.5",
    // fillOpacity: "0.5"
}
var styleRedH = {
    strokeColor: "#FF0D01",
    strokeWidth: 8
    // strokeOpacity:"0.5",
    // fillOpacity: "0.5"
}
var styleYelH = {
    strokeColor: "#F7FF01",
    strokeWidth: 8
    // strokeOpacity:"0.5",
    // fillOpacity: "0.5"
}
var styleGreH = {
    strokeColor: "#67FF01",
    strokeWidth: 8
    // strokeOpacity:"0.5",
    // fillOpacity: "0.5"
}


// $(document).ready(function () {
//     // $("input[name='projectType']").click(function () {
//     //     console.log($(this).val())
//     //     var projectType = $(this).val()
//     //     changeProjectType(projectType)
//     // })
//     //initZttMap();
// })
function initZttMap() {
    // 在建工程图层显示
    //layerZJRoad.setVisibility(true);

    //map.addLayers([layerZJRoadR,layerZJRoadY,layerZJRoadG]);
    //搜索填充三个底图
    queryRoadByDsAll();
    //搜索填充列表
    zjgcSearch();
    $("#zjgcList").css("display", "block");
    // setTimeout(function(){
    //     map.zoomIn();
    //     map.zoomOut();
    //     },20000);

    // feature = queryEventArgs.result.recordsets[0].features[0];
    // reWriteLayer(feature.geometry);
}
function queryRoadByDsAll(){
    removeZttMapAllFeatures();
    queryRoadByDs("GLGS_1@xj","厅本级");
    queryRoadByDs("GLGS_1@xj","地州级","part1");
    queryRoadByDs("GLGS_1@xj","地州级","part2");
    queryRoadByDs("GLGS_1@xj","生产建设兵团");
    queryRoadByDs("GLGD_3@xj","厅本级");
    queryRoadByDs("GLGD_3@xj","地州级");
    queryRoadByDs("GLGD_3@xj","生产建设兵团");
    queryRoadByDs("GLSD@xj","厅本级");
    queryRoadByDs("GLSD@xj","地州级");
    queryRoadByDs("GLSD@xj","生产建设兵团");
}
function queryRoadByDs(dataSetName,ssjbName,partFlag) {
    var queryParam, queryBySQLParams, queryBySQLService;
    if(ssjbName=="地州级" && partFlag=="part1"){
        queryParam = new SuperMap.REST.FilterParameter({
            name: dataSetName,
            attributeFilter: "SSJB = '"+ssjbName+"',SSJB < 10"
        });
    }else if(ssjbName=="地州级" && partFlag=="part2"){
        queryParam = new SuperMap.REST.FilterParameter({
            name: dataSetName,
            attributeFilter: "SSJB = '"+ssjbName+"',SSJB > 10"
        });
    }else{
        queryParam = new SuperMap.REST.FilterParameter({
            name: dataSetName,
            attributeFilter: "SSJB = '"+ssjbName+"'"
        });
    }

    queryBySQLParams = new SuperMap.REST.QueryBySQLParameters({
        //queryParams: [queryParamGS, queryParamGD, queryParamSD],
        queryParams: [queryParam],
        queryOption: "ATTRIBUTEANDGEOMETRY"
    });
    queryBySQLService = new SuperMap.REST.QueryBySQLService(MAPURL.ZJ_ROAD, {
        eventListeners: {
            "processCompleted": initProcessCompleted,
            "processFailed": processFailed
        }
    });
    queryBySQLService.processAsync(queryBySQLParams);
}
// 查询数据集处理
function initProcessCompleted(queryEventArgs) {

    //console.dir(queryEventArgs);
    queryFea = queryEventArgs.result.recordsets[0].features;
    //console.dir(gsFea);
    //gdFea = queryEventArgs.result.recordsets[1].features
    //sdFea = queryEventArgs.result.recordsets[2].features
    for (var i = 0; i < queryFea.length; i++) {
        var _obj = queryFea[i];
        // var _obj_att = gdFea[i].attributes;
        // var _obj_geo = gdFea[i].geometry;
        var randomNum = parseInt(Math.random()*100)+40;

        if(randomNum<=80){
            //_obj_att.JIEJIAN = "red";
            queryFea[i].attributes.JIEJIAN = "red";
            reWriteLayer(layerZJRoadR,queryFea[i],"#BF3503");
        }else if(randomNum>=80 && randomNum<=100){
            queryFea[i].attributes.JIEJIAN = "yellow";
            reWriteLayer(layerZJRoadY,queryFea[i],"#E5E104");
        }else if(randomNum>=100){
            queryFea[i].attributes.JIEJIAN = "green";
            reWriteLayer(layerZJRoadG,queryFea[i],"#07B74E");
        }

    }

}
function reWriteLayer(objLayer,objFeature,objColor){

    //  var bezierPoint =[
    //      new SuperMap.Geometry.Point(85.92614, 41.49396),
    //      new SuperMap.Geometry.Point(85.92614, 45.49396)];
    // var bezier5= new SuperMap.Geometry.LineString(bezierPoint);
    objStyle={
        //strokeColor:"#9AFF9A",
        strokeColor:objColor,
        strokeWidth:3,
        fillColor: "#304DBE",
        fillOpacity: "0"
    };
    var bezier5Vector = new SuperMap.Feature.Vector(objFeature.geometry,objFeature.attributes,objStyle);


    objLayer.addFeatures([bezier5Vector]);
    //map.addLayers([vector]);
}






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
 * 左侧道路树查询
 */
var gsFeatures = null;
var gdFeatures = null;
var sdFeatures = null;

function queryRoad(content) {
    content = $("#sole-input").val();
    content = $.trim(content);
    console.log("content:"+content);
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
    for (var i = 0; i < gs.length; i++) {
        _obj = gs[i].attributes;
        if (_obj.SSJB.trim() == "厅本级" && type == "tbj") {
            // gsStr = gsStr + `<li><a href="javascript:void(0)"
	    // data-smId="${_obj.SmID}"
	    // data-gljb="${_obj.GLJB}">${_obj.XMMC}</a></li>`
            gsStr = gsStr + `<li><div class="text-item"><a href="javascript:void(0);" data-smId="${_obj.SmID}" data-gljb="${_obj.GLJB}">${_obj.XMMC}</a></div></li>`;
        } else if (_obj.SSJB.trim() == "地州级" && type == "dzj") {
            // gsStr = gsStr + `<li><a href="javascript:void(0)"
	    // data-smId="${_obj.SmID}"
	    // data-gljb="${_obj.GLJB}">${_obj.XMMC}</a></li>`
            gsStr = gsStr + `<li><div class="text-item"><a href="javascript:void(0);" data-smId="${_obj.SmID}" data-gljb="${_obj.GLJB}">${_obj.XMMC}</a></div></li>`;
        } else if (_obj.SSJB.trim() == "建设兵团级" && type == "jsbt") {
            // gsStr = gsStr + `<li><a href="javascript:void(0)"
	    // data-smId="${_obj.SmID}"
	    // data-gljb="${_obj.GLJB}">${_obj.XMMC}</a></li>`
            gsStr = gsStr + `<li><div class="text-item"><a href="javascript:void(0);" data-smId="${_obj.SmID}" data-gljb="${_obj.GLJB}">${_obj.XMMC}</a></div></li>`;
        }
    }
    for (var i = 0; i < gd.length; i++) {
        _obj = gd[i].attributes
        if (_obj.SSJB.trim() == "厅本级" && type == "tbj") {
            // gdStr = gdStr + `<li><a href="javascript:void(0)"
	    // data-smId="${_obj.SmID}"
	    // data-gljb="${_obj.GLJB}">${_obj.XMMC}</a></li>`
            gdStr = gdStr + `<li><div class="text-item"><a href="javascript:void(0);" data-smId="${_obj.SmID}" data-gljb="${_obj.GLJB}">${_obj.XMMC}</a></div></li>`;
        } else if (_obj.SSJB.trim() == "地州级" && type == "dzj") {
            // gdStr = gdStr + `<li><a href="javascript:void(0)"
	    // data-smId="${_obj.SmID}"
	    // data-gljb="${_obj.GLJB}">${_obj.XMMC}</a></li>`
            gdStr = gdStr + `<li><div class="text-item"><a href="javascript:void(0);" data-smId="${_obj.SmID}" data-gljb="${_obj.GLJB}">${_obj.XMMC}</a></div></li>`;
        } else if (_obj.SSJB.trim() == "建设兵团级" && type == "jsbt") {
            // gdStr = gdStr + `<li><a href="javascript:void(0)"
	    // data-smId="${_obj.SmID}"
	    // data-gljb="${_obj.GLJB}">${_obj.XMMC}</a></li>`
            gdStr = gdStr + `<li><div class="text-item"><a href="javascript:void(0);" data-smId="${_obj.SmID}" data-gljb="${_obj.GLJB}">${_obj.XMMC}</a></div></li>`;
        }
    }
    for (var i = 0; i < sd.length; i++) {
        _obj = sd[i].attributes
        if (_obj.SSJB.trim() == "厅本级" && type == "tbj") {
            // sdStr = sdStr + `<li><a href="javascript:void(0)"
	    // data-smId="${_obj.SmID}"
	    // data-gljb="${_obj.GLJB}">${_obj.XMMC}</a></li>`
            sdStr = sdStr + `<li><div class="text-item"><a href="javascript:void(0);" data-smId="${_obj.SmID}" data-gljb="${_obj.GLJB}">${_obj.XMMC}</a></div></li>`;
        } else if (_obj.SSJB.trim() == "地州级" && type == "dzj") {
            // sdStr = sdStr + `<li><a href="javascript:void(0)"
	    // data-smId="${_obj.SmID}"
	    // data-gljb="${_obj.GLJB}">${_obj.XMMC}</a></li>`
            sdStr = sdStr + `<li><div class="text-item"><a href="javascript:void(0);" data-smId="${_obj.SmID}" data-gljb="${_obj.GLJB}">${_obj.XMMC}</a></div></li>`;

        } else if (_obj.SSJB.trim() == "建设兵团级" && type == "jsbt") {
            // sdStr = sdStr + `<li><a href="javascript:void(0)"
	    // data-smId="${_obj.SmID}"
	    // data-gljb="${_obj.GLJB}">${_obj.XMMC}</a></li>`
            sdStr = sdStr + `<li><div class="text-item"><a href="javascript:void(0);" data-smId="${_obj.SmID}" data-gljb="${_obj.GLJB}">${_obj.XMMC}</a></div></li>`;
        }
    }

    if (type == "tbj") {
        $("#gsULTBJ").html(gsStr);
        $("#gdULTBJ").html(gdStr);
        $("#sdULTBJ").html(sdStr);

        $("#gsULTBJ>li>div>a").click(function () {
            onClickForSel({smId: $(this).data("smid"), gljb: $(this).data("gljb")})
        })
        $("#gdULTBJ>li>div>a").click(function () {
            onClickForSel({smId: $(this).data("smid"), gljb: $(this).data("gljb")})
        })
        $("#sdULTBJ>li>div>a").click(function () {
            onClickForSel({smId: $(this).data("smid"), gljb: $(this).data("gljb")})
        })
    } else if (type == "dzj") {
        $("#gsULDZJ").html(gsStr);
        $("#gdULDZJ").html(gdStr);
        $("#sdULDZJ").html(sdStr);
        $("#gsULDZJ>li>div>a").click(function () {
            onClickForSel({smId: $(this).data("smid"), gljb: $(this).data("gljb")})
        })
        $("#gdULDZJ>li>div>a").click(function () {
            onClickForSel({smId: $(this).data("smid"), gljb: $(this).data("gljb")})
        })
        $("#sdULDZJ>li>div>a").click(function () {
            onClickForSel({smId: $(this).data("smid"), gljb: $(this).data("gljb")})
        })
    } else if (type == "jsbt") {
        $("#gsULJSBT").html(gsStr);
        $("#gdULJSBT").html(gdStr);
        $("#sdULJSBT").html(sdStr);
        $("#gsULJSBT>li>div>a").click(function () {
            onClickForSel({smId: $(this).data("smid"), gljb: $(this).data("gljb")})
        })
        $("#gdULJSBT>li>div>a").click(function () {
            onClickForSel({smId: $(this).data("smid"), gljb: $(this).data("gljb")})
        })
        $("#sdULJSBT>li>div>a").click(function () {
            onClickForSel({smId: $(this).data("smid"), gljb: $(this).data("gljb")})
        })
    }
}
function onClickForSel(treeNode) {
    layerZJRoadH.removeAllFeatures();
    contralLayerShow("all");
    //layerZJRoadH.removeAllFeatures();// 去除高亮
    //layerZJRoadH.setVisibility(true);
    // removeVectorLayer()
    // deactiveAll();// 注销点控件

    // 判断海德中是否有数据添加条件 && treeNode.uniqueid != '0' && treeNode.uniqueid != ""
    if (treeNode.gljb != undefined) {
        if (treeNode.uniqueid != "0") {
            // app.checkall(treeNode.uniqueid);
        } else {
            // layer.msg("没有该项目信息");
            console.log("没有该项目信息")
        }

        var featureTmpR,featureTmpY,featureTmpG;
        featureTmpR = layerZJRoadR.getFeaturesByAttribute("SmID",treeNode.smId.toString());
        featureTmpY = layerZJRoadY.getFeaturesByAttribute("SmID",treeNode.smId.toString());
        featureTmpG = layerZJRoadG.getFeaturesByAttribute("SmID",treeNode.smId.toString());


        var featureTmpT;
        if(featureTmpR.length>0){
            featureTmpR.forEach(function(value,index,array){
                //code something
                if(value.attributes.GLJB == treeNode.gljb){
                    featureTmpT = value.clone();
                }
            });
        }
        if(featureTmpY.length>0){
            featureTmpY.forEach(function(value,index,array){
                //code something
                if(value.attributes.GLJB == treeNode.gljb){
                    featureTmpT = value.clone();
                }
            });
        }
        if(featureTmpG.length>0){
            featureTmpG.forEach(function(value,index,array){
                //code something
                if(value.attributes.GLJB == treeNode.gljb){
                    featureTmpT = value.clone();
                }
            });
        }

        if(featureTmpT.attributes.JIEJIAN=="red"){
            featureTmpT.style = styleRedH;
        }else if(featureTmpT.attributes.JIEJIAN=="yellow"){
            featureTmpT.style = styleYelH;
        }else if(featureTmpT.attributes.JIEJIAN=="green"){
            featureTmpT.style = styleGreH;
        }
        //添加高亮
        layerZJRoadH.drawFeature(featureTmpT);
        //定位范围
        map.zoomToExtent(featureTmpT.geometry.getBounds());
        //弹窗显示
        showPopup(featureTmpT);
    }


}
/*function onClick(treeNode) {
    removeZttMapAllFeatures();
    layerZJRoadH.removeAllFeatures();// 去除高亮
    layerZJRoadH.setVisibility(true)
    lineLayer.setVisibility(false)
    // removeVectorLayer()
    // deactiveAll();// 注销点控件

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
            queryParams: [queryParam],
            queryOption: "ATTRIBUTEANDGEOMETRY"
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
                        layerZJRoadH.addFeatures(feature);

                        map.zoomToExtent(feature.geometry.getBounds())

                        // 显示项目信息
// if ($("#projectInfoBt").prop("checked")) {
// $("#projectInfoAreaId").css("display", "block")
// }
                        // 显示影像核查信息
// if ($("#yxhcInfoBt").prop("checked")) {
// $("#yxhcInfoArea").css("display", "block")
// }


                        showPopup(feature);

                    },
                    "processFailed": processFailed
                }
            });
        queryBySQLService.processAsync(queryBySQLParams);
    } else {
        // layer.msg("系统中没有该项目信息！")
    }
}*/



var size = new SuperMap.Size(21,25);
var offset = new SuperMap.Pixel(-(size.w/2), -size.h);
var icon = new SuperMap.Icon('images/markerbig_select.png', size, offset);

var infowin = null;
// 定义mouseClickHandler函数，触发click事件会调用此函数
function showPopup(obj){
    closeInfoWin();
    var len = obj.geometry.components.length;
    var midLen = parseInt(len/2);
    var pointObj = obj.geometry.components[midLen];
    // console.log("点数："+len);
    var lat=null,lon = null;
    // 获取弹框经纬坐标
    if(pointObj.x){
	lat=pointObj.x;
	lon=pointObj.y;
    }else{
	lat=pointObj.components[0].x;
	lon=pointObj.components[0].y;
    }
    var contentHTML = "<div style='font-size:12px;font-weight:bold ;min-width: 100px;'><ul>";
    contentHTML += "<li>级别 : "+obj.data.SSJB+"</li>";
    contentHTML += "<li>类别 : "+GLJBToWord(obj.data.GLJB)+"</li>";
    contentHTML += "<li>名称 : "+obj.data.XMMC+"</li>";
    contentHTML += "<li>距离 : 约 "+parseInt(obj.data.SmLength/1000)+" 公里"+"</li>";
    contentHTML += "<li>状态 : "+"</li>";
    contentHTML += "</ul></div>"; 
    // 初始化popup类
    var popup = new SuperMap.Popup(
        "chicken",
         new SuperMap.LonLat(lat,lon),
	 // new SuperMap.LonLat(pointObj.x,pointObj.y),
        new SuperMap.Size(150,50),
        contentHTML,
        true,
        null
    );
 // 根据弹窗内容自动调整弹窗大小
    popup.autoSize = true;
  // 设置弹窗的边框样式
    popup.setBorder("solid 2px #6CA6CD");
    // 允许弹出内容的最小尺寸
    popup.maxSize = 200; 
 // 是否移动地图以确保弹窗显示在窗口内
    popup.panMapIfOutOfView = true;
    // 设置弹出框的透明度.
    popup.setOpacity(0.7);
    
    infowin = popup;
    // 添加弹窗到map图层
    map.addPopup(popup);
}

function closeInfoWin(){
    if(infowin){
        try{
    	    infowin.hide();
    	    infowin.destroy();
        }
        catch(e){}
    }
}
function GLJBToWord(obj){
    if(obj=="GS"){
	return "高速";
    }else if(obj=="GD"){
	return "国道";
    }else if(obj=="SD"){
	return "省道";
    }else{
	return obj;
    }
}
function contralLayerShow(obj){
    if(obj=="red"){
        layerZJRoadR.setVisibility(true);
        layerZJRoadY.setVisibility(false);
        layerZJRoadG.setVisibility(false);
    }else if(obj=="yellow"){
        layerZJRoadR.setVisibility(false);
        layerZJRoadY.setVisibility(true);
        layerZJRoadG.setVisibility(false);
    }else if(obj=="green"){
        layerZJRoadR.setVisibility(false);
        layerZJRoadY.setVisibility(false);
        layerZJRoadG.setVisibility(true);
    }else{
        layerZJRoadR.setVisibility(true);
        layerZJRoadY.setVisibility(true);
        layerZJRoadG.setVisibility(true);
    }
}
function removeZttMapAllFeatures() {
    layerZJRoadH.removeAllFeatures();
    layerZJRoadR.removeAllFeatures();
    layerZJRoadY.removeAllFeatures();
    layerZJRoadG.removeAllFeatures();
    closeInfoWin();
    //areaLayer.removeAllFeatures();
    //layerZJRoad.setVisibility(false);
}
function removeZttDataListAll() {
    layerZJRoadH.removeAllFeatures();
    closeInfoWin();
    //areaLayer.removeAllFeatures();
    //layerZJRoad.setVisibility(false);
}