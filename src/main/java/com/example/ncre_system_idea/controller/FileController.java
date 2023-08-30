package com.example.ncre_system_idea.controller;

import com.example.ncre_system_idea.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpSession;
import java.io.*;

@Controller
@RequestMapping("/file")
@Slf4j
public class FileController {
    //头像上传
    /**
     * 用户头像的上传
     *
     * @return
     */
    @PostMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam MultipartFile file, HttpSession session) throws Exception {
        String imgName = session.getAttribute("loginName") + "_avatar" + ".jpg";
        System.out.println(imgName);
        String imgFilePath = "D:\\重装前桌面代码内容\\暑期实训_1\\uploadImg\\" + imgName;
        System.out.println(imgFilePath);
        try(OutputStream out = new FileOutputStream(imgFilePath)){
            out.write(file.getBytes());
            out.flush();
            return "ok";
        }
    }

    //返回前台头像
    /**
     * 向前台返回对应用户的头像
     *
     * @return
     */
    @GetMapping(value = "/getImage", produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] getImage(HttpSession session) throws Exception {

        File file = new File("D:\\重装前桌面代码内容\\暑期实训_1\\uploadImg\\" + session.getAttribute("loginName") + "_avatar" + ".jpg");
        try(FileInputStream inputStream = new FileInputStream(file)){

            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes, 0, inputStream.available());
            return bytes;
        }
    }

    @Autowired
    FileService fileService;
    /**
     * 为用户提供exam表对应表格下载
     *
     * @return
     */
    @RequestMapping("/examDown")//下载exam表格
    public ResponseEntity<byte[]> examDown() throws
            IOException {

        return fileService.examDown();
    }
    /**
     * 接受用户exam表格的上传，并且存入数据库
     *
     * @return
     */
    @RequestMapping("/examUpload")
    @ResponseBody
    public String examUpload(@RequestParam MultipartFile file) throws IOException {
        return fileService.examUpload(file);
    }

    @RequestMapping("/studentDown")//下载exam表格
    public ResponseEntity<byte[]> studentDown() throws
            IOException {
        return fileService.studentDown();
    }
    @RequestMapping("/studentUpload")
    @ResponseBody
    public String studentUpload(@RequestParam MultipartFile file) throws IOException {
        return fileService.studentUpload(file);
    }

    @RequestMapping("/proctorDown")//下载exam表格
    public ResponseEntity<byte[]> proctorDown() throws
            IOException {
        return fileService.proctorDown();
    }

    @RequestMapping("/proctorUpload")
    @ResponseBody
    public String proctorUpload(@RequestParam MultipartFile file) throws IOException {
        return fileService.proctorUpload(file);
    }
    @RequestMapping("/examRoomDown")//下载exam表格
    public ResponseEntity<byte[]> examRoomDown() throws
            IOException {
        return fileService.examRoomDown();
    }

    @RequestMapping("/examRoomUpload")
    @ResponseBody
    public String examRoomUpload(@RequestParam MultipartFile file) throws IOException {
        return fileService.examRoomUpload(file);
    }
    @RequestMapping("/userDown")//下载exam表格
    public ResponseEntity<byte[]> userDown() throws
            IOException {
        return fileService.userDown();
    }

    @RequestMapping("/userUpload")
    @ResponseBody
    public String userUpload(@RequestParam MultipartFile file) throws IOException {
        return fileService.userUpload(file);
    }
    @RequestMapping("/examRoomExamDown")//下载exam表格
    public ResponseEntity<byte[]> examRoomExamDown() throws
            IOException {
        return fileService.examRoomExamDown();
    }

    @RequestMapping("/examRoomExamUpload")
    @ResponseBody
    public String examRoomExamUpload(@RequestParam MultipartFile file) throws IOException {
        return fileService.examRoomExamUpload(file);
    }
    @RequestMapping("/ereProctorDown")//下载exam表格
    public ResponseEntity<byte[]> ereProctorDown() throws
            IOException {
        return fileService.ereProctorDown();
    }
    @RequestMapping("/studentOfExamRoomDown")//下载exam表格
    public ResponseEntity<byte[]> studentOfExamRoomDown(int examID,int examRoomID) throws
            IOException {
        return fileService.studentOfExamRoomDown(examID,examRoomID);
    }
}

