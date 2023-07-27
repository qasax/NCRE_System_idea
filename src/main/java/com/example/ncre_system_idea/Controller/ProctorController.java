package com.example.ncre_system_idea.Controller;

import com.example.ncre_system_idea.Service.ProctorService;
import com.example.ncre_system_idea.pojo.Exam;
import com.example.ncre_system_idea.pojo.ExamRoom;
import com.example.ncre_system_idea.pojo.Proctor;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProctorController {
    @Autowired
    ProctorService proctorService;
    @RequestMapping("/aLLProctors")
    @ResponseBody
    public PageInfo<Proctor> selectALL(int pageNum, int pageSize,String sortProp,String sortOrder,boolean isSearch,String optionValue,String searchValue){

        return proctorService.selectAll(pageNum,pageSize,sortProp,sortOrder,isSearch,optionValue,searchValue);
    }
    @RequestMapping("/deleteOne")
    @ResponseBody
    public String deleteOne(int ProctorID){

        return proctorService.deleteOne(ProctorID);
    }
    @RequestMapping("/update")
    @ResponseBody
    public String update(@RequestBody Proctor proctor){

        return proctorService.update(proctor);
    }
    @RequestMapping("/addOne")
    @ResponseBody
    public String addOne(@RequestBody Proctor proctor){

        return proctorService.addOne(proctor);
    }
    @RequestMapping("/selectIt")//选出该场次考试尚未被使用的考场
    @ResponseBody
    public List<Proctor> selectIt(String examId){

        return proctorService.selectIt(examId);
    }
    //监考员前台
    @RequestMapping("/selectProctorByUsername")//选出该场次考试尚未被使用的考场
    @ResponseBody
    public Proctor selectProctorByUsername(String username){
        return  proctorService.selectProctorByUsername(username);
    }
    @RequestMapping("/updateProctor")//选出该场次考试尚未被使用的考场
    @ResponseBody
    public String updateProctor(@RequestBody Proctor proctor) {
        return  proctorService.updateProctor(proctor);

    }
}