package com.wzy.member.request;
import lombok.Data;
import java.util.List;
import java.lang.Integer;
import com.wzy.common.page.RequestPage;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value = " ProMemberVo", description = "会员表 ")
public class ProMemberRequest extends RequestPage {

   /**
    * 会员id
    */
    @ApiModelProperty(value = "会员id", name = "memberId")
    private Integer memberId;

   /**
    * 会员号
    */
    @ApiModelProperty(value = "会员号", name = "memberNo")
    private String memberNo;

   /**
    * 手机号（账号）
    */
    @ApiModelProperty(value = "手机号（账号）", name = "userName")
    private String userName;

   /**
    * 密码
    */
    @ApiModelProperty(value = "密码", name = "passWord")
    private String passWord;

   /**
    * 头像
    */
    @ApiModelProperty(value = "头像", name = "headImg")
    private String headImg;

   /**
    * 名称
    */
    @ApiModelProperty(value = "名称", name = "name")
    private String name;

   /**
    * 学校
    */
    @ApiModelProperty(value = "学校", name = "school")
    private String school;

   /**
    * 院系
    */
    @ApiModelProperty(value = "院系", name = "department")
    private String department;

   /**
    * 入学时间
    */
    @ApiModelProperty(value = "入学时间", name = "admissionTime")
    private String admissionTime;

   /**
    * 学历
    */
    @ApiModelProperty(value = "学历", name = "education")
    private String education;

   /**
    * 展示范围
    */
    @ApiModelProperty(value = "展示范围", name = "displayPermissions")
    private String displayPermissions;

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
