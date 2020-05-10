package com.wzy.system.vo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.util.List;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value = " ProLogVo", description = "操作日志")
public class ProLogVo {

   /**
    * 日志id
    */
    @ApiModelProperty(value = "日志id", name = "logId")
    private Integer logId;

   /**
    * 日志名称
    */
    @ApiModelProperty(value = "日志名称", name = "name")
    private String name;

   /**
    * 日志内容
    */
    @ApiModelProperty(value = "日志内容", name = "value")
    private String value;

   /**
    * 函数类
    */
    @ApiModelProperty(value = "函数类", name = "className")
    private String className;

   /**
    * 函数名
    */
    @ApiModelProperty(value = "函数名", name = "functionName")
    private String functionName;

   /**
    * 执行时间ms
    */
    @ApiModelProperty(value = "执行时间ms", name = "runTime")
    private Float runTime;

   /**
    * 日志来源
    */
    @ApiModelProperty(value = "日志来源", name = "source")
    private String source;

   /**
    * 参数内容
    */
    @ApiModelProperty(value = "参数内容", name = "body")
    private String body;

   /**
    * 反馈数据
    */
    @ApiModelProperty(value = "反馈数据", name = "returnBody")
    private String returnBody;

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
