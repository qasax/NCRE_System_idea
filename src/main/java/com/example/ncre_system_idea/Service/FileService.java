package com.example.ncre_system_idea.Service;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.alibaba.fastjson.JSON;
import com.example.ncre_system_idea.DAO.*;
import com.example.ncre_system_idea.EasyExcelPojo.EreProctorsExcel;
import com.example.ncre_system_idea.pojo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

@Service
@Slf4j
public class FileService {
    @Autowired
    ExamDAO examDAO;

    public ResponseEntity<byte[]> examDown(HttpSession session) throws
            IOException {

        List<Exam> list= examDAO.selectAllExam();
        String fileName = "D:\\重装前桌面代码内容\\暑期实训_1\\ncre_Download\\"+ "exam_" + ".xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(fileName, Exam.class)
                .sheet("模板")
                .doWrite(() -> {
                    // 分页查询数据
                    return list;
                });
        //创建输入流
        //使用try-with-resources语句自动关闭资源
        try (InputStream is = new FileInputStream(fileName)) {
            //创建字节数组
            byte[] bytes = new byte[is.available()];
            //将流读到字节数组中
            is.read(bytes);
            //创建HttpHeaders对象设置响应头信息
            MultiValueMap<String, String> headers = new HttpHeaders();
            //设置要下载方式以及下载文件的名字
            headers.add("Content-Disposition", "attachment;filename=exam.xlsx");
            //设置响应状态码
            HttpStatus statusCode = HttpStatus.OK;
            //创建ResponseEntity对象
            ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers,statusCode);
            return responseEntity;
        }


    }
    public String examUpload(@RequestParam MultipartFile file) throws IOException {
        // 写法1：JDK8+ ,不用额外写一个DemoDataListener
        // since: 3.0.0-beta1
        String fileName = "D:\\重装前桌面代码内容\\暑期实训_1\\ncre_Upload\\"+ "exam_" + ".xlsx";
        try(OutputStream out = new FileOutputStream(fileName)){
            out.write(file.getBytes());
            out.flush();
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
    }
    @Autowired
    StudentDAO studentDAO;
    public ResponseEntity<byte[]> studentDown(HttpSession session) throws
            IOException {

        List<Student> list= studentDAO.selectAll();
        String fileName = "D:\\重装前桌面代码内容\\暑期实训_1\\ncre_Download\\"+ "student_" + ".xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(fileName, Student.class)
                .sheet("模板")
                .doWrite(() -> {
                    // 分页查询数据
                    return list;
                });
        //创建输入流
        try(InputStream is = new FileInputStream(fileName)){
            //创建字节数组
            byte[] bytes = new byte[is.available()];
            //将流读到字节数组中
            is.read(bytes);
            //创建HttpHeaders对象设置响应头信息
            MultiValueMap<String, String> headers = new HttpHeaders();
            //设置要下载方式以及下载文件的名字
            headers.add("Content-Disposition", "attachment;filename=student.xlsx");
            //设置响应状态码
            HttpStatus statusCode = HttpStatus.OK;
            //创建ResponseEntity对象
            ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers,statusCode);
            return responseEntity;
        }
    }
    public String studentUpload(@RequestParam MultipartFile file) throws IOException {
        // 写法1：JDK8+ ,不用额外写一个DemoDataListener
        // since: 3.0.0-beta1
        String fileName = "D:\\重装前桌面代码内容\\暑期实训_1\\ncre_Upload\\"+ "student_" + ".xlsx";
        try( OutputStream out = new FileOutputStream(fileName)){
            out.write(file.getBytes());
            out.flush();
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
    }
    @Autowired
    ProctorDAO proctorDAO;
    public ResponseEntity<byte[]> proctorDown(HttpSession session) throws
            IOException {

        List<Proctor> list= proctorDAO.selectAll();
        String fileName = "D:\\重装前桌面代码内容\\暑期实训_1\\ncre_Download\\"+ "proctor_" + ".xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(fileName, Proctor.class)
                .sheet("模板")
                .doWrite(() -> {
                    // 分页查询数据
                    return list;
                });
        //创建输入流
        try(InputStream is = new FileInputStream(fileName)){
            //创建字节数组
            byte[] bytes = new byte[is.available()];
            //将流读到字节数组中
            is.read(bytes);
            //创建HttpHeaders对象设置响应头信息
            MultiValueMap<String, String> headers = new HttpHeaders();
            //设置要下载方式以及下载文件的名字
            headers.add("Content-Disposition", "attachment;filename=proctor_.xlsx");
            //设置响应状态码
            HttpStatus statusCode = HttpStatus.OK;
            //创建ResponseEntity对象
            ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers,statusCode);
            return responseEntity;
        }
    }
    public String proctorUpload(@RequestParam MultipartFile file) throws IOException {
        // 写法1：JDK8+ ,不用额外写一个DemoDataListener
        // since: 3.0.0-beta1
        String fileName = "D:\\重装前桌面代码内容\\暑期实训_1\\ncre_Upload\\"+ "proctor_" + ".xlsx";
        try(OutputStream out = new FileOutputStream(fileName)){
            out.write(file.getBytes());
            out.flush();
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
    }
    @Autowired
    ExamRoomDAO examRoomDAO;
    public ResponseEntity<byte[]> examRoomDown(HttpSession session) throws
            IOException {

        List<ExamRoom> list= examRoomDAO.selectAll();
        String fileName = "D:\\重装前桌面代码内容\\暑期实训_1\\ncre_Download\\"+ "examRoom_" + ".xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(fileName, ExamRoom.class)
                .sheet("模板")
                .doWrite(() -> {
                    // 分页查询数据
                    return list;
                });
        //创建输入流
        try(InputStream is = new FileInputStream(fileName)){
            //创建字节数组
            byte[] bytes = new byte[is.available()];
            //将流读到字节数组中
            is.read(bytes);
            //创建HttpHeaders对象设置响应头信息
            MultiValueMap<String, String> headers = new HttpHeaders();
            //设置要下载方式以及下载文件的名字
            headers.add("Content-Disposition", "attachment;filename=examRoom_.xlsx");
            //设置响应状态码
            HttpStatus statusCode = HttpStatus.OK;
            //创建ResponseEntity对象
            ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers,statusCode);
            return responseEntity;
        }
    }
    public String examRoomUpload(@RequestParam MultipartFile file) throws IOException {
        // 写法1：JDK8+ ,不用额外写一个DemoDataListener
        // since: 3.0.0-beta1
        String fileName = "D:\\重装前桌面代码内容\\暑期实训_1\\ncre_Upload\\"+ "examRoom_" + ".xlsx";
        try(OutputStream out = new FileOutputStream(fileName)){
            out.write(file.getBytes());
            out.flush();
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
    }
    @Autowired
    UserDAO userDAO;
    public ResponseEntity<byte[]> userDown() throws
            IOException {

        List<User> list= userDAO.selectAll();
        String fileName = "D:\\重装前桌面代码内容\\暑期实训_1\\ncre_Download\\"+ "user_" + ".xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(fileName, User.class)
                .sheet("模板")
                .doWrite(() -> {
                    // 分页查询数据
                    return list;
                });
        //创建输入流
        try(InputStream is = new FileInputStream(fileName)){
            //创建字节数组
            byte[] bytes = new byte[is.available()];
            //将流读到字节数组中
            is.read(bytes);
            //创建HttpHeaders对象设置响应头信息
            MultiValueMap<String, String> headers = new HttpHeaders();
            //设置要下载方式以及下载文件的名字
            headers.add("Content-Disposition", "attachment;filename=user_.xlsx");
            //设置响应状态码
            HttpStatus statusCode = HttpStatus.OK;
            //创建ResponseEntity对象
            ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers,statusCode);
            return responseEntity;
        }
    }
    public String userUpload(@RequestParam MultipartFile file) throws IOException {
        // 写法1：JDK8+ ,不用额外写一个DemoDataListener
        // since: 3.0.0-beta1
        String fileName = "D:\\重装前桌面代码内容\\暑期实训_1\\ncre_Upload\\"+ "user_" + ".xlsx";
        try(OutputStream out = new FileOutputStream(fileName)){
            out.write(file.getBytes());
            out.flush();
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
    }
    @Autowired
    ExamRoomExamDAO examRoomExamDAO;
    public ResponseEntity<byte[]> examRoomExamDown() throws
            IOException {

        List<ExamRoomExam> list= examRoomExamDAO.selectAll();
        String fileName = "D:\\重装前桌面代码内容\\暑期实训_1\\ncre_Download\\"+ "examRoomExam_" + ".xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(fileName, ExamRoomExam.class)
                .sheet("模板")
                .doWrite(() -> {
                    // 分页查询数据
                    return list;
                });
        //创建输入流
        try(InputStream is = new FileInputStream(fileName)){
            //创建字节数组
            byte[] bytes = new byte[is.available()];
            //将流读到字节数组中
            is.read(bytes);
            //创建HttpHeaders对象设置响应头信息
            MultiValueMap<String, String> headers = new HttpHeaders();
            //设置要下载方式以及下载文件的名字
            headers.add("Content-Disposition", "attachment;filename=examRoomExam_.xlsx");
            //设置响应状态码
            HttpStatus statusCode = HttpStatus.OK;
            //创建ResponseEntity对象
            ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers,statusCode);
            return responseEntity;
        }
    }
    public String examRoomExamUpload(@RequestParam MultipartFile file) throws IOException {
        // 写法1：JDK8+ ,不用额外写一个DemoDataListener
        // since: 3.0.0-beta1
        String fileName = "D:\\重装前桌面代码内容\\暑期实训_1\\ncre_Upload\\"+ "examRoomExam_" + ".xlsx";
        try(OutputStream out = new FileOutputStream(fileName)){
            out.write(file.getBytes());
            out.flush();
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
    }
    @Autowired
    EreProctorsDAO ereProctorsDAO;
    public ResponseEntity<byte[]> ereProctorDown() throws
            IOException {

        List<EreProctors> list= ereProctorsDAO.selectAll();
        //以下为list转化为excel表格的逻辑

        List<EreProctorsExcel> ereProctorsExcelList = new ArrayList<>();
        for (EreProctors ereProctor:list
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
            for (Proctor proctor:ereProctor.getProctors()
                 ) {
                if(ereProctorsExcel.getProctor1()==null){
                    ereProctorsExcel.setProctor1(proctor);
                }else {
                    ereProctorsExcel.setProctor2(proctor);
                }
            }
            ereProctorsExcelList.add(ereProctorsExcel);
        }
        String fileName = "D:\\重装前桌面代码内容\\暑期实训_1\\ncre_Download\\"+ "ereProctor_" + ".xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(fileName, EreProctorsExcel.class)
                .sheet("模板")
                .doWrite(() -> {
                    // 分页查询数据
                    return ereProctorsExcelList;
                });
        //创建输入流
        try(InputStream is = new FileInputStream(fileName)){
            //创建字节数组
            byte[] bytes = new byte[is.available()];
            //将流读到字节数组中
            is.read(bytes);
            //创建HttpHeaders对象设置响应头信息
            MultiValueMap<String, String> headers = new HttpHeaders();
            //设置要下载方式以及下载文件的名字
            headers.add("Content-Disposition", "attachment;filename=ereProctor_.xlsx");
            //设置响应状态码
            HttpStatus statusCode = HttpStatus.OK;
            //创建ResponseEntity对象
            ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers,statusCode);
            return responseEntity;
        }
    }
    public ResponseEntity<byte[]> studentOfExamRoomDown(int examID,int examRoomID) throws
            IOException {
        List<Student> list= studentDAO.selectStudentOfExamRoom(examID,examRoomID);
        String fileName = "D:\\重装前桌面代码内容\\暑期实训_1\\ncre_Download\\"+ "studentOfExamRoom_" +examID+"_"+examRoomID+ ".xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(fileName, Student.class)
                .sheet("模板")
                .doWrite(() -> {
                    // 分页查询数据
                    return list;
                });
        //创建输入流
        try(InputStream is = new FileInputStream(fileName)){
            //创建字节数组
            byte[] bytes = new byte[is.available()];
            //将流读到字节数组中
            is.read(bytes);
            //创建HttpHeaders对象设置响应头信息
            MultiValueMap<String, String> headers = new HttpHeaders();
            //设置要下载方式以及下载文件的名字
            headers.add("Content-Disposition", "attachment;filename=studentOfExamRoom_"+examID+"_"+examRoomID+".xlsx");
            //设置响应状态码
            HttpStatus statusCode = HttpStatus.OK;
            //创建ResponseEntity对象
            ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers,statusCode);
            return responseEntity;
        }
    }
}
