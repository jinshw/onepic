// var $ = require('jQuery');
// import Ztree from '../library/zTree-v3/js/jquery.ztree.all.min.js'

var map,
  layerT,
  layerRoad,
  layerZJRoad,
  layerYXALL,
  layer20150913,
  layer20161210,
  layerYX20162,
  layerYX201705G216,
  layerYX201705TWD,
  layerYX201706,
  layerYX201707,
  layerYX2017081,
  layerYX2017082,
  layerYX201709,
  layerChangeArea,
  layerJSJD,
  layerJSJDTWD,
  areaLayer,
  ponitLayer,
  drawPoint,
  mousePosition,
  vectorLayer,
  markers;
var host = "http://localhost:8090";
var MAPURL = {
  host: host,
  URL: host + "/iserver/services/map-xjsl_Final/rest/maps/JSGIST-GL",
  URL_DATA: host + "/iserver/services/data-xjsl_Final/rest/data",
  ROAD_URL: host + "/iserver/services/map-xjsl_Final/rest/maps/JSGIST-GS",
  ZJ_ROAD: host + "/iserver/services/map-zaijiandaoluxin/rest/maps/GLZJ",
  XJ_YX_ALL: host + "/iserver/services/map-XJ_level11/rest/maps/XJ_11",
  YX_2015: host + "/iserver/services/map-WK20171011/rest/maps/WK2015",
  YX_2016_1: host + "/iserver/services/map-TWD20171012/rest/maps/TWD2016",
  YX_2016_2: host + "/iserver/services/map-WK20171011/rest/maps/WK2016",
  YX_2017_05_G216:
    host + "/iserver/services/map-G216_20171012/rest/maps/G216_201705GJ",
  YX_2017_05_TWD:
    host + "/iserver/services/map-TWD20171012/rest/maps/TWD201705",
  YX_2017_06:
    host + "/iserver/services/map-G216_20171012/rest/maps/G216_201706GF2",
  YX_2017_07:
    host + "/iserver/services/map-G575_20171010/rest/maps/G575_201707",
  YX_2017_08_1: host + "/iserver/services/map-TWD20171012/rest/maps/TWD201708",
  YX_2017_08_2:
    host + "/iserver/services/map-G575_20171010/rest/maps/G575_201708",
  YX_2017_09:
    host + "/iserver/services/map-G575_20171010/rest/maps/G575_201709",
  JSJD_URL: host + "/iserver/services/map-jsjd/rest/maps/T500@jsjd",
  JSJD_URL_TWD:
    host + "/iserver/services/map-jsjdwukui/rest/maps/T500m@jsjdwukui",
  CHANGE_AREA_MAP:
    host + "/iserver/services/map-G575ChangeArea/rest/maps/G575ChangeArea",
  CHANGE_AREA_DATA: host + "/iserver/services/data-G575ChangeArea/rest/data",
  GF2016_WUYU_URL:
    host + "/iserver/services/map-G575_20171010/rest/maps/G575_201707",
  GJ2017_WUYU_URL:
    host + "/iserver/services/map-G575_20171010/rest/maps/G575_201707",
  YX_SL_2017: host + "/iserver/services/map-G575_20171010/rest/maps/G575_201707"
};

// marker 模板数据
var _markerTepl =
  '<div class="popup" style="color: #FFFFFF;font-size: 14px;">  ' +
  "   <section> " +
  "       公路名：##name##" +
  "   </section>" +
  "   <section> " +
  "       全长：##mileage##公里" +
  "   </section> " +
  "   <section>" +
  "       开工时间：##startTime##" +
  "   </section>" +
  "   <section>" +
  "       竣工时间：##endTime##" +
  "   </section>" +
  "   <section>" +
  "       简介：##jianjie##" +
  "   </section>" +
  "   <section>" +
  "</div>";

/**
     * [获取提示内容]
     * @param  {[type]} obj [properties属性]
     * @return {[type]}     [string]
     */
