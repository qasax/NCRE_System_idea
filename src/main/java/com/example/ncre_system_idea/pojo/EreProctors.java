package com.example.ncre_system_idea.pojo;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@EqualsAndHashCode
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EreProctors {
    private int ereID;
    private int examID;
    private String examName;
    private String examDate;
    private String examTime;
    private String examLocation;
    private int examRoomID;
    private String examRoomName;
    private  int seatCount;
    List<Proctor> proctors;
}
