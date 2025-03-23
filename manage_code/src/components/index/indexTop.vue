<template>
	<div class="top_view">
		<div class="top_left_view">
			<div class="fold_view" @click="toggleClick" :class="{'is_collapse':collapse}">
				<el-icon class="icons">
					<Fold v-if="!collapse" />
					<Expand v-else />
				</el-icon>
			</div>
		</div>

		<div class="projectTitle">高校考公咨询交流平台的设计</div>
		<div class="top_right_view">
			<el-dropdown class="avatar-container" trigger="hover">
				<div class="avatar-wrapper">
					<div class="nickname">欢迎 {{$toolUtil.storageGet('adminName')}}</div>
					<img class="user-avatar" :src="store.getters['user/avatar']">
					<el-icon class="el-icon-arrow-down">
						<arrow-down />
					</el-icon>
				</div>
				<template #dropdown>
					<el-dropdown-menu class="user-dropDown" slot="dropdown">
						<el-dropdown-item class="center" @click="centerClick" >
							个人中心
						</el-dropdown-item>
						<el-dropdown-item class="password" @click="updatepasswordClick">
							修改密码
						</el-dropdown-item>
						<el-dropdown-item class="front">
							<span style="display:block;" @click="frontClick">系统前台</span>
						</el-dropdown-item>
						<el-dropdown-item class="loginOut">
							<span style="display:block;" @click="onLogout">退出登录</span>
						</el-dropdown-item>
					</el-dropdown-menu>
				</template>
			</el-dropdown>
		</div>
		<div class="breadcrumb-view">
			<el-breadcrumb separator="—">
				<el-breadcrumb-item v-for="(item,index) in breadcrumbList" :key="item.path">
					<i class="iconfont icon-zhuye2" v-if="!index"></i>
					<span @click="router.push(item.path)">{{item.name}}</span>
				</el-breadcrumb-item>
			</el-breadcrumb>
		</div>
	</div>
</template>

<script setup>
	import axios from 'axios'
    import moment from "moment"
	import {
		ElMessageBox
	} from 'element-plus'
	import {
		toRefs,
		defineEmits,
		getCurrentInstance,
		ref,
		onBeforeUnmount,
		computed,
	} from 'vue';

	import {
		useRouter,
		useRoute
	} from 'vue-router';
	const router = useRouter()
	const context = getCurrentInstance()?.appContext.config.globalProperties;
	const emit = defineEmits(['collapseChange'])
	const role = context?.$toolUtil.storageGet('sessionTable')
	const roleName = context?.$toolUtil.storageGet('role')
	const route = useRoute()
	let breadcrumbList = computed(()=>{
		let arr = route.matched.map(item=>({
			name:item.name,
			path:item.path
		}))
		return arr[arr.length-1].path=='/'?[arr[0]]:arr
	})

	const props = defineProps({
		collapse: Boolean
	})
	const {collapse} = toRefs(props)

	//获取用户信息
	import { useStore } from 'vuex'
	const store = useStore()
	const user = computed(()=>store.getters['user/session'])
	const avatar = ref(store.state.user.avatar)
	if(!store.state.user.session.id){
		store.dispatch('user/getSession')
	}
	const toggleClick = () => {
		emit('collapseChange')
	}
	// 退出登录
	const onLogout = () => {
		let toolUtil = context?.$toolUtil
		store.dispatch('delAllCachedViews')
		store.dispatch('delAllVisitedViews')
		toolUtil.storageClear()
		router.replace({
			name: "login"
		});
	}
	// 跳转前台
	const frontClick = () => {
        window.open(`${context.$config.url}client/index.html#/index/home`,'_blank')
	}
	// 个人中心
	const centerClick = () => {
		router.push(`/${role}Center`)
	}
	// 修改密码
	const updatepasswordClick = () => {
		router.push(`/updatepassword`)
	}
</script>

<style lang="scss" scoped>
	// 总盒子
	.top_view {
		// 左边盒子
		.top_left_view {
			display: none;
			// 折叠按钮盒子
			.fold_view {
				// 图标
				.icons {
				}
			}
		}
		// 标题
		.projectTitle{
		}
		// 右部盒子
		.top_right_view{
			// 头像盒子
			.avatar-container {
				cursor: pointer;
				margin: 0 30px 0 0;
				color: #fff;
				display: flex;
				align-items: center;
				height: 50px;
				.avatar-wrapper {
					margin: 5px 0 0;
					display: flex;
					position: relative;
					align-items: center;
					// 昵称
					.nickname {
						cursor: pointer;
						margin: 0 5px;
						color: #fff;
						line-height: 44px;
					}
					// 头像
					.user-avatar {
						cursor: pointer;
						border-radius: 10px;
						width: 40px;
						height: 40px;
					}
					// 图标
					.el-icon-arrow-down {
						color: #fff;
					}
				}
			}
		}
	}
	// 下拉盒子
	.el-dropdown-menu{
		background: #fff;
		// 下拉盒子itme
		:deep(.el-dropdown-menu__item){
			color: #fff;
			background: #123;
		}
		// item悬浮
		:deep(.el-dropdown-menu__item:hover){
			color: #333;
			background: #ff0;
		}
	}
