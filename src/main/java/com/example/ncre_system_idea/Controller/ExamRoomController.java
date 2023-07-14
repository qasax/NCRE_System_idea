package com.example.ncre_system_idea.Controller;

import com.example.ncre_system_idea.Service.ExamRoomService;
import com.example.ncre_system_idea.Service.ExamService;
import com.example.ncre_system_idea.pojo.Exam;
import com.example.ncre_system_idea.pojo.ExamRoom;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin(origins = "http://localhost:8088", allowCredentials = "true")
@RequestMapping("/examroom")
public class ExamRoomController {
    @Autowired
    ExamRoomService examRoomService;
    @RequestMapping("/aLLExamroom")
    @ResponseBody
    public PageInfo<ExamRoom> selectALL(int pageNum, int pageSize, String sortProp, String sortOrder, boolean isSearch, String optionValue, String searchValue){

        return examRoomService.selectAll(pageNum,pageSize,sortProp,sortOrder,isSearch,optionValue,searchValue);
    }
    @RequestMapping("/deleteOne")
    @ResponseBody
    public String deleteOne(int examRoomID){

        return examRoomService.deleteOne(examRoomID);
    }
    @RequestMapping("/update")
    @ResponseBody
    public String update(@RequestBody ExamRoom examRoom){

        return examRoomService.update(examRoom);
    }
    @RequestMapping("/addOne")
    @ResponseBody
    public String addOne(@RequestBody ExamRoom examRoom){

        return examRoomService.addOne(examRoom);
    }
}
