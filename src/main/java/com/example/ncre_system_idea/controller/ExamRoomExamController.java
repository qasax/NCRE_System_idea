package com.example.ncre_system_idea.controller;

import com.example.ncre_system_idea.service.ExamRoomExamService;
import com.example.ncre_system_idea.pojo.ExamRoomExam;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/examRoomExam")
public class ExamRoomExamController {
    @Autowired
    ExamRoomExamService examRoomExamService;
    /**
     * 查询考场-考试对应表的信息
     *实现分页查询，关键词查询，排序
     * @return
     */
    @RequestMapping("/aLLExamRoomExam")
    @ResponseBody
    public PageInfo<ExamRoomExam> selectALL(int pageNum, int pageSize, String sortProp, String sortOrder, boolean isSearch, String optionValue, String searchValue){

        return examRoomExamService.selectAll(pageNum,pageSize,sortProp,sortOrder,isSearch,optionValue,searchValue);
    }
    /**
     * 根据ereID删除表中的某一条信息
     *
     * @return
     */
    @RequestMapping("/deleteOne")
    @ResponseBody
    public String deleteOne(int ereID){

        return examRoomExamService.deleteOne(ereID);
    }
    /**
     * 根据examRoomExam中的id，对表中某一条信息进行更新
     *
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public String update(@RequestBody ExamRoomExam examRoomExam){

        return examRoomExamService.update(examRoomExam);
    }
    /**
     * 向表中添加一条信息
     *
     * @return
     */
    @RequestMapping("/addOne")
    @ResponseBody
    public String addOne(@RequestBody ExamRoomExam examRoomExam){

        return examRoomExamService.addOne(examRoomExam);
    }
}
