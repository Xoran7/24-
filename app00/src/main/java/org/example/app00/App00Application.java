package org.example.app00;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

// 排除掉启动时不依赖数据源
@SpringBootApplication
public class App00Application {

    public static void main(String[] args) {
        SpringApplication.run(App00Application.class, args);
    }

}
