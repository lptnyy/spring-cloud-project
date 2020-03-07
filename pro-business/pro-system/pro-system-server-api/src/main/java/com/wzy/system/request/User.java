package com.wzy.system.request;

import com.wzy.common.page.RequestPage;
import lombok.Data;

@Data
public class User extends RequestPage {

    private Integer userId;

    /**
     * 头像
     */
    private String headImg;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String userPass;

    /**
     * 登录次数
     */
    private Integer loginNum;

    /**
     * 状态
     */
    private Integer stats;

    /**
     * 最后登录时间
     */
    private String lastLoginTime;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     *  通过id组数进行in 查询
     */
    private Integer[] ids;
}
