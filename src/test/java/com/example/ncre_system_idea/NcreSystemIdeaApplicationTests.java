package com.example.ncre_system_idea;

import com.example.ncre_system_idea.DAO.ExamDAO;
import com.example.ncre_system_idea.DAO.ProctorDAO;
import com.example.ncre_system_idea.pojo.Proctor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NcreSystemIdeaApplicationTests {
@Autowired
    ProctorDAO proctorDAO;
    @Autowired
    ExamDAO examDAO;
    @Test
    void contextLoads() {

    examDAO.selectExamRoomExam();
    }

}
