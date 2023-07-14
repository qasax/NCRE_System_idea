package com.example.ncre_system_idea.pojo;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@EqualsAndHashCode
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Exam {
    private int ExamID;
    private String ExamName;
    private String ExamDate;
    private String ExamTime;
    private String ExamLocation;
}
