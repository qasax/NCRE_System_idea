package com.example.ncre_system_idea.service;

import com.example.ncre_system_idea.dao.EreProctorsDAO;
import com.example.ncre_system_idea.pojo.EreProctors;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
@Service
public class EreProctorsService {
    @Autowired
    EreProctorsDAO ereProctorsDAO;
    public PageInfo<EreProctors> selectAll(int pageNum, int pageSize, String sortProp, String sortOrder, boolean isSearch, String optionValue, String searchValue) {
        if(Objects.equals(isSearch, true)){
            /*点击了搜索按钮*/
            if(searchValue == ""){
                /*搜索内容为空则显示全部列表*/
                PageHelper.startPage(pageNum,pageSize);
                if(sortProp!=""){
                    PageHelper.orderBy("examroomexam."+sortProp+" "+sortOrder);
                }
                List<EreProctors> list =ereProctorsDAO.selectAll();
                if(list.size()<10){//如果查询结果的size小于10 说明前台显示不够10条
                    int i=10- list.size();//获取缺失的条数-至少要多查i条

                }
                PageInfo<EreProctors> result =new PageInfo<>(list);
                return result;
            }else {
                /*搜索不为空*/
                if(optionValue==""){
                    /*但是没有选择查询依据，返回所有列表*/
                    PageHelper.startPage(pageNum,pageSize);
                    if(sortProp!=""){
                        PageHelper.orderBy("examroomexam."+sortProp+" "+sortOrder);
                    }
                    List<EreProctors> list =ereProctorsDAO.selectAll();
                    PageInfo<EreProctors> result =new PageInfo<>(list);
                    return result;
                }else {
                    /*正确进行搜索*/
                    if("序号".equals(optionValue)){
                        PageHelper.startPage(pageNum,pageSize);
                        if(sortProp!=""){
                            PageHelper.orderBy("examroomexam."+sortProp+" "+sortOrder);
                        }
                        List<EreProctors> list =ereProctorsDAO.selectAllById(searchValue);
                        PageInfo<EreProctors> result =new PageInfo<>(list);
                        return result;
                    }else {
                        PageHelper.startPage(pageNum,pageSize);
                        if(sortProp!=""){
                            PageHelper.orderBy("examroomexam."+sortProp+" "+sortOrder);
                        }
                        List<EreProctors> list =ereProctorsDAO.selectAllByName(searchValue);
                        PageInfo<EreProctors> result =new PageInfo<>(list);
                        return result;
                    }


                }

            }

        }else{/*首次进入列表页面*/
            PageHelper.startPage(pageNum,pageSize);
            if(sortProp!=""){
                PageHelper.orderBy("examroomexam."+sortProp+" "+sortOrder);
            }
            List<EreProctors> list =ereProctorsDAO.selectAll();
            PageInfo<EreProctors> result =new PageInfo<>(list);
            return result;
        }
    }

    public String deleteOne(int ereID) {
        int line=ereProctorsDAO.deleteOne(ereID);
        if(line!=0){
            return "success";
        }else
        {
            return "wrong";
        }
    }

    public String update(int  before1,int before2 ,int ereID,int after1,int after2) {//是修改还是添加，进行判断

        int line=ereProctorsDAO.update(before1,before2,ereID,after1,after2);
        if(before1!=0&before2==0){//筛选出只有一个监考员的情况
            /*ereProctorsDAO.update(before1,before2,ereID,after2,after1);//把表中原来的数据修改成管理员2对应的数据（原因：collection对应select查询结果生成的List集合顺序会与查询结果相反）*/
            //----上面的问题，无法复现，修改为正常添加方式，上面的方法废弃。--------
            addOne(ereID,after1);//然后再把原来监考员1的数据再添加进去
        }else {
            if (before1 == 0) {
                addOne(ereID, after1);
            }
            if (before2 == 0) {
                addOne(ereID, after2);
            }

        }

        if(line!=0){
            return "success";
        }else
        {
            return "wrong";
        }
    }
    public String addOne(int ereID,int proctorID) {
        int line=   ereProctorsDAO.addOne(ereID,proctorID);
        if(line!=0){
            return "success";
        }else
        {
            return "wrong";
        }
    }
}
