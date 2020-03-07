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
    * 枚举表 
    * </p>
 *
 * @author 王振宇
 * @since 2020-03-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value = "pro_enum")
public class ProEnum implements Serializable {

   /**
    * 枚举id
    */
    @TableId(value = "enum_id", type = IdType.AUTO)
    private Integer enumId;

   /**
    * key
    */
    @TableField(value = "keyStr")
    private String keystr;

   /**
    * value
    */
    @TableField(value = "valueStr")
    private String valuestr;

   /**
    * type
    */
    @TableField(value = "type")
    private String type;

   /**
    * create_time
    */
    @TableField(value = "create_time")
    private Date createTime;

}
