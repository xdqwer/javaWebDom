package com.dxm.web.service;

import com.dxm.web.dao.UserByIdDao;
import com.dxm.web.entity.User;
import com.dxm.web.utils.JwtUtils;
import com.dxm.web.utils.RedisUtil;
import redis.clients.jedis.Jedis;

import java.sql.SQLException;
import java.util.List;

public class UserByIdService2 {
    public List<User> reqUserById(int userid) throws SQLException {
        UserByIdDao userByIdDao = new UserByIdDao();
        List<User> userList=userByIdDao.reqUserById(userid);
        return  userList;
    }
}
