package com.example.ncre_system_idea.service;

import com.example.ncre_system_idea.dao.AdminDAO;
import com.example.ncre_system_idea.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    AdminDAO adminDAO;
    public Admin selectAdminByUsername(String username){
       return adminDAO.selectAdminByUsername(username);
    }
    public String updateStudent(Admin admin){
        int line= adminDAO.updateStudent(admin);
        if(line!=0){
            return "success";
        }else
        {
            return "wrong";
        }
    }
}
