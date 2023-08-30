package com.example.ncre_system_idea.dao;
import com.example.ncre_system_idea.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginDAO  {
    User selectOne(@Param("loginName") String loginName);
}
