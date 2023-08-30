package com.example.ncre_system_idea.dao;

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
    int registerOne(Proctor proctor);
    List<Proctor> selectIt(@Param("examID") String examID);//选择出没有被分配到某一场考试的某一个考场的监考员
    String selectOne(@Param("start") int start);//利用limit限制，一次获取一名监考员的id -- 查询结果为空会返回null，所以要使用string接受
    //监考员前台操作
    Proctor selectProctorByUsername(@Param("username") String username);//查找监考员的信息
    int updateProctor(Proctor proctor);//更新监考员的信息
    List<Proctor> selectExamMsgByUsername(@Param("username")String username);//监考员查询自己所负责的考场
}
