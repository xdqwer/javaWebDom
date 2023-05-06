package com.dxm.web.dao;

import cn.hutool.core.convert.Convert;
import com.dxm.web.entity.Comments;
import com.dxm.web.entity.Massages;
import com.dxm.web.entity.Replace;
import com.dxm.web.utils.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentsDao {
    public List<Comments> commentsList(int atcid) throws SQLException {
        MySQLConnection mySQLConnection= new MySQLConnection();
        Connection connection=mySQLConnection.getConnection();
        String sql = "SELECT * FROM `comments` WHERE parentid is null AND atcid ="+atcid;
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        ResultSet resultSet=preparedStatement.executeQuery();
        List<Comments> commentsList=new ArrayList<>();
        while (resultSet.next()){
            Comments comments=new Comments();
            comments.setId(resultSet.getInt("id"));
            comments.setAtcid(resultSet.getInt("atcid"));
            comments.setUserid(resultSet.getInt("userid"));
            comments.setContent(resultSet.getString("content"));
            comments.setParentid(resultSet.getInt("parentid"));
            List<Replace> replaces = getReplace(Convert.toInt(resultSet.getInt("id")));
            comments.setReplace(replaces);
            commentsList.add(comments);
        }
        mySQLConnection.closeConnection(connection);
        return commentsList;
    }
    public List<Replace> getReplace(int id) throws SQLException {
        MySQLConnection mySQLConnection= new MySQLConnection();
        Connection connection=mySQLConnection.getConnection();
        String sql = "SELECT * FROM comments WHERE parentid = "+id;
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        ResultSet resultSet=preparedStatement.executeQuery();
        List<Replace> replaces=new ArrayList<>();
        while (resultSet.next()){
            Replace replace=new Replace();
            replace.setId(resultSet.getInt("id"));
            replace.setAtcid(resultSet.getInt("atcid"));
            replace.setUserid(resultSet.getInt("userid"));
            replace.setContent(resultSet.getString("content"));
            replace.setParentid(resultSet.getInt("parentid"));

            replaces.add(replace);
        }
        mySQLConnection.closeConnection(connection);
        return replaces;
    }
}
