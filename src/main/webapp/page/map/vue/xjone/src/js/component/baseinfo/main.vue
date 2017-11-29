<template>
  <section>
    <m-header></m-header>
    <div class="row mapWrap">
      <m-lefttree v-on:refproject="projectInfoEvent"></m-lefttree>
      <div id="MainId" class="col-md-10 col-sm-10" style="height: 100%; min-width: 880px ">
        
        <!-- <div class="row">
          <div id="mapArea" class="col-md-12 col-sm-12">
            <m-map></m-map>
            <m-project-info v-bind:style="{display:config.projectInfo?'block':'none'}"></m-project-info>
            <m-set-page v-bind:config="config"></m-set-page>
          </div>
        </div> -->
        <!-- <m-basemap></m-basemap> -->
        <router-view class="view" v-bind:config="config" v-on:refconfig="getConfig"></router-view>
      </div>
    </div>
  </section>
</template>
<script>
import Vue from "Vue";
// import VueRouter from "vue-router";
import Header from "../header/main.vue";
// import MapLayer from "../../config/xjone-map.js";
// import XJMap from "../map/main.vue";
import LeftTree from "./leftTree.vue";
// import ProjectInfo from "./projectInfo.vue";
// import SetPage from "../common/setpage.vue";
import BaseMap from "./basemap.vue";
import { mapState, mapGetters } from "vuex";

/* //定义路由
const router = new VueRouter({
  base: __dirname,
  routes: [
    { path: "/", component: Home },
    { path: "/base", component: BaseInfo },
    { path: "/progress/funds", component: FundsMain },
    { path: "/progress/image", component: ImageMain },
    { path: "/inspect", component: InspectMain },
    { path: "/earlywarning", component: EarlyWarning },
    { path: "/charts", component: ChartsMain }
  ]
}); */

var Home = Vue.extend({
  name: "Home",
  created: function() {
    console.log("created", this.config);
    this.getConfig();
  },
  data: function() {
    return {
      config: {
        jdhc: false,
        scanPicInfo: false,
        projectInfo: true,
        yxhcInfo: false,
        jdhcDisplay: "none",
        scanPicInfoDisplay: "none",
        projectInfoDisplay: "none",
        yxhcInfoDisplay: "none"
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
    projectInfoEvent() {
      this.config.yxhcInfo = true;
    },
    getConfig() {
      console.log(this.$route, "getConfig");
      var path = this.$route.path;
      if (path == "/base") {
        this.setConfig({
          jdhc: false,
          scanPicInfo: false,
          projectInfo: true,
          yxhcInfo: true,
          jdhcDisplay: "none",
          scanPicInfoDisplay: "none",
          projectInfoDisplay: "display",
          yxhcInfoDisplay: "none"
        });
      } else if (path == "/progress/funds") {
      } else if (path == "/progress/image") {
      } else if (path == "/inspect") {
        this.setConfig({
          jdhc: false,
          scanPicInfo: false,
          projectInfo: false,
          yxhcInfo: false,
          jdhcDisplay: "none",
          scanPicInfoDisplay: "display",
          projectInfoDisplay: "none",
          yxhcInfoDisplay: "display"
        });
      } else if (path == "/earlywarning") {
        this.setConfig({
          jdhc: true,
          scanPicInfo: false,
          projectInfo: false,
          yxhcInfo: false,
          jdhcDisplay: "display",
          scanPicInfoDisplay: "none",
          projectInfoDisplay: "none",
          yxhcInfoDisplay: "none"
        });
      }
    },
    setConfig(obj) {
      this.config.jdhc = obj.jdhc;
      this.config.scanPicInfo = obj.scanPicInfo;
      this.config.projectInfo = obj.projectInfo;
      this.config.yxhcInfo = obj.yxhcInfo;
      this.config.jdhcDisplay = obj.jdhcDisplay;
      this.config.scanPicInfoDisplay = obj.scanPicInfoDisplay;
      this.config.projectInfoDisplay = obj.projectInfoDisplay;
      this.config.yxhcInfoDisplay = obj.yxhcInfoDisplay;
    }
  },
  computed: {
    ...mapGetters(["amsg", "bmsg"])
  },
  components: {
    "m-header": Header,
    "m-lefttree": LeftTree,
    "m-basemap": BaseMap
  },
  mounted: function() {
    //注意 mounted 不会承诺所有的子组件也都一起被挂载。如果你希望等到整个视图都渲染完毕，可以用 vm.$nextTick 替换掉 mounted：
    this.$nextTick(function() {});
  }
});
module.exports = Home;
</script>




