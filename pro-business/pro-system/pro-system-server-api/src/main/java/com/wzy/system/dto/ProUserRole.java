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
    * 用户角色关系表 
    * </p>
 *
 * @author 王振宇
 * @since 2020-03-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value = "pro_user_role")
public class ProUserRole implements Serializable {

   /**
    * 关系ID
    */
    @TableId(value = "ur_id", type = IdType.AUTO)
    private Integer urId;

   /**
    * 角色ID
    */
    @TableField(value = "role_id")
    private Integer roleId;

   /**
    * 用户ID
    */
    @TableField(value = "user_id")
    private Integer userId;

   /**
    * 创建时间
    */
    @TableField(value = "create_time")
    private Date createTime;

}
