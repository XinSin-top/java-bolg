<template>
  <el-container>
    <el-header>

    </el-header>
    <el-main>
      123
      <v-md-preview :text="text">123</v-md-preview>
    </el-main>
  </el-container>
</template>

<script>
import {onMounted, ref} from "vue";
import {selectArticleUUID} from "@/axios/request";
import {useRoute} from "vue-router";

export default {
  name: "ArticleInfo",
  setup(){
    const text = ref("");
    const router = useRoute();

    const update = async () => {
      text.value = (await selectArticleUUID(router.params.uuid).then()).data.data.article;
    }

    onMounted(() =>{
      update();
    })

    return{
      text,
    }
  }
}
</script>

<style scoped>

</style>