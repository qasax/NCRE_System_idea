package com.example.ncre_system_idea.pojo;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@EqualsAndHashCode
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Proctor {
    private int proctorID;
    private String teacherName;
    private String age;
    private String gender;
    private String phoneNumber;
    private String email;
    private String username;
}
