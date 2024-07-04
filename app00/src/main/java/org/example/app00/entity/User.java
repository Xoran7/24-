package org.example.app00.entity;

import lombok.Data;

@Data
public class User {
    private Long uid;
    private String userName;
    private Long did;
    private String phone;
    private String password;
    private String salt;
    private String state;
}