function getPopupMsg(obj) {
  var _tempTepl = _markerTepl;
  _tempTepl = _tempTepl
    .replace("##name##", obj.XMMC)
    .replace("##mileage##", "70")
    .replace("##startTime##", "2017-5")
    .replace("##endTime##", "2019-10")
    .replace("##jianjie##", "G575巴里坤-哈密段")
    .replace("##actual##", obj.mileage);

  // _tempTepl = _tempTepl.replace("##name##", obj.XMMC)
  //     .replace("##mileage##", parseInt(obj.length))
  //     .replace("##startTime##", obj.begin_User)
  //     .replace("##endTime##", obj.end_User)
  //     .replace("##jianjie##", obj.jianjie)
  //     .replace("##actual##", obj.mileage)

  return _tempTepl;
}

var style = {
  strokeColor: "red",
  strokeWidth: 5,
  fillOpacity: "1"
};

function initMap(centerObj) {
  document.getElementById("map").style.height =
    document.documentElement.clientHeight - 50 + "px";

  ponitLayer = new SuperMap.Layer.Vector("ponitLayer");
  drawPoint = new SuperMap.Control.DrawFeature(
    ponitLayer,
    SuperMap.Handler.Point
  );
  drawPoint.events.on({
    featureadded: drawCompleted
  });

  map = new SuperMap.Map("map", {
    minZoom: 0,
    maxZoom: 11,
    allOverlays: true,
    controls: [
      new SuperMap.Control.Navigation(),
      new SuperMap.Control.Zoom(),
      new SuperMap.Control.LayerSwitcher(),
      drawPoint
    ]
  });

  //初始化图层
  layerT = new SuperMap.Layer.TiledDynamicRESTLayer("ditu", MAPURL.URL, {
    transparent: true,
    cacheEnabled: true
  });

  layerRoad = new SuperMap.Layer.TiledDynamicRESTLayer(
    "road",
    MAPURL.ROAD_URL,
    {
      transparent: true,
      cacheEnabled: true
    }
  );
  layerZJRoad = new SuperMap.Layer.TiledDynamicRESTLayer(
    "zjroad",
    MAPURL.ZJ_ROAD,
    {
      transparent: true,
      cacheEnabled: true
    }
  );
  layerYXALL = new SuperMap.Layer.TiledDynamicRESTLayer(
    "yxall",
    MAPURL.XJ_YX_ALL,
    {
      transparent: true,
      cacheEnabled: true
    }
  );
  layer20150913 = new SuperMap.Layer.TiledDynamicRESTLayer(
    "2015年影像",
    MAPURL.YX_2015,
    {
      transparent: true,
      cacheEnabled: true
    }
  );
  layer20161210 = new SuperMap.Layer.TiledDynamicRESTLayer(
    "2016年影像_1",
    MAPURL.YX_2016_1,
    {
      transparent: true,
      cacheEnabled: true
    }
  );
  layerYX20162 = new SuperMap.Layer.TiledDynamicRESTLayer(
    "2016年影像_2",
    MAPURL.YX_2016_2,
    {
      transparent: true,
      cacheEnabled: true
    }
  );
  layerYX201705G216 = new SuperMap.Layer.TiledDynamicRESTLayer(
    "201705G216影像",
    MAPURL.YX_2017_05_G216,
    {
      transparent: true,
      cacheEnabled: true
    }
  );
  layerYX201705TWD = new SuperMap.Layer.TiledDynamicRESTLayer(
    "201705TWD影像",
    MAPURL.YX_2017_05_TWD,
    {
      transparent: true,
      cacheEnabled: true
    }
  );

  layerYX201706 = new SuperMap.Layer.TiledDynamicRESTLayer(
    "201706影像",
    MAPURL.YX_2017_06,
    {
      transparent: true,
      cacheEnabled: true
    }
  );
  layerYX201707 = new SuperMap.Layer.TiledDynamicRESTLayer(
    "201707影像",
    MAPURL.YX_2017_07,
    {
      transparent: true,
      cacheEnabled: true
    }
  );
  layerYX2017081 = new SuperMap.Layer.TiledDynamicRESTLayer(
    "201708影像_1",
    MAPURL.YX_2017_08_1,
    {
      transparent: true,
      cacheEnabled: true
    }
  );
  layerYX2017082 = new SuperMap.Layer.TiledDynamicRESTLayer(
    "201708影像_2",
    MAPURL.YX_2017_08_2,
    {
      transparent: true,
      cacheEnabled: true
    }
  );
  layerYX201709 = new SuperMap.Layer.TiledDynamicRESTLayer(
    "201709影像",
    MAPURL.YX_2017_09,
    {
      transparent: true,
      cacheEnabled: true
    }
  );
  layerChangeArea = new SuperMap.Layer.TiledDynamicRESTLayer(
    "变化线路",
    MAPURL.CHANGE_AREA_MAP,
    {
      transparent: true,
      cacheEnabled: true
    }
  );
  layerJSJD = new SuperMap.Layer.TiledDynamicRESTLayer(
    "jsjd",
    MAPURL.JSJD_URL,
    {
      transparent: true,
      cacheEnabled: true
    }
  );
  layerJSJDTWD = new SuperMap.Layer.TiledDynamicRESTLayer(
    "layerJSJDTWD",
    MAPURL.JSJD_URL_TWD,
    {
      transparent: true,
      cacheEnabled: true
    }
  );

  layerJSJDTWD.events.on({
    layerInitialized: addLayer
  });

  areaLayer = new SuperMap.Layer.Vector("区域面积高亮");

  function addLayer() {
    map.addLayers([
      layerT,
      layerYXALL,
      layer20150913,
      layer20161210,
      layerYX20162,
      layerYX201705G216,
      layerYX201705TWD,
      layerYX201706,
      layerYX201707,
      layerYX2017081,
      layerYX2017082,
      layerYX201709,
      layerChangeArea,
      layerRoad,
      layerZJRoad,
      layerJSJD,
      layerJSJDTWD,
      ponitLayer,
      vectorLayer,
      markers,
      areaLayer
    ]);

    /* if (type == "2") {
            console.log(map.getCenter())
            map.setCenter(new SuperMap.LonLat(87.40448, 43.87231), 5)
        } else {
            //显示地图范围9732011.83931, 5440449.31251    85.782, 41.344
            map.setCenter(new SuperMap.LonLat(87.64226, 43.79469), 1);
        } */
    if (
      centerObj == null ||
      typeof centerObj == "undefined" ||
      typeof centerObj.lat == "undefined"
    ) {
      //显示地图范围9732011.83931, 5440449.31251    85.782, 41.344
      map.setCenter(new SuperMap.LonLat(87.64226, 43.79469), 1);
    } else {
      map.setCenter(
        new SuperMap.LonLat(centerObj.lat, centerObj.lon),
        centerObj.level
      );
    }
  }

  // 其他图层
  /* ponitLayer = new SuperMap.Layer.Vector("ponitLayer");
    drawPoint = new SuperMap.Control.DrawFeature(ponitLayer, SuperMap.Handler.Point);
    drawPoint.events.on({
        "featureadded": drawCompleted
    }); */

  mousePosition = new SuperMap.Control.MousePosition({
    id: "mousePositionId",
    autoActivate: true,
    separator: ","
  });
  map.addControl(mousePosition);
  mousePosition.activate();

  // 点控件查询
  function drawCompleted(drawGeometryArgs) {
    var feature = new SuperMap.Feature.Vector();
    (feature.geometry = drawGeometryArgs.feature.geometry),
      (feature.style = style);
    ponitLayer.addFeatures(feature);
    var getFeatureParameter, getFeatureService;
    getFeatureParameter = new SuperMap.REST.GetFeaturesByBufferParameters({
      bufferDistance: 0.0001,
      //attributeFilter: "SMID > 0",
      datasetNames: ["G575ChangeArea:变化线"],
      returnContent: true,
      geometry: drawGeometryArgs.feature.geometry
    });
    getFeatureService = new SuperMap.REST
      .GetFeaturesByBufferService(MAPURL.CHANGE_AREA_DATA, {
      eventListeners: {
        processCompleted: processCompletedPoint,
        processFailed: processFailed
      }
    });
    getFeatureService.processAsync(getFeatureParameter);
  }

  function processCompletedPoint(getFeaturesEventArgs) {
    var _feature = getFeaturesEventArgs.result.features[0];
    var _attr = _feature.attributes;
    layer.msg(_attr.NOTE);
  }

  // 选择要素
  var callbacks = {
    click: function(currentFeature) {
      console.log(currentFeature);
      var _html = getPopupMsg(currentFeature.attributes);
      layer.msg(_html);
    }
  };
  vectorLayer = new SuperMap.Layer.Vector("vectorLayer");
  var selectFeature = new SuperMap.Control.SelectFeature(vectorLayer, {
    callbacks: callbacks
  });
  map.addControl(selectFeature);
  selectFeature.activate();
  markers = new SuperMap.Layer.Markers("Markers");
}
function setLayerVisibility(obj) {
  layerT.setVisibility(obj["layerT"] || true);
  layerRoad.setVisibility(obj["layerRoad"] || true);
  layerYXALL.setVisibility(obj["layerYXALL"] || false);
  layerZJRoad.setVisibility(obj["layerZJRoad"] || true);

  layer20150913.setVisibility(obj["layer20150913"] || false);
  layer20161210.setVisibility(obj["layer20161210"] || false);

  layerYX20162.setVisibility(obj["layerYX20162"] || false);

  layerYX201705G216.setVisibility(obj["layerYX201705"] || false);
  layerYX201705TWD.setVisibility(obj["layerYX201705"] || false);
  layerYX201706.setVisibility(obj["layerYX201706"] || false);
  layerYX201707.setVisibility(obj["layerYX201707"] || false);
  layerYX2017081.setVisibility(obj["layerYX2017081"] || false);
  layerYX2017082.setVisibility(obj["layerYX2017082"] || false);

  layerYX201709.setVisibility(obj["layerYX201709"] || false);

  vectorLayer.setVisibility(obj["vectorLayer"] || false);
  layerJSJD.setVisibility(obj["layerJSJD"] || false);
  layerJSJDTWD.setVisibility(obj["layerJSJDTWD"] || false);

  ponitLayer.setVisibility(obj["ponitLayer"] || false);
  markers.setVisibility(obj["markers"] || false);
  areaLayer.setVisibility(obj["areaLayer"] || false);
  layerChangeArea.setVisibility(obj["layerChangeArea"] || false);
}
function timeLineLayer() {
  $("#timeLine").initTimeLine(
    {
      times: [
        "2015年",
        "2016年",
        "201705",
        "201706",
        "201707",
        "201708",
        "201709"
      ],
      activeIndex:6
    },
    function(item) {
      console.log($(item).text());

      var checkDate = $(item)
        .text()
        .trim();

      setLayerVisibility({
        layerYXALL: true,
        layer20150913: false,
        layer20161210: false,
        layerYX20162: false,
        layerYX201705: false,
        layerYX201706: false,
        layerYX201707: false,
        layerYX2017081: false,
        layerYX2017082: false,
        layerYX201709: false
      });

      if (checkDate == "2015年") {
        layer20150913.setVisibility(true);
      } else if (checkDate == "2016年") {
        layer20161210.setVisibility(true);
        layerYX20162.setVisibility(true);
      } else if (checkDate == "201705") {
        layerYX201705G216.setVisibility(true);
        layerYX201705TWD.setVisibility(true);
      } else if (checkDate == "201706") {
        layerYX201706.setVisibility(true);
      } else if (checkDate == "201707") {
        layerYX201707.setVisibility(true);
      } else if (checkDate == "201708") {
        layerYX2017081.setVisibility(true);
        layerYX2017082.setVisibility(true);
      } else if (checkDate == "201709") {
        layerYX201709.setVisibility(true);
      }
    }
  );
}

