package com.dxm.web.dao;
import com.dxm.web.entity.User;
import com.dxm.web.utils.MySQLConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    MySQLConnection mySQLConnection=new MySQLConnection();
    public Connection getConnection() throws SQLException {
        Connection connection = mySQLConnection.getConnection();
        return connection;
    }
    public List<User> selectAll() throws SQLException {
        PreparedStatement statement = null;
        List<User> userList = new ArrayList<>();
        String sql = "select *  from user";
        Connection connection = getConnection();
        statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()){
            User user =new User();
            user.setId(resultSet.getInt("id"));
            user.setUser_name(resultSet.getString("user_name"));
            user.setPassword(resultSet.getString("password"));
            user.setEmail(resultSet.getString("email"));
            userList.add(user);
        }
        mySQLConnection.closeConnection(connection);
        return  userList;
    }


}
