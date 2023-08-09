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
    /**
     * 根据用户名查询管理员的个人信息
     *
     * @return
     */
    @RequestMapping("/selectAdminByUsername")
    @ResponseBody
    public Admin selectAdminByUsername(String username){
        return adminService.selectAdminByUsername(username);
    }
    /**
     * 根据id，更新管理员的个人信息
     *
     * @return
     */
    @RequestMapping("/updateAdmin")
    @ResponseBody
    public String updateStudent(@RequestBody Admin admin){
        return adminService.updateStudent(admin);
    }
}
