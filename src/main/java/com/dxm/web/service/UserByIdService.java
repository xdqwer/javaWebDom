package com.dxm.web.service;

import com.dxm.web.dao.UserByIdDao;
import com.dxm.web.entity.User;
import com.dxm.web.utils.JwtUtils;
import com.dxm.web.utils.RedisUtil;
import redis.clients.jedis.Jedis;

import java.sql.SQLException;
import java.util.List;

public class UserByIdService {

    public List<User> reqUserById(String userid) throws SQLException {
        UserByIdDao userByIdDao = new UserByIdDao();
        Jedis jedis = RedisUtil.getJedis();
        String uuid = JwtUtils.getToken(userid);
        String s = jedis.get(uuid);
        List<User> userList=userByIdDao.reqUserById(Integer.parseInt(s));
        return  userList;
    }
}
