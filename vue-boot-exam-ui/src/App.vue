<template>
  <div id="app">

    <el-button v-if="$route.path==='/'" v-show="show" id="e1" type="primary" v-model="loading"
               :loading="loading" @click="func1()">进入系统</el-button>
    <router-view></router-view>
  </div>
</template>

<script>

export default {
  name: 'App',
  data(){
    return{
      loading:false,
      show:true
    }
  },
  methods:{
    func1:function(){
      var nthis=this; //保存this对象
      nthis.loading = true;

      setTimeout(function () {
         nthis.loading = false;
         nthis.show = false;
         nthis.$router.push('/exam')
      },800);

    }
  }
}

</script>
