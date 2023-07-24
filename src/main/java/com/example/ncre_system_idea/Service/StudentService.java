package com.example.ncre_system_idea.Service;

import com.example.ncre_system_idea.DAO.StudentDAO;
import com.example.ncre_system_idea.pojo.Exam;
import com.example.ncre_system_idea.pojo.ExamRoom;
import com.example.ncre_system_idea.pojo.Student;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class StudentService {
    @Autowired
    StudentDAO studentDAO;
    public PageInfo<Student> selectAll(int pageNum, int pageSize, String sortProp, String sortOrder, boolean isSearch, String optionValue, String searchValue) {
        if(Objects.equals(isSearch, true)){
            /*点击了搜索按钮*/
            if(searchValue == ""){
                /*搜索内容为空则显示全部列表*/
                PageHelper.startPage(pageNum,pageSize);
                if(sortProp!=""){
                    PageHelper.orderBy(sortProp+" "+sortOrder);
                }
                List<Student> list =studentDAO.selectAll();
                PageInfo<Student> result =new PageInfo<>(list);
                return result;
            }else {
                /*搜索不为空*/
                if(optionValue==""){
                    /*但是没有选择查询依据，返回所有列表*/
                    PageHelper.startPage(pageNum,pageSize);
                    if(sortProp!=""){
                        PageHelper.orderBy(sortProp+" "+sortOrder);
                    }
                    List<Student> list =studentDAO.selectAll();
                    PageInfo<Student> result =new PageInfo<>(list);
                    return result;
                }else {
                    /*正确进行搜索*/
                    if("考生序号".equals(optionValue)){
                        PageHelper.startPage(pageNum,pageSize);
                        if(sortProp!=""){
                            PageHelper.orderBy(sortProp+" "+sortOrder);
                        }
                        List<Student> list =studentDAO.selectAllById(searchValue);
                        PageInfo<Student> result =new PageInfo<>(list);
                        return result;
                    }else {
                        PageHelper.startPage(pageNum,pageSize);
                        if(sortProp!=""){
                            PageHelper.orderBy(sortProp+" "+sortOrder);
                        }
                        List<Student> list =studentDAO.selectAllByName(searchValue);
                        PageInfo<Student> result =new PageInfo<>(list);
                        return result;
                    }


                }

            }

        }else{/*首次进入列表页面*/
            PageHelper.startPage(pageNum,pageSize);
            if(sortProp!=""){
                PageHelper.orderBy(sortProp+" "+sortOrder);
            }
            List<Student> list =studentDAO.selectAll();
            PageInfo<Student> result =new PageInfo<>(list);
            return result;
        }
    }

    public String deleteOne(int studentID) {
        int line=studentDAO.deleteOne(studentID);
        if(line!=0){
            return "success";
        }else
        {
            return "wrong";
        }
    }

    public String update(Student student) {
        int line=studentDAO.update(student);
        if(line!=0){
            return "success";
        }else
        {
            return "wrong";
        }
    }
    public String addOne(Student student) {
        int line=   studentDAO.addOne(student);
        if(line!=0){
            return "success";
        }else
        {
            return "wrong";
        }
    }
    public String registerOne(Student student) {
        int line=   studentDAO.registerOne(student);
        if(line!=0){
            return "success";
        }else
        {
            return "wrong";
        }
    }
    public PageInfo<Student> selectStudentOfExamRoom(int pageNum,int pageSize,String sortProp, String sortOrder,int examID , int examRoomID){
        PageHelper.startPage(pageNum,pageSize);
        PageHelper.orderBy(sortProp+" "+sortOrder);
        List<Student> list=studentDAO.selectStudentOfExamRoom(examID,examRoomID);
        PageInfo<Student> result =new PageInfo<>(list);
        return  result;
    }
}
