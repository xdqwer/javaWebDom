package com.dxm.web.service;

import com.dxm.web.dao.CommentsDao;
import com.dxm.web.dao.UserByIdDao;
import com.dxm.web.dao.UserDao;
import com.dxm.web.entity.Comments;
import com.dxm.web.entity.Replace;
import com.dxm.web.entity.User;
import com.dxm.web.entity.vo.CommentVo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentsService {

    public  List<CommentVo> commentList(int atcid) throws SQLException {
        CommentsDao commentsDao = new CommentsDao();
        List<Comments> comments = commentsDao.commentsList(atcid);
        List<CommentVo> commentVos = new ArrayList<>();
        UserByIdDao userByIdDao = new UserByIdDao();
        for (Comments comm : comments){
            User user = userByIdDao.reqUserById(comm.getUserid()).get(0);
            List<CommentVo> commentVos1=new ArrayList<>();
            for (Replace rep:comm.getReplace()){
                User repUser = userByIdDao.reqUserById(rep.getUserid()).get(0);
                CommentVo commentVoRep = new CommentVo(
                         rep.getId()
                        ,repUser.getUser_name()
                        ,repUser.getAvatar()
                        ,rep.getAtcid()
                        ,rep.getUserid()
                        ,rep.getContent()
                        ,rep.getParentid()
                        ,null);

                commentVos1.add(commentVoRep);
            }
            CommentVo commentVo = new CommentVo(
                     comm.getId()
                    ,user.getUser_name()
                    ,user.getAvatar()
                    ,comm.getAtcid()
                    ,comm.getUserid()
                    ,comm.getContent()
                    ,comm.getParentid()
                    ,commentVos1);
            commentVos.add(commentVo);
        }

        return commentVos;
    }
}
