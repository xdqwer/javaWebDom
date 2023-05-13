package com.dxm.web.dao;

import com.dxm.web.entity.Massages;
import com.dxm.web.utils.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class AddMassageDao {
    public void insertMassage(Massages msg) throws SQLException {
        MySQLConnection mySQLConnection = new MySQLConnection();
        Connection connection = mySQLConnection.getConnection();
        String sql="INSERT INTO massages (userid,title,content,`date`,support,atcnumber,atcimg) VALUES(?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,msg.getUserid());
        preparedStatement.setString(2,msg.getTitle());
        preparedStatement.setString(3,msg.getContent());
        preparedStatement.setString(4,msg.getDate());
        preparedStatement.setInt(5,msg.getSupport());
        preparedStatement.setInt(6,msg.getAtcnumber());
        preparedStatement.setString(7,msg.getAtcimg());
        preparedStatement.execute();
        preparedStatement.close();
        connection.close();
    }


}
