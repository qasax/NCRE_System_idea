package com.example.ncre_system_idea.pojo;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@EqualsAndHashCode
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AutoAssignStatus {
    private boolean signUpStatus=false;//标识报名按钮
    private boolean signUpOverStatus=false;
    private boolean assignStudentStatus=false;//标识分配学生按钮
    private boolean assignProctorStatus=false;//标识分配监考员按钮
    private boolean assignOverStatus=false;//标识分配工作是否已经完成


}
