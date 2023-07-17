package com.example.ncre_system_idea.Service;

import com.example.ncre_system_idea.DAO.UserDAO;
import com.example.ncre_system_idea.pojo.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserService {
    @Autowired
    UserDAO userDAO;
    public PageInfo<User> selectAll(int pageNum, int pageSize, String sortProp, String sortOrder, boolean isSearch, String optionValue, String searchValue) {
        if(Objects.equals(isSearch, true)){
            /*点击了搜索按钮*/
            if(searchValue == ""){
                /*搜索内容为空则显示全部列表*/
                PageHelper.startPage(pageNum,pageSize);
                if(sortProp!=""){
                    PageHelper.orderBy(sortProp+" "+sortOrder);
                }
                List<User> list =userDAO.selectAll();
                PageInfo<User> result =new PageInfo<>(list);
                return result;
            }else {
                /*搜索不为空*/
                if(optionValue==""){
                    /*但是没有选择查询依据，返回所有列表*/
                    PageHelper.startPage(pageNum,pageSize);
                    if(sortProp!=""){
                        PageHelper.orderBy(sortProp+" "+sortOrder);
                    }
                    List<User> list =userDAO.selectAll();
                    PageInfo<User> result =new PageInfo<>(list);
                    return result;
                }else {
                    /*正确进行搜索*/
                    if("考试序号".equals(optionValue)){
                        PageHelper.startPage(pageNum,pageSize);
                        if(sortProp!=""){
                            PageHelper.orderBy(sortProp+" "+sortOrder);
                        }
                        List<User> list =userDAO.selectAllById(searchValue);
                        PageInfo<User> result =new PageInfo<>(list);
                        return result;
                    }else {
                        PageHelper.startPage(pageNum,pageSize);
                        if(sortProp!=""){
                            PageHelper.orderBy(sortProp+" "+sortOrder);
                        }
                        List<User> list =userDAO.selectAllByName(searchValue);
                        PageInfo<User> result =new PageInfo<>(list);
                        return result;
                    }


                }

            }

        }else{/*首次进入列表页面*/
            PageHelper.startPage(pageNum,pageSize);
            if(sortProp!=""){
                PageHelper.orderBy(sortProp+" "+sortOrder);
            }
            List<User> list =userDAO.selectAll();
            PageInfo<User> result =new PageInfo<>(list);
            return result;
        }
    }

    public String deleteOne(int UserID) {
        int line=userDAO.deleteOne(UserID);
        if(line!=0){
            return "success";
        }else
        {
            return "wrong";
        }
    }

    public String update(User user) {
        int line=userDAO.update(user);
        if(line!=0){
            return "success";
        }else
        {
            return "wrong";
        }
    }

    public String addOne(User user) {
        int line=   userDAO.addOne(user);
        if(line!=0){
            return "success";
        }else
        {
            return "wrong";
        }
    }
}