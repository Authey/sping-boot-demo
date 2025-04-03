<script setup>
import {useRouter} from "vue-router";
import {useTokenStore} from "@/stores/token.js";
import {apiUserLogout} from "@/api/user.js";
import {ElMessage} from "element-plus";
import {reactive} from "vue";

const router = useRouter()
const tokenStore = useTokenStore()
const arrTab = reactive(window.config.arrTab)

const logout = async () => {
  await apiUserLogout()
  // 更新主页下方TabBar跳转路径
  arrTab.forEach((item)=>{
    if (item.tabPath === '/user/user') {
      item.tabPath = '/user/guest'
    }
  });
  tokenStore.removeToken()
  await router.push('/user/guest')
  ElMessage.success('退出成功')
}
</script>

<template>
  <div class="user-user">User</div>
  <el-button class="button" type="danger" auto-insert-space @click="logout">退出</el-button>
</template>

<style scoped>

</style>
