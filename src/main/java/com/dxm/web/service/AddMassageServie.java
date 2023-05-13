package com.dxm.web.service;

import com.dxm.web.dao.AddMassageDao;
import com.dxm.web.entity.Massages;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddMassageServie {

    public void insertMassage(int userid,String title,String content,String atcImg) throws SQLException {
        AddMassageDao addMassageDao = new AddMassageDao();
        String dateTime=getDateTime();
        Massages massages = new Massages(0,userid,title,content,dateTime,0,1,atcImg);
        addMassageDao.insertMassage(massages);
    }

    public String  getDateTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String dateTime=df.format(new Date());
        return dateTime;
    }
}