function initTree(mycallback) {
  var zTreeObj;

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
    vectorLayer.setVisibility(true);
    removeVectorLayer();
    deactiveAll(); //注销点控件

    var feature;
    if (treeNode.gljb != undefined) {
      var queryParam,
        queryParamGS,
        queryParamGD,
        queryParamSD,
        queryBySQLParams,
        queryBySQLService;
      if (treeNode.gljb == "GS") {
        queryParam = new SuperMap.REST.FilterParameter({
          name: "GLGS_1@xj"
        });
      } else if (treeNode.gljb == "GD") {
        queryParam = new SuperMap.REST.FilterParameter({
          //name: "一般国道@交通#2#4",
          name: "GLGD_3@xj",
          attributeFilter: "SmID = " + treeNode.smId
        });
      } else if (treeNode.gljb == "SD") {
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
          processCompleted: function(queryEventArgs) {
            console.log("-----------");
            //                        console.log(queryEventArgs)
            console.log("-----------");
            feature = queryEventArgs.result.recordsets[0].features[0];
            feature.style = style;
            vectorLayer.addFeatures(feature);
            map.zoomToExtent(feature.geometry.getBounds());

            mycallback();

            // 显示项目信息
            /* if ($("#projectInfoBt").prop("checked")) {
                            $("#projectInfoAreaId").css("display", "block")
                        }
                        // 显示影像核查信息
                        if ($("#yxhcInfoBt").prop("checked")) {
                            $("#yxhcInfoArea").css("display", "block")
                        } */
          },
          processFailed: processFailed
        }
      });
      queryBySQLService.processAsync(queryBySQLParams);
    }
  }

  vectorLayer = new SuperMap.Layer.Vector("Vector Layer");

  var treeNodes = [
    { id: 1, pId: 0, name: "厅本级项目", open: true },
    { id: 11, pId: 1, name: "高速" },
    { id: 12, pId: 1, name: "国道" },
    { id: 13, pId: 1, name: "省道" }
  ];
  var treeNodesDZ = [
    { id: 1, pId: 0, name: "地州级项目", open: true },
    { id: 11, pId: 1, name: "高速" },
    { id: 12, pId: 1, name: "国道" },
    { id: 13, pId: 1, name: "省道" }
  ];
  var treeNodesJS = [
    { id: 1, pId: 0, name: "建设兵团及项目", open: true },
    { id: 11, pId: 1, name: "高速" },
    { id: 12, pId: 1, name: "国道" },
    { id: 13, pId: 1, name: "省道" }
  ];
  $(function() {
    function autoHeight() {
      var winH = $(window).height();
      var footerH = $(".footerWrap").height();
      var headerH = $(".headerWrap").height();
      return winH - footerH - headerH;
    }

    $(".mapWrap").height(autoHeight());
    $(window).resize(function() {
      $(".mapWrap").height(autoHeight());
    });

    $(".mianNav>li").hover(
      function() {
        $(this)
          .find("ul")
          .show()
          .parent()
          .siblings()
          .find("ul")
          .hide();
      },
      function() {
        $(this)
          .find("ul")
          .hide();
      }
    );

    $(".js_drop").click(function() {
      $(this)
        .find("p")
        .toggle();
    });

    var queryParamGS,
      queryParamGD,
      queryParamSD,
      queryBySQLParams,
      queryBySQLService;
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
        processCompleted: processCompleted,
        processFailed: processFailed
      }
    });
    queryBySQLService.processAsync(queryBySQLParams);
  });

  // 查询数据集处理
  function processCompleted(queryEventArgs) {
    var gsFeatures = queryEventArgs.result.recordsets[0].features;
    var gdFeatures = queryEventArgs.result.recordsets[1].features;
    var sdFeatures = queryEventArgs.result.recordsets[2].features;

    var _obj = null;
    var _count = 0;
    for (var i = 0; i < gsFeatures.length; i++) {
      _obj = gsFeatures[i].attributes;
      if (_obj.XMMC == "G7大黄山至乌鲁木齐段改扩建工程") {
        if (_count == 0) {
          treeNodes.push({
            id: i + 2000,
            pId: 11,
            name: _obj.XMMC,
            smId: _obj.SmID,
            gljb: _obj.GLJB,
            arrIndex: i
          });
        }
        _count = _count + 1;
      } else {
        treeNodes.push({
          id: i + 2000,
          pId: 11,
          name: _obj.XMMC,
          smId: _obj.SmID,
          gljb: _obj.GLJB,
          arrIndex: i
        });
      }
    }
    for (var i = 0; i < gdFeatures.length; i++) {
      _obj = gdFeatures[i].attributes;
      treeNodes.push({
        id: i + 3000,
        pId: 12,
        name: _obj.XMMC,
        smId: _obj.SmID,
        gljb: _obj.GLJB,
        arrIndex: i
      });
    }
    for (var i = 0; i < sdFeatures.length; i++) {
      _obj = sdFeatures[i].attributes;
      treeNodes.push({
        id: i + 4000,
        pId: 13,
        name: _obj.XMMC,
        smId: _obj.SmID,
        gljb: _obj.GLJB,
        arrIndex: i
      });
    }
    zTreeObj = $.fn.zTree.init($("#treeDemo"), setting, treeNodes);
    $.fn.zTree.init($("#treeDemoDZ"), setting, treeNodesDZ);
    $.fn.zTree.init($("#treeDemoJS"), setting, treeNodesJS);
  }

  function removeVectorLayer() {
    vectorLayer.removeAllFeatures(); // 去除高亮
  }
}

