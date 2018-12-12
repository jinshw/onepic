//页面js控制
$(function () {
    //创建缓存数据库
    createIndexDB("dbs", 1, function () {
        var searchType = $("input[name='searchType']").val();
        //changeSearchType(searchType);
    });

    $(".map-type-card").click(function () {
        var _type = $(this).data("name");
        $(".map-type-card").removeClass("active");
        $(this).addClass("active");

        if (_type == 'earth') {
            layerYXALL.setVisibility(true)
            layerT.setVisibility(false)
        } else {
            layerYXALL.setVisibility(false)
            layerT.setVisibility(true)
        }
    });

    $("#ztListId").click(function () {
        $(".tools-items").removeClass("active");
        $(this).addClass("active");
        var _img = $("#ztListId").children(".right-img");
        var _type = $(_img).data("type");
        if (_type == "xiala") {
            $(_img).attr("src", "../img/sanjiao_shouqi.png")
            $(_img).data("type", "shouqi")
        } else {
            $(_img).attr("src", "../img/sanjiao_xiala.png")
            $(_img).data("type", "xiala")
        }
        $(".tools-child-list.tools-child-yxss").toggle();
    });

    $("#zttId").click(function () {
        $(".tools-items").removeClass("active");
        $(this).addClass("active");
        var _img = $("#zttId").children(".right-img");
        var _type = $(_img).data("type");
        if (_type == "xiala") {
            $(_img).attr("src", "../img/sanjiao_shouqi.png")
            $(_img).data("type", "shouqi")
        } else {
            $(_img).attr("src", "../img/sanjiao_xiala.png")
            $(_img).data("type", "xiala")
        }
        $(".tools-child-list.tools-child-ztt").toggle();
    });

    // 搜索事件
    $("#search-button").click(function () {

        var content = $("#sole-input").val()
        if ($.trim(content) == "") {
            layer.msg("请输入查询内容！");
            return false;
        }
        var tempName = $(".tools-container .active").data("name");
        if (tempName == "zjgc") {
            zjgcSearch();
        } else if (tempName == "sslk") {

        } else {// 底图搜索
            dituSearch();
        }


    });

    $("#sole-input").focus(function () {
        console.log("1234....")
        var len = $(".tools-container .active").length;
        if (len == 0) {//底图查询
            $("#dituList").css("display", "block");
        } else {
            var name = $(".tools-container .active").data("name");
            if (name == "zjgc") {
                $("#zjgcList").css("display", "block")
            }
        }
    })

    // 清除搜索内容
    $("#clearContent").click(function () {
        //alert(1);
        removeZttDataListAll();
        $("#sole-input").val("");
        queryRoad();
        // $("#zjgcList").hide();
        // $("#dituList").hide();

        // 专题图
        //var len = $(".tools-container .active").length;
        /*if(len == 0){
            $("#dituList").css("display","none");
        }*/
        // $("#dituList").css("display", "none");
        // $("#zjgcList").css("display", "none");

    });

    $(".tools-container .tools-items").click(function () {
        setLayerVisibilityALL({layerZJRoad:true,layerT:true});
        var name = $(this).data("name");
        var tempName = $(".tools-container .active").data("name");

        $(".tools-container .tools-items").removeClass("active");
        $(".tools-container .tools-child-item").removeClass("active");
        removeMapAllFeatures();
        if (name == tempName) {// active 为当前按钮
            displayDiTu("block");
            displayZJGC("none");
        } else {// active 不是当前按钮
            $(this).addClass("active");
            if (name == "zjgc") {
                layerZJRoad.setVisibility(true);
                displayDiTu("none");
                displayZJGC("block");
            } else if (name == "sslk") {

            }
        }
    });

    $(".tools-child-yxss .tools-child-item").click(function () {
        var name = $(this).data("name");
        var tempName = $(".tools-container .active").data("name");

        if (name == tempName) {// active 为当前按钮
            displayDiTu("block");
            displayZJGC("none");
            $(".tools-container .tools-items").removeClass("active");
            $(".tools-container .tools-child-item").removeClass("active");
        } else {// active 不是当前按钮
            $(this).addClass("active");
            if (name == "zjgc") {
                displayDiTu("none");
                displayZJGC("block");
            } else if (name == "sslk") {

            }
        }
    });

    // 交通专题图点击事件
    $(".tools-child-item input").click(function () {
        changeCheckbox()
    });

    // 专题图点击事件
    $(".tools-child-ztt .tools-child-item").click(function () {
        var name = $(this).data("name");
        console.log(name);
        // 隐藏所有地图
        setLayerVisibilityALL({});
        $("#clearContent").trigger("click");
        if (name == "blue") {
            setLayerVisibilityZTT({"layerZTTBLUE": true});
        } else if (name == "green") {
            setLayerVisibilityZTT({"layerZTTGREEN": true});
        } else if (name == "gray") {
            setLayerVisibilityZTT({"layerZTTGRAY": true});
        } else if (name == "baidu") {
            setLayerVisibilityZTT({"layerZTTBAIDU": true});
        }

    });


    // 初始化
    //initBaseMap();

    // 选择切换
    $("input[name='searchType']").click(function () {
        var searchType = $(this).val();
        changeSearchType(searchType)
    });

    $('.city-page').pagination({
        totalData: 101,
        showData: 10,
        mode: 'fixed',
        callback: function (api) {
            console.log(api, api.getPageCount(), api.getCurrent())
            var current = api.getCurrent();
            var pageCount = api.getPageCount();
            // showPageContent(current);

        }
    });


    $('.box').on('click','.item',function (ev) {
        $(this).addClass('cur').siblings().removeClass('cur');
    });

    function yearItem(){
        var yearItem = '';

        for(var i=2000; i<=2018; i++){
            yearItem += '<div class="item" data-toggle="tooltip" data-placement="top" onclick="javascript:queryRoadByDsAll();" title="<p><span>计划投资:</span><strong>2000万元</strong></p><p><span>实际投资:</span><strong>2100万元</strong></p>"><span href="#" >'+ i +'</span></div>'
        };

        $('.yearBox').append($(yearItem));
    }
    yearItem();
    function monthItem(){
        var monthItem = '';

        for(var i=1; i<=12; i++){
            monthItem += '<div class="item" data-toggle="tooltip" data-placement="top" onclick="javascript:queryRoadByDsAll();" title="<p><span>计划投资:</span><strong>2000万元</strong></p><p><span>实际投资:</span><strong>2100万元</strong></p>"><span href="#" >'+ i +'</span></div>'
        };

        $('.monthBox').append($(monthItem));
    }
    monthItem();

    $('.selectYearMonth').change(function(){
        var val = $(this).find('option:selected').val();
        if(val == '0'){
            $('.yearBox').show();
            $('.monthBox').hide();
        }else {
            $('.yearBox').hide();
            $('.monthBox').show();
        }
    });
    $('[data-toggle="tooltip"]').tooltip({html : true });

});

