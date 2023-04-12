package com.dxm.web.dao;

import com.dxm.web.utils.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SupportUpDao {

    public void updateSupport(int atcid,int support) throws SQLException {
        MySQLConnection mySQLConnection = new MySQLConnection();
        String sql="UPDATE massages SET support =? WHERE atcid =?";
        Connection connection=mySQLConnection.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setInt(1,support);
        preparedStatement.setInt(2,atcid);
        preparedStatement.execute();
        preparedStatement.close();
        connection.close();
    }
}
