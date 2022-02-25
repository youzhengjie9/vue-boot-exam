<template>

  <div>

    <el-container>
      <el-header>
        <el-button type="success" round :plain="true" @click="drawQuestion">抽取题目</el-button>
        <el-button type="success" round :plain="true" @click="init">初始化题库</el-button>
      </el-header>
      <el-main>
        <h3>抽取的题目如下：</h3>
        <h3 id="tm">666888</h3>
      </el-main>
    </el-container>

  </div>

</template>

<script>
    export default {
        name: "Exam",
        methods: {
          init() {
            this.$message({
              message: '初始化题库成功',
              type: 'success',
              duration:2200 //关闭时间
            });
          },
          drawQuestion:function () {
            this.axios
              .get('http://localhost:5123/exam/getQuestion')
              .then(function (response) {
                console.log(response)
              })
          }
      }
    }
</script>

<style scoped>

</style>
