<template>
  <div class="home">
    <!-- DeepSeek 聊天弹窗 -->
    <el-dialog v-model="deepSeekChatVisible" title="DeepSeek 聊天" width="70%" destroy-on-close
               @close="deepSeekChatClose">
      <el-form ref="deepSeekFormRef" :model="deepSeekChatForm" class="deep-seek-chat-form">
        <div class="chat-content">
          <div :key="item.id" v-for="item in deepSeekChatList">
            <div class="chat_time" v-if="item.showTime">{{ item.addtime }}</div>
            <div v-if="item.ask" class="right-content">
              <el-alert class="text-content" :title="item.ask" :closable="false" type="success"></el-alert>
            </div>
            <div v-else class="left-content">
              <el-alert class="text-content" :title="item.reply" :closable="false" type="warning"></el-alert>
            </div>
            <div class="clear-float"></div>
          </div>
        </div>
        <div class="input_box">
          <el-input class="input" v-model="deepSeekChatForm.ask" placeholder="请输入问题" type="textarea"/>
        </div>
        <div class="save_box">
          <el-button class="save_btn" @click="sendDeepSeekChatMessage">发送</el-button>
        </div>
      </el-form>
    </el-dialog>
    <div class="index_top">
      <div class="index_top_title">高校考公咨询交流平台的设计</div>
      <div class="index_top_right" style="border: 1px solid red;">
        <div class="chat" style="cursor: pointer" @click="chatClick">
          <i class="iconfont icon-kefu3"></i>
          <span>管理员聊天</span>
        </div>
        <!-- 新增 DeepSeek 聊天按钮 -->
        <div class="chat" style="cursor: pointer; margin-right: 10px;" @click="deepSeekChatClick">
          <i class="iconfont icon-kefu3"></i>
          <span>DeepSeek 聊天</span>
        </div>
        <el-button v-if="!Token" class="login" type="success" icon="User" circle @click="loginClick">
          登录
        </el-button>
        <div class="user" v-if="Token">
          <el-dropdown class="avatar-container" trigger="hover">
            <div class="avatar-wrapper">
              <img class="user-avatar" :src="store.getters['user/avatar']" style="width: 50px">
              <div class="nickname">{{ $toolUtil.storageGet("frontName") }}</div>
              <el-icon class="el-icon-arrow-down">
                <arrow-down/>
              </el-icon>
            </div>
            <template #dropdown>
              <el-dropdown-menu class="user-dropDown" slot="dropdown">
                <el-dropdown-item @click="menuHandler('center')" class="center">
                  <span>个人中心</span>
                </el-dropdown-item>
                <el-dropdown-item @click="loginOut" class="loginOut">
                  <span>退出登录</span>
                </el-dropdown-item>
              </el-dropdown-menu>
            </template>
          </el-dropdown>
        </div>
      </div>
    </div>
    <el-scrollbar class="contain_view">
      <div class="menu-wrapper">
        <el-scrollbar wrap-class="scrollbar-wrapper" class="menu_scrollbar">
          <el-menu :default-openeds="[]" :unique-opened="true" :default-active="menuIndex"
                   class="menu_view" mode="horizontal" :ellipsis="false" @select="menuChange" :key="menuIndex">
            <el-menu-item class="first-item" index="0" @click="menuHandler('/')">
              <template #title>
                <span>首页</span>
              </template>
            </el-menu-item>
            <template v-for="(menu,index) in menuList" :key="menu.menu">
              <el-sub-menu v-if="menu.child.length>1" :index="index+2+''" class="first-item" :teleported="true">
                <template #title>
                  <span>{{ menu.name }}</span>
                </template>
                <el-menu-item class="second-item" v-for=" (child,sort) in menu.child" :key="sort"
                              :index="(index+2)+'-'+sort" @click="menuHandler(child.url)">{{ child.name }}
                </el-menu-item>
              </el-sub-menu>
              <el-menu-item v-else :index="index+2+''" class="first-item" @click="menuHandler(menu.child[0].url)">
                <template #title>
                  <span>{{ menu.child[0].name }}</span>
                </template>
              </el-menu-item>
            </template>
          </el-menu>
        </el-scrollbar>
      </div>
      <div class="rotation_view">
        <mySwiper :type="3" :data="rotationList" :autoHeight="false" :autoplay="true"
                  :loop="false" :navigation="true" :pagination="false"
                  :paginationType="1" :scrollbar="false" :slidesPerView="1"
                  :spaceBetween="20" :centeredSlides="false"
                  :freeMode="false" :effectType="0"
                  :direction="horizontal">
          <template #default="scope">
            <img :style='{}' :src="scope.row.value?$config.url + scope.row.value:''"
                 @click="carouselClick(scope.row.url)">
          </template>
        </mySwiper>
      </div>
      <router-view/>
      <el-backtop :right="100" :bottom="100"/>
      <div class="bottom_view">
        <img class="bottom_img" src="http://chy2.gdnxeco.com/20230912/0d5ae5e141c14b06a52a7c4c2f8ea4cf.jpg" alt="">
        <div class="bottom_company"></div>
        <div class="bottom_record"></div>
        <div class="bottom_desc"></div>
      </div>
    </el-scrollbar>
    <el-dialog v-model="chatVisible" title="客服" width="70%" destroy-on-close @close="chatClose">
      <el-form ref="formRef" :model="chatForm" class="chat_form">
        <div class="chat-content">
          <div :key="item.id" v-for="item in chatList">
            <div class="chat_time" v-if="item.showTime">{{ item.addtime }}</div>
            <div v-if="item.ask" class="right-content">
              <el-alert v-if="!item.img" class="text-content" :title="item.ask" :closable="false"
                        type="success"></el-alert>
              <video v-else-if="item.content.endsWith('.mp4')" controls style="width: 200px;height: 160px">
                <source :src="$config.url + item.content">
              </video>
              <el-image v-if="item.img" :src="$config.url + item.img" class="chat_img"
                        fit="scale-down" :preview-src-list="[$config.url + item.img]"></el-image>
            </div>
            <div v-else class="left-content">
              <el-alert v-if="!item.img" class="text-content" :title="item.reply" :closable="false"
                        type="warning"></el-alert>
              <video v-else-if="item.content.endsWith('.mp4')" controls style="width: 200px;height: 160px">
                <source :src="$config.url + item.content">
              </video>
              <el-image v-if="item.img" :src="$config.url + item.img" class="chat_img"
                        fit="scale-down" :preview-src-list="[$config.url + item.img]"></el-image>
            </div>
            <div class="clear-float"></div>
          </div>
        </div>
        <div class="input_box">
          <el-input class="input" v-model="chatForm.ask" placeholder="请回复" type="textarea"/>
          <img src="http://chy2.gdnxeco.com/20230912/f60a0c39a6d34289b50c151949711b67.png" class="inp_add"
               @click="askShow=!askShow" alt="">
        </div>
        <div class="upload_box" v-if="askShow">
          <el-upload class="upload-demo" :action="action" :on-success="uploadSuccess" :show-file-list="false">
            <el-button class="upload_btn">上传文件</el-button>
          </el-upload>
        </div>
        <div class="save_box">
          <el-button class="save_btn" @click="askSave">发送</el-button>
        </div>
      </el-form>
    </el-dialog>
  </div>