function initBaseMap() {
    // 在建工程图层隐藏
    layerZJRoad.setVisibility(false);
}

function changeCheckbox() {
    var checkedAttrs = $("input[name='jtztType']:checked");
    var obj = {}, val = "";
    for (var i = 0; i < checkedAttrs.length; i++) {
        val = $(checkedAttrs[i]).val();
        if (val == "sfz") {
            obj.layerSFZ = true;
        } else if (val == "fwq") {
            obj.layerFWQ = true;
        } else if (val == "jyz") {
            obj.layerJYZ = true;
        } else if (val == "tcq") {
            obj.layerTCQ = true;
        } else if (val == "bridge") {
            obj.layerBRIDGE = true;
        }
    }
    setLayerVisibilityJTZT(obj);

}

function displayDiTu(display) {
    $("#dituList").css("display", display);
}

function displayZJGC(display) {
    $("#zjgcList").css("display", display);
}

// 底图查询
function dituSearch() {
    var searchType = $("input[name='searchType']:checked").val();
    console.log("searchType==", searchType)
    // 底图查询:
    if (searchType == "place") {//地名
        searchCity();
        searchCounty();
        searchTown();
        searchVillage();
    } else if (searchType == "road") {
        searchGS();
        searchGD();
        searchSD();
    } else if (searchType == "bridge") {
        searchBigBridge();
    } else if (searchType == "accessory") {
        searchService();
        searchGasStation();
        searchTollStation();
    }
}

function zjgcSearch() {
    var projectType = $("input[name='projectType']:checked").val();
    console.log("projectType==", projectType)
    queryRoad();
    /*if (projectType == "tbj") {//厅本级
    } else if (projectType == "dzj") {//地州级
    } else if (projectType == "jsbt") {//生产建设兵团
    }*/
}

function changeSearchType(searchType) {
    console.log(searchType);
    displaySearchContext(searchType);
}

function displaySearchContext(type) {
    removeMapAllFeatures();
    if (type == 'place') {
        $("#placeContainer").css("display", "block");
        $("#roadContainer").css("display", "none");
        $("#bridgeContainer").css("display", "none");
        $("#accessoryContainer").css("display", "none");
        searchPlace();
    } else if (type == 'road') {
        $("#placeContainer").css("display", "none");
        $("#roadContainer").css("display", "block");
        $("#bridgeContainer").css("display", "none");
        $("#accessoryContainer").css("display", "none");
        searchRoad();
    } else if (type == 'bridge') {
        $("#placeContainer").css("display", "none");
        $("#roadContainer").css("display", "none");
        $("#bridgeContainer").css("display", "block");
        $("#accessoryContainer").css("display", "none");
        searchBridge();
    } else if (type == 'accessory') {
        $("#placeContainer").css("display", "none");
        $("#roadContainer").css("display", "none");
        $("#bridgeContainer").css("display", "none");
        $("#accessoryContainer").css("display", "block");
        searchAccessory();
    }
}

// 地名查询
function searchPlace() {
    removeMapAllFeatures();
    searchCity();//由于需要查询连个数据集，现不从缓存中查询
    // searchCounty();
    // searchTown();
    // searchVillage();
    // queryIndexdDB("city");
    queryIndexdDB("county");
    queryIndexdDB("town");
    queryIndexdDB("village");

}

// 省市名查询
function searchCity(content) {
    content = $("#sole-input").val();
    content = $.trim(content);
    if (content == undefined) {
        content = ""
    }

    var queryParamProvince, queryParamCity, queryBySQLParams, queryBySQLService;
    /* queryParamProvince = new SuperMap.REST.FilterParameter({
         name: "A_省名@xinjiang20141202#2",
         attributeFilter: "Name LIKE '%" + content + "%'"
     });*/
    queryParamCity = new SuperMap.REST.FilterParameter({
        name: "地级市_1@xinjiang20141202",
        attributeFilter: "Name_1 LIKE '%" + content + "%'"
    });
    queryBySQLParams = new SuperMap.REST.QueryBySQLParameters({
        queryParams: [queryParamCity]
    });
    queryBySQLService = new SuperMap.REST.QueryBySQLService(MAPURL.URL, {
        eventListeners: {
            "processCompleted": function (queryEventArgs) {
                console.log("1231456...........")
                console.log(queryEventArgs)
                var strs = "";
                var recordsets = queryEventArgs.result.recordsets;
                let features = recordsets[0].features;
                for (var i = 0; i < features.length; i++) {
                    _obj = features[i].attributes;
                    if (strs.indexOf(_obj.Name_1) == -1) {
                        strs = strs + `<li><div class="text-item"><a href="javascript:void(0);" data-smid="${_obj.SmID}">${_obj.Name_1}</a></div></li>`;
                    }
                }
                $("#cityUL").html(strs);

                // featuresTemp = featuresTemp.concat(features);
                $("#cityUL>li>div>a").click(function () {
                    cityULClick({smid: $(this).data("smid")});
                })

                /*var attrs = $("#cityUL>li>div>a");
                for (var i = 0; i < attrs.length; i++) {
                    $(attrs[i]).click(function () {
                        var _index = $(this).data("index");
                        _feature = featuresTemp[_index];
                        var _attribute = _feature.attributes;
                        var x = _attribute.SMX;
                        var y = _attribute.SMY;
                        console.log("x=" + x, "y=" + y)
                        map.setCenter(new SuperMap.LonLat(x, y), 10);
                    });
                }*/
                // }

            },
            "processFailed": processFailed
        }
    });
    queryBySQLService.processAsync(queryBySQLParams);
}

