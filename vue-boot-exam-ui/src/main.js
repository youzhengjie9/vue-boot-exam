// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import axios from 'axios'
import VueAxios from 'vue-axios'
import App from "./App";

//路由配置
import router from "./router";

Vue.use(router)
//使用elementui插件
Vue.use(ElementUI)

//axios
Vue.use(VueAxios, axios)


new Vue({

  el:'#app',
  router,
  render: h => h(App)
})

