package com.dxm.web.service;

import com.dxm.web.dao.DeleteUserByIdDao;

import java.sql.SQLException;

public class DeleteUserByIdService {
    public void DeleteUserById(int id) throws SQLException {
        DeleteUserByIdDao deleteUserByIdDao = new DeleteUserByIdDao();
        deleteUserByIdDao.deleteUserById(id);
    }
}
