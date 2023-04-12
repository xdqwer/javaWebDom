package com.dxm.web.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Massages {
    private int atcid;
    private int userid;
    private String title;
    private String content;
    private String date;
    private int support;
    private int atcnumber;
    private String atcimg;

}
