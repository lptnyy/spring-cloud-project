package com.wzy.generator.controller;

import com.wzy.common.util.ServiceResponse;
import com.wzy.generator.controller.request.TableInfo;
import com.wzy.generator.service.GeneratorService;
import com.wzy.generator.util.Freemarker;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/db")
public class GeneratorController {

    @Autowired
    GeneratorService generatorService;

    @Autowired
    Freemarker freemarker;

    /**
     * 获取数据库表列表
     * @param tableInfo
     * @return
     */
    @RequestMapping(path = "/tableList")
    public ServiceResponse<List<Map<String,String>>> getTableList(@RequestBody TableInfo tableInfo) {
        return new ServiceResponse<List<Map<String,String>>>()
                .run(serviceResponse -> {
                    return generatorService.getTableList(tableInfo);
                })
                .exec();
    }


    /**
     * 生成文件
     * @param tableInfo
     * @return
     */
    @RequestMapping(path = "/generator")
    public ServiceResponse<String> generator(@RequestBody TableInfo tableInfo) throws SQLException, ClassNotFoundException, IOException, TemplateException {
        freemarker.dto(tableInfo, generatorService.getTableList(tableInfo).get(0), generatorService.getTableInfo(tableInfo));
        freemarker.mapper(tableInfo, generatorService.getTableList(tableInfo).get(0), generatorService.getTableInfo(tableInfo));
        freemarker.mapperXml(tableInfo, generatorService.getTableList(tableInfo).get(0), generatorService.getTableInfo(tableInfo));
        freemarker.request(tableInfo, generatorService.getTableList(tableInfo).get(0), generatorService.getTableInfo(tableInfo));
        freemarker.service(tableInfo, generatorService.getTableList(tableInfo).get(0), generatorService.getTableInfo(tableInfo));
        freemarker.serviceHystrix(tableInfo, generatorService.getTableList(tableInfo).get(0), generatorService.getTableInfo(tableInfo));
        return null;
    }
}
