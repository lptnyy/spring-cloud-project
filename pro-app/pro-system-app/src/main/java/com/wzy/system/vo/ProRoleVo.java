package com.wzy.system.vo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.util.List;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;

/**
 * <p>
    * 系统角色表 
    * </p>
 *
 * @author 王振宇
 * @since 2020-03-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = " ProRoleVo", description = "系统角色表 ")
public class ProRoleVo {

   /**
    * 角色id
    */
    @ApiModelProperty(value = "角色id", name = "roleId")
    private Integer roleId;

   /**
    * 角色名称
    */
    @ApiModelProperty(value = "角色名称", name = "name")
    private String name;

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

    @ApiModelProperty(value = "角色关联的权限id")
    private List<ProRoleMenuVo> proRoleMenuVos;
}
