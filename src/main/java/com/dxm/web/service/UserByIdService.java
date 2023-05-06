package com.dxm.web.service;

import com.dxm.web.dao.UserByIdDao;
import com.dxm.web.entity.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserByIdService {

    public List<User> reqUserById(int userid) throws SQLException {
        UserByIdDao userByIdDao = new UserByIdDao();
        List<User> userList=userByIdDao.reqUserById(userid);
        return  userList;
    }
}
