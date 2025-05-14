<template>
  <div>
    <div class="center_view">
      <div class="list_search_view">
        <div class="search_and_btn_container">
          <el-form :model="searchQuery" class="search_form">
            <div class="search_view">
              <div class="search_label">
                省份：
              </div>
              <div class="search_box">
                <el-select
                    class="search_sel"
                    clearable
                    v-model="searchQuery.province"
                    placeholder="请选择省份"
                >
                  <el-option v-for="item in provinceList" :key="item" :label="item" :value="item"></el-option>
                </el-select>
              </div>
            </div>
            <div class="search_view">
              <div class="search_label">
                岗位：
              </div>
              <div class="search_box">
                <el-input class="search_inp" v-model="searchQuery.zhiweimingcheng" placeholder="请输入岗位名称"
                          clearable>
                </el-input>
              </div>
            </div>
            <div class="search_btn_view">
              <el-button class="search_btn" type="primary" @click="searchClick()" size="small">搜索</el-button>
            </div>
          </el-form>
          <div class="btn_view">
            <el-button class="add_btn" type="success" @click="addClick" v-if="btnAuth('baokaozhinan','新增')">
              新增
            </el-button>
          </div>
        </div>
      </div>
      <br>
      <div class="dataList"
           v-if="btnAuth('baokaozhinan','查看')"
      >
        <el-card class="card-item" v-for="(item,index) in list" :key="item.id" shadow="hover">
          <div class="item-content">
            <div class="title" :title="item.fengmian">部门：{{ truncateText(item.fengmian, 18) }}</div>
            <div class="title" :title="item.zhiweimingcheng">岗位：{{ truncateText(item.zhiweimingcheng, 18) }}</div>
            <div class="title" :title="item.xuelitiaojian">学历条件：{{ truncateText(item.xuelitiaojian, 18) }}</div>
            <div class="title" :title="item.baomingwangzhi">报名网址：{{ truncateText(item.baomingwangzhi, 18) }}</div>
            <div class="btns">
              <el-button class="view_btn" type="info" v-if=" btnAuth('baokaozhinan','查看')"
                         @click="infoClick(item.id)">
                详情
              </el-button>
              <el-button class="edit_btn" type="primary" @click="editClick(item.id)"
                         v-if=" btnAuth('baokaozhinan','修改')">
                修改
              </el-button>
              <el-button class="del_btn" type="danger" @click="delClick(item.id)" v-if="btnAuth('baokaozhinan','删除')">
                删除
              </el-button>
              <el-button class="operate_btn" v-if="btnAuth('baokaozhinan','查看评论')" type="warning"
                         @click="commentClick(item.id)">
                查看评论
              </el-button>
            </div>
          </div>
        </el-card>
      </div>
      <el-pagination
          background
          :layout="layouts.join(',')"
          :total="total"
          :page-size="listQuery.limit"
          v-model:current-page="listQuery.page"
          prev-text="<"
          next-text=">"
          :hide-on-single-page="false"
          :style='{}'
          :page-sizes="[10, 20, 30, 40, 50, 100]"
          @size-change="sizeChange"
          @current-change="currentChange"/>
    </div>
    <formModel ref="formRef" @formModelChange="formModelChange"></formModel>
  </div>
</template>

<script setup>
import axios from 'axios'
import {
  reactive,
  ref,
  getCurrentInstance,
  nextTick,
  onMounted,
  watch,
  computed,
} from 'vue'
import {
  useRoute,
  useRouter
} from 'vue-router'
import {
  ElMessageBox
} from 'element-plus'
import {
  useStore
} from 'vuex';

const store = useStore()
const user = computed(() => store.getters['user/session'])
const avatar = ref(store.state.user.avatar)
const context = getCurrentInstance()?.appContext.config.globalProperties;
import formModel from './formModel.vue'

// 全国省份列表
const provinceList = ref([
  '北京市', '天津市', '河北省', '山西省', '内蒙古自治区',
  '辽宁省', '吉林省', '黑龙江省', '上海市', '江苏省',
  '浙江省', '安徽省', '福建省', '江西省', '山东省',
  '河南省', '湖北省', '湖南省', '广东省', '广西壮族自治区',
  '海南省', '重庆市', '四川省', '贵州省', '云南省',
  '西藏自治区', '陕西省', '甘肃省', '青海省', '宁夏回族自治区',
  '新疆维吾尔自治区', '台湾省', '香港特别行政区', '澳门特别行政区'
])

const truncateText = (text, maxLength) => {
  if (!text) return '-';
  return text.length > maxLength ? text.substring(0, maxLength) + '...' : text;
};

//基础信息
const tableName = 'baokaozhinan'
const formName = '报考指南'
const route = useRoute()

//列表数据
const list = ref(null)
const table = ref(null)
const listQuery = ref({
  page: 1,
  limit: 20,
  sort: 'id',
  order: 'desc'
})
const searchQuery = ref({})
const selRows = ref([])
const listLoading = ref(false)

