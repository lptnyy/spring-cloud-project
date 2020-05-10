package com.wzy.system.vo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.util.List;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.lang.Integer;
import java.util.Date;

/**
 * <p>
    * 用户角色关系表 
    * </p>
 *
 * @author 王振宇
 * @since 2020-03-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = " ProUserRoleVo", description = "用户角色关系表 ")
public class ProUserRoleVo {

   /**
    * 关系ID
    */
    @ApiModelProperty(value = "关系ID", name = "urId")
    private Integer urId;

   /**
    * 角色ID
    */
    @ApiModelProperty(value = "角色ID", name = "roleId")
    private Integer roleId;

   /**
    * 用户ID
    */
    @ApiModelProperty(value = "用户ID", name = "userId")
    private Integer userId;

   /**
    * 创建时间
    */
    @ApiModelProperty(value = "创建时间", name = "createTime")
    private String createTime;

   /**
    * in 查询操作 批量删除
    */
    @ApiModelProperty(value = "in 查询操作 批量删除", name = "ids")
    private List<Integer> ids;
}
