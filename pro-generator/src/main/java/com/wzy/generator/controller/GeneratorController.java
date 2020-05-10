package com.wzy.generator.controller;
import com.wzy.common.util.ServiceResponse;
import com.wzy.common.zip.ZipFilesUtil;
import com.wzy.generator.controller.request.TableInfo;
import com.wzy.generator.service.GeneratorService;
import com.wzy.generator.service.IProGeneratorService;
import com.wzy.generator.util.Freemarker;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.io.*;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;

@RestController
@RequestMapping(path = "/db")
public class GeneratorController {

    @Autowired
    GeneratorService generatorService;

    @Autowired
    Freemarker freemarker;

    @Autowired
    IProGeneratorService proGeneratorService;

    /**
     * 获取数据库表列表
     * @return
     */
    @RequestMapping(path = "/tableList", method = RequestMethod.POST)
    public ServiceResponse<List<Map<String,String>>> getTableList(@RequestBody TableInfo tableInfo) throws Exception {
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
    @RequestMapping(path = "/generator", method = RequestMethod.POST)
    public ServiceResponse generator(@RequestBody TableInfo tableInfo) throws SQLException, ClassNotFoundException, IOException, TemplateException {
        freemarker.dto(tableInfo, generatorService.getTableList(tableInfo).get(0), generatorService.getTableInfo(tableInfo));
        freemarker.mapper(tableInfo, generatorService.getTableList(tableInfo).get(0), generatorService.getTableInfo(tableInfo));
        freemarker.mapperXml(tableInfo, generatorService.getTableList(tableInfo).get(0), generatorService.getTableInfo(tableInfo));
        freemarker.request(tableInfo, generatorService.getTableList(tableInfo).get(0), generatorService.getTableInfo(tableInfo));
        freemarker.service(tableInfo, generatorService.getTableList(tableInfo).get(0), generatorService.getTableInfo(tableInfo));
        freemarker.serviceHystrix(tableInfo, generatorService.getTableList(tableInfo).get(0), generatorService.getTableInfo(tableInfo));
        freemarker.serviceImpl(tableInfo, generatorService.getTableList(tableInfo).get(0), generatorService.getTableInfo(tableInfo));
        freemarker.vo(tableInfo, generatorService.getTableList(tableInfo).get(0), generatorService.getTableInfo(tableInfo));
        freemarker.controller(tableInfo, generatorService.getTableList(tableInfo).get(0), generatorService.getTableInfo(tableInfo));
        return new ServiceResponse().setCode(200);
    }

    /**
     * 生成文件
     * @param tableInfo
     * @return
     */
    @RequestMapping(path = "/generatorWeb", method = RequestMethod.POST)
    public ServiceResponse generatorWeb(@RequestBody TableInfo tableInfo) throws SQLException, ClassNotFoundException, IOException, TemplateException {
        freemarker.web(tableInfo, generatorService.getTableList(tableInfo).get(0), generatorService.getTableInfo(tableInfo));
        freemarker.webjs(tableInfo, generatorService.getTableList(tableInfo).get(0), generatorService.getTableInfo(tableInfo));
        return new ServiceResponse().setCode(200);
    }

    /**
     * 下载导出来的文件
     * @return
     */
    @RequestMapping(path = "/downloadZip", method = RequestMethod.GET)
    public ResponseEntity<byte[]> downloadZip() {
        String url = System.getProperty("user.dir")+"/generator";
        File sourceDir = new File(url);
        File zipFile = new File(url+".zip");
        ZipOutputStream zos = null;
        try {
            zos = new ZipOutputStream(new FileOutputStream(zipFile));
            String baseDir = "generator/";
            ZipFilesUtil.compress(sourceDir, baseDir, zos);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally{
            if(zos!=null)
                try {
                    zos.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        }
        ResponseEntity<byte[]> responseEntity = returnFile(zipFile);
        if (zipFile.exists()) {
            zipFile.delete();
        }
        delFile(new File(url));
        return responseEntity;
    }

    /**
     * 下载文件
     * @param fileDatas
     * @return
     */
    public ResponseEntity<byte[]> returnFile(File fileDatas) {
        try {
            InputStream inputStream = new FileInputStream(fileDatas);
            byte[] filedatas = InputStreamToByte(inputStream);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            headers.setContentDispositionFormData("attachment", simpleDateFormat.format(new Date())+".zip");
            ResponseEntity<byte[]> files = new ResponseEntity<byte[]>(filedatas,
                    headers, HttpStatus.CREATED);
            inputStream.close();
            return files;
        } catch (Exception e) {
        }
        return  null;
    }

    public byte[] InputStreamToByte(InputStream iStrm) throws IOException {
        ByteArrayOutputStream bytestream = new ByteArrayOutputStream();
        int ch;
        while ((ch = iStrm.read()) != -1)
        {
            bytestream.write(ch);
        }
        byte imgdata[]=bytestream.toByteArray();
        bytestream.close();
        return imgdata;
    }

    /**
     * 删除文件夹
     * @param file
     * @return
     */
    boolean delFile(File file) {
        if (!file.exists()) {
            return false;
        }

        if (file.isFile()) {
            return file.delete();
        } else {
            File[] files = file.listFiles();
            for (File f : files) {
                delFile(f);
            }
            return file.delete();
        }
    }
}
