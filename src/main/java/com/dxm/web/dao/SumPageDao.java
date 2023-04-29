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

public class SumPageDao {

    public int massagesList( ) throws SQLException {
        MySQLConnection mySQLConnection= new MySQLConnection();
        Connection connection=mySQLConnection.getConnection();
        String sql = "select COUNT(*) as `count` from massages";
        PreparedStatement preparedStatement=connection.prepareStatement(sql); //创建一个PreparedStatement接口实例对象
        ResultSet resultSet=preparedStatement.executeQuery(); //执行数据查询
        int number=0;
        //判断是否有数据
        if (resultSet.next()){
            number= Integer.parseInt(resultSet.getString("count"));
        }
        mySQLConnection.closeConnection(connection);
        return number;
    }
//    public static void main(String[] args) throws SQLException {
//        MySQLConnection mySQLConnection= new MySQLConnection();
//        Connection connection=mySQLConnection.getConnection();
//        String sql = "select COUNT(*) as `count` from massages";
//        PreparedStatement preparedStatement=connection.prepareStatement(sql); //创建一个PreparedStatement接口实例对象
//        ResultSet resultSet=preparedStatement.executeQuery(); //执行数据查询
//        //判断是否有数据
//        if (resultSet.next()){
//            int number= Integer.parseInt(resultSet.getString("count"));
//            System.out.println(number);
//        }
//        mySQLConnection.closeConnection(connection);
//    }

}