</template>
<script setup>
import menu from '@/utils/menu'
import axios from 'axios'
import {
  ref,
  onBeforeUnmount,
  getCurrentInstance,
  nextTick,
  computed,
  watch,
} from 'vue';
import {
  useRouter,
  useRoute
} from 'vue-router';
import {
  useStore
} from 'vuex';

const store = useStore()
const router = useRouter()
const route = useRoute();
const context = getCurrentInstance()?.appContext.config.globalProperties;
const Token = ref('')
const date = ref('')
const timer = ref('')
const interval = ref(null)
if (localStorage.getItem('frontToken') && !store.getters['user/session'].id) {
  store.dispatch('user/getSession')
}
onBeforeUnmount(() => {
  clearInterval(interval.value)
  delTimer()
})
// 获取默认菜单index
const setMenuIndex = () => {
  menuIndex.value = ''
  nextTick(() => {
    menuIndex.value = context?.$toolUtil.storageGet('menuIndex') ? context?.$toolUtil.storageGet('menuIndex') : '0'
  })
}
// 默认菜单index
const menuIndex = ref('0')
watch(() => router.currentRoute.value, () => {
  Token.value = context?.$toolUtil.storageGet('frontToken')
  setMenuIndex()
}, {
  immediate: true
})
const init = () => {
  // 获取菜单
  getMenu()
  // 赋值token
  Token.value = context?.$toolUtil.storageGet('frontToken')
  // 时间
  interval.value = setInterval(() => {
    date.value = context?.$toolUtil.getCurDate()
    timer.value = context?.$toolUtil.getCurDateTime().split(' ')[1]
  }, 1000)
  // 轮播图
  getRotationList()
  if (Token.value) {
    getSession()
  }
}
// 切换菜单保存index
const menuChange = (e) => {
  if (e == 'chat') return
  context?.$toolUtil.storageSet('menuIndex', e)
}
// 轮播图
const rotationList = ref([])
const baseUrl = context?.$config.url
const getRotationList = () => {
  context?.$http({
    url: 'config/list',
    method: 'get',
    params: {
      page: 1,
      limit: 3
    }
  }).then(res => {
    rotationList.value = res.data.data.list
  })
}

