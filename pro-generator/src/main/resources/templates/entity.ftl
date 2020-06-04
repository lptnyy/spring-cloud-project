package ${genpkg};
import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
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
@TableName(value = "${tableName}")
@SuppressWarnings("unchecked")
public class ${className} implements Serializable {

    <#list fields as field>
   /**
    * ${field.comment}
    */
    <#if field.columnKey == 'pri'>@TableId(value = "${field.tableName}", type = IdType.AUTO)<#else>@TableField(value = "${field.tableName}")</#if>
    private ${field.type} ${field.fieldName};

    </#list>
}
