package com.example.ncre_system_idea.pojo;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@EqualsAndHashCode
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Student {
   private int StudentID;
   private String Name;
    private String Gender;
    private int Age ;
    private String PhoneNumber;
    private String Email;
    private int ExamID;
    private int ExamRoomID;
    private int SeatID;
    private String Username;
}
