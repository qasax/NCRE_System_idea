package com.example.ncre_system_idea.Controller;

import com.example.ncre_system_idea.Service.ProctorService;
import com.example.ncre_system_idea.pojo.Proctor;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin(origins = "http://localhost:8088", allowCredentials = "true")
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
    public String deleteOne(int id){

        return proctorService.deleteOne(id);
    }
}
