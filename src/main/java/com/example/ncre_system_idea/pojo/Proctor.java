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
    private int ProctorID;
    private String TeacherName;
    private String Age;
    private String Gender;
    private String PhoneNumber;
    private String Email;
    private String Username;
}
