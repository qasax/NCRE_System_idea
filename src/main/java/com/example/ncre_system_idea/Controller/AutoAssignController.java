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
@RequestMapping("/autoAssignController")
public class AutoAssignController {
    @Autowired
    AutoAssignService autoAssignService;
    @Autowired
    SignUpStatusDAO signUpStatusDAO;

    /**
     * 为考生自动分配考场
     *
     * @return
     */
    @RequestMapping("/autoAssignStudent")
    @ResponseBody
    public String autoAssignStudent() {
        return autoAssignService.AutoAssignStudent();

    }

    /**
     * 为监考员自动分配监考考场
     * 要在考生分配考场完毕后运行
     *
     * @return
     */
    @RequestMapping("/autoAssignProctor")
    @ResponseBody
    public List<String> AutoAssignProctor() {
        return autoAssignService.AutoAssignProctor();
    }

    /**
     * 获取当前报名状态
     * 当前是否可以报名
     *
     * @return
     */
    @RequestMapping("/getSignUpStatus")
    @ResponseBody
    public boolean getSignUpStatus() {
        return signUpStatusDAO.selectSignUpStatus();
    }

    /**
     * 更改报名状态
     *
     * @return
     */
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

    /**
     * 获取当前考生分配考场的状态
     *
     * @return
     */
    @RequestMapping("/getAssignStudentStatus")
    @ResponseBody
    public boolean getAssignStudentStatus() {
        return signUpStatusDAO.selectAssignStudentStatus();
    }

    /**
     * 更新当前考生分配考场的状态
     *
     * @return
     */
    @RequestMapping("/setAssignStudentStatus")
    @ResponseBody
    public int setAssignStudentStatus(boolean status) {
        return signUpStatusDAO.updateAssignStudentStatus(status);
    }

    /**
     * 获取当前监考员分配考场的状态
     *
     * @return
     */
    @RequestMapping("/getAssignProctorStatus")
    @ResponseBody
    public boolean getAssignProctorStatus() {
        return signUpStatusDAO.selectAssignProctorStatus();
    }

    /**
     * 更新当前监考员分配考场的状态
     *
     * @return
     */
    @RequestMapping("/setAssignProctorStatus")
    @ResponseBody
    public int setAssignProctorStatus(boolean status) {
        return signUpStatusDAO.updateAssignProctorStatus(status);
    }

    /**
     * 获取当前分配工作是否结束的状态
     *
     * @return
     */
    @RequestMapping("/getSignUpOverStatus")
    @ResponseBody
    public boolean getSignUpOverStatus() {
        return signUpStatusDAO.selectSignUpOverStatus();
    }

    /**
     * 更新当前分配工作是否结束的状态
     *
     * @return
     */
    @RequestMapping("/setSignUpOverStatus")
    @ResponseBody
    public int setSignUpOverStatus(boolean status) {
        return signUpStatusDAO.updateSignUpOverStatus(status);
    }
}