<template>
  <div class="detail-page" :style='{}'>
    <div class="breadcrumb-wrapper" style="width: 100%;">
      <div class="bread_view">
        <el-breadcrumb separator="/" class="breadcrumb">
          <el-breadcrumb-item class="first_breadcrumb" :to="{ path: '/' }">首页</el-breadcrumb-item>
          <el-breadcrumb-item class="second_breadcrumb" v-for="(item,index) in breadList" :key="index">{{item.name}}</el-breadcrumb-item>
        </el-breadcrumb>
      </div>
      <div class="back_view">
        <el-button class="back_btn" @click="backClick" type="primary">返回</el-button>
      </div>
    </div>
    <div class="detail_view">
      <div class="swiper_view">
        <mySwiper :data="bannerList" :type="3"
                  :loop="false"
                  :navigation="true"
                  :pagination="false"
                  :paginationType="1"
                  :scrollbar="false"
                  :slidesPerView="1"
                  :spaceBetween="20"
                  :autoHeight="false"
                  :centeredSlides="false"
                  :freeMode="false"
                  :effectType="0"
                  :direction="horizontal"
                  :autoplay="false"
                  :slidesPerColumn="1">

        </mySwiper>
      </div>
      <div class="thumbs_view">
        <template v-if="!thumbsupOrCrazilyInfo.type">
          <div class="zan_view" @click="thumbsupOrCrazilyClick(21)">
            <i class="iconfont icon-thumb-up-line1"></i>
            <span>赞({{detail.thumbsupNumber}})</span>
          </div>
          <div class="zan_view can_view" @click="thumbsupOrCrazilyClick(22)">
            <i class="iconfont icon-thumb-down-line1"></i>
            <span>踩({{detail.crazilyNumber}})</span>
          </div>
        </template>
        <template v-else>
          <div class="zan_view zanActive" v-if="thumbsupOrCrazilyInfo.type==21" @click="cancelThumbsupOrCrazilyClick(21)">
            <i class="iconfont iconfontActive icon-thumb-up-fill1"></i>
            <span class="textActive">取消赞({{detail.thumbsupNumber}})</span>
          </div>
          <div class="zan_view can_view zanActive" v-else @click="cancelThumbsupOrCrazilyClick(22)">
            <i class="iconfont iconfontActive icon-thumb-down-fill1"></i>
            <span class="textActive">取消踩({{detail.crazilyNumber}})</span>
          </div>
        </template>
      </div>

      <div class="info_view">
        <div class="title_view">
          <div class="detail_title">
