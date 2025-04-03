<script setup>
import {onMounted, reactive} from 'vue';
import {useRouter} from 'vue-router';

const router = new useRouter();

function onClick(tab) {
  const idx = arrTab.indexOf(tab)
  // 更新高亮显示
  for (let i = 0; i < arrTab.length; i++) {
    arrTab[i].tabClass = i === idx ? 'tab-bar-item-active' : 'tab-bar-item'
  }
  router.push({ path: tab.tabPath });
}

const arrTab = reactive(window.config.arrTab)

const props = defineProps(['path'])
onMounted(() => {
  arrTab.forEach((item)=>{
    if (item.tabPath === props.path){
      item.tabClass = "tab-bar-item-active";
    }
  });
})
</script>

<template>
  <div class="tab-bar">
    <template v-for="item in arrTab">
      <div class="tab-bar-comp" @click="onClick(item)">
        <i :class="item.tabClass + ' ' + item.tabIcon"/>
        <span :class="item.tabClass" style="font-size: 10px">{{ item.tabText }}</span>
      </div>
    </template>
  </div>
</template>

<style scoped>
.tab-bar {
  width: 100%;
  left: 0;
  bottom: 0;
  display: flex;
  position: fixed;
  padding: 5px 0;
  border-top: solid 1px #c0c0c0;
  flex-direction: row;
  justify-content: space-around;
}
.tab-bar-comp {
  text-align: center;
}
.tab-bar-item {
  display: flex;
  flex-direction: column;
  color: grey;
}
.tab-bar-item-active {
  display: flex;
  flex-direction: column;
  color: #0fc588;
}
</style>
