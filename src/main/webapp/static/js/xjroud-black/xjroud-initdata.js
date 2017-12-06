/**
 * 模块：初始化数据
 ***********************
 */

// 资金进度数据
var zjjdTableDatas = [
    {
        "id": 0,
        "name": "计划投资(万元)",
        "january": "351",
        "february": "362",
        "march": "453",
        "april": "454",
        "may": "355",
        "june": "436",
        "july": "357",
        "august": "448",
        "september": "369",
        "october": "510",
        "november": "311",
        "december": "412"
    },
    {
        "id": 1,
        "name": "实际投资(万元)",
        "january": "351",
        "february": "362",
        "march": "453",
        "april": "454",
        "may": "355",
        "june": "420",
        "july": "357",
        "august": "448",
        "september": "369",
        "october": "510",
        "november": "311",
        "december": "414"
    }
];
var jdjdTableDatas = [
    {
        "id": 0,
        "name": "计划投资(万元)",
        "january": "351",
        "february": "362",
        "march": "453",
        "april": "454",
        "may": "355",
        "june": "436",
    },
    {
        "id": 1,
        "name": "实际投资(万元)",
        "january": "351",
        "february": "362",
        "march": "453",
        "april": "454",
        "may": "355",
        "june": "420",
    }
];

function initZjjdTable() {
    var _zjjdTbody = ""
    var _zjjdBFB = '<th scope="row">完成百分比(%)</th>'
    for (var i in zjjdTableDatas) {
        _zjjdTbody = _zjjdTbody + '<tr><th scope="row">' + zjjdTableDatas[i].name + '</th>' +
            '<td>' + zjjdTableDatas[i].january + '</td>' +
            '<td>' + zjjdTableDatas[i].february + '</td>' +
            '<td>' + zjjdTableDatas[i].march + '</td>' +
            '<td>' + zjjdTableDatas[i].april + '</td>' +
            '<td>' + zjjdTableDatas[i].may + '</td>' +
            '<td>' + zjjdTableDatas[i].june + '</td>' +
            '<td>' + zjjdTableDatas[i].july + '</td>' +
            '<td>' + zjjdTableDatas[i].august + '</td>' +
            '<td>' + zjjdTableDatas[i].september + '</td>' +
            '<td>' + zjjdTableDatas[i].october + '</td>' +
            '<td>' + zjjdTableDatas[i].november + '</td>' +
            '<td>' + zjjdTableDatas[i].december + '</td>' +
            '</tr>'
    }
    _zjjdBFB = '<tr>' + _zjjdBFB +
        '<td>' + (zjjdTableDatas[1].january / zjjdTableDatas[0].january ).toFixed(4) * 100 + '%</td>' +
        '<td>' + (zjjdTableDatas[1].february / zjjdTableDatas[0].february ).toFixed(4) * 100 + '%</td>' +
        '<td>' + (zjjdTableDatas[1].march / zjjdTableDatas[0].march ).toFixed(4) * 100 + '%</td>' +
        '<td>' + (zjjdTableDatas[1].april / zjjdTableDatas[0].april ).toFixed(4) * 100 + '%</td>' +
        '<td>' + (zjjdTableDatas[1].may / zjjdTableDatas[0].may ).toFixed(4) * 100 + '%</td>' +
        '<td>' + (zjjdTableDatas[1].june / zjjdTableDatas[0].june ).toFixed(4) * 100 + '%</td>' +
        '<td>' + (zjjdTableDatas[1].july / zjjdTableDatas[0].july ).toFixed(4) * 100 + '%</td>' +
        '<td>' + (zjjdTableDatas[1].august / zjjdTableDatas[0].august ).toFixed(4) * 100 + '%</td>' +
        '<td>' + (zjjdTableDatas[1].september / zjjdTableDatas[0].september ).toFixed(4) * 100 + '%</td>' +
        '<td>' + (zjjdTableDatas[1].october / zjjdTableDatas[0].october ).toFixed(4) * 100 + '%</td>' +
        '<td>' + (zjjdTableDatas[1].november / zjjdTableDatas[0].november ).toFixed(4) * 100 + '%</td>' +
        '<td>' + (zjjdTableDatas[1].december / zjjdTableDatas[0].december ).toFixed(4) * 100 + '%</td>' +
        '</tr>';
    _zjjdTbody = _zjjdTbody + _zjjdBFB
    $("#zjjdTable tbody").html(_zjjdTbody)
    var trs = $("#zjjdTable tr")
    var coefficients = trs[trs.length - 1]
    var tds = $(coefficients).find('td')
    for (var i = 0; i < tds.length; i++) {
        var str = $(tds[i]).text().trim();
        var coeff = Number(str.substr(0, str.length - 1))
        if (coeff != 100) {
            var _th = $(trs[0]).find("th")[i + 1]
            var _trOne = $(trs[1]).find("td")[i]
            var _trTwo = $(trs[2]).find("td")[i]
            var _trThree = $(trs[3]).find("td")[i]
            $(_th).addClass("danger")
            $(_trOne).addClass("danger")
            $(_trTwo).addClass("danger")
            $(_trThree).addClass("danger")
        }
    }

}

