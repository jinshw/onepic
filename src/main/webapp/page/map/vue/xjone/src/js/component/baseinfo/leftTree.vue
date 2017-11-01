<template>
  <div id="leftSider" class="col-md-2 col-sm-2" style="display:block; height: 100%;background: #293033; min-width: 200px">
    <div style="height: 100%; width: 100%; position: absolute; left:10px; overflow: auto;">
      <ul id="treeDemo" class="ztree"></ul>
      <ul id="treeDemoDZ" class="ztree"></ul>
      <ul id="treeDemoJS" class="ztree"></ul>
    </div>
  </div>
</template>
<script>
  import Vue from "Vue";
  // import InitTree from "../../config/initTree.js";
  var LeftTree = Vue.extend({
    name: "LeftTree",
    data: function() {
      return {};
    },
    methods: {},
    mounted: function() {
      //注意 mounted 不会承诺所有的子组件也都一起被挂载。如果你希望等到整个视图都渲染完毕，可以用 vm.$nextTick 替换掉 mounted：
      this.$nextTick(function() {
        // InitTree.initTree();
        var that = this
        initTree(function() {
          that.$emit('refproject');
        })
      });
    },
  });
  export default LeftTree;
</script>
