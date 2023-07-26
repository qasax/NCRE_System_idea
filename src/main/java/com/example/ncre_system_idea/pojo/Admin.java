package com.example.ncre_system_idea.pojo;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@EqualsAndHashCode
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Admin {
    int adminID;
    String name;
    String gender;
    String age;
    String phoneNumber;
    String email;
    String username;

}
