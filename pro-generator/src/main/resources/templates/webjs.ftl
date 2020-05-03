import axios from '@/libs/api.request'

/**
 * 查询
 * @param {} params
 */
export const get${className}PageList = (params) => {
  return axios.request({
    url: '${gateway}/${smClassName}/getPageList',
    method: 'post',
    data: params
  })
}

/**
 * 删除
 * @param {} params
 */
export const delete${className} = (params) => {
  return axios.request({
    url: '${gateway}/${smClassName}/delete',
    method: 'post',
    data: params
  })
}

/**
 * 批量删除
 * @param {} params
 */
export const ids${className}Delete = (params) => {
  return axios.request({
    url: '${gateway}/${smClassName}/idsDelete',
    method: 'post',
    data: params
  })
}

/**
 * 修改
 * @param {} params
 */
export const update${className} = (params) => {
  return axios.request({
    url: '${gateway}/${smClassName}/update',
    method: 'post',
    data: params
  })
}

/**
 * 保存
 * @param {} params
 */
export const save${className} = (params) => {
  return axios.request({
    url: '${gateway}/${smClassName}/save',
    method: 'post',
    data: params
  })
}
