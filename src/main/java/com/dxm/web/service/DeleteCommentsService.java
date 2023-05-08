package com.dxm.web.service;

import com.dxm.web.dao.DeleteCommentsDao;

import java.sql.SQLException;

public class DeleteCommentsService {

    public void deleteCommentsById(int commentId) throws SQLException {
        DeleteCommentsDao deleteCommentsDao = new DeleteCommentsDao();
        deleteCommentsDao.deleteCommentById(commentId);
    }
}
