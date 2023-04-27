package com.dxm.web.service;

import com.dxm.web.dao.MassagesByUserIdDao;
import com.dxm.web.entity.Massages;

import java.sql.SQLException;
import java.util.List;

public class MassagesByUserIdServie {

    public List<Massages> UserIdMassages(int userid) throws SQLException {
        MassagesByUserIdDao massagesByUserIdDao = new MassagesByUserIdDao();
        List<Massages> massagesList=massagesByUserIdDao.UserIdMassages(userid);
        return massagesList;
    }
}
