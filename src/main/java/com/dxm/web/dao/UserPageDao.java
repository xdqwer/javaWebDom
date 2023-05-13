package com.dxm.web.dao;

import com.dxm.web.utils.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserPageDao {

    public int sumUser() throws SQLException {
        MySQLConnection mySQLConnection = new MySQLConnection();
        Connection connection = mySQLConnection.getConnection();
        String sql="select COUNT(*) as `count` from `user`";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet=preparedStatement.executeQuery();
        int count = 0;
        if (resultSet.next()){
            count = resultSet.getInt("count");
        }
        preparedStatement.close();
        connection.close();
        return count;
    }
}
