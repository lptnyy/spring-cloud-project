package com.wzy.member.dto;
import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;

/**
 * <p>
    * 会员表 
    * </p>
 *
 * @author 王振宇
 * @since 2020-05-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value = "pro_member")
public class ProMember implements Serializable {

   /**
    * 会员id
    */
    @TableId(value = "member_id", type = IdType.AUTO)
    private Integer memberId;

   /**
    * 会员号
    */
    @TableField(value = "member_no")
    private String memberNo;

   /**
    * 手机号（账号）
    */
    @TableField(value = "user_name")
    private String userName;

   /**
    * 密码
    */
    @TableField(value = "pass_word")
    private String passWord;

   /**
    * 头像
    */
    @TableField(value = "head_img")
    private String headImg;

   /**
    * 名称
    */
    @TableField(value = "name")
    private String name;

   /**
    * 学校
    */
    @TableField(value = "school")
    private String school;

   /**
    * 院系
    */
    @TableField(value = "department")
    private String department;

   /**
    * 入学时间
    */
    @TableField(value = "admission_time")
    private String admissionTime;

   /**
    * 学历
    */
    @TableField(value = "education")
    private String education;

   /**
    * 展示范围
    */
    @TableField(value = "display_permissions")
    private String displayPermissions;

   /**
    * 省份
    */
    @TableField(value = "province")
    private String province;

   /**
    * 城市
    */
    @TableField(value = "city")
    private String city;

   /**
    * 地区
    */
    @TableField(value = "area")
    private String area;

   /**
    * 创建时间
    */
    @TableField(value = "create_time")
    private Date createTime;

}
