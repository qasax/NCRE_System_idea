package com.example.ncre_system_idea.pojo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@EqualsAndHashCode
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Proctor {
    @ExcelProperty("监考员ID")
    private int proctorID;
    @ExcelProperty("监考员姓名")
    private String teacherName;
    @ExcelProperty("年龄")
    private String age;
    @ExcelProperty("性别")
    private String gender;
    @ExcelProperty("手机号码")
    private String phoneNumber;
    @ExcelProperty("邮箱")
    private String email;
    @ExcelProperty("用户名")
    private String username;
    @ExcelIgnore
    private Exam exam;
    @ExcelIgnore
    private ExamRoom examRoom;
}
