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
@TableName(value = "pro_role")
public class ProRole implements Serializable {

   /**
    * 角色id
    */
    @TableId(value = "role_id", type = IdType.AUTO)
    private Integer roleId;

   /**
    * 角色名称
    */
    @TableField(value = "name")
    private String name;

   /**
    * 创建时间
    */
    @TableField(value = "create_time")
    private Date createTime;

}