// 轮播图跳转
const carouselClick = (url) => {
  if (url) {
    if (url.startsWith('http')) {
      window.open(url)
    } else {
      context.$router.push(url)
    }
  }
}
const menuList = ref([])
const role = ref('')
const getMenu = () => {
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
    context?.$toolUtil.storageSet("menus", res.data.data.list[0].menujson);
  })
  menuList.value = context?.$config.menuList
}
const loginClick = () => {
  context?.$toolUtil.storageSet('toPath', window.history.state.current)
  router.push('/login')
}
const loginOut = () => {
  context?.$toolUtil.message('退出成功', 'success')
  context?.$toolUtil.storageClear()
  router.replace('/index/home')
  context?.$toolUtil.storageSet('menuIndex', '0')
  Token.value = ''
}
//管理员聊天
//客服弹窗
const chatClick = () => {
  getChatList()
  chatVisible.value = true
  intervalTimer.value = setInterval(() => {
    getChatList()
  }, 3000)
}

const chatVisible = ref(false)
const chatForm = ref({})
const chatList = ref([])
const scrollFlag = ref(true)
//管理员聊天列表
const getChatList = () => {
  context?.$http({
    url: 'chat/page',
    method: 'get',
    params: {
      limit: 1000,
      sort: 'addtime',
      order: 'asc',
      userid: context?.$toolUtil.storageGet('userid')
    }
  }).then(res => {
    for (let x in res.data.data.list) {
      if (res.data.data.list[x].ask) {
        if (res.data.data.list[x].ask.split('/').length > 1) {
          if (res.data.data.list[x].ask.split('/')[0] == 'file') {
            res.data.data.list[x].img = res.data.data.list[x].ask
          }
        }
      }
      if (res.data.data.list[x].reply) {
        if (res.data.data.list[x].reply.split('/').length > 1) {
          if (res.data.data.list[x].reply.split('/')[0] == 'file') {
            res.data.data.list[x].img = res.data.data.list[x].reply
          }
        }
      }
      if (x == 0) {
        res.data.data.list[x].showTime = 1
      } else {
        let jian = new Date(res.data.data.list[x].addtime).getTime() - new Date(res.data.data.list[x - 1].addtime).getTime()
        if (jian > 18000) {
          res.data.data.list[x].showTime = 1
        } else {
          res.data.data.list[x].showTime = 0
        }
      }
    }
    chatList.value = res.data.data.list
    nextTick(() => {
      let div = document.getElementsByClassName('chat-content')[0]
      setTimeout(() => {
        if (div) {
          if (div.scrollTop + div.clientHeight == div.scrollHeight || scrollFlag.value) {
            div.scrollTop = div.scrollHeight
            scrollFlag.value = false
          }
        }
      }, 100)
    })
  })
}

// 发送 DeepSeek 聊天消息
// 控制弹窗显示状态
const deepSeekChatVisible = ref(false);

// DeepSeek 聊天表单数据
const deepSeekChatForm = ref({
  ask: '',
});

// DeepSeek 聊天记录
const deepSeekChatList = ref([]);

// 打开 DeepSeek 聊天弹窗
const deepSeekChatClick = () => {
  deepSeekChatVisible.value = true;
};

// 关闭 DeepSeek 聊天弹窗
const deepSeekChatClose = () => {
  deepSeekChatVisible.value = false;
};

