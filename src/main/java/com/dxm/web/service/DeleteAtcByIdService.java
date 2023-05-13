package com.dxm.web.service;


import com.dxm.web.dao.DeleteAtcByIdDao;

import java.sql.SQLException;

public class DeleteAtcByIdService {

    public void deleteAtcByAtcId(int atcId) throws SQLException {
        DeleteAtcByIdDao deleteAtcByIdDao = new DeleteAtcByIdDao();
        deleteAtcByIdDao.DeleteAtcByAtcId(atcId);
    }

}
