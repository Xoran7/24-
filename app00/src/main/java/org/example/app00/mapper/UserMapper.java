package org.example.app00.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.app00.dto.UserDTO;
import org.example.app00.entity.User;
import org.example.app00.service.UserService;

@Mapper
public interface UserMapper {
    User findUserByPhone(String phone);

    int insertUser(UserDTO userDTO);
}
