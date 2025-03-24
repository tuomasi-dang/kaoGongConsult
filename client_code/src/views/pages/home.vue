<template>
	<div>
		<div class="home_box">
			<!-- 考公资料推荐 -->
			<div class="recomList_view">
				<div class="recomList_title">
                    <span>考公资料推荐</span>
                </div>
				<div class="categoryList">
					<div class="item" @click="kaoyanziliaoRecomCategoryChange(-1)" style="cursor: pointer" :class="{active:kaoyanziliaoRecom_index==-1}">全部</div>
					<div class="item" v-for="(item,index) in kaoyanziliaoRecomCategorys" @click="kaoyanziliaoRecomCategoryChange(index)" :class="{active:kaoyanziliaoRecom_index==index}" style="cursor: pointer">
						{{item}}
					</div>
				</div>
				<div class="recommendList">
					<div class="item" v-for="(item,index) in kaoyanziliaoRecomList" :key="index" @click="detailClick('kaoyanziliao',item.id)">
						<div class="img-box">
							<img v-if="isHttp(item.fengmian)" :src="item.fengmian.split(',')[0]" alt="">
							<img v-else :src="item.fengmian?$config.url + item.fengmian.split(',')[0]:''" alt="">
						</div>
						<div class="content-box">
							<div class="title">
								资料名称：{{item.ziliaomingcheng}}
							</div>
							<div class="title">
								资料分类：{{item.ziliaofenlei}}
							</div>
							<div class="price">
								￥{{item.price}}
							</div>
							<div class="statistic">
								<div class="like">
									<span class="iconfont icon-thumb-up-line1"></span>
									<div class="num">{{item.thumbsupNumber}}</div>
								</div>
								<div class="collect">
									<span class="iconfont icon-likeline4"></span>
									<div class="num">{{item.storeupNumber}}</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="recommend_more_view" @click="moreClick('kaoyanziliao')">
					<span class="recommend_more_text">更多</span>
				</div>
			</div>
			<!-- 报考指南首页展示 -->
      <div class="homeList_view">
        <div class="homeList_title">
          <el-icon class="title-icon"><Notification /></el-icon>
          <span>报考指南</span>
          <div class="title-decoration"></div>
        </div>
        <div class="home_list_two">
          <mySwiper
              :data="baokaozhinanHomeList"
              :type="3"
              :loop="false"
              :navigation="true"
              :pagination="false"
              :scrollbar="false"
              :slidesPerView="3"
              :spaceBetween="30"
              :autoHeight="false"
              :effectType="0"
              :autoplay="false">
            <template #default="scope">
              <div class="home_item card-hover" @click="detailClick('baokaozhinan',scope.row.id)">
                <div class="card-header">
                  <el-tag class="recruit-tag" effect="dark">
                    <el-icon><UserFilled /></el-icon>
                    招{{ scope.row.zhaokaorenshu }}人
                  </el-tag>
                  <div class="position-code">
                    <el-icon><Discount /></el-icon>
                    {{ scope.row.zhiweidaima }}
                  </div>
                </div>
                <div class="home_content">
                  <div class="department">
                    <el-icon class="icon"><OfficeBuilding /></el-icon>
                    <span class="text">{{ scope.row.bumenmingcheng }}</span>
                  </div>
                  <h3 class="position-title">{{ scope.row.zhiweimingcheng }}</h3>
                  <div class="position-info">
                    <div class="info-item">
                      <el-icon class="icon"><Reading /></el-icon>
                      <span class="label">学历：</span>
                      <span class="value">{{ scope.row.xueliyaoqiu || '不限' }}</span>
                    </div>
                    <div class="info-item">
                      <el-icon class="icon"><Histogram /></el-icon>
                      <span class="label">政治面貌：</span>
                      <span class="value">{{ scope.row.zhengzhimianmao || '不限' }}</span>
                    </div>
                  </div>
                  <div class="deadline">
                    <el-icon class="icon"><Clock /></el-icon>
                    <span class="text">报名截止：{{ scope.row.baomingshijian || '详见公告' }}</span>
                  </div>
                </div>
              </div>
            </template>
          </mySwiper>
        </div>
      </div>
			<!-- 考公资讯 -->
			<div class="newsList_view">
				<div class="ntitle"> <div class="n2">NEWS INFORMATION</div> <div class="n1">考公资讯</div> </div>
				
				    <div class="nlist">
				         <ul> 
				        <li v-for="(item,index) in newsList" :key="index" @click="newsDetailClick(item)">
				          
				          <div class="tim"><div class="t1">{{moment(item.addtime).format('DD')}}</div><div class="t2">{{moment(item.addtime).format('YYYY-MM-DD')}}</div></div>
				          
				          <div class="infobox">
				            <div class="nam">{{item.title}}</div>
				            <div class="info">{{item.introduction}}</div>
				          </div>
				          
				        </li>
				         </ul> 
				    </div>
				
				<div class="nmore" @click="moreClick('news')" style="cursor: pointer">更多</div>
			</div>

			<!--友情链接-->
			<div class="friendLink" v-if="friendLinkList && friendLinkList.length">
				<div class="title-wrapper">
					<div>友情链接</div>
				</div>
				<div class="list">
					<div class="item" v-for="(item,index) in friendLinkList" :key="index" @click="friendlinkClick(item.linkUrl)">
						<img class="img" :src="item.linkImage?($config.url + item.linkImage.split(',')[0]): ''">
						<div class="name">{{item.linkName}}</div>
					</div>
				</div>
			</div>
			<div class="appendBox1"></div>
		</div>
		<formModel ref="newsFormModelRef"></formModel>
	</div>
