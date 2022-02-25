import Vue from 'vue'
//导入路由插件
import VueRouter from 'vue-router'
//导入上面定义的组件
import Exam from "../views/Exam";

//安装路由
Vue.use(VueRouter);

//配置路由
export default new VueRouter({
  routes: [
    {
      //路由路径
      path: '/exam',
      //路由名称
      name: 'exam',
      //跳转到组件
      component:Exam
    }
  ]
});
