package com.example.ncre_system_idea.pojo;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@EqualsAndHashCode
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ExamRoom {
    private int ExamRoomID;
    private String ExamRoomName;
    private  int SeatCount;
}
