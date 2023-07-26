package com.example.ncre_system_idea.Controller;

import com.example.ncre_system_idea.Service.ExamService;
import com.example.ncre_system_idea.Service.ProctorService;
import com.example.ncre_system_idea.pojo.Exam;
import com.example.ncre_system_idea.pojo.Proctor;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/exam")
public class ExamController {
    @Autowired
    ExamService examService;
    @RequestMapping("/aLLExam")
    @ResponseBody
    public PageInfo<Exam> selectALL(int pageNum, int pageSize, String sortProp, String sortOrder, boolean isSearch, String optionValue, String searchValue){

        return examService.selectAll(pageNum,pageSize,sortProp,sortOrder,isSearch,optionValue,searchValue);
    }
    @RequestMapping("/deleteOne")
    @ResponseBody
    public String deleteOne(int examID){

        return examService.deleteOne(examID);
    }
    @RequestMapping("/update")
    @ResponseBody
    public String update(@RequestBody Exam exam){

        return examService.update(exam);
    }
    @RequestMapping("/addOne")
    @ResponseBody
    public String addOne(@RequestBody Exam exam){

        return examService.addOne(exam);
    }
}