function initjdjdTable() {
    var _jdjdTbody = ""
    var _jdjdBFB = '<th scope="row">完成百分比(%)</th>'
    for (var i in jdjdTableDatas) {
        _jdjdTbody = _jdjdTbody + '<tr><th scope="row">' + jdjdTableDatas[i].name + '</th>' +
            '<td>' + jdjdTableDatas[i].january + '</td>' +
            '<td>' + jdjdTableDatas[i].february + '</td>' +
            '<td>' + jdjdTableDatas[i].march + '</td>' +
            '<td>' + jdjdTableDatas[i].april + '</td>' +
            '<td>' + jdjdTableDatas[i].may + '</td>' +
            '<td>' + jdjdTableDatas[i].june + '</td>' +
            '</tr>'
    }
    _jdjdBFB = '<tr>' + _jdjdBFB +
        '<td>' + (jdjdTableDatas[1].january / jdjdTableDatas[0].january ).toFixed(4) * 100 + '%</td>' +
        '<td>' + (jdjdTableDatas[1].february / jdjdTableDatas[0].february ).toFixed(4) * 100 + '%</td>' +
        '<td>' + (jdjdTableDatas[1].march / jdjdTableDatas[0].march ).toFixed(4) * 100 + '%</td>' +
        '<td>' + (jdjdTableDatas[1].april / jdjdTableDatas[0].april ).toFixed(4) * 100 + '%</td>' +
        '<td>' + (jdjdTableDatas[1].may / jdjdTableDatas[0].may ).toFixed(4) * 100 + '%</td>' +
        '<td>' + (jdjdTableDatas[1].june / jdjdTableDatas[0].june ).toFixed(4) * 100 + '%</td>' +
        '</tr>';
    _jdjdTbody = _jdjdTbody + _jdjdBFB
    $("#jdjdTable tbody").html(_jdjdTbody)
    var trs = $("#jdjdTable tr")
    var coefficients = trs[trs.length - 1]
    var tds = $(coefficients).find('td')
    for (var i = 0; i < tds.length; i++) {
        var str = $(tds[i]).text().trim();
        var coeff = Number(str.substr(0, str.length - 1))
        if (coeff != 100) {
            var _th = $(trs[0]).find("th")[i + 1]
            var _trOne = $(trs[1]).find("td")[i]
            var _trTwo = $(trs[2]).find("td")[i]
            var _trThree = $(trs[3]).find("td")[i]
            $(_th).addClass("danger")
            $(_trOne).addClass("danger")
            $(_trTwo).addClass("danger")
            $(_trThree).addClass("danger")

        }
    }

}

$(function () {
    initZjjdTable()
    initjdjdTable()
})

/**
 * [获取提示内容]
 * @param  {[type]} obj [properties属性]
 * @return {[type]}     [string]
 */
