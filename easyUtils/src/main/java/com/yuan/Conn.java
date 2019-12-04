package com.yuan;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Conn {

    public static void main(String[] args) throws Exception {
        String urlA = "jdbc:sqlserver://10.164.4.54;DatabaseName=Map-SIT";
        String urlB = "jdbc:sqlserver://10.164.27.34\\sql2012;DatabaseName=Map";

        String usernameA = "sa";
        String usernameB = "mapadmin";

        String passwordA = "User123$";
        String passwordB = "User123$";


        System.out.println("开始 注册驱动");
        //1.注册驱动
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        System.out.println("注册驱动 成功");
        //2.创建数据库连接对象
        System.out.println("开始 连接A数据库");
        Connection connA = DriverManager.getConnection(urlA, usernameA, passwordA);
        System.out.println("连接A数据库 成功");
        System.out.println("开始 连接B数据库");
        Connection connB = DriverManager.getConnection(urlB, usernameB, passwordB);
        System.out.println("连接B数据库 成功");
        //第一步、从A数据库取出数据
        //1.定义sql语句
        String sqlA = "select * from TEST_WUBO";
        //2.预编译 并获得prepareStatement对象
        PreparedStatement psA = connA.prepareStatement(sqlA);
        //3.执行sql 获得结果集
        ResultSet rsA = psA.executeQuery();
        //4.处理结果
        ArrayList<HashMap<String, String>> listA = new ArrayList<>();
        while (rsA.next()) {
            HashMap<String, String> mapA = new HashMap<>();
            mapA.put("USERNAME", rsA.getString(1));
            mapA.put("PASSWORD", rsA.getString(2));
            listA.add(mapA);
        }

        //第二步、将获取到的数据存储到B数据库中
        //1.准备SQL语句到SQL集合中
        ArrayList<String> SQLArrayList = new ArrayList<>();
        for (HashMap<String, String> mapA : listA) {
            StringBuffer sb = new StringBuffer();
            sb.append("INSERT INTO TEST_WUBO VALUES ( ");
            sb.append("\'" + mapA.get("USERNAME") + "\'" + ", ");
            sb.append("\'" + mapA.get("PASSWORD") + "\'" + " ");
            sb.append(" )");
            SQLArrayList.add(sb.toString());
        }


        //第三步、将SQL从SQLArrayList中取出来并执行
        for (String sql : SQLArrayList) {
            System.out.println("执行SQL : " + sql);
            connB.createStatement().executeUpdate(sql);
            connB.commit();
        }
    }
}
