<template>
  <el-container>
    <el-header>
dasdasd
    </el-header>
    <el-main>
      <v-md-editor
          v-model="text"
          height="800px"
          :disabled-menus="[]"
          @upload-image="handleUploadImage"
      >

      </v-md-editor>
    </el-main>
  </el-container>
</template>

<script>
import {ref} from "vue";

export default {
  setup(){
    const text = ref("");
    
    // eslint-disable-next-line no-unused-vars
    const handleUploadImage = (event, insertImage, files) => {

    }

    return{
      text,
      handleUploadImage
    }
  }
}
</script>

<style scoped>

</style>