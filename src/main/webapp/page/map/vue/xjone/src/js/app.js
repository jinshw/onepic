'use strict';
var $ = require('jQuery');
import Vue from "Vue";
import VueRouter from 'vue-router'
import echarts from 'echarts'
import Home from './component/home/main.vue'
import store from './store/index.js'
import Counter from './component/home/Count.vue'
import BaseInfo from './component/baseinfo/main.vue'
import FundsMain from './component/progress/fundsMain.vue'
import ImageMain from './component/progress/imageMain.vue'
import InspectMain from './component/inspect/inspectMain.vue'
import EarlyWarning from './component/earlywarning/main.vue'
import ChartsMain from './component/charts/main.vue'
/*
var $ = require('jQuery');
var Vue = require('Vue');


import HelloWorld from './HelloWorld.vue'
import VueRouter from 'vue-router'
import Home from './component/home/main.vue'
import Header from './component/header/main.vue'
// var App = require('./App.vue')
// var router = require('./router')
*/


Vue.use(VueRouter)
// 全局引用echarts
Vue.prototype.$echarts = echarts

// const Home = { template: '<div>home</div>' }
// const Foo = { template: '<div>foo</div>' }
// const Bar = { template: '<div>bar</div>' }

//定义路由
const router = new VueRouter({
  base: __dirname,
  routes: [
    { path: '/', component: Home },
    { path: '/base', component: BaseInfo },
    { path: '/progress/funds', component: FundsMain },
    { path: '/progress/image', component: ImageMain },
    { path: '/inspect', component: InspectMain },
    { path: '/earlywarning', component: EarlyWarning },
    { path: '/charts', component: ChartsMain },
  ]
})

// Vue.config.debug = true
// new Vue({
//   el: "#app",
//   router,
//   store,
//   render: h => h(Home)
// })

new Vue({
  router,
  store
}).$mount('#app')
