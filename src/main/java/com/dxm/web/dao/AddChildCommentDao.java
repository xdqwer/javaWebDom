package com.dxm.web.dao;

import com.dxm.web.entity.Replace;
import com.dxm.web.utils.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddChildCommentDao {

    public void insertComment(Replace replace) throws SQLException {
        MySQLConnection mySQLConnection=new MySQLConnection();
        Connection connection = mySQLConnection.getConnection();
        String sql = "insert into comments (atcid,userid,content,parentid) value (?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,replace.getAtcid());
        preparedStatement.setInt(2,replace.getUserid());
        preparedStatement.setString(3,replace.getContent());
        preparedStatement.setInt(4,replace.getParentid());
        preparedStatement.execute();
        connection.close();
        preparedStatement.close();
    }
}
