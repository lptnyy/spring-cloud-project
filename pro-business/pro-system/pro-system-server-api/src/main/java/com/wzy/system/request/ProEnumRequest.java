package com.wzy.system.request;
import lombok.Data;
import java.util.List;
import java.lang.Integer;
import com.wzy.common.page.RequestPage;
import java.lang.String;

/**
 * <p>
    * 枚举表 
    * </p>
 *
 * @author 王振宇
 * @since 2020-03-07
 */
@Data
public class ProEnumRequest extends RequestPage {

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
