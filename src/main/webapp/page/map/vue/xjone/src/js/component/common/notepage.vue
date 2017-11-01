<!--
组件名称：标注笔记记录组件
参数：父组件组件需要传递参数
    
-->
<template>
    <!--标注笔记页面-->
    <div class="drawplot-container" id="toolbar">
        <div class="drawplot-opt-bar">
            <input type="checkbox" v-on:change="chkChange" id="isShowMarker"> 开始标注
            <input type="button" id="delMarkerBT" style="background-color: #313d4f;" class="btn" value="删除标注" onclick="removePlotById()" />
        </div>
        <div class="drawplot-content">
            <div class="drawplot-content-area">
                <textarea name="" id="plotContent" cols="" rows="" style="color: #000000;border:1px solid #000000;"></textarea>
            </div>
            <div class="drawplot-bt-bar">
                <input type="button" id="saveMarkerBT" style="background-color: #313d4f;" class="btn" value="保存" onclick="plotSaveBt()" />
                <input type="button" id="cancelMarkerBT" style="background-color: #313d4f;" class="btn" value="取消" onclick="plotCancelBt()" />
            </div>
        </div>
    </div>
</template>
<script>
    import Vue from "Vue";
    var NotePage = Vue.extend({
        name: "NotePage",
        props: {
            moduletype:{
                type:String,
                default:"0"
            }
        },
        data: function() {
            return {};
        },
        methods: {
            chkChange() {
                map.events.register('click', layer, mapLayerClick); // 注册标注点击事件
                markers.setVisibility(true)
            }
        },
        mounted: function() {
            this.$nextTick(function() {
                initDatas()
                if(this.moduletype == "1"){
                    noteDisabled()
                }
               
            });
        }
    });
    export default NotePage;
</script>

