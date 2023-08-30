package com.example.ncre_system_idea.dao;

import com.example.ncre_system_idea.pojo.Proctor;
import com.example.ncre_system_idea.pojo.Student;
import com.example.ncre_system_idea.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDAO {
    List<User> selectAll();
    List<User> selectAllById(@Param("id") String id);

    List<User> selectAllByName(@Param("name") String name);

    int deleteOne(@Param("userID") int StudentID);

    int update(User user);
    int addOne(User user);

    List<Proctor> findProctors();//查询用户表中没有对应信息的监考员
    List<Student> findStudents();//查找用户表中没有对应信息的考生
    //前台操作
    String selectUsername(@Param("username") String username);//在注册时，查询是否有重名的用户名，如果没有则允许注册
    //修改密码
    int changPassword(@Param("password")String password,@Param("aesKey")String aesKey,@Param("username")String username);//根据username查询用户，从而修改密码
}