function cityULClick(obj) {
    removeMapAllFeatures();
    var queryParam, queryBySQLParams, queryBySQLService;
    queryParam = new SuperMap.REST.FilterParameter({
        name: "地级市_1@xinjiang20141202",
        attributeFilter: "SmID = " + obj.smid
    });
    queryBySQLParams = new SuperMap.REST.QueryBySQLParameters({
        queryParams: [queryParam]
    });
    queryBySQLService = new SuperMap.REST.QueryBySQLService(MAPURL.URL, {
        eventListeners: {
            "processCompleted": function (queryEventArgs) {
                var recordsets = queryEventArgs.result.recordsets;
                let features = recordsets[0].features;
                let feature;
                for (var i = 0; i < features.length; i++) {
                    feature = features[i];
                    feature.style = {
                        strokeColor: "#304DBE",
                        strokeWidth: 1,
                        fillColor: "#304DBE",
                        fillOpacity: "0"
                    };
                    areaLayer.addFeatures(feature);
                    // map.setCenter(new SuperMap.LonLat(85.92614, 41.49396), 2);
                    map.zoomToExtent(feature.geometry.getBounds())
                }
            },
            "processFailed": processFailed
        }
    });
    queryBySQLService.processAsync(queryBySQLParams);

}

// 区县名查询
function searchCounty(content) {
    content = $("#sole-input").val();
    content = $.trim(content);
    if (content == undefined) {
        content = ""
    }
    var queryParamCounty, queryBySQLParams, queryBySQLService;
    queryParamCounty = new SuperMap.REST.FilterParameter({
        name: "A_县级市@xinjiang20141202",
        attributeFilter: "Name LIKE '%" + content + "%'"
    });
    queryBySQLParams = new SuperMap.REST.QueryBySQLParameters({
        queryParams: [queryParamCounty],
        queryOption: "ATTRIBUTE"
    });
    queryBySQLService = new SuperMap.REST.QueryBySQLService(MAPURL.URL, {
        eventListeners: {
            "processCompleted": function (queryEventArgs) {
                var strs = "";
                var recordsets = queryEventArgs.result.recordsets;
                var featuresTemp = [];
                var count = 0;
                for (var rindex = 0; rindex < recordsets.length; rindex++) {
                    let features = recordsets[rindex].features;
                    // let features = queryEventArgs.result.recordsets[rindex].features;
                    for (var i = 0; i < features.length; i++) {
                        _obj = features[i].attributes;
                        strs = strs + `<li><div class="text-item"><a href="javascript:void(0);" data-smid="${_obj.SMID}" data-index="${i + count}">${_obj.Name}</a></div></li>`;
                    }
                    // $("#countyUL").html(strs);

                    featuresTemp = featuresTemp.concat(features);
                    count = count + features.length;

                    // 把数据添加到缓存中
                    addData(mydb.db, 'Maps', {id: "county", list: {val: featuresTemp, strs: strs}});
                    bindListClick(strs, featuresTemp, "county");

                    /*var attrs = $("#countyUL>li>div>a");
                    for (var i = 0; i < attrs.length; i++) {
                        var tempIndex = i;
                        $(attrs[i]).click(function () {
                            var _index = $(this).data("index");
                            _feature = featuresTemp[_index];
                            var _attribute = _feature.attributes;
                            var x = _attribute.SMX;
                            var y = _attribute.SMY;
                            console.log("x=" + x, "y=" + y)
                            map.setCenter(new SuperMap.LonLat(x, y), 11);
                        });
                    }*/
                }

            },
            "processFailed": processFailed
        }
    });
    queryBySQLService.processAsync(queryBySQLParams);
}

// 乡镇名查询
function searchTown(content) {
    content = $("#sole-input").val();
    content = $.trim(content);
    if (content == undefined) {
        content = ""
    }
    var queryParamCounty, queryBySQLParams, queryBySQLService;
    queryParamCounty = new SuperMap.REST.FilterParameter({
        name: "乡镇@xinjiang20141202",
        attributeFilter: "Name LIKE '%" + content + "%'"
    });
    queryBySQLParams = new SuperMap.REST.QueryBySQLParameters({
        queryParams: [queryParamCounty],
        queryOption: "ATTRIBUTE"
    });
    queryBySQLService = new SuperMap.REST.QueryBySQLService(MAPURL.URL, {
        eventListeners: {
            "processCompleted": function (queryEventArgs) {
                var strs = "";
                var recordsets = queryEventArgs.result.recordsets;
                var featuresTemp = [];
                var count = 0;
                for (var rindex = 0; rindex < recordsets.length; rindex++) {
                    let features = recordsets[rindex].features;
                    // let features = queryEventArgs.result.recordsets[rindex].features;
                    for (var i = 0; i < features.length; i++) {
                        _obj = features[i].attributes;
                        strs = strs + `<li><div class="text-item"><a href="javascript:void(0);" data-smid="${_obj.SMID}" data-index="${i + count}">${_obj.Name}</a></div></li>`;
                    }
                    // $("#townUL").html(strs);

                    featuresTemp = featuresTemp.concat(features);
                    count = count + features.length;

                    // 把数据添加到缓存中
                    addData(mydb.db, 'Maps', {id: "town", list: {val: featuresTemp, strs: strs}});
                    bindListClick(strs, featuresTemp, "town");

                    /* var attrs = $("#townUL>li>div>a");
                     for (var i = 0; i < attrs.length; i++) {
                         var tempIndex = i;
                         $(attrs[i]).click(function () {
                             var _index = $(this).data("index");
                             _feature = featuresTemp[_index];
                             var _attribute = _feature.attributes;
                             var x = _attribute.Display_X;
                             var y = _attribute.Display_Y;
                             console.log("x=" + x, "y=" + y)
                             map.setCenter(new SuperMap.LonLat(x, y), 11);
                         });
                     }*/
                }

            },
            "processFailed": processFailed
        }
    });
    queryBySQLService.processAsync(queryBySQLParams);
}

