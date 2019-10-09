package com.yuan.util.jdbc;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author Yuan-9826
 */
public class JDBCUtils {

    private static DataSource ds;
    private static InputStream stream = ClassLoader.getSystemResourceAsStream("druid.properties");

    static {

        try {
            //加载配置文件
            Properties properties = new Properties();
            properties.load(stream);
            //获取 DataSource
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接
     *
     * @return
     */
    public static Connection getConnection() {
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("获取连接失败");
        }
    }

    /**
     * 获取连接池
     *
     * @return
     */
    public static DataSource getDataSource() {
        return ds;
    }

    /**
     * 释放资源
     *
     * @param conn
     * @param statment
     * @param resultSet
     */
    public static void close(Connection conn, Statement statment, ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (statment != null) {
            try {
                statment.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }

    /**
     * 释放资源
     *
     * @param conn
     * @param statment
     */
    public static void close(Connection conn, Statement statment) {
        close(conn, statment, null);
    }

    /**
     * 释放资源
     *
     * @param conn
     */
    public static void close(Connection conn) {
        close(conn, null, null);

    }

    @Test
    public void test() throws IOException {

    }
}
