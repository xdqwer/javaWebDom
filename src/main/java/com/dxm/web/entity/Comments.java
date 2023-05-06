package com.dxm.web.entity;

import lombok.Data;

import java.util.List;

@Data
public class Comments {
    private int id;
    private int atcid;
    private int userid;
    private String content;
    private int parentid;
    private List<Replace> replace;
}
