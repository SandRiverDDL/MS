package com.ms.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/*
 * 数据库库连接工具类
 */
public class DbUtil {

    private static String dbDriver;
    private static String dbUrl;
    private static String dbUsername;
    private static String dbPassword;

    static {
        Properties rp = new Properties();
        InputStream ips = DbUtil.class.getResourceAsStream("/db.properties");
        try {
            rp.load(ips);
            dbDriver = rp.getProperty("dbDriver");
            dbUrl = rp.getProperty("dbUrl");
            dbUsername = rp.getProperty("dbUsername");
            dbPassword = rp.getProperty("dbPassword");
            Class.forName(dbDriver);
        } catch (IOException |ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return con;
    }

}
