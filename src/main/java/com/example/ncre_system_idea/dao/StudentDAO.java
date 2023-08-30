package com.example.ncre_system_idea.dao;

import com.example.ncre_system_idea.pojo.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDAO {
    List<Student> selectAll();
    List<Student> selectAllById(@Param("id") String id);

    List<Student> selectAllByName(@Param("name") String name);
    List<Student> selectStudentOfExamRoom(@Param("examID")int examID , @Param("examRoomID") int examRoomID);
    //查询在某场考试某个考场的全部学生
    int deleteOne(@Param("studentID") int StudentID);

    int update(Student student);
    int addOne(Student student);

    int updateAssignSeat(@Param("examID") int examID,@Param("examRoomID") int examRoomID,@Param("seatID") int seatID);//为学生分配对应的考场和座位
    int checkStudent();//检查报名考试的学生是否还有人没有对应的座位
    //考生前台操作
    int registerOne(Student student);//前台注册
    Student selectStudentByUsername(@Param("username")String username);//通过用户名查询对应考生信息
    int updateStudent(Student student);//更新个人资料
    //前台考生报名
    int signUpExam(@Param("examID") int examID,@Param("username")String username);//考生选择科目后，为考生表添加对应考试id
    String getIsSignUp(@Param("username")String username);//获取考生是否已经报名了一场考试
    Student selectSingUpOverStudent(@Param("username")String username);//分配工作结束后，考生获取自己的考试信息
}
