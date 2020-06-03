<template>
  <div>
    <Row>
      <Col span="24">
        <Card :bordered="false">
          <p slot="title">${tableComment}管理</p>
            <div class="search">
              <#list fields as field>
              <#if field.webSelectType == 'text'>
              <Input class="input" v-model="${field.fieldName}" placeholder="${field.comment}"/>
              </#if>
              <#if field.webSelectType == 'select'>
              <Select v-model="${field.fieldName}">
                <Option value="0">需要编码</Option>
              </Select>
              </#if>
              <#if field.webSelectType == 'radio'>
              <RadioGroup v-model="${field.fieldName}">
                <Radio label="需要编码" disabled></Radio>
                <Radio label="需要编码"></Radio>
              </RadioGroup>
              </#if>
              <#if field.webSelectType == 'time'>
              <DatePicker v-model="${field.fieldName}" type="date" placeholder="${field.comment}"></DatePicker>
              </#if>
              <#if field.webSelectType == 'timeyyyymmdd'>
              <DatePicker type="datetime" v-model="${field.fieldName}" placeholder="${field.comment}"></DatePicker>
              </#if>
              </#list>
              <Button @click="search" :disabled="!isRetrieve">查询</Button>
              <Button class="add_button" :disabled="!isRetrieve" @click="reset">重置</Button>
              <Button class="add_button" :disabled="!isDelete" @click="deleteBathBtnClick" type="warning">删除</Button>
              <Button class="add_button" :disabled="!isCreate" @click="addBtnClick" type="primary">添加</Button>
            </div>
            <Table border @on-selection-change="tableOnSelect" ref="selection" :columns="columns" :data="tableData"></Table>
            <Page class="page" @on-page-size-change="onPageSizeChange" show-total show-sizer @on-change="tableOnChange" :total="total" show-elevator />
        </Card>
      </Col>
      <Modal
        v-model="addFlag"
        :title="title"
        :footer-hide=true>
          <Form ref="formInline" :model="formInline" :rules="ruleValidate">
            <#list fields as field>
            <FormItem label="${field.comment}" prop="${field.fieldName}">
              <Input v-model="formInline.${field.fieldName}" placeholder="请输入${field.comment}"/>
            </FormItem>
            </#list>
          </Form>
          <div class="foodl">
              <Button @click="cancel">取消</Button>
              &nbsp;&nbsp;<Button type="primary" :disabled="!isCreate" @click="handleSubmit('formInline')">确定</Button>
          </div>
      </Modal>
    </Row>
  </div>
</template>

<script>
import Tables from '_c/tables'
import { get${className}PageList, delete${className}, update${className}, save${className}, ids${className}Delete } from '@/api/${smClassName}'
import userStore from '@/store/module/user'

