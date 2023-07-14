package com.example.ncre_system_idea.DAO;

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

    int deleteOne(@Param("UserID") int StudentID);

    int update(User user);
    int addOne(User user);
}
