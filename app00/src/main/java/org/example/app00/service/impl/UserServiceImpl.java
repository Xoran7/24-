package org.example.app00.service.impl;

import org.example.app00.dto.UserDTO;
import org.example.app00.entity.User;
import org.example.app00.mapper.UserMapper;
import org.example.app00.service.UserService;
import org.example.app00.until.JWTUtil;
import org.example.app00.until.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserMapper userMapper;
    @Autowired
    private final RedisTemplate redisTemplate;

    public UserServiceImpl(UserMapper userMapper, @Qualifier("redisTemplate") RedisTemplate redisTemplate) {
        this.userMapper = userMapper;
        this.redisTemplate = redisTemplate;
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

    @Override
    public String login(UserDTO userDTO) {
        // 判断账号是否输入正确
        User user = userMapper.findUserByPhone(userDTO.getPhone());
        if (user == null) {
            throw new RuntimeException("账号或密码错误");
        }
        // 比对密码， 将用户输入的密码进行加密，比对加密后的
        String password = StringUtil.md5Password(userDTO.getPassword(), user.getSalt(), 10);
        if (!password.equals(user.getPassword())) {
            throw new RuntimeException("账号或密码错误");
        }
        // 设置登录Token
        String token = JWTUtil.sign(userDTO.getPhone(), user.getPassword());
        redisTemplate.opsForValue().set("TOKEN_USER" + token, user, 12, TimeUnit.HOURS);

        return token;
    }
}
