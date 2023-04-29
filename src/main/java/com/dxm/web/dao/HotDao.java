package com.dxm.web.dao;

import com.dxm.web.entity.Massages;
import com.dxm.web.utils.MySQLConnection;
import com.mysql.cj.xdevapi.Result;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HotDao {
    MySQLConnection mySQLConnection= new MySQLConnection();
    public List<Massages> massagesList() throws SQLException {
        Connection connection=mySQLConnection.getConnection();
        String sql = "select * from massages order by support desc limit 3";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        ResultSet resultSet=preparedStatement.executeQuery();
        List<Massages> massagesList=new ArrayList<>();
        while (resultSet.next()){
            Massages massages=new Massages();
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
        mySQLConnection.closeConnection(connection);
        return massagesList;
    }

}
