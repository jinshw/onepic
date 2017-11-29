<template>
    <div class="row">
        <div id="mapArea" class="col-md-12 col-sm-12">
            <m-map></m-map>
            <div class="yx-time-line" id="timeLine">
            </div>
            <m-set-page v-bind:config="config"></m-set-page>
            <!-- 影像核查信息显示 -->
            <div class="yxhc-info-area" v-bind:style="{display:config.yxhcInfo?'block':'none'}">
                G575巴里坤-哈密段，2017 年9月动工八处，施工里程为16公里，施工主要为桥梁桩基础施工、便道施工、清表施工。
            </div>
            <!-- 标注笔记 -->
            <m-note-page></m-note-page>
        </div>
    </div>
</template>
<script>
import Vue from "Vue";
// import Header from "../header/main.vue";
import XJMap from "../map/main.vue";
// import LeftTree from "../baseinfo/leftTree.vue";
import SetPage from "../common/setpage.vue";
import NotePage from "../common/notepage.vue";
var InspectMap = Vue.extend({
  name: "InspectMain",
  props:{
    config: {
        type: Object,
    }
  },
  created: function() {
    console.log("map--created",this.config)
    this.$emit('refconfig')
  },
  data: function() {
    return {
      myconfig:this.config
      // config: {
      //   jdhc: true,
      //   scanPicInfo: false,
      //   projectInfo: false,
      //   yxhcInfo: false,
      //   jdhcDisplay: "none",
      //   scanPicInfoDisplay: "block",
      //   projectInfoDisplay: "none",
      //   yxhcInfoDisplay: "block"
      // }
    };
  },
  components: {
    "m-map": XJMap,
    "m-set-page": SetPage,
    "m-note-page": NotePage
  },
  methods: {
    projectInfoEvent() {
      this.config.yxhcInfo = true;
    }
  },
  mounted: function() {
    //注意 mounted 不会承诺所有的子组件也都一起被挂载。如果你希望等到整个视图都渲染完毕，可以用 vm.$nextTick 替换掉 mounted：
    this.$nextTick(function() {
      initMap({
        lat: 87.40448,
        lon: 43.87231,
        level: 5
      });
      setLayerVisibility({
        layerT: false,
        layerRoad: true,
        layerYXALL: true,
        layerZJRoad: true,
        layerYX201709: true,
        vectorLayer: true,
        layerChangeArea: true
      });
      timeLineLayer();
    });
  }
});
export default InspectMap;
</script>
