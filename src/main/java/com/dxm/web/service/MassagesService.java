package com.dxm.web.service;

import com.dxm.web.dao.MassagesDao;
import com.dxm.web.entity.Massages;

import java.sql.SQLException;
import java.util.List;

public class MassagesService {

    public List<Massages> MassagesList() throws SQLException {
        MassagesDao massagesDao=new MassagesDao();
        List<Massages> massagesList=massagesDao.massagesList();
        return massagesList;
    }
}
