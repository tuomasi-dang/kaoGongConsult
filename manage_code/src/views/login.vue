<template>
	<div>
		<div class="login_view">
			<el-form :model="loginForm" class="login_form">
				<div class="title_view">高校考公咨询交流平台的设计登录</div>
				<div class="tabView" v-if="userList.length>1">
					<div class="tab" :style="{'width':`calc(100% / ${userList.length})`}"
						:class="loginForm.role==item.roleName?'tabActive':''" v-for="(item,index) in userList"
						:key="index" @click="tabClick(item.roleName)">{{item.roleName}}</div>
				</div>
				<div class="list_item" v-if="loginType==1">
					<div class="list_label">
						账号：
					</div>
					<input class="list_inp" v-model="loginForm.username" placeholder="请输入账号" name="username" />
				</div>
				<div class="list_item" v-if="loginType==1">
					<div class="list_label">
						密码：
					</div>
					<input class="list_inp" v-model="loginForm.password" type="password" placeholder="请输入密码" @keydown.enter.native="handleLogin"  />
				</div>
				<div class="btn_view">
					<el-button class="login" v-if="loginType==1" type="success" @click="handleLogin">登录</el-button>
				</div>
			</el-form>
		</div>
	</div>
</template>
<script setup>
	import {
		ref,
		getCurrentInstance,
		nextTick,
		onMounted,
	} from "vue";
	import { useStore } from 'vuex'
	const store = useStore()
	const userList = ref([])
	const menus = ref([])
	const loginForm = ref({
		role: '',
		username: '',
		password: ''
	})
	const tableName = ref('')
	const loginType = ref(1)
	const context = getCurrentInstance()?.appContext.config.globalProperties;
	//登录用户tab切换
	const tabClick = (role) => {
		loginForm.value.role = role
		
	}
	const handleLogin = () => {
		if (!loginForm.value.username) {
			context?.$toolUtil.message('请输入用户名', 'error')
			
			return;
		}
		if (!loginForm.value.password) {
			context?.$toolUtil.message('请输入密码', 'error')
			return;
		}
		if (userList.value.length > 1) {
			if (!loginForm.value.role) {
				context?.$toolUtil.message('请选择角色', 'error')
				verifySlider.value.reset()
				return;
			}
			for (let i = 0; i < menus.value.length; i++) {
				if (menus.value[i].roleName == loginForm.value.role) {
					tableName.value = menus.value[i].pathName||menus.value[i].tableName;
				}
			}
		} else {
			tableName.value = userList.value[0].pathName||userList.value[0].tableName;
			loginForm.value.role = userList.value[0].roleName;
		}
		login()
	}
	const login = () => {
		context?.$http({
			url: `${tableName.value}/login?username=${loginForm.value.username}&password=${loginForm.value.password}`,
			method: 'post'
		}).then(res => {
			context?.$toolUtil.storageSet("Token", res.data.token);
			context?.$toolUtil.storageSet("role", loginForm.value.role);
			context?.$toolUtil.storageSet("sessionTable", tableName.value);
			context?.$toolUtil.storageSet("adminName", loginForm.value.username);
			store.dispatch('user/getSession')	//vuex中获取用户信息并保存
			context?.$router.push('/')
		}, err => {
		})
	}
	//获取菜单
	const getMenu=()=> {
      let params = {
        page: 1,
        limit: 1,
        sort: 'id',
      }

      context?.$http({
        url: "menu/list",
        method: "get",
        params: params
      }).then(res => {
          menus.value = JSON.parse(res.data.data.list[0].menujson)
          for (let i = 0; i < menus.value.length; i++) {
            if (menus.value[i].hasBackLogin=='是') {
              userList.value.push(menus.value[i])
            }
          }
			loginForm.value.role = userList.value[0].roleName
          context?.$toolUtil.storageSet("menus", JSON.stringify(menus.value));
      })
    }
	//初始化
	const init = () => {
		getMenu();
	}
	onMounted(()=>{
		init()
		
document.querySelector('.login_view').insertAdjacentHTML('beforeend',`<div id="particles-js" class="diy-bg" style="width: 100vw;height: 100vh;position: fixed;top: 0;left: 0;"><canvas class="particles-js-canvas-el" style="width:100%;height:100%;"></canvas></div>`)
const script = document.createElement('script');
script.src = 'https://cdn.bootcdn.net/ajax/libs/particles.js/2.0.0/particles.min.js';
script.onload = () => {
  // script加载后执行
  particlesJS("particles-js",{
    particles: {
      number: {
        value: 120,
        density: {
          value_area: 500
        }
      },
      size: {
        value: 1,
        random: true,
        anim: {
          speed: 20,
          size_min: .1,
          sync: false
        }
      },
      line_linked: {
        enable: true,
        distance: 40,
        color: "#fff",
        opacity: 1,
        width: 2
      },
    },
  });
};
document.head.appendChild(script);
	})
</script>

<style lang="scss" scoped>
	.login_view {
        background-image: url("");
		// 表单盒子
		.login_form {
		}
		.title_view {
		}
		// item盒子
		.list_item {
			// label
			.list_label {
			}
			// 输入框
			.list_inp {
			}
		}
		// 用户类型样式
		.tabView{
			// 默认样式
			.tab{
			}
			// 选中样式
			.tabActive{
			}
		}
		// 按钮盒子
		.btn_view {
			// 登录
			.login {
			}
		}
	}

