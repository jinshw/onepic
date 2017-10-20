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
        text: '项目情况',
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
        data: ['厅本级', '地州交通局', '建设兵团']
    },
    series: [{
        name: '项目个数',
        type: 'pie',
        radius: '55%',
        center: ['50%', '60%'],
        data: [
            {value: 40, name: '厅本级'},
            {value: 260, name: '地州交通局'},
            {value: 220, name: '建设兵团'}
        ],
        itemStyle: {
            emphasis: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
            }
        },
    }],
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
        text: '某地区蒸发量和降水量',
        subtext: '纯属虚构'
    },
    backgroundColor: "#e1e1e1",
    tooltip: {
        trigger: 'axis'
    },
    legend: {
        data: ['蒸发量', '降水量']
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
            data: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月']
        }
    ],
    yAxis: [
        {
            type: 'value'
        }
    ],
    series: [
        {
            name: '蒸发量',
            type: 'bar',
            data: [2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3],
            markPoint: {
                data: [
                    {type: 'max', name: '最大值'},
                    {type: 'min', name: '最小值'}
                ]
            },
            markLine: {
                data: [
                    {type: 'average', name: '平均值'}
                ]
            }
        },
        {
            name: '降水量',
            type: 'bar',
            data: [2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3],
            markPoint: {
                data: [
                    {name: '年最高', value: 182.2, xAxis: 7, yAxis: 183},
                    {name: '年最低', value: 2.3, xAxis: 11, yAxis: 3}
                ]
            },
            markLine: {
                data: [
                    {type: 'average', name: '平均值'}
                ]
            }
        }
    ]
};
// 使用刚指定的配置项和数据显示图表。
xmtzEcharts.setOption(optionXMTZEcharts);
xmtzEcharts.on("click", function (eventName, handler, context) {
    console.log(eventName, handler, context)
    queryYXInfo("5")
})



