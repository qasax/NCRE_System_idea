package com.example.ncre_system_idea;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.ncre_system_idea.DAO.ProctorDAO;
import com.example.ncre_system_idea.pojo.Proctor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NcreSystemIdeaApplicationTests {
@Autowired
    ProctorDAO proctorDAO;
    @Test
    void contextLoads() {
        Page<Proctor> page =new Page<Proctor>(1,3);
        proctorDAO.selectPage(page,null);
        System.out.println(page);
    }

}
