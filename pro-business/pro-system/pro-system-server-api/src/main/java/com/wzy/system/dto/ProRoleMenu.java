package com.wzy.system.dto;
import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.lang.Integer;
import java.util.Date;

/**
 * <p>
    * 角色菜单关系表
    * </p>
 *
 * @author 王振宇
 * @since 2020-03-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value = "pro_role_menu")
public class ProRoleMenu implements Serializable {

   /**
    * 标示id
    */
    @TableId(value = "rm_id", type = IdType.AUTO)
    private Integer rmId;

   /**
    * 角色id
    */
    @TableField(value = "role_id")
    private Integer roleId;

   /**
    * 菜单id
    */
    @TableField(value = "menu_id")
    private Integer menuId;

   /**
    * 创建时间
    */
    @TableField(value = "create_time")
    private Date createTime;

}