// 发送消息
const sendDeepSeekChatMessage = async () => {

  if (!deepSeekChatForm.value.ask?.trim()) {
    context?.$toolUtil.message('请输入有效问题', 'warning');
    return;
  }

  // 添加用户提问
  deepSeekChatList.value.push({
    id: Date.now(),
    ask: deepSeekChatForm.value.ask.trim(),
    addtime: new Date().toLocaleString(),
    showTime: shouldShowTime(),
  });

  try {
    // 使用 await 处理异步请求
    const res = await context.$http({
      url: 'chat/response',
      method: 'post',
      data: {ask: deepSeekChatForm.value.ask},
      transformResponse: [(data) => {
        const parsedData = JSON.parse(data);
        return parsedData.content;
      }],
      skipGlobalError: true
    });
    context.$http.defaults.showMessage = false;

    // 处理文本响应
    deepSeekChatList.value.push({
      id: Date.now() + 1,
      reply: res.data,
      addtime: new Date().toLocaleString(),
      showTime: shouldShowTime()
    });

  } catch (error) {
    // 检查错误对象中是否包含可用数据
    if (error.data) {
      const replyMessage = typeof error.data === 'string' ? error.data : JSON.stringify(error.data);

      // 将错误信息添加到聊天列表
      deepSeekChatList.value.push({
        id: Date.now() + 1,
        reply: replyMessage,
        addtime: new Date().toLocaleString(),
        showTime: shouldShowTime()
      });
    }
  } finally {
    // 无论成功或失败，都清空输入框
    deepSeekChatForm.value.ask = '';
  }
};


// 时间显示逻辑（示例）
const shouldShowTime = () => {
  if (deepSeekChatList.value.length === 0) return true;
  const lastMessage = deepSeekChatList.value[deepSeekChatList.value.length - 1];
  const now = Date.now();
  return now - new Date(lastMessage.addtime).getTime() > 5 * 60 * 1000; // 5分钟间隔
};

// 自动滚动到底部
const scrollToBottom = () => {
  nextTick(() => {
    const container = document.querySelector('.chat-content');
    if (container) {
      container.scrollTop = container.scrollHeight;
    }
  });
};

//定时器
const intervalTimer = ref(null)
const chatClose = () => {
  setMenuIndex()
  delTimer()
}
const delTimer = () => {
  if (intervalTimer.value) {
    clearInterval(intervalTimer.value)
  }
}
//图片上传
const action = ref(`${context?.$config.name}/file/upload`)
const uploadSuccess = (e) => {
  let params = {
    ask: 'file/' + e.file,
    userid: context?.$toolUtil.storageGet('userid')
  }
  context?.$http({
    url: 'chat/add',
    method: 'post',
    data: params
  }).then(res => {
    context?.$toolUtil.message('发送成功', 'success', () => {
      getChatList()
      chatForm.value.ask = ''
    })
  })
}
//操作显示
const askShow = ref(false)
//发送客服信息
const askSave = () => {
  let params = JSON.parse(JSON.stringify(chatForm.value))
  params.userid = context?.$toolUtil.storageGet('userid')
  context?.$http({
    url: 'chat/add',
    method: 'post',
    data: params
  }).then(res => {
    context?.$toolUtil.message('发送成功', 'success')
    chatForm.value.ask = ''
    getChatList()
  })
}
//菜单跳转
const menuHandler = (name) => {
  if (name == 'chat') return chatClick()
  if (name == 'center') {
    name = `${context?.$toolUtil.storageGet('frontSessionTable')}Center`
    menuChange('center')
  }
  router.push(name)
}
// 获取用户信息
const getSession = () => {
  context?.$http({
    url: `${context?.$toolUtil.storageGet('frontSessionTable')}/session`,
    method: 'get'
  }).then(res => {
    context?.$toolUtil.storageSet('userid', res.data.data.id)
    if (context?.$toolUtil.storageGet('frontSessionTable') == 'xuesheng') {
      context?.$toolUtil.storageSet("frontName", res.data.data.zhanghao)
    }
    if (context?.$toolUtil.storageGet('frontSessionTable') == 'xuesheng') {
      context?.$toolUtil.storageSet('headportrait', res.data.data.touxiang)
    }
  })
}
init()
</script>
<style lang="scss" scoped>
/* 头部 */
.index_top {
  .index_top_title {
  }

  .index_top_right {
    line-height: 1;

    .weather_time_view {
      display: flex;
      align-items: center;
      gap: 10px; /* 设置按钮之间的间距 */
      .weather {
        padding: 0 10px;
        flex-direction: row;
        display: none;
        font-size: 16px;
        line-height: 1;
        justify-content: center;
        align-items: center;

        .city {
          padding: 0;
          margin: 0 10px 0 0;
        }

        .wea {
        }
      }

      .time {
        padding: 0 20px;
        flex-direction: row;
        display: flex;
        font-size: 16px;
        line-height: 1;
        justify-content: center;
        align-items: center;

        .date {
          padding: 0;
          margin: 0 10px 0 0;
        }

        .timer {
          padding: 0;
          margin: 0;
        }
      }
    }
  }

  // 登录按钮
  :deep(.el-button--success) {
    border-radius: 4px;
    padding: 10px;
    margin: 0 10px 0 0;
    color: #fff;
    background: none;
    font-size: 16px;
    border-color: transparent;
  }

  :deep(.el-button--success:hover) {
  }

  // 登出按钮
  :deep(.el-button--danger) {
    border-radius: 4px;
    padding: 10px;
    color: #fff;
    background: none;
    font-size: 16px;
    border-color: transparent;
  }

  :deep(.el-button--danger:hover) {
  }
}

