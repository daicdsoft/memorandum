<template>
  <div id="app">

<!--    //对应的组件内容渲染到router-view中-->
    <router-view></router-view>
<!--    <Upload msg="Welcome to Your Vue.js App"/>-->
<!--    <Picture msg="Welcome to Your Vue.js App"/>-->
  </div>
</template>

<script>
import Upload from './components/Upload.vue'
import Picture from './components/picture/Picture.vue'
import Home from './components/home/Home.vue'
import Login from './components/login/Login.vue'
import axois from './http/http.js'

export default {
  name: 'App',
  components: {
    Upload,
    Picture,
    Home,
    Login
  },
  data() {
    return {
    }
  },
  mounted() {
    // 关闭浏览器执行退出接口--
    // onUnload方法是在关闭窗口之后执行
    // onbeforeUnload方法是在关闭窗口之前执行
    window.addEventListener('beforeunload', e => this.beforeunloadHandler(e))
    window.addEventListener('unload', e => this.unloadHandler(e))
  },
  destroyed() {
    // 关闭浏览器执行退出接口
    window.removeEventListener('beforeunload', e => this.beforeunloadHandler(e))
    window.removeEventListener('unload', e => this.unloadHandler(e))
  },
  methods: {
    // 关闭窗口之前执行
    async beforeunloadHandler(e) {
      await this.clearLogin() // 退出登录接口
      // this._beforeUnload_time = new Date().getTime()
      // console.log('this._beforeUnload_time：', this._beforeUnload_time)
      window.close()
    },
    // 关闭窗口之后执行--暂时用不到
    unloadHandler() {
    },
    // 退出登录接口
    clearLogin(e){
      axois.postWithNoParam("user/loginOut").then(x => {
        console.log("login out")
        console.log(x)
      })
    }
  }
}
</script>

<style>
#app {
  /*font-family: Avenir, Helvetica, Arial, sans-serif;*/
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;

  font-family: "Helvetica Neue",Helvetica,"PingFang SC","Hiragino Sans GB","Microsoft YaHei","微软雅黑",Arial,sans-serif;
}
.body{
  width: 100%;
  height: 100%;
  padding: 0;
  margin: 0;
  height: 100vh;
}
.app, .home{
  height: 100vh;
}
.route-xxx{
  min-width: 100px!important;
  padding-top: 20px;
  font-size: 18px;
  font-weight: 600;
}
</style>