</style>
<style>
.login_view {
    min-height: 100vh;
    position: relative;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    background-position: center center;
    background-size: 100% 100% !important;
    background-repeat: no-repeat;
    background-attachment: initial;
    background-origin: initial;
    background-clip: initial;
    background-color: initial;
    background: linear-gradient(0deg, #249BEF, #7CC9FF)!important;
}

/*表单盒子*/
.login_form{width:500px;margin:0 auto;padding:30px 50px 40px 50px;font-size:16px;-webkit-transform:scale(1);z-index:5;background: rgba(255,255,255,0.5);border-radius: 10px 10px 10px 10px;border: 2px solid #FFFFFF;}

/*标题*/
.login_form .title_view{width:100%;float:left;line-height:46px;font-size:24px;font-weight:600;letter-spacing:2px;color: var(--theme);position:relative;margin-bottom:20px;text-align: center;}

/*list_item*/
.login_form .list_item{display: flex;align-items: center;width: 100%;justify-content: flex-start;margin: 24px auto;background: #fff;padding: 0 16px;border-radius: 26px;line-height: 40px;}
.login_form .list_item .list_label {margin-right:10px;font-size:16px;white-space:nowrap;color: var(--theme);width: 60px;flex-shrink: 0;text-align: center;}
.login_form .list_item .list_label i {  font-size:24px; color:#999;  }
.login_form .list_item .list_inp{ width:100%; border:none; border-bottom:1px solid #ddd; height:40px; line-height:40px; font-size:inherit;  }
.login_form .list_item .el-select{  }

/*用户类型*/
.login_form .list_type{ display: flex; align-items: center; width: 100%; justify-content: center; padding: 10px 0px;margin-bottom:10px;  }
.login_form .list_type .el-radio{ }
.login_form .list_type .el-radio .el-radio__label{ color: #666;  font-size: 16px; }
.login_form .list_type .el-radio.is-checked{ }
.login_form .list_type .el-radio.is-checked .el-radio__label{ color: rgb(139, 92, 126);  font-size: 16px; }
.login_form .list_type .el-radio__input{ }
.login_form .list_type .el-radio__input.is-checked{ }
.login_form .list_type .el-radio__input .el-radio__inner{ background: rgb(255, 255, 255); border: 1px solid rgb(220, 223, 230); }
.login_form .list_type .el-radio__input.is-checked  .el-radio__inner{ background-color: rgb(139, 92, 126); border-color: rgb(139, 92, 126); }

/*记住密码*/
.login_form .remember_view{  margin-bottom:20px;  }
.login_form .remember_view .el-checkbox{ width: 20%; margin: 0px;  display: flex;  justify-content: center; align-items: center; }
.login_form .remember_view .el-checkbox .el-checkbox__label{ background: rgb(255, 255, 255); }
.login_form .remember_view .el-checkbox .el-checkbox__inner{ color: rgb(153, 153, 153); }
.login_form .remember_view .el-checkbox.is-checked .el-checkbox__label{ color:#8b5c7e; font-size: 15px;  }
.login_form .remember_view .el-checkbox.is-checked .el-checkbox__inner{  background: #8b5c7e;  border-color: #8b5c7e; font-size: 16px; }

/* 按钮 */
.login_form .btn_view{text-align:center;margin-top: 60px;position: relative;}
.login_form .btn_view .login{width: 100%;height: 50px;line-height: 46px;background: var(--theme);border: 0px solid #ccc;font-weight: 600;font-size: 20px;color: #fff;margin-bottom:20px;padding:0;border-radius: 26px;} 
.login_form .btn_view .login:hover {} 
.login_form .btn_view .register{background: #D3EDFA;border: 0px solid #ccc;font-size:16px;color: var(--theme);} 
.login_form .btn_view .register:hover {color: #fff;background: var(--theme);} 
.login_form .btn_view .forget{background: none;border: 0px solid #ccc;font-size:16px;color: #fff;width: 120px;position: absolute;top: -50px;left: calc(50% - 60px);} 
.login_form .btn_view .forget:hover {border: none;color: var(--theme);}

.login_form .face{width:100%;height: 46px;line-height: 40px;background: #fff;border: 3px solid #ccc;font-weight: 600;font-size: 20px;color: #999;margin-bottom:20px;text-align:center;margin-top:20px;padding:0;cursor: pointer;} 
.login_form .face:hover {color: var(--theme);border-color: var(--theme);} 



.tabView {
    display: flex;
    width: 100%;
    column-gap: 12px;
}

.tab {
    flex: 1;
    text-align: center;
    background: #FFFFFF;
    border-radius: 37px 37px 37px 37px;
    border: 1px solid #EEEEEE;
    line-height: 40px;
    color: var(--theme);
    border: none;
}

.tab.tabActive {
    color: #fff;
    background: var(--theme);
}

.listCode_view {
    display: flex;
    background: #fff;
    line-height: 40px;
    padding: 0 16px;
    border-radius: 26px;
}

.listCode_label {
    color: var(--theme);
    flex-shrink: 0;
}

input.listCode_inp {
    border: none;
    flex: 1;
}

.listCode_btn {
    padding: 0 12px;
}
</style>