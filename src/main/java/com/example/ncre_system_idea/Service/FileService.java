package com.example.ncre_system_idea.Service;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.alibaba.fastjson.JSON;
import com.example.ncre_system_idea.DAO.*;
import com.example.ncre_system_idea.EasyExcelPojo.EreProctorsExcel;
import com.example.ncre_system_idea.Utils.FileUtils;
import com.example.ncre_system_idea.pojo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

@Service
@Slf4j
public class FileService {
    @Autowired
    ExamDAO examDAO;
    FileUtils fileUtils=new FileUtils();
    String downSave = "D:\\重装前桌面代码内容\\暑期实训_1\\ncre_Download\\";
    String upSave = "D:\\重装前桌面代码内容\\暑期实训_1\\ncre_Upload\\";

    public ResponseEntity<byte[]> examDown() {

        List<Exam> list = examDAO.selectAllExam();
        String fileName = downSave + "exam_" + ".xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(fileName, Exam.class)
                .sheet("模板")
                .doWrite(() -> {
                    // 分页查询数据
                    return list;
                });
        String downName = "exam.xlsx";//用户下载时，所下载文件对应的文件名
        return fileUtils.downFile(fileName, downName);//工具类，负责读取用户请求的表格，并响应给用户下载--使用输入流读取
    }

    public String examUpload(@RequestParam MultipartFile file) throws IOException {
        // 写法1：JDK8+ ,不用额外写一个DemoDataListener
        // since: 3.0.0-beta1
        String fileName = upSave + "exam_" + ".xlsx";
        fileUtils.upFile(fileName, file);//工具类，负责将用户上传的表格保存到本地--使用输出流，写到目标路径
        // 这里默认每次会读取100条数据 然后返回过来 直接调用使用数据就行
        // 具体需要返回多少行可以在`PageReadListener`的构造函数设置
        EasyExcel.read(fileName, Exam.class, new PageReadListener<Exam>(dataList -> {
            for (Exam exam : dataList) {
                log.info("读取到一条数据{}", JSON.toJSONString(exam));
                examDAO.addOne(exam);
            }
        })).sheet().doRead();
        return "ok";
    }

    @Autowired
    StudentDAO studentDAO;

    public ResponseEntity<byte[]> studentDown() {

        List<Student> list = studentDAO.selectAll();
        String fileName = downSave + "student_" + ".xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(fileName, Student.class)
                .sheet("模板")
                .doWrite(() -> {
                    // 分页查询数据
                    return list;
                });
        String downName = "student.xlsx";//用户下载时，所下载文件对应的文件名
        return fileUtils.downFile(fileName, downName);
    }

    public String studentUpload(@RequestParam MultipartFile file) throws IOException {
        // 写法1：JDK8+ ,不用额外写一个DemoDataListener
        // since: 3.0.0-beta1
        String fileName = upSave + "student_" + ".xlsx";
        fileUtils.upFile(fileName, file);
        // 这里默认每次会读取100条数据 然后返回过来 直接调用使用数据就行
        // 具体需要返回多少行可以在`PageReadListener`的构造函数设置
        EasyExcel.read(fileName, Exam.class, new PageReadListener<Student>(dataList -> {
            for (Student student : dataList) {
                log.info("读取到一条数据{}", JSON.toJSONString(student));
                studentDAO.addOne(student);
            }
        })).sheet().doRead();
        return "ok";

    }

    @Autowired
    ProctorDAO proctorDAO;

    public ResponseEntity<byte[]> proctorDown() {

        List<Proctor> list = proctorDAO.selectAll();
        String fileName = downSave + "proctor_" + ".xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(fileName, Proctor.class)
                .sheet("模板")
                .doWrite(() -> {
                    // 分页查询数据
                    return list;
                });
        String downName = "proctor_.xlsx";//用户下载时，所下载文件对应的文件名
        return fileUtils.downFile(fileName, downName);
    }

    public String proctorUpload(@RequestParam MultipartFile file) throws IOException {
        // 写法1：JDK8+ ,不用额外写一个DemoDataListener
        // since: 3.0.0-beta1
        String fileName = upSave + "proctor_" + ".xlsx";
        fileUtils.upFile(fileName, file);
        // 这里默认每次会读取100条数据 然后返回过来 直接调用使用数据就行
        // 具体需要返回多少行可以在`PageReadListener`的构造函数设置
        EasyExcel.read(fileName, Proctor.class, new PageReadListener<Proctor>(dataList -> {
            for (Proctor proctor : dataList) {
                log.info("读取到一条数据{}", JSON.toJSONString(proctor));
                proctorDAO.addOne(proctor);
            }
        })).sheet().doRead();
        return "ok";

    }

    @Autowired
    ExamRoomDAO examRoomDAO;

    public ResponseEntity<byte[]> examRoomDown() {

        List<ExamRoom> list = examRoomDAO.selectAll();
        String fileName = downSave + "examRoom_" + ".xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(fileName, ExamRoom.class)
                .sheet("模板")
                .doWrite(() -> {
                    // 分页查询数据
                    return list;
                });
        String downName = "examRoom_.xlsx";//用户下载时，所下载文件对应的文件名
        return fileUtils.downFile(fileName, downName);
    }

