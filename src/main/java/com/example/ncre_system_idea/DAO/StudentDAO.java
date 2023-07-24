package com.example.ncre_system_idea.DAO;

import com.example.ncre_system_idea.pojo.ExamRoom;
import com.example.ncre_system_idea.pojo.Proctor;
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
    int registerOne(Student student);
    int updateAssignSeat(@Param("examID") int examID,@Param("examRoomID") int examRoomID,@Param("seatID") int seatID);//为学生分配对应的考场和座位
    int checkStudent();//检查报名考试的学生是否还有人没有对应的座位
}
