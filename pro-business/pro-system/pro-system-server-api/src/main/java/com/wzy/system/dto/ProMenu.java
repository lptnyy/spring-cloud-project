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
    * 菜单表 
    * </p>
 *
 * @author 王振宇
 * @since 2020-04-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value = "pro_menu")
public class ProMenu implements Serializable {

   /**
    * 标示id
    */
    @TableId(value = "menu_id", type = IdType.AUTO)
    private Integer menuId;

   /**
    * 
    */
    @TableField(value = "title")
    private String title;

   /**
    * 名称
    */
    @TableField(value = "name")
    private String name;

   /**
    * 物理地址
    */
    @TableField(value = "path")
    private String path;

   /**
    * 图标
    */
    @TableField(value = "icon")
    private String icon;

   /**
    * 父级id
    */
    @TableField(value = "parent_id")
    private Integer parentId;

   /**
    * 类型
    */
    @TableField(value = "type")
    private String type;

   /**
    * 创建事件
    */
    @TableField(value = "create_time")
    private Date createTime;

   /**
    * 
    */
    @TableField(value = "jurisdiction")
    private String jurisdiction;

}
