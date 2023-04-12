package com.dxm.web.service;

import com.dxm.web.dao.MassagesByIdDao;
import com.dxm.web.entity.Massages;

import java.sql.SQLException;
import java.util.List;

public class MassagersByIdService {

    public List<Massages> massagesType(int i) throws SQLException {
        MassagesByIdDao massagesTypeDao=new MassagesByIdDao();
        List<Massages> massagesList=massagesTypeDao.massagesTypeList(i);
        return massagesList;
    }

}
