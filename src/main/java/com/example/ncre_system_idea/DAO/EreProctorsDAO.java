package com.example.ncre_system_idea.DAO;

import com.example.ncre_system_idea.pojo.EreProctors;
import com.example.ncre_system_idea.pojo.ExamRoomExam;
import com.example.ncre_system_idea.pojo.Proctor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EreProctorsDAO {
    List<EreProctors> selectAll();//collection映射采用子查询的方式，pagehelper只会影响主查询，总而让pagehelper正常运行（防止一对多，占用查询pagesize）
    List<EreProctors> selectAllById(@Param("id") String id);

    List<EreProctors> selectAllByName(@Param("name") String name);

    int deleteOne(@Param("ereID") int ereID);
    //管理员后台修改考场对应监考员操作
    int update(@Param("before1") int before1,@Param("before2") int before2,@Param("ereID")int ereID,@Param("after1") int after1,@Param("after2") int after2) ;
    int addOne(@Param("ereID") int ereID,@Param("proctorID") int proctorID);
    //监考员前台
}
