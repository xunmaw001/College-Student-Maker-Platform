<template>
<div :style='{"width":"100%","padding":"40px 7%","margin":"0 auto","position":"relative","background":"none"}'>
    <el-form
      class="add-update-preview"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="150px"
    >
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px 0","alignItems":"center","background":"linear-gradient(90deg, rgba(238,177,238,1) 0%, rgba(165,228,222,1) 30%, rgba(165,228,222,1) 100%)","display":"flex"}' label="项目名称" prop="xiangmumingcheng">
            <el-input v-model="ruleForm.xiangmumingcheng" 
                placeholder="项目名称" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px 0","alignItems":"center","background":"linear-gradient(90deg, rgba(238,177,238,1) 0%, rgba(165,228,222,1) 30%, rgba(165,228,222,1) 100%)","display":"flex"}'  label="项目类别" prop="xiangmuleibie">
            <el-select v-model="ruleForm.xiangmuleibie" placeholder="请选择项目类别"  >
              <el-option
                  v-for="(item,index) in xiangmuleibieOptions"
                  :key="index"
                  :label="item"
                  :value="item">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px 0","alignItems":"center","background":"linear-gradient(90deg, rgba(238,177,238,1) 0%, rgba(165,228,222,1) 30%, rgba(165,228,222,1) 100%)","display":"flex"}' label="经费来源" prop="jingfeilaiyuan">
            <el-input v-model="ruleForm.jingfeilaiyuan" 
                placeholder="经费来源" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px 0","alignItems":"center","background":"linear-gradient(90deg, rgba(238,177,238,1) 0%, rgba(165,228,222,1) 30%, rgba(165,228,222,1) 100%)","display":"flex"}' label="教师工号" prop="jiaoshigonghao">
            <el-input v-model="ruleForm.jiaoshigonghao" 
                placeholder="教师工号" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px 0","alignItems":"center","background":"linear-gradient(90deg, rgba(238,177,238,1) 0%, rgba(165,228,222,1) 30%, rgba(165,228,222,1) 100%)","display":"flex"}' label="学生学号" prop="xueshengxuehao">
            <el-input v-model="ruleForm.xueshengxuehao" 
                placeholder="学生学号" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px 0","alignItems":"center","background":"linear-gradient(90deg, rgba(238,177,238,1) 0%, rgba(165,228,222,1) 30%, rgba(165,228,222,1) 100%)","display":"flex"}' label="学生姓名" prop="xueshengxingming">
            <el-input v-model="ruleForm.xueshengxingming" 
                placeholder="学生姓名" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px 0","alignItems":"center","background":"linear-gradient(90deg, rgba(238,177,238,1) 0%, rgba(165,228,222,1) 30%, rgba(165,228,222,1) 100%)","display":"flex"}' label="学院" prop="xueyuan">
            <el-input v-model="ruleForm.xueyuan" 
                placeholder="学院" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px 0","alignItems":"center","background":"linear-gradient(90deg, rgba(238,177,238,1) 0%, rgba(165,228,222,1) 30%, rgba(165,228,222,1) 100%)","display":"flex"}' label="专业" prop="zhuanye">
            <el-input v-model="ruleForm.zhuanye" 
                placeholder="专业" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px 0","alignItems":"center","background":"linear-gradient(90deg, rgba(238,177,238,1) 0%, rgba(165,228,222,1) 30%, rgba(165,228,222,1) 100%)","display":"flex"}' label="联系电话" prop="lianxidianhua">
            <el-input v-model="ruleForm.lianxidianhua" 
                placeholder="联系电话" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px 0","alignItems":"center","background":"linear-gradient(90deg, rgba(238,177,238,1) 0%, rgba(165,228,222,1) 30%, rgba(165,228,222,1) 100%)","display":"flex"}' label="提交时间" prop="tijiaoshijian" >
              <el-date-picker
                  value-format="yyyy-MM-dd HH:mm:ss"
                  v-model="ruleForm.tijiaoshijian" 
                  type="datetime"
                  placeholder="提交时间">
              </el-date-picker>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px 0","alignItems":"center","background":"linear-gradient(90deg, rgba(238,177,238,1) 0%, rgba(165,228,222,1) 30%, rgba(165,228,222,1) 100%)","display":"flex"}' label="结题答辩" prop="jietidabian">
            <file-upload
            tip="点击上传结题答辩"
            action="file/upload"
            :limit="1"
            :multiple="true"
            :fileUrls="ruleForm.jietidabian?ruleForm.jietidabian:''"
            @change="jietidabianUploadChange"
            ></file-upload>
          </el-form-item>  
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px 0","alignItems":"center","background":"linear-gradient(90deg, rgba(238,177,238,1) 0%, rgba(165,228,222,1) 30%, rgba(165,228,222,1) 100%)","display":"flex"}' label="小组成员" prop="xiaozuchengyuan">
            <el-input
              type="textarea"
              :rows="8"
              placeholder="小组成员"
              v-model="ruleForm.xiaozuchengyuan">
            </el-input>
          </el-form-item>

      <el-form-item :style='{"padding":"0","margin":"30px 0 20px 140px"}'>
        <el-button :style='{"border":"0","cursor":"pointer","padding":"0 10px","margin":"0 10px","color":"#fff","minWidth":"140px","outline":"none","borderRadius":"10px","background":"linear-gradient(90deg, rgba(32,173,158,1) 0%, rgba(138,228,219,1) 50%, rgba(32,173,158,1) 100%),#20ad9e","width":"auto","lineHeight":"44px","fontSize":"14px","height":"44px"}'  type="primary" @click="onSubmit">提交</el-button>
        <el-button :style='{"border":"0px solid rgba(64, 158, 255, 1)","cursor":"pointer","padding":"0 15px","margin":"0 10px","color":"#fff","minWidth":"140px","outline":"none","borderRadius":"10px","background":"linear-gradient(90deg, rgba(153,153,153,1) 0%, rgba(204,204,204,1) 50%, rgba(153,153,153,1) 100%),#999","width":"auto","lineHeight":"44px","fontSize":"14px","height":"44px"}' @click="back()">返回</el-button>
      </el-form-item>
    </el-form>
