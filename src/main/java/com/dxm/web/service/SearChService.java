package com.dxm.web.service;

import com.dxm.web.dao.SearchDao;
import com.dxm.web.dao.SumPageDao;
import com.dxm.web.entity.Massages;

import java.sql.SQLException;
import java.util.List;

public class SearChService {
    public List<Massages> SearChList(String keyWord) throws SQLException {
        SearchDao searchDao=new SearchDao();
        List<Massages> searChList=searchDao.massagesList(keyWord);
        return searChList;
    }
}
