package com.wzy.system.request;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.util.List;
import java.lang.Integer;
import java.lang.String;

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
public class ProEnumRequest {

   /**
    * 枚举id
    */
    private Integer enumId;

   /**
    * key
    */
    private String keystr;

   /**
    * value
    */
    private String valuestr;

   /**
    * type
    */
    private String type;

   /**
    * create_time
    */
    private String createTime;

   /**
    * in 查询操作
    */
    private List<Integer> ids;
}
