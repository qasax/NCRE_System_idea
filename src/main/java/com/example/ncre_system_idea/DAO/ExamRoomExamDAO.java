package com.example.ncre_system_idea.DAO;

import com.example.ncre_system_idea.pojo.ExamRoom;
import com.example.ncre_system_idea.pojo.ExamRoomExam;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamRoomExamDAO {
    List<ExamRoomExam> selectAll();
    List<ExamRoomExam> selectAllById(@Param("id") String id);

    List<ExamRoomExam> selectAllByName(@Param("name") String name);

    int deleteOne(@Param("ereID") int ereID);

    int update(ExamRoomExam examRoom);
    int addOne(ExamRoomExam examRoom);
    int selectCount(@Param("examID") int examID);
    int selectExamRoomID(@Param("examID") int examID,@Param("start") int start);
    int selectEreID(@Param("examID") int examID,@Param("start") int start);
}