<!--            <span>{{detail.yuanxiao}}</span>-->
          </div>
          <div class="collect_view" v-if="!collectType" @click="collectClick(1)">
            <i class="iconfont icon-likeline1"></i>
            <span>收藏</span>
          </div>
          <div class="collect_view" v-if="collectType" @click="collectClick(-1)">
            <i class="iconfont iconfontActive icon-likefill1"></i>
            <span class="textActive">取消收藏</span>
          </div>
        </div>
        <div v-for="(item, index) in infoItems" :key="index" class="info_item">
          <div class="info_label">{{ item.label }}</div>
          <el-tooltip :content="item.text" placement="top">
            <div class="info_text">
              {{ item.text }}
            </div>
          </el-tooltip>
        </div>

        <div class="info_item">
          <div class="info_label">报考条件</div>
          <el-tooltip :content="detail.baokaotiaojian" placement="top">
            <div class="info_text">{{detail.baokaotiaojian}}</div>
          </el-tooltip>
        </div>
        <div class="info_item">
          <div class="info_label">学历条件</div>
          <el-tooltip :content="detail.xuelitiaojian" placement="top">
            <div class="info_text">{{detail.xuelitiaojian}}</div>
          </el-tooltip>
        </div>
        <div class="info_item">
          <div class="info_label">报名时间</div>
          <el-tooltip :content="detail.baomingshijian" placement="top">
            <div class="info_text">{{detail.baomingshijian}}</div>
          </el-tooltip>
        </div>
        <div class="info_item">
          <div class="info_label">报名网址</div>
          <a
              href="http://bm.scs.gov.cn/pp/gkweb/core/web/ui/business/home/gkhome.html"
              target="_blank"
              class="info_link"
              style="color: #409EFF; text-decoration: underline; cursor: pointer;"
          >
            http://bm.scs.gov.cn
          </a>
        </div>
        <div class="info_item">
          <div class="info_label">费用缴纳</div>
          <el-tooltip :content="detail.feiyongjiaona" placement="top">
            <div class="info_text">{{detail.feiyongjiaona}}</div>
          </el-tooltip>
        </div>
        <div class="info_item">
          <div class="info_label">发布时间</div>
          <el-tooltip :content="detail.fabushijian" placement="top">
            <div class="info_text">{{detail.fabushijian}}</div>
          </el-tooltip>
        </div>
        <div class="info_item">
          <div class="info_label">部门名称</div>
          <el-tooltip :content="detail.bumenmingcheng" placement="top">
            <div class="info_text">{{detail.bumenmingcheng}}</div>
          </el-tooltip>
        </div>
        <div class="info_item">
          <div class="info_label">职位代码</div>
          <el-tooltip :content="detail.zhiweidaima" placement="top">
            <div class="info_text">{{detail.zhiweidaima}}</div>
          </el-tooltip>
        </div>
        <div class="info_item">
          <div class="info_label">职位名称</div>
          <el-tooltip :content="detail.zhiweimingcheng" placement="top">
            <div class="info_text">{{detail.zhiweimingcheng}}</div>
          </el-tooltip>
        </div>
        <div class="info_item">
          <div class="info_label">科目类别</div>
          <el-tooltip :content="detail.kemuleibie" placement="top">
            <div class="info_text">{{detail.kemuleibie}}</div>
          </el-tooltip>
        </div>
        <div class="info_item">
          <div class="info_label">招考人数</div>
          <el-tooltip :content="detail.zhaokaorenshu" placement="top">
            <div class="info_text">{{detail.zhaokaorenshu}}</div>
          </el-tooltip>
        </div>
        <div class="info_item">
          <div class="info_label">学历要求</div>
          <el-tooltip :content="detail.xueliyaoqiu" placement="top">
            <div class="info_text">{{detail.xueliyaoqiu}}</div>
          </el-tooltip>
        </div>
        <div class="info_item">
          <div class="info_label">专业要求</div>
          <el-tooltip :content="detail.zhuanyeyaoqiu" placement="top">
            <div class="info_text">{{detail.zhuanyeyaoqiu}}</div>
          </el-tooltip>
        </div>
        <div class="info_item">
          <div class="info_label">政治面貌</div>
          <el-tooltip :content="detail.zhengzhimianmao" placement="top">
            <div class="info_text">{{detail.zhengzhimianmao}}</div>
          </el-tooltip>
        </div>
        <div class="info_item">
          <div class="info_label">咨询电话</div>
          <el-tooltip :content="detail.zixundianhua" placement="top">
            <div class="info_text">{{detail.zixundianhua}}</div>
          </el-tooltip>
        </div>
        <div class="info_item">
          <div class="info_label">其他条件</div>
            <div class="info_text">敬请关注官网通知...</div>
        </div>
        <div class="btn_view">
          <el-button class="edit_btn" v-if="centerType&&btnAuth('baokaozhinan','修改')" type="primary" @click="editClick">修改</el-button>
          <el-button class="del_btn" v-if="centerType&&btnAuth('baokaozhinan','删除')" type="danger" @click="delClick">删除</el-button>
        </div>
      </div>
      <!-- 报考详情模块 -->
      <div class="job_description_view">
        <div class="job_description_title">报考详情</div>
        <div class="job_description_content" v-html="detail.xiangqingjianjie"></div>
      </div>
    </div>
    <el-tabs type="border-card" v-model="activeName" class="tabs_view">
      <el-tab-pane label="详情简介" name="first">
        <div v-html="detail.xiangqingjianjie"></div>
      </el-tab-pane>
      <el-tab-pane label="评论" name="commentActive">
        <div class="my_comment_view">
          <el-form ref="commentFormRef" :model="commentForm" class="my_comment_form"
                   :rules="commentRules">
            <el-form-item prop="content">
              <editor :value="commentForm.content" placeholder="善语结善缘,恶语伤人心"
                      class="list_editor" @change="contentChange"></editor>
            </el-form-item>
          </el-form>
          <div class="comment_btn">
            <el-button class="add_btn" type="primary" @click="commentSave">立即评论</el-button>
            <el-button class="reset_btn" @click="resetForm">重置</el-button>
          </div>
        </div>
        <div class="comment_list">
          <div class="comment" v-for="(item,index) in commentList" :key="index">
            <div class="comment_top">
              <div class="comment_user">
                <div class="comment_user_img">
                  <img :src="item.avatarurl?$config.url + item.avatarurl:'../../../assets/avatar.png'" alt="">
                </div>
                <div class="comment_user_info">
                  {{item.nickname}}
                </div>
              </div>
              <div class="comment_time">{{item.addtime}}</div>
            </div>
            <div class="comment_bottom">
              <div class="comment_content" v-html="item.content"></div>
              <div v-if="item.userid==user.id" class="comment_action">
                <span class="del" @click="commentDel(item)" style="cursor: pointer">删除</span>
              </div>
              <div class="comment_reply" v-if="item.reply">
                回复：<span v-html="item.reply"></span>
              </div>
            </div>
          </div>
        </div>
        <el-pagination
            background
            :layout="layouts.join(',')"
            :total="commentTotal"
            :page-size="commentQuery.limit"
            prev-text="上一页"
            next-text="下一页"
            :hide-on-single-page="false"
            :style='{}'
            @size-change="commentSizeChange"
            @current-change="commentCurrentChange" />
      </el-tab-pane>
    </el-tabs>
  </div>
