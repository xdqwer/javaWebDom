package com.dxm.web.dao;

import com.dxm.web.entity.Replace;
import com.dxm.web.utils.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddCommentDao {

    public void insertReplace(Replace rp) throws SQLException {
        String sql = "insert into comments (atcid,userid,content,parentid) value (?,?,?,null)";
        MySQLConnection mySQLConnection = new MySQLConnection();
        Connection connection = mySQLConnection.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setInt(1,rp.getAtcid());
        preparedStatement.setInt(2,rp.getUserid());
        preparedStatement.setString(3,rp.getContent());
        preparedStatement.execute();
        preparedStatement.close();
        connection.close();
    }

//    public static void main(String[] args) throws SQLException {
//        String sql = "insert into comments (atcid,userid,content) value (?,?,?)";
//        MySQLConnection mySQLConnection = new MySQLConnection();
//        Connection connection = mySQLConnection.getConnection();
//        PreparedStatement preparedStatement=connection.prepareStatement(sql);
//        String content="牛啊，泰库啦";
//        preparedStatement.setInt(1,3);
//        preparedStatement.setInt(2,1);
//        preparedStatement.setString(3,content);
//        preparedStatement.execute();
//        preparedStatement.close();
//        connection.close();
//    }
}
