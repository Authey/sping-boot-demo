<script setup>
import {useTokenStore} from "@/stores/token.js";

const tokenStore = useTokenStore()
</script>

<template>
  <div class="tab-bar">
    <router-link to="/home/index" class="tab-item" active-class="active">首页</router-link>
    <router-link to="/user/guest" class="tab-item" active-class="active" v-if="tokenStore.token === ''">我的</router-link>
    <router-link to="/user/user" class="tab-item" active-class="active" v-else>我的</router-link>
  </div>
</template>

<style scoped>

</style>
