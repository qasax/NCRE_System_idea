package com.example.ncre_system_idea.DAO;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SignUpStatusDAO {
    boolean selectSignUpStatus();//是否开始报名
    boolean selectAssignStudentStatus();//是否已经分配考生
    boolean selectAssignProctorStatus();//是否已经分配监考员
    boolean selectSignUpOverStatus();//分配工作是否完成
    int updateSignUpStatus(@Param("signUpStatus") boolean signUpStatus);
    int updateAssignStudentStatus(@Param("assignStudentStatus") boolean assignStudentStatus);
    int updateAssignProctorStatus(@Param("assignProctorStatus") boolean assignProctorStatus);
    int updateSignUpOverStatus(@Param("signUpOverStatus") boolean signUpOverStatus);

}
