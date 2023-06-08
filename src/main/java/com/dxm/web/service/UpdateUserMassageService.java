package com.dxm.web.service;

import com.dxm.web.dao.UpdateUserMassageDao;
import com.dxm.web.entity.User;
import java.sql.SQLException;

public class UpdateUserMassageService {
    public void updateUserMassage(User user) throws SQLException {
        UpdateUserMassageDao updateUserMassageDao = new UpdateUserMassageDao();
        updateUserMassageDao.updateUser(user);
    }
}
