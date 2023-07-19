package com.example.ncre_system_idea.DAO;

import com.example.ncre_system_idea.pojo.ExamRoom;
import com.example.ncre_system_idea.pojo.Proctor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProctorDAO  {
 List<Proctor> selectAll();

 List<Proctor> selectAllById(@Param("id") String id);

 List<Proctor> selectAllByName(@Param("name") String name);

 int deleteOne(@Param("proctorID") int ProctorID);

    int update(Proctor proctor);
    int addOne(Proctor proctor);
    List<Proctor> selectIt(@Param("examID") String examID);//选择出没有被分配到某一场考试的某一个考场的监考员
}