//列表
const getList = () => {
  listLoading.value = true
  let params = JSON.parse(JSON.stringify(listQuery.value))
  params['sort'] = 'id'
  params['order'] = 'desc'

  if (searchQuery.value.province && searchQuery.value.province != '') {
    params['fengmian'] = '%' + searchQuery.value.province + '%'
  }

  if (searchQuery.value.zhiweimingcheng && searchQuery.value.zhiweimingcheng != '') {
    params['zhiweimingcheng'] = '%' + searchQuery.value.zhiweimingcheng + '%'
  }

  context.$http({
    url: `${tableName}/page`,
    method: 'get',
    params: params
  }).then(res => {
    listLoading.value = false
    list.value = res.data.data.list
    total.value = Number(res.data.data.total)
  })
}

//删
const delClick = (id) => {
  let ids = ref([])
  if (id) {
    ids.value = [id]
  } else {
    if (selRows.value.length) {
      for (let x in selRows.value) {
        ids.value.push(selRows.value[x].id)
      }
    } else {
      return false
    }
  }
  ElMessageBox.confirm(`是否删除选中${formName}`, '提示', {
    confirmButtonText: '是',
    cancelButtonText: '否',
    type: 'warning',
  }).then(() => {
    context.$http({
      url: `${tableName}/delete`,
      method: 'post',
      data: ids.value
    }).then(res => {
      context?.$toolUtil.message('删除成功', 'success', () => {
        getList()
      })
    })
  })
}

//多选
const handleSelectionChange = (e) => {
  selRows.value = e
}

//分页
const total = ref(0)
const layouts = ref(["total", "prev", "pager", "next", "sizes", "jumper"])
const sizeChange = (size) => {
  listQuery.value.limit = size
  getList()
}
const currentChange = (page) => {
  listQuery.value.page = page
  getList()
}

//权限验证
const btnAuth = (e, a) => {
  return context?.$toolUtil.isAuth(e, a)
}

//搜索
const searchClick = () => {
  listQuery.value.page = 1
  getList()
}

//表单
const formRef = ref(null)
const formModelChange = () => {
  searchClick()
}
const addClick = () => {
  formRef.value.init()
}
const editClick = (id = null) => {
  if (id) {
    formRef.value.init(id, 'edit')
    return
  }
  if (selRows.value.length) {
    formRef.value.init(selRows.value[0].id, 'edit')
  }
}

const infoClick = (id = null) => {
  if (id) {
    formRef.value.init(id, 'info')
  } else if (selRows.value.length) {
    formRef.value.init(selRows.value[0].id, 'info')
  }
}

// 查看评论
const commentClick = (id) => {
  context?.$router.push('/discussbaokaozhinan?refid=' + id)
}

//初始化
const init = () => {
  getList()
}
init()
</script>

<style lang="scss" scoped>
.center_view {
  padding: 20px;
}


// 操作盒子
.list_search_view {
  .search_and_btn_container {
    display: flex;
    align-items: center;
    flex-wrap: wrap;
    gap: 10px;
  }

  // 搜索盒子
  .search_form {
    display: flex;
    align-items: center;
    flex-wrap: wrap;
    gap: 10px;

    // 子盒子
    .search_view {
      display: flex;
      align-items: center;
      margin-right: 0;

      // 搜索label
      .search_label {
        white-space: nowrap;
        margin-right: 10px;
        font-size: 14px;
        color: #606266;
      }

      // 搜索item
      .search_box {
        width: 180px;

        // 输入框
        :deep(.search_inp) {
          width: 100%;
        }

        // 下拉框
        :deep(.search_sel) {
          width: 100%;
          //去掉默认样式
          .select-trigger {
            height: 100%;

            .el-input {
              height: 100%;
            }
          }
        }
      }
    }

    // 搜索按钮盒子
    .search_btn_view {
      margin-bottom: 0;

      // 搜索按钮
      .search_btn {
        width: 80px;
      }
    }
  }

  //头部按钮盒子
  .btn_view {
    margin-bottom: 0;

    // 新增
    .add_btn {
      width: 80px;
    }
  }
}

// 数据列表
.dataList {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(300px, 1fr));
  gap: 20px;
  margin-bottom: 20px;

  .card-item {
    height: 250px; /* 固定高度 */
    display: flex;
    flex-direction: column;
    border-radius: 8px;
    overflow: hidden;

    .item-content {
      padding: 16px;
      flex: 1;
      display: flex;
      flex-direction: column;

      .title {
        margin-bottom: 12px;
        font-size: 14px;
        color: #606266;
        line-height: 1.5;
        white-space: nowrap; /* 禁止换行 */
        overflow: hidden; /* 隐藏溢出内容 */
        text-overflow: ellipsis; /* 显示省略号 */

        &:hover {
          cursor: default;
        }
      }

      .btns {
        margin-top: auto;
        display: flex;
        flex-wrap: wrap;
        gap: 8px;

        .el-button {
          flex: 1;
          min-width: 60px;
          padding: 8px 5px;
        }
      }
    }
  }
}
// 分页器
.el-pagination {
  margin-top: 20px;
  text-align: center;
}
</style>