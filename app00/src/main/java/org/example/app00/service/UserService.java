package org.example.app00.service;

import org.example.app00.dto.UserDTO;

public interface UserService {
    boolean userReg(UserDTO userDTO);

    String login(UserDTO userDTO); // 返回Token
}
