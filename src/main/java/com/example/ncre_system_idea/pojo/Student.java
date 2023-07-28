package com.example.ncre_system_idea.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.example.ncre_system_idea.DAO.ExamDAO;
import lombok.*;
import org.springframework.stereotype.Component;

@Component
@EqualsAndHashCode
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Student {
 @ExcelProperty("考生ID")
   private int studentID;
 @ExcelProperty("考生姓名")
   private String name;
 @ExcelProperty("性别")
    private String gender;
 @ExcelProperty("年龄")
    private int age;
 @ExcelProperty("手机号码")
    private String phoneNumber;
 @ExcelProperty("邮箱")
    private String email;
 @ExcelProperty("考试ID")
    private int examID;
    private int examRoomID;
    private int seatID;
    private String username;
    private Exam exam;
    private ExamRoom examRoom;
}
//学生实体