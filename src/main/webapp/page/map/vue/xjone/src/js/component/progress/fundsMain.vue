<template>
    <section>
        <m-header></m-header>
        <div class="row mapWrap">
            <m-lefttree></m-lefttree>
            <div id="MainId" class="col-md-10 col-sm-10" style="height: 100%; min-width: 880px ">
                <div class="row">
                    <div id="mapArea" class="col-md-12 col-sm-12">
                        <m-map></m-map>
                        <m-funds-table></m-funds-table>
                        <m-funds-echarts></m-funds-echarts>
                    </div>
                </div>
            </div>
        </div>
    </section>
</template>
<script>
    import Vue from "Vue";
    import Header from "../header/main.vue";
    import XJMap from "../map/main.vue";
    import LeftTree from "../baseinfo/leftTree.vue";
    import FundsTable from "./fundsTable.vue";
    import FundsEcharts from "./fundsEcharts.vue"
    import {
        mapState,
        mapGetters
    } from "vuex";
    var FundsMain = Vue.extend({
        name: "FundsMain",
        data: function() {
            return {};
        },
        components: {
            "m-header": Header,
            "m-map": XJMap,
            "m-lefttree": LeftTree,
            "m-funds-table": FundsTable,
            "m-funds-echarts":FundsEcharts
        },
        mounted: function() {
            //注意 mounted 不会承诺所有的子组件也都一起被挂载。如果你希望等到整个视图都渲染完毕，可以用 vm.$nextTick 替换掉 mounted：
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
                    layerYXALL: true,
                    vectorLayer: true
                });
               /*  MapLayer.initMap();
                MapLayer.setLayerVisibility({
                    layerT: true,
                    layerRoad: true,
                    layerYXALL: false,
                    layerZJRoad: true,
                    layer20150913: false,
                    layer20161210: false,
                    layer20170101: false,
                    layerYXALL: true,
                    vectorLayer: true
                }); */
            });
        }
    });
    export default FundsMain;
</script>
