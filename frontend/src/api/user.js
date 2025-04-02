import request from '@/utils/request.js'

export const apiUserLogin = params => {
    return request.post('/user/login', params)
}

export const apiUserLogout = params => {
    return request.post('/user/logout', params)
}
