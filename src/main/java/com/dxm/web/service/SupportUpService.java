package com.dxm.web.service;

import com.dxm.web.dao.SupportUpDao;

import java.sql.SQLException;

public class SupportUpService {

    public void updateSupportService(int support,int atcid) throws SQLException {
        SupportUpDao supportUpDao = new SupportUpDao();
        supportUpDao.updateSupport(support,atcid);
    }
}