export default {
  name: '${className}',
  components: {
    Tables
  },
  data () {
    return {
      title: '添加${tableComment}',
      isCreate: this.authorities('权限值'),
      isDelete: this.authorities('权限值'),
      isUpdate: this.authorities('权限值'),
      isRetrieve: this.authorities('权限值'),
      selection: [],
      addFlag: false,
      <#list fields as field>
      <#if field.webSelectType != 'zore'>
      ${field.fieldName}: <#if field.type == 'String'>''<#else>null</#if>,
      </#if>
      </#list>
      uploadUrl: userStore.state.baseUrl,
      downloadUrl: userStore.state.downloadUrl,
      pageSize: 10,
      pageNum: 1,
      total: 0,
      formInline: this.initFromInput(),
      ruleValidate: {
        <#list fields as field>
        ${field.fieldName}: [
          { required: true, message: '请输入${field.comment}', trigger: 'blur' }
        ],
        </#list>
      },
      columns: [
        {
          type: 'selection',
          width: 60,
          fixed: 'left'
        },
        <#list fields as field>
        {
          title: '${field.comment}',
          key: '${field.fieldName}',
          fixed: 'left'
        },
        </#list>
        {
          title: '操作',
          key: 'action',
          fixed: 'right',
          width: 140,
          render: (h, params) => {
            return h('div', [
              h('Button', {
                props: {
                  type: 'text',
                  size: 'small',
                  disabled: !this.isUpdate
                },
                on: {
                  click: () => {
                    this.editBtnClick(params.index)
                  }
                }
              }, '编辑'),
              h('Button', {
                props: {
                  type: 'text',
                  size: 'small',
                  disabled: !this.isDelete
                },
                on: {
                  click: () => {
                    this.deleteBtnClick(params.index)
                  }
                }
              }, '删除')
            ])
          }
        }
      ],
      tableData: []
    }
  },
  methods: {
    initFromInput () {
      var formInline = {
        <#list fields as field>
        ${field.fieldName}: <#if field.type == 'String'>''<#else>null</#if>,
        </#list>
      }
      return formInline
    },
    reset () {
      <#list fields as field>
      <#if field.webSelectType != 'zore'>
      this.${field.fieldName} = <#if field.type == 'String'>''<#else>null</#if>
      </#if>
      </#list>
      this.pageNum = 1
      this.initData()
    },
    search () {
      this.initData()
    },
    addBtnClick () {
      this.title = '添加${tableComment}'
      this.formInline = this.initFromInput()
      this.addFlag = true
    },
    cancel () {
      this.addFlag = false
      this.formInline = this.initFromInput()
    },
    editBtnClick (index) {
      this.title = '编辑${tableComment}'
      let tableRow = this.tableData[index]
      <#list fields as field>
      this.formInline.${field.fieldName} = tableRow.${field.fieldName}
      </#list>
      this.addFlag = true
    },
    deleteBathBtnClick () {
      if (this.selection.length === 0) {
        this.$Message.error('没有选择数据')
      } else {
        var ids = []
        for (let i = 0; i < this.selection.length; i++) {
          ids.push(this.selection[i].${pri})
        }
        var params = {
          ids: ids
        }
        this.$Modal.confirm({
          title: '是否删除枚举?',
          width: 280,
          onOk: () => {
            ids${className}Delete(params)
              .then(res => {
                this.initData()
                this.selection = []
              })
          }
        })
      }
    },
    tableOnSelect (selection, row) {
      this.selection = selection
    },
    deleteBtnClick (index) {
      let table = this.tableData[index]
      var params = {
        ${pri}: table.${pri}
      }
      this.$Modal.confirm({
        title: '是否删除枚举?',
        width: 280,
        onOk: () => {
          delete${className}(params)
            .then(res => {
              this.initData()
            })
        }
      })
    },
    handleSubmit () {
      this.$refs['formInline'].validate((valid) => {
        if (valid) {
          if (this.formInline.${pri} !== null) {
            update${className}(this.formInline)
              .then(res => {
                if (res.data.code === 200) {
                  this.$Message.success('修改成功')
                  this.initData()
                  this.cancel()
                } else {
                  this.$Message.error(res.data.msg)
                }
              })
          } else {
            save${className}(this.formInline)
              .then(res => {
                if (res.data.code === 200) {
                  this.$Message.success('保存成功')
                  this.initData()
                  this.cancel()
                } else {
                  this.$Message.error(res.data.msg)
                }
              })
          }
        }
      })
    },
    tableOnChange (index) {
      this.pageNum = index
      this.initData()
    },
    onPageSizeChange (index) {
      this.pageSize = index
      this.initData()
    },
    initData () {
      if (!this.isRetrieve) return
      var params = {}
      <#list fields as field>
      <#if field.webSelectType != 'zore'>
      params.${field.fieldName} = this.${field.fieldName}
      </#if>
      </#list>
      params.pageNum = this.pageNum
      params.pageSize = this.pageSize
      get${className}PageList(params)
        .then(res => {
          if (res.code !== 200) {
            this.tableData = res.data.obj
            this.total = res.data.count
          } else {
            this.$Message.error(res.data.msg)
          }
        })
    }
  },
  mounted () {},
  created () {
    this.initData()
  }
}
</script>
<style lang="less">
.page {
    margin-top: 10px;
}
.search {
    margin-top: 10px;
    margin-bottom: 10px;
    .input{
        width: 150px;
        margin-right: 10px;
    }
}
.add_button {
    margin-left: 10px;
}
.foodl{
    text-align: center;
    width: 100%;
}
</style>
