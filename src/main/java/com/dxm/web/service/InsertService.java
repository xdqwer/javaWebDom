package com.dxm.web.service;

import com.dxm.web.dao.InsertDao;
import com.dxm.web.entity.User;
import com.dxm.web.utils.Md5Utils;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class InsertService {

    public void insert(String username,String password,String email) throws SQLException, NoSuchAlgorithmException {
        InsertDao insertDao = new InsertDao();
        User user = new User();
        Md5Utils md5Utils=new Md5Utils();
        String passwordMd=md5Utils.md5(password);
        user.setUser_name(username);
        user.setPassword(passwordMd);
        user.setEmail(email);
        insertDao.insert(user);
    }

    public static void main(String[] args) throws SQLException, NoSuchAlgorithmException {
//        InsertDao insertDao = new InsertDao();
//        User user = new User();
        Md5Utils md5Utils=new Md5Utils();
        String password = "222";
        String passwordMd = md5Utils.md5(password);
        System.out.println(passwordMd);
//        user.setUser_name("赵信");
//        user.setPassword(passwordMd);
//        user.setEmail("1728900192@qq.com");
//        insertDao.insert(user);
    }

}
