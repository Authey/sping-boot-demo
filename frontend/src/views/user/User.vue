<script setup>
import {useRouter} from "vue-router";
import {useTokenStore} from "@/stores/token.js";
import {apiUserLogout} from "@/api/user.js";
import {ElMessage} from "element-plus";

const router = useRouter()
const tokenStore = useTokenStore()
const logout = async () => {
  await apiUserLogout()
  ElMessage.success('退出成功')
  tokenStore.removeToken()
  await router.push('/user/guest')
}
</script>

<template>
  <div class="user-user">User</div>
  <el-button class="button" type="danger" auto-insert-space @click="logout">退出</el-button>
</template>

<style scoped>

</style>
