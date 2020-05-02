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
    * 枚举表 
    * </p>
 *
 * @author 王振宇
 * @since 2020-05-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = " ProEnumVo", description = "枚举表 ")
public class ProEnumVo {

   /**
    * 枚举id
    */
    @ApiModelProperty(value = "枚举id", name = "enumId")
    private Integer enumId;

   /**
    * key
    */
    @ApiModelProperty(value = "key", name = "keystr")
    private String keystr;

   /**
    * value
    */
    @ApiModelProperty(value = "value", name = "valuestr")
    private String valuestr;

   /**
    * type
    */
    @ApiModelProperty(value = "type", name = "type")
    private String type;

   /**
    * create_time
    */
    @ApiModelProperty(value = "create_time", name = "createTime")
    private String createTime;

   /**
    * in 查询操作 批量删除
    */
    @ApiModelProperty(value = "in 查询操作 批量删除", name = "ids")
    private List<Integer> ids;
}
