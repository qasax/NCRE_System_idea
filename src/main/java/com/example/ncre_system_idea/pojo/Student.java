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
   private int studentID;
   private String name;
    private String gender;
    private int age;
    private String phoneNumber;
    private String email;
    private int examID;
    private int examRoomID;
    private int seatID;
    private String username;
}
//学生实体