<script setup>
import {Lock, User} from '@element-plus/icons-vue'
import {reactive, ref} from "vue";
import {useTokenStore} from "@/stores/token.js";
import {useRouter} from "vue-router";
import {apiUserLogin, apiUserWxLogin} from "@/api/user.js";
import {ElMessage} from "element-plus";

const loginData = ref({
  username: '',
  password: ''
})
const loginRef = ref()
const loginRules = ref({
  username: [
    { required: true, message: '请输入用户名', trigger: 'blur'}
  ],
  password: [
    { required: true, message: '请输入密码', trigger: 'blur'}
  ]
})

const router = useRouter()
const tokenStore = useTokenStore()
const arrTab = reactive(window.config.arrTab)

const login = async () => {
  if (!loginRef.value) return
  await loginRef.value.validate(async (valid) => {
    if (valid) {
      const result = await apiUserLogin(loginData.value)
      // 更新主页下方TabBar跳转路径
      arrTab.forEach((item)=>{
        if (item.tabPath === '/user/guest') {
          item.tabPath = '/user/user'
        }
      });
      tokenStore.setToken(result.data)
      await router.push('/user/user')
      ElMessage.success('登录成功')
    }
  })
}

const wxUse = ref(window.config.wxUse)

const wxLogin = async () => {
  const result = await apiUserWxLogin()
  // 更新主页下方TabBar跳转路径
  arrTab.forEach((item)=>{
    if (item.tabPath === '/user/guest') {
      item.tabPath = '/user/user'
    }
  });
  tokenStore.setToken(result.data)
  await router.push('/user/user')
  ElMessage.success('微信登录成功')
}
</script>

<template>
  <div class="user-guest">Guest</div>
  <el-form ref="loginRef" :rules="loginRules" :model="loginData">
    <el-form-item prop="username">
      <el-input :prefix-icon="User" placeholder="请输入用户名" v-model="loginData.username" @keydown.enter="login"/>
    </el-form-item>
    <el-form-item prop="password">
      <el-input :prefix-icon="Lock" type="password" placeholder="请输入密码" v-model="loginData.password" @keydown.enter="login"/>
    </el-form-item>
    <el-form-item>
      <el-button class="button" type="primary" auto-insert-space @click="login">登录</el-button>
      <el-button class="button" type="success" auto-insert-space @click="wxLogin" v-if="wxUse">微信快捷登录</el-button>
    </el-form-item>
  </el-form>
</template>

<style scoped>

</style>
