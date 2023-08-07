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
public class ExamRoom {
    @ExcelProperty("考场ID")
    private int examRoomID;
    @ExcelProperty("考场名称")
    private String examRoomName;
    @ExcelProperty("座位数")
    private  int seatCount;
}
