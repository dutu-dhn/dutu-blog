package com.dutu.dutublog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.dutu.dutublog.mapper")//扫描mapper,自动加入容器
@SpringBootApplication
public class DutuBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(DutuBlogApplication.class, args);
    }

}
