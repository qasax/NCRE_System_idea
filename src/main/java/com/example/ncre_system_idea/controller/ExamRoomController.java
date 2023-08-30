package com.example.ncre_system_idea.controller;

import com.example.ncre_system_idea.service.ExamRoomService;
import com.example.ncre_system_idea.pojo.ExamRoom;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/examRoom")
public class ExamRoomController {
    @Autowired
    ExamRoomService examRoomService;
    /**
     * 查询考场信息
     *实现分页查询，排序，关键词查询
     * @return
     */
    @RequestMapping("/aLLExamRoom")
    @ResponseBody
    public PageInfo<ExamRoom> selectALL(int pageNum, int pageSize, String sortProp, String sortOrder, boolean isSearch, String optionValue, String searchValue){

        return examRoomService.selectAll(pageNum,pageSize,sortProp,sortOrder,isSearch,optionValue,searchValue);
    }
    /**
     * 根据考场Id，删除考场表某一条信息
     *
     * @return
     */
    @RequestMapping("/deleteOne")
    @ResponseBody
    public String deleteOne(int examRoomID){

        return examRoomService.deleteOne(examRoomID);
    }
    /**
     * 根据examRoom中的Id，对表中某一条信息进行更新
     *
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public String update(@RequestBody ExamRoom examRoom){

        return examRoomService.update(examRoom);
    }
    /**
     * 向表中添加一个考场信息
     *
     * @return
     */
    @RequestMapping("/addOne")
    @ResponseBody
    public String addOne(@RequestBody ExamRoom examRoom){

        return examRoomService.addOne(examRoom);
    }
    /**
     * 查询在某场考试中，没有被使用的考场。
     *
     * @return
     */
    @RequestMapping("/selectIt")//选出该场次考试尚未被使用的考场
    @ResponseBody
    public List<ExamRoom> selectIt(String examId){

        return examRoomService.selectIt(examId);
    }
}
