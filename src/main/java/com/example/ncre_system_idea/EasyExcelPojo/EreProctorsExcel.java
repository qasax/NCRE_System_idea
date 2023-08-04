package com.example.ncre_system_idea.EasyExcelPojo;

import com.example.ncre_system_idea.pojo.Proctor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;
@Data
@Component
public class EreProctorsExcel {
    private int ereID;
    private int examID;
    private String examName;
    private String examDate;
    private String examTime;
    private String examLocation;
    private int examRoomID;
    private String examRoomName;
    private  int seatCount;
    Proctor proctor1;
    Proctor proctor2;
}
