package org.example.app00.controller;

import org.example.app00.dto.UserDTO;
import org.example.app00.service.UserService;
import org.example.app00.until.StringUtil;
import org.example.app00.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController // 标记当前是控制层
@RequestMapping("user") // 可以理解为WebServlet
public class UserController {

    @GetMapping("hello") //标记下面的方法是get请求
    // 访问方法: /user/hello
    public String hello() {
        return "hello world";
    }
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private UserService userService;

    /**
     * 发送验证码
     * @param phone
     * @return
     */
    @GetMapping("send")
    public ResponseEntity<Result> send(String phone) {
        // 验证码:生成一个四位数的随机字符串
        String code = StringUtil.getRandomNumber(4);
        System.out.println(code);
        // 生成一个redis里面的key : uuid + phone
        String key = StringUtil.uuid() + phone;
        System.out.println(key);
        // 将生成的验证码存入redis
        redisTemplate.opsForValue().set(key, code, 5, TimeUnit.MINUTES);

        return ResponseEntity.status(200).header("SMS_SEND", key).body(Result.success("发送成功"));
    }

    /**
     * 注册
     * @param userDTO
     * @param key
     * @return
     */
    @PostMapping("reg")
    public ResponseEntity<Result> userReg(@RequestBody UserDTO userDTO, @RequestHeader("SMS_SEND")String key) { // @RequestBody才能接收到json数据
        // 判断验证码是否正确
        // 验证码从redis中取
        String code = (String) redisTemplate.opsForValue().get(key);
        if (code == null) {
            return ResponseEntity.status(200).body(Result.fail("验证码过期"));
        }
        if (!code.equals(userDTO.getCode())) {
            return ResponseEntity.status(200).body(Result.fail("验证码错误"));
        }

        boolean success = userService.userReg(userDTO);

        return success ? ResponseEntity.status(200).body(Result.fail("注册成功")) : ResponseEntity.status(200).body(Result.fail("注册失败"));
    }

    /**
     * 登录
     * @param userDTO
     * @return
     */
    @PostMapping("login")
    public ResponseEntity<Result> login(@RequestBody UserDTO userDTO) {
//        String code = (String) redisTemplate.opsForValue().get(userDTO.getCode());
        try {
            String token = userService.login(userDTO);
            return ResponseEntity.status(200).header("token", token).body(Result.success("登录成功"));
        } catch (RuntimeException e) {
            return ResponseEntity.status(200).body(Result.fail("账号或密码错误"));
        }

    }
}
