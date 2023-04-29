package com.dxm.web.service;

import com.dxm.web.dao.HotDao;
import com.dxm.web.dao.MassagesDao;
import com.dxm.web.entity.Massages;

import java.sql.SQLException;
import java.util.List;

public class HotService {

    public List<Massages> MassagesList() throws SQLException {
        HotDao hotDao=new HotDao();
        List<Massages> massagesList=hotDao.massagesList();
        return massagesList;
    }
}
