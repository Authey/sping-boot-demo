<script setup>
import {Lock, User} from '@element-plus/icons-vue'
import {ref} from "vue";
import {useTokenStore} from "@/stores/token.js";
import {useRouter} from "vue-router";
import {apiUserLogin} from "@/api/user.js";
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
const login = async () => {
  if (!loginRef.value) return
  await loginRef.value.validate(async (valid) => {
    if (valid) {
      const result = await apiUserLogin(loginData.value)
      ElMessage.success('登录成功')
      tokenStore.setToken(result.data)
      await router.push('/user/user')
    }
  })
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
    </el-form-item>
  </el-form>
</template>

<style scoped>

</style>
