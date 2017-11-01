<template>
 <div id="map"></div>
</template>
<script>
var Vue = require("Vue");
import { mapState, mapGetters } from "vuex";

var XJMap = Vue.extend({
  name: "XJMap",
  data: function() {
    return {
        
    };
  },
  created: function() {},
  methods: {},
  components: {},
  computed: {
    ...mapGetters(["amsg", "bmsg","mainClass"])
  },
});

module.exprots = XJMap;
</script>
