package org.example.app00.dto;

import com.sun.tracing.dtrace.ArgsAttributes;
import lombok.Data; // lombok 小辣椒
import lombok.ToString;

//@ToString
//@ArgsAttributes() 有参构造
@Data // 自动添加getter和setter
public class UserDTO {
    private Long uid;
    private String userName;
    private Long did;
    private String phone;
    private String password;
    private String salt;
    private String state;
    private String code;
}