// 乡村名查询
function searchVillage(content) {
    content = $("#sole-input").val();
    content = $.trim(content);
    if (content == undefined) {
        content = ""
    }
    var queryParamCounty, queryBySQLParams, queryBySQLService;
    queryParamCounty = new SuperMap.REST.FilterParameter({
        name: "村@xinjiang20141202",
        attributeFilter: "Name LIKE '%" + content + "%'"
    });
    queryBySQLParams = new SuperMap.REST.QueryBySQLParameters({
        queryParams: [queryParamCounty],
        queryOption: "ATTRIBUTE"
    });
    queryBySQLService = new SuperMap.REST.QueryBySQLService(MAPURL.URL, {
        eventListeners: {
            "processCompleted": function (queryEventArgs) {
                var strs = "";
                var recordsets = queryEventArgs.result.recordsets;
                var featuresTemp = [];
                var count = 0;
                for (var rindex = 0; rindex < recordsets.length; rindex++) {
                    let features = recordsets[rindex].features;
                    // let features = queryEventArgs.result.recordsets[rindex].features;
                    for (var i = 0; i < features.length; i++) {
                        _obj = features[i].attributes;
                        strs = strs + `<li><div class="text-item"><a href="javascript:void(0);" data-smid="${_obj.SMID}" data-index="${i + count}">${_obj.Name}</a></div></li>`;
                    }
                    // $("#villageUL").html(strs);

                    featuresTemp = featuresTemp.concat(features);
                    count = count + features.length;

                    // 把数据添加到缓存中
                    addData(mydb.db, 'Maps', {id: "village", list: {val: featuresTemp, strs: strs}});
                    bindListClick(strs, featuresTemp, "village");

                    /*var attrs = $("#villageUL>li>div>a");
                    for (var i = 0; i < attrs.length; i++) {
                        var tempIndex = i;
                        $(attrs[i]).click(function () {
                            var _index = $(this).data("index");
                            _feature = featuresTemp[_index];
                            var _attribute = _feature.attributes;
                            var x = _attribute.Display_X;
                            var y = _attribute.Display_Y;
                            console.log("x=" + x, "y=" + y)
                            map.setCenter(new SuperMap.LonLat(x, y), 11);
                        });
                    }*/
                }

            },
            "processFailed": processFailed
        }
    });
    queryBySQLService.processAsync(queryBySQLParams);
}

// 道路查询
function searchRoad() {
    // searchGS();
    // searchGD();
    // searchSD();
    queryIndexdDB("GS");
    queryIndexdDB("GD");
    queryIndexdDB("SD");
}

function searchGS(content) {
    content = $("#sole-input").val();
    content = $.trim(content);
    if (content == undefined) {
        content = ""
    }
    var queryParamGS, queryBySQLParams, queryBySQLService;
    queryParamGS = new SuperMap.REST.FilterParameter({
        name: "高速公路@国省干道",
        attributeFilter: "ROADNAME LIKE '%" + content + "%' or  ROADCODE LIKE '%" + content + "%'"
    });
    queryBySQLParams = new SuperMap.REST.QueryBySQLParameters({
        queryParams: [queryParamGS]
    });
    queryBySQLService = new SuperMap.REST.QueryBySQLService(MAPURL.URL, {
        eventListeners: {
            "processCompleted": function (queryEventArgs) {
                var strs = "";
                var recordsets = queryEventArgs.result.recordsets;
                var featuresTemp = [];
                var count = 0;
                for (var rindex = 0; rindex < recordsets.length; rindex++) {
                    let features = recordsets[rindex].features;
                    // let features = queryEventArgs.result.recordsets[rindex].features;
                    for (var i = 0; i < features.length; i++) {
                        _obj = features[i].attributes;
                        var tempName = _obj.ROADCODE + "-" + _obj.ROADNAME;
                        if ($.trim(_obj.QDDM) != "" && _obj.QDDM != null) {
                            tempName = tempName + "(" + _obj.QDDM + "-" + _obj.ZDDM + ")";
                        }
                        strs = strs + `<li><div class="text-item"><a href="javascript:void(0);" data-smid="${_obj.ID}" data-index="${i + count}">${tempName}</a></div></li>`;
                    }
                    $("#gsULPlace").html(strs);

                    featuresTemp = featuresTemp.concat(features);
                    count = count + features.length;

                    // 把数据添加到缓存中
                    addData(mydb.db, 'Maps', {id: "GS", list: {strs: strs}});

                    var attrs = $("#gsULPlace>li>div>a");
                    for (var i = 0; i < attrs.length; i++) {
                        $(attrs[i]).click(function () {
                            var smid = $(this).data("smid");
                            // 调用查询图层信息，渲染图层
                            queryFeatureByIdForRender({smid: smid, type: "GS"});
                        });
                    }
                }

            },
            /*
                         "processCompleted": function (queryEventArgs) {
                             var strs = "";
                             var recordsets = queryEventArgs.result.recordsets;
                             var featuresTemp = [];
                             var count = 0;
                             for (var rindex = 0; rindex < recordsets.length; rindex++) {
                                 let features = recordsets[rindex].features;
                                 // let features = queryEventArgs.result.recordsets[rindex].features;
                                 for (var i = 0; i < features.length; i++) {
                                     _obj = features[i].attributes;
                                     var tempName = _obj.ROADCODE + _obj.ROADNAME;
                                     if ($.trim(_obj.QDDM) != "" && _obj.QDDM != null) {
                                         tempName = tempName + "(" + _obj.QDDM + "—" + _obj.ZDDM + ")";
                                     }
                                     strs = strs + `<li><div class="text-item"><a href="javascript:void(0);" data-smid="${_obj.SMID}" data-index="${i + count}">${tempName}</a></div></li>`;
                                 }
                                 $("#gsULPlace").html(strs);

                                 featuresTemp = featuresTemp.concat(features);
                                 count = count + features.length;

                                 // 把数据添加到缓存中
                                 addData(mydb.db, 'Maps', {id: "GS", list: {val: queryEventArgs.result, strs: strs}});
                                 // addData(mydb.db, 'Maps', {id: "GS", list: {val: featuresTemp, strs: strs}});
                                 // bindListClick(strs, queryEventArgs.result.recordsets[0].features, "GS");
                                 // bindListClick(strs, featuresTemp, "GS");


                                  var attrs = $("#gsULPlace>li>div>a");
                                  for (var i = 0; i < attrs.length; i++) {
                                      var tempIndex = i;
                                      $(attrs[i]).click(function () {
                                          var _index = $(this).data("index");
                                          _feature = featuresTemp[_index];
                                          _feature.style = style;
                                          vectorLayer.addFeatures(_feature);
                                          map.zoomToExtent(_feature.geometry.getBounds())
                                      });
                                  }
                             }

                         },
            */

            /* "processCompleted": function (queryEventArgs) {
                 var thisVectorLayer = vectorLayer



                 getDataByKey(mydb.db, 'Maps', "GS", function (d) {
                     // var featuresTemp = d.list.val;  queryEventArgs.result
                     var featuresTemp2 = d.list.val.recordsets[0].features;
                     var featuresTemp = queryEventArgs.result.recordsets[0].features

                     // 把数据添加到缓存中
                     // addData(mydb.db, 'Maps', {id: "GS", list: {val: queryEventArgs, strs: d.list.strs}});

                     $("#gsULPlace").html(d.list.strs);
                     var attrs = $("#gsULPlace>li>div>a");
                     for (var i = 0; i < attrs.length; i++) {
                         var tempIndex = i;
                         $(attrs[i]).click(function () {
                             var _index = $(this).data("index");
                             _featureTemp = featuresTemp2[_index];
                             // _feature.style = style;
                             _feature = new SuperMap.Feature.Vector(_featureTemp.geometry,null,style)
                             thisVectorLayer.addFeatures(_feature);
                             map.zoomToExtent(_feature.geometry.getBounds())
                         });
                     }
                 })
             },*/
            "processFailed": processFailed
        }
    });
    queryBySQLService.processAsync(queryBySQLParams);
}

