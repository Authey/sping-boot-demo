import axios from 'axios';
import {ElMessage} from 'element-plus';
import {useTokenStore} from '@/stores/token.js';
import router from '@/router';
import {reactive} from 'vue';

const baseURL = '/api/'
const instance = axios.create({ baseURL })


instance.interceptors.request.use(
    (config) => {
        const tokenStore = useTokenStore()
        if (tokenStore.token) {
            config.headers.Authorization = tokenStore.token
        }
        return config
    },
    (err) => {
        Promise.reject(err)
    }
)


const arrTab = reactive(window.config.arrTab)

instance.interceptors.response.use(
    result => {
        if (result.data.code === 1) {
            return result.data
        }
        ElMessage.error(result.data.message ? result.data.message : '服务异常')
        return Promise.reject(result.data)
    },
    err => {
        if (err.response.status === 401) {
            ElMessage.error('登录信息获取失败，请登录')
            // 更新主页下方TabBar高亮显示
            arrTab.forEach((item)=>{
                item.tabClass = item.tabPath === '/user/guest' ? 'tab-bar-item-active' : 'tab-bar-item';
            });
            router.push('/user/guest')
        } else {
            ElMessage.error('服务异常')
        }
        return Promise.reject(err)
    }
)


export default instance
