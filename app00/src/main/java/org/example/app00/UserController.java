package org.example.app00;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 标记当前是控制层
@RequestMapping("user") // 可以理解为WebServlet
public class UserController {

    @GetMapping("hello") //标记下面的方法是get请求
    // 访问方法: /user/hello
    public String hello() {
        return "hello world";
    }
}
