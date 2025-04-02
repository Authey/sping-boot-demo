<script setup>
import {apiHomeTest} from "@/api/home.js";
import {ElMessage} from "element-plus";

const test = async () => {
  const result = await apiHomeTest()
  ElMessage.success(result.data)
}
</script>

<template>
  <div class="home-index">Index</div>
  <el-button class="button" type="primary" auto-insert-space @click="test">测试</el-button>
</template>

<style scoped>

</style>
