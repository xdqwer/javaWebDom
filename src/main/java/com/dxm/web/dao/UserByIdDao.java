package com.dxm.web.dao;

import com.dxm.web.entity.Massages;
import com.dxm.web.entity.User;
import com.dxm.web.utils.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserByIdDao {

    public List<User> reqUserById(int userid) throws SQLException {
        MySQLConnection mySQLConnection = new MySQLConnection();
        Connection connection=mySQLConnection.getConnection();
        String sql="select *  from user where id = "+userid;
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet= statement.executeQuery();
        List<User> userList=new ArrayList<>();
        while (resultSet.next()) {
            User user = new User();
            user.setId(resultSet.getInt("id"));
            user.setUser_name(resultSet.getString("user_name"));
            user.setPassword(resultSet.getString("password"));
            user.setEmail(resultSet.getString("email"));
            userList.add(user);
        }
        return userList;
    }
}
