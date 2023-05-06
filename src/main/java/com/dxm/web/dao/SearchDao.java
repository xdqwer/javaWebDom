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

public class SearchDao {

    public List<Massages> massagesList(String keyWord) throws SQLException {
        MySQLConnection mySQLConnection= new MySQLConnection();
        Connection connection=mySQLConnection.getConnection();
        String sql = "SELECT * FROM massages WHERE title  LIKE ?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,"%"+keyWord+"%");
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

//    public static void main(String[] args) throws SQLException {
//        MySQLConnection mySQLConnection= new MySQLConnection();
//        Connection connection=mySQLConnection.getConnection();
//        String sql = "SELECT * FROM massages WHERE title  LIKE ?";
//        PreparedStatement preparedStatement=connection.prepareStatement(sql);
//        String keyWord="累吗";
//        preparedStatement.setString(1,"%"+keyWord+"%");
//        ResultSet resultSet=preparedStatement.executeQuery();
//        if (resultSet.next()){
//            System.out.println(resultSet.getString("title"));
//        }
//    }

}