// 轮播盒子
.rotation_view {
}

// 底部
.bottom_view {
  // 图片
  .bottom_img {
    border-radius: 100%;
    object-fit: cover;
    display: none;
    width: 44px;
    height: 44px;
  }

  // 公司
  .bottom_company {
    margin: 10px 0 0;
  }

  // 备案号
  .bottom_record {
    margin: 10px 0 0;
  }

  // 联系方式
  .bottom_desc {
    margin: 10px 0 0;
  }
}


.contain_view {
  margin: 0;
  background: #fff;
  position: relative;
  height: calc(100% - 60px);
}

.el-aside {
  transition: width 0.15s;
  -webkit-transition: width 0.15s;
  -moz-transition: width 0.15s;
  -webkit-transition: width 0.15s;
  -o-transition: width 0.15s;
}

.el-sub-menu__hide-arrow {
  display: block !important;
}

.menu_scrollbar {
}

// 总盒子
.menu_view {
  // 一级菜单
  :deep(.first-item) {

    // 图标

    // 标题
    .el-sub-menu__title,
    span {
    }

    //箭头
    .el-sub-menu__icon-arrow {
    }
  }

  // 选中
  :deep(.is-active) {
  }

  // 悬浮
  :deep(.first-item:hover) {
  }
}

// 聊天总盒子
.chat_form {
  // 聊天内容盒子
  .chat-content {
    // 聊天时间
    .chat_time {
    }

    // 提问盒子
    .left-content {
      // 文字样式
      :deep(.el-alert--success) {
        .el-alert__title {
          font-size: inherit;
        }
      }

      // 聊天图片
      .chat_img {
      }
    }

    // 回复盒子
    .right-content {
      // 文字样式
      :deep(.el-alert--warning) {
        .el-alert__title {
          font-size: inherit;
        }
      }

      // 聊天图片
      .chat_img {
      }
    }
  }

  // 输入内容盒子
  .input_box {
    // 输入框
    :deep(.el-textarea__inner) {
    }

    // 操作按钮
    .inp_add {
    }
  }

  // 操作盒子
  .upload_box {
    :deep(.upload-demo) {
      // 上传按钮
      .upload_btn {
      }

      // 上传按钮-悬浮
      .upload_btn:hover {
      }
    }
  }

  // 发送盒子
  .save_box {
    // 发送按钮
    .save_btn {
    }

    // 发送按钮-悬浮
    .save_btn:hover {
    }
  }

  .clear-float {
    clear: both;
  }
}
</style>
<style lang="scss">
// 二级
.menu_popper {
  border: none !important;
  background: none !important;

  // 二级总盒子
  .el-menu--popup {
  }

  // 二级菜单
  .second-item {
  }

  // 选中
  .is-active {
  }

  // 悬浮
  .second-item:hover {
  }
}
</style>
<style>
/* 盒子 */
.index_top {
  box-sizing: border-box;
  width: 100%;
  display: flex;
  align-items: center;
  height: 44px;
  background: #333333;
  color: #fff;
  justify-content: space-between;
  padding: 0px calc((100% - 1200px) / 2);
  z-index: 1002;
  position: relative;
}

/* 标题 */
.index_top .index_top_title {
  font-size: 20px;
  color: rgb(255, 255, 255);
  font-weight: bold;
  margin-left: 20px;
}

/* 右部 盒子 */
.index_top .index_top_right {
  display: flex;
  align-items: center;
  margin-right: 20px;
  color: inherit;
}

/* 系统公告 */
.index_top .notice-btn {
  background: none;
  border: 0px solid #dcdfe6;
  color: #fff;
  margin: 0;
  padding: 10px;
  font-size: 16px;
  border-radius: 0px;
}

