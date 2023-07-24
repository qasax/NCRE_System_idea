package com.example.ncre_system_idea.DAO;
import com.example.ncre_system_idea.pojo.Admin;
import com.example.ncre_system_idea.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginDAO  {
    User selectOne(@Param("loginName") String loginName);
}
