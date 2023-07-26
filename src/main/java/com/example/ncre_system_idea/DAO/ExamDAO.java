package com.example.ncre_system_idea.DAO;

import com.example.ncre_system_idea.pojo.Exam;
import com.example.ncre_system_idea.pojo.Proctor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamDAO {
    List<Exam> selectAll();
    List<Exam> selectAllById(@Param("id") String id);

    List<Exam> selectAllByName(@Param("name") String name);
    int deleteOne(@Param("examID") int ExamID);

    int update(Exam exam);

    int addOne(Exam exam);
    int selectCount();//查询有多少场考试
    int selectExamID(@Param("start") int start);//查询对应考场id
    //前台操作
    List<Exam> selectAllExam();
}
