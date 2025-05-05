<template>
  <div class="list-page" :style='{}'>
    <div class="breadcrumb-wrapper" style="width: 100%;">
      <div class="bread_view">
        <el-breadcrumb separator="/" class="breadcrumb">
          <el-breadcrumb-item class="first_breadcrumb" :to="{ path: '/' }">首页</el-breadcrumb-item>
          <el-breadcrumb-item class="second_breadcrumb" v-for="(item,index) in breadList" :key="index">{{ item.name }}
          </el-breadcrumb-item>
        </el-breadcrumb>
      </div>
      <div class="back_view" v-if="centerType">
        <el-button class="back_btn" @click="backClick" type="primary">返回</el-button>
      </div>
    </div>
    <!-- 公告栏 -->
    <div class="notice-wrapper">
      <div class="notice-bar">
        <el-alert type="info" :closable="false">
          <template #title>
            <!-- 标题 -->
            <h1 class="bold" style="text-align: center; font-size: 24px; margin: 20px 0">
              2025年度国家公务员考试公告
            </h1>

            <!-- 公告内容 -->
            <div class="notice-content">
              <p>
                根据国家公务员局统一部署，2025年度国家公务员考试即将启动。
                本次招录面向全国，提供多种职位，涵盖中央及地方机关单位，请考生及时关注。
              </p>
              <p>
                报名时间：<strong>10月15日8:00至10月24日18:00</strong>，
                笔试时间：<strong>11月30日至12月01日</strong>。
              </p>
              <p>
                符合条件的考生可登录国家公务员局官网报名，详细信息请查阅
                <el-link type="primary" href="http://bm.scs.gov.cn/pp/gkweb/core/web/ui/business/home/gkhome.html"
                         target="_blank">
                  《2025年度考试录用公务员公告》
                </el-link>
                。
              </p>
            </div>

            <!-- 报名链接 -->
            <div class="notice-link">
              <p>立即报名：
                <el-link type="primary" href="http://bm.scs.gov.cn/kl2025" target="_blank">
                  国家公务员局
                </el-link>
              </p>
            </div>
          </template>
        </el-alert>
      </div>
    </div>


    <!-- 搜索区域 -->
    <!-- 优化后的搜索区域 -->
    <el-card class="search-wrapper modern-search">
      <el-form :inline="true" class="search-form">
        <el-row :gutter="20">
          <!-- 配置化搜索字段 -->
          <el-col :xs="24" :sm="12" :md="8" :lg="6" v-for="(field, index) in searchFields" :key="index">
            <el-form-item :label="field.label + '：'" class="modern-form-item">
              <!-- 输入框 -->
              <el-input
                  v-if="field.type === 'input'"
                  v-model="searchQuery[field.prop]"
                  :placeholder="field.placeholder"
                  clearable
                  class="modern-input"
              >
                <template #suffix>
                  <el-icon class="search-clear" @click="handleClear(field.prop)">
                    <CloseBold/>
                  </el-icon>
                </template>
              </el-input>

              <!-- 下拉选择 -->
              <el-select
                  v-if="field.type === 'select'"
                  v-model="searchQuery[field.prop]"
                  :placeholder="field.placeholder"
                  clearable
                  class="modern-select"
              >
                <el-option
                    v-for="opt in field.options"
                    :key="opt.value"
                    :label="opt.label"
                    :value="opt.value"
                />
              </el-select>

              <!-- 日期选择 -->
              <div v-if="field.type === 'date'" class="date-picker-wrapper">
                <el-date-picker
                    v-model="searchQuery[field.prop]"
                    type="date"
                    :placeholder="field.placeholder"
                    value-format="YYYY-MM-DD"
                    class="modern-date"
                />
                <el-icon class="date-clear" @click="handleClear(field.prop)">
                  <CloseBold/>
                </el-icon>
              </div>

              <!-- 数字输入 -->
              <div v-if="field.type === 'number'" class="number-input-wrapper">
                <el-input-number
                    v-model="searchQuery[field.prop]"
                    :min="0"
                    :placeholder="field.placeholder"
                    controls-position="right"
                    class="modern-number"
                />
                <el-icon class="number-clear" @click="handleClear(field.prop)">
                  <CloseBold/>
                </el-icon>
              </div>
            </el-form-item>
          </el-col>
        </el-row>

        <!-- 操作按钮 -->
        <div class="action-buttons">
          <el-button type="primary" @click="handleSearch" class="search-btn">
            <el-icon>
              <Search/>
            </el-icon>
            搜索
          </el-button>
          <el-button @click="handleReset" class="reset-btn">
            <el-icon>
              <Refresh/>
            </el-icon>
            重置条件
          </el-button>
        </div>
      </el-form>
    </el-card>


    <!-- 数据卡片 -->
    <div class="card-wrapper">
      <div class="card-container">
        <el-row :gutter="20">
          <el-col :span="12" v-for="(item, index) in list" :key="index">
            <el-card class="position-card" shadow="hover">
              <template #header>
                <div class="card-header">
                  <span class="department">{{ item.bumenmingcheng }}</span>
                  <el-tag type="danger">招{{ item.zhaokaorenshu }}人</el-tag>
                </div>
              </template>

              <!-- 卡片内容区域 -->
              <div class="card-content" style="display: flex; flex-direction: column; min-height: 200px;">
                <!-- 上方内容区域 -->
                <div class="position-info" style="flex: 1; overflow: hidden;">
                  <div>
                    <el-icon><office-building /></el-icon>
                    职位代码：{{ item.zhiweidaima }}
                  </div>
                  <div>
                    <el-icon><postcard /></el-icon>
                    职位名称：{{ item.zhiweimingcheng }}
                  </div>
                  <div>
                    <el-icon><reading /></el-icon>
                    学历：{{ item.xueliyaoqiu }}
                  </div>
                  <div class="professional" style="
                display: -webkit-box;
                -webkit-line-clamp: 2;
                -webkit-box-orient: vertical;
                overflow: hidden;
                text-overflow: ellipsis;
              ">
                    <el-icon><tickets /></el-icon>
                    专业要求：{{ item.zhuanyeyaoqiu || '不限' }}
                  </div>
                </div>

                <!-- 固定在底部的横线和操作区域 -->
                <div style="flex-shrink: 0;">
                  <el-divider style="margin: 20px 0;" />
                  <div class="card-footer" style="display: flex; justify-content: space-between; align-items: center;">
                    <el-button type="primary" @click="detailClick(item.id)">查看详情</el-button>
                    <div class="contact" style="display: flex; align-items: center;">
                      <el-icon style="margin-right: 5px;"><phone /></el-icon>
                      咨询电话：{{ item.zixundianhua || '暂无' }}
                    </div>
                  </div>
                </div>
              </div>
            </el-card>
          </el-col>
        </el-row>

        <el-pagination
            background
            :layout="layouts.join(',')"
            :total="total"
            :page-size="listQuery.limit"
            v-model:current-page="listQuery.page"
            prev-text="上一页"
            next-text="下一页"
            :hide-on-single-page="false"
            @size-change="sizeChange"
            @current-change="currentChange"
        />
      </div>
    </div>
  </div>
