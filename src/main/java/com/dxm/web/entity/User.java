package com.dxm.web.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class User {
    private int id;
    private String user_name;
    private String password;
    private String email;
    private String avatar;
}
