package com.dxm.web.entity;

import lombok.Data;

@Data
public class Replace {
    private int id;
    private int atcid;
    private int userid;
    private String content;
    private int parentid;
}
