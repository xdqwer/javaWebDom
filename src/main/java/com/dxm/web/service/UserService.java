package com.dxm.web.service;
import com.dxm.web.dao.UserDao;
import com.dxm.web.entity.User;
import com.dxm.web.utils.Md5Utils;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

public class UserService {
    public UserDao userDao  = new UserDao();;
    public List<User> userList() throws SQLException {
        List<User> users = userDao.selectAll();
        return users;
    }

    //登录判断
    public boolean login(String username,String password) throws SQLException, NoSuchAlgorithmException {
       List<User> userOn = userDao.selectAll();
        Md5Utils md5Utils = new Md5Utils();
        String passwordMd = md5Utils.md5(password);
       boolean tf=false;
        for(int i = 0; i < userOn.size(); i++)
        {
                if (username.equals(userOn.get(i).getUser_name()) && passwordMd.equals(userOn.get(i).getPassword())){
                    tf = true;
                }
        }
        return tf;
    }


//    public static void main(String[] args) throws SQLException {
//        UserService userService = new UserService();
//        List<User> users = userService.userList();
//        System.out.println(users);
//
//    }
}
