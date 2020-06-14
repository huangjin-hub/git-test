import Vue from 'vue'
import VueRouter from 'vue-router'

import Content from '../components/Content'
import Main from '../components/Main'

Vue.use(VueRouter)

export default new VueRouter({
  routes:[
    {
      path:'/content',
      name:'content',
      component:Content
    },
    {
      path:'/main',
      name:'main',
      component:Main
    }
  ]

});
