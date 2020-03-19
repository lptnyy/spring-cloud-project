package com.wzy.system.vo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.util.ArrayList;
import java.util.List;
import java.lang.Integer;
import java.lang.String;

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
@ApiModel(value = "ProMenuVo", description = "菜单表")
public class ProMenuVo {

    @ApiModelProperty(value = "是否展开子菜单", name = "expand")
    private Boolean expand = false;

    @ApiModelProperty(value = "是否默认选中", name = "checked")
    private Boolean checked = false;

   /**
    * 标示id
    */
   @ApiModelProperty(value = "标示id", name = "menuId")
    private Integer menuId;

   /**
    * 名称
    */
   @ApiModelProperty(value = "名称", name = "name")
    private String name;

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称", name = "title")
    private String title;

   /**
    * 访问地址
    */
   @ApiModelProperty(value = "访问地址", name = "url")
    private String url;

   /**
    * 图标
    */
   @ApiModelProperty(value = "图标", name = "icon")
    private String icon;

   /**
    * 物理地址
    */
   @ApiModelProperty(value = "物理地址", name = "path")
    private String path;

   /**
    * 父级id
    */
   @ApiModelProperty(value = "父级id", name = "parentId")
    private Integer parentId;

    /**
     * 父级名称
     */
    @ApiModelProperty(value = "父级名称", name = "parentName")
    private String parentName;

   /**
    * 类型
    */
   @ApiModelProperty(value = "类型", name = "type")
    private String type;

    /**
     * 权限角色
     */
    @ApiModelProperty(value = "权限角色", name = "jurisdiction")
    private String jurisdiction;

   /**
    * 创建事件
    */
   @ApiModelProperty(value = "创建事件", name = "createTime")
    private String createTime;

   /**
    * in 查询操作
    */
   @ApiModelProperty(value = "查询操作", name = "ids")
    private List<Integer> ids;

    /**
     * 子节点
     */
    @ApiModelProperty(value = "子节点", name = "children")
    private List<ProMenuVo> children = new ArrayList<>();
}
