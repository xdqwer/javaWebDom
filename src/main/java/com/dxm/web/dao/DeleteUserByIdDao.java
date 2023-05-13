package com.dxm.web.dao;

import com.dxm.web.utils.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteUserByIdDao {
    public void deleteUserById(int id) throws SQLException {
        MySQLConnection mySQLConnection = new MySQLConnection();
        Connection connection = mySQLConnection.getConnection();
        String sql="delete from `user` where id = "+id;
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.execute();
        preparedStatement.close();
        connection.close();
    }
}
