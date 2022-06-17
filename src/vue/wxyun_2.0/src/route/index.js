import Vue from 'vue'
import Router from 'vue-router'
import upload from "@/components/Upload.vue";
import picture from "@/components/picture/Picture.vue";
import home from "@/components/home/Home.vue";
import login from "@/components/login/Login.vue";


Vue.use(Router)
// const originalPush = Router.prototype.push
// Router.prototype.push = function push (location) {
//     return originalPush.call(this, location).catch(err => err)
// }
const router = new Router({
//去掉url上的#
//     mode: 'history',
    routes: [
        // {
        //     path:'/',
        //     name:'login',
        //     redirect:login
        // },
        {
            path:'/',
            name:'login',
            component:login
        },
        {
            path: '/home',
            name: 'home',
            component: home,
            children:[{
                path: '/upload',
                name: 'upload',
                component: upload
            },
                {
                    path: '/view',
                    name: 'view',
                    component: picture,
                },]
        },

        ]
})

router.beforeEach((to, from, next) => {
    console.log("route to", to.path);
    if ("这里判断是不是开发环境") {
        //开发环境下，直接路由
        next();
    } else {
        if (to.path === "/") {
            //登录页面
            next(`/login`);
        } else {
            next();
        }
    }
});

export default router