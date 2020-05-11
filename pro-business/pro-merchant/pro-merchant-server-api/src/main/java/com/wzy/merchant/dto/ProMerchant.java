package com.wzy.merchant.dto;
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
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
    * 商户表 
    * </p>
 *
 * @author 王振宇
 * @since 2020-05-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value = "pro_merchant")
public class ProMerchant implements Serializable {

   /**
    * 标示列
    */
    @TableId(value = "merchant_id", type = IdType.AUTO)
    private Integer merchantId;

   /**
    * 企业简称
    */
    @TableField(value = "abbreviation")
    private String abbreviation;

   /**
    * 账号
    */
    @TableField(value = "user_name")
    private String userName;

   /**
    * 密码
    */
    @TableField(value = "pass_word")
    private String passWord;

   /**
    * logo图片
    */
    @TableField(value = "logo_url")
    private String logoUrl;

   /**
    * 企业全名
    */
    @TableField(value = "name")
    private String name;

   /**
    * 商户资质材料
    */
    @TableField(value = "qualification")
    private String qualification;

   /**
    * 保证金额
    */
    @TableField(value = "margin")
    private BigDecimal margin;

   /**
    * 收款账号
    */
    @TableField(value = "collect_money")
    private String collectMoney;

   /**
    * 固定电话
    */
    @TableField(value = "tel")
    private String tel;

   /**
    * 手机号码
    */
    @TableField(value = "phone")
    private String phone;

   /**
    * 邮箱
    */
    @TableField(value = "email")
    private String email;

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
    * 详细地址
    */
    @TableField(value = "address")
    private String address;

   /**
    * qq号码
    */
    @TableField(value = "qq")
    private String qq;

   /**
    * 企业官网
    */
    @TableField(value = "home_url")
    private String homeUrl;

   /**
    * 状态(枚举表 enterprise_stat)
    */
    @TableField(value = "stat")
    private Integer stat;

   /**
    * 创建时间
    */
    @TableField(value = "create_time")
    private Date createTime;

}
