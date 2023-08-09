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

import java.util.List;

@Controller
@RequestMapping("/exam")
public class ExamController {
    @Autowired
    ExamService examService;
    /**
     * 查询全部考试信息
     *实现分页查询，关键词查询，排序
     * @return
     */
    @RequestMapping("/aLLExam")
    @ResponseBody
    public PageInfo<Exam> selectALL(int pageNum, int pageSize, String sortProp, String sortOrder, boolean isSearch, String optionValue, String searchValue){

        return examService.selectAll(pageNum,pageSize,sortProp,sortOrder,isSearch,optionValue,searchValue);
    }
    /**
     * 根据ExamID删除某个考试信息
     *
     * @return
     */
    @RequestMapping("/deleteOne")
    @ResponseBody
    public String deleteOne(int examID){

        return examService.deleteOne(examID);
    }
    /**
     * 根据Exam中的examId，对对应考试信息进行修改。
     *
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public String update(@RequestBody Exam exam){

        return examService.update(exam);
    }
    /**
     * 在表中添加一场考试以及对应信息
     *
     * @return
     */
    @RequestMapping("/addOne")
    @ResponseBody
    public String addOne(@RequestBody Exam exam){

        return examService.addOne(exam);
    }
    /**
     * 查询全部考试，不涉及分页等
     * 前台考生用户使用
     * @return
     */
    @RequestMapping("/selectAllExam")
    @ResponseBody
    public List<Exam> selectAllExam(){

        return examService.selectAllExam();
    }
}
