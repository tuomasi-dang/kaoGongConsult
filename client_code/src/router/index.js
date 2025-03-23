import { createRouter, createWebHashHistory } from 'vue-router'
import index from '../views'
import home from '../views/pages/home.vue'
import login from '../views/pages/login.vue'
import newsList from '@/views/pages/news/list'
import forumList from '@/views/pages/forum/list'
import xueshengList from '@/views/pages/xuesheng/list'
import xueshengDetail from '@/views/pages/xuesheng/formModel'
import xueshengAdd from '@/views/pages/xuesheng/formAdd'
import xueshengRegister from '@/views/pages/xuesheng/register'
import xueshengCenter from '@/views/pages/xuesheng/center'
import kemuList from '@/views/pages/kemu/list'
import kemuDetail from '@/views/pages/kemu/formModel'
import kemuAdd from '@/views/pages/kemu/formAdd'
import baokaozhinanList from '@/views/pages/baokaozhinan/list'
import baokaozhinanDetail from '@/views/pages/baokaozhinan/formModel'
import baokaozhinanAdd from '@/views/pages/baokaozhinan/formAdd'
import storeupList from '@/views/pages/storeup/list'
import ziliaofenleiList from '@/views/pages/ziliaofenlei/list'
import ziliaofenleiDetail from '@/views/pages/ziliaofenlei/formModel'
import ziliaofenleiAdd from '@/views/pages/ziliaofenlei/formAdd'
import kaoyanziliaoList from '@/views/pages/kaoyanziliao/list'
import kaoyanziliaoDetail from '@/views/pages/kaoyanziliao/formModel'
import kaoyanziliaoAdd from '@/views/pages/kaoyanziliao/formAdd'
import cartList from '@/views/pages/shop_order/cart'
import addressList from '@/views/pages/shop_address/list'
import friendshipLinkList from '@/views/pages/friendshipLink/list'
import friendshipLinkDetail from '@/views/pages/friendshipLink/formModel'
import friendshipLinkAdd from '@/views/pages/friendshipLink/formAdd'
import order_confirm from '@/views/pages/shop_order/confirm'
import ordersList from '@/views/pages/shop_order/list'

const routes = [{
		path: '/',
		redirect: '/index/home'
	},
	{
		path: '/index',
		component: index,
		children: [{
			path: 'home',
			component: home
		}
		, {
			path: 'newsList',
			component: newsList
		}
		, {
			path: 'forumList',
			component: forumList
		}
		, {
			path: 'xueshengList',
			component: xueshengList
		}, {
			path: 'xueshengDetail',
			component: xueshengDetail
		}, {
			path: 'xueshengAdd',
			component: xueshengAdd
		}
		, {
			path: 'xueshengCenter',
			component: xueshengCenter
		}
		, {
			path: 'kemuList',
			component: kemuList
		}, {
			path: 'kemuDetail',
			component: kemuDetail
		}, {
			path: 'kemuAdd',
			component: kemuAdd
		}
		, {
			path: 'baokaozhinanList',
			component: baokaozhinanList
		}, {
			path: 'baokaozhinanDetail',
			component: baokaozhinanDetail
		}, {
			path: 'baokaozhinanAdd',
			component: baokaozhinanAdd
		}
        , {
            path: 'storeupList',
            component: storeupList
        }
		, {
			path: 'ziliaofenleiList',
			component: ziliaofenleiList
		}, {
			path: 'ziliaofenleiDetail',
			component: ziliaofenleiDetail
		}, {
			path: 'ziliaofenleiAdd',
			component: ziliaofenleiAdd
		}
		, {
			path: 'kaoyanziliaoList',
			component: kaoyanziliaoList
		}, {
			path: 'kaoyanziliaoDetail',
			component: kaoyanziliaoDetail
		}, {
			path: 'kaoyanziliaoAdd',
			component: kaoyanziliaoAdd
		}
		, {
			path: 'cartList',
			component: cartList
		}
		, {
			path: 'addressList',
			component: addressList
		}
		, {
			path: 'friendshipLinkList',
			component: friendshipLinkList
		}, {
			path: 'friendshipLinkDetail',
			component: friendshipLinkDetail
		}, {
			path: 'friendshipLinkAdd',
			component: friendshipLinkAdd
		}
		, {
			path: 'order_confirm',
			component: order_confirm
		}
		, {
			path: 'ordersList',
			component: ordersList
		}
		]
	},
	{
		path: '/login',
		component: login
	}
	,{
		path: '/xueshengRegister',
		component: xueshengRegister
	}
]

const router = createRouter({
  history: createWebHashHistory(process.env.BASE_URL),
  routes
})

export default router
