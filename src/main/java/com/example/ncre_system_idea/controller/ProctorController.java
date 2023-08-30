package com.example.ncre_system_idea.controller;

import com.example.ncre_system_idea.service.ProctorService;
import com.example.ncre_system_idea.pojo.Proctor;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProctorController {
    @Autowired
    ProctorService proctorService;
    /**
     * 查询监考员信息
     *分页查询，关键词查询，排序
     * @return
     */
    @RequestMapping("/aLLProctors")
    @ResponseBody
    public PageInfo<Proctor> selectALL(int pageNum, int pageSize,String sortProp,String sortOrder,boolean isSearch,String optionValue,String searchValue){

        return proctorService.selectAll(pageNum,pageSize,sortProp,sortOrder,isSearch,optionValue,searchValue);
    }
    /**
     * 根据id删除表中某一条信息
     *
     * @return
     */
    @RequestMapping("/deleteOne")
    @ResponseBody
    public String deleteOne(int ProctorID){

        return proctorService.deleteOne(ProctorID);
    }
    /**
     * 根据proctor中的id，更新某一条信息
     *
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public String update(@RequestBody Proctor proctor){

        return proctorService.update(proctor);
    }
    /**
     * 为proctor表中添加一名用户
     *
     * @return
     */
    @RequestMapping("/addOne")
    @ResponseBody
    public String addOne(@RequestBody Proctor proctor){

        return proctorService.addOne(proctor);
    }
    @RequestMapping("/registerOne")
    @ResponseBody
    public String registerOne(@RequestBody Proctor proctor){

        return proctorService.registerOne(proctor);
    }
    /**
     * 查询在某次考试中没有被分配的监考员
     *
     * @return
     */
    @RequestMapping("/selectIt")
    @ResponseBody
    public List<Proctor> selectIt(String examId){

        return proctorService.selectIt(examId);
    }
    //监考员前台
    /**
     * 根据username查询对应的监考员信息
     *
     * @return
     */
    @RequestMapping("/selectProctorByUsername")
    @ResponseBody
    public Proctor selectProctorByUsername(String username){
        return  proctorService.selectProctorByUsername(username);
    }
    /**
     * 根据proctor中的id，修改监考员个人信息
     *
     * @return
     */
    @RequestMapping("/updateProctor")
    @ResponseBody
    public String updateProctor(@RequestBody Proctor proctor) {
        return  proctorService.updateProctor(proctor);

    }
    /**
     * 根据用户名查询某位监考员所负责的全部考场
     *
     * @return
     */
    @RequestMapping("/selectExamMsgByUsername")//找出该监考员所负责的全部考场
    @ResponseBody
    public List<Proctor> selectExamMsgByUsername(String username){
        return proctorService.selectExamMsgByUsername(username);
    }
}