package com.wzy.generator.request;
import lombok.Data;
import java.util.List;
import java.lang.Integer;
import com.wzy.common.page.RequestPage;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value = " ProGeneratorVo", description = "代码生成表")
public class ProGeneratorRequest extends RequestPage {

   /**
    * 标示id
    */
    @ApiModelProperty(value = "标示id", name = "genId")
    private Integer genId;

   /**
    * 数据库地址
    */
    @ApiModelProperty(value = "数据库地址", name = "mysql")
    private String mysql;

   /**
    * api参数包名
    */
    @ApiModelProperty(value = "api参数包名", name = "apiPkg")
    private String apiPkg;

   /**
    * Controller包名
    */
    @ApiModelProperty(value = "Controller包名", name = "controllerPkg")
    private String controllerPkg;

   /**
    * Vo包名
    */
    @ApiModelProperty(value = "Vo包名", name = "voPkg")
    private String voPkg;

   /**
    * Service接口包名
    */
    @ApiModelProperty(value = "Service接口包名", name = "servicePkg")
    private String servicePkg;

   /**
    * Service实现包名
    */
    @ApiModelProperty(value = "Service实现包名", name = "serviceImplPkg")
    private String serviceImplPkg;

   /**
    * Mapper包名
    */
    @ApiModelProperty(value = "Mapper包名", name = "mapperPkg")
    private String mapperPkg;

   /**
    * Dto包名
    */
    @ApiModelProperty(value = "Dto包名", name = "dtoPgk")
    private String dtoPgk;

   /**
    * 数据库账号
    */
    @ApiModelProperty(value = "数据库账号", name = "mysqlUser")
    private String mysqlUser;

   /**
    * 数据库密码
    */
    @ApiModelProperty(value = "数据库密码", name = "mysqlPass")
    private String mysqlPass;

    @ApiModelProperty(value = "数据库驱动", name = "mysqlPass")
    private String mysqlDev;

   /**
    * 数据库表名称
    */
    @ApiModelProperty(value = "数据库表名称", name = "tableName")
    private String tableName;

   /**
    * Feign服务名
    */
    @ApiModelProperty(value = "Feign服务名", name = "feignClientService")
    private String feignClientService;

   /**
    * 网关访问根目录
    */
    @ApiModelProperty(value = "网关访问根目录", name = "gateWayPath")
    private String gateWayPath;

   /**
    * 日志来源名称
    */
    @ApiModelProperty(value = "日志来源名称", name = "logSourceName")
    private String logSourceName;

   /**
    * 创建时间
    */
    @ApiModelProperty(value = "创建时间", name = "createTime")
    private String createTime;

   /**
    * in 查询操作
    */
    @ApiModelProperty(value = "in 查询操作 批量删除", name = "ids")
    private List<Integer> ids;
}