</style>
<style>
/*总盒子*/
.top_view{
    height: 100px;
    width: calc(100% - 17px);
    display: flex;
    align-items: center;
    justify-content: center;
    position: fixed;
    left: 0px;
    top: 0px;
    z-index: 9;
    padding: 0px;
    border-width: 0px;
    border-style: solid;
    border-color: rgb(221, 245, 206);
    background: url(http://clfile.zggen.cn/20241105/4bb40042bd0b4b93be040fbda44d4322.webp);
    background-size: 100% 100%;
}
/*标题*/
.top_view .projectTitle{
    font-size: 18px;
    margin: 0px;
    padding: 10px;
    line-height: 1.5em;
    font-weight: 400;
    color: #fff;
    order: 1;
    background: #fff;
    color: #000;
    margin-left: 10px;
    height: calc(100% - 20px);
    margin-top: 20px;
    width: 208px;
    display: flex;
    justify-content: center;
    align-items: center;
}

/*左边盒子*/
.top_view .top_left_view{
    width: auto;
    display: none;
    height: 100%;
    align-items: center;
}
/*折叠按钮*/
.top_view .top_left_view .fold_view{
    display: flex;
    padding: 0px;
    margin: 0px 0px 0px 222px;
    background: rgb(139, 92, 126);
    border-radius: 50%;
    width: 32px;
    height: 32px;
    align-items: center;
    justify-content: center;
 }
.top_view .top_left_view .fold_view:hover {
    background:#fa9fa4;
 }
/*图标*/
.top_view .top_left_view .fold_view .icons{
    font-size: 24px;
    color: rgb(255, 255, 255);
}

/*系统公告*/
.top_view .notice-btn{
    padding: 0 16px;
    margin-right:20px;
    line-height: 50px;
    font-size: 14px;
    color: #333;
    order: 3;
    height: 100%;
    border: none;
    background: none;
    color: #000;
}
.top_view .notice-btn:hover{
    color:#fff; 
}
.top_view .notice-btn .iconfont{
    font-size: 16px;
}

/*右边盒子 横排*/
.top_view .top_right_view{
    width: auto;
    height: 100%;
    display: flex;
    align-items: center;
    justify-content: flex-end;
    order: 4;
    margin-right: 0;
    padding-left: 20px;
    background-image: url(http://clfile.zggen.cn/20241105/83664769c2c2424595613bed616aaa59.png);
    background-size: 100% 100%;
    margin-left: auto;
 }
.top_view .top_right_view .actionBar{ }
.top_view .top_right_view .actionBar .item { float:left; margin-right:20px; margin-bottom:5px; font-size:16px; color:#8b5c7e; font-weight:500;  }
.top_view .top_right_view .actionBar .item:hover { color:#fff; cursor:pointer;  }
.top_view .top_right_view .actionBar .item i { font-size:18px; }

.top_view .user-info{
    position:absolute;
    left:20px;
    display: flex;
    align-items: center;
}
.top_view .user-info .img-wrapper{
    margin-right:10px;
}
.top_view .user-info .img-wrapper .user-avatar{
    width:50px;
}
.top_view .user-info .nickname{
    font-size:16px;
    color:#fff; 
}


.top_view .weather {
    order: 2;
    display: flex;
    white-space: nowrap;
    line-height: 80px;
    column-gap: 4px;
    padding-left: 20px;
    color: #000;
}

.top_view img.user-avatar {
    width: 40px;
    height: 40px;
    border-radius: 50%;
}

.top_view .avatar-wrapper {
    display: flex;
    align-items: center;
}

.top_view .nickname {
    white-space: nowrap;
    margin-right: 6px;
}

.top_view .nowDate {
    order: 2;
    white-space: nowrap;
    margin: 0 20px;
    padding-left: 20px;
    line-height: 80px;
    color: #000;
}

.top_view .breadcrumb-view {
    position: fixed;
    top: 110px;
    background: none;
    width: calc(100% - 240px - 17px);
    left: 240px;
    height: 36px;
    display: flex;
    align-items: center;
    padding: 0 20px;
    border-bottom: 0px solid;
}

.top_view .breadcrumb-view:before {
    position: absolute;
    content: '';
    width: 539px;
    height: 35px;
    z-index: -1;
    left: 0px;
    top: 0;
    border-right: 36px solid transparent;
    border-bottom: 36px solid #3775BB;
    border-left: 539px solid #3775BB;
    box-sizing: border-box;
}

.top_view .el-breadcrumb {
    display: flex;
    align-items: center;
    color: #fff;
}

.top_view .breadcrumb-view i.iconfont {
    color: inherit!important;
}

.top_view .el-breadcrumb_inner {}
.top_view .el-breadcrumb__inner {
    color: inherit!important;
}
</style>