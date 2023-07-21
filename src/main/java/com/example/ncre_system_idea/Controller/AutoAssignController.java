package com.example.ncre_system_idea.Controller;

import com.example.ncre_system_idea.DAO.SignUpStatusDAO;
import com.example.ncre_system_idea.Service.AutoAssignService;
import com.example.ncre_system_idea.pojo.SignUpStatus;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin(origins = "http://localhost:8088", allowCredentials = "true")
@RequestMapping("/autoAssignController")
public class AutoAssignController {
    @Autowired
    AutoAssignService autoAssignService;
    @Autowired
    SignUpStatusDAO signUpStatusDAO;

    @RequestMapping("/autoAssignStudent")
    @ResponseBody
    public String autoAssignStudent() {
        return autoAssignService.AutoAssignStudent();

    }

    @RequestMapping("/autoAssignProctor")
    @ResponseBody
    public List<String> AutoAssignProctor() {
        return autoAssignService.AutoAssignProctor();
    }

    @RequestMapping("/getSignUpStatus")
    @ResponseBody
    public boolean getSignUpStatus() {
        return signUpStatusDAO.selectSignUpStatus();
    }

    @RequestMapping("/setSignUpStatus")
    @ResponseBody
    public String setSignUpStatus(boolean status) {
        signUpStatusDAO.updateSignUpStatus(status);
        if (signUpStatusDAO.selectSignUpStatus()) {
            return "已开启报名";
        } else {
            return "报名已关闭";
        }

    }

    @RequestMapping("/getAssignStudentStatus")
    @ResponseBody
    public boolean getAssignStudentStatus() {
        return signUpStatusDAO.selectAssignStudentStatus();
    }

    @RequestMapping("/setAssignStudentStatus")
    @ResponseBody
    public int setAssignStudentStatus(boolean status) {
        return signUpStatusDAO.updateAssignStudentStatus(status);
    }

    @RequestMapping("/getAssignProctorStatus")
    @ResponseBody
    public boolean getAssignProctorStatus() {
        return signUpStatusDAO.selectAssignProctorStatus();
    }

    @RequestMapping("/setAssignProctorStatus")
    @ResponseBody
    public int setAssignProctorStatus(boolean status) {
        return signUpStatusDAO.updateAssignProctorStatus(status);
    }

    @RequestMapping("/getSignUpOverStatus")
    @ResponseBody
    public boolean getSignUpOverStatus() {
        return signUpStatusDAO.selectSignUpOverStatus();
    }

    @RequestMapping("/setSignUpOverStatus")
    @ResponseBody
    public int setSignUpOverStatus(boolean status) {
        return signUpStatusDAO.updateSignUpOverStatus(status);
    }
}