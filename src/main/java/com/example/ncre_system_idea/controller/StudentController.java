package com.example.ncre_system_idea.controller;

import com.example.ncre_system_idea.service.StudentService;
import com.example.ncre_system_idea.pojo.Student;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    //管理员后台服务
    /**
     * 查询考生信息
     *分页查询，关键词查询，排序
     * @return
     */
    @RequestMapping("/allStudent")
    @ResponseBody
    public PageInfo<Student> selectALL(int pageNum, int pageSize, String sortProp, String sortOrder, boolean isSearch, String optionValue, String searchValue){

        return studentService.selectAll(pageNum,pageSize,sortProp,sortOrder,isSearch,optionValue,searchValue);
    }
    /**
     * 根据考生id，删除某一个考生的信息
     *
     * @return
     */
    @RequestMapping("/deleteOne")
    @ResponseBody
    public String deleteOne(int StudentID){

        return studentService.deleteOne(StudentID);
    }
    /**
     * 根据student中的id，更新某一条信息
     *
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public String update(@RequestBody Student student){

        return studentService.update(student);
    }
    /**
     * 向表中，添加一条考生信息
     *
     * @return
     */
    @RequestMapping("/addOne")
    @ResponseBody
    public String addOne(@RequestBody Student student){

        return studentService.addOne(student);
    }
    /**
     * 考生前台注册api接口
     *
     * @return
     */
    @RequestMapping("/registerOne")
    @ResponseBody
    public String registerOne(@RequestBody Student student){

        return studentService.registerOne(student);
    }
    /**
     * 查询某场考试某个考场的全部学生
     *
     * @return
     */
    @RequestMapping("/selectStudentOfExamRoom")
    @ResponseBody
    public PageInfo<Student> selectStudentOfExamRoom(int pageNum,int pageSize,String sortProp, String sortOrder,int examID , int examRoomID){
        return  studentService.selectStudentOfExamRoom(pageNum,pageSize,sortProp,sortOrder,examID,examRoomID);
    }
    //考生和监考员前台服务
    /**
     * 根据用户名查询考生的个人信息
     *
     * @return
     */
    @RequestMapping("/selectStudentByUsername")
    @ResponseBody
    public Student selectStudentByUsername(String username){
        return  studentService.selectStudentByUsername(username);
    }
    /**
     * 根据student中的id，更新个人信息
     *
     * @return
     */
    @RequestMapping("/updateStudent")
    @ResponseBody
    public String updateStudent(@RequestBody Student student){
        System.out.println(student);
        return  studentService.updateStudent(student);
    }
    /**
     * 考生报名某场考试的api接口
     *
     * @return
     */
    @RequestMapping("/signUpExam")
    @ResponseBody
    public String signUpExam(int examID,String username){
        return  studentService.signUpExam(examID,username);
    }
    /**
     * 根据用户名，获取该名考生是否已经报名了一场考试
     *
     * @return
     */
    @RequestMapping("/getIsSignUp")
    @ResponseBody
    public String getIsSignUp(String username){
        if(studentService.getIsSignUp(username)==null){
            return  "null";
        }else
            return studentService.getIsSignUp(username);

    }
    /**
     * 在报考结束，且考试分配结束后后，考生查询自己的考试信息。
     *
     * @return
     */
    @RequestMapping("/selectSingUpOverStudent")
    @ResponseBody
    public Student selectSingUpOverStudent(String username){
        return  studentService.selectSingUpOverStudent(username);
    }
}
