package com.example.ncre_system_idea.DAO;

import com.example.ncre_system_idea.pojo.Proctor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProctorDAO  {
 List<Proctor> selectAll();

 List<Proctor> selectAllById(@Param("id") String id);

 List<Proctor> selectAllByName(@Param("name") String name);

 int deleteOne(@Param("ProctorID") int ProctorID);

    int update(Proctor proctor);
}
