<template>

  <div>

    <el-container>
      <el-header>
        <el-button type="success" round :plain="true" @click="drawQuestion">抽取题目</el-button>
        <el-button type="success" round :plain="true" @click="init">初始化题库</el-button>
      </el-header>
      <el-main>
        <h3>抽取的题目如下：</h3>
        <h3 id="tm">{{question}}</h3>
      </el-main>
    </el-container>

  </div>

</template>

<script>
    export default {
        name: "Exam",
        data(){
          return{
            question:'请点击抽取题目！'
          }
        },
        methods: {
          init() {
            var nthis=this;
            this.axios
              .get('http://localhost:5123/exam/init')
              .then(function (response) {
                nthis.$message({
                  message: response.data,
                  type: 'success',
                  duration:2200 //关闭时间
                });
              }).catch(function (error){
              nthis.$message({
                message: "初始化题库失败",
                type: 'error',
                duration:2200 //关闭时间
              });
            })
          },
          drawQuestion:function () {
            var nthis=this;
            this.axios
              .get('http://localhost:5123/exam/getQuestion')
              .then(function (response) {
                nthis.question=response.data;
              }).catch(function (error){
              nthis.$message({
                message: "抽取题目失败",
                type: 'error',
                duration:2200 //关闭时间
              });
            })
          }
      }
    }
</script>

<style scoped>

</style>
