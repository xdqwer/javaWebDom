package com.dxm.web.dao;

import com.dxm.web.entity.Massages;
import com.dxm.web.utils.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MassagesByUserIdDao {

    public List<Massages> UserIdMassages(int userId) throws SQLException {
        MySQLConnection mySQLConnection = new MySQLConnection();
        Connection connection=mySQLConnection.getConnection();
        String sql = "select * from massages where userid = "+userId;
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        ResultSet resultSet=preparedStatement.executeQuery();
        List<Massages> massagesList=new  ArrayList<>();
        while (resultSet.next()){
            Massages massages = new Massages();
            massages.setAtcid(resultSet.getInt("atcid"));
            massages.setUserid(resultSet.getInt("userid"));
            massages.setTitle(resultSet.getString("title"));
            massages.setContent(resultSet.getString("content"));
            massages.setDate(resultSet.getString("date"));
            massages.setSupport(resultSet.getInt("support"));
            massages.setAtcnumber(resultSet.getInt("atcnumber"));
            massages.setAtcimg(resultSet.getString("atcimg"));
            massagesList.add(massages);
        }
        return massagesList;
    }
}
