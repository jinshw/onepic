<template>
  <nav class="navbar headerWrap" role="navigation"
     style="height: 50px;  padding-right:30px; background: #0B61A4;">
    <div class="container-fluid">
        <div class="navbar-header">
            <!-- <router-link to="/" class="navbar-brand" style="margin-left: 10px;">
                新疆公路建设指挥平台
            </router-link> -->
            <a href="home.html#/" class="navbar-brand" style="margin-left: 10px;">
                新疆公路建设指挥平台
            </a>
        </div>
        <div>
            <ul class="nav navbar-nav  navbar-right">
                <li class="active">
                    <router-link to="/base">基本建设信息查询</router-link>
                    <!-- <a v-on:click="linkTo()" >基本建设信息查询</a> -->
                </li>
                <li class="dropdown">
                    <a href="#" id="jdgl" class="dropdown-toggle" data-toggle="dropdown">
                        进度管理
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li>
                             <!-- <router-link to="/progress/funds">
                                资金进度管理
                             </router-link> -->
                            <a v-on:click="linkTo($event)" data-type="zjjd" >
                                资金进度管理
                            </a>
                        </li>
                        <!-- <li><a href="#" id="jdjdBt">形像进度管理</a></li> -->
                        <li>
                            <!-- <router-link to="/progress/image">形像进度管理</router-link> -->
                            <a v-on:click="linkTo($event)" data-type="xxjd">
                                形像进度管理
                            </a>
                        </li>
                    </ul>
                </li>
                <li>
                    <!-- <a href="#" id="yxBT">影像核查</a> -->
                    <router-link id="yxBT" to="/inspect">影像核查</router-link>
                </li>
                <li class="dropdown">
                    <!-- <a href="#" id="jdhcId" class="dropdown-toggle" data-toggle="dropdown"> -->
                        <!--进度核查-->
                        <!-- 预警管理 -->
                    <!-- </a> -->
                    <router-link class="dropdown-toggle" data-toggle="dropdown" id="jdhcId" to="/earlywarning">预警管理</router-link>
                </li>
                <li class="dropdown">
                    <!-- <a href="home.html#/charts" class="dropdown-toggle" data-toggle="dropdown" id="tjgnBT">
                        统计功能
                    </a> -->
                    <!-- <router-link class="dropdown-toggle" data-toggle="dropdown" id="tjgnBT" to="/charts">统计功能</router-link> -->
                    <a href="home.html#/charts" class="dropdown-toggle">统计功能</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
</template>

<script>
var Vue = require("Vue");
var $ = require("jQuery");
import jQuery from "jQuery";
import layer from "../../library/layer-v2.3/layer.js";
import "../../library/layer-v2.3/skin/layer.css";

import bootstrap from "../../library/bootstrap-3.3.7-dist/js/bootstrap.min.js";
import "../../library/bootstrap-3.3.7-dist/css/bootstrap.min.css";
import "../../../css/xjone.css";

var Header = Vue.extend({
  name: "Header",
  data: function() {
    return {
      name: "vue 222"
    };
  },
  methods: {
    getContent: function() {
      alert("GGGG");
    },
    linkTo: function(e) {
      var _nodes = getSelectedNodes();
      var _type = e.currentTarget.dataset.type;
      if (
        _nodes.length > 0 &&
        _nodes[0].id != 1 &&
        _nodes[0].id != 11 &&
        _nodes[0].id != 12 &&
        _nodes[0].id != 13
      ) {
        if (_type == "zjjd") {
          this.$router.push("/progress/funds");
        } else if (_type == "xxjd") {
          this.$router.push("/progress/image");
        }
      } else {
        layer.msg("请选择一条公路后再点击");
      }
    }
  },
  mounted: function() {
    //注意 mounted 不会承诺所有的子组件也都一起被挂载。如果你希望等到整个视图都渲染完毕，可以用 vm.$nextTick 替换掉 mounted：
    this.$nextTick(function() {
      // 需要xjone-map-all.js 全部加载完成后才执行
      // // setTimeout(function(){
      //     var nodes = getSelectedNodes()
      //     console.log("ztree selected:",nodes.length)
      // // },3000)
    });
  }
});

module.exports = Header;
</script>

