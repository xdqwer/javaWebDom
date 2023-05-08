package com.dxm.web.service;

import com.dxm.web.dao.AddChildCommentDao;
import com.dxm.web.entity.Replace;

import java.sql.SQLException;

public class AddChildCommentService {

    public void insertChildComment(int atcid,int userid,String content,int parentid) throws SQLException {
        AddChildCommentDao addChildCommentDao = new AddChildCommentDao();
        Replace replace = new Replace(0,atcid,userid,content,parentid);
        addChildCommentDao.insertComment(replace);
    }
}
