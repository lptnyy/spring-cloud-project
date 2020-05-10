package com.wzy.generator.dto;
import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;

/**
 * <p>
    * 代码生成表
    * </p>
 *
 * @author 王振宇
 * @since 2020-05-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value = "pro_generator")
public class ProGenerator implements Serializable {

   /**
    * 标示id
    */
    @TableId(value = "gen_id", type = IdType.AUTO)
    private Integer genId;

   /**
    * 数据库地址
    */
    @TableField(value = "mysql")
    private String mysql;

   /**
    * api参数包名
    */
    @TableField(value = "api_pkg")
    private String apiPkg;

   /**
    * Controller包名
    */
    @TableField(value = "controller_pkg")
    private String controllerPkg;

   /**
    * Vo包名
    */
    @TableField(value = "vo_pkg")
    private String voPkg;

   /**
    * Service接口包名
    */
    @TableField(value = "service_pkg")
    private String servicePkg;

   /**
    * Service实现包名
    */
    @TableField(value = "service_impl_pkg")
    private String serviceImplPkg;

   /**
    * Mapper包名
    */
    @TableField(value = "mapper_pkg")
    private String mapperPkg;

   /**
    * Dto包名
    */
    @TableField(value = "dto_pgk")
    private String dtoPgk;

   /**
    * 数据库账号
    */
    @TableField(value = "mysql_user")
    private String mysqlUser;

   /**
    * 数据库密码
    */
    @TableField(value = "mysql_pass")
    private String mysqlPass;

   /**
    * 数据库表名称
    */
    @TableField(value = "table_name")
    private String tableName;

   /**
    * Feign服务名
    */
    @TableField(value = "feign_client_service")
    private String feignClientService;

   /**
    * 网关访问根目录
    */
    @TableField(value = "gate_way_path")
    private String gateWayPath;

   /**
    * 日志来源名称
    */
    @TableField(value = "log_source_name")
    private String logSourceName;

    @ApiModelProperty(value = "数据库驱动", name = "mysqlPass")
    @TableField(value = "mysql_dev")
    private String mysqlDev;

   /**
    * 创建时间
    */
    @TableField(value = "create_time")
    private Date createTime;

}
