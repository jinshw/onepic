<template>
    <div class="row">
        <div id="mapArea" class="col-md-12 col-sm-12">
            <m-map></m-map>
        </div>
        <m-set-page v-bind:config="config"></m-set-page>
        <!-- 标注笔记 -->
        <m-note-page moduletype="1"></m-note-page>
    </div>
</template>
<script>
import Vue from "Vue";
import XJMap from "../map/main.vue";
import SetPage from "../common/setpage.vue";
import NotePage from "../common/notepage.vue";
var EarlyWarningMap = Vue.extend({
  name: "EarlyWarningMap",
  props: {
    config: {
      type: Object
    }
  },
  created: function() {
    console.log("map--created", this.config);
    this.$emit("refconfig");
  },
  components: {
    "m-map": XJMap,
    "m-set-page": SetPage,
    "m-note-page": NotePage
  },
  methods: {},
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
        layerZJRoad: false,
        layer20150913: false,
        layer20161210: false,
        layer20170101: true,
        vectorLayer: true,
        layerJSJD: true,
        layerSar2017: false,
        layerJSJDTWD: true,
        markers: true
      });
      timeLineLayer();
    });
  }
});
export default EarlyWarningMap;
</script>
