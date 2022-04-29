<template>
  <div id="app">
    <header>
<!--      //router-link 定义点击后导航到哪个路径下-->
      <router-link to="/upload">上传</router-link>
      <br>
      <br>
      <router-link to="/view">查看</router-link>
    </header>
<!--    //对应的组件内容渲染到router-view中-->
    <router-view></router-view>
<!--    <Upload msg="Welcome to Your Vue.js App"/>-->
<!--    <Picture msg="Welcome to Your Vue.js App"/>-->
  </div>
</template>

<script>
import Upload from './components/Upload.vue'
import Picture from './components/picture/Picture.vue'

export default {
  name: 'App',
  components: {
    Upload,
    Picture
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
