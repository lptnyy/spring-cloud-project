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
import java.lang.Float;
import java.util.Date;

/**
 * <p>
    * 操作日志
    * </p>
 *
 * @author 王振宇
 * @since 2020-05-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value = "pro_log")
public class ProLog implements Serializable {

   /**
    * 日志id
    */
    @TableId(value = "log_id", type = IdType.AUTO)
    private Integer logId;

   /**
    * 日志名称
    */
    @TableField(value = "name")
    private String name;

   /**
    * 日志内容
    */
    @TableField(value = "value")
    private String value;

   /**
    * 函数类
    */
    @TableField(value = "class_name")
    private String className;

   /**
    * 函数名
    */
    @TableField(value = "function_name")
    private String functionName;

   /**
    * 执行时间ms
    */
    @TableField(value = "run_time")
    private Float runTime;

   /**
    * 日志来源
    */
    @TableField(value = "source")
    private String source;

   /**
    * 参数内容
    */
    @TableField(value = "body")
    private String body;

   /**
    * 反馈数据
    */
    @TableField(value = "return_body")
    private String returnBody;

   /**
    * 创建时间
    */
    @TableField(value = "create_time")
    private Date createTime;

}
