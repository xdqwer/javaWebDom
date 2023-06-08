package com.dxm.web.service;

import com.dxm.web.dao.MassagesByUserIdDao;
import com.dxm.web.entity.Massages;
import com.dxm.web.utils.JwtUtils;
import com.dxm.web.utils.RedisUtil;
import redis.clients.jedis.Jedis;

import java.sql.SQLException;
import java.util.List;

public class MassagesByUserIdService {

    public List<Massages> UserIdMassages(String userid) throws SQLException {
        MassagesByUserIdDao massagesByUserIdDao = new MassagesByUserIdDao();
        Jedis jedis = RedisUtil.getJedis();
        String uuid = JwtUtils.getToken(userid);
        String s = jedis.get(uuid);
        System.out.println("用户id值："+s);
        List<Massages> massagesList=massagesByUserIdDao.UserIdMassages(Integer.parseInt(s));
        return massagesList;
    }
}
