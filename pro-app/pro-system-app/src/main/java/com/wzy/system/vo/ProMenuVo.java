package com.wzy.system.vo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.util.List;
import java.lang.Integer;
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
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ProMenuVo {

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
     * 父级名称
     */
    private String parentName;

   /**
    * 类型
    */
    private String type;

   /**
    * 创建事件
    */
    private String createTime;

   /**
    * in 查询操作
    */
    private List<Integer> ids;
}
