package com.example.ncre_system_idea.pojo;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@EqualsAndHashCode
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {
    private int userID;
    private String username;
    private String password;
    private String userType;
    private String aesKey;
}