</div>
</template>

<script>
  export default {
    data() {
      return {
        id: '',
        baseUrl: '',
        ro:{
            xiangmumingcheng : false,
            xiangmuleibie : false,
            jingfeilaiyuan : false,
            jiaoshigonghao : false,
            xiaozuchengyuan : false,
            xueshengxuehao : false,
            xueshengxingming : false,
            xueyuan : false,
            zhuanye : false,
            lianxidianhua : false,
            tijiaoshijian : false,
            jietidabian : false,
            sfsh : false,
            shhf : false,
        },
        type: '',
        userTableName: localStorage.getItem('UserTableName'),
        ruleForm: {
          xiangmumingcheng: '',
          xiangmuleibie: '',
          jingfeilaiyuan: '',
          jiaoshigonghao: '',
          xiaozuchengyuan: '',
          xueshengxuehao: '',
          xueshengxingming: '',
          xueyuan: '',
          zhuanye: '',
          lianxidianhua: '',
          tijiaoshijian: '',
          jietidabian: '',
        },
        xiangmuleibieOptions: [],
        rules: {
          xiangmumingcheng: [
          ],
          xiangmuleibie: [
          ],
          jingfeilaiyuan: [
          ],
          jiaoshigonghao: [
          ],
          xiaozuchengyuan: [
          ],
          xueshengxuehao: [
          ],
          xueshengxingming: [
          ],
          xueyuan: [
          ],
          zhuanye: [
          ],
          lianxidianhua: [
          ],
          tijiaoshijian: [
          ],
          jietidabian: [
          ],
          sfsh: [
          ],
          shhf: [
          ],
        },
      };
    },
    computed: {



    },
    components: {
    },
    created() {
	  //this.bg();
      let type = this.$route.query.type ? this.$route.query.type : '';
      this.init(type);
      this.baseUrl = this.$config.baseUrl;
      this.ruleForm.tijiaoshijian = this.getCurDateTime()
    },
    methods: {
      getMakeZero(s) {
          return s < 10 ? '0' + s : s;
      },
      // 下载
      download(file){
        window.open(`${file}`)
      },
      // 初始化
      init(type) {
        this.type = type;
        if(type=='cross'){
          var obj = JSON.parse(localStorage.getItem('crossObj'));
          for (var o in obj){
            if(o=='xiangmumingcheng'){
              this.ruleForm.xiangmumingcheng = obj[o];
              this.ro.xiangmumingcheng = true;
              continue;
            }
            if(o=='xiangmuleibie'){
              this.ruleForm.xiangmuleibie = obj[o];
              this.ro.xiangmuleibie = true;
              continue;
            }
            if(o=='jingfeilaiyuan'){
              this.ruleForm.jingfeilaiyuan = obj[o];
              this.ro.jingfeilaiyuan = true;
              continue;
            }
            if(o=='jiaoshigonghao'){
              this.ruleForm.jiaoshigonghao = obj[o];
              this.ro.jiaoshigonghao = true;
              continue;
            }
            if(o=='xiaozuchengyuan'){
              this.ruleForm.xiaozuchengyuan = obj[o];
              this.ro.xiaozuchengyuan = true;
              continue;
            }
            if(o=='xueshengxuehao'){
              this.ruleForm.xueshengxuehao = obj[o];
              this.ro.xueshengxuehao = true;
              continue;
            }
            if(o=='xueshengxingming'){
              this.ruleForm.xueshengxingming = obj[o];
              this.ro.xueshengxingming = true;
              continue;
            }
            if(o=='xueyuan'){
              this.ruleForm.xueyuan = obj[o];
              this.ro.xueyuan = true;
              continue;
            }
            if(o=='zhuanye'){
              this.ruleForm.zhuanye = obj[o];
              this.ro.zhuanye = true;
              continue;
            }
            if(o=='lianxidianhua'){
              this.ruleForm.lianxidianhua = obj[o];
              this.ro.lianxidianhua = true;
              continue;
            }
            if(o=='tijiaoshijian'){
              this.ruleForm.tijiaoshijian = obj[o];
              this.ro.tijiaoshijian = true;
              continue;
            }
            if(o=='jietidabian'){
              this.ruleForm.jietidabian = obj[o];
              this.ro.jietidabian = true;
              continue;
            }
          }
        }
        // 获取用户信息
        this.$http.get(this.userTableName + '/session', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            var json = res.data.data;
            if((json.xueshengxuehao!=''&&json.xueshengxuehao) || json.xueshengxuehao==0){
                this.ruleForm.xueshengxuehao = json.xueshengxuehao
            }
            if((json.xueshengxingming!=''&&json.xueshengxingming) || json.xueshengxingming==0){
                this.ruleForm.xueshengxingming = json.xueshengxingming
            }
            if((json.xueyuan!=''&&json.xueyuan) || json.xueyuan==0){
                this.ruleForm.xueyuan = json.xueyuan
            }
            if((json.zhuanye!=''&&json.zhuanye) || json.zhuanye==0){
                this.ruleForm.zhuanye = json.zhuanye
            }
            if((json.lianxidianhua!=''&&json.lianxidianhua) || json.lianxidianhua==0){
                this.ruleForm.lianxidianhua = json.lianxidianhua
            }
          }
        });
        this.$http.get('option/xiangmuleibie/xiangmuleibie', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.xiangmuleibieOptions = res.data.data;
          }
        });
      },

    // 多级联动参数
      // 多级联动参数
      info(id) {
        this.$http.get('jietidabian/detail/${id}', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.ruleForm = res.data.data;
          }
        });
      },
      // 提交
      onSubmit() {

        //更新跨表属性
        var crossuserid;
        var crossrefid;
        var crossoptnum;
        this.$refs["ruleForm"].validate(valid => {
          if(valid) {
            if(this.type=='cross'){
                 var statusColumnName = localStorage.getItem('statusColumnName');
                 var statusColumnValue = localStorage.getItem('statusColumnValue');
                 if(statusColumnName && statusColumnName!='') {
                     var obj = JSON.parse(localStorage.getItem('crossObj'));
                     if(!statusColumnName.startsWith("[")) {
                         for (var o in obj){
                             if(o==statusColumnName){
                                 obj[o] = statusColumnValue;
                             }
                         }
                         var table = localStorage.getItem('crossTable');
                         this.$http.post(table+'/update', obj).then(res => {});
                     } else {
                            crossuserid=Number(localStorage.getItem('userid'));
                            crossrefid=obj['id'];
                            crossoptnum=localStorage.getItem('statusColumnName');
                            crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
                     }
                 }
            }
            if(crossrefid && crossuserid) {
                 this.ruleForm.crossuserid=crossuserid;
                 this.ruleForm.crossrefid=crossrefid;
                 var params = {
                     page: 1,
                     limit: 10,
                     crossuserid:crossuserid,
                     crossrefid:crossrefid,
                 }
                 this.$http.get('jietidabian/list', {
                  params: params
                 }).then(res => {
                     if(res.data.data.total>=crossoptnum) {
                         this.$message({
                          message: localStorage.getItem('tips'),
                          type: 'success',
                          duration: 1500,
                         });
                          return false;
                     } else {
                         // 跨表计算


                          this.$http.post('jietidabian/add', this.ruleForm).then(res => {
                              if (res.data.code == 0) {
                                  this.$message({
                                      message: '操作成功',
                                      type: 'success',
                                      duration: 1500,
                                      onClose: () => {
                                          this.$router.go(-1);
                                      }
                                  });
                              } else {
                                  this.$message({
                                      message: res.data.msg,
                                      type: 'error',
                                      duration: 1500
                                  });
                              }
                          });
                     }
                 });
             } else {


                  this.$http.post('jietidabian/add', this.ruleForm).then(res => {
                     if (res.data.code == 0) {
                          this.$message({
                              message: '操作成功',
                              type: 'success',
                              duration: 1500,
                              onClose: () => {
                                  this.$router.go(-1);
                              }
                          });
                      } else {
                          this.$message({
                              message: res.data.msg,
                              type: 'error',
                              duration: 1500
                          });
                      }
                  });
             }
          }
        });
      },
      // 获取uuid
      getUUID () {
        return new Date().getTime();
      },
      // 返回
      back() {
        this.$router.go(-1);
      },
      jietidabianUploadChange(fileUrls) {
          this.ruleForm.jietidabian = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");;
      },
    }
  };
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  padding: 0 15px;
	  color: #992298;
	  font-weight: 500;
	  width: 150px;
	  font-size: 15px;
	  line-height: 40px;
	  text-align: right;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 150px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  border: 0;
	  border-radius: 0;
	  padding: 0 10px;
	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  outline: none;
	  color: #333;
	  background: #fff;
	  width: 360px;
	  font-size: 14px;
	  line-height: 32px;
	  height: 32px;
	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  border: 0;
	  border-radius: 0;
	  padding: 0 30px 0 10px;
	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  outline: none;
	  color: #333;
	  background: #fff;
	  width: 320px;
	  font-size: 14px;
	  line-height: 32px;
	  height: 32px;
	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  border: 0;
	  border-radius: 0;
	  padding: 0 10px 0 30px;
	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  outline: none;
	  color: #333;
	  background: #fff;
	  width: 400px;
	  font-size: 14px;
	  line-height: 32px;
	  height: 32px;
	}
	
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview /deep/ .upload .upload-img {
	  border: 1px dashed #992298;
	  cursor: pointer;
	  border-radius: 6px;
	  color: #992298;
	  width: 100px;
	  font-size: 32px;
	  line-height: 100px;
	  text-align: center;
	  height: 100px;
	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  border: 1px dashed #992298;
	  cursor: pointer;
	  border-radius: 6px;
	  color: #992298;
	  width: 100px;
	  font-size: 32px;
	  line-height: 100px;
	  text-align: center;
	  height: 100px;
	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  border: 1px dashed #992298;
	  cursor: pointer;
	  border-radius: 6px;
	  color: #992298;
	  width: 100px;
	  font-size: 32px;
	  line-height: 100px;
	  text-align: center;
	  height: 100px;
	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  border: 0;
	  border-radius: 0;
	  padding: 12px;
	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  outline: none;
	  color: #333;
	  width: 400px;
	  font-size: 14px;
	  height: 120px;
	}
</style>
