package com.dxm.web.service;

import com.dxm.web.dao.SupportUpDao;

import java.sql.SQLException;

public class SupportUpService {

    public void updateSupportService(int atcid,int support) throws SQLException {
        SupportUpDao supportUpDao = new SupportUpDao();
        supportUpDao.updateSupport(atcid,support);
    }
}
