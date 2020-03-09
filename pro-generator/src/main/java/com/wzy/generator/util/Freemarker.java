package com.wzy.generator.util;
import com.wzy.generator.controller.request.TableInfo;
import com.wzy.generator.util.entity.GenDto;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class Freemarker {

    @Autowired
    StringUtil stringUtil;

    @Autowired
    DtoUtil dtoUtil;

    /**
     * 生成dto
     * @param tableInfo
     * @param table
     * @param tableInfos
     * @throws IOException
     * @throws TemplateException
     */
    public void dto(TableInfo tableInfo, Map<String,String> table, List<Map<String,String>> tableInfos) throws IOException, TemplateException {
        // 第一步：创建一个Configuration对象，直接new一个对象。构造方法的参数就是freemarker对于的版本号。
        Configuration configuration = new Configuration(Configuration.getVersion());
        File file = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX+"templates");
        // 第二步：设置模板文件所在的路径。
        configuration.setDirectoryForTemplateLoading(file);
        // 第三步：设置模板文件使用的字符集。一般就是utf-8.
        configuration.setDefaultEncoding("utf-8");
        // 第四步：加载一个模板，创建一个模板对象。
        Template template = configuration.getTemplate("entity.ftl");
        // 第五步：创建一个模板使用的数据集，可以是pojo也可以是map。一般是Map。
        Map dataModel = new HashMap<>();

        dataModel.put("tableComment", table.get("tableComment"));
        dataModel.put("generatorDate", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        dataModel.put("tableName", table.get("tableName"));
        dataModel.put("className", stringUtil.getClassName(table.get("tableName")));
        dataModel.put("genpkg", tableInfo.getDtoPgk());
        List<GenDto> fields = new ArrayList<>();

        // 遍历组装字段格式
        tableInfos.forEach(stringStringMap -> {
            GenDto genDto = new GenDto();
            genDto.setColumnKey(stringStringMap.get("columnKey").toLowerCase());
            genDto.setComment(stringStringMap.get("columnComment"));
            genDto.setTableName(stringStringMap.get("columnName"));
            genDto.setFieldName(stringUtil.getFieldName(stringStringMap.get("columnName")));
            genDto.setType(dtoUtil.dbType(stringStringMap.get("dataType")).name);
            genDto.setPkg(dtoUtil.dbType(stringStringMap.get("dataType")).pkg);
            fields.add(genDto);
        });

        // 筛选引入的包
        List<String> importPkg = fields.stream().map(GenDto::getPkg)
                .distinct()
                .collect(Collectors.toList());

        // 存放生成的字段信息
        dataModel.put("fields", fields);
        dataModel.put("importPkg", importPkg);

        String cacheFile = System.getProperty("user.dir");
        String gearfileUrl = cacheFile+"/generator/src/main/java/"+tableInfo.getDtoPgk().replace(".", "/")+"/";
        File gearfile = new File(gearfileUrl);
        if (!gearfile.exists()) {
            gearfile.mkdirs();
        }

        // 第六步：创建一个Writer对象，一般创建一FileWriter对象，指定生成的文件名。
        Writer out = new FileWriter(new File(gearfileUrl+stringUtil.getClassName(table.get("tableName"))+".java"));
        // 第七步：调用模板对象的process方法输出文件。
        template.process(dataModel, out);
        // 第八步：关闭流。
        out.close();
    }

    /**
     * 生成mapper
     * @param tableInfo
     * @param table
     * @param tableInfos
     * @throws IOException
     * @throws TemplateException
     */
    public void mapper(TableInfo tableInfo, Map<String,String> table, List<Map<String,String>> tableInfos) throws IOException, TemplateException {
        // 第一步：创建一个Configuration对象，直接new一个对象。构造方法的参数就是freemarker对于的版本号。
        Configuration configuration = new Configuration(Configuration.getVersion());
        File file = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX+"templates");
        // 第二步：设置模板文件所在的路径。
        configuration.setDirectoryForTemplateLoading(file);
        // 第三步：设置模板文件使用的字符集。一般就是utf-8.
        configuration.setDefaultEncoding("utf-8");
        // 第四步：加载一个模板，创建一个模板对象。
        Template template = configuration.getTemplate("mapper.ftl");
        // 第五步：创建一个模板使用的数据集，可以是pojo也可以是map。一般是Map。
        Map dataModel = new HashMap<>();

        dataModel.put("tableComment", table.get("tableComment"));
        dataModel.put("generatorDate", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        dataModel.put("tableName", table.get("tableName"));
        dataModel.put("className", stringUtil.getClassName(table.get("tableName")));
        dataModel.put("genpkg", tableInfo.getMapperPkg());
        dataModel.put("dtoClassPath",tableInfo.getDtoPgk()+"."+dataModel.get("className"));

        String cacheFile = System.getProperty("user.dir");
        String gearfileUrl = cacheFile+"/generator/src/main/java/"+tableInfo.getMapperPkg().replace(".", "/")+"/";
        File gearfile = new File(gearfileUrl);
        if (!gearfile.exists()) {
            gearfile.mkdirs();
        }

        // 第六步：创建一个Writer对象，一般创建一FileWriter对象，指定生成的文件名。
        Writer out = new FileWriter(new File(gearfileUrl+stringUtil.getClassName(table.get("tableName"))+"Mapper.java"));
        // 第七步：调用模板对象的process方法输出文件。
        template.process(dataModel, out);
        // 第八步：关闭流。
        out.close();
    }

    /**
     * 生成mapper
     * @param tableInfo
     * @param table
     * @param tableInfos
     * @throws IOException
     * @throws TemplateException
     */
    public void mapperXml(TableInfo tableInfo, Map<String,String> table, List<Map<String,String>> tableInfos) throws IOException, TemplateException {
        // 第一步：创建一个Configuration对象，直接new一个对象。构造方法的参数就是freemarker对于的版本号。
        Configuration configuration = new Configuration(Configuration.getVersion());
        File file = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX+"templates");
        // 第二步：设置模板文件所在的路径。
        configuration.setDirectoryForTemplateLoading(file);
        // 第三步：设置模板文件使用的字符集。一般就是utf-8.
        configuration.setDefaultEncoding("utf-8");
        // 第四步：加载一个模板，创建一个模板对象。
        Template template = configuration.getTemplate("mapperxml.ftl");
        // 第五步：创建一个模板使用的数据集，可以是pojo也可以是map。一般是Map。
        Map dataModel = new HashMap<>();

        dataModel.put("tableComment", table.get("tableComment"));
        dataModel.put("generatorDate", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        dataModel.put("tableName", table.get("tableName"));
        dataModel.put("className", stringUtil.getClassName(table.get("tableName")));
        dataModel.put("genpkg", tableInfo.getMapperPkg());
        dataModel.put("dtoClassPath",tableInfo.getDtoPgk()+"."+dataModel.get("className"));

        String cacheFile = System.getProperty("user.dir");
        String gearfileUrl = cacheFile+"/generator/src/main/java/"+tableInfo.getMapperPkg().replace(".", "/")+"/";
        File gearfile = new File(gearfileUrl);
        if (!gearfile.exists()) {
            gearfile.mkdirs();
        }

        // 第六步：创建一个Writer对象，一般创建一FileWriter对象，指定生成的文件名。
        Writer out = new FileWriter(new File(gearfileUrl+stringUtil.getClassName(table.get("tableName"))+"Mapper.xml"));
        // 第七步：调用模板对象的process方法输出文件。
        template.process(dataModel, out);
        // 第八步：关闭流。
        out.close();
    }

    /**
     * 生成request
     * @param tableInfo
     * @param table
     * @param tableInfos
     * @throws IOException
     * @throws TemplateException
     */
    public void request(TableInfo tableInfo, Map<String,String> table, List<Map<String,String>> tableInfos) throws IOException, TemplateException {
        // 第一步：创建一个Configuration对象，直接new一个对象。构造方法的参数就是freemarker对于的版本号。
        Configuration configuration = new Configuration(Configuration.getVersion());
        File file = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX+"templates");
        // 第二步：设置模板文件所在的路径。
        configuration.setDirectoryForTemplateLoading(file);
        // 第三步：设置模板文件使用的字符集。一般就是utf-8.
        configuration.setDefaultEncoding("utf-8");
        // 第四步：加载一个模板，创建一个模板对象。
        Template template = configuration.getTemplate("request.ftl");
        // 第五步：创建一个模板使用的数据集，可以是pojo也可以是map。一般是Map。
        Map dataModel = new HashMap<>();

        dataModel.put("tableComment", table.get("tableComment"));
        dataModel.put("generatorDate", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        dataModel.put("tableName", table.get("tableName"));
        dataModel.put("className", stringUtil.getClassName(table.get("tableName")));
        dataModel.put("genpkg", tableInfo.getApiPkg());
        List<GenDto> fields = new ArrayList<>();

        // 遍历组装字段格式
        tableInfos.forEach(stringStringMap -> {
            GenDto genDto = new GenDto();
            genDto.setColumnKey(stringStringMap.get("columnKey").toLowerCase());
            genDto.setComment(stringStringMap.get("columnComment"));
            genDto.setTableName(stringStringMap.get("columnName"));
            genDto.setFieldName(stringUtil.getFieldName(stringStringMap.get("columnName")));
            genDto.setType(dtoUtil.dbType(stringStringMap.get("dataType")).name);
            genDto.setPkg(dtoUtil.dbType(stringStringMap.get("dataType")).pkg);
            fields.add(genDto);
        });

        // 筛选引入的包
        List<String> importPkg = fields.stream().map(GenDto::getPkg)
                .distinct()
                .collect(Collectors.toList());

        // 存放生成的字段信息
        dataModel.put("fields", fields);
        dataModel.put("importPkg", importPkg);

        String cacheFile = System.getProperty("user.dir");
        String gearfileUrl = cacheFile+"/generator/src/main/java/"+tableInfo.getApiPkg().replace(".", "/")+"/";
        File gearfile = new File(gearfileUrl);
        if (!gearfile.exists()) {
            gearfile.mkdirs();
        }

        // 第六步：创建一个Writer对象，一般创建一FileWriter对象，指定生成的文件名。
        Writer out = new FileWriter(new File(gearfileUrl+stringUtil.getClassName(table.get("tableName"))+"Request.java"));
        // 第七步：调用模板对象的process方法输出文件。
        template.process(dataModel, out);
        // 第八步：关闭流。
        out.close();
    }

    /**
     * 生成service 接口
     * @param tableInfo
     * @param table
     * @param tableInfos
     * @throws IOException
     * @throws TemplateException
     */
    public void service(TableInfo tableInfo, Map<String,String> table, List<Map<String,String>> tableInfos) throws IOException, TemplateException {
        // 第一步：创建一个Configuration对象，直接new一个对象。构造方法的参数就是freemarker对于的版本号。
        Configuration configuration = new Configuration(Configuration.getVersion());
        File file = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX+"templates");
        // 第二步：设置模板文件所在的路径。
        configuration.setDirectoryForTemplateLoading(file);
        // 第三步：设置模板文件使用的字符集。一般就是utf-8.
        configuration.setDefaultEncoding("utf-8");
        // 第四步：加载一个模板，创建一个模板对象。
        Template template = configuration.getTemplate("service.ftl");
        // 第五步：创建一个模板使用的数据集，可以是pojo也可以是map。一般是Map。
        Map dataModel = new HashMap<>();

        dataModel.put("tableComment", table.get("tableComment"));
        dataModel.put("generatorDate", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        dataModel.put("tableName", table.get("tableName"));
        dataModel.put("className", stringUtil.getClassName(table.get("tableName")));
        dataModel.put("fegionService", tableInfo.getFeignClientService());
        dataModel.put("genpkg", tableInfo.getServicePkg());
        dataModel.put("dtoClassPath",tableInfo.getDtoPgk()+"."+dataModel.get("className"));
        dataModel.put("requestClassPath",tableInfo.getApiPkg()+"."+dataModel.get("className")+"Request");

        String cacheFile = System.getProperty("user.dir");
        String gearfileUrl = cacheFile+"/generator/src/main/java/"+tableInfo.getServicePkg().replace(".", "/")+"/";
        File gearfile = new File(gearfileUrl);
        if (!gearfile.exists()) {
            gearfile.mkdirs();
        }

        // 第六步：创建一个Writer对象，一般创建一FileWriter对象，指定生成的文件名。
        Writer out = new FileWriter(new File(gearfileUrl+"I"+stringUtil.getClassName(table.get("tableName"))+"Service.java"));
        // 第七步：调用模板对象的process方法输出文件。
        template.process(dataModel, out);
        // 第八步：关闭流。
        out.close();
    }

    /**
     * 生成service 接口
     * @param tableInfo
     * @param table
     * @param tableInfos
     * @throws IOException
     * @throws TemplateException
     */
    public void serviceHystrix(TableInfo tableInfo, Map<String,String> table, List<Map<String,String>> tableInfos) throws IOException, TemplateException {
        // 第一步：创建一个Configuration对象，直接new一个对象。构造方法的参数就是freemarker对于的版本号。
        Configuration configuration = new Configuration(Configuration.getVersion());
        File file = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX+"templates");
        // 第二步：设置模板文件所在的路径。
        configuration.setDirectoryForTemplateLoading(file);
        // 第三步：设置模板文件使用的字符集。一般就是utf-8.
        configuration.setDefaultEncoding("utf-8");
        // 第四步：加载一个模板，创建一个模板对象。
        Template template = configuration.getTemplate("servicehystrix.ftl");
        // 第五步：创建一个模板使用的数据集，可以是pojo也可以是map。一般是Map。
        Map dataModel = new HashMap<>();

        dataModel.put("tableComment", table.get("tableComment"));
        dataModel.put("generatorDate", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        dataModel.put("tableName", table.get("tableName"));
        dataModel.put("className", stringUtil.getClassName(table.get("tableName")));
        dataModel.put("fegionService", tableInfo.getFeignClientService());
        dataModel.put("genpkg", tableInfo.getServicePkg());
        dataModel.put("dtoClassPath",tableInfo.getDtoPgk()+"."+dataModel.get("className"));
        dataModel.put("serviceClassPath",tableInfo.getServicePkg()+".I"+dataModel.get("className")+"Service");
        dataModel.put("requestClassPath",tableInfo.getApiPkg()+"."+dataModel.get("className")+"Request");

        String cacheFile = System.getProperty("user.dir");
        String gearfileUrl = cacheFile+"/generator/src/main/java/"+tableInfo.getServicePkg().replace(".", "/")+"/hystrix/";
        File gearfile = new File(gearfileUrl);
        if (!gearfile.exists()) {
            gearfile.mkdirs();
        }

        // 第六步：创建一个Writer对象，一般创建一FileWriter对象，指定生成的文件名。
        Writer out = new FileWriter(new File(gearfileUrl+stringUtil.getClassName(table.get("tableName"))+"ServiceHystrix.java"));
        // 第七步：调用模板对象的process方法输出文件。
        template.process(dataModel, out);
        // 第八步：关闭流。
        out.close();
    }

    /**
     * 生成dto
     * @param tableInfo
     * @param table
     * @param tableInfos
     * @throws IOException
     * @throws TemplateException
     */
    public void serviceImpl(TableInfo tableInfo, Map<String,String> table, List<Map<String,String>> tableInfos) throws IOException, TemplateException {
        // 第一步：创建一个Configuration对象，直接new一个对象。构造方法的参数就是freemarker对于的版本号。
        Configuration configuration = new Configuration(Configuration.getVersion());
        File file = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX+"templates");
        // 第二步：设置模板文件所在的路径。
        configuration.setDirectoryForTemplateLoading(file);
        // 第三步：设置模板文件使用的字符集。一般就是utf-8.
        configuration.setDefaultEncoding("utf-8");
        // 第四步：加载一个模板，创建一个模板对象。
        Template template = configuration.getTemplate("serviceimpl.ftl");
        // 第五步：创建一个模板使用的数据集，可以是pojo也可以是map。一般是Map。
        Map dataModel = new HashMap<>();

        dataModel.put("tableComment", table.get("tableComment"));
        dataModel.put("generatorDate", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        dataModel.put("tableName", table.get("tableName"));
        dataModel.put("className", stringUtil.getClassName(table.get("tableName")));
        dataModel.put("dtoClassPath",tableInfo.getDtoPgk()+"."+dataModel.get("className"));
        dataModel.put("serviceClassPath",tableInfo.getServicePkg()+".I"+dataModel.get("className")+"Service");
        dataModel.put("requestClassPath",tableInfo.getApiPkg()+"."+dataModel.get("className")+"Request");
        dataModel.put("mapperClassPath",tableInfo.getMapperPkg()+"."+dataModel.get("className")+"Mapper");
        dataModel.put("genpkg", tableInfo.getServiceImplPkg());
        List<GenDto> fields = new ArrayList<>();

        // 遍历组装字段格式
        tableInfos.forEach(stringStringMap -> {
            GenDto genDto = new GenDto();
            genDto.setColumnKey(stringStringMap.get("columnKey").toLowerCase());
            genDto.setComment(stringStringMap.get("columnComment"));
            genDto.setTableName(stringStringMap.get("columnName"));
            genDto.setFieldName(stringUtil.getFieldName(stringStringMap.get("columnName")));
            genDto.setType(dtoUtil.dbType(stringStringMap.get("dataType")).name);
            genDto.setPkg(dtoUtil.dbType(stringStringMap.get("dataType")).pkg);
            fields.add(genDto);
        });

        // 筛选引入的包
        List<String> importPkg = fields.stream().map(GenDto::getPkg)
                .distinct()
                .collect(Collectors.toList());

        // 存放生成的字段信息
        dataModel.put("fields", fields);
        dataModel.put("importPkg", importPkg);

        String cacheFile = System.getProperty("user.dir");
        String gearfileUrl = cacheFile+"/generator/src/main/java/"+tableInfo.getServiceImplPkg().replace(".", "/")+"/";
        File gearfile = new File(gearfileUrl);
        if (!gearfile.exists()) {
            gearfile.mkdirs();
        }

        // 第六步：创建一个Writer对象，一般创建一FileWriter对象，指定生成的文件名。
        Writer out = new FileWriter(new File(gearfileUrl+stringUtil.getClassName(table.get("tableName"))+"ServiceImpl.java"));
        // 第七步：调用模板对象的process方法输出文件。
        template.process(dataModel, out);
        // 第八步：关闭流。
        out.close();
    }

    /**
     * 生成request
     * @param tableInfo
     * @param table
     * @param tableInfos
     * @throws IOException
     * @throws TemplateException
     */
    public void vo(TableInfo tableInfo, Map<String,String> table, List<Map<String,String>> tableInfos) throws IOException, TemplateException {
        // 第一步：创建一个Configuration对象，直接new一个对象。构造方法的参数就是freemarker对于的版本号。
        Configuration configuration = new Configuration(Configuration.getVersion());
        File file = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX+"templates");
        // 第二步：设置模板文件所在的路径。
        configuration.setDirectoryForTemplateLoading(file);
        // 第三步：设置模板文件使用的字符集。一般就是utf-8.
        configuration.setDefaultEncoding("utf-8");
        // 第四步：加载一个模板，创建一个模板对象。
        Template template = configuration.getTemplate("vo.ftl");
        // 第五步：创建一个模板使用的数据集，可以是pojo也可以是map。一般是Map。
        Map dataModel = new HashMap<>();

        dataModel.put("tableComment", table.get("tableComment"));
        dataModel.put("generatorDate", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        dataModel.put("tableName", table.get("tableName"));
        dataModel.put("className", stringUtil.getClassName(table.get("tableName")));
        dataModel.put("genpkg", tableInfo.getVoPkg());
        List<GenDto> fields = new ArrayList<>();

        // 遍历组装字段格式
        tableInfos.forEach(stringStringMap -> {
            GenDto genDto = new GenDto();
            genDto.setColumnKey(stringStringMap.get("columnKey").toLowerCase());
            genDto.setComment(stringStringMap.get("columnComment"));
            genDto.setTableName(stringStringMap.get("columnName"));
            genDto.setFieldName(stringUtil.getFieldName(stringStringMap.get("columnName")));
            genDto.setType(dtoUtil.dbType(stringStringMap.get("dataType")).name);
            genDto.setPkg(dtoUtil.dbType(stringStringMap.get("dataType")).pkg);
            fields.add(genDto);
        });

        // 筛选引入的包
        List<String> importPkg = fields.stream().map(GenDto::getPkg)
                .distinct()
                .collect(Collectors.toList());

        // 存放生成的字段信息
        dataModel.put("fields", fields);
        dataModel.put("importPkg", importPkg);

        String cacheFile = System.getProperty("user.dir");
        String gearfileUrl = cacheFile+"/generator/src/main/java/"+tableInfo.getVoPkg().replace(".", "/")+"/";
        File gearfile = new File(gearfileUrl);
        if (!gearfile.exists()) {
            gearfile.mkdirs();
        }

        // 第六步：创建一个Writer对象，一般创建一FileWriter对象，指定生成的文件名。
        Writer out = new FileWriter(new File(gearfileUrl+stringUtil.getClassName(table.get("tableName"))+"Vo.java"));
        // 第七步：调用模板对象的process方法输出文件。
        template.process(dataModel, out);
        // 第八步：关闭流。
        out.close();
    }
}
