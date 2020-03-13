package com.wzy.system.request;
import lombok.Data;
import java.util.List;
import java.lang.Integer;
import com.wzy.common.page.RequestPage;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;

/**
 * <p>
    * 菜单表 
    * </p>
 *
 * @author 王振宇
 * @since 2020-03-07
 */
@Data
public class ProMenuRequest extends RequestPage {

   /**
    * 标示id
    */
    private Integer menuId;

   /**
    * 名称
    */
    private String name;

   /**
    * 访问地址
    */
    private String url;

   /**
    * 图标
    */
    private String icon;

   /**
    * 物理地址
    */
    private String path;

   /**
    * 父级id
    */
    private Integer parentId;

   /**
    * 类型
    */
    private String type;

    /**
     * 权限
     */
    private String jurisdiction;

   /**
    * 创建事件
    */
    private String createTime;

   /**
    * in 查询操作
    */
    private List<Integer> ids;
}
