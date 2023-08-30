package com.example.ncre_system_idea.service;

import com.example.ncre_system_idea.dao.*;
import com.example.ncre_system_idea.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AutoAssignService {
    @Autowired
    ExamDAO examDAO;
    @Autowired
    ExamRoomExamDAO examRoomExamDAO;
    @Autowired
    ExamRoomDAO examRoomDAO;
    @Autowired
    StudentDAO studentDAO;
    @Autowired
    ProctorDAO proctorDAO;
    @Autowired
    EreProctorsDAO ereProctorsdao;
    public String AutoAssignStudent(){//学生自动分配位置
        int flag=0;//用来标识本次循环，是否成功进行了学生的分配，为0时说明upate没有更改表中的任何一行，相当于说明考生分配完毕
        int examNum=examDAO.selectCount();//获取到考试场数
        for(int i=0;i<examNum;i++){//根据考试数进行循环
            int examID= examDAO.selectExamID(i);//利用limit实现依次获取表中考试对应的ID
            System.out.println("正在给"+examID+"号考试进行分配考生");
            int examRoomNum = examRoomExamDAO.selectCount(examID);//根据考试ID,获取该场考试的考场数
            for(int j=0;j<examRoomNum;j++){//根据考场数进行循环
                int examRoomID= examRoomExamDAO.selectExamRoomID(examID,j);//利用考试号和limit实现依次获取examRoomExam表中考试房间对应的ID
                System.out.println("正在给"+examRoomID+"号考场进行分配考生");
                int seatNum = examRoomDAO.selectCount(examRoomID);//根据考场号获取该考场对应的座位数
                for (int k=0;k<seatNum;k++){//根据座位数进行循环
                    System.out.println("正在给"+(k+1)+"号座位进行分配考生");
                   flag= studentDAO.updateAssignSeat(examID,examRoomID,k+1);//根据考试号为考生分配对应的考场号和座位号，注意：考场号要和考场表中的序号相同
                }
            }
        }
        if(flag==0)
            return "考生成功全部分配完成,且教室有空闲座位";
        else  //即flag==1，此时有可能座位正好，也有可能是座位不够
        {
            if(studentDAO.checkStudent()==0)
            {
                return "考生全部分配完成，且座位正好";
            }else {
                return "考生未分配完成，教室不足。有"+studentDAO.checkStudent()+"名考生没有座位";
            }
        }

    }

    public List<String> AutoAssignProctor(){//监考员自动分配
        int examNum=examDAO.selectCount();//获取到考试场数
        List<String>  endStatus = new ArrayList<>();
        for(int i=0;i<examNum;i++) {//根据考试数进行循环
            int examID = examDAO.selectExamID(i);//利用limit实现依次获取表中考试对应的ID
            System.out.println("正在给" + examID + "号考试进行分配监考员");
            int examRoomNum = examRoomExamDAO.selectCount(examID);//根据考试ID,获取该场考试的考场数
            for (int j = 0, k=0; j < examRoomNum; j++,k++) {//根据考场数进行循环--由于一次循环中要添加两名监考员，增加一个k用来标识limit的起始数。
                int examRoomID= examRoomExamDAO.selectExamRoomID(examID,j);//利用考试号和limit实现依次获取examRoomExam表中考试房间对应的ID
                int ereID = examRoomExamDAO.selectEreID(examID,j);//利用limit获取同一行的ereID
                List<Student> studentList=studentDAO.selectStudentOfExamRoom(examID,examRoomID);//获取该考场的全部学生
               int studentSize= studentList.size();//获取到该考场的学生数
                if(studentSize!=0){
                   String proctorID= proctorDAO.selectOne(k);//利用limit 获取一名监考员 ；由于不清楚监考员数量，此处查询可能为空，所以使用String类型接受
                    if(proctorID!=null){

                        ereProctorsdao.addOne(ereID,Integer.parseInt(proctorID));//向ereProctor表中添加一名监考员
                    }else{
                        endStatus.add("考试"+examID+",监考员不足，最后分配的考场缺一位监考员");
                        break;
                    }
                    k++;
                    proctorID=proctorDAO.selectOne(k);
                    if(proctorID!=null){
                        ereProctorsdao.addOne(ereID,Integer.parseInt(proctorID));
                    } else{

                        endStatus.add("考试"+examID+",监考员不足，最后分配的考场监考员正好");
                        break;
                    }
                }else
                    endStatus.add("考试"+examID+"中的考场"+examRoomID+"没有考生，不需要进行分配");
            }
        }
        endStatus.add("全部考试，全部考场监考员正常分配完成");
        return endStatus;
    }
}
