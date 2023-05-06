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
    public int login(String username,String password) throws SQLException, NoSuchAlgorithmException {
       List<User> userOn = userDao.selectAll();
        Md5Utils md5Utils = new Md5Utils();
        String passwordMd = md5Utils.md5(password);
       int tf=0;
        for(int i = 0; i < userOn.size(); i++)
        {
                if (username.equals(userOn.get(i).getUser_name()) && passwordMd.equals(userOn.get(i).getPassword())){
                    tf = userOn.get(i).getId();
                }
        }
        return tf;
    }


//    public static void main(String[] args) throws NoSuchAlgorithmException {
//        Md5Utils md5Utils = new Md5Utils();
//        String password="12345";
//        String passwordMd = md5Utils.md5(password);
//        System.out.println(passwordMd);
//    }
}
