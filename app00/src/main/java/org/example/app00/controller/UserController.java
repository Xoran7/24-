package org.example.app00.controller;

import org.example.app00.until.StringUtil;
import org.example.app00.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
