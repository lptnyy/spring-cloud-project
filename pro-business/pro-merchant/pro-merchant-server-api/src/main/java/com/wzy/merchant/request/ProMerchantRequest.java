package com.wzy.merchant.request;
import lombok.Data;
import java.util.List;
import java.lang.Integer;
import com.wzy.common.page.RequestPage;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value = " ProMerchantVo", description = "商户表 ")
public class ProMerchantRequest extends RequestPage {

   /**
    * 标示列
    */
    @ApiModelProperty(value = "标示列", name = "merchantId")
    private Integer merchantId;

   /**
    * 企业简称
    */
    @ApiModelProperty(value = "企业简称", name = "abbreviation")
    private String abbreviation;

   /**
    * 账号
    */
    @ApiModelProperty(value = "账号", name = "userName")
    private String userName;

   /**
    * 密码
    */
    @ApiModelProperty(value = "密码", name = "passWord")
    private String passWord;

   /**
    * logo图片
    */
    @ApiModelProperty(value = "logo图片", name = "logoUrl")
    private String logoUrl;

   /**
    * 企业全名
    */
    @ApiModelProperty(value = "企业全名", name = "name")
    private String name;

   /**
    * 商户资质材料
    */
    @ApiModelProperty(value = "商户资质材料", name = "qualification")
    private String qualification;

   /**
    * 保证金额
    */
    @ApiModelProperty(value = "保证金额", name = "margin")
    private BigDecimal margin;

   /**
    * 收款账号
    */
    @ApiModelProperty(value = "收款账号", name = "collectMoney")
    private String collectMoney;

   /**
    * 固定电话
    */
    @ApiModelProperty(value = "固定电话", name = "tel")
    private String tel;

   /**
    * 手机号码
    */
    @ApiModelProperty(value = "手机号码", name = "phone")
    private String phone;

   /**
    * 邮箱
    */
    @ApiModelProperty(value = "邮箱", name = "email")
    private String email;

   /**
    * 省份
    */
    @ApiModelProperty(value = "省份", name = "province")
    private String province;

   /**
    * 城市
    */
    @ApiModelProperty(value = "城市", name = "city")
    private String city;

   /**
    * 地区
    */
    @ApiModelProperty(value = "地区", name = "area")
    private String area;

   /**
    * 详细地址
    */
    @ApiModelProperty(value = "详细地址", name = "address")
    private String address;

   /**
    * qq号码
    */
    @ApiModelProperty(value = "qq号码", name = "qq")
    private String qq;

   /**
    * 企业官网
    */
    @ApiModelProperty(value = "企业官网", name = "homeUrl")
    private String homeUrl;

   /**
    * 状态(枚举表 enterprise_stat)
    */
    @ApiModelProperty(value = "状态(枚举表 enterprise_stat)", name = "stat")
    private Integer stat;

   /**
    * 创建时间
    */
    @ApiModelProperty(value = "创建时间", name = "createTime")
    private String createTime;

   /**
    * in 查询操作
    */
    @ApiModelProperty(value = "in 查询操作 批量删除", name = "ids")
    private List<Integer> ids;
}
