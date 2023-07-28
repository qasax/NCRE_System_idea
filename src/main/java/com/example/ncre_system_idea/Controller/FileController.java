package com.example.ncre_system_idea.Controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.example.ncre_system_idea.DAO.ExamDAO;
import com.example.ncre_system_idea.DAO.StudentDAO;
import com.example.ncre_system_idea.pojo.Exam;
import com.example.ncre_system_idea.pojo.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.slf4j.Logger;
import com.alibaba.fastjson.JSON;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.List;

@Controller
@RequestMapping("/file")
@Slf4j
public class FileController {
    //头像上传
    @PostMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam MultipartFile file, HttpSession session) throws Exception{
        String imgName = session.getAttribute("loginName") +"_avatar"+".jpg";
        System.out.println(imgName);
        String imgFilePath="D:\\重装前桌面代码内容\\暑期实训_1\\uploadImg\\"+imgName;
        System.out.println(imgFilePath);
        OutputStream out = new FileOutputStream(imgFilePath);
        out.write(file.getBytes());
        out.flush();
        out.close();
        return "ok";
    }
    //返回前台头像
    @GetMapping(value = "/getImage",produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] getImage(HttpSession session) throws Exception {

        File file = new File("D:\\重装前桌面代码内容\\暑期实训_1\\uploadImg\\"+session.getAttribute("loginName") +"_avatar"+".jpg");
        FileInputStream inputStream = new FileInputStream(file);
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes, 0, inputStream.available());
        return bytes;
    }
    @Autowired
    ExamDAO examDAO;
    @RequestMapping("/examDown")//下载exam表格
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
        InputStream is = new FileInputStream(fileName);
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
        //关闭输入流
        is.close();
        return responseEntity;
    }
    @RequestMapping("/examUpload")
    @ResponseBody
    public String examUpload(@RequestParam MultipartFile file) throws IOException {
        // 写法1：JDK8+ ,不用额外写一个DemoDataListener
        // since: 3.0.0-beta1
        String fileName = "D:\\重装前桌面代码内容\\暑期实训_1\\ncre_Upload\\"+ "exam_" + ".xlsx";
        OutputStream out = new FileOutputStream(fileName);
        out.write(file.getBytes());
        out.flush();
        out.close();
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
    @RequestMapping("/studentDown")//下载exam表格
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
        InputStream is = new FileInputStream(fileName);
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
        //关闭输入流
        is.close();
        return responseEntity;
    }
    @RequestMapping("/studentUpload")
    @ResponseBody
    public String studentUpload(@RequestParam MultipartFile file) throws IOException {
        // 写法1：JDK8+ ,不用额外写一个DemoDataListener
        // since: 3.0.0-beta1
        String fileName = "D:\\重装前桌面代码内容\\暑期实训_1\\ncre_Upload\\"+ "student_" + ".xlsx";
        OutputStream out = new FileOutputStream(fileName);
        out.write(file.getBytes());
        out.flush();
        out.close();
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

