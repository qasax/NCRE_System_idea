package com.example.ncre_system_idea.service;

import com.example.ncre_system_idea.dao.LoginDAO;
import com.example.ncre_system_idea.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    public LoginDAO loginDAO;
    public User selectOne(String loginName){
        return loginDAO.selectOne(loginName);
    }
}