function processFailed(e) {
  console.log(e);
  alert(e.error.errorMsg);
}

function drawPointLayer() {
  drawPoint.activate();
}

// 注销点控件
function deactiveAll() {
  drawPoint.deactivate();
}

/**
 * 添加标注
 */
var pointx = null,
  pointy = null,
  size,
  offset,
  icon;
function addMarker(px, py) {
  size = new SuperMap.Size(21, 25);
  offset = new SuperMap.Pixel(-(size.w / 2), -size.h);
  icon = new SuperMap.Icon("./dist/static/images/marker.gif", size, offset);
  //初始化标记覆盖物类
  marker = new SuperMap.Marker(new SuperMap.LonLat(px, py), icon);
  //添加覆盖物到标记图层
  markers.addMarker(marker);
  //注册 click 事件,触发 mouseClickHandler()方法
  marker.events.on({
    click: function(event) {
      pointx = event.object.lonlat.lon;
      pointy = event.object.lonlat.lat;
      $(".drawplot-content").css("display", "block");
      $("#plotContent").val("");
      ajaxRequest
        .findPlot({ pointx: pointx, pointy: pointy })
        .then(function(data) {
          if (data.status == 200 && data.list.length > 0) {
            $("#plotContent").val(data.list[0].content);
          }
        });
    }
  });
}
// 标注内容保存
function plotSaveBt() {
  var keycode = "plotcontent";
  var content = $("#plotContent").val();
  if (content.trim() == "") {
    layer.msg("请填写标注的内容");
    return;
  }
  console.log(pointx, pointy);
  // 保存到数据库中
  ajaxRequest
    .insertPlot({
      pointx: pointx,
      pointy: pointy,
      content: content,
      keycode: keycode
    })
    .then(function(data) {
      console.log(data);
      if (data.status == 200) {
        layer.msg("保存成功");
      }
    });
}
// 标注内容取消
function plotCancelBt() {
  px = null;
  py = null;
  $(".drawplot-content").css("display", "none");
  $("#plotContent").val("");
}
function removePlotById() {
  //获取选中的对象
  if (pointx == null || pointy == null) {
    layer.msg("请选择一个标号");
    return;
  }

  layer.confirm(
    "您确定要删除(不可恢复)该标注吗？ ",
    {
      btn: ["确定", "取消"] //按钮
    },
    function() {
      ajaxRequest
        .deletePlot({ pointx: pointx, pointy: pointy })
        .then(function(data) {
          markers.removeMarker(marker);
          if (data.rint == 0) {
            layer.msg("删除失败");
            return;
          }

          layer.msg("删除成功");
          $("#plotContent").val("");
          $(".drawplot-content").css("display", "none");
        });
    },
    function() {}
  );
}
function initDatas() {
  var keycode = "plotcontent";
  ajaxRequest.findPlot({}).then(function(data) {
    console.log(data);
    if (data.status == 200) {
      var list = data.list;
      for (var i = 0; i < list.length; i++) {
        let polygonPs = new Array();
        console.log(list[i].pointx, list[i].pointy);
        addMarker(list[i].pointx, list[i].pointy);
      }
    }
  });
}
function mapLayerClick(obj, ele) {
  var pxystr = mousePosition.div.textContent;
  var pxys = pxystr.split(",");
  if (pxys.length == 2) {
    addMarker(pxys[0], pxys[1]);
  } else {
    alert("获取坐标点失败");
  }
}
// 隐藏标注笔记按钮
function noteDisabled() {
  $("#isShowMarker").attr("disabled", true);
  $("#isShowMarker").attr("disabled", true);
  $("#delMarkerBT").attr("disabled", true);
  $("#saveMarkerBT").attr("disabled", true);
  $("#cancelMarkerBT").attr("disabled", false);
  $("#plotContent").attr("disabled", true);
  map.events.unregister("click", layer, mapLayerClick);
}
//== 添加标注