function searchGD(content) {
    content = $("#sole-input").val();
    content = $.trim(content);
    if (content == undefined) {
        content = ""
    }
    var queryParamGD, queryBySQLParams, queryBySQLService;
    queryParamGD = new SuperMap.REST.FilterParameter({
        name: "国道@国省干道",
        attributeFilter: "ROADNAME LIKE '%" + content + "%' or ROADCODE LIKE '%" + content + "%'"
    });
    queryBySQLParams = new SuperMap.REST.QueryBySQLParameters({
        queryParams: [queryParamGD]
    });
    queryBySQLService = new SuperMap.REST.QueryBySQLService(MAPURL.URL, {
        eventListeners: {
            "processCompleted": function (queryEventArgs) {
                var strs = "";
                var recordsets = queryEventArgs.result.recordsets;
                var featuresTemp = [];
                var count = 0;
                for (var rindex = 0; rindex < recordsets.length; rindex++) {
                    let features = recordsets[rindex].features;
                    // let features = queryEventArgs.result.recordsets[rindex].features;
                    for (var i = 0; i < features.length; i++) {
                        _obj = features[i].attributes;
                        var tempName = _obj.ROADCODE + "-" + _obj.ROADNAME;
                        if ($.trim(_obj.QDDM) != "" && _obj.QDDM != null) {
                            tempName = tempName + "(" + _obj.QDDM + "-" + _obj.ZDDM + ")";
                        }
                        strs = strs + `<li><div class="text-item"><a href="javascript:void(0);" data-smid="${_obj.ID}" data-index="${i + count}">${tempName}</a></div></li>`;
                    }
                    $("#gdULPlace").html(strs);

                    featuresTemp = featuresTemp.concat(features);
                    count = count + features.length;

                    // 把数据添加到缓存中
                    addData(mydb.db, 'Maps', {id: "GD", list: {strs: strs}});

                    var attrs = $("#gdULPlace>li>div>a");
                    for (var i = 0; i < attrs.length; i++) {
                        $(attrs[i]).click(function () {
                            var smid = $(this).data("smid");
                            // 调用查询图层信息，渲染图层
                            queryFeatureByIdForRender({smid: smid, type: "GD"});
                        });
                    }

                    // bindListClick(strs, featuresTemp, "GD");

                    /* var attrs = $("#gdULPlace>li>div>a");
                     for (var i = 0; i < attrs.length; i++) {
                         var tempIndex = i;
                         $(attrs[i]).click(function () {
                             var _index = $(this).data("index");
                             _feature = featuresTemp[_index];
                             _feature.style = style;
                             vectorLayer.addFeatures(_feature);
                             map.zoomToExtent(_feature.geometry.getBounds())
                         });
                     }*/
                }

            },
            "processFailed": processFailed
        }
    });
    queryBySQLService.processAsync(queryBySQLParams);
}

function searchSD(content) {
    content = $("#sole-input").val();
    content = $.trim(content);
    if (content == undefined) {
        content = ""
    }
    var queryParamSD, queryBySQLParams, queryBySQLService;
    queryParamSD = new SuperMap.REST.FilterParameter({
        name: "省道@国省干道",
        attributeFilter: "ROADNAME LIKE '%" + content + "%' or ROADCODE LIKE '%" + content + "%'"
    });
    queryBySQLParams = new SuperMap.REST.QueryBySQLParameters({
        queryParams: [queryParamSD]
    });
    queryBySQLService = new SuperMap.REST.QueryBySQLService(MAPURL.URL, {
        eventListeners: {
            "processCompleted": function (queryEventArgs) {
                var strs = "";
                var recordsets = queryEventArgs.result.recordsets;
                var featuresTemp = [];
                var count = 0;
                for (var rindex = 0; rindex < recordsets.length; rindex++) {
                    let features = recordsets[rindex].features;
                    // let features = queryEventArgs.result.recordsets[rindex].features;
                    for (var i = 0; i < features.length; i++) {
                        _obj = features[i].attributes;
                        var tempName = _obj.ROADCODE + "-" + _obj.ROADNAME;
                        if ($.trim(_obj.QDDM) != "" && _obj.QDDM != null) {
                            tempName = tempName + "(" + _obj.QDDM + "-" + _obj.ZDDM + ")";
                        }
                        strs = strs + `<li><div class="text-item"><a href="javascript:void(0);" data-smid="${_obj.ID}" data-index="${i + count}">${tempName}</a></div></li>`;
                    }
                    $("#sdULPlace").html(strs);

                    featuresTemp = featuresTemp.concat(features);
                    count = count + features.length;

                    // 把数据添加到缓存中
                    addData(mydb.db, 'Maps', {id: "SD", list: {strs: strs}});

                    var attrs = $("#gdULPlace>li>div>a");
                    for (var i = 0; i < attrs.length; i++) {
                        $(attrs[i]).click(function () {
                            var smid = $(this).data("smid");
                            // 调用查询图层信息，渲染图层
                            queryFeatureByIdForRender({smid: smid, type: "SD"});
                        });
                    }

                    // bindListClick(strs, featuresTemp, "SD");

                    /*   var attrs = $("#sdULPlace>li>div>a");
                       for (var i = 0; i < attrs.length; i++) {
                           var tempIndex = i;
                           $(attrs[i]).click(function () {
                               var _index = $(this).data("index");
                               _feature = featuresTemp[_index];
                               _feature.style = style;
                               vectorLayer.addFeatures(_feature);
                               map.zoomToExtent(_feature.geometry.getBounds())
                           });
                       }*/
                }

            },
            "processFailed": processFailed
        }
    });
    queryBySQLService.processAsync(queryBySQLParams);
}


