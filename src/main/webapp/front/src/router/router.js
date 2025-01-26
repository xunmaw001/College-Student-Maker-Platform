import VueRouter from 'vue-router'

//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import Storeup from '../pages/storeup/list'
import News from '../pages/news/news-list'
import NewsDetail from '../pages/news/news-detail'
import xueshengList from '../pages/xuesheng/list'
import xueshengDetail from '../pages/xuesheng/detail'
import xueshengAdd from '../pages/xuesheng/add'
import jiaoshiList from '../pages/jiaoshi/list'
import jiaoshiDetail from '../pages/jiaoshi/detail'
import jiaoshiAdd from '../pages/jiaoshi/add'
import youxiuxiangmuList from '../pages/youxiuxiangmu/list'
import youxiuxiangmuDetail from '../pages/youxiuxiangmu/detail'
import youxiuxiangmuAdd from '../pages/youxiuxiangmu/add'
import xiangmuleibieList from '../pages/xiangmuleibie/list'
import xiangmuleibieDetail from '../pages/xiangmuleibie/detail'
import xiangmuleibieAdd from '../pages/xiangmuleibie/add'
import xiangmushenqingList from '../pages/xiangmushenqing/list'
import xiangmushenqingDetail from '../pages/xiangmushenqing/detail'
import xiangmushenqingAdd from '../pages/xiangmushenqing/add'
import chuqidabianList from '../pages/chuqidabian/list'
import chuqidabianDetail from '../pages/chuqidabian/detail'
import chuqidabianAdd from '../pages/chuqidabian/add'
import zhongqidabianList from '../pages/zhongqidabian/list'
import zhongqidabianDetail from '../pages/zhongqidabian/detail'
import zhongqidabianAdd from '../pages/zhongqidabian/add'
import jietidabianList from '../pages/jietidabian/list'
import jietidabianDetail from '../pages/jietidabian/detail'
import jietidabianAdd from '../pages/jietidabian/add'
import jietipingjiaList from '../pages/jietipingjia/list'
import jietipingjiaDetail from '../pages/jietipingjia/detail'
import jietipingjiaAdd from '../pages/jietipingjia/add'
import zhaoshangyinziList from '../pages/zhaoshangyinzi/list'
import zhaoshangyinziDetail from '../pages/zhaoshangyinzi/detail'
import zhaoshangyinziAdd from '../pages/zhaoshangyinzi/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'storeup',
					component: Storeup
				},
				{
					path: 'news',
					component: News
				},
				{
					path: 'newsDetail',
					component: NewsDetail
				},
				{
					path: 'xuesheng',
					component: xueshengList
				},
				{
					path: 'xueshengDetail',
					component: xueshengDetail
				},
				{
					path: 'xueshengAdd',
					component: xueshengAdd
				},
				{
					path: 'jiaoshi',
					component: jiaoshiList
				},
				{
					path: 'jiaoshiDetail',
					component: jiaoshiDetail
				},
				{
					path: 'jiaoshiAdd',
					component: jiaoshiAdd
				},
				{
					path: 'youxiuxiangmu',
					component: youxiuxiangmuList
				},
				{
					path: 'youxiuxiangmuDetail',
					component: youxiuxiangmuDetail
				},
				{
					path: 'youxiuxiangmuAdd',
					component: youxiuxiangmuAdd
				},
				{
					path: 'xiangmuleibie',
					component: xiangmuleibieList
				},
				{
					path: 'xiangmuleibieDetail',
					component: xiangmuleibieDetail
				},
				{
					path: 'xiangmuleibieAdd',
					component: xiangmuleibieAdd
				},
				{
					path: 'xiangmushenqing',
					component: xiangmushenqingList
				},
				{
					path: 'xiangmushenqingDetail',
					component: xiangmushenqingDetail
				},
				{
					path: 'xiangmushenqingAdd',
					component: xiangmushenqingAdd
				},
				{
					path: 'chuqidabian',
					component: chuqidabianList
				},
				{
					path: 'chuqidabianDetail',
					component: chuqidabianDetail
				},
				{
					path: 'chuqidabianAdd',
					component: chuqidabianAdd
				},
				{
					path: 'zhongqidabian',
					component: zhongqidabianList
				},
				{
					path: 'zhongqidabianDetail',
					component: zhongqidabianDetail
				},
				{
					path: 'zhongqidabianAdd',
					component: zhongqidabianAdd
				},
				{
					path: 'jietidabian',
					component: jietidabianList
				},
				{
					path: 'jietidabianDetail',
					component: jietidabianDetail
				},
				{
					path: 'jietidabianAdd',
					component: jietidabianAdd
				},
				{
					path: 'jietipingjia',
					component: jietipingjiaList
				},
				{
					path: 'jietipingjiaDetail',
					component: jietipingjiaDetail
				},
				{
					path: 'jietipingjiaAdd',
					component: jietipingjiaAdd
				},
				{
					path: 'zhaoshangyinzi',
					component: zhaoshangyinziList
				},
				{
					path: 'zhaoshangyinziDetail',
					component: zhaoshangyinziDetail
				},
				{
					path: 'zhaoshangyinziAdd',
					component: zhaoshangyinziAdd
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
	]
})
