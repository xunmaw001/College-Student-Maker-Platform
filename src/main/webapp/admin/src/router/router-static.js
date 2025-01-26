import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import news from '@/views/modules/news/list'
    import aboutus from '@/views/modules/aboutus/list'
    import xuesheng from '@/views/modules/xuesheng/list'
    import xiangmushenqing from '@/views/modules/xiangmushenqing/list'
    import youxiuxiangmu from '@/views/modules/youxiuxiangmu/list'
    import zhaoshangyinzi from '@/views/modules/zhaoshangyinzi/list'
    import jiaoshi from '@/views/modules/jiaoshi/list'
    import jietipingjia from '@/views/modules/jietipingjia/list'
    import chuqidabian from '@/views/modules/chuqidabian/list'
    import xiangmuleibie from '@/views/modules/xiangmuleibie/list'
    import systemintro from '@/views/modules/systemintro/list'
    import chat from '@/views/modules/chat/list'
    import discusszhaoshangyinzi from '@/views/modules/discusszhaoshangyinzi/list'
    import discussyouxiuxiangmu from '@/views/modules/discussyouxiuxiangmu/list'
    import zhongqidabian from '@/views/modules/zhongqidabian/list'
    import jietidabian from '@/views/modules/jietidabian/list'
    import config from '@/views/modules/config/list'


//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '系统首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '系统首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
      ,{
	path: '/news',
        name: '创新创业政策',
        component: news
      }
      ,{
	path: '/aboutus',
        name: '关于我们',
        component: aboutus
      }
      ,{
	path: '/xuesheng',
        name: '学生',
        component: xuesheng
      }
      ,{
	path: '/xiangmushenqing',
        name: '项目申请',
        component: xiangmushenqing
      }
      ,{
	path: '/youxiuxiangmu',
        name: '优秀项目',
        component: youxiuxiangmu
      }
      ,{
	path: '/zhaoshangyinzi',
        name: '招商引资',
        component: zhaoshangyinzi
      }
      ,{
	path: '/jiaoshi',
        name: '教师',
        component: jiaoshi
      }
      ,{
	path: '/jietipingjia',
        name: '结题评价',
        component: jietipingjia
      }
      ,{
	path: '/chuqidabian',
        name: '初期答辩',
        component: chuqidabian
      }
      ,{
	path: '/xiangmuleibie',
        name: '项目类别',
        component: xiangmuleibie
      }
      ,{
	path: '/systemintro',
        name: '系统简介',
        component: systemintro
      }
      ,{
	path: '/chat',
        name: '问题反馈',
        component: chat
      }
      ,{
	path: '/discusszhaoshangyinzi',
        name: '招商引资评论',
        component: discusszhaoshangyinzi
      }
      ,{
	path: '/discussyouxiuxiangmu',
        name: '优秀项目评论',
        component: discussyouxiuxiangmu
      }
      ,{
	path: '/zhongqidabian',
        name: '中期答辩',
        component: zhongqidabian
      }
      ,{
	path: '/jietidabian',
        name: '结题答辩',
        component: jietidabian
      }
      ,{
	path: '/config',
        name: '轮播图管理',
        component: config
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '系统首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
   return originalPush.call(this, location).catch(err => err)
}
export default router;
