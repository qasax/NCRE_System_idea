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
@RequestMapping("/ereProctors")
public class EreProctorsController {
    @Autowired
    EreProctorsService ereProctorsService;
    /**
     * 查询数据库中全部的监考员-考场分配信息
     *实现分页查询，关键词查询
     * @return
     */
    @RequestMapping("/allEreProctors")
    @ResponseBody
    public PageInfo<EreProctors> selectALL(int pageNum, int pageSize, String sortProp, String sortOrder, boolean isSearch, String optionValue, String searchValue){

        return ereProctorsService.selectAll(pageNum,pageSize,sortProp,sortOrder,isSearch,optionValue,searchValue);
    }
    /**
     * 根据ereID删除ereproctor表中某一条信息
     *已经弃用
     * @return
     */
    @RequestMapping("/deleteOne")
    @ResponseBody
    public String deleteOne(int ereID){

        return ereProctorsService.deleteOne(ereID);
    }
    /**
     * 更新某场考试某个考场的所分配的监考员
     *
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public String update(int  before1,int before2 ,int ereID,int after1,int after2){
        return ereProctorsService.update(before1,before2,ereID,after1,after2);
    }
    /**
     * 为某场考试的某个考场添加监考员
     *
     * @return
     */
    @RequestMapping("/addOne")
    @ResponseBody
    public String addOne(int ereID,int proctorID){

        return ereProctorsService.addOne(ereID,proctorID);
    }
}
