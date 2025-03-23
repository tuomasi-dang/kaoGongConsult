<template>
	<div class="home_view">
		<div class="projectTitle">欢迎使用 {{projectName}}</div>
		<div class="count_list">
			<el-collapse-transition v-if="btnAuth('kaoyanziliao','首页总数')">
				<el-card v-show="countTypeList.closekaoyanziliaoCountType" class="card_view count-item">
					<template #header>
						<div class="index_card_head">
							<div class="card_head_title">
								考公资料
							</div>
							<div class="card_head_right">
								<el-icon @click="countTypeClick('hiddenkaoyanziliaoCountType')" class="showIcons"
									:class="countTypeList.hiddenkaoyanziliaoCountType?'showIcons1':''">
									<ArrowUpBold />
								</el-icon>
								<el-icon @click="countTypeClick('closekaoyanziliaoCountType')" class="closeIcons">
									<CloseBold />
								</el-icon>
							</div>
						</div>
					</template>
					<el-collapse-transition>
						<div class="count_item" v-show="countTypeList.hiddenkaoyanziliaoCountType">
							<div class="count_title">考公资料总数</div>
							<div class="count_num">{{kaoyanziliaoCount}}</div>
						</div>
					</el-collapse-transition>
				</el-card>
			</el-collapse-transition>
			<el-collapse-transition v-if="btnAuth('orders','首页总数')">
				<el-card v-show="countTypeList.closeordersCountType" class="card_view count-item">
					<template #header>
						<div class="index_card_head">
							<div class="card_head_title">
								商品订单
							</div>
							<div class="card_head_right">
								<el-icon @click="countTypeClick('hiddenordersCountType')" class="showIcons"
									:class="countTypeList.hiddenordersCountType?'showIcons1':''">
									<ArrowUpBold />
								</el-icon>
								<el-icon @click="countTypeClick('closeordersCountType')" class="closeIcons">
									<CloseBold />
								</el-icon>
							</div>
						</div>
					</template>
					<el-collapse-transition>
						<div class="count_item" v-show="countTypeList.hiddenordersCountType">
							<div class="count_title">商品订单总数</div>
							<div class="count_num">{{ordersCount}}</div>
						</div>
					</el-collapse-transition>
				</el-card>
			</el-collapse-transition>
		</div>
		<div class="card_list">
			<el-collapse-transition v-if="btnAuth('kaoyanziliao','首页统计')">
				<el-card v-show="cardTypeList.closekaoyanziliaoChartType1" class="card_view chart-item">
					<template #header>
						<div class="index_card_head">
							<div class="card_head_title">
								考公资料
							</div>
							<div class="card_head_right">
								<el-icon @click="cardTypeClick('hiddenkaoyanziliaoChartType1')" class="showIcons"
										 :class="cardTypeList.hiddenkaoyanziliaoChartType1?'showIcons1':''">
									<ArrowUpBold />
								</el-icon>
								<el-icon @click="cardTypeClick('closekaoyanziliaoChartType1')" class="closeIcons">
									<CloseBold />
								</el-icon>
							</div>
						</div>
					</template>
					<el-collapse-transition>
						<div class="card_item" v-show="cardTypeList.hiddenkaoyanziliaoChartType1">
							<div id="kaoyanziliaoziliaofenleiEchart1" class="Echart" style="width: 100%;height: 400px;"></div>
						</div>
					</el-collapse-transition>
				</el-card>
			</el-collapse-transition>
			<el-collapse-transition v-if="btnAuth('orders','首页统计')">
				<el-card v-show="cardTypeList.closeordersChartType1" class="card_view chart-item">
					<template #header>
						<div class="index_card_head">
							<div class="card_head_title">
								商品订单
							</div>
							<div class="card_head_right">
								<el-icon @click="cardTypeClick('hiddenordersChartType1')" class="showIcons"
										 :class="cardTypeList.hiddenordersChartType1?'showIcons1':''">
									<ArrowUpBold />
								</el-icon>
								<el-icon @click="cardTypeClick('closeordersChartType1')" class="closeIcons">
									<CloseBold />
								</el-icon>
							</div>
						</div>
					</template>
					<el-collapse-transition>
						<div class="card_item" v-show="cardTypeList.hiddenordersChartType1">
							<div id="ordersbuynumberEchart1" class="Echart" style="width: 100%;height: 400px;"></div>
						</div>
					</el-collapse-transition>
				</el-card>
			</el-collapse-transition>
			<el-collapse-transition v-if="btnAuth('orders','首页统计')">
				<el-card v-show="cardTypeList.closeordersChartType2" class="card_view chart-item">
					<template #header>
						<div class="index_card_head">
							<div class="card_head_title">
								商品订单
							</div>
							<div class="card_head_right">
								<el-icon @click="cardTypeClick('hiddenordersChartType2')" class="showIcons"
										 :class="cardTypeList.hiddenordersChartType2?'showIcons2':''">
									<ArrowUpBold />
								</el-icon>
								<el-icon @click="cardTypeClick('closeordersChartType2')" class="closeIcons">
									<CloseBold />
								</el-icon>
							</div>
						</div>
					</template>
					<el-collapse-transition>
						<div class="card_item" v-show="cardTypeList.hiddenordersChartType2">
							<div id="ordersbuynumberEchart2" class="Echart" style="width: 100%;height: 400px;"></div>
						</div>
					</el-collapse-transition>
				</el-card>
			</el-collapse-transition>
			<el-collapse-transition v-if="btnAuth('orders','首页统计')">
				<el-card v-show="cardTypeList.closeordersChartType3" class="card_view chart-item">
					<template #header>
						<div class="index_card_head">
							<div class="card_head_title">
								商品订单
							</div>
							<div class="card_head_right">
								<el-icon @click="cardTypeClick('hiddenordersChartType3')" class="showIcons"
										 :class="cardTypeList.hiddenordersChartType3?'showIcons3':''">
									<ArrowUpBold />
								</el-icon>
								<el-icon @click="cardTypeClick('closeordersChartType3')" class="closeIcons">
									<CloseBold />
								</el-icon>
							</div>
						</div>
					</template>
					<el-collapse-transition>
						<div class="card_item" v-show="cardTypeList.hiddenordersChartType3">
							<div id="orderstotalEchart3" class="Echart" style="width: 100%;height: 400px;"></div>
						</div>
					</el-collapse-transition>
				</el-card>
			</el-collapse-transition>
			<el-collapse-transition v-if="btnAuth('orders','首页统计')">
				<el-card v-show="cardTypeList.closeordersChartType4" class="card_view chart-item">
					<template #header>
						<div class="index_card_head">
							<div class="card_head_title">
								商品订单
							</div>
							<div class="card_head_right">
								<el-icon @click="cardTypeClick('hiddenordersChartType4')" class="showIcons"
										 :class="cardTypeList.hiddenordersChartType4?'showIcons4':''">
									<ArrowUpBold />
								</el-icon>
								<el-icon @click="cardTypeClick('closeordersChartType4')" class="closeIcons">
									<CloseBold />
								</el-icon>
							</div>
						</div>
					</template>
					<el-collapse-transition>
						<div class="card_item" v-show="cardTypeList.hiddenordersChartType4">
							<div id="orderstotalEchart4" class="Echart" style="width: 100%;height: 400px;"></div>
						</div>
					</el-collapse-transition>
				</el-card>
			</el-collapse-transition>
			<el-collapse-transition v-if="btnAuth('orders','首页统计')">
				<el-card v-show="cardTypeList.closeordersChartType5" class="card_view chart-item">
					<template #header>
						<div class="index_card_head">
							<div class="card_head_title">
								商品订单
							</div>
							<div class="card_head_right">
								<el-icon @click="cardTypeClick('hiddenordersChartType5')" class="showIcons"
										 :class="cardTypeList.hiddenordersChartType5?'showIcons5':''">
									<ArrowUpBold />
								</el-icon>
								<el-icon @click="cardTypeClick('closeordersChartType5')" class="closeIcons">
									<CloseBold />
								</el-icon>
							</div>
						</div>
					</template>
					<el-collapse-transition>
						<div class="card_item" v-show="cardTypeList.hiddenordersChartType5">
							<div id="ordersbuynumberEchart5" class="Echart" style="width: 100%;height: 400px;"></div>
						</div>
					</el-collapse-transition>
				</el-card>
			</el-collapse-transition>
		</div>
	</div>
