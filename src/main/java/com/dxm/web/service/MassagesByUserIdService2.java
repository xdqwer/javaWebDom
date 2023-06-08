package com.dxm.web.service;

import com.dxm.web.dao.MassagesByUserIdDao;
import com.dxm.web.entity.Massages;
import com.dxm.web.utils.JwtUtils;
import com.dxm.web.utils.RedisUtil;
import redis.clients.jedis.Jedis;

import java.sql.SQLException;
import java.util.List;

public class MassagesByUserIdService2 {

    public List<Massages> UserIdMassages(int userid) throws SQLException {
        MassagesByUserIdDao massagesByUserIdDao = new MassagesByUserIdDao();

        List<Massages> massagesList=massagesByUserIdDao.UserIdMassages(userid);
        return massagesList;
    }
}
