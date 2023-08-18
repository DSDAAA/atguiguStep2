package org.example.Controller;

import org.example.Pojo.Job;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class sqlController {
    @Test
    public void test() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql:///atguigu", "root", "123456");

        String sql = "SELECT * FROM t_employee";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("ename"));
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }

    @Test
    public void test1() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql:///atguigu", "root", "123456");
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM t_job");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Job> res = new ArrayList<>();
        while (resultSet.next()) {
            res.add(new Job(resultSet.getInt("jid"), resultSet.getString("jname"), resultSet.getString("description")));
        }
        Iterator iterator = res.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
    @Test
    public void test2() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql:///atguigu", "root", "123456");

        String str = "insert into t_job values(null,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(str);
        for (int i=0;i<10000;i++){
            preparedStatement.setObject(1,i);
            preparedStatement.setObject(2,i);
            preparedStatement.addBatch();
        }
        preparedStatement.executeBatch();
        preparedStatement.close();
        connection.close();
    }
}
