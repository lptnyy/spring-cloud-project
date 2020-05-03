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
    * 系统资源文件表 
    * </p>
 *
 * @author 王振宇
 * @since 2020-05-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value = "pro_resource_file")
public class ProResourceFile implements Serializable {

   /**
    * 文件id
    */
    @TableId(value = "file_id", type = IdType.AUTO)
    private Integer fileId;

   /**
    * 文件名称
    */
    @TableField(value = "file_name")
    private String fileName;

   /**
    * 物理地址
    */
    @TableField(value = "physics_path")
    private String physicsPath;

   /**
    * 相对路径
    */
    @TableField(value = "path")
    private String path;

   /**
    * 文件指纹
    */
    @TableField(value = "md5")
    private String md5;

   /**
    * 文件大小
    */
    @TableField(value = "file_size")
    private Integer fileSize;

   /**
    * 访问域名
    */
    @TableField(value = "file_dns")
    private String fileDns;

   /**
    * 资源类型
    */
    @TableField(value = "type")
    private String type;

   /**
    * 资源后缀
    */
    @TableField(value = "suffix")
    private String suffix;

   /**
    * 储存源
    */
    @TableField(value = "source_type")
    private String sourceType;

   /**
    * 上传时间
    */
    @TableField(value = "upload_time")
    private Date uploadTime;

}
