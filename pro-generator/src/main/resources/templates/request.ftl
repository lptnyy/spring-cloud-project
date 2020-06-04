package ${genpkg};
import lombok.Data;
import java.util.List;
import java.lang.Integer;
import com.wzy.common.page.RequestPage;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
<#list importPkg as pkg>
import ${pkg};
</#list>

/**
 * <p>
    * ${tableComment}
    * </p>
 *
 * @author 王振宇
 * @since ${generatorDate}
 */
@Data
@ApiModel(value = " ${className}Vo", description = "${tableComment}")
@SuppressWarnings("unchecked")
public class ${className}Request extends RequestPage {

<#list fields as field>
   /**
    * ${field.comment}
    */
    @ApiModelProperty(value = "${field.comment}", name = "${field.fieldName}")
    private <#if field.type == 'Date'>String<#else>${field.type}</#if> ${field.fieldName};

</#list>
   /**
    * in 查询操作
    */
    @ApiModelProperty(value = "in 查询操作 批量删除", name = "ids")
    private List<Integer> ids;
}
