package com.example.ncre_system_idea.Service;

import com.example.ncre_system_idea.DAO.ExamDAO;
import com.example.ncre_system_idea.pojo.Exam;
import com.example.ncre_system_idea.pojo.Proctor;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service

public class ExamService {
    @Autowired
    ExamDAO examDAO;
    public PageInfo<Exam> selectAll(int pageNum, int pageSize, String sortProp, String sortOrder, boolean isSearch, String optionValue, String searchValue) {
        if(Objects.equals(isSearch, true)){
            /*点击了搜索按钮*/
            if(searchValue == ""){
                /*搜索内容为空则显示全部列表*/
                PageHelper.startPage(pageNum,pageSize);
                if(sortProp!=""){
                    PageHelper.orderBy(sortProp+" "+sortOrder);
                }
                List<Exam> list =examDAO.selectAll();
                PageInfo<Exam> result =new PageInfo<>(list);
                return result;
            }else {
                /*搜索不为空*/
                if(optionValue==""){
                    /*但是没有选择查询依据，返回所有列表*/
                    PageHelper.startPage(pageNum,pageSize);
                    if(sortProp!=""){
                        PageHelper.orderBy(sortProp+" "+sortOrder);
                    }
                    List<Exam> list =examDAO.selectAll();
                    PageInfo<Exam> result =new PageInfo<>(list);
                    return result;
                }else {
                    /*正确进行搜索*/
                    if("考试序号".equals(optionValue)){
                        PageHelper.startPage(pageNum,pageSize);
                        if(sortProp!=""){
                            PageHelper.orderBy(sortProp+" "+sortOrder);
                        }
                        List<Exam> list =examDAO.selectAllById(searchValue);
                        PageInfo<Exam> result =new PageInfo<>(list);
                        return result;
                    }else {
                        PageHelper.startPage(pageNum,pageSize);
                        if(sortProp!=""){
                            PageHelper.orderBy(sortProp+" "+sortOrder);
                        }
                        List<Exam> list =examDAO.selectAllByName(searchValue);
                        PageInfo<Exam> result =new PageInfo<>(list);
                        return result;
                    }


                }

            }

        }else{/*首次进入列表页面*/
            PageHelper.startPage(pageNum,pageSize);
            if(sortProp!=""){
                PageHelper.orderBy(sortProp+" "+sortOrder);
            }
            List<Exam> list =examDAO.selectAll();
            PageInfo<Exam> result =new PageInfo<>(list);
            return result;
        }
    }

    public String deleteOne(int examID) {
        int line=examDAO.deleteOne(examID);
        if(line!=0){
            return "success";
        }else
        {
            return "wrong";
        }
    }

    public String update(Exam exam) {
        int line=examDAO.update(exam);
        if(line!=0){
            return "success";
        }else
        {
            return "wrong";
        }
    }

    public String addOne(Exam exam) {
        int line=   examDAO.addOne(exam);
        if(line!=0){
            return "success";
        }else
        {
            return "wrong";
        }
    }
    public List<Exam> selectAllExam(){
        return  examDAO.selectAllExam();
    }
}
