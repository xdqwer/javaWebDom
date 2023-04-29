package com.dxm.web.service;

import com.dxm.web.dao.SumPageDao;

import java.sql.SQLException;

public class SumPageService {

    public int sumPage() throws SQLException {
        SumPageDao sumPageDao=new SumPageDao();
        int number=sumPageDao.massagesList();
        return number;
    }
}
