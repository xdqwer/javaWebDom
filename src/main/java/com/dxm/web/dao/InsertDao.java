package com.dxm.web.dao;

import com.dxm.web.entity.User;
import com.dxm.web.utils.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertDao {
    static MySQLConnection mySQLConnection=new MySQLConnection();

    public void insert(User u) throws SQLException {
        String sql = "insert into user (user_name,password,email) value (?,?,?)";
        Connection connection=mySQLConnection.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1, u.getUser_name());
        preparedStatement.setString(2, u.getPassword());
        preparedStatement.setString(3, u.getEmail());
        preparedStatement.execute();
        preparedStatement.close();
        connection.close();
    }

//    public static void main(String[] args) throws SQLException {
//        String sql = "insert into user (user_name,password,email) value (?,?,?)";
//        Connection connection=mySQLConnection.getConnection();
//        PreparedStatement preparedStatement=connection.prepareStatement(sql);
//        preparedStatement.setString(1, "王德发");
//        preparedStatement.setString(2, "0a113ef6b61820daa5611c870ed8d5ee");
//        preparedStatement.setString(3, "1728900192@qq.com");
//        System.out.println(preparedStatement);
//        preparedStatement.execute();
//        preparedStatement.close();
//        connection.close();
//
//    }
}
