<!--
组件名称：设置开关组件
参数：父组件组件需要传递参数
    config{
        jdhc: true,// 预警标注线路：true选中，false未选中
        scanPicInfo: false,//查看影像变化信息
        projectInfo: false,
        yxhcInfo: true,
        jdhcDisplay: 'none',//预警标注线路:none隐藏，display显示
        scanPicInfoDisplay: 'none',
        projectInfoDisplay: 'none',
        yxhcInfoDisplay: 'none',
    }
-->
<template>
    <!--设置页面-->
    <div class="config-page">
        <div class="config-bt" v-on:click="configBTClick" id="configBT" style="position: absolute;z-index: 10002;bottom: 20px;right: 20px;font-size: 36px;cursor: pointer;">
            <i class="fa fa-cog" aria-hidden="true"></i>
        </div>
        <div class="config-page-container" v-bind:style="{display:configPageDisplay}"
            v-on:mouseleave="mouseleave">
            <div class="config-page-content" style="width: 240px;height: auto;
                                    position: absolute;bottom: 20px;right: 30px;z-index: 10002;
                                    background-color: #313d4f;color: #ffffff;">
                <ul class="list-group">
                    <li class="list-group-item" :style="{display:config.jdhcDisplay}">
                        <label><input type="checkbox" data-type="jdhc"  
                            v-model="config.jdhc" v-on:change="inputChange($event)"> 
                            预警标注线路开关
                        </label>
                    </li>
                    <li class="list-group-item" :style="{display:config.scanPicInfoDisplay}">
                        <label><input type="checkbox" data-type="scanPicInfo" 
                            v-model="config.scanPicInfo" v-on:change="inputChange($event)"> 
                            查看影像变化信息
                            </label>
                    </li>
                    <li class="list-group-item" :style="{display:config.projectInfoDisplay}">
                        <label><input type="checkbox" data-type="projectInfo" 
                            v-model="config.projectInfo" v-on:change="inputChange($event)"> 
                            项目基本信息
                            </label>
                    </li>
                    
                    <li class="list-group-item" :style="{display:config.yxhcInfoDisplay}">
                        <label><input type="checkbox" data-type="yxhcInfo" 
                            v-model="config.yxhcInfo" v-on:change="inputChange($event)"> 
                            影像核查信息
                            </label>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</template>
<script>
    import Vue from "Vue";
    var SetPage = Vue.extend({
        name: "SetPage",
        props: {
            config: {
                type: Object,
            }
        },
        data: function() {
            return {
                configPageDisplay: "none"
            };
        },
        methods: {
            configBTClick: function() {
                this.configPageDisplay = "block";
            },
            inputChange: function(event) {
                console.log(event.currentTarget);
                var _type = event.currentTarget.dataset.type;
                if (_type == "jdhc") {
                    if (this.config.jdhc) {
                        layerJSJD.setVisibility(true);
                        layerJSJDTWD.setVisibility(true);
                    } else {
                        layerJSJD.setVisibility(false);
                        layerJSJDTWD.setVisibility(false);
                    }
                } else if (_type == "scanPicInfo") {
                    if (this.config.scanPicInfo) {
                        drawPointLayer();
                    } else {
                        deactiveAll();
                    }
                } else if (_type == "projectInfo") {
                    if (this.config.projectInfo) {
                        // 项目基本信息显示
                    } else {
                        // 项目基本信息隐藏
                    }
                } else if (_type == "yxhcInfo") {
                    if (this.config.yxhcInfo) {
                        // 影像信息显示
                    } else {
                        // 影像信息隐藏
                    }
                }
            },
            mouseleave:function(event){
                this.configPageDisplay = "none"
            }
        },
        mounted: function() {
            this.$nextTick(function() {
            });
        }
    });
    export default SetPage;
</script>

