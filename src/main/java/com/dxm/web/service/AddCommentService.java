package com.dxm.web.service;

import com.dxm.web.dao.AddCommentDao;
import com.dxm.web.entity.Replace;

import java.sql.SQLException;

public class AddCommentService {

    public void insertComment(int atcid,int userid,String content) throws SQLException {
        AddCommentDao addCommentDao = new AddCommentDao();
        Replace replace = new Replace();
        replace.setAtcid(atcid);
        replace.setUserid(userid);
        replace.setContent(content);
        addCommentDao.insertReplace(replace);
    }
}
