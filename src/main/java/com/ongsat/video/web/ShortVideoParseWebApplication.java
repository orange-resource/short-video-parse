package com.ongsat.video.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@ComponentScan("com.ongsat.video")
@MapperScan("com.ongsat.video.web.mapper")
public class ShortVideoParseWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShortVideoParseWebApplication.class, args);
    }

}
