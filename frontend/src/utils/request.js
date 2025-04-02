import axios from "axios";
import {ElMessage} from "element-plus";
import {useTokenStore} from "@/stores/token.js";
import router from "@/router";

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
            ElMessage.error('请先登录')
            router.push('/user/guest')
        } else {
            ElMessage.error('服务异常')
        }
        return Promise.reject(err)
    }
)


export default instance
