<style lang="less">
    @import './index.less';
</style>
<template>
    <div>
        <Row>
            <Col span="24">
            <Card :bordered="false">
                <p slot="title">枚举管理</p>
                <div class="search">
                    <Input class="input" v-model="key" placeholder="Key"/>
                    <Input class="input" v-model="type" placeholder="Type"/>
                    <Button @click="search">查询</Button>
                    <Button class="add_button" @click="reset">重置</Button>
                    <Button class="add_button" @click="deleteBathBtnClick" type="warning">删除</Button>
                    <Button class="add_button" @click="addBtnClick" type="primary">添加</Button>
                </div>
                <Table border @on-selection-change="tableOnSelect" ref="selection" :columns="columns" :data="tableData"></Table>
                <Page class="page" @on-page-size-change="onPageSizeChange" show-total show-sizer @on-change="tableOnChange" :total="total" show-elevator />
            </Card>
            </Col>
            <Modal
                    v-model="addFlag"
                    title="添加枚举"
                    :footer-hide=true>
                <Form ref="formInline" :model="formInline" :rules="ruleValidate">
                    <FormItem label="Key" prop="keystr">
                        <Input v-model="formInline.keystr" placeholder="Key"/>
                    </FormItem>
                    <FormItem label="Value" prop="valuestr">
                        <Input v-model="formInline.valuestr" placeholder="Value"/>
                    </FormItem>
                    <FormItem label="Type" prop="type">
                        <Input v-model="formInline.type" placeholder="Type"/>
                    </FormItem>
                </Form>
                <div class="foodl">
                    <Button @click="cancel">取消</Button>
                    &nbsp;&nbsp;<Button type="primary" @click="handleSubmit('formInline')">确定</Button>
                </div>
            </Modal>
        </Row>
    </div>
</template>

<script>
    import Tables from '_c/tables'
    import { getEnumPageList, deleteEnum, updateEnum, saveEnum, idsDelete } from '@/api/enum'
    import userStore from '@/store/module/user'

    export default {
        name: 'enum',
        components: {
            Tables
        },
        data () {
            return {
                selection: [],
                addFlag: false,
                key: '',
                type: '',
                uploadUrl: userStore.state.baseUrl,
                downloadUrl: userStore.state.downloadUrl,
                pageSize: 10,
                pageNum: 1,
                total: 0,
                formInline: this.initFromInput(),
                ruleValidate: {
                    keystr: [
                        { required: true, message: 'Key不能为空', trigger: 'blur' }
                    ],
                    valuestr: [
                        { required: true, message: 'Value不能为空', trigger: 'blur' }
                    ],
                    type: [
                        { required: true, message: 'Type不能为空', trigger: 'blur' }
                    ]
                },
                columns: [
                    {
                        type: 'selection',
                        width: 60,
                        fixed: 'left'
                    },
                    {
                        title: 'Key',
                        key: 'keystr',
                        fixed: 'left'
                    },
                    {
                        title: 'Value',
                        key: 'valuestr',
                        width: 100,
                        fixed: 'left'
                    },
                    {
                        title: 'Type',
                        key: 'type',
                        width: 100,
                        fixed: 'left'
                    },
                    {
                        title: '创建时间',
                        width: 150,
                        key: 'createTime',
                        fixed: 'left'
                    },
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
                                        size: 'small'
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
                                        size: 'small'
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
                    enumId: null,
                    keystr: '',
                    valuestr: '',
                    type: ''
                }
                return formInline
            },
            reset () {
                this.key = ''
                this.type = ''
                this.pageNum = 1
                this.initData()
            },
            search () {
                this.initData()
            },
            addBtnClick () {
                this.formInline = this.initFromInput()
                this.addFlag = true
            },
            cancel () {
                this.addFlag = false
                this.formInline = this.initFromInput()
            },
            editBtnClick (index) {
                let enumVo = this.tableData[index]
                this.formInline.enumId = enumVo.enumId
                this.formInline.keystr = enumVo.keystr
                this.formInline.valuestr = enumVo.valuestr
                this.formInline.type = enumVo.type
                this.addFlag = true
            },
            deleteBathBtnClick () {
                if (this.selection.length === 0) {
                    this.$Message.error('没有选择数据')
                } else {
                    var ids = []
                    for (let i = 0; i < this.selection.length; i++) {
                        ids.push(this.selection[i].enumId)
                    }
                    var params = {
                        ids: ids
                    }
                    this.$Modal.confirm({
                        title: '是否删除枚举?',
                        width: 280,
                        onOk: () => {
                            idsDelete(params)
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
                let enumVo = this.tableData[index]
                var params = {
                    enumId: enumVo.enumId
                }
                this.$Modal.confirm({
                    title: '是否删除枚举?',
                    width: 280,
                    onOk: () => {
                        deleteEnum(params)
                            .then(res => {
                                this.initData()
                            })
                    }
                })
            },
            handleSubmit () {
                this.$refs['formInline'].validate((valid) => {
                    if (valid) {
                        if (this.formInline.enumId !== null) {
                            updateEnum(this.formInline)
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
                            saveEnum(this.formInline)
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
                console.log(this.selection)
                var params = {}
                params.keystr = this.key
                params.type = this.type
                params.pageNum = this.pageNum
                params.pageSize = this.pageSize
                getEnumPageList(params)
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
<style>
</style>