</template>

<script setup>
	import {
		ref,
		getCurrentInstance
	} from 'vue';
	import moment from 'moment'
	import {
		useRouter
	} from 'vue-router';
	const context = getCurrentInstance()?.appContext.config.globalProperties;
	const router = useRouter()
	//报考指南首页展示
	const baokaozhinanHomeList = ref([])
	const getbaokaozhinanHomeList = () => {
		let params = {
			page: 1,
			limit: 8
		}
		context?.$http({
			url: 'baokaozhinan/list',
			method: 'get',
			params: params
		}).then(res => {
			baokaozhinanHomeList.value = res.data.data.list
		})
	}
	//考公资料推荐
	const kaoyanziliaoRecomCategorys = ref([])
	const kaoyanziliaoRecom_index = ref(-1)
	const getkaoyanziliaoRecomCategorys = () => {
		context?.$http({
			url: 'option/ziliaofenlei/ziliaofenlei',
			method: 'get'
		}).then(res => {
			kaoyanziliaoRecomCategorys.value = res.data.data
		})
	}
	getkaoyanziliaoRecomCategorys()
	const kaoyanziliaoRecomCategoryChange = (index)=>{
		kaoyanziliaoRecom_index.value = index
		getkaoyanziliaoRecomList()
	}
	const kaoyanziliaoRecomList = ref([])
	const getkaoyanziliaoRecomList = () => {
		let autoSortUrl = 'kaoyanziliao/autoSort'
		if(context?.$toolUtil.storageGet('frontToken')){
			autoSortUrl = "kaoyanziliao/autoSort2"
		}
		let params = {
			page: 1,
			limit: 8
		}
		if(kaoyanziliaoRecom_index.value>=0){
            params.ziliaofenlei = kaoyanziliaoRecomCategorys.value[kaoyanziliaoRecom_index.value]
		}
		context?.$http({
			url: autoSortUrl,
			method: 'get',
			params: params
		}).then(res => {
			kaoyanziliaoRecomList.value = res.data.data.list
			kaoyanziliaoRecomList.value.forEach(item=>{
				if(!isHttp(item.fengmian)){
					item.imgUrls = item.fengmian.split(',').map(item=>context.$config.url+item)
				}
			})
		})
	}
	//考公资讯弹窗
	import formModel from './news/formModel'
	const newsFormModelRef = ref(null)
	//考公资讯
	const newsList = ref([])
	const getNewsList = () => {
		context?.$http({
			url: 'news/list',
			method: 'get',
			params:{
				page:1,
				limit: 4
			}
		}).then(res=>{
			newsList.value = res.data.data.list
			newsList.value.forEach(item=>{
				if(!isHttp(item.picture)){
					item.imgUrl=context.$config.url+item.picture.split(',')[0]
				}
			})
		})
	}
	const newsDetailClick = (item) => {
		if (item && item.id){
			newsFormModelRef.value.init(item.id)
		}
	}
	// 友情链
	const friendLinkList = ref([])
	const getFriendLinkList = ()=>{
		context.$http.get('friendshiplink/list', {
            params:{
                page: 1,
                limit: 6,
                sort:'id',
                order:'desc'
            }
        }).then(res => {
			if(res.data.code == 0) {
				friendLinkList.value = res.data.data.list
			}
		})
	}
	const friendlinkClick = (url)=>{
		if(url){
			window.open(url)
		}
	}
	//判断图片链接是否带http
	const isHttp = (str) => {
        return str && str.substr(0,4)=='http';
    }
	//跳转详情
	const detailClick = (table,id) => {
		router.push(`/index/${table}Detail?id=${id}`)
	}
	const moreClick = (table) => {
		router.push(`/index/${table}List`)
	}
	const init = () => {
		//报考指南首页展示
		getbaokaozhinanHomeList()
		//考公资料推荐
		getkaoyanziliaoRecomList()
		//考公资讯
		getNewsList()
		getFriendLinkList()
	}
	init()
