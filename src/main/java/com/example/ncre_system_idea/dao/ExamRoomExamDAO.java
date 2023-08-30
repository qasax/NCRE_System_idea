package com.example.ncre_system_idea.dao;

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
    int selectCount(@Param("examID") int examID);//查询考试的数量
    int selectExamRoomID(@Param("examID") int examID,@Param("start") int start);//根据考试id，依次查询该次考试教室的id
    int selectEreID(@Param("examID") int examID,@Param("start") int start);//根据考试id，依次获取该次考试对应的ereID
}
