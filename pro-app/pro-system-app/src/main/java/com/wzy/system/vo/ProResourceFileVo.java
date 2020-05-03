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
    * 系统资源文件表 
    * </p>
 *
 * @author 王振宇
 * @since 2020-05-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = " ProResourceFileVo", description = "系统资源文件表 ")
public class ProResourceFileVo {

   /**
    * 文件id
    */
    @ApiModelProperty(value = "文件id", name = "fileId")
    private Integer fileId;

   /**
    * 文件名称
    */
    @ApiModelProperty(value = "文件名称", name = "fileName")
    private String fileName;

   /**
    * 物理地址
    */
    @ApiModelProperty(value = "物理地址", name = "physicsPath")
    private String physicsPath;

   /**
    * 相对路径
    */
    @ApiModelProperty(value = "相对路径", name = "path")
    private String path;

   /**
    * 文件指纹
    */
    @ApiModelProperty(value = "文件指纹", name = "md5")
    private String md5;

   /**
    * 文件大小
    */
    @ApiModelProperty(value = "文件大小", name = "fileSize")
    private Integer fileSize;

   /**
    * 访问域名
    */
    @ApiModelProperty(value = "访问域名", name = "fileDns")
    private String fileDns;

   /**
    * 资源类型
    */
    @ApiModelProperty(value = "资源类型", name = "type")
    private String type;

   /**
    * 资源后缀
    */
    @ApiModelProperty(value = "资源后缀", name = "suffix")
    private String suffix;

   /**
    * 储存源
    */
    @ApiModelProperty(value = "储存源", name = "sourceType")
    private String sourceType;

   /**
    * 上传时间
    */
    @ApiModelProperty(value = "上传时间", name = "uploadTime")
    private String uploadTime;

   /**
    * in 查询操作 批量删除
    */
    @ApiModelProperty(value = "in 查询操作 批量删除", name = "ids")
    private List<Integer> ids;
}
