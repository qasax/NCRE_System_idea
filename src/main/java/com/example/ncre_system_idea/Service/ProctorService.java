package com.example.ncre_system_idea.Service;

import com.example.ncre_system_idea.DAO.ProctorDAO;
import com.example.ncre_system_idea.pojo.Proctor;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProctorService {
    @Autowired
    ProctorDAO proctorDAO;
    public List<Proctor> selectAll(int pageNum, int pageSize){
        int offset = (pageNum-1)*pageSize;
        List<Proctor> list =proctorDAO.selectAll(offset,pageSize);
        return list;
    }

    public PageInfo<Proctor> selectAll1(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Proctor> list =proctorDAO.selectAll1();
        PageInfo<Proctor> result =new PageInfo<>(list);
        return  result;
    }
}