.index_top .notice-btn:hover {
  color: #ccc;
}

/* 图标 */
.index_top .notice-btn .iconfont {
  font-size: 16px;
}

/* 管理员聊天 */
.index_top .index_top_right .chat {
  position: relative;
  z-index: 1000; /* 确保按钮显示在最上层 */
  margin-right: 10px;
  order: 3;
}

.index_top .index_top_right .chat:hover {
  color: #ccc;
}

.index_top .index_top_right .chat .iconfont {
  font-size: 16px;
}

.index_top .index_top_right .chat span {
  font-size: 16px;
}

/* 购物中心 */
.index_top .index_top_right .cart {
  margin-right: 10px;
  font-size: 16px;
}

.index_top .index_top_right .cart:hover {
  color: #ccc;
}

.index_top .index_top_right .cart .iconfont {
  font-size: 16px;
  margin-right: 5px;
}

/* 系统后台 */
.index_top .index_top_right .toBack {
  margin-right: 15px;
}

.index_top .index_top_right .toBack .el-button {
  background: none;
  border: 0;
  padding: 0;
  font-size: 16px;
  color: #fff;
}

.index_top .index_top_right .toBack .el-button:hover {
  color: #ccc;
  background: none;
}

.index_top .login {
  order: 22;
}

/* 用户 盒子 */
.index_top .user {
  order: 2;
  margin-right: 10px;
}

.index_top .user .avatar-wrapper {
  display: flex;
  align-items: center;
  cursor: pointer;
  color: inherit;
}

/* 头像 */
.index_top .user .avatar-wrapper .user-avatar {
  width: 36px !important;
  height: 36px;
  border-radius: 100%;
  margin-right: 5px;
}

/* 昵称 */
.index_top .user .avatar-wrapper .nickname {
  font-size: 16px;
  margin-right: 5px;
  color: #fff;
}

/* 箭头 */
.index_top .user .avatar-wrapper .el-icon-arrow-down {
  color: #fff;
}

/* 用户下拉 盒子 */
.user-dropDown {
  padding: 10px 0;
  margin: 5px 0;
  background: #fff;
  border: 1px solid #e6ebf5;
  border-radius: 4px;
  -webkit-box-shadow: 0 2px 12px 0 rgba(0, 0, 0, .1);
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, .1);
}

.user-dropDown li {
  padding: 0 20px !important;
  line-height: 36px !important;
  font-size: 14px !important;
  color: #606266 !important;
}

.user-dropDown li:hover {
  color: #0076ca !important;
  background: none !important;
}

.user-dropDown li.loginOut {
  background: none !important;
  border-color: none !important;
  color: #666 !important;
}

.user-dropDown li.loginOut:hover {
  border-radius: 0px !important;
  background: none !important;
  color: #0076ca !important;
}

