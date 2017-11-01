<template>
    <!--资金管理图表-->
    <div class="zjgl-echarts-area" id="zjGLChartArea">
        <div class="pie-chart" id="pieZJGL" style="width: 500px;height: 300px;z-index: 10005;
                                 position: absolute;bottom: 2px;left: 15px;">
        </div>
        <div class="line-chart" id="lineZJGL" style="width: 800px;height: 300px;z-index: 10005;
                                 position: absolute;bottom: 2px;left: 520px;">
        </div>
    </div>
</template>
<script>
    import Vue from "Vue";
    var FundsEcharts = Vue.extend({
        name: "FundsEcharts",
        data: function() {
            return {};
        },
        mounted: function() {
            //注意 mounted 不会承诺所有的子组件也都一起被挂载。如果你希望等到整个视图都渲染完毕，可以用 vm.$nextTick 替换掉 mounted：
            this.$nextTick(function() {
                var pieZJGLChart = this.$echarts.init(document.getElementById('pieZJGL'));
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
                        data: [{
                                value: 25723034,
                                name: '已完成'
                            },
                            {
                                value: 20000135,
                                name: '未完成'
                            },
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
                var lineZJGLChart = this.$echarts.init(document.getElementById('lineZJGL'));
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
                            dataView: {
                                readOnly: false
                            },
                            magicType: {
                                type: ['line', 'bar']
                            },
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
                    series: [{
                            name: '计划投资',
                            type: 'line',
                            data: [10000, 21000, 40020, 53000, 66000, 72000, 82000, 91000, 80000, 72000, 61000, 30000],
                            markPoint: {
                                data: [{
                                        type: 'max',
                                        name: '最大值'
                                    },
                                    {
                                        type: 'min',
                                        name: '最小值'
                                    }
                                ]
                            },
                        },
                        {
                            name: '实际投资',
                            type: 'line',
                            data: [15000, 26000, 43000, 49000, 60000, 79000, 87200, 94000, 76000, 69000, 58000, 25000],
                            markPoint: {
                                data: [{
                                    name: '周最低',
                                    value: -2,
                                    xAxis: 1,
                                    yAxis: -1.5
                                }]
                            },
                        }
                    ]
                };
                lineZJGLChart.setOption(optionLineZJGL);
            });
        }
    });
    export default FundsEcharts;
</script>