</template>

<script setup>
import {Search, Refresh, CloseBold} from '@element-plus/icons-vue'

// 搜索字段配置化
const searchFields = [
  {
    label: '部门名称',
    prop: 'bumenmingcheng',
    type: 'input',
    placeholder: '输入部门名称'
  },
  {
    label: '职位名称',
    prop: 'zhiweimingcheng',
    type: 'input',
    placeholder: '输入职位名称'
  },
  {
    label: '学历要求',
    prop: 'xueliyaoqiu',
    type: 'select',
    placeholder: '选择学历',
    options: [
      {label: '大专及以上学历', value: '大专及以上学历'},
      {label: '本科及以上学历', value: '本科及以上学历'},
      {label: '硕士及以上学历', value: '硕士及以上学历'}
    ]
  },
  {
    label: '专业要求',
    prop: 'zhuanyeyaoqiu',
    type: 'input',
    placeholder: '输入专业要求'
  },
  {
    label: '政治面貌',
    prop: 'zhengzhimianmao',
    type: 'select',
    placeholder: '选择政治面貌',
    options: [
      {label: '中共党员', value: '中共党员'},
      {label: '共青团员', value: '共青团员'},
      {label: '群众', value: '群众'},
      {label: '不限', value: '不限'}
    ]
  },
  {
    label: '招考人数',
    prop: 'zhaokaorenshu',
    type: 'number',
    placeholder: '输入人数'
  },
  {
    label: '报名时间',
    prop: 'baomingshijian',
    type: 'date',
    placeholder: '选择日期'
  },
  {
    label: '报名费用',
    prop: 'feiyongjiaona',
    type: 'number',
    placeholder: '输入金额'
  }
]
// 清空处理
const handleClear = (prop) => {
  if (prop === 'zhaokaorenshu' || prop === 'feiyongjiaona') {
    searchQuery.value[prop] = 0
  } else {
    searchQuery.value[prop] = ''
  }
}

