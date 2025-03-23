	import {
		createRouter,
		createWebHashHistory
	} from 'vue-router'
	import news from '@/views/news/list'
	import ziliaofenlei from '@/views/ziliaofenlei/list'
	import address from '@/views/address/list'
	import xuesheng from '@/views/xuesheng/list'
	import discusskaoyanziliao from '@/views/discusskaoyanziliao/list'
	import kaoyanziliao from '@/views/kaoyanziliao/list'
	import storeup from '@/views/storeup/list'
	import users from '@/views/users/list'
	import kemu from '@/views/kemu/list'
	import forum from '@/views/forum/list'
	import discussbaokaozhinan from '@/views/discussbaokaozhinan/list'
	import baokaozhinan from '@/views/baokaozhinan/list'
	import chat from '@/views/chat/list'
	import orders from '@/views/orders/list'
	import config from '@/views/config/list'
	import usersCenter from '@/views/users/center'

export const routes = [{
		path: '/login',
		name: 'login',
		component: () => import('../views/login.vue')
	},{
		path: '/',
		name: '首页',
		component: () => import('../views/index'),
		children: [{
			path: '/',
			name: '首页',
			component: () => import('../views/HomeView.vue'),
			meta: {
				affix: true
			}
		}, {
			path: '/updatepassword',
			name: '修改密码',
			component: () => import('../views/updatepassword.vue')
		}
		
		,{
			path: '/usersCenter',
			name: '管理员个人中心',
			component: usersCenter
		}
		,{
			path: '/news',
			name: '考公资讯',
			component: news
		}
		,{
			path: '/ziliaofenlei',
			name: '资料分类',
			component: ziliaofenlei
		}
		,{
			path: '/address',
			name: '地址',
			component: address
		}
		,{
			path: '/xuesheng',
			name: '学生',
			component: xuesheng
		}
		,{
			path: '/discusskaoyanziliao',
			name: '考公资料评论-评论',
			component: discusskaoyanziliao
		}
		,{
			path: '/kaoyanziliao',
			name: '考公资料',
			component: kaoyanziliao
		}
		,{
			path: '/storeup',
			name: '我的收藏',
			component: storeup
		}
		,{
			path: '/users',
			name: '管理员',
			component: users
		}
		,{
			path: '/kemu',
			name: '科目',
			component: kemu
		}
		,{
			path: '/forum',
			name: '我的发布',
			component: forum
		}
		,{
			path: '/discussbaokaozhinan',
			name: '报考指南评论-评论',
			component: discussbaokaozhinan
		}
		,{
			path: '/baokaozhinan',
			name: '报考指南',
			component: baokaozhinan
		}
		,{
			path: '/chat',
			name: '管理员聊天',
			component: chat
		}
		,{
			path: '/orders',
			name: '订单管理',
			component: orders
		}
		,{
			path: '/config',
			name: '轮播图',
			component: config
		}
		]
	},
]

const router = createRouter({
	history: createWebHashHistory(process.env.BASE_URL),
	routes
})

export default router
