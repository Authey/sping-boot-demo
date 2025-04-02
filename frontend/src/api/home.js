import request from '@/utils/request.js'

export const apiHomeTest = params => {
    return request.post('/home/test', params)
}
