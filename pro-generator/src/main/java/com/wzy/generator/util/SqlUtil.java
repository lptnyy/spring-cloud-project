package com.wzy.generator.util;

import com.wzy.generator.controller.request.TableInfo;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class SqlUtil {

    /**
     * 获取数据库链接
     * @param tableInfo
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Connection getConnection(TableInfo tableInfo) throws SQLException, ClassNotFoundException {
        // 注册 JDBC 驱动
        Class.forName(tableInfo.getMysqlDev());
        Connection connection = DriverManager.getConnection(tableInfo.getMysql(),tableInfo.getMysqlUser(),tableInfo.getMsyqlPass());
        return connection;
    }
}
