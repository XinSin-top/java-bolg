<template>
    <v-md-editor
        v-model="text"
        :disabled-menus="[]"
        height="800px"
        @upload-image="handleUploadImage"
        left-toolbar="undo redo clear | h bold italic strikethrough quote | ul ol table hr | link image code | save | tip | emoji"
        @save="saveText" />
</template>

<script>
//使用组件化重构
//还有点问题待解决
export default {
  name: "MdEditor",
  props:{
    text:String,
  },
  emits:{
    handleUploadImage:"upload-img",
    saveText:'save'
  }
}
</script>

<style scoped>

</style>