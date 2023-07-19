package com.example.ncre_system_idea.Service;

import com.example.ncre_system_idea.DAO.ExamRoomDAO;
import com.example.ncre_system_idea.DAO.ExamRoomExamDAO;
import com.example.ncre_system_idea.pojo.ExamRoomExam;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
@Service
public class ExamRoomExamService {
    @Autowired
    ExamRoomExamDAO examRoomExamDAO;
    public PageInfo<ExamRoomExam> selectAll(int pageNum, int pageSize, String sortProp, String sortOrder, boolean isSearch, String optionValue, String searchValue) {
        if(Objects.equals(isSearch, true)){
            /*点击了搜索按钮*/
            if(searchValue == ""){
                /*搜索内容为空则显示全部列表*/
                PageHelper.startPage(pageNum,pageSize);
                if(sortProp!=""){
                    PageHelper.orderBy(sortProp+" "+sortOrder);
                }
                List<ExamRoomExam> list =examRoomExamDAO.selectAll();
                PageInfo<ExamRoomExam> result =new PageInfo<>(list);
                return result;
            }else {
                /*搜索不为空*/
                if(optionValue==""){
                    /*但是没有选择查询依据，返回所有列表*/
                    PageHelper.startPage(pageNum,pageSize);
                    if(sortProp!=""){
                        PageHelper.orderBy(sortProp+" "+sortOrder);
                    }
                    List<ExamRoomExam> list =examRoomExamDAO.selectAll();
                    PageInfo<ExamRoomExam> result =new PageInfo<>(list);
                    return result;
                }else {
                    /*正确进行搜索*/
                    if("序号".equals(optionValue)){
                        PageHelper.startPage(pageNum,pageSize);
                        if(sortProp!=""){
                            PageHelper.orderBy(sortProp+" "+sortOrder);
                        }
                        List<ExamRoomExam> list =examRoomExamDAO.selectAllById(searchValue);
                        PageInfo<ExamRoomExam> result =new PageInfo<>(list);
                        return result;
                    }else {
                        PageHelper.startPage(pageNum,pageSize);
                        if(sortProp!=""){
                            PageHelper.orderBy(sortProp+" "+sortOrder);
                        }
                        List<ExamRoomExam> list =examRoomExamDAO.selectAllByName(searchValue);
                        PageInfo<ExamRoomExam> result =new PageInfo<>(list);
                        return result;
                    }


                }

            }

        }else{/*首次进入列表页面*/
            PageHelper.startPage(pageNum,pageSize);
            if(sortProp!=""){
                PageHelper.orderBy(sortProp+" "+sortOrder);
            }
            List<ExamRoomExam> list =examRoomExamDAO.selectAll();
            PageInfo<ExamRoomExam> result =new PageInfo<>(list);
            return result;
        }
    }

    public String deleteOne(int ereID) {
        int line=examRoomExamDAO.deleteOne(ereID);
        if(line!=0){
            return "success";
        }else
        {
            return "wrong";
        }
    }

    public String update(ExamRoomExam examRoomExam) {
        int line=examRoomExamDAO.update(examRoomExam);
        if(line!=0){
            return "success";
        }else
        {
            return "wrong";
        }
    }
    public String addOne(ExamRoomExam examRoomExam) {
        int line=   examRoomExamDAO.addOne(examRoomExam);
        if(line!=0){
            return "success";
        }else
        {
            return "wrong";
        }
    }
}
