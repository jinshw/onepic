<template>
  <section>
    <m-header></m-header>
    <div class="row mapWrap">
      <m-lefttree></m-lefttree>
      <div id="MainId" class="col-md-10 col-sm-10" style="height: 100%; min-width: 880px ">
        <div class="row">
          <div id="mapArea" class="col-md-12 col-sm-12">
            <m-map></m-map>
            <m-project-info v-bind:style="{display:config.projectInfo?'block':'none'}"></m-project-info>
            <m-set-page v-bind:config="config"></m-set-page>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>
<script>
  import Vue from "Vue";
  import Header from "../header/main.vue";
  // import MapLayer from "../../config/xjone-map.js";
  import XJMap from "../map/main.vue";
  import LeftTree from "./leftTree.vue";
  import ProjectInfo from "./projectInfo.vue";
  import SetPage from "../common/setpage.vue";
  import {
    mapState,
    mapGetters
  } from "vuex";
  var Home = Vue.extend({
    name: "Home",
    data: function() {
      return {
        config: {
          jdhc: false,
          scanPicInfo: false,
          projectInfo: true,
          yxhcInfo: false,
          jdhcDisplay: 'none',
          scanPicInfoDisplay: 'none',
          projectInfoDisplay: 'display',
          yxhcInfoDisplay: 'none',
        }
      };
    },
    methods: {
      increment() {
        this.$store.dispatch("sendA", this.a);
      },
      decrement() {
        this.$store.dispatch("sendB", this.a);
      },
      
    },
    computed: {
      ...mapGetters(["amsg", "bmsg"])
    },
    components: {
      "m-header": Header,
      "m-map": XJMap,
      "m-lefttree": LeftTree,
      "m-project-info": ProjectInfo,
      "m-set-page": SetPage
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
      });
    }
  });
  module.exports = Home;
</script>