.bottom_view {
  width: 100%;
  margin: 20px auto 0;
  background: url(http://clfile.zggen.cn/20240927/761ce17a236f471188de37f6cc1a60b4.png) no-repeat center top;
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  padding: 40px 0px 20px;
  min-height: 188px;
  border-width: 0px 0px 0px;
  border-style: solid;
  border-color: rgb(254, 176, 67);
  font-size: 16px;
  color: rgb(51, 51, 51);
  line-height: 1.8;
}

/* 总盒子(可滚动容器) */
.menu_scrollbar {
  width: 100%;
  background: #fff;
  border-width: 0px;
  border-style: solid;
  border-color: rgb(239, 239, 239);
}

.menu_scrollbar .el-scrollbar__view {
  padding-bottom: 0px;
}

/* 菜单盒子 */
.menu_scrollbar .menu_view {
  background: transparent;
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  border-bottom: none;
  padding: 20px 0;
}

/* 一级菜单 item */
.menu_scrollbar .menu_view .el-menu-item, .menu_scrollbar .menu_view .el-sub-menu, .menu_scrollbar .menu_view .el-sub-menu .el-sub-menu__title {
  height: 50px;
  line-height: 50px;
  border: 0px;
  color: #333;
  font-size: 16px;
  padding: 0px 10px;
  cursor: pointer;
  white-space: nowrap;
  list-style: none;
  background: transparent;
  min-width: 80px;
  text-align: center;
}

.menu_scrollbar .menu_view .el-menu-item:hover, .menu_scrollbar .menu_view .el-sub-menu:hover {
  background: url(http://clfile.zggen.cn/20240927/13e16f1e331e45e296c392509a7ec2fe.png) no-repeat center bottom;
  color: var(--theme) !important;
}

.menu_scrollbar .menu_view .el-menu-item.is-active, .menu_scrollbar .menu_view .el-sub-menu.is-active {
  height: 50px;
  line-height: 50px;
  font-size: 16px;
  border-bottom: none;
  background: url(http://clfile.zggen.cn/20240927/13e16f1e331e45e296c392509a7ec2fe.png) no-repeat center bottom;
  color: var(--theme) !important;
}

/* 图标 */
.menu_scrollbar .menu_view .el-sub-menu .el-sub-menu__title .el-icon-menu, .menu_scrollbar .menu_view .el-sub-menu .el-sub-menu__title .iconfont {
  vertical-align: middle;
  margin: 0px 3px;
  width: 34px;
  text-align: center;
  font-size: 18px;
  color: inherit;
}

/* 标题 */
.menu_scrollbar .menu_view .el-sub-menu .el-sub-menu__title span {
  font-size: 16px;
  vertical-align: middle;
  color: inherit;
}

/* 箭头 */
.menu_scrollbar .menu_view .el-sub-menu .el-sub-menu__title .el-sub-menu__icon-arrow {
  position: static;
  margin: -3px 0px 0px 8px;
  font-size: 12px;
  vertical-align: middle;
  color: inherit;
}

/* 二级菜单 总盒子 */
.el-menu--horizontal .el-menu {
  border: none;
}

.el-menu--horizontal .el-menu .el-menu-item {
  color: rgb(102, 102, 102);
  height: 40px;
  line-height: 40px;
  padding: 0px 20px;
  background: rgb(255, 255, 255);
}

.el-menu--horizontal .el-menu .el-menu-item:hover {
  color: var(--theme) !important;
  background: #fff !important;
}

.el-menu--horizontal .el-menu .el-menu-item.is-active {
  color: var(--theme) !important;
  background: #fff !important;
}

/*总盒子*/
.rotation_view {
  width: 100%;
  margin: 0px auto;
}

/*banner盒子*/
.rotation_view .swiper-container {
  width: 100%;
  height: 100%;
  border: 0px solid #fff;
}

.rotation_view .swiper .swiper-wrapper {
  transition-duration: 0ms;
  transform: translate3d(0px, 0px, 0px);
  height: 480px;
}

.rotation_view .swiper .swiper-wrapper .swiper-slide {
}

.rotation_view .swiper .swiper-wrapper .swiper-slide img {
  width: 100%;
  height: 100%;
  object-fit: cover;
}

/*左箭头*/
.rotation_view .swiper .swiper-button-prev {
  margin-left: calc((100% - 1180px) / 2);
  color: var(--theme);
}

/*右箭头*/
.rotation_view .swiper .swiper-button-next {
  margin-right: calc((100% - 1180px) / 2);
  color: var(--theme);
}

/*总盒子*/
.bread_view {
  width: 100%;
  background: none;
  color: rgb(51, 51, 51);
  text-align: center;
  font-size: 20px;
  font-weight: 600;
  border: 0px solid #eee;
  padding: 10px 0px 10px 0px;
  background: #fff;
}

/*面包屑盒子*/
.bread_view .el-breadcrumb {
  font-size: 16px;
  line-height: 1;
}

/*分隔符*/
.bread_view .el-breadcrumb .el-breadcrumb__separator {
  margin: 0px 9px;
  font-weight: 500;
  color: rgb(204, 204, 204);
}

/*一级*/
.bread_view .el-breadcrumb .first_breadcrumb span a {
  color: #333;
  display: inline-block;
}

/*二级*/
.bread_view .el-breadcrumb .second_breadcrumb .el-breadcrumb__inner {
  color: #666;
  display: inline-block;
}

/*总盒子*/
.chat_form {
  display: flex;
  flex-direction: column;
  width: 100%;
  margin: 20px auto;
}

/*聊天列表 盒子*/
.chat_form .chat-content {
  margin: 0px 0px 30px;
  padding: 0px 0px 30px;
  height: 300px;
  overflow-y: scroll;
  border: 1px solid rgb(221, 221, 221);
  background: #fff !important;
}

/*时间*/
.chat_form .chat-content .chat_time {
  width: 100%;
  text-align: center;
  font-size: 16px;
  color: rgb(153, 153, 153);
  padding: 6px 0px;
}

/*提问盒子*/
.chat_form .chat-content .right-content {
  float: right !important;
  margin: 0px 0px 10px;
  padding: 10px;
}

.chat_form .chat-content .right-content .text-content {
  background: rgba(80, 200, 100, .3);
  color: #333;
  margin: 0px 0px 0 10px;
}

.chat_form .chat-content .right-content .chat_img {
  width: 150px;
  margin: 10px;
}

/*回复盒子*/
.chat_form .chat-content .left-content {
  float: left !important;
  margin: 0px 0px 10px;
  padding: 10px;
  width: auto;
}

.chat_form .chat-content .left-content .text-content {
  background: rgba(240, 180, 60, .3);
  color: #333;
}

.chat_form .chat-content .left-content .chat_img {
  width: 150px;
  margin: 10px;
}

/*操作栏 盒子*/
.chat_form .input_box {
  display: flex;
  align-items: center;
}

/*输入框*/
.chat_form .input_box .el-textarea .el-textarea__inner {
  width: 100%;
  min-height: 120px;
  padding: 12px;
  font-size: 14px;
  color: rgb(51, 51, 51);
  border: 1px solid rgb(221, 221, 221);
}

/*加号*/
.chat_form .input_box .inp_add {
  width: 36px;
  cursor: pointer;
  margin: 0px 0px 0px 10px;
}

/*上传 盒子*/
.chat_form .upload_box {
  display: flex;
  align-items: center;
  width: 100%;
  margin: 20px 0px 0px;
  justify-content: center;
}

/*转人工*/
.chat_form .upload_box .change_btn {
  margin: 0px 10px 0px 0px;
  padding: 0px 24px;
  width: auto;
  height: 32px;
  font-size: 16px;
  color: rgb(255, 255, 255);
  border-radius: 4px;
  border: 0px;
  background: #00caa2;
  cursor: pointer;
}

/*上传图片*/
.chat_form .upload_box .upload_btn {
  margin: 0px 10px 0px 0px;
  padding: 0px 24px;
  width: auto;
  height: 32px;
  font-size: 16px;
  color: rgb(255, 255, 255);
  border-radius: 4px;
  border: 0px;
  background: rgb(54, 176, 67);
  cursor: pointer;
}

/*发送按钮 盒子*/
.chat_form .save_box {
  width: 100%;
  display: flex;
  justify-content: flex-end;
  margin: 30px 0px 0px;
}

.chat_form .save_box .save_btn {
  margin: 0px 10px 0px 0px;
  padding: 0px 24px;
  width: auto;
  height: 34px;
  font-size: 16px;
  color: rgb(255, 255, 255);
  border-radius: 4px;
  border: 0px;
  background: var(--theme);
  cursor: pointer;
  min-width: 100px;
}

/* DeepSeek 聊天弹窗样式 */
.deep-seek-chat-form {
  .chat-content {
    margin: 0px 0px 30px;
    padding: 0px 0px 30px;
    height: 300px;
    overflow-y: scroll;
    border: 1px solid rgb(221, 221, 221);
    background: #fff !important;
  }

  .input_box {
    display: flex;
    align-items: center;

    .el-textarea .el-textarea__inner {
      width: 100%;
      min-height: 120px;
      padding: 12px;
      font-size: 14px;
      color: rgb(51, 51, 51);
      border: 1px solid rgb(221, 221, 221);
    }
  }

  .save_box {
    width: 100%;
    display: flex;
    justify-content: flex-end;
    margin: 30px 0px 0px;

    .save_btn {
      margin: 0px 10px 0px 0px;
      padding: 0px 24px;
      width: auto;
      height: 34px;
      font-size: 16px;
      color: rgb(255, 255, 255);
      border-radius: 4px;
      border: 0px;
      background: var(--theme);
      cursor: pointer;
      min-width: 100px;
    }
  }

  .right-content {
    float: right !important;
    margin: 0px 0px 10px;
    padding: 10px;

    .text-content {
      background: rgba(80, 200, 100, .3);
      color: #333;
      margin: 0px 0px 0 10px;
    }
  }

  .left-content {
    float: left !important;
    margin: 0px 0px 10px;
    padding: 10px;
    width: auto;

    .text-content {
      background: rgba(240, 180, 60, .3);
      color: #333;
    }
  }

  .chat_time {
    width: 100%;
    text-align: center;
    font-size: 16px;
    color: rgb(153, 153, 153);
    padding: 6px 0px;
  }

  .clear-float {
    clear: both;
  }
}
</style>