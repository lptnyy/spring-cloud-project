package com.wzy.generator.service;
import com.wzy.generator.controller.request.TableInfo;
import com.wzy.generator.util.SqlUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GeneratorService {

    @Autowired
    SqlUtil sqlUtil;

    /**
     * 获取数据库所有表名称
     * @param tableInfo
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<Map<String,String>> getTableList(TableInfo tableInfo) throws SQLException, ClassNotFoundException {
        try{
            List<Map<String,String>> result = new ArrayList<>();
            Connection connection = sqlUtil.getConnection(tableInfo);
            Statement stmt = connection.createStatement();
            String dbName = tableInfo.getMysql().substring(tableInfo.getMysql().lastIndexOf("/")+1);
            String sql = "select * from information_schema.tables WHERE table_schema='"+dbName+"'";
            if (!StringUtils.isEmpty(tableInfo.getTableName())) {
                sql += " and table_name='"+tableInfo.getTableName()+"'";
            }
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                String tableName = rs.getString("table_name");
                String createTime = rs.getString("create_time");
                String engine = rs.getString("engine");
                String tableComment = rs.getString("table_comment");
                Map<String,String> map = new HashMap<>();
                map.put("tableName",tableName);
                map.put("createTime",createTime);
                map.put("engine",engine);
                map.put("tableComment",tableComment);
                result.add(map);
            }
            connection.close();
            stmt.close();
            rs.close();
            return result;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * 获取数据库表列名
     * @param tableInfo
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<Map<String,String>> getTableInfo(TableInfo tableInfo) throws SQLException, ClassNotFoundException {
        try{
            List<Map<String,String>> result = new ArrayList<>();
            Connection connection = sqlUtil.getConnection(tableInfo);
            Statement stmt = connection.createStatement();
            String dbName = tableInfo.getMysql().substring(tableInfo.getMysql().lastIndexOf("/")+1);
            String sql = "select  *  from information_schema.columns where table_schema ='"
                    +dbName+"'  and table_name = '"+tableInfo.getTableName()+"'";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                String columnName = rs.getString("column_name");
                String dataType = rs.getString("data_type");
                String columnComment = rs.getString("column_comment");
                String columnKey = rs.getString("COLUMN_KEY");

                Map<String,String> map = new HashMap<>();
                map.put("columnName",columnName);
                map.put("dataType",dataType);
                map.put("columnComment",columnComment);
                map.put("columnKey",columnKey);
                result.add(map);
            }
            connection.close();
            stmt.close();
            rs.close();
            return result;
        } catch (Exception e) {
            throw e;
        }
    }
}