</template>
<script setup>
	import axios from 'axios'
	import moment from 'moment'
	import {
		ref,
		getCurrentInstance,
		watch,
		onUnmounted,
		onMounted,
		nextTick,
		computed
	} from 'vue';
	import {
		ElMessageBox
	} from 'element-plus'
	import {
		useRoute,
		useRouter
	} from 'vue-router';
	import {
		useStore
	} from 'vuex';
	const store = useStore()
	const user = computed(()=>store.getters['user/session'])
	const userAvatar = computed(()=>store.getters['user/avatar'])
	const context = getCurrentInstance()?.appContext.config.globalProperties;
	const route = useRoute()
	const router = useRouter()
	//基础信息
	const tableName = 'baokaozhinan'
	const formName = '报考指南'
	//基础信息
	const breadList = ref([{
		name: formName
	}])
	//权限验证
	const btnAuth = (e,a)=>{
		if(centerType.value){
			return context?.$toolUtil.isBackAuth(e,a)
		}else{
			return context?.$toolUtil.isAuth(e,a)
		}
	}
	//查看权限验证
	const btnFrontAuth = (e,a)=>{
		if(centerType.value){
			return context?.$toolUtil.isBackAuth(e,a)
		}else{
			return context?.$toolUtil.isFrontAuth(e,a)
		}
	}
	// 返回
	const backClick = () =>{
		history.back()
	}
	// 轮播图
	const bannerList = ref([])
	// 详情
	const title = ref('')
	const detail = ref({})
    const activeName = ref('first')
	const getDetail = () => {
		context?.$http({
			url: `${tableName}/detail/${route.query.id}`,
			method: 'get'
		}).then(res => {
            bannerList.value = res.data.data.fengmian?res.data.data.fengmian.split(','):[]
            title.value = res.data.data.zhiweimingcheng
			detail.value = res.data.data
		})
	}
	// 下载文件
	const downClick = (file) => {
		if(!file){
			context?.$toolUtil.message('文件不存在','error')
		}
		let arr = file.replace(new RegExp('file/', "g"), "")
		axios.get((location.href.split(context?.$config.name).length>1 ? location.href.split(context?.$config.name)[0] :'') + context?.$config.name + '/file/download?fileName=' + arr, {
			headers: {
				token: context?.$toolUtil.storageGet('frontToken')
			},
			responseType: "blob"
		}).then(({
			data
		}) => {
			const binaryData = [];
			binaryData.push(data);
			const objectUrl = window.URL.createObjectURL(new Blob(binaryData, {
				type: 'application/pdf;chartset=UTF-8'
			}))
			const a = document.createElement('a')
			a.href = objectUrl
			a.download = arr
			// a.click()
			// 下面这个写法兼容火狐
			a.dispatchEvent(new MouseEvent('click', {
				bubbles: true,
				cancelable: true,
				view: window
			}))
			window.URL.revokeObjectURL(data)
		})
	}
	// 判断是否从个人中心跳转
	const centerType = ref(false)
	const init = () => {
		if(route.query.centerType){
			centerType.value = true
		}
		getDetail()
		// 赞踩状态
		getThumbsupOrCrazily()
		// 收藏
		getCollect()
		// 评论
		getCommentList()
	}
	// 赞or踩
	const thumbsupOrCrazilyInfo = ref({})
	// 获取赞踩状态
	const getThumbsupOrCrazily = () => {
		if (context?.$toolUtil.storageGet('frontToken')) {
			context?.$http({
				url: 'storeup/page',
				method: 'get',
				params: {
					page: 1,
					refid: route.query.id,
					tablename: tableName,
					userid: context?.$toolUtil.storageGet('userid')
				}
			}).then(res => {
				let list = res.data.data.list.filter(item=>(item.type==21||item.type==22))
				if(!list.length){
					thumbsupOrCrazilyInfo.value = {}
				}else{
					thumbsupOrCrazilyInfo.value = list[0]
				}
			})
		}
	}
	// 赞踩按钮
	const thumbsupOrCrazilyClick = (type) => {
		let params = {
			name: detail.value.zhiweimingcheng,
			picture: bannerList.value[0],
			refid: detail.value.id,
			type: type,
			tablename: tableName,
			userid: context?.$toolUtil.storageGet('userid')
		}
		context?.$http({
			url: 'storeup/add',
			method: 'post',
			data: params
		}).then(res => {
			if (type == 21) detail.value.thumbsupNumber += 1
			if (type == 22) detail.value.crazilyNumber += 1
			context?.$http({
				url: `${tableName}/update`,
				method: 'post',
				data: detail.value
			})
			getThumbsupOrCrazily()
			context?.$toolUtil.message('操作成功', 'success')
		})
	}
	//取消赞踩按钮
	const cancelThumbsupOrCrazilyClick = (type) => {
		let ids = []
		ids.push(thumbsupOrCrazilyInfo.value.id)
		context?.$http({
			url: 'storeup/delete',
			method: 'post',
			data: ids
		}).then(res => {
			if (type == 21 && detail.value.thumbsupNumber>0) detail.value.thumbsupNumber -= 1
			if (type == 22 && detail.value.crazilyNumber>0) detail.value.crazilyNumber -= 1
			context?.$http({
				url: `${tableName}/update`,
				method: 'post',
				data: detail.value
			})
			getThumbsupOrCrazily()
			context?.$toolUtil.message('取消成功', 'success')
		})
	}
	// 收藏
	const collectType = ref(false)
	const collectInfo = ref({})
	const getCollect = () => {
		if (context?.$toolUtil.storageGet('frontToken')) {
			context?.$http({
				url: 'storeup/list',
				method: 'get',
				params: {
					page: 1,
					limit: 1,
					type: 1,
					refid: route.query.id,
					tablename: tableName,
					userid: context?.$toolUtil.storageGet('userid')
				}
			}).then(res => {
				if (res.data.data.list.length) {
					collectType.value = true
					collectInfo.value = res.data.data.list[0]
				}else{
					collectType.value = false
					collectInfo.value = {}
				}
			})
		}
	}
	// 收藏按钮
	const collectClick = (type) => {
		if (type == 1 && !collectType.value) {
			let params = {
				name: title.value,
				picture: bannerList.value[0],
				refid: detail.value.id,
				type: type,
				tablename: tableName,
				userid: context?.$toolUtil.storageGet('userid')
			}
			context?.$http({
				url: 'storeup/add',
				method: 'post',
				data: params
			}).then(res => {
				detail.value.storeupNumber += 1
				context?.$http({
					url: `${tableName}/update`,
					method: 'post',
					data: detail.value
				})
				collectType.value = true
				getCollect()
				context?.$toolUtil.message('收藏成功', 'success')
			})
		}
		else if (type == -1 && collectType.value) {
			let ids = []
			ids.push(collectInfo.value.id)
			context?.$http({
				url: 'storeup/delete',
				method: 'post',
				data: ids
			}).then(res => {
				detail.value.storeupNumber -= 1
				context?.$http({
					url: `${tableName}/update`,
					method: 'post',
					data: detail.value
				})
				collectInfo.value = {}
				collectType.value = false
				context?.$toolUtil.message('取消成功', 'success')
			})
		}
	}
    const contentChange = (e)=>{
        commentForm.value.content = e
    }
	//评论
	const commentForm = ref({
		content: '',
		refid: route.query.id,
		userid: context?.$toolUtil.storageGet('userid'),
		nickname: context?.$toolUtil.storageGet('frontName'),
		avatarurl: context?.$toolUtil.storageGet('headportrait') ? context?.$toolUtil.storageGet('headportrait') : '',
	})
	const commentRules = ref({
		content: [{
			required: true,
			message: '请输入',
			trigger: 'blur'
		}, ]
	})
	const commentQuery = ref({
		page: 1,
		limit: 10,
		refid: route.query.id
	})
	const layouts = ref(["total","prev","pager","next","sizes","jumper"])
	const commentList = ref([])
	const commentTotal = ref(0)
	const commentFormRef = ref(null)
	const commentSizeChange = (size) =>{
		commentQuery.value.limit = size
		getCommentList()
	}
	const commentCurrentChange = (page) =>{
		commentQuery.value.page = page
		getCommentList()
	}
	const getCommentList = () => {
		context?.$http({
			url: `discuss${tableName}/list?sort=id&order=desc`,
			params: commentQuery.value,
			method: 'get'
		}).then(res => {
			commentList.value = res.data.data.list
			commentTotal.value = res.data.data.total

		})
	}
	//提交评论
	const commentSave = async () => {
        if(!commentForm.value.content ||commentForm.value.content=='<p><br></p>'){
            return context.$message.error("请输入评论内容")
        }
		let sensitiveWords = "艹,垃圾";
		let sensitiveWordsArr = [];
		if(sensitiveWords) {
		    sensitiveWordsArr = sensitiveWords.split(",");
		}
		for(var i=0; i<sensitiveWordsArr.length; i++){
		    //全局替换
		    var reg = new RegExp(sensitiveWordsArr[i],"g");
		    //判断内容中是否包括敏感词
		    if (commentForm.value.content.indexOf(sensitiveWordsArr[i]) > -1) {
		        // 将敏感词替换为 **
		        commentForm.value.content = commentForm.value.content.replace(reg,"**");
		    }
		}
		commentFormRef.value.validate((valid) => {
			if (valid) {
				context?.$http({
					url: `discuss${tableName}/add`,
					method: 'post',
					data: commentForm.value
				}).then(res => {
                    context.$http.get(`${tableName}/info/${detail.value.id}`).then(res=>{
                        let detail = res.data.data
                        detail.discussNumber++
                        context.$http.post(`${tableName}/update`,detail).then(()=>{
                            getDetail()
                        })
                    })
					context?.$toolUtil.message('评论成功', 'success')
                    resetForm()
                    getCommentList()
				})
			}
		})
	}
    const commentDel = (item)=>{
        context.$confirm("确定要删除该评论吗？","提示").then(()=>{
            context.$http.post(`discuss${tableName}/delete`,[item.id]).then(res=>{
                if(res.data.code==0){
                    context.$message.success("删除成功")
                    context.$http.get(`${tableName}/info/${detail.value.id}`).then(res=>{
                        let detail = res.data.data
                        detail.discussNumber--
                        context.$http.post(`${tableName}/update`,detail).then(()=>{
                            getDetail()
                        })
                    })
                    getCommentList()
                }
            })
        }).catch(()=>{})
    }
	const resetForm = () => {
		commentFormRef.value.resetFields()
	}
	const linkOthers = (url) =>{
		window.open(url)
	}
	//修改
	const editClick = () => {
		router.push(`/index/${tableName}Add?id=${detail.value.id}&&type=edit`)
	}
	//删除
	const delClick = () => {
		ElMessageBox.confirm(`是否删除此${formName}？`, '提示', {
			confirmButtonText: '是',
			cancelButtonText: '否',
			type: 'warning',
		}).then(()=>{
			context?.$http({
				url: `${tableName}/delete`,
				method: 'post',
				data: [detail.value.id]
			}).then(res=>{
				context?.$toolUtil.message('删除成功','success',()=>{
					history.back()
				})
			})

		})
	}
	onMounted(()=>{
		init()
	})
