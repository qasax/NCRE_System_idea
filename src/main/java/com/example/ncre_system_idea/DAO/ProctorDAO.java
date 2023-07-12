package com.example.ncre_system_idea.DAO;

import com.example.ncre_system_idea.pojo.Proctor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProctorDAO  {
 List<Proctor> selectAll( @Param("offset") int offset,@Param("pageSize") int pageSize);

 List<Proctor> selectAll1();
}
