package ${genpkg};
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.util.List;
import java.lang.Integer;
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
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ${className}Request {

<#list fields as field>
   /**
    * ${field.comment}
    */
    private <#if field.type == 'Date'>String<#else>${field.type}</#if> ${field.fieldName};

</#list>
   /**
    * in 查询操作
    */
    private List<Integer> ids;
}
