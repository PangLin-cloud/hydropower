package com.panglin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@MapperScan
@SpringBootApplication
public class HydropowerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HydropowerApplication.class, args);
    }

}
