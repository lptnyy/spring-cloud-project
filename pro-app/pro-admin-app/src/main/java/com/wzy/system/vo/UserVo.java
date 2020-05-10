package com.wzy.system.vo;
import lombok.Data;

@Data
public class UserVo {

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
     * ids 数组
     */
    private Integer[] ids;
}