// 搜索操作
const handleSearch = () => {
  getList()
}

// 重置操作
const handleReset = () => {
  searchQuery.value = {
    bumenmingcheng: '',
    zhiweimingcheng: '',
    xueliyaoqiu: '',
    zhuanyeyaoqiu: '',
    zhengzhimianmao: '',
    zhaokaorenshu: 0,
    baomingshijian: '',
    feiyongjiaona: 0
  }
  getList()
}
import {
  ref,
  getCurrentInstance,
  nextTick,
  computed,
} from 'vue';
import {
  useRoute,
  useRouter
} from 'vue-router';
import {
  useStore
} from 'vuex';

const store = useStore()
const user = computed(() => store.getters['user/session'])
const context = getCurrentInstance()?.appContext.config.globalProperties;
const router = useRouter()
const route = useRoute()
//基础信息
const tableName = 'baokaozhinan'
const formName = '报考指南'
//基础信息
const breadList = ref([{
  name: formName
}])
const list = ref([])
const listQuery = ref({
  page: 1,
  limit: Number(10)
})
const total = ref(0)
const listLoading = ref(false)
//权限验证
const btnAuth = (e, a) => {
  if (centerType.value) {
    return context?.$toolUtil.isBackAuth(e, a)
  } else {
    return context?.$toolUtil.isAuth(e, a)
  }
}
const addClick = () => {
  router.push('/index/baokaozhinanAdd')
}
//判断是否从个人中心跳转
const centerType = ref(false)
//返回
const backClick = () => {
  router.push(`/index/${context?.$toolUtil.storageGet('frontSessionTable')}Center`)
}
//搜索
const searchQuery = ref({})
//下拉列表
const kemuLists = ref([])
const getkemuLists = () => {
  context?.$http({
    url: 'option/kemu/kemu',
    method: 'get'
  }).then(res => {
    kemuLists.value = res.data.data
  })
}
getkemuLists()
const searchClick = () => {
  listQuery.value.page = 1
  getList()
}
//分页
const layouts = ref(["total", "prev", "pager", "next", "sizes", "jumper"])
const sizeChange = (size) => {
  listQuery.value.limit = size
  getList()
}
const currentChange = (page) => {
  listQuery.value.page = page
  getList()
}
//分页
const sortType = ref('')
const sortOrder = ref('')
const sortClick = (type) => {
  if (sortType.value == type && sortOrder.value == 'asc') {
    sortType.value = ''
    sortOrder.value = ''
  } else if (sortType.value == type && sortOrder.value == 'desc') {
    sortOrder.value = 'asc'
  } else {
    sortType.value = type
    sortOrder.value = 'desc'
  }
  getList()
}
//列表
const getList = () => {
  listLoading.value = true
  // 深拷贝查询条件
  let params = JSON.parse(JSON.stringify(listQuery.value));

  // 添加动态查询条件
  if (searchQuery.value.bumenmingcheng) {
    params.bumenmingcheng = '%' + searchQuery.value.bumenmingcheng + '%'; // 部门名称模糊查询
  }
  if (searchQuery.value.zhiweimingcheng) {
    params.zhiweimingcheng = '%' + searchQuery.value.zhiweimingcheng + '%'; // 职位名称模糊查询
  }
  if (searchQuery.value.xueliyaoqiu) {
    params.xueliyaoqiu = searchQuery.value.xueliyaoqiu; // 学历要求精确查询
  }
  if (searchQuery.value.zhuanyeyaoqiu) {
    params.zhuanyeyaoqiu = '%' + searchQuery.value.zhuanyeyaoqiu + '%'; // 专业要求模糊查询
  }
  if (searchQuery.value.zhengzhimianmao) {
    params.zhengzhimianmao = searchQuery.value.zhengzhimianmao; // 政治面貌精确查询
  }
  if (searchQuery.value.zhaokaorenshu) {
    params.zhaokaorenshu = searchQuery.value.zhaokaorenshu; // 招考人数精确查询
  }
  if (searchQuery.value.baomingshijian) {
    params.baomingshijian = searchQuery.value.baomingshijian; // 报名时间精确查询
  }
  if (searchQuery.value.feiyongjiaona) {
    params.feiyongjiaona = searchQuery.value.feiyongjiaona; // 费用缴纳精确查询
  }
  if (sortType.value) {
    params['sort'] = sortType.value
    params['order'] = sortOrder.value
  }
  context?.$http({
    url: `${tableName}/${centerType.value ? 'page' : 'list'}`,
    method: 'get',
    params: params
  }).then(res => {
    listLoading.value = false
    list.value = res.data.data.list
    total.value = Number(res.data.data.total)
  })
}
//分类
const categoryList = ref([])
const categoryIndex = ref(-1)
const getCategoryList = () => {
  context?.$http({
    url: 'option/kemu/kemu',
    method: 'get'
  }).then(res => {
    categoryList.value = res.data.data
  })
}
const categoryClick = (index) => {
  listQuery.value.page = 1
  categoryIndex.value = index
  getList()
}
const detailClick = (id) => {
  router.push(`${tableName}Detail?id=` + id + (centerType.value ? '&&centerType=1' : ''))
}
//下载文件
const download = (file) => {
  if (!file) {
    context?.$toolUtil.message('文件不存在', 'error')
  }
  const a = document.createElement('a');
  a.style.display = 'none';
  a.setAttribute('target', '_blank');
  file && a.setAttribute('download', file);
  a.href = context?.$config.url + file;
  document.body.appendChild(a);
  a.click();
  document.body.removeChild(a);
}
// 查看大图
const preViewUrl = ref('')
const preViewVisible = ref(false)
const preViewClick = (url) => {
  preViewUrl.value = url
  preViewVisible.value = true
}
const init = () => {
  if (route.query.centerType) {
    centerType.value = true
  }
  getCategoryList()
  getList()
}
init()
</script>
<style lang="scss" scoped>
.modern-search {
  border-radius: 12px;
  border: 1px solid #e4e7ed;
  background: #f8f9fa;
  box-shadow: 0 4px 16px rgba(0, 0, 0, 0.08);

  .search-form {
    padding: 16px;
  }
}

