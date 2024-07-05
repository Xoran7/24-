package org.example.app00.service.impl;

import org.example.app00.dto.UserDTO;
import org.example.app00.entity.User;
import org.example.app00.mapper.UserMapper;
import org.example.app00.service.UserService;
import org.example.app00.until.StringUtil;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public boolean userReg(UserDTO userDTO) {
        // 检查手机号是否被注册
        // 首先取出用户输入的手机号
        String phone = userDTO.getPhone();
        User user = userMapper.findUserByPhone(phone);
        // 根据手机号查找的对象是否为空， 来判断手机号是否被注册
        if (user != null) {
            throw new RuntimeException("手机号已被注册");
        }

        // 获取密码
        String password = userDTO.getPassword();
        // 密码加密
        // 生成一个盐值
        String salt = StringUtil.getRandomNumber(4);
        userDTO.setSalt(salt);
        String newPassword = StringUtil.md5Password(password, salt, 10); // 生成10次
        // 将加密后的密码赋值给UserDTO
        userDTO.setPassword(newPassword);
        userDTO.setState("0");
        int result = userMapper.insertUser(userDTO);

        return result == 1;
    }
}
