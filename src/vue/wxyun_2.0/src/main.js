import Vue from 'vue'
import App from './App.vue'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css'
import router from './route/index'
import axios from 'axios'
import QS from 'qs'


Vue.prototype.$axios = axios;
Vue.prototype.qs = QS;
Vue.use(ElementUI)

Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App),
}).$mount('#app')
