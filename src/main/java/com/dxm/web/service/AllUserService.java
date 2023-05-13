package com.dxm.web.service;

import com.dxm.web.dao.AllUserDao;
import com.dxm.web.entity.User;

import java.sql.SQLException;
import java.util.List;

public class AllUserService {
    public List<User> allUser(int pageNumber) throws SQLException {
        int pageNumber2=(pageNumber-1)*10;
        AllUserDao allUserDao = new AllUserDao();
        List<User> userList = allUserDao.selectAll(pageNumber2);
        return userList;
    }
}
