package com.example.ncre_system_idea.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoAssignStatusDAO {
    boolean selectSignUpStatus();//是否开始报名
    boolean selectSignUpOverStatus();
    boolean selectAssignStudentStatus();//是否已经分配考生
    boolean selectAssignProctorStatus();//是否已经分配监考员
    boolean selectAssignOverStatus();//分配工作是否完成
    int updateSignUpStatus(@Param("signUpStatus") boolean signUpStatus);
    int updateSignUpOverStatus(@Param("signUpOverStatus") boolean signUpOverStatus);
    int updateAssignStudentStatus(@Param("assignStudentStatus") boolean assignStudentStatus);
    int updateAssignProctorStatus(@Param("assignProctorStatus") boolean assignProctorStatus);
    int updateAssignOverStatus(@Param("assignOverStatus") boolean assignOverStatus);

}
