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

    int deleteOne(@Param("studentID") int StudentID);

    int update(Student student);
    int addOne(Student student);
}
