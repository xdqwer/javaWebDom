package com.dxm.web.dao;

import com.dxm.web.utils.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteAtcByIdDao {

    public void DeleteAtcByAtcId(int atcId) throws SQLException {
        MySQLConnection mySQLConnection = new MySQLConnection();
        Connection connection = mySQLConnection.getConnection();
        String sql="delete from `massages` where atcid = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,atcId);
        preparedStatement.execute();
        preparedStatement.close();
        connection.close();
    }
}
