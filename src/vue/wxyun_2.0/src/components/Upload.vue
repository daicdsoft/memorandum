<template>
  <div>
    <div style="padding-bottom: 50px" >图片上传</div>
    <el-upload
        action="http://127.0.0.1:8881/api/picture/upload"
        list-type="picture-card"
        name="file"
        :on-preview="handlePictureCardPreview"
        :on-remove="handleRemove">
      <i class="el-icon-plus"></i>
    </el-upload>
    <el-dialog :visible.sync="dialogVisible">
      <img width="100%" :src="dialogImageUrl" alt="">
    </el-dialog>
    <div style="padding-top: 12px">
      <el-button> 取消</el-button>

      <el-button> 确认上传</el-button>
    </div>

  </div>

</template>

<script src="./Upload.js"></script>
<style src="./Upload.css"></style>
