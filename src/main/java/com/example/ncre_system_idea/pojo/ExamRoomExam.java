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
public class ExamRoomExam {
    @ExcelProperty("序号")
    private int ereID;
    @ExcelProperty("考试ID")
    private int examID;
    @ExcelProperty("考试科目")
    private String examName;
    @ExcelProperty("考试日期")
    private String examDate;
    @ExcelProperty("考试事件段")
    private String examTime;
    @ExcelProperty("考试地点")
    private String examLocation;
    @ExcelProperty("考场ID")
    private int examRoomID;
    @ExcelProperty("考场名称")
    private String examRoomName;
    @ExcelProperty("座位数")
    private  int seatCount;
}
