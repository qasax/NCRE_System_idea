package com.example.ncre_system_idea.Controller;

import com.example.ncre_system_idea.DAO.AutoAssignStatusDAO;
import com.example.ncre_system_idea.Service.AutoAssignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/autoAssignController")
public class AutoAssignController {
    @Autowired
    AutoAssignService autoAssignService;
    @Autowired
    AutoAssignStatusDAO autoAssignStatusDAO;

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
        return autoAssignStatusDAO.selectSignUpStatus();
    }

    /**
     * 更改报名状态
     *
     * @return
     */
    @RequestMapping("/setSignUpStatus")
    @ResponseBody
    public String setSignUpStatus(boolean status) {
        autoAssignStatusDAO.updateSignUpStatus(status);
        if (autoAssignStatusDAO.selectSignUpStatus()) {
            return "已开启报名";
        } else {
            return "报名已关闭";
        }

    }
    /**
     * 获取当前报名结束状态
     * 当前是否报名已结束
     *
     * @return
     */
    @RequestMapping("/getSignUpOverStatus")
    @ResponseBody
    public boolean getSignUpOverStatus() {
        return autoAssignStatusDAO.selectSignUpOverStatus();
    }

    /**
     * 更改报名结束状态
     *
     * @return
     */
    @RequestMapping("/setSignUpOverStatus")
    @ResponseBody
    public String setSignUpOverStatus(boolean status) {
        autoAssignStatusDAO.updateSignUpOverStatus(status);
        if (autoAssignStatusDAO.selectSignUpOverStatus()) {
            return "报名已结束";
        } else {
            return "报名未结束";
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
        return autoAssignStatusDAO.selectAssignStudentStatus();
    }

    /**
     * 更新当前考生分配考场的状态
     *
     * @return
     */
    @RequestMapping("/setAssignStudentStatus")
    @ResponseBody
    public int setAssignStudentStatus(boolean status) {
        return autoAssignStatusDAO.updateAssignStudentStatus(status);
    }

    /**
     * 获取当前监考员分配考场的状态
     *
     * @return
     */
    @RequestMapping("/getAssignProctorStatus")
    @ResponseBody
    public boolean getAssignProctorStatus() {
        return autoAssignStatusDAO.selectAssignProctorStatus();
    }

    /**
     * 更新当前监考员分配考场的状态
     *
     * @return
     */
    @RequestMapping("/setAssignProctorStatus")
    @ResponseBody
    public int setAssignProctorStatus(boolean status) {
        return autoAssignStatusDAO.updateAssignProctorStatus(status);
    }

    /**
     * 获取当前分配工作是否结束的状态
     *
     * @return
     */
    @RequestMapping("/getAssignOverStatus")
    @ResponseBody
    public boolean getAssignOverStatus() {
        return autoAssignStatusDAO.selectAssignOverStatus();
    }

    /**
     * 更新当前分配工作是否结束的状态
     *
     * @return
     */
    @RequestMapping("/setAssignOverStatus")
    @ResponseBody
    public int setAssignOverStatus(boolean status) {
        return autoAssignStatusDAO.updateAssignOverStatus(status);
    }
}