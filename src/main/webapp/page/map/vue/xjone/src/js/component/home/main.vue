<template>
  <section>
    <m-header></m-header>
    <!-- <div :class="amsg">
       <input type="button" value="加法+++" v-on:click="increment">
       <input type="button" value="减法---" v-on:click="decrement">
       <div>
         {{ amsg }}
       </div>
     </div> -->
    <div class="row mapWrap">
      <div id="MainId" class="col-md-12 col-sm-12" style="height: 100%; min-width: 880px ">
        <div class="row">
          <div id="mapArea" class="col-md-12 col-sm-12">
            <m-map></m-map>
          </div>
        </div>
      </div>
    </div>
    <m-homeecharts></m-homeecharts>
  </section>
</template>
<script>
  import Vue from "Vue";
  import Header from "../header/main.vue";
  // import MapLayer from "../../config/xjone-map.js";
  import XJMap from "../map/main.vue";
  import HomeEcharts from "./echarts.vue";
  import {
    mapState,
    mapGetters
  } from "vuex";
  var Home = Vue.extend({
    name: "Home",
    data: function() {
      return {
        msg: "Hello Vuex"
      };
    },
    methods: {
      increment() {
        this.$store.dispatch("sendA", this.a);
      },
      decrement() {
        this.$store.dispatch("sendB", this.a);
      }
    },
    computed: {
      ...mapGetters(["amsg", "bmsg"])
    },
    components: {
      "m-header": Header,
      "m-map": XJMap,
      "m-homeecharts": HomeEcharts
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
          vectorLayer: true
        });
        /* MapLayer.initMap();
        MapLayer.setLayerVisibility({
          layerT: true,
          layerRoad: true,
          layerYXALL: false,
          layerZJRoad: true,
          layer20150913: false,
          layer20161210: false,
          layer20170101: false,
          vectorLayer: true
        }); */
      });
    }
  });
  module.exports = Home;
</script>




