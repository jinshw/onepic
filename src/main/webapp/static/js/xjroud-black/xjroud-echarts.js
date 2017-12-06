/**
 * 模块：图表
 *
 */

var myChart = echarts.init(document.getElementById('pieOne'));
// 指定图表的配置项和数据
var option = {
    title: {
        text: '某站点用户访问来源',
        subtext: '纯属虚构',
        x: 'center'
    },
    backgroundColor: "#e1e1e1",
    tooltip: {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    legend: {
        orient: 'vertical',
        left: 'left',
        data: ['直接访问', '邮件营销', '联盟广告', '视频广告', '搜索引擎']
    },
    series: [{
        name: '访问来源',
        type: 'pie',
        radius: '55%',
        center: ['50%', '60%'],
        data: [
            {value: 335, name: '直接访问'},
            {value: 310, name: '邮件营销'},
            {value: 234, name: '联盟广告'},
            {value: 135, name: '视频广告'},
            {value: 1548, name: '搜索引擎'}
        ],
        itemStyle: {
            emphasis: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
            }
        }
    }]
};
// 使用刚指定的配置项和数据显示图表。
myChart.setOption(option);

var pieZJGLChart = echarts.init(document.getElementById('pieZJGL'));
// 指定图表的配置项和数据
var optionPieZJGL = {
    title: {
        text: '项目投资完成情况',
        subtext: '纯属虚构',
        x: 'center'
    },
    backgroundColor: "#e1e1e1",
    tooltip: {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    legend: {
        orient: 'vertical',
        left: 'left',
        data: ['已完成', '未完成']
    },
    series: [{
        name: '投资情况(元)',
        type: 'pie',
        radius: '55%',
        center: ['50%', '60%'],
        data: [
            {value: 25723034, name: '已完成'},
            {value: 20000135, name: '未完成'},
        ],
        itemStyle: {
            emphasis: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
            }
        }
    }]
};
// 使用刚指定的配置项和数据显示图表。
pieZJGLChart.setOption(optionPieZJGL);

// 资金管理折线图
var lineZJGLChart = echarts.init(document.getElementById('lineZJGL'));
var colors = ['#5793f3', '#d14a61', '#675bba'];
// 指定图表的配置项和数据
var optionLineZJGL = {
    title: {
        text: '资金投资',
        subtext: '纯属虚构'
    },
    backgroundColor: "#e1e1e1",
    tooltip: {
        trigger: 'axis'
    },
    legend: {
        data: ['计划投资', '实际投资']
    },
    toolbox: {
        show: true,
        feature: {
            dataZoom: {
                yAxisIndex: 'none'
            },
            dataView: {readOnly: false},
            magicType: {type: ['line', 'bar']},
            restore: {},
            saveAsImage: {}
        }
    },
    xAxis: {
        type: 'category',
        boundaryGap: false,
        data: ['201701', '201702', '201703', '201704', '201705', '201706', '201707', '201708', '201709', '201710']
    },
    yAxis: {
        type: 'value',
        axisLabel: {
            formatter: '{value} 万元'
        }
    },
    series: [
        {
            name: '计划投资',
            type: 'line',
            data: [10000, 21000, 40020, 53000, 66000, 72000, 82000, 91000, 80000, 72000, 61000, 30000],
            markPoint: {
                data: [
                    {type: 'max', name: '最大值'},
                    {type: 'min', name: '最小值'}
                ]
            },
        },
        {
            name: '实际投资',
            type: 'line',
            data: [15000, 26000, 43000, 49000, 60000, 79000, 87200, 94000, 76000, 69000, 58000, 25000],
            markPoint: {
                data: [
                    {name: '周最低', value: -2, xAxis: 1, yAxis: -1.5}
                ]
            },
        }
    ]
};
lineZJGLChart.setOption(optionLineZJGL);