function getPopupMsg(obj) {
    var _tempTepl = _markerTepl
    _tempTepl = _tempTepl.replace("##name##", obj.XMMC)
        .replace("##mileage##", "70")
        .replace("##startTime##", "2017-5")
        .replace("##endTime##", "2019-10")
        .replace("##jianjie##", "G575巴里坤-哈密段")
        .replace("##actual##", obj.mileage)

    // _tempTepl = _tempTepl.replace("##name##", obj.XMMC)
    //     .replace("##mileage##", parseInt(obj.length))
    //     .replace("##startTime##", obj.begin_User)
    //     .replace("##endTime##", obj.end_User)
    //     .replace("##jianjie##", obj.jianjie)
    //     .replace("##actual##", obj.mileage)

    return _tempTepl
}

// 卫星影像数组
var _layerImageList = [{
    id: "layer20150913",
    time: "20150913",

}, {
    id: "layer20161210",
    time: "20161210",
}, {
    id: "layer20170101",
    time: "20170101",
}]

// marker 模板数据
var _markerTepl = '<div class="popup" style="color: #FFFFFF;font-size: 14px;">  ' +
    '   <section> ' +
    '       公路名：##name##' +
    '   </section>' +
    '   <section> ' +
    '       全长：##mileage##公里' +
    '   </section> ' +
    '   <section>' +
    '       开工时间：##startTime##' +
    '   </section>' +
    '   <section>' +
    '       竣工时间：##endTime##' +
    '   </section>' +
    '   <section>' +
    '       简介：##jianjie##' +
    '   </section>' +
    '   <section>' +
    '</div>'

// marker数据集
var _markerList = [{
    "geometry": {
        "type": "Point",
        "coordinates": [
            623865.51010, 4772555.12113
        ]
    },
    "properties": {
        "name": "G30小草湖至乌鲁木齐段改扩建工程",
        "mileage": "380",
        "design": "中交XXXX",
        "plan": "5",
        "actual": "6"
    }
}, {
    "geometry": {
        "type": "Point",
        "coordinates": [
            622867.43265, 4774969.16099
        ]
    },
    "properties": {
        "name": "G30小草湖至乌鲁木齐段改扩建工程",
        "mileage": "381",
        "design": "中交XXXX",
        "plan": "5",
        "actual": "6"
    }
}, {
    "geometry": {
        "type": "Point",
        "coordinates": [
            620879.68869, 4779458.34025
        ]
    },
    "properties": {
        "name": "G30小草湖至乌鲁木齐段改扩建工程",
        "mileage": "382",
        "design": "中交XXXX",
        "plan": "5",
        "actual": "6"
    }
}, {
    "geometry": {
        "type": "Point",
        "coordinates": [
            614764.72642, 4787675.32079
        ]
    },
    "properties": {
        "name": "G30小草湖至乌鲁木齐段改扩建工程",
        "mileage": "383",
        "design": "中交XXXX",
        "plan": "5",
        "actual": "6"
    }
}, {
    "geometry": {
        "type": "Point",
        "coordinates": [
            609223.04187, 4793446.31642
        ]
    },
    "properties": {
        "name": "G30小草湖至乌鲁木齐段改扩建工程",
        "mileage": "384",
        "design": "中交XXXX",
        "plan": "5",
        "actual": "6"
    }
}];
/**
 * 新疆地区矢量信息
 * 注意：需与地图矢量信息一致
 */
var XJ_AREA_DATA = {
    "独山子区": {
        SmID: "1"
    },
    "奎屯市": {
        SmID: "2"
    },
    "乌鲁木齐市": {
        SmID: "3"
    },
    "阿克苏地区": {
        SmID: "4"
    },
    "阿勒泰地区": {
        SmID: "5"
    },
    "巴音郭楞蒙古自治州": {
        SmID: "6"
    },
    "博尔塔拉蒙古自治州": {
        SmID: "7"
    },
    "昌吉回族自治州": {
        SmID: "8"
    },
    "哈密地区": {
        SmID: "9"
    },
    "和田地区": {
        SmID: "10"
    },
    "喀什地区": {
        SmID: "11"
    },
    "克孜勒苏柯尔克孜自治州": {
        SmID: "12"
    },
    "塔城地区": {
        SmID: "13"
    },
    "吐鲁番地区": {
        SmID: "14"
    },
    "伊犁哈萨克自治州": {
        SmID: "15"
    },
    "石河子市": {
        SmID: "16"
    },
    "克拉玛依市": {
        SmID: "17"
    },


}

