package com.example.ncre_system_idea.Controller;

import com.example.ncre_system_idea.Service.ExamRoomService;
import com.example.ncre_system_idea.Service.StudentService;
import com.example.ncre_system_idea.pojo.ExamRoom;
import com.example.ncre_system_idea.pojo.Student;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    //管理员后台服务
    @RequestMapping("/allStudent")
    @ResponseBody
    public PageInfo<Student> selectALL(int pageNum, int pageSize, String sortProp, String sortOrder, boolean isSearch, String optionValue, String searchValue){

        return studentService.selectAll(pageNum,pageSize,sortProp,sortOrder,isSearch,optionValue,searchValue);
    }
    @RequestMapping("/deleteOne")
    @ResponseBody
    public String deleteOne(int StudentID){

        return studentService.deleteOne(StudentID);
    }
    @RequestMapping("/update")
    @ResponseBody
    public String update(@RequestBody Student student){

        return studentService.update(student);
    }
    @RequestMapping("/addOne")
    @ResponseBody
    public String addOne(@RequestBody Student student){

        return studentService.addOne(student);
    }
    @RequestMapping("/registerOne")
    @ResponseBody
    public String registerOne(@RequestBody Student student){

        return studentService.registerOne(student);
    }
    @RequestMapping("/selectStudentOfExamRoom")
    @ResponseBody
    public PageInfo<Student> selectStudentOfExamRoom(int pageNum,int pageSize,String sortProp, String sortOrder,int examID , int examRoomID){
        return  studentService.selectStudentOfExamRoom(pageNum,pageSize,sortProp,sortOrder,examID,examRoomID);
    }
    //考生和监考员前台服务
    @RequestMapping("/selectStudentByUsername")
    @ResponseBody
    public Student selectStudentByUsername(String username){
        return  studentService.selectStudentByUsername(username);
    }
    @RequestMapping("/updateStudent")
    @ResponseBody
    public String updateStudent(@RequestBody Student student){
        System.out.println(student);
        return  studentService.updateStudent(student);
    }
}
