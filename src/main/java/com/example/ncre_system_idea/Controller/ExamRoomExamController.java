package com.example.ncre_system_idea.Controller;

import com.example.ncre_system_idea.Service.ExamRoomExamService;
import com.example.ncre_system_idea.pojo.ExamRoomExam;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin(origins = {"http://localhost:8088","http://localhost:8089"}, allowCredentials = "true")
@RequestMapping("/examRoomExam")
public class ExamRoomExamController {
    @Autowired
    ExamRoomExamService examRoomExamService;
    @RequestMapping("/aLLExamroomExam")
    @ResponseBody
    public PageInfo<ExamRoomExam> selectALL(int pageNum, int pageSize, String sortProp, String sortOrder, boolean isSearch, String optionValue, String searchValue){

        return examRoomExamService.selectAll(pageNum,pageSize,sortProp,sortOrder,isSearch,optionValue,searchValue);
    }
    @RequestMapping("/deleteOne")
    @ResponseBody
    public String deleteOne(int ereID){

        return examRoomExamService.deleteOne(ereID);
    }
    @RequestMapping("/update")
    @ResponseBody
    public String update(@RequestBody ExamRoomExam examRoomExam){

        return examRoomExamService.update(examRoomExam);
    }
    @RequestMapping("/addOne")
    @ResponseBody
    public String addOne(@RequestBody ExamRoomExam examRoomExam){

        return examRoomExamService.addOne(examRoomExam);
    }
}
