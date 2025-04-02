<script setup>
import TabBar from "@/components/TabBar.vue";
</script>

<template>
  <div id="app-container" class="app-container">
    <div id="app-main" class="app-main">
      <router-view></router-view>
      <tab-bar></tab-bar>
    </div>
  </div>
</template>

<style scoped>

</style>