    public String examRoomUpload(@RequestParam MultipartFile file) throws IOException {
        // 写法1：JDK8+ ,不用额外写一个DemoDataListener
        // since: 3.0.0-beta1
        String fileName = upSave + "examRoom_" + ".xlsx";
        fileUtils.upFile(fileName, file);
        // 这里默认每次会读取100条数据 然后返回过来 直接调用使用数据就行
        // 具体需要返回多少行可以在`PageReadListener`的构造函数设置
        EasyExcel.read(fileName, ExamRoom.class, new PageReadListener<ExamRoom>(dataList -> {
            for (ExamRoom examRoom : dataList) {
                log.info("读取到一条数据{}", JSON.toJSONString(examRoom));
                examRoomDAO.addOne(examRoom);
            }
        })).sheet().doRead();
        return "ok";

    }

    @Autowired
    UserDAO userDAO;

    public ResponseEntity<byte[]> userDown() {

        List<User> list = userDAO.selectAll();
        String fileName = downSave + "user_" + ".xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(fileName, User.class)
                .sheet("模板")
                .doWrite(() -> {
                    // 分页查询数据
                    return list;
                });
        String downName = "user_.xlsx";//用户下载时，所下载文件对应的文件名
        return fileUtils.downFile(fileName, downName);
    }

    public String userUpload(@RequestParam MultipartFile file) throws IOException {
        // 写法1：JDK8+ ,不用额外写一个DemoDataListener
        // since: 3.0.0-beta1
        String fileName = upSave + "user_" + ".xlsx";
        fileUtils.upFile(fileName, file);
        // 这里默认每次会读取100条数据 然后返回过来 直接调用使用数据就行
        // 具体需要返回多少行可以在`PageReadListener`的构造函数设置
        EasyExcel.read(fileName, User.class, new PageReadListener<User>(dataList -> {
            for (User user : dataList) {
                log.info("读取到一条数据{}", JSON.toJSONString(user));
                userDAO.addOne(user);
            }
        })).sheet().doRead();
        return "ok";

    }

    @Autowired
    ExamRoomExamDAO examRoomExamDAO;

    public ResponseEntity<byte[]> examRoomExamDown() {

        List<ExamRoomExam> list = examRoomExamDAO.selectAll();
        String fileName = downSave + "examRoomExam_" + ".xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(fileName, ExamRoomExam.class)
                .sheet("模板")
                .doWrite(() -> {
                    // 分页查询数据
                    return list;
                });
        String downName = "examRoomExam_.xlsx";//用户下载时，所下载文件对应的文件名
        return fileUtils.downFile(fileName, downName);
    }

    public String examRoomExamUpload(@RequestParam MultipartFile file) throws IOException {
        // 写法1：JDK8+ ,不用额外写一个DemoDataListener
        // since: 3.0.0-beta1
        String fileName = upSave + "examRoomExam_" + ".xlsx";
        fileUtils.upFile(fileName, file);
        // 这里默认每次会读取100条数据 然后返回过来 直接调用使用数据就行
        // 具体需要返回多少行可以在`PageReadListener`的构造函数设置
        EasyExcel.read(fileName, ExamRoomExam.class, new PageReadListener<ExamRoomExam>(dataList -> {
            for (ExamRoomExam examRoomExam : dataList) {
                log.info("读取到一条数据{}", JSON.toJSONString(examRoomExam));
                examRoomExamDAO.addOne(examRoomExam);
            }
        })).sheet().doRead();
        return "ok";

    }

    @Autowired
    EreProctorsDAO ereProctorsDAO;

    public ResponseEntity<byte[]> ereProctorDown() {

        List<EreProctors> list = ereProctorsDAO.selectAll();
        //以下为list转化为excel表格的逻辑

        List<EreProctorsExcel> ereProctorsExcelList = new ArrayList<>();
        for (EreProctors ereProctor : list
        ) {
            EreProctorsExcel ereProctorsExcel = new EreProctorsExcel();
            ereProctorsExcel.setEreID(ereProctor.getEreID());
            ereProctorsExcel.setExamID(ereProctor.getExamID());
            ereProctorsExcel.setExamName(ereProctor.getExamName());
            ereProctorsExcel.setExamDate(ereProctor.getExamDate());
            ereProctorsExcel.setExamTime(ereProctor.getExamTime());
            ereProctorsExcel.setExamLocation(ereProctor.getExamLocation());
            ereProctorsExcel.setExamRoomID(ereProctor.getExamRoomID());
            ereProctorsExcel.setExamRoomName(ereProctor.getExamRoomName());
            ereProctorsExcel.setSeatCount(ereProctor.getSeatCount());
            for (Proctor proctor : ereProctor.getProctors()
            ) {
                if (ereProctorsExcel.getProctorName1() == null) {
                    ereProctorsExcel.setProctorName1(proctor.getTeacherName());
                } else {
                    ereProctorsExcel.setProctorName2(proctor.getTeacherName());
                }
            }
            ereProctorsExcelList.add(ereProctorsExcel);
        }
        String fileName = downSave + "ereProctor_.xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(fileName, EreProctorsExcel.class)
                .sheet("模板")
                .doWrite(() -> {
                    // 分页查询数据
                    return ereProctorsExcelList;
                });
        String downName = "ereProctor_.xlsx";//用户下载时，所下载文件对应的文件名
        return fileUtils.downFile(fileName, downName);
    }

    public ResponseEntity<byte[]> studentOfExamRoomDown(int examID, int examRoomID) {
        List<Student> list = studentDAO.selectStudentOfExamRoom(examID, examRoomID);
        String fileName = downSave + "studentOfExamRoom_" + examID + "_" + examRoomID + ".xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(fileName, Student.class)
                .sheet("模板")
                .doWrite(() -> {
                    // 分页查询数据
                    return list;
                });
        String downName = "studentOfExamRoom_" + examID + "_" + examRoomID + ".xlsx";//用户下载时，所下载文件对应的文件名
        return fileUtils.downFile(fileName, downName);
    }
}