</script>
<style lang="scss" scoped>
	// 返回盒子
	.back_view {
		border-radius: 4px;
		padding: 10px 0px;
		margin: 10px auto;
		background: none;
		width: 100%;
		text-align: right;
		// 返回按钮
		.back_btn {
			border: 1px solid #0076ca50;
			cursor: pointer;
			border-radius: 4px;
			padding: 0 24px;
			color: #0076ca;
			background: #fff;
			width: auto;
			font-size: 14px;
			height: 34px;
		}
		// 返回按钮-悬浮
		.back_btn:hover {
		}
	}
	// 面包屑盒子
	.bread_view {
		:deep(.breadcrumb) {
			.el-breadcrumb__separator {
			}
			.first_breadcrumb {
				.el-breadcrumb__inner {
				}
			}
			.second_breadcrumb {
				.el-breadcrumb__inner {
				}
			}
		}
	}

	.detail_view{
		// 轮播图
		.swiper_view {
		}
		// 赞踩盒子
		.thumbs_view {
			.zan_view {

				.iconfont {
				}
				.iconfontActive {
				}
				span {
				}
				.textActive {
				}
			}
			.zan_view:hover {
				color: #fff;
				background: #feb043;
				border-color: #feb043;
			}
			.zan_view:active {
				transform: scale(0.8);
				background: #feb043;
			}
		}
		// 文字区
		.info_view {

			.title_view {

				.detail_title {
				}
				// 收藏盒子
				.collect_view {
					border: 0px solid #eee;
					cursor: pointer;
					border-radius: 10px;
					padding: 10px 0px;
					color: #999;
					background: #fff;
					display: flex;
					width: auto;
					line-height: 1;
					justify-content: center;
					align-items: center;
					.iconfont {
						margin: 0 5px 0 0;
						color: #888;
					}
					.iconfontActive {
						margin: 0 5px 0 0;
						color: #feb043;
					}
					span {
						color: #666;
					}
					.textActive {
						color: #feb043;
					}
				}
				.collect_view:hover {
				}
				.collect_view:active {
					transform: scale(0.8);
				}
			}

      .info_item {
        display: flex;
        justify-content: space-between;
        align-items: center;
        margin-bottom: 10px;

        .info_label {
          flex: 0 0 100px; /* 固定宽度 */
          font-weight: bold;
          color: #333;
        }

        .info_text {
          flex: 1;
          white-space: nowrap;
          overflow: hidden;
          text-overflow: ellipsis;
          color: #666;
          cursor: pointer;
        }

        .info_text:hover {
          color: #0076ca;
        }
      }

      .detail_view {
        display: flex;
        justify-content: space-between;
        align-items: flex-start;
        gap: 20px; /* 左右模块之间的间距 */
      }

      .info_view {
        flex: 1; /* 左侧信息模块占据剩余空间 */
      }

      .job_description_view {
        width: 40%; /* 右侧报考详情模块宽度 */
        padding: 20px;
        border: 1px solid #eee;
        border-radius: 4px;
        background-color: #f9f9f9;

        .job_description_title {
          font-size: 18px;
          font-weight: bold;
          margin-bottom: 10px;
          color: #333;
        }

        .job_description_content {
          font-size: 14px;
          color: #666;
          line-height: 1.6;
        }
      }


      .btn_view {
				// 修改-按钮
				.edit_btn {
				}
				// 悬浮
				.edit_btn:hover {
				}
				// 删除-按钮
				.del_btn {
				}
				// 悬浮
				.del_btn:hover {
				}
			}
		}
	}

	//底部盒子
	.tabs_view {
		:deep(.el-tabs__header) {
			background: transparent;
			border: none;
		}
		// 头部
		:deep(.el-tabs__nav-scroll) {
			.el-tabs__nav {
				.el-tabs__item {
				}
				.el-tabs__item:hover {
				}
				.is-active {
				}
			}
		}
		// 内容区
		:deep(.el-tabs__content) {
		}
		//评论
		//我的评论
		.my_comment_view {

			.my_comment_form {
				// 输入框
				:deep(.el-textarea__inner) {
				}
			}
			// 按钮盒子
			.comment_btn {
				// 评论按钮
				.add_btn {
				}
				// 悬浮
				.add_btn:hover {
				}
				// 重置按钮
				.reset_btn {
				}
				// 悬浮
				.reset_btn:hover {
				}
			}
		}

		//评论列表
		.comment_list {

			.comment {
				.comment_top {

					.comment_user {
						.comment_user_img {

							img {
								border-radius: 50%;
								width: 40px;
								height: 40px;
							}
						}
						.comment_user_info {
						}
					}
					.comment_time{
					}
				}

				.comment_bottom {
					.comment_content {
					}
					.comment_reply {
					}
				}
			}
		}
		// 分页器
		.el-pagination {
			// 总页码
			:deep(.el-pagination__total) {
			}
			// 上一页
			:deep(.btn-prev) {
			}
			// 下一页
			:deep(.btn-next) {
			}
			// 上一页禁用
			:deep(.btn-prev:disabled) {
			}
			// 下一页禁用
			:deep(.btn-next:disabled) {
			}
			// 页码
			:deep(.el-pager) {
				// 数字
				.number {
				}
				// 数字悬浮
				.number:hover {
				}
				// 选中
				.number.is-active {
				}
			}
			// sizes
			:deep(.el-pagination__sizes) {
				.el-select {
				//去掉默认样式
				.select-trigger{
					height: 100%;
					.el-input{
						height: 100%;

					}
				}
				}
			}
			// 跳页
			:deep(.el-pagination__jump) {
				// 输入框
				.el-input {

				}
			}
		}
	}
  .detail-page {
    padding: 20px;
  }

  .detail_view {
    display: flex;
    justify-content: space-between;
    gap: 20px; /* 左右模块之间的间距 */
    margin-top: 20px;
  }

  .info_view {
    flex: 1; /* 左侧信息模块占据剩余空间 */
    max-width: 60%; /* 限制左侧模块宽度 */
  }

  .job_description_view {
    width: 40%; /* 右侧报考详情模块宽度 */
    padding: 20px;
    border: 1px solid #eee;
    border-radius: 8px;
    background-color: #f9f9f9;
    box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);

    .job_description_title {
      font-size: 18px;
      font-weight: bold;
      margin-bottom: 16px;
      color: #333;
      border-bottom: 1px solid #eee;
      padding-bottom: 8px;
    }

    .job_description_content {
      font-size: 14px;
      color: #666;
      line-height: 1.6;

      /* 富文本内容样式 */
      p {
        margin: 8px 0;
      }

      ul, ol {
        margin: 8px 0;
        padding-left: 20px;
      }

      li {
        margin: 4px 0;
      }
    }
  }
</style>