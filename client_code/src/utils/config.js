const config = {
    get() {
        return {
            url : process.env.VUE_APP_BASE_API_URL + process.env.VUE_APP_BASE_API + '/',
            name: process.env.VUE_APP_BASE_API,
			menuList:[
				{
					name: '报考指南管理',
					icon: '',
					child:[

						{
							name:'报考指南',
							url:'/index/baokaozhinanList'
						},
					]
				},
				{
					name: '论坛交流',
					icon: '',
					child:[

						{
							name:'论坛交流',
							url:'/index/forumList'
						},
					]
				},
				{
					name: '考公资料管理',
					icon: '',
					child:[

						{
							name:'考公资料',
							url:'/index/kaoyanziliaoList'
						},
					]
				},
				{
					name: '新闻资讯管理',
					icon: '',
					child:[

						{
							name:'考公资讯',
							url:'/index/newsList'
						},
					]
				},
				{
					name: '购物中心管理',
					icon: '',
					child:[

						{
							name:'购物中心',
							url:'/index/cartList'
						},
					]
				},
			]
        }
    },
    getProjectName(){
        return {
            projectName: "高校考公咨询交流平台的设计"
        } 
    }
}
export default config
