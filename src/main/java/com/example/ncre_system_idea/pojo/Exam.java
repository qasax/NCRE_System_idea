package com.example.ncre_system_idea.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.*;
import org.springframework.stereotype.Component;

@Component
@EqualsAndHashCode
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Exam {
    @ExcelProperty("考试ID")
    private int examID;
    @ExcelProperty("考试科目")
    private String examName;
    @ExcelProperty("考试日期")
    private String examDate;
    @ExcelProperty("考试时间段")
    private String examTime;
    @ExcelProperty("考点")
    private String examLocation;
}
