package com.dxm.web.service;

import com.dxm.web.dao.PaginatedQueriesDao;
import com.dxm.web.entity.Massages;

import java.sql.SQLException;
import java.util.List;

public class PaginatedQueriesService {

    public List<Massages> MassagesList(int page) throws SQLException {
        int page1=(page-1)*5;
        PaginatedQueriesDao paginatedQueriesDao=new PaginatedQueriesDao();
        List<Massages> massagesList=paginatedQueriesDao.massagesList(page1);
        return massagesList;
    }
}
