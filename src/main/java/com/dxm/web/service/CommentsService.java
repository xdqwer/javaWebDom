package com.dxm.web.service;

import com.dxm.web.dao.CommentsDao;
import com.dxm.web.entity.Comments;

import java.sql.SQLException;
import java.util.List;

public class CommentsService {

    public List<Comments> commentList(int atcid) throws SQLException {
        CommentsDao commentsDao = new CommentsDao();
        List<Comments> comments = commentsDao.commentsList(atcid);
        return comments;
    }
}
