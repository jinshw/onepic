import Vue from 'vue'
import Router from 'vue-router'
import Home from '../component/home/main.vue'

// var Vue = require('vue'); 
// var Router = require('vue-router')
// var Home = require('@/components/home/main.vue') 

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home
    }
  ]
})
