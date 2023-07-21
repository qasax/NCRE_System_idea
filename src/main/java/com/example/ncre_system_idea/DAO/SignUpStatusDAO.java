package com.example.ncre_system_idea.DAO;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SignUpStatusDAO {
    boolean selectSignUpStatus();
    boolean selectAssignStudentStatus();
    boolean selectAssignProctorStatus();
    boolean selectSignUpOverStatus();
    int updateSignUpStatus(@Param("signUpStatus") boolean signUpStatus);
    int updateAssignStudentStatus(@Param("assignStudentStatus") boolean assignStudentStatus);
    int updateAssignProctorStatus(@Param("assignProctorStatus") boolean assignProctorStatus);
    int updateSignUpOverStatus(@Param("signUpOverStatus") boolean signUpOverStatus);

}
