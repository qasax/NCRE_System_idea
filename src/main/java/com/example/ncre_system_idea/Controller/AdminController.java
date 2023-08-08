package com.example.ncre_system_idea.Controller;

import com.example.ncre_system_idea.Service.AdminService;
import com.example.ncre_system_idea.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;
    @RequestMapping("/selectAdminByUsername")
    @ResponseBody
    public Admin selectAdminByUsername(String username){
        return adminService.selectAdminByUsername(username);
    }
    @RequestMapping("/updateAdmin")
    @ResponseBody
    public String updateStudent(@RequestBody Admin admin){
        return adminService.updateStudent(admin);
    }
}
