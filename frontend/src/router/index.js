import {createRouter, createWebHistory} from "vue-router";

import Layout from '@/views/Layout.vue'
import Home from '@/views/home/Index.vue'
import Guest from '@/views/user/Guest.vue'
import User from '@/views/user/User.vue'

const routes = [
    {
        path: '/',
        redirect: '/home/index',
        component: Layout,
        children:[
            {
                path: '/home/index',
                name: 'home-index',
                component: Home,
                meta: {
                    title: '主页'
                }
            },
            {
                path: '/user/guest',
                name: 'user-guest',
                component: Guest,
                meta: {
                    title: '游客'
                }
            },
            {
                path: '/user/user',
                name: 'user-user',
                component: User,
                meta: {
                    title: '用户'
                }
            }
        ]
    }
]

const router = createRouter({
    history: createWebHistory(),
    routes: routes
})

export default router
