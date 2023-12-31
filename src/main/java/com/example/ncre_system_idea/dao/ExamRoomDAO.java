package com.example.ncre_system_idea.dao;

import com.example.ncre_system_idea.pojo.ExamRoom;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ExamRoomDAO {
    List<ExamRoom> selectAll();
    List<ExamRoom> selectAllById(@Param("id") String id);

    List<ExamRoom> selectAllByName(@Param("name") String name);

    int deleteOne(@Param("examRoomID") int examRoomID);

    int update(ExamRoom examRoom);
    int addOne(ExamRoom examRoom);
    List<ExamRoom> selectIt(@Param("examID") String examID);//选出该场次考试尚未被使用的考场
    int selectCount(@Param("examRoomID") int examRoomID);//根据考场id获取对应的座位数
}