// 桥梁查询
function searchBridge(content) {
    queryIndexdDB("bridge");
    // searchBigBridge(content);
}

function searchBigBridge(content) {
    content = $("#sole-input").val();
    content = $.trim(content);
    if (content == undefined) {
        content = ""
    }
    var queryParamBridge, queryBySQLParams, queryBySQLService;
    queryParamBridge = new SuperMap.REST.FilterParameter({
        name: "桥梁@国省干道",
        attributeFilter: "NAME LIKE '%" + content + "%'"
    });
    queryBySQLParams = new SuperMap.REST.QueryBySQLParameters({
        queryParams: [queryParamBridge]
    });
    queryBySQLService = new SuperMap.REST.QueryBySQLService(MAPURL.URL, {
        eventListeners: {
            "processCompleted": function (queryEventArgs) {
                var strs = "";
                var recordsets = queryEventArgs.result.recordsets;
                var featuresTemp = [];
                var count = 0;
                for (var rindex = 0; rindex < recordsets.length; rindex++) {
                    let features = recordsets[rindex].features;
                    for (var i = 0; i < features.length; i++) {
                        _obj = features[i].attributes;
                        var tempName = _obj.NAME;
                        strs = strs + `<li><div class="text-item"><a href="javascript:void(0);" data-smid="${_obj.SMID}" data-index="${i + count}">${tempName}</a></div></li>`;
                    }
                    // $("#bigULBridge").html(strs);

                    featuresTemp = featuresTemp.concat(features);
                    count = count + features.length;

                    // 把数据添加到缓存中
                    addData(mydb.db, 'Maps', {id: "bridge", list: {val: featuresTemp, strs: strs}});

                    // var attrs = $("#bigULBridge>li>div>a");
                    bindListClick(strs, featuresTemp, "bridge");
                    /*for (var i = 0; i < attrs.length; i++) {
                        var tempIndex = i;
                        $(attrs[i]).click(function () {
                            var _index = $(this).data("index");
                            _feature = featuresTemp[_index];
                            var x = _feature.geometry.x;
                            var y = _feature.geometry.y;
                            console.log("x=" + x, "y=" + y)
                            // map.setCenter(new SuperMap.LonLat(x, y), 10);

                            _feature.style = {
                                strokeColor: "red",
                                strokeWidth: 10,
                                fillOpacity: "1"
                            };
                            vectorLayer.addFeatures(_feature);
                            map.setCenter(new SuperMap.LonLat(x, y), 10);
                            // map.zoomToExtent(_feature.geometry.getBounds())

                        });
                    }*/
                }

            },
            "processFailed": processFailed
        }
    });
    queryBySQLService.processAsync(queryBySQLParams);
}


// 附属设施查询
function searchAccessory(content) {
    // searchService(content);
    // searchGasStation(content);
    // searchTollStation(content);
    queryIndexdDB("service");
    queryIndexdDB("gasStation");
    queryIndexdDB("tollStation");
}

function searchService(content) {
    content = $("#sole-input").val();
    content = $.trim(content);
    if (content == undefined) {
        content = ""
    }
    var queryParamService, queryBySQLParams, queryBySQLService;
    queryParamService = new SuperMap.REST.FilterParameter({
        name: "服务区@xinjiang20141202",
        attributeFilter: "Name LIKE '%" + content + "%'"
    });
    queryBySQLParams = new SuperMap.REST.QueryBySQLParameters({
        queryParams: [queryParamService]
    });
    queryBySQLService = new SuperMap.REST.QueryBySQLService(MAPURL.URL, {
        eventListeners: {
            "processCompleted": function (queryEventArgs) {
                var strs = "";
                var recordsets = queryEventArgs.result.recordsets;
                var featuresTemp = [];
                var count = 0;
                for (var rindex = 0; rindex < recordsets.length; rindex++) {
                    let features = recordsets[rindex].features;
                    for (var i = 0; i < features.length; i++) {
                        _obj = features[i].attributes;
                        var tempName = _obj.Name;
                        strs = strs + `<li><div class="text-item"><a href="javascript:void(0);" data-smid="${_obj.SMID}" data-index="${i + count}">${tempName}</a></div></li>`;
                    }
                    // $("#serviceUL").html(strs);

                    featuresTemp = featuresTemp.concat(features);
                    count = count + features.length;

                    // 把数据添加到缓存中
                    addData(mydb.db, 'Maps', {id: "service", list: {val: featuresTemp, strs: strs}});
                    bindListClick(strs, featuresTemp, "service");

                    /* var attrs = $("#serviceUL>li>div>a");
                     for (var i = 0; i < attrs.length; i++) {
                         var tempIndex = i;
                         $(attrs[i]).click(function () {
                             var _index = $(this).data("index");
                             _feature = featuresTemp[_index];
                             var x = _feature.geometry.x;
                             var y = _feature.geometry.y;
                             console.log("x=" + x, "y=" + y)
                             map.setCenter(new SuperMap.LonLat(x, y), 10);
                         });
                     }*/
                }

            },
            "processFailed": processFailed
        }
    });
    queryBySQLService.processAsync(queryBySQLParams);
}

