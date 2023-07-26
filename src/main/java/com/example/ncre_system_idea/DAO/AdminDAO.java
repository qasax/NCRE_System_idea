package com.example.ncre_system_idea.DAO;

import com.example.ncre_system_idea.pojo.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDAO {
    Admin  selectAdminByusername(@Param("username") String username);//通过用户名查询用户信息
    int updateStudent(Admin admin);//更新个人资料
}