var xmslChart = echarts.init(document.getElementById('xmslEcharts'));
// 指定图表的配置项和数据
var optionTJGNChart = {
    title: {
        text: '项目数量总览',
        subtext: '纯属虚构',
        x: 'center'
    },
    backgroundColor: "#e1e1e1",
    tooltip: {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    legend: {
        x: 'center',
        y: 'bottom',
        data: ['国高', '省高', '国道', '省道']
    },
    toolbox: {
        show: true,
        feature: {
            mark: {show: true},
            dataView: {show: true, readOnly: false},
            magicType: {
                show: true,
                type: ['pie', 'funnel']
            },
            restore: {show: true},
            saveAsImage: {show: true}
        }
    },
    calculable: true,
    series: [
        {
            name: '厅下达任务',
            type: 'pie',
            radius: [20, 110],
            center: ['27%', '50%'],
            roseType: 'radius',
            data: [
                {value: 10, name: '国高'},
                {value: 5, name: '省高'},
                {value: 15, name: '国道'},
                {value: 25, name: '省道'},
            ]
        },
        {
            name: '上报个数',
            type: 'pie',
            radius: [30, 110],
            center: ['75%', '50%'],
            roseType: 'area',
            data: [
                {value: 10, name: '国高'},
                {value: 5, name: '省高'},
                {value: 15, name: '国道'},
                {value: 25, name: '省道'},
            ]
        }
    ]
};
// 使用刚指定的配置项和数据显示图表。
xmslChart.setOption(optionTJGNChart);
xmslChart.on("click", function (eventName, handler, context) {
    console.log(eventName, handler, context)
    queryYXInfo("4")
})

var xmtzEcharts = echarts.init(document.getElementById('xmtzEcharts'));
// 指定图表的配置项和数据
var optionXMTZEcharts = {
    title: {
        text: '项目投资计划(亿)',
        subtext: '纯属虚构',
        x: 'center'
    },
    backgroundColor: "#e1e1e1",
    tooltip: {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    legend: {
        x: 'center',
        y: 'bottom',
        data: ['国高', '省高', '国道', '省道']
    },
    toolbox: {
        show: true,
        feature: {
            mark: {show: true},
            dataView: {show: true, readOnly: false},
            magicType: {
                show: true,
                type: ['pie', 'funnel']
            },
            restore: {show: true},
            saveAsImage: {show: true}
        }
    },
    calculable: true,
    series: [
        {
            name: '下达',
            type: 'pie',
            radius: [20, 110],
            center: ['28%', '50%'],
            roseType: 'radius',
            data: [
                {value: 150, name: '国高'},
                {value: 306, name: '省高'},
                {value: 200, name: '国道'},
                {value: 100, name: '省道'},
            ]
        },
        {
            name: '上报',
            type: 'pie',
            radius: [30, 110],
            center: ['75%', '50%'],
            roseType: 'area',
            data: [
                {value: 160, name: '国高'},
                {value: 310, name: '省高'},
                {value: 210, name: '国道'},
                {value: 100, name: '省道'},
            ]
        }
    ]
};
// 使用刚指定的配置项和数据显示图表。
xmtzEcharts.setOption(optionXMTZEcharts);
xmtzEcharts.on("click", function (eventName, handler, context) {
    console.log(eventName, handler, context)
    queryYXInfo("5")
})

// 前期完成情况（全区）
var qqwcAllEcharts = echarts.init(document.getElementById('qqwcAllEcharts'));
var optionQQWCAllEcharts = {
    title: {
        text: '前期完成情况（进度）',
        subtext: '纯属虚构'
    },
    backgroundColor: "#e1e1e1",
    tooltip: {
        trigger: 'axis'
    },
    legend: {
        data: ['国高', '省高', '国道', '省道']
    },
    toolbox: {
        show: true,
        feature: {
            dataView: {show: true, readOnly: false},
            magicType: {show: true, type: ['line', 'bar']},
            restore: {show: true},
            saveAsImage: {show: true}
        }
    },
    calculable: true,
    xAxis: [
        {
            type: 'category',
            data: ['工可', '初步设计', '施工图设计', '工程招标']
        }
    ],
    yAxis: [
        {
            type: 'value',
            axisLabel: {
                formatter: '{value} 个'
            }
        }
    ],
    series: [
        {
            name: '国高',
            type: 'bar',
            data: [12, 23, 8, 5],
        },
        {
            name: '省高',
            type: 'bar',
            data: [13, 23, 9, 21],
        },
        {
            name: '国道',
            type: 'bar',
            data: [22, 4, 2, 21],
        },
        {
            name: '省道',
            type: 'bar',
            data: [22, 12, 23, 12],
        },
    ]
};
qqwcAllEcharts.setOption(optionQQWCAllEcharts);
qqwcAllEcharts.on("click", function (eventName, handler, context) {
    queryYXInfo("3")
})

// 前期完成情况（厅本）
var qqwcTBEcharts = echarts.init(document.getElementById('qqwcTBEcharts'));
var optionQQWCTBEcharts = {
    title: {
        text: '前期完成情况（进度）',
        subtext: '纯属虚构'
    },
    backgroundColor: "#e1e1e1",
    tooltip: {
        trigger: 'axis'
    },
    legend: {
        data: ['国高', '省高', '国道', '省道']
    },
    toolbox: {
        show: true,
        feature: {
            dataView: {show: true, readOnly: false},
            magicType: {show: true, type: ['line', 'bar']},
            restore: {show: true},
            saveAsImage: {show: true}
        }
    },
    calculable: true,
    xAxis: [
        {
            type: 'category',
            data: ['工可', '初步设计', '施工图设计', '工程招标']
        }
    ],
    yAxis: [
        {
            type: 'value',
            axisLabel: {
                formatter: '{value} 个'
            }
        }
    ],
    series: [
        {
            name: '国高',
            type: 'bar',
            data: [5, 23, 8, 5],
        },
        {
            name: '省高',
            type: 'bar',
            data: [6, 23, 9, 21],
        },
        {
            name: '国道',
            type: 'bar',
            data: [16, 4, 2, 21],
        },
        {
            name: '省道',
            type: 'bar',
            data: [22, 12, 23, 12],
        },
    ]
};
qqwcTBEcharts.setOption(optionQQWCTBEcharts);
qqwcTBEcharts.on("click", function (eventName, handler, context) {
    queryYXInfo("2")
})

// 前期完成情况（地州）
var qqwcDZEcharts = echarts.init(document.getElementById('qqwcDZEcharts'));
var optionQQWCDZEcharts = {
    title: {
        text: '前期完成情况（进度）',
        subtext: '纯属虚构'
    },
    backgroundColor: "#e1e1e1",
    tooltip: {
        trigger: 'axis'
    },
    legend: {
        data: ['国高', '省高', '国道', '省道']
    },
    toolbox: {
        show: true,
        feature: {
            dataView: {show: true, readOnly: false},
            magicType: {show: true, type: ['line', 'bar']},
            restore: {show: true},
            saveAsImage: {show: true}
        }
    },
    calculable: true,
    xAxis: [
        {
            type: 'category',
            data: ['工可', '初步设计', '施工图设计', '工程招标']
        }
    ],
    yAxis: [
        {
            type: 'value',
            axisLabel: {
                formatter: '{value} 个'
            }
        }
    ],
    series: [
        {
            name: '国高',
            type: 'bar',
            data: [17, 23, 8, 5],
        },
        {
            name: '省高',
            type: 'bar',
            data: [14, 23, 9, 21],
        },
        {
            name: '国道',
            type: 'bar',
            data: [26, 4, 2, 21],
        },
        {
            name: '省道',
            type: 'bar',
            data: [34, 12, 23, 12],
        },
    ]
};
qqwcDZEcharts.setOption(optionQQWCDZEcharts);
qqwcDZEcharts.on("click", function (eventName, handler, context) {
    queryYXInfo("1")
})

// 项目投资情况（全区）
var xmtzAllEcharts = echarts.init(document.getElementById('xmtzAllEcharts'));
var optionZMTZAllEcharts = {
    title: {
        text: '项目投资情况',
        subtext: '纯属虚构'
    },
    backgroundColor: "#e1e1e1",
    tooltip: {
        trigger: 'axis'
    },
    legend: {
        data: ['国高', '省高', '国道', '省道']
    },
    toolbox: {
        show: true,
        feature: {
            dataView: {show: true, readOnly: false},
            magicType: {show: true, type: ['line', 'bar']},
            restore: {show: true},
            saveAsImage: {show: true}
        }
    },
    calculable: true,
    xAxis: [
        {
            type: 'category',
            data: ['项目计划下达', '项目计划上报', '本年计划下达', '本年计划上报', '上期完成', '本期完成', '累计完成']
        }
    ],
    yAxis: [
        {
            type: 'value',
            axisLabel: {
                formatter: '{value} 亿'
            }
        }
    ],
    series: [
        {
            name: '国高',
            type: 'bar',
            data: [300, 300, 100, 100, 103, 20, 50],
        },
        {
            name: '省高',
            type: 'bar',
            data: [200, 200, 57, 57, 4, 8, 20],
        },
        {
            name: '国道',
            type: 'bar',
            data: [100, 100, 80, 80, 10, 12, 53],
        },
        {
            name: '省道',
            type: 'bar',
            data: [50, 50, 40, 40, 13, 14, 32],
        },
    ]
};
xmtzAllEcharts.setOption(optionZMTZAllEcharts);
xmtzAllEcharts.on("click", function (eventName, handler, context) {
    queryYXInfo("1")
})
// 项目投资情况（厅本）
var xmtzTBEcharts = echarts.init(document.getElementById('xmtzTBEcharts'));
var optionXMTZBEcharts = {
    title: {
        text: '项目投资情况',
        subtext: '纯属虚构'
    },
    backgroundColor: "#e1e1e1",
    tooltip: {
        trigger: 'axis'
    },
    legend: {
        data: ['国高', '省高', '国道', '省道']
    },
    toolbox: {
        show: true,
        feature: {
            dataView: {show: true, readOnly: false},
            magicType: {show: true, type: ['line', 'bar']},
            restore: {show: true},
            saveAsImage: {show: true}
        }
    },
    calculable: true,
    xAxis: [
        {
            type: 'category',
            data: ['项目计划下达', '项目计划上报', '本年计划下达', '本年计划上报', '上期完成', '本期完成', '累计完成']
        }
    ],
    yAxis: [
        {
            type: 'value',
            axisLabel: {
                formatter: '{value} 亿'
            }
        }
    ],
    series: [
        {
            name: '国高',
            type: 'bar',
            data: [300, 300, 100, 100, 103, 20, 50],
        },
        {
            name: '省高',
            type: 'bar',
            data: [200, 200, 57, 57, 4, 8, 20],
        },
        {
            name: '国道',
            type: 'bar',
            data: [100, 100, 80, 80, 10, 12, 53],
        },
        {
            name: '省道',
            type: 'bar',
            data: [50, 50, 40, 40, 13, 14, 32],
        },
    ]
};
xmtzTBEcharts.setOption(optionXMTZBEcharts);
xmtzTBEcharts.on("click", function (eventName, handler, context) {
    queryYXInfo("7")
})
// 项目投资情况（地州）
var xmtzDZEcharts = echarts.init(document.getElementById('xmtzDZEcharts'));
// 模板
/*var optionXMTDZEcharts = {
    title: {
        text: '项目投资情况',
        subtext: '纯属虚构'
    },
    backgroundColor: "#e1e1e1",
    tooltip: {
        trigger: 'axis'
    },
    legend: {
        data: ['国高', '省高', '国道', '省道']
    },
    toolbox: {
        show: true,
        feature: {
            dataView: {show: true, readOnly: false},
            magicType: {show: true, type: ['line', 'bar']},
            restore: {show: true},
            saveAsImage: {show: true}
        }
    },
    calculable: true,
    xAxis: [
        {
            type: 'category',
            data: ['项目计划下达', '项目计划上报', '本年计划下达', '本年计划上报', '上期完成', '本期完成', '累计完成']
        }
    ],
    yAxis: [
        {
            type: 'value',
            axisLabel: {
                formatter: '{value} 亿'
            }
        }
    ],
    series: [
        {
            name: '国高',
            type: 'bar',
            data: [300, 300, 100, 100, 103, 20, 50],
        },
        {
            name: '省高',
            type: 'bar',
            data: [200, 200, 57, 57, 4, 8, 20],
        },
        {
            name: '国道',
            type: 'bar',
            data: [100, 100, 80, 80, 10, 12, 53],
        },
        {
            name: '省道',
            type: 'bar',
            data: [50, 50, 40, 40, 13, 14, 32],
        },
    ]
};*/
/*var optionXMTDZEcharts = {
    title : {
        text: '2017年G575完成投资',
        x:'center'
    },
    backgroundColor:"#e1e1e1",
    tooltip : {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    toolbox: {
        show: true,
        feature: {
            saveAsImage: {show: true},
            dataView: {show: true, readOnly: false},
            magicType: {show: true, type: ['line', 'bar']},
            restore: {show: true}
        }
    },
    legend: {
        orient: 'vertical',
        left: 'left',
        data: ['1-3月','4月','5月','6月','7月','8月','9月']
    },
    series : [
        {
            name: '计划投资',
            type: 'pie',
            radius : '55%',
            center: ['50%', '60%'],
            data:[
                {value:350, name:'1-3月'},
                {value:750, name:'4月'},
                {value:12540, name:'5月'},
                {value:4560, name:'6月'},
                {value:6200, name:'7月'},
                {value:20000, name:'8月'},
                {value:15500, name:'9月'},
            ],
            itemStyle: {
                emphasis: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            }
        }
    ]
};*/
var optionXMTDZEcharts = {
    title : {
        text: '2017年G575计划投资',
        x:'center'
    },
    backgroundColor:"#e1e1e1",
    tooltip : {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    toolbox: {
        show: true,
        feature: {
            saveAsImage: {show: true},
            dataView: {show: true, readOnly: false},
            magicType: {show: true, type: ['line', 'bar']},
            restore: {show: true}
        }
    },
    legend: {
        orient: 'vertical',
        left: 'left',
        data: ['1-3月','4月','5月','6月','7月','8月','9月','10月','11月']
    },
    series : [
        {
            name: '计划投资',
            type: 'pie',
            radius : '55%',
            center: ['50%', '60%'],
            data:[
                {value:371, name:'1-3月'},
                {value:371, name:'4月'},
                {value:371, name:'5月'},
                {value:2599, name:'6月'},
                {value:22278, name:'7月'},
                {value:25991, name:'8月'},
                {value:22278, name:'9月'},
                {value:22278, name:'10月'},
                {value:7426, name:'11月'},
            ],
            itemStyle: {
                emphasis: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            }
        }
    ]
};
/*
var optionXMTDZEcharts = {
    title: {
        text: '项目投资情况',
        // subtext: '纯属虚构'
    },
    backgroundColor: "#e1e1e1",
    tooltip: {
        trigger: 'axis'
    },
    legend: {
        data: ['计划', '完成']
    },
    toolbox: {
        show: true,
        feature: {
            dataView: {show: true, readOnly: false},
            magicType: {show: true, type: ['line', 'bar']},
            restore: {show: true},
            saveAsImage: {show: true}
        }
    },
    calculable: true,
    xAxis: [
        {
            type: 'category',
            data: ['1-3月', '4月', '5月', '6月', '7月', '8月', '9月','10月','11月','12月']
        }
    ],
    yAxis: [
        {
            type: 'value',
            axisLabel: {
                formatter: '{value} 万元'
            },
            nameTextStyle:{
                fontSize:30
            }
        }
    ],
    series: [
        {
            name: '计划',
            type: 'bar',
            data: [371, 371, 371, 2599, 22278, 25991, 22278,2278,7426],
        },
        {
            name: '完成',
            type: 'bar',
            data: [350, 750, 12540, 4560, 6200, 20000, 15500],
        },
    ]
};
*/
xmtzDZEcharts.setOption(optionXMTDZEcharts);
xmtzDZEcharts.on("click", function (eventName, handler, context) {
    queryYXInfo("8")
})
// 形像进度（全区）
var xxjdAllEcharts = echarts.init(document.getElementById('xxjdAllEcharts'));
var xxjdAllOption = {
    title: {
        text: '形像进度',
        subtext: '纯属虚构',
        left: 'center'
    },
    backgroundColor: "#e1e1e1",
    tooltip: {
        trigger: 'item',
        formatter: "{a} <br/>{b}: {c} ({d}%)"
    },
    legend: {
        orient: 'vertical',
        x: 'left',
        data: ['路基', '路面', '桥梁', '涵洞', '隧道',
            '路基上期', '路基本期', '路面上期', '路面本期', '桥梁上期', '桥梁本期', '涵洞上期', '涵洞本期', '隧道上期', '隧道本期']
    },
    series: [
        {
            name: '形像进度',
            type: 'pie',
            selectedMode: 'single',
            radius: [0, '30%'],

            label: {
                normal: {
                    position: 'inner'
                }
            },
            labelLine: {
                normal: {
                    show: false
                }
            },
            data: [
                {value: 60, name: '路基'},
                {value: 30, name: '路面'},
                {value: 20, name: '桥梁'},
                {value: 40, name: '涵洞'},
                {value: 50, name: '隧道'},
            ]
        },
        {
            name: '形像进度',
            type: 'pie',
            radius: ['40%', '55%'],
            data: [
                {value: 28, name: '路基上期'},
                {value: 32, name: '路基本期'},
                {value: 19, name: '路面上期'},
                {value: 11, name: '路面本期'},
                {value: 9, name: '桥梁上期'},
                {value: 11, name: '桥梁本期'},
                {value: 15, name: '涵洞上期'},
                {value: 25, name: '涵洞本期'},
                {value: 20, name: '隧道上期'},
                {value: 30, name: '隧道本期'},
            ]
        }
    ]
};
xxjdAllEcharts.setOption(xxjdAllOption);
xxjdAllEcharts.on("click", function (eventName, handler, context) {
    queryYXInfo("9")
})
// 形像进度（厅本）
var xxjdTBEcharts = echarts.init(document.getElementById('xxjdTBEcharts'));
var xxjdTBOption = {
    title: {
        text: '形像进度',
        subtext: '纯属虚构',
        left: 'center'
    },
    backgroundColor: "#e1e1e1",
    tooltip: {
        trigger: 'item',
        formatter: "{a} <br/>{b}: {c} ({d}%)"
    },
    legend: {
        orient: 'vertical',
        x: 'left',
        data: ['路基', '路面', '桥梁', '涵洞', '隧道',
            '路基上期', '路基本期', '路面上期', '路面本期', '桥梁上期', '桥梁本期', '涵洞上期', '涵洞本期', '隧道上期', '隧道本期']
    },
    series: [
        {
            name: '形像进度',
            type: 'pie',
            selectedMode: 'single',
            radius: [0, '30%'],

            label: {
                normal: {
                    position: 'inner'
                }
            },
            labelLine: {
                normal: {
                    show: false
                }
            },
            data: [
                {value: 60, name: '路基'},
                {value: 30, name: '路面'},
                {value: 20, name: '桥梁'},
                {value: 40, name: '涵洞'},
                {value: 50, name: '隧道'},
            ]
        },
        {
            name: '形像进度',
            type: 'pie',
            radius: ['40%', '55%'],
            data: [
                {value: 28, name: '路基上期'},
                {value: 32, name: '路基本期'},
                {value: 19, name: '路面上期'},
                {value: 11, name: '路面本期'},
                {value: 9, name: '桥梁上期'},
                {value: 11, name: '桥梁本期'},
                {value: 15, name: '涵洞上期'},
                {value: 25, name: '涵洞本期'},
                {value: 20, name: '隧道上期'},
                {value: 30, name: '隧道本期'},
            ]
        }
    ]
};
xxjdTBEcharts.setOption(xxjdTBOption);
xxjdTBEcharts.on("click", function (eventName, handler, context) {
    queryYXInfo("10")
})
// 形像进度（地州）
var xxjdDZEcharts = echarts.init(document.getElementById('xxjdDZEcharts'));
var xxjdDZOption = {
    title: {
        text: '形像进度',
        subtext: '纯属虚构',
        left: 'center'
    },
    backgroundColor: "#e1e1e1",
    tooltip: {
        trigger: 'item',
        formatter: "{a} <br/>{b}: {c} ({d}%)"
    },
    legend: {
        orient: 'vertical',
        x: 'left',
        data: ['路基', '路面', '桥梁', '涵洞', '隧道',
            '路基上期', '路基本期', '路面上期', '路面本期', '桥梁上期', '桥梁本期', '涵洞上期', '涵洞本期', '隧道上期', '隧道本期']
    },
    series: [
        {
            name: '形像进度',
            type: 'pie',
            selectedMode: 'single',
            radius: [0, '30%'],

            label: {
                normal: {
                    position: 'inner'
                }
            },
            labelLine: {
                normal: {
                    show: false
                }
            },
            data: [
                {value: 60, name: '路基'},
                {value: 30, name: '路面'},
                {value: 20, name: '桥梁'},
                {value: 40, name: '涵洞'},
                {value: 50, name: '隧道'},
            ]
        },
        {
            name: '形像进度',
            type: 'pie',
            radius: ['40%', '55%'],
            data: [
                {value: 28, name: '路基上期'},
                {value: 32, name: '路基本期'},
                {value: 19, name: '路面上期'},
                {value: 11, name: '路面本期'},
                {value: 9, name: '桥梁上期'},
                {value: 11, name: '桥梁本期'},
                {value: 15, name: '涵洞上期'},
                {value: 25, name: '涵洞本期'},
                {value: 20, name: '隧道上期'},
                {value: 30, name: '隧道本期'},
            ]
        }
    ]
};
xxjdDZEcharts.setOption(xxjdDZOption);
xxjdDZEcharts.on("click", function (eventName, handler, context) {
    queryYXInfo("11")
    querySelectData()
})


function echartsResize() {
    $("#tjTabContent").css('height', $('#map').height())
    var _width = document.body.clientWidth - $("#map").width()
    var _offset = 0
    console.log(_width)
    $("#xmslEcharts").css('width', _width - _offset)
    $("#xmtzEcharts").css('width', _width - _offset)
    $("#qqwcAllEcharts").css('width', _width - _offset)
    $("#qqwcTBEcharts").css('width', _width - _offset)
    $("#qqwcDZEcharts").css('width', _width - _offset)
    $("#xmtzAllEcharts").css('width', _width - _offset)
    $("#xmtzTBEcharts").css('width', _width - _offset)
    $("#xmtzDZEcharts").css('width', _width - _offset)
    $("#xxjdAllEcharts").css('width', _width - _offset)
    $("#xxjdTBEcharts").css('width', _width - _offset)
    $("#xxjdDZEcharts").css('width', _width - _offset)

    xmslChart.resize()
    xmtzEcharts.resize()
    qqwcAllEcharts.resize()
    qqwcTBEcharts.resize()
    qqwcDZEcharts.resize()
    xmtzAllEcharts.resize()
    xmtzTBEcharts.resize()
    xmtzDZEcharts.resize()
    xxjdAllEcharts.resize()
    xxjdTBEcharts.resize()
    xxjdDZEcharts.resize()
}

/**
 * 统计功能图表切换
 * @param type：block显示、 none 隐藏
 */
function echartsToggle(type) {
    if (type == 'block') {
        $("#leftSider").css("display", "none")
        $("#MainId").removeClass("col-md-10 col-sm-10").addClass("col-md-12 col-sm-12")

        $("#mapArea").removeClass("col-md-12 col-sm-12").addClass("col-md-8 col-sm-8")
        $("#echartArea").css("display", "block")
    } else {
        $("#leftSider").css("display", "block")
        $("#MainId").removeClass("col-md-12 col-sm-12").addClass("col-md-10 col-sm-10")

        $("#mapArea").removeClass("col-md-8 col-sm-8").addClass("col-md-12 col-sm-12")
        $("#echartArea").css("display", "none")
    }

}

function querySelectData(obj) {
    var obj = {} || obj;

    console.log("aaaa")
    var queryParam, queryParamGS, queryParamGD, queryParamSD, queryBySQLParams, queryBySQLService;
    if (obj.gljb == 'GS') {
        queryParam = new SuperMap.REST.FilterParameter({
            name: "GLGS_1@xj"
        });
    } else if (obj.gljb == 'GD') {
        queryParam = new SuperMap.REST.FilterParameter({
            name: "GLGD_3@xj",
            // attributeFilter: "SmID = " + treeNode.smId
        });
    } else if (obj.gljb == 'SD') {
        queryParam = new SuperMap.REST.FilterParameter({
            name: "一般省道@交通#3",
            // attributeFilter: "SmID = " + treeNode.smId
        });
    } else {
        queryParamGS = new SuperMap.REST.FilterParameter({
            name: "GLGS_1@xj",
            attributeFilter: "SmID <= " + '5'
        });
        queryParamGD = new SuperMap.REST.FilterParameter({
            name: "GLGD_3@xj",
            attributeFilter: "SmID <= " + '5'
        });
        queryParamSD = new SuperMap.REST.FilterParameter({
            name: "一般省道@交通#3",
            attributeFilter: "SmID <= " + '5'
        });
    }

    queryBySQLParams = new SuperMap.REST.QueryBySQLParameters({
        queryParams: [queryParamGS, queryParamGD, queryParamSD]
    });
    queryBySQLService = new SuperMap.REST.QueryBySQLService(MAPURL.ZJ_ROAD, {
        eventListeners: {
            "processCompleted": function (queryEventArgs) {
                var feature;
                for (var i = 0; i < queryEventArgs.result.recordsets.length; i++) {
                    for (var j=0; j < queryEventArgs.result.recordsets[i].features.length; j++) {
                        feature = queryEventArgs.result.recordsets[i].features[j]
                        feature.style = {
                            strokeColor: "red",
                            strokeWidth: 4,
                            fillOpacity: "1"
                        };
                        areaLayer.addFeatures(feature);
                    }
                }
                var selectFeatureEchart = new SuperMap.Control.SelectFeature(areaLayer, {
                    callbacks: {
                        click: function (currentFeature) {
                            console.log(currentFeature)
                            // layer.open({
                            //     type: 1,
                            //     title: false,
                            //     closeBtn: 0,
                            //     area: '516px',
                            //     shadeClose: true,
                            //     content: $('#xxjdDZEcharts')
                            // });
                            layer.open({
                                type: 1,
                                title: false,
                                closeBtn: 0,
                                skin: 'layui-layer-nobg', //没有背景色
                                shadeClose: true,
                                area: ['800px', '800px'], //宽高
                                content: $('#onlyEchart'),
                                success: function(layero, index){
                                    initOnlyEchart()
                                    console.log(layero, index);
                                }
                            });
                        }
                    }
                })
                map.addControl(selectFeatureEchart);
                selectFeatureEchart.activate();
            },
            "processFailed": processFailed
        }
    });
    queryBySQLService.processAsync(queryBySQLParams);
}

function initOnlyEchart() {
    var onlyEchart = echarts.init(document.getElementById('onlyEchart'));
    var onlyEchartOption = {
        title: {
            text: '形像进度',
            subtext: '纯属虚构',
            left: 'center'
        },
        backgroundColor: "#e1e1e1",
        tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b}: {c} ({d}%)"
        },
        legend: {
            orient: 'vertical',
            x: 'left',
            data: ['路基', '路面', '桥梁', '涵洞', '隧道',
                '路基上期', '路基本期', '路面上期', '路面本期', '桥梁上期', '桥梁本期', '涵洞上期', '涵洞本期', '隧道上期', '隧道本期']
        },
        series: [
            {
                name: '形像进度',
                type: 'pie',
                selectedMode: 'single',
                radius: [0, '30%'],

                label: {
                    normal: {
                        position: 'inner'
                    }
                },
                labelLine: {
                    normal: {
                        show: false
                    }
                },
                data: [
                    {value: 60, name: '路基'},
                    {value: 30, name: '路面'},
                    {value: 20, name: '桥梁'},
                    {value: 40, name: '涵洞'},
                    {value: 50, name: '隧道'},
                ]
            },
            {
                name: '形像进度',
                type: 'pie',
                radius: ['40%', '55%'],
                data: [
                    {value: 28, name: '路基上期'},
                    {value: 32, name: '路基本期'},
                    {value: 19, name: '路面上期'},
                    {value: 11, name: '路面本期'},
                    {value: 9, name: '桥梁上期'},
                    {value: 11, name: '桥梁本期'},
                    {value: 15, name: '涵洞上期'},
                    {value: 25, name: '涵洞本期'},
                    {value: 20, name: '隧道上期'},
                    {value: 30, name: '隧道本期'},
                ]
            }
        ]
    };
    onlyEchart.setOption(onlyEchartOption);
    onlyEchart.resize()
    onlyEchart.on("click", function (eventName, handler, context) {

    })
}