function searchGasStation(content) {
    content = $("#sole-input").val();
    content = $.trim(content);
    if (content == undefined) {
        content = ""
    }
    var queryParamGasStation, queryBySQLParams, queryBySQLService;
    queryParamGasStation = new SuperMap.REST.FilterParameter({
        name: "服务区@xinjiang20141202",
        attributeFilter: "Name LIKE '%" + content + "%'"
    });
    queryBySQLParams = new SuperMap.REST.QueryBySQLParameters({
        queryParams: [queryParamGasStation]
    });
    queryBySQLService = new SuperMap.REST.QueryBySQLService(MAPURL.URL, {
        eventListeners: {
            "processCompleted": function (queryEventArgs) {
                var strs = "";
                var recordsets = queryEventArgs.result.recordsets;
                var featuresTemp = [];
                var count = 0;
                for (var rindex = 0; rindex < recordsets.length; rindex++) {
                    let features = recordsets[rindex].features;
                    for (var i = 0; i < features.length; i++) {
                        _obj = features[i].attributes;
                        var tempName = _obj.Name;
                        strs = strs + `<li><div class="text-item"><a href="javascript:void(0);" data-smid="${_obj.SMID}" data-index="${i + count}">${tempName}</a></div></li>`;
                    }
                    // $("#gasStationUL").html(strs);

                    featuresTemp = featuresTemp.concat(features);
                    count = count + features.length;

                    // 把数据添加到缓存中
                    addData(mydb.db, 'Maps', {id: "gasStation", list: {val: featuresTemp, strs: strs}});
                    bindListClick(strs, featuresTemp, "gasStation");

                    /* var attrs = $("#gasStationUL>li>div>a");
                     for (var i = 0; i < attrs.length; i++) {
                         var tempIndex = i;
                         $(attrs[i]).click(function () {
                             var _index = $(this).data("index");
                             _feature = featuresTemp[_index];
                             var x = _feature.geometry.x;
                             var y = _feature.geometry.y;
                             console.log("x=" + x, "y=" + y)
                             map.setCenter(new SuperMap.LonLat(x, y), 10);
                         });
                     }*/
                }

            },
            "processFailed": processFailed
        }
    });
    queryBySQLService.processAsync(queryBySQLParams);
}

function searchTollStation(content) {
    content = $("#sole-input").val();
    content = $.trim(content);
    if (content == undefined) {
        content = ""
    }
    var queryParamTollStation, queryBySQLParams, queryBySQLService;
    queryParamTollStation = new SuperMap.REST.FilterParameter({
        name: "T_收费站@xinjiang20141202",
        attributeFilter: "Name LIKE '%" + content + "%'"
    });
    queryBySQLParams = new SuperMap.REST.QueryBySQLParameters({
        queryParams: [queryParamTollStation]
    });
    queryBySQLService = new SuperMap.REST.QueryBySQLService(MAPURL.URL, {
        eventListeners: {
            "processCompleted": function (queryEventArgs) {
                var strs = "";
                var recordsets = queryEventArgs.result.recordsets;
                var featuresTemp = [];
                var count = 0;
                for (var rindex = 0; rindex < recordsets.length; rindex++) {
                    let features = recordsets[rindex].features;
                    for (var i = 0; i < features.length; i++) {
                        _obj = features[i].attributes;
                        var tempName = _obj.Name;
                        strs = strs + `<li><div class="text-item"><a href="javascript:void(0);" data-smid="${_obj.SMID}" data-index="${i + count}">${tempName}</a></div></li>`;
                    }
                    // $("#tollStationUL").html(strs);

                    featuresTemp = featuresTemp.concat(features);
                    count = count + features.length;

                    // 把数据添加到缓存中
                    addData(mydb.db, 'Maps', {id: "tollStation", list: {val: featuresTemp, strs: strs}});
                    bindListClick(strs, featuresTemp, "tollStation");

                    /*var attrs = $("#tollStationUL>li>div>a");
                    for (var i = 0; i < attrs.length; i++) {
                        var tempIndex = i;
                        $(attrs[i]).click(function () {
                            var _index = $(this).data("index");
                            _feature = featuresTemp[_index];
                            var x = _feature.geometry.x;
                            var y = _feature.geometry.y;
                            console.log("x=" + x, "y=" + y)
                            map.setCenter(new SuperMap.LonLat(x, y), 10);
                        });
                    }*/
                }

            },
            "processFailed": processFailed
        }
    });
    queryBySQLService.processAsync(queryBySQLParams);
}


// 判断缓存中数据存在
function queryIndexdDB(type) {
    getDataByKey(mydb.db, 'Maps', type, function (d) {
        if (d == undefined || d.list == undefined || d.list == null || d.list == "") {
            if (type == "bridge") {
                searchBigBridge();
            } else if (type == "city") {
                searchCity();
            } else if (type == "county") {
                searchCounty();
            } else if (type == "town") {
                searchTown();
            } else if (type == "village") {
                searchVillage();
            } else if (type == "GS") {
                searchGS();
            } else if (type == "GD") {
                searchGD();
            } else if (type == "SD") {
                searchSD();
            } else if (type == "service") {
                searchService();
            } else if (type == "gasStation") {
                searchGasStation();
            } else if (type == "tollStation") {
                searchTollStation();
            }

        } else {
            if (type == "GS") {
                $("#gsULPlace").html(d.list.strs);
                var attrs = $("#gsULPlace>li>div>a");
                for (var i = 0; i < attrs.length; i++) {
                    $(attrs[i]).click(function () {
                        var smid = $(this).data("smid");
                        // 调用查询图层信息，渲染图层
                        queryFeatureByIdForRender({smid: smid, type: "GS"});
                    });
                }
            } else if (type == "GD") {
                $("#gdULPlace").html(d.list.strs);
                var attrs = $("#gdULPlace>li>div>a");
                for (var i = 0; i < attrs.length; i++) {
                    $(attrs[i]).click(function () {
                        var smid = $(this).data("smid");
                        // 调用查询图层信息，渲染图层
                        queryFeatureByIdForRender({smid: smid, type: "GD"});
                    });
                }
            } else if (type == "SD") {
                $("#sdULPlace").html(d.list.strs);
                var attrs = $("#sdULPlace>li>div>a");
                for (var i = 0; i < attrs.length; i++) {
                    $(attrs[i]).click(function () {
                        var smid = $(this).data("smid");
                        // 调用查询图层信息，渲染图层
                        queryFeatureByIdForRender({smid: smid, type: "SD"});
                    });
                }
            } else {
                bindListClick(d.list.strs, d.list.val, type);
            }

        }
    })
}

