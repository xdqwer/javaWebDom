package com.dxm.web.dao;

import com.dxm.web.entity.User;
import com.dxm.web.utils.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateUserMassageDao {
    public void updateUser(User user) throws SQLException {
        MySQLConnection mySQLConnection = new MySQLConnection();
        Connection connection = mySQLConnection.getConnection();
        String sql="update `user` set user_name=?,`password`=?,email=?,avatar=? where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        System.out.println("获取前端头像数据："+user.getAvatar());
        preparedStatement.setString(1,user.getUser_name());
        preparedStatement.setString(2,user.getPassword());
        preparedStatement.setString(3,user.getEmail());
        preparedStatement.setString(4,user.getAvatar());
        preparedStatement.setInt(5,user.getId());
        preparedStatement.execute();
        preparedStatement.close();
        connection.close();
    }
}
