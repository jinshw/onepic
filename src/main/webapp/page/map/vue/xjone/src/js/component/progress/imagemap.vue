<template>
     <div class="row">
        <div id="mapArea" class="col-md-12 col-sm-12">
            <m-map></m-map>
            <m-image-table></m-image-table>
        </div>
    </div>
</template>
<script>
    import Vue from 'Vue'
    import XJMap from "../map/main.vue";
    import ImageTable from './imageTable.vue'
    var ImageMap = Vue.extend({
        name: "ImageMap",
        data: function() {
            return {};
        },
        components: {
            "m-map": XJMap,
            "m-image-table": ImageTable,
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
            });
        }
    });
    export default ImageMap;
</script>
