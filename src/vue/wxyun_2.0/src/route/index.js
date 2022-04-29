import Vue from 'vue'
import Router from 'vue-router'
import upload from "@/components/Upload.vue";
import picture from "@/components/picture/Picture.vue";


Vue.use(Router)
// const originalPush = Router.prototype.push
// Router.prototype.push = function push (location) {
//     return originalPush.call(this, location).catch(err => err)
// }
export default new Router({
//去掉url上的#
    mode: 'history',
    routes: [{
        path: '/upload',
        name: 'upload',
        component: upload
    },
        {
            path: '/view',
            name: 'view',
            component: picture,
            // children: [{
            //     path: '/Vehicleinformation',
            //     name: 'Vehicleinformation',
            //     component: resolve => require(['../views/home/Vehicleinformation'], resolve)
            // },
            //     {
            //         path: '/Vehiclerental',
            //         name: 'Vehiclerental',
            //         component: resolve => require(['../views/home/Vehiclerental'], resolve)
            //     },
            //     {
            //         path: '/',
            //         name: 'homepage',
            //         component: resolve => require(['../views/home/homepage'], resolve)
            //     }, {
            //         path: '/video',
            //         name: 'video',
            //         component: resolve => require(['../views/home/video.vue'], resolve)
            //     }
            // ]
        }]
})