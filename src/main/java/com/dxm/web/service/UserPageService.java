package com.dxm.web.service;

import com.dxm.web.dao.UserPageDao;

import java.sql.SQLException;

public class UserPageService {
    public int sumUsr() throws SQLException {
        UserPageDao userPageDao = new UserPageDao();
        int count = userPageDao.sumUser();
        int count2=(count%10!=0?count/10+1:count/10);
        return count2;
    }

//    public static void main(String[] args) throws SQLException {
//        UserPageService userPageService = new UserPageService();
//        int i = userPageService.sumUsr();
//        System.out.println(i);
//    }
}

