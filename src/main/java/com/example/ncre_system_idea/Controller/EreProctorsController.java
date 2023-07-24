package com.example.ncre_system_idea.Controller;

import com.example.ncre_system_idea.Service.EreProctorsService;
import com.example.ncre_system_idea.Service.ExamRoomExamService;
import com.example.ncre_system_idea.pojo.EreProctors;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin(origins = {"http://localhost:8088","http://localhost:8089"}, allowCredentials = "true")
@RequestMapping("/ereProctors")
public class EreProctorsController {
    @Autowired
    EreProctorsService ereProctorsService;
    @RequestMapping("/allEreProctors")
    @ResponseBody
    public PageInfo<EreProctors> selectALL(int pageNum, int pageSize, String sortProp, String sortOrder, boolean isSearch, String optionValue, String searchValue){

        return ereProctorsService.selectAll(pageNum,pageSize,sortProp,sortOrder,isSearch,optionValue,searchValue);
    }
    @RequestMapping("/deleteOne")
    @ResponseBody
    public String deleteOne(int ereID){

        return ereProctorsService.deleteOne(ereID);
    }
    @RequestMapping("/update")
    @ResponseBody
    public String update(int  before1,int before2 ,int ereID,int after1,int after2){
        return ereProctorsService.update(before1,before2,ereID,after1,after2);
    }
    @RequestMapping("/addOne")
    @ResponseBody
    public String addOne(int ereID,int proctorID){

        return ereProctorsService.addOne(ereID,proctorID);
    }
}