</template>

<script setup>
	import {
		inject,
		nextTick,
		ref,
		getCurrentInstance
	} from 'vue';
	const context = getCurrentInstance()?.appContext.config.globalProperties;
	const projectName = context.$project.projectName
	const countTypeList = ref({
	})
	const getCountList=()=>{
		countTypeList.value.closekaoyanziliaoCountType = true
		countTypeList.value.hiddenkaoyanziliaoCountType = true
		if(btnAuth('kaoyanziliao','首页总数')){
			getkaoyanziliaoCount()
		}
		countTypeList.value.closeordersCountType = true
		countTypeList.value.hiddenordersCountType = true
		if(btnAuth('orders','首页总数')){
			getordersCount()
		}
	}
	const kaoyanziliaoCount = ref(0)
	const getkaoyanziliaoCount = () => {
		context?.$http({
			url:'kaoyanziliao/count',
			method: 'get'
		}).then(res=>{
			kaoyanziliaoCount.value = res.data.data
		})
	}
	const ordersCount = ref(0)
	const getordersCount = () => {
		context?.$http({
			url:'orders/count',
			method: 'get'
		}).then(res=>{
			ordersCount.value = res.data.data
		})
	}
	const countTypeClick = (e) => {
		countTypeList.value[e] = !countTypeList.value[e]
	}
	//权限验证
	const btnAuth = (e,a)=>{
		return context?.$toolUtil.isAuth(e,a)
	}
	let echarts = inject("echarts")
	const cardTypeClick = (e) =>{
		cardTypeList.value[e] = !cardTypeList.value[e]
		setTimeout(()=>{
			getCardList()
		},1000)
	}
	const cardTypeList = ref({
		closekaoyanziliaoChartType1: true,
		hiddenkaoyanziliaoChartType1: true,
		closeordersChartType1: true,
		hiddenordersChartType1: true,
		closeordersChartType2: true,
		hiddenordersChartType2: true,
		closeordersChartType3: true,
		hiddenordersChartType3: true,
		closeordersChartType4: true,
		hiddenordersChartType4: true,
		closeordersChartType5: true,
		hiddenordersChartType5: true,
	})
	const getCardList = () => {
		if(btnAuth('kaoyanziliao','首页统计')){
			getkaoyanziliaoChart1()
		}
		if(btnAuth('orders','首页统计')){
			getordersChart1()
		}
		if(btnAuth('orders','首页统计')){
			getordersChart2()
		}
		if(btnAuth('orders','首页统计')){
			getordersChart3()
		}
		if(btnAuth('orders','首页统计')){
			getordersChart4()
		}
		if(btnAuth('orders','首页统计')){
			getordersChart5()
		}
	}
	import '@/assets/js/echarts-theme'
	const getkaoyanziliaoChart1 = () => {
		nextTick(()=>{
			var ziliaofenleiEchart1 = echarts.init(document.getElementById("kaoyanziliaoziliaofenleiEchart1"),'theme');
			context?.$http({
				url: "kaoyanziliao/group/ziliaofenlei",
				method: "get",
			}).then(obj=>{
				let res = obj.data.data
				let xAxis = [];
				let yAxis = [];
				let dataList = []
				for(let i=0;i<res.length;i++){
				    xAxis.push(res[i].ziliaofenlei);
				    yAxis.push(parseFloat((res[i].total)));
					dataList.push({
				        value: parseFloat((res[i].total)),
				        name: res[i].ziliaofenlei
				    })
				}
				var option = {};
				option = {
    title:{
        text: '资料分类统计',
        left: 'center'
    },
    legend: {
        orient: 'vertical',
        left: 'left'
    },
    tooltip: {
        trigger: 'item',
        formatter: '{b} : {c} ({d}%)'
    },
    series: [
        {
            type: 'pie',
            radius: '55%',
            center: ['50%', '60%'],
            data: dataList,
            emphasis: {
                itemStyle: {
                  shadowBlur: 10,
                  shadowOffsetX: 0,
                  shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            }
        }
    ]
}
				ziliaofenleiEchart1.clear()
				// 使用刚指定的配置项和数据显示图表。
				ziliaofenleiEchart1.setOption(option);
				//根据窗口的大小变动图表
				ziliaofenleiEchart1.resize();
			})
		})
	}
	const getordersChart1 = () => {
		nextTick(()=>{
			var buynumberEchart1 = echarts.init(document.getElementById("ordersbuynumberEchart1"),'theme');
			context?.$http({
				url: `orders/value/addtime/buynumber/日`,
				method: "get",
			}).then(obj=>{
				let res = obj.data.data
				let xAxis = [];
				let yAxis = [];
				let dataList = []
				for(let i=0;i<res.length;i++){
				    xAxis.push(res[i].addtime);
				    yAxis.push(parseFloat((res[i].total)));
					dataList.push({
				        value: parseFloat((res[i].total)),
				        name: res[i].addtime
				    })
				}
				var option = {};
				option = {
    title: {
        text: '日销量统计',
        left: 'center'
    },
    tooltip: {
        trigger: 'item',
        formatter: '{b} : {c}'
    },
    xAxis: {
        data: xAxis,
        type: 'category',
    },
    yAxis: {
        type: 'value'
    },
    series:{
        data: yAxis,
        type: 'bar'
    }
}

				buynumberEchart1.clear()
				// 使用刚指定的配置项和数据显示图表。
				buynumberEchart1.setOption(option);
				//根据窗口的大小变动图表
				buynumberEchart1.resize();
			})
		})
	}
	const getordersChart2 = () => {
		nextTick(()=>{
			var buynumberEchart2 = echarts.init(document.getElementById("ordersbuynumberEchart2"),'theme');
			context?.$http({
				url: `orders/value/addtime/buynumber/月`,
				method: "get",
			}).then(obj=>{
				let res = obj.data.data
				let xAxis = [];
				let yAxis = [];
				let dataList = []
				for(let i=0;i<res.length;i++){
				    xAxis.push(res[i].addtime);
				    yAxis.push(parseFloat((res[i].total)));
					dataList.push({
				        value: parseFloat((res[i].total)),
				        name: res[i].addtime
				    })
				}
				var option = {};
				option = {
    title: {
        text: '月销量统计',
        left: 'center'
    },
    tooltip: {
        trigger: 'item',
        formatter: '{b} : {c}'
    },
    xAxis: {
        data: xAxis,
        type: 'category',
    },
    yAxis: {
        type: 'value'
    },
    series:{
        data: yAxis,
        type: 'bar'
    }
}
                var middle = option.xAxis
                option.xAxis = option.yAxis
                option.yAxis = middle

				buynumberEchart2.clear()
				// 使用刚指定的配置项和数据显示图表。
				buynumberEchart2.setOption(option);
				//根据窗口的大小变动图表
				buynumberEchart2.resize();
			})
		})
	}
	const getordersChart3 = () => {
		nextTick(()=>{
			var totalEchart3 = echarts.init(document.getElementById("orderstotalEchart3"),'theme');
			context?.$http({
				url: `orders/value/addtime/total/日`,
				method: "get",
			}).then(obj=>{
				let res = obj.data.data
				let xAxis = [];
				let yAxis = [];
				let dataList = []
				for(let i=0;i<res.length;i++){
				    xAxis.push(res[i].addtime);
				    yAxis.push(parseFloat((res[i].total)));
					dataList.push({
				        value: parseFloat((res[i].total)),
				        name: res[i].addtime
				    })
				}
				var option = {};
				option = {
    title: {
        text: '日销额统计',
        left: 'center'
    },
    tooltip: {
        trigger: 'item',
        formatter: '{b} : {c}'
    },
    xAxis: {
        data: xAxis,
        type: 'category',
    },
    yAxis: {
        type: 'value'
    },
    series:{
        data: yAxis,
        type: 'line'
    }
}
				totalEchart3.clear()
				// 使用刚指定的配置项和数据显示图表。
				totalEchart3.setOption(option);
				//根据窗口的大小变动图表
				totalEchart3.resize();
			})
		})
	}
	const getordersChart4 = () => {
		nextTick(()=>{
			var totalEchart4 = echarts.init(document.getElementById("orderstotalEchart4"),'theme');
			context?.$http({
				url: `orders/value/addtime/total/月`,
				method: "get",
			}).then(obj=>{
				let res = obj.data.data
				let xAxis = [];
				let yAxis = [];
				let dataList = []
				for(let i=0;i<res.length;i++){
				    xAxis.push(res[i].addtime);
				    yAxis.push(parseFloat((res[i].total)));
					dataList.push({
				        value: parseFloat((res[i].total)),
				        name: res[i].addtime
				    })
				}
				var option = {};
				option = {
    title: {
        text: '月销额统计',
        left: 'center'
    },
    tooltip: {
        trigger: 'item',
        formatter: '{b} : {c}'
    },
    xAxis: {
        data: xAxis,
        type: 'category',
    },
    yAxis: {
        type: 'value'
    },
    series:{
        data: yAxis,
        type: 'line'
    }
}
                Object.assign(option.series,{smooth: true})
				totalEchart4.clear()
				// 使用刚指定的配置项和数据显示图表。
				totalEchart4.setOption(option);
				//根据窗口的大小变动图表
				totalEchart4.resize();
			})
		})
	}
	const getordersChart5 = () => {
		nextTick(()=>{
			var buynumberEchart5 = echarts.init(document.getElementById("ordersbuynumberEchart5"),'theme');
			context?.$http({
				url: `orders/value/goodname/buynumber`,
				method: "get",
			}).then(obj=>{
				let res = obj.data.data
				let xAxis = [];
				let yAxis = [];
				let dataList = []
				for(let i=0;i<res.length;i++){
				    xAxis.push(res[i].goodname);
				    yAxis.push(parseFloat((res[i].total)));
					dataList.push({
				        value: parseFloat((res[i].total)),
				        name: res[i].goodname
				    })
				}
				var option = {};
				option = {
    title: {
        text: '品销量统计',
        left: 'center'
    },
    tooltip: {
        trigger: 'item',
        formatter: '{b} : {c}'
    },
    xAxis: {
        data: xAxis,
        type: 'category',
    },
    yAxis: {
        type: 'value'
    },
    series:{
        data: yAxis,
        type: 'line'
    }
}
                Object.assign(option.series,{areaStyle: {}, smooth: true})
				buynumberEchart5.clear()
				// 使用刚指定的配置项和数据显示图表。
				buynumberEchart5.setOption(option);
				//根据窗口的大小变动图表
				buynumberEchart5.resize();
			})
		})
	}

	const init=()=>{
		getCountList()
		getCardList()
	}
	init()
</script>
<style lang="scss">
	// 首页盒子
	.home_view {
	}
	.home_view .projectTitle{
	}

	.showIcons {
		transition: transform 0.3s;
		margin-right: 10px;
	}

	.showIcons1 {
		transform: rotate(-180deg);
	}
	
	// 总数盒子
	.count_list{
		// 总数card
		.card_view {
			// card头部
			.el-card__header {
				// 头部盒子
				.index_card_head {
					// 标题
					.card_head_title {
					}
					// 按钮盒子
					.card_head_right {
						// 按钮
						.el-icon {
						}
					}
				}
			}
			// body
			.el-card__body {
				// body盒子
				.count_item{
					// 总数标题
					.count_title{
					}
					// 总数数字
					.count_num{
					}
				}
			}
		}
	}

	// 统计图盒子
	.card_list {
		// 统计图card
		.card_view {
			// 头部
			.el-card__header {
				// 头部盒子
				.index_card_head {
					// 标题
					.card_head_title {
					}
					// 按钮盒子
					.card_head_right {
						// 按钮
						.el-icon{
						}
					}
				}
			}
			// body
			.el-card__body {
				// body盒子
				.card_item{
				}
			}
		}
	}
</style>
<style>
.home_view .projectTitle {
    display: none;
}

.home_view .el-card__header {display: none;}

.home_view .count_list {
    display: flex;
    column-gap: 30px;
    order: 1;
    flex: 1;
}

.home_view {
    padding: 20px 60px;
    display: flex;
    flex-wrap: wrap;
    row-gap: 30px;
    column-gap: 30px;
}

.home_view .count_list .card_view {
    flex: 1;
    height: 100px;
    box-shadow: none;
    background-image: url(http://clfile.zggen.cn/20241107/51775843f83145358ee7bceba9093325.png);
    background-color: transparent;
    border-radius: 0;
    background-size: 100% 100%;
}

.home_view .count_title {
    font-weight: 400;
    font-size: 14px;
    order: 1;
    color: #969696;
}

.home_view .count_num {font-size: 30px;color: #000000;}

.home_view .count_item {
    display: flex;
    flex-direction: column;
}

.home_view .card_list {
    order: 3;
    display: grid;
    grid-template-columns: 1fr 1fr;
    column-gap: 30px;
    row-gap: 30px;
    position: relative;
    width: 100%;
}

.count_list .el-card__body {
    position: relative;
}

.chart-item {
    box-shadow: none!important;
}
.home-calendar{
  border: 0px solid rgb(238, 238, 238);
  box-shadow: rgba(0, 0, 0, 0.1) 0px 0px 0px;
  margin: 0px auto 30px;
  border-radius: 0px;
  color: rgb(102, 102, 102);
  background: none;
  width: calc(100% - 310px);
  font-size: inherit;
  height: auto;
}
.home-calendar .header{
  padding: 17px 40px;
  border-color: rgba(126, 96, 16, 0.1);
  flex-wrap: wrap;
  background: linear-gradient( 135deg, var(--theme) 0%, #6CACFF 100%);
  border-width: 0px 0px 1px;
  display: flex;
  width: 100%;
  border-style: solid;
  justify-content: space-between;
  height: auto;
  border-radius: 10px 10px 10px 10px;
}
.home-calendar .header .btn{
  cursor: pointer;
  border: 0px solid rgb(153, 153, 153);
  padding: 0px 0px 0px 12px;
  align-items: center;
  color: rgb(102, 102, 102);
  border-radius: 4px;
  display: flex;
  width: auto;
  font-size: inherit;
  justify-content: center;
}
.home-calendar .header .title{
  padding: 0px 10px;
  font-size: 24px;
  align-items: center;
  justify-content: center;
  display: flex;
  color: rgb(51, 51, 51);
}
.home-calendar table{
  width: 100%;
  padding: 0px 0px 20px;
  height: auto;
}
.home-calendar tbody,thead{
  width: 100%;
}
.home-calendar tr{
  width: 100%;
  align-items: center;
  justify-content: center;
  display: flex;
}
.home-calendar th{
  align-items: center;
  flex: 1;
  display: flex;
  line-height: 50px;
  justify-content: center;
}
.home-calendar td{
  cursor: pointer;
  padding: 6px 12px 12px;
  flex: 1;
  display: flex;
  justify-content: center;
  text-align: center;
}
.home-calendar {
    order: 2;
    width: 100%;
    margin: 0;
    height: 435px;
    background: #fff;
    padding: 20px;
}

.home-calendar .header * {
    color: #fff!important;
}

.home-calendar table {
    font-size: 12px;
    line-height: 12px;
}
</style>
