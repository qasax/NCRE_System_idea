package com.example.ncre_system_idea.Service;

import com.example.ncre_system_idea.DAO.LoginDAO;
import com.example.ncre_system_idea.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    public LoginDAO loginDAO;
    public Admin selectOne(String loginName){
        return loginDAO.selectOne(loginName);
    }
}