.modern-form-item {
  :deep(.el-form-item__label) {
    color: #409eff;
    font-weight: 600;
    padding-right: 8px;
  }
}

.modern-input {
  :deep(.el-input__wrapper) {
    border-radius: 8px;
    transition: all 0.3s;
    background: #fff;

    &:hover {
      box-shadow: 0 0 0 1px #409eff inset;
    }

    &.is-focus {
      box-shadow: 0 0 0 2px #409eff inset;
    }
  }
}

.date-picker-wrapper,
.number-input-wrapper {
  position: relative;
  width: 100%;

  .modern-date,
  .modern-number {
    width: 100%;
  }

  .date-clear,
  .number-clear {
    position: absolute;
    right: 8px;
    top: 50%;
    transform: translateY(-50%);
    cursor: pointer;
    color: #c0c4cc;
    z-index: 1;

    &:hover {
      color: #409eff;
    }
  }
}

.action-buttons {
  width: 100%;
  text-align: center;
  margin-top: 16px;

  .search-btn {
    background: linear-gradient(135deg, #409eff, #79bbff);
    border: none;
    padding: 10px 24px;
    transition: all 0.3s;

    &:hover {
      opacity: 0.9;
      transform: translateY(-1px);
    }
  }

  .reset-btn {
    border-color: #409eff;
    color: #409eff;

    &:hover {
      background: #ecf5ff;
    }
  }
}

// 响应式调整
@media (max-width: 768px) {
  .modern-form-item {
    margin-bottom: 12px;

    :deep(.el-form-item__label) {
      font-size: 13px;
    }
  }

  .action-buttons {
    .el-button {
      width: 100%;
      margin-bottom: 8px;
    }
  }
}

/* 新增布局容器样式 */
.notice-wrapper,
.search-wrapper {
  padding: 20px;
  border-radius: 8px;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
}

.search-form .el-form-item {
  margin-bottom: 20px;
}

.search-form .el-input, .search-form .el-select, .search-form .el-date-picker {
  width: 100%;
}

.search-form .el-button {
  padding: 10px;
}

.el-row {
  margin-bottom: 20px;
}

.el-row:last-child {
  margin-bottom: 0;
}

.el-col {
  padding: 0 10px;
}

.el-form-item {
  width: 100%;
  margin-bottom: 0;
}

.el-input,
.el-select,
.el-date-picker,
.el-input-number {
  width: 100%;
}

.card-wrapper {
  max-width: 1200px;
  margin: 0 auto;
  padding: 0 20px;
}

/* 公告栏优化 */
.notice-bar {
  :deep(.el-alert) {
    text-align: center;
    padding: 18px 24px;

    .el-alert__title {
      font-size: 16px;
      line-height: 1.8;
    }
  }
}

/* 搜索表单居中 */
.search-form {
  display: flex;
  justify-content: center;
  gap: 20px;
  flex-wrap: wrap;

  :deep(.el-form-item) {
    margin: 0;

    .el-input__wrapper {
      width: 220px;
    }
  }
}

/* 卡片容器优化 */
.card-wrapper {
  .card-container {
    margin: 0 -10px;

    .el-col {
      padding: 0 10px !important;
      margin-bottom: 20px;

      @media (max-width: 992px) {
        width: 50%;
        max-width: 50%;
        flex: 0 0 50%;
      }

      @media (max-width: 768px) {
        width: 100%;
        max-width: 100%;
        flex: 0 0 100%;
      }
    }
  }
}

/* 卡片样式优化 */
.position-card {
  height: 100%;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);

  :deep(.el-card__header) {
    padding: 16px 20px;
  }

  :deep(.el-card__body) {
    padding: 20px;
  }
}