</script>

<style lang="scss">
	.home_box {
	}

	// 推荐
	.recomList_view {
		.recomList_title {
		}
		// list
		// list
		// animation
		.animation_box {
			transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			z-index: initial;
		}
		.animation_box:hover {
			transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			-webkit-perspective: 1000px;
			perspective: 1000px;
			transition: 0.3s;
		}
		.animation_box img {
			transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			z-index: initial;
		}
		.animation_box img:hover {
			transform: rotate(0deg) scale(1.05) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			-webkit-perspective: 1000px;
			perspective: 1000px;
			transition: 0.3s;
		}
		// animation
		// 更多
		.recommend_more_view {
			cursor: pointer;
			top: 60px;
			position: absolute;
			right: calc((100% - 1180px)/2);
			.recommend_more_text {
			}
		}
	}
	// 推荐
	// 新闻资讯
	.newsList_view {

		.newsList_title {
		}
		// list
		.news_list_one {
			display: flex;
			flex-wrap: wrap;
			.news_item {
				box-shadow: 0 4px 6px rgba(0,0,0,.3);
				margin: 0 10px 10px;
				background: #fff;
				display: flex;
				width: calc(33% - 20px);
				align-items: center;
				.news_img_box {
					width: 40%;
					font-size: 0;
					.news_img {
						object-fit: cover;
						width: 100%;
						height: 200px;
					}
				}
				.news_content {
					margin: 0 0 0 20px;
					width: calc(60% - 20px);
					.news_title {
						font-weight: bold;
						font-size: 20px;
					}
					.news_text {
						font-size: 14px;
						line-height: 1.5;
					}
					.news_time {
						color: #999;
						width: 100%;
						text-align: right;
					}
				}
			}
		}
		// list
		// animation
		.animation_box {
			transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			z-index: initial;
		}
		.animation_box:hover {
			transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			-webkit-perspective: 1000px;
			perspective: 1000px;
			transition: 0.3s;
		}
		.animation_box img {
			transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			z-index: initial;
		}
		.animation_box img:hover {
			transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			-webkit-perspective: 1000px;
			perspective: 1000px;
			transition: 0.3s;
		}
		// animation
		// 更多
		.news_more_view {
			.news_more_text {
			}
			.el-icon {
			}
		}
	}
	// 新闻资讯
	// 首页展示
  .homeList_view {
    padding: 40px 0;
    background: linear-gradient(135deg, #f8f9fe 0%, #f1f4ff 100%);

    .homeList_title {
      position: relative;
      text-align: center;
      margin-bottom: 40px;

      .title-icon {
        font-size: 28px;
        color: var(--el-color-primary);
        margin-right: 12px;
        vertical-align: middle;
      }

      span {
        font-size: 24px;
        font-weight: 600;
        color: #2c3e50;
        vertical-align: middle;
      }

      .title-decoration {
        position: absolute;
        bottom: -15px;
        left: 50%;
        transform: translateX(-50%);
        width: 60px;
        height: 3px;
        background: var(--el-color-primary);
        border-radius: 2px;
      }
    }

    .home_list_two {
      max-width: 1200px;
      margin: 0 auto;
      padding: 0 20px;
    }

    .home_item {
      background: white;
      border-radius: 12px;
      padding: 20px;
      box-shadow: 0 4px 12px rgba(0,0,0,0.08);
      transition: all 0.3s ease;
      margin-bottom: 30px;

      &.card-hover:hover {
        transform: translateY(-5px);
        box-shadow: 0 8px 20px rgba(0,0,0,0.12);

        .position-title {
          color: var(--el-color-primary);
        }
      }

      .card-header {
        display: flex;
        justify-content: space-between;
        align-items: center;
        margin-bottom: 15px;

        .recruit-tag {
          font-size: 14px;
          padding: 6px 12px;
          .el-icon {
            margin-right: 6px;
          }
        }

        .position-code {
          font-size: 13px;
          color: #666;
          .el-icon {
            margin-right: 5px;
            color: var(--el-color-primary);
          }
        }
      }

      .home_content {
        .department {
          display: flex;
          align-items: center;
          margin-bottom: 12px;
          .icon {
            color: #7e8c9c;
            margin-right: 8px;
          }
          .text {
            font-size: 15px;
            color: #4a5568;
          }
        }

        .position-title {
          font-size: 18px;
          color: #2c3e50;
          margin: 0 0 15px;
          transition: color 0.3s;
        }

        .position-info {
          .info-item {
            display: flex;
            align-items: center;
            margin-bottom: 10px;
            font-size: 14px;
            .icon {
              color: #a0aec0;
              margin-right: 8px;
            }
            .label {
              color: #718096;
            }
            .value {
              color: #4a5568;
            }
          }
        }

        .deadline {
          display: flex;
          align-items: center;
          margin-top: 15px;
          padding-top: 15px;
          border-top: 1px solid #eee;
          .icon {
            color: #e53e3e;
            margin-right: 8px;
          }
          .text {
            font-size: 14px;
            color: #e53e3e;
          }
        }
      }
    }
  }
	// 首页展示
</style>
<style>
.home_box{
    width: 100%;
    margin: 0px auto;
    display: flex;
    flex-wrap: wrap;
    justify-content: space-between;
}
.home_box .appendBox1{
    width: 100%;
    height:299px;
    background:url(http://clfile.zggen.cn/20240927/708c7343aeeb4d728265133426b664a4.jpg) no-repeat center top / 100% 100%;
    order:8;
}
/* 总盒子 */
.recomList_view {
    width: 100%;
    margin:0;
    padding: 20px 0 50px;
    background: url(http://clfile.zggen.cn/20240927/91099cb5630e43b78fe4bdc325232fa7.png) fixed no-repeat center top / cover,var(--theme50);
    overflow: hidden;
    position:relative;
    order: 3;
    display: block;
}
/* 标题 */
.recomList_view .recomList_title{
    width: 1200px;
    margin:30px auto;
    background:url(http://clfile.zggen.cn/20240927/413033afa8644152b027d13e3b7caced.png) no-repeat center bottom;
    text-align: center;
    padding: 0 0 20px;
    font-size: 22px;
    color:#333;
}
/* 分类 */
.recomList_view .categoryList{
    display: none;
    flex-wrap: wrap;
}
.recomList_view .categoryList .item{
}

/* 样式七 总盒子 */
.recomList_view .recommendList{
    width: 1200px;
    margin: 0 auto;
    display: flex;
    flex-wrap: wrap;
    margin: 0px auto;
}
.recomList_view .recommendList .item{
    width: calc(25% - 20px);
    margin: 0px 10px 20px;
    background: rgb(255, 255, 255);
    cursor: pointer;
    height: 280px;
    overflow:hidden;
    position:relative;
}
.recomList_view .recommendList .item .img-box{
    width: 100%;
    height: 100%;
    overflow: hidden;
    margin: 0px 0px 5px;
}
.recomList_view .recommendList .item .img-box img{
    width: 100%;
    height: 100%;
    object-fit: cover;
}
.recomList_view .recommendList .item .content-box{
    width: 100%;
    position:absolute; left:0px; bottom:-100%; background:rgba(255, 255, 255, .8); width:100%; padding:10px 20px; transition:all 0.5s; display:flex; flex-wrap:wrap; align-items:center; justify-content:center;flex-direction:column; text-align:center;
}
.recomList_view .recommendList .item:hover .content-box{ bottom:0px; background:rgba(0, 0, 0, .5); height:100%; }

.recomList_view .recommendList .item .content-box .title{
    width: 100%;
    line-height: 24px;
    white-space:nowrap;
    overflow:hidden;
    text-overflow:ellipsis;
}
.recomList_view .recommendList .item:hover .content-box .title{
    color: #eee;
}
.recomList_view .recommendList .item .content-box .price{
    width: 100%;
    text-align:center;
    color: #f00;
    font-size:16px;
}
.recomList_view .recommendList .item:hover .content-box .price{
}
.recomList_view .recommendList .item .content-box .statistic{
    width: 100%;
    display: flex;
    align-items: center;
    justify-content: center;
    margin:10px 0 0;
}
.recomList_view .recommendList .item:hover .content-box .statistic{
    color: #ccc;
}
.recomList_view .recommendList .item .content-box .statistic .iconfont{
    color: inherit;
    margin: 0px 4px 0px 0px;
}
.recomList_view .recommendList .item .content-box .statistic .num{
    color: inherit;
}
.recomList_view .recommendList .item .content-box .statistic .like{
    display: flex;
    align-items: center;
    color: inherit;
    font-size: 16px;
    margin: 0px 10px 0px 0px;
}
.recomList_view .recommendList .item .content-box .statistic .collect{
    display: flex;
    align-items: center;
    color: inherit;
    font-size: 16px;
    margin: 0px 10px 0px 0px;
}
.recomList_view .recommendList .item .content-box .statistic .clickNum{
    display: flex;
    align-items: center;
    color: inherit;
    font-size: 16px;
    margin: 0px 10px 0px 0px;
}
/* 总盒子*/
.homeList_view {
    width: 100%;
    margin: 20px 10px 0;
    padding: 0;
    background: #fff;
    overflow: hidden;
    position:relative;
    order: 5;
    display: block;
}
/* 标题 */
.homeList_view .homeList_title{
    width: 1200px;
    margin:30px auto;
    background:url(http://clfile.zggen.cn/20240927/413033afa8644152b027d13e3b7caced.png) no-repeat center bottom;
    text-align: center;
    padding: 0 0 20px;
    font-size: 22px;
    color:#333;
}
/* 样式五 盒子 */
.homeList_view .home_list_two{
    width: 1200px !important;
    margin:30px auto;
    display: flex;
    flex-wrap: wrap;
    align-items: flex-start;
}


/* 总盒子 */
.newsList_view {
    width: 100%;
    margin:0;
    padding: 30px 0;
    background: #fff url(http://clfile.zggen.cn/20240927/0ac15177583b4bacb8d617aff9494909.jpg);
    overflow: hidden;
    position:relative;
    order: 6;
    display:block;
}
/* 自定义 start*/
.newsList_view .ntitle{
    width: 1200px;
    margin:0 auto;
    background:url(http://clfile.zggen.cn/20240927/413033afa8644152b027d13e3b7caced.png) no-repeat center bottom;
    text-align: center;
    padding: 0 0 20px;
}
.newsList_view .ntitle .n1{
    display:block;
    font-size: 22px;
    color:#333;
    font-weight:500;
}
.newsList_view .ntitle .n2{
    display:block;
    font-size: 18px;
    line-height:30px;
    color:#888;
    margin-left:5px;
}
.newsList_view .nlist{
    width: 1200px;
    margin:30px auto 0;
}
.newsList_view .nlist ul{
    margin:0;
    padding:0;
    display: flex;
    flex-wrap: wrap;
    align-items: center;
    justify-content: space-between;
}
.newsList_view .nlist ul li{
    width: 48%;
    text-align: left;
    background: none;
    border: 0px dashed #aaa;
    cursor:pointer;
    display: flex;
    flex-wrap: wrap;
    align-items: center;
    justify-content: space-between;
    margin:0 0 30px;
}
.newsList_view .nlist ul li:last-child{
    border-bottom: none;
}
.newsList_view .nlist ul li .tim {
    display: flex;
    flex-wrap: wrap;
    width: 80px;
}
.newsList_view .nlist ul li .tim .t1 {
    width: 100%;
    text-align: center;
    font-size: 48px;
    line-height: 1;
    border-bottom:1px solid #ddd;
}
.newsList_view .nlist ul li:hover .tim .t1 {
    color:#0076ca;
    border-bottom:1px solid #0076ca;
}
.newsList_view .nlist ul li .tim .t2 {
    width: 100%;
    text-align: center;
    line-height: 30px;
}
.newsList_view .nlist ul li:hover .tim .t2 {
    color:#ff6600;
}
.newsList_view .nlist ul li .infobox {
    width: calc(100% - 110px);
    flex: 1;
    padding:0 20px 20px;
    background:url(http://clfile.zggen.cn/20240927/d0b3c8896c1c4b7986c66937670e76d5.png) no-repeat right bottom;
}
.newsList_view .nlist ul li:hover .infobox {
    background:url(http://clfile.zggen.cn/20240927/a8725863a0f24454ae5e0881ac5b901b.png) no-repeat right bottom;
}
.newsList_view .nlist ul li .infobox .nam {
    font-size: 16px;
    font-weight: 600;
}
.newsList_view .nlist ul li:hover .infobox .nam {
    color:#333;
}
.newsList_view .nlist ul li:hover .infobox .nam{
    color:#0076ca;
}
.newsList_view .nlist ul li .infobox .info {
    font-size: 15px;
    color: #888;
    line-height: 24px;
    height:48px;
    overflow:hidden;
    margin-top: 5px;
}
.newsList_view .nmore{
    position:absolute;
    top:60px;
    right:calc((100% - 1180px)/2);
}
/* 自定义 end*/

.friendLink {
    width: 100%;
    margin:20px 10px;
    padding: 0px calc((100% - 1200px)/2);
    background: #fff;
    overflow: hidden;
    position:relative;
    order: 12;
}
.friendLink .title-wrapper {
    width: 1200px;
    margin:10px auto;
    background:url(http://clfile.zggen.cn/20240927/413033afa8644152b027d13e3b7caced.png) no-repeat center bottom;
    text-align: center;
    padding: 0 0 20px;
    font-size: 22px;
    color:#333;
}
.friendLink .list {
    display: block;
    column-gap: 20px;
    text-align: center;
    margin:10px 0 0;
}
.friendLink .list .item{
    width: auto;
    display: inline-block;
    cursor:pointer;
    margin:0 10px 10px 0;
}
.friendLink .list .item img {
    width: 100%;
    height:90px;
    object-fit:cover;
    display: none;
}
.friendLink .list .item .name{
    font-size: 14px;
    line-height: 30px;
}

</style>