// 查询影像信息
function queryYXInfo(SmID) {
  // 查询影像面数据
  var queryParam,
    queryParamGS,
    queryParamGD,
    queryParamSD,
    queryBySQLParams,
    queryBySQLService;
  var queryParam1,
    queryParam2,
    queryParam3,
    queryParam4,
    queryParam5,
    queryParam6,
    queryParam7,
    queryParam8,
    queryParam9,
    queryParam10,
    queryParam11,
    queryParam12,
    queryParam13,
    queryParam14,
    queryParam15,
    queryParam16,
    queryParam17,
    queryParam18,
    queryParam19,
    queryParam20,
    queryParam21,
    queryParam22;
  /*queryParam1 = new SuperMap.REST.FilterParameter({
        name: "Export_Output@yxsx2017"
    });
    queryParam2 = new SuperMap.REST.FilterParameter({
        name: "Export_Output_19@yxsx2017"
    });
    queryParam3 = new SuperMap.REST.FilterParameter({
        name: "Export_Output_22@yxsx2017"
    });
    queryParam4 = new SuperMap.REST.FilterParameter({
        name: "Export_Output_5@yxsx2017"
    });
    queryParam5 = new SuperMap.REST.FilterParameter({
        name: "Export_Output_3@yxsx2017"
    });
    queryParam6 = new SuperMap.REST.FilterParameter({
        name: "Export_Output_7@yxsx2017"
    });
    queryParam7 = new SuperMap.REST.FilterParameter({
        name: "Export_Output_9@yxsx2017"
    });
    queryParam8 = new SuperMap.REST.FilterParameter({
        name: "Export_Output_11@yxsx2017"
    });
    queryParam9 = new SuperMap.REST.FilterParameter({
        name: "Export_Output_10@yxsx2017"
    });
    queryParam10 = new SuperMap.REST.FilterParameter({
        name: "Export_Output_13@yxsx2017"
    });
    queryParam11 = new SuperMap.REST.FilterParameter({
        name: "Export_Output_12@yxsx2017"
    });
    queryParam12 = new SuperMap.REST.FilterParameter({
        name: "Export_Output_14@yxsx2017"
    });
    queryParam13 = new SuperMap.REST.FilterParameter({
        name: "Export_Output_8@yxsx2017"
    });
    queryParam14 = new SuperMap.REST.FilterParameter({
        name: "Export_Output_6@yxsx2017"
    });
    queryParam15 = new SuperMap.REST.FilterParameter({
        name: "Export_Output_16@yxsx2017"
    });
    queryParam16 = new SuperMap.REST.FilterParameter({
        name: "Export_Output_2@yxsx2017"
    });
    queryParam17 = new SuperMap.REST.FilterParameter({
        name: "Export_Output_4@yxsx2017"
    });
    queryParam18 = new SuperMap.REST.FilterParameter({
        name: "Export_Output_15@yxsx2017"
    });
    queryParam19 = new SuperMap.REST.FilterParameter({
        name: "Export_Output_18@yxsx2017"
    });
    queryParam20 = new SuperMap.REST.FilterParameter({
        name: "Export_Output_17@yxsx2017"
    });
    queryParam21 = new SuperMap.REST.FilterParameter({
        name: "Export_Output_21@yxsx2017"
    });
    queryParam22 = new SuperMap.REST.FilterParameter({
        name: "Export_Output_20@yxsx2017"
    });*/
  console.log("smid==" + SmID);
  queryParam = new SuperMap.REST.FilterParameter({
    name: "qujingjieRL@xj",
    attributeFilter: "SmID = " + SmID
  });

  queryBySQLParams = new SuperMap.REST.QueryBySQLParameters({
    queryParams: [queryParam]
  });
  /*queryBySQLParams = new SuperMap.REST.QueryBySQLParameters({
        queryParams: [
            queryParam1, queryParam2, queryParam3, queryParam4, queryParam5,
            queryParam6, queryParam7, queryParam8, queryParam9, queryParam10,
            queryParam11, queryParam12, queryParam13, queryParam14, queryParam15,
            queryParam16, queryParam17, queryParam18, queryParam19, queryParam20, queryParam21, queryParam22
        ]
    });*/

  areaLayer.removeAllFeatures();
  queryBySQLService = new SuperMap.REST.QueryBySQLService(MAPURL.URL, {
    eventListeners: {
      processCompleted: function(queryEventArgs) {
        console.log(queryEventArgs);
        var i,
          j,
          feature,
          result = queryEventArgs.result;
        if (result && result.recordsets) {
          for (i = 0; i < result.recordsets.length; i++) {
            if (result.recordsets[i].features) {
              for (j = 0; j < result.recordsets[i].features.length; j++) {
                feature = result.recordsets[i].features[j];
                feature.style = {
                  strokeColor: "#304DBE",
                  strokeWidth: 1,
                  fillColor: "#304DBE",
                  fillOpacity: "0.8"
                };
                areaLayer.addFeatures(feature);
                map.zoomToExtent(feature.geometry.getBounds());
              }
            }
          }
        }

        /*var _recordsets = queryEventArgs.result.recordsets
                var _feature;
                for (var i = 0; i < _recordsets.length; i++) {
                    _feature = _recordsets[i].features[0]
                    _feature.style = {
                        strokeColor: "#304DBE",
                        strokeWidth: 1,
                        strokeOpacity: "0",
                        fillColor: "#304DBE",
                        fillOpacity: "0"

                    }
                }*/
      },
      processFailed: processFailed
    }
  });
  queryBySQLService.processAsync(queryBySQLParams);
}
