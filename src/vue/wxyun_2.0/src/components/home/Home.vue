<template>


  <div class="home">
    <header  style="background-color: #fff7f7;display: flex; height: 60px; ">
      <!--      //router-link 定义点击后导航到哪个路径下-->
      <router-link to="/home" class="route-xxx">首页</router-link>
      <router-link to="/upload" class="route-xxx">上传</router-link>
      <router-link to="/view" class="route-xxx">查看</router-link>
    </header>
    <router-view></router-view>
<!--    <div style="padding-bottom: 50px" >登录页面</div>-->

<!--    <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm" style="display: inline-block;padding-top: 30px">-->
<!--      <el-form-item label="用户名" prop="name">-->
<!--        <el-input v-model.number="ruleForm.name"></el-input>-->
<!--      </el-form-item>-->
<!--      <el-form-item label="密码" prop="pass">-->
<!--        <el-input type="password" v-model="ruleForm.pass" autocomplete="off"></el-input>-->
<!--      </el-form-item>-->
<!--&lt;!&ndash;      <el-form-item label="确认密码" prop="checkPass">&ndash;&gt;-->
<!--&lt;!&ndash;        <el-input type="password" v-model="ruleForm.checkPass" autocomplete="off"></el-input>&ndash;&gt;-->
<!--&lt;!&ndash;      </el-form-item>&ndash;&gt;-->

<!--      <el-form-item>-->
<!--        <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>-->
<!--        <el-button @click="resetForm('ruleForm')">重置</el-button>-->
<!--      </el-form-item>-->
<!--    </el-form>-->



  </div>

</template>

<script src="./Home.js"></script>
<style src="./Home.css"></style>
