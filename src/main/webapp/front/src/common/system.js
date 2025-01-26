export function isAuth(tableName, key) {
  let role = localStorage.getItem("UserTableName");
  let menus = [{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-copy","buttons":["新增","查看","修改","删除"],"menu":"学生","menuJump":"列表","tableName":"xuesheng"}],"menu":"学生管理"},{"child":[{"appFrontIcon":"cuIcon-skin","buttons":["新增","查看","修改","删除"],"menu":"教师","menuJump":"列表","tableName":"jiaoshi"}],"menu":"教师管理"},{"child":[{"appFrontIcon":"cuIcon-attentionfavor","buttons":["新增","查看","修改","删除","查看评论"],"menu":"优秀项目","menuJump":"列表","tableName":"youxiuxiangmu"}],"menu":"优秀项目管理"},{"child":[{"appFrontIcon":"cuIcon-time","buttons":["新增","查看","修改","删除"],"menu":"项目类别","menuJump":"列表","tableName":"xiangmuleibie"}],"menu":"项目类别管理"},{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["查看","修改","删除"],"menu":"项目申请","menuJump":"列表","tableName":"xiangmushenqing"}],"menu":"项目申请管理"},{"child":[{"appFrontIcon":"cuIcon-newshot","buttons":["查看","修改","删除"],"menu":"初期答辩","menuJump":"列表","tableName":"chuqidabian"}],"menu":"初期答辩管理"},{"child":[{"appFrontIcon":"cuIcon-vipcard","buttons":["查看","修改","删除"],"menu":"中期答辩","menuJump":"列表","tableName":"zhongqidabian"}],"menu":"中期答辩管理"},{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["查看","修改","删除"],"menu":"结题答辩","menuJump":"列表","tableName":"jietidabian"}],"menu":"结题答辩管理"},{"child":[{"appFrontIcon":"cuIcon-explore","buttons":["查看","修改","删除"],"menu":"结题评价","menuJump":"列表","tableName":"jietipingjia"}],"menu":"结题评价管理"},{"child":[{"appFrontIcon":"cuIcon-attentionfavor","buttons":["新增","查看","修改","删除","查看评论"],"menu":"招商引资","menuJump":"列表","tableName":"zhaoshangyinzi"}],"menu":"招商引资管理"},{"child":[{"appFrontIcon":"cuIcon-clothes","buttons":["查看","修改"],"menu":"轮播图管理","tableName":"config"},{"appFrontIcon":"cuIcon-news","buttons":["新增","查看","修改","删除"],"menu":"创新创业政策","tableName":"news"},{"appFrontIcon":"cuIcon-service","buttons":["新增","查看","修改","删除"],"menu":"问题反馈","tableName":"chat"},{"appFrontIcon":"cuIcon-discover","buttons":["查看","修改"],"menu":"关于我们","tableName":"aboutus"},{"appFrontIcon":"cuIcon-shop","buttons":["查看","修改"],"menu":"系统简介","tableName":"systemintro"}],"menu":"系统管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-addressbook","buttons":["查看","查看评论","项目申请"],"menu":"优秀项目列表","menuJump":"列表","tableName":"youxiuxiangmu"}],"menu":"优秀项目模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"管理员","tableName":"users"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["查看","删除","修改","初期答辩"],"menu":"项目申请","menuJump":"列表","tableName":"xiangmushenqing"}],"menu":"项目申请管理"},{"child":[{"appFrontIcon":"cuIcon-newshot","buttons":["查看","删除","中期答辩","修改"],"menu":"初期答辩","menuJump":"列表","tableName":"chuqidabian"}],"menu":"初期答辩管理"},{"child":[{"appFrontIcon":"cuIcon-vipcard","buttons":["查看","修改","删除","结题答辩"],"menu":"中期答辩","menuJump":"列表","tableName":"zhongqidabian"}],"menu":"中期答辩管理"},{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["查看","修改","删除"],"menu":"结题答辩","menuJump":"列表","tableName":"jietidabian"}],"menu":"结题答辩管理"},{"child":[{"appFrontIcon":"cuIcon-explore","buttons":["查看"],"menu":"结题评价","menuJump":"列表","tableName":"jietipingjia"}],"menu":"结题评价管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-addressbook","buttons":["查看","查看评论","项目申请"],"menu":"优秀项目列表","menuJump":"列表","tableName":"youxiuxiangmu"}],"menu":"优秀项目模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"是","hasFrontRegister":"是","roleName":"学生","tableName":"xuesheng"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-attentionfavor","buttons":["新增","查看","修改","删除","查看评论"],"menu":"优秀项目","menuJump":"列表","tableName":"youxiuxiangmu"}],"menu":"优秀项目管理"},{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["查看","删除","审核"],"menu":"项目申请","menuJump":"列表","tableName":"xiangmushenqing"}],"menu":"项目申请管理"},{"child":[{"appFrontIcon":"cuIcon-newshot","buttons":["查看","删除","审核"],"menu":"初期答辩","menuJump":"列表","tableName":"chuqidabian"}],"menu":"初期答辩管理"},{"child":[{"appFrontIcon":"cuIcon-vipcard","buttons":["查看","删除","审核"],"menu":"中期答辩","menuJump":"列表","tableName":"zhongqidabian"}],"menu":"中期答辩管理"},{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["查看","删除","审核","评分"],"menu":"结题答辩","menuJump":"列表","tableName":"jietidabian"}],"menu":"结题答辩管理"},{"child":[{"appFrontIcon":"cuIcon-explore","buttons":["查看","修改","删除"],"menu":"结题评价","menuJump":"列表","tableName":"jietipingjia"}],"menu":"结题评价管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-addressbook","buttons":["查看","查看评论","项目申请"],"menu":"优秀项目列表","menuJump":"列表","tableName":"youxiuxiangmu"}],"menu":"优秀项目模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"教师","tableName":"jiaoshi"}];
  for(let i=0;i<menus.length;i++){
    if(menus[i].tableName==role){
      for(let j=0;j<menus[i].frontMenu.length;j++){
          for(let k=0;k<menus[i].frontMenu[j].child.length;k++){
            if(tableName==menus[i].frontMenu[j].child[k].tableName){
              let buttons = menus[i].frontMenu[j].child[k].buttons.join(',');
              return buttons.indexOf(key) !== -1 || false
            }
          }
      }
    }
  }
  return false;
}

/**
 *  * 获取当前时间（yyyy-MM-dd hh:mm:ss）
 *   */
export function getCurDateTime() {
    let currentTime = new Date(),
    year = currentTime.getFullYear(),
    month = currentTime.getMonth() + 1 < 10 ? '0' + (currentTime.getMonth() + 1) : currentTime.getMonth() + 1,
    day = currentTime.getDate() < 10 ? '0' + currentTime.getDate() : currentTime.getDate(),
    hour = currentTime.getHours(),
    minute = currentTime.getMinutes(),
    second = currentTime.getSeconds();
    return year + "-" + month + "-" + day + " " +hour +":" +minute+":"+second;
}

/**
 *  * 获取当前日期（yyyy-MM-dd）
 *   */
export function getCurDate() {
    let currentTime = new Date(),
    year = currentTime.getFullYear(),
    month = currentTime.getMonth() + 1 < 10 ? '0' + (currentTime.getMonth() + 1) : currentTime.getMonth() + 1,
    day = currentTime.getDate() < 10 ? '0' + currentTime.getDate() : currentTime.getDate();
    return year + "-" + month + "-" + day;
}
