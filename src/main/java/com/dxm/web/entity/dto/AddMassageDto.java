package com.dxm.web.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddMassageDto {
    private int userid;
    private String title;
    private String content;
    private String atcImg;
}
