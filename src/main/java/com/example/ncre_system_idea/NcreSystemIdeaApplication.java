package com.example.ncre_system_idea;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.ncre_system_idea.DAO")
public class NcreSystemIdeaApplication {

    public static void main(String[] args) {
        SpringApplication.run(NcreSystemIdeaApplication.class, args);
    }

}
