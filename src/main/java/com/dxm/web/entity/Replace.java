package com.dxm.web.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Replace {
    private int id;
    private int atcid;
    private int userid;
    private String content;
    private int parentid;
}
