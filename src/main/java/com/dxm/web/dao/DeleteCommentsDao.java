package com.dxm.web.dao;

import com.dxm.web.utils.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteCommentsDao {

    public void deleteCommentById(int commentId) throws SQLException {
        MySQLConnection mySQLConnection = new MySQLConnection();
        Connection connection = mySQLConnection.getConnection();
        String sql="delete from `comments` where id=? or id in (SELECT id WHERE parentid=?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,commentId);
        preparedStatement.setInt(2,commentId);
        preparedStatement.execute();
        connection.close();
        preparedStatement.close();
    }

//    public static void main(String[] args) throws SQLException {
//        MySQLConnection mySQLConnection = new MySQLConnection();
//        Connection connection = mySQLConnection.getConnection();
//        String sql="delete from `comments` where id=? or id in (SELECT id WHERE parentid=?)";
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.setInt(1,20);
//        preparedStatement.setInt(2,20);
//        preparedStatement.execute();
//        connection.close();
//        preparedStatement.close();
//    }
}
