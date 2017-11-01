<template>
    <section>
        <m-header></m-header>
        <div class="row mapWrap">
            <div id="MainId" class="col-md-12 col-sm-12" style="height: 100%; min-width: 880px ">
                <div class="row">
                    <div id="mapArea" class="col-md-8 col-sm-8">
                        <m-map></m-map>
                    </div>
                    <div id="echartArea" class="col-md-4 col-sm-4 tongji-echarts">
                        <ul class="nav nav-tabs">
                            <li class="active">
                                <a href="#echartBasic" data-toggle="tab">概况</a>
                            </li>
                            <li>
                                <a href="#echartAll" data-toggle="tab">全区</a>
                            </li>
                            <li>
                                <a href="#echartTB" data-toggle="tab">厅本</a>
                            </li>
                            <li>
                                <a href="#echartDZ" data-toggle="tab">地州</a>
                            </li>
                        </ul>
                        <div id="tjTabContent" class="tab-content" style="height: auto;width: 100%;height: 899px;">
                            <div class="tab-pane fad in active" id="echartBasic">
                                <div id="xmslEcharts" class="echarts-container"></div>
                                <div id="xmtzEcharts" class="echarts-container"></div>
                                <!--<div id="qqwcEcharts" class="echarts-container"></div>-->
                            </div>
                            <div class="tab-pane fad" id="echartAll">
                                <div id="qqwcAllEcharts" class="echarts-container"></div>
                                <div id="xmtzAllEcharts" class="echarts-container"></div>
                                <div id="xxjdAllEcharts" class="echarts-container" style="height: 500px;"></div>
                            </div>
                            <div class="tab-pane fad" id="echartTB">
                                <div id="qqwcTBEcharts" class="echarts-container"></div>
                                <div id="xmtzTBEcharts" class="echarts-container"></div>
                                <div id="xxjdTBEcharts" class="echarts-container" style="height: 500px;"></div>
                            </div>
                            <div class="tab-pane fad" id="echartDZ">
                                <div id="qqwcDZEcharts" class="echarts-container"></div>
                                <div id="xmtzDZEcharts" class="echarts-container"></div>
                                <div id="xxjdDZEcharts" class="echarts-container" style="height: 500px;"></div>
                            </div>
                        </div>
                    </div>
                    <div class="echart-only-container">
                        <div id="onlyEchart" style="height: 800px;width: 800px;"></div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</template>

<script>
    import Vue from 'Vue';
    import Header from "../header/main.vue";
    import XJMap from "../map/main.vue";
    var ChartsMain = Vue.extend({
        name: "ChartsMain",
        data: function() {
            return {}
        },
        components: {
            "m-header": Header,
            "m-map": XJMap,
        },
        methods: {},
        mounted: function() {
            this.$nextTick(function() {
                initMap();
                setLayerVisibility({
                    layerT: true,
                    layerRoad: true,
                    layerYXALL: false,
                    layerZJRoad: true,
                    layer20150913: false,
                    layer20161210: false,
                    layer20170101: false,
                    vectorLayer: true,
                    areaLayer: true
                });
                initEcharts()
                echartsResize()
            });
        }
    })
    export default ChartsMain;
</script>
