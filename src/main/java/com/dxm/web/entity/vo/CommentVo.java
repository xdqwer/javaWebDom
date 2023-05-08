package com.dxm.web.entity.vo;

import com.dxm.web.entity.Comments;
import com.dxm.web.entity.Replace;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentVo {
    private int id;
    private String user_name;
    private String avatar;
    private int atcid;
    private int userid;
    private String content;
    private int parentid;
    private List<CommentVo> replace;

}
