<template>
  <div class="home">
<!--    <div style="padding-bottom: 50px" >登录页面</div>-->

    <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm" style="display: inline-block;padding-top: 30px">
      <el-form-item label="用户名" prop="name">
        <el-input v-model.number="ruleForm.name"></el-input>
      </el-form-item>
      <el-form-item label="密码" prop="pass">
        <el-input type="password" v-model="ruleForm.pass" autocomplete="off"></el-input>
      </el-form-item>
<!--      <el-form-item label="确认密码" prop="checkPass">-->
<!--        <el-input type="password" v-model="ruleForm.checkPass" autocomplete="off"></el-input>-->
<!--      </el-form-item>-->

      <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
        <el-button @click="resetForm('ruleForm')">重置</el-button>
      </el-form-item>
    </el-form>



  </div>

</template>

<script src="./Login.js"></script>
<style src="./Login.css"></style>
