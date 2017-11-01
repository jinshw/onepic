<template>
  <nav class="navbar headerWrap" role="navigation"
     style="height: 50px;  padding-right:30px; background: #0B61A4;">
    <div class="container-fluid">
        <div class="navbar-header">
            <router-link to="/" class="navbar-brand" style="margin-left: 10px;">
                新疆公路建设指挥平台
            </router-link>
        </div>
        <div>
            <ul class="nav navbar-nav  navbar-right">
                <li class="active">
                    <router-link to="/base">基本建设信息查询</router-link>
                </li>
                <li class="dropdown">
                    <a href="#" id="jdgl" class="dropdown-toggle" data-toggle="dropdown">
                        进度管理
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li>
                             <router-link to="/progress/funds">
                            <!-- <a href="#" id="zjjdBt"> -->
                                资金进度管理
                            <!-- </a> -->
                             </router-link>
                        </li>
                        <!-- <li><a href="#" id="jdjdBt">形像进度管理</a></li> -->
                        <li>
                            <router-link to="/progress/image">形像进度管理</router-link>
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
                    <!-- <a href="#" id="tjgnBT" class="dropdown-toggle" data-toggle="dropdown">
                        统计功能
                    </a> -->
                    <router-link class="dropdown-toggle" data-toggle="dropdown" id="tjgnBT" to="/charts">统计功能</router-link>
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
    }
  }
});

module.exports = Header;
</script>