function bindListClick(strs, featuresTemp, type) {

    var attrs;
    if (type == "bridge") {
        $("#bigULBridge").html(strs);
        attrs = $("#bigULBridge>li>div>a");
    } else if (type == "city") {
        $("#cityUL").html(strs);
        attrs = $("#cityUL>li>div>a");
    } else if (type == "county") {
        $("#countyUL").html(strs);
        attrs = $("#countyUL>li>div>a");
    } else if (type == "town") {
        $("#townUL").html(strs);
        attrs = $("#townUL>li>div>a");
    } else if (type == "village") {
        $("#villageUL").html(strs);
        attrs = $("#villageUL>li>div>a");
    } else if (type == "GS") {
        $("#gsULPlace").html(strs);
        attrs = $("#gsULPlace>li>div>a");
    } else if (type == "GD") {
        $("#gdULPlace").html(strs);
        attrs = $("#gdULPlace>li>div>a");
    } else if (type == "SD") {
        $("#sdULPlace").html(strs);
        attrs = $("#sdULPlace>li>div>a");
    } else if (type == "service") {
        $("#serviceUL").html(strs);
        attrs = $("#serviceUL>li>div>a");
    } else if (type == "gasStation") {
        $("#gasStationUL").html(strs);
        attrs = $("#gasStationUL>li>div>a");
    } else if (type == "tollStation") {
        $("#tollStationUL").html(strs);
        attrs = $("#tollStationUL>li>div>a");
    }

    for (var i = 0; i < attrs.length; i++) {
        var tempIndex = i;
        $(attrs[i]).click(function () {
            removeMapAllFeatures();
            var _index = $(this).data("index");
            _feature = featuresTemp[_index];
            var x, y;
            var _attribute = _feature.attributes;
            if (type == "city" || type == "county") {
                x = _attribute.SMX;
                y = _attribute.SMY;
            } else if (type == "town" || type == "village") {
                x = _attribute.Display_X;
                y = _attribute.Display_Y;
            } else if (type == "bridge") {
                x = _feature.geometry.x;
                y = _feature.geometry.y;
            } else if (type == "service") {
                x = _feature.geometry.x;
                y = _feature.geometry.y;
            } else if (type == "gasStation") {
                x = _feature.geometry.x;
                y = _feature.geometry.y;
            } else if (type == "tollStation") {
                x = _feature.geometry.x;
                y = _feature.geometry.y;
            }
            console.log("x=" + x, "y=" + y)

            _feature.style = {
                strokeColor: "red",
                strokeWidth: 10,
                fillOpacity: "1"
            };

            if (type == "GS" || type == "GD" || type == "SD") {
                /*_feature.style = style;
                setTimeout(function () {
                    vectorLayer.addFeatures(_feature);
                    map.zoomToExtent(_feature.geometry.getBounds())
                }, 200);*/

                var smid = $(this).data("smid");
                console.log("smid===" + smid)
                // 调用查询图层信息，渲染图层
                queryFeatureByIdForRender({smid: smid, type: type});

                /*var attrs = $("#gsULPlace>li>div>a");
                for (var i = 0; i < attrs.length; i++) {
                    var tempIndex = i;
                    $(attrs[i]).click(function () {
                        var smid = $(this).data("smid");
                        console.log("smid==="+smid)
                        // 调用查询图层信息，渲染图层
                        queryFeatureByIdForRender({smid:smid,type:"GS"});
                    });
                }*/

            } else {
                // vectorLayer.addFeatures(_feature);
                map.setCenter(new SuperMap.LonLat(x, y), 10);
            }
        });
    }
}


function refreshIndexdDB() {
    clearStore(mydb.db, 'Maps', function () {
        window.location.reload();
    });
}

function queryFeatureByIdForRender(obj) {
    removeMapAllFeatures();
    vectorLayer.setVisibility(true);
    lineLayer.setVisibility(false);
    vectorLayer.removeAllFeatures();// 去除高亮
    var queryParam;
    if (obj.type == "bridge") {
    } else if (obj.type == "city") {
    } else if (obj.type == "county") {
    } else if (obj.type == "town") {
    } else if (obj.type == "village") {
    } else if (obj.type == "GS") {
        queryParam = new SuperMap.REST.FilterParameter({
            name: "高速公路@国省干道",
            attributeFilter: "ID = '" + obj.smid + "'"
        });
        /*queryBySQLParams = new SuperMap.REST.QueryBySQLParameters({
            queryParams: [queryParam]
        });

        queryBySQLService = new SuperMap.REST.QueryBySQLService(
            MAPURL.URL,
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
                    },
                    "processFailed": processFailed
                }
            });
        queryBySQLService.processAsync(queryBySQLParams);*/

    } else if (obj.type == "GD") {
        queryParam = new SuperMap.REST.FilterParameter({
            name: "国道@国省干道",
            attributeFilter: "ID = '" + obj.smid + "'"
        });

    } else if (obj.type == "SD") {
        queryParam = new SuperMap.REST.FilterParameter({
            name: "省道@国省干道",
            attributeFilter: "ID = '" + obj.smid + "'"
        });
    }


    queryBySQLParams = new SuperMap.REST.QueryBySQLParameters({
        queryParams: [queryParam]
    });

    queryBySQLService = new SuperMap.REST.QueryBySQLService(
        MAPURL.URL,
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
                },
                "processFailed": processFailed
            }
        });
    queryBySQLService.processAsync(queryBySQLParams);
}


function removeMapAllFeatures() {
    //vectorLayer.removeAllFeatures();

    areaLayer.removeAllFeatures();
    //layerZJRoad.setVisibility(false);
}