/* 调整信息排版 */
.position-info {
  div {
    display: flex;
    align-items: center;
    gap: 8px;

    .el-icon {
      font-size: 18px;
      color: #909399;
    }
  }
}

/* 底部按钮优化 */
.card-footer {
  .el-button {
    padding: 8px 16px;
  }
}

// 分类盒子
.category_view {
  // 分类item
  .category {
  }

  // item-悬浮
  .category:hover {
  }

  // item-选中
  .categoryActive {
  }
}

//搜索
.list_search {
  .search_view {
    .search_label {
    }

    .search_box {
      // 输入框
      :deep(.search_inp) {
        .is-focus {
          box-shadow: none !important;
        }
      }

      // 下拉框
      :deep(.search_sel) {
        //去掉默认样式
        .select-trigger {
          height: 100%;

          .el-input {
            height: 100%;

            .is-focus {
              box-shadow: none !important;
            }
          }
        }
      }
    }
  }

  .search_btn_view {
    // 搜索按钮
    .search_btn {
    }

    // 搜索按钮-悬浮
    .search_btn:hover {
    }

    // 新增按钮
    .add_btn {
    }

    // 新增按钮-悬浮
    .add_btn:hover {
    }
  }
}

// 数据盒子
.page_list {
  //列表
  .data_box {
    .data_view {
      .data_item:nth-of-type(2n - 1) {
        // 图片盒子
        .data_img_box {
          width: 100%;
          // 图片
          .data_img {
            object-fit: cover;
            width: 100%;
            height: 100%;
          }
        }

        // 内容盒子
        .data_content {
          // 价格
          .data_price {
            color: #f00;
          }

          // 标题1
          .data_title1 {
            margin: 0 0 10px;
            width: 100%;
            text-align: center;
          }

          // 标题2
          .data_title2 {
            margin: 0 0 10px;
            width: 100%;
            text-align: center;
          }

          // 标题3
          .data_title3 {
            margin: 0 0 10px;
            width: 100%;
            text-align: center;
          }

          // 标题4
          .data_title4 {
            margin: 0 0 10px;
            width: 100%;
            text-align: center;
          }

          // 标题5
          .data_title5 {
            margin: 0 0 10px;
            width: 100%;
            text-align: center;
          }
        }
      }

      .data_item:nth-of-type(2n) {
        // 图片盒子
        .data_img_box {
          width: 100%;
          // 图片
          .data_img {
            object-fit: cover;
            width: 100%;
            height: 100%;
          }
        }

        // 内容盒子
        .data_content {
          // 价格
          .data_price {
            color: #f00;
          }

          // 标题1
          .data_title1 {
            margin: 0 0 10px;
            width: 100%;
            text-align: center;
          }

          // 标题2
          .data_title2 {
            margin: 0 0 10px;
            width: 100%;
            text-align: center;
          }

          // 标题3
          .data_title3 {
            margin: 0 0 10px;
            width: 100%;
            text-align: center;
          }

          // 标题4
          .data_title4 {
            margin: 0 0 10px;
            width: 100%;
            text-align: center;
          }

          // 标题5
          .data_title5 {
            margin: 0 0 10px;
            width: 100%;
            text-align: center;
          }
        }
      }

      .data_item:nth-of-type(2n - 1):hover {
        // 图片盒子
        .data_img_box {
          // 图片
          .data_img {
          }
        }

        // 内容盒子
        .data_content {
          // 价格
          .data_price {
          }

          // 标题1
          .data_title1 {
          }

          // 标题2
          .data_title2 {
          }

          // 标题3
          .data_title3 {
          }

          // 标题4
          .data_title4 {
          }

          // 标题5
          .data_title5 {
          }
        }
      }

      .data_item:nth-of-type(2n):hover {
        // 图片盒子
        .data_img_box {
          // 图片
          .data_img {
          }
        }

        // 内容盒子
        .data_content {
          // 价格
          .data_price {
          }

          // 标题1
          .data_title1 {
          }

          // 标题2
          .data_title2 {
          }

          // 标题3
          .data_title3 {
          }

          // 标题4
          .data_title4 {
          }

          // 标题5
          .data_title5 {
          }
        }
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
      .select-trigger {
        height: 100%;

        .el-input {
          height: 100%;

          .is-focus {
            box-shadow: none !important;
          }
        }
      }
    }
  }

  // 跳页
  :deep(.el-pagination__jump) {
    // 输入框
    .el-input {
      .is-focus {
        box-shadow: none !important;
      }
    }
  }
}

// 热门信息盒子
.hot_view {
  // 标题
  .hot_title {
  }

  .hot_list {
    // item
    .hot {
      //图片盒子
      .hot_img_view {
        // 图片
        .hot_img {
        }
      }

      // 内容盒子
      .hot_content {
        // 名称
        .hot_text {
        }
      }
    }
  }
}

/* 公告内容样式 */
.notice-content {
  margin: 16px 0;
  line-height: 1.8;
  color: #606266;
}

.notice-content p {
  margin: 8px 0;
}

/* 报名链接样式 */
.notice-link {
  margin-top: 20px;
  text-align: center;
}

.notice-link .el-link {
  font-size: 16px;
  font-weight: 500;
}

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
</style>