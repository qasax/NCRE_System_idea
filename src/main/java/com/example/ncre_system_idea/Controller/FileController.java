package com.example.ncre_system_idea.Controller;

import com.example.ncre_system_idea.Service.FileService;
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
    @PostMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam MultipartFile file, HttpSession session) throws Exception {
        String imgName = session.getAttribute("loginName") + "_avatar" + ".jpg";
        System.out.println(imgName);
        String imgFilePath = "D:\\重装前桌面代码内容\\暑期实训_1\\uploadImg\\" + imgName;
        System.out.println(imgFilePath);
        OutputStream out = new FileOutputStream(imgFilePath);
        out.write(file.getBytes());
        out.flush();
        out.close();
        return "ok";
    }

    //返回前台头像
    @GetMapping(value = "/getImage", produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] getImage(HttpSession session) throws Exception {

        File file = new File("D:\\重装前桌面代码内容\\暑期实训_1\\uploadImg\\" + session.getAttribute("loginName") + "_avatar" + ".jpg");
        FileInputStream inputStream = new FileInputStream(file);
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes, 0, inputStream.available());
        return bytes;
    }

    @Autowired
    FileService fileService;

    @RequestMapping("/examDown")//下载exam表格
    public ResponseEntity<byte[]> examDown(HttpSession session) throws
            IOException {

        return fileService.examDown(session);
    }

    @RequestMapping("/examUpload")
    @ResponseBody
    public String examUpload(@RequestParam MultipartFile file) throws IOException {
        return fileService.examUpload(file);
    }

    @RequestMapping("/studentDown")//下载exam表格
    public ResponseEntity<byte[]> studentDown(HttpSession session) throws
            IOException {
        return fileService.studentDown(session);
    }
    @RequestMapping("/studentUpload")
    @ResponseBody
    public String studentUpload(@RequestParam MultipartFile file) throws IOException {
        return fileService.studentUpload(file);
    }

    @RequestMapping("/proctorDown")//下载exam表格
    public ResponseEntity<byte[]> proctorDown(HttpSession session) throws
            IOException {
        return fileService.proctorDown(session);
    }

    @RequestMapping("/proctorUpload")
    @ResponseBody
    public String proctorUpload(@RequestParam MultipartFile file) throws IOException {
        return fileService.proctorUpload(file);
    }
    @RequestMapping("/examRoomDown")//下载exam表格
    public ResponseEntity<byte[]> examRoomDown(HttpSession session) throws
            IOException {
        return fileService.examRoomDown(session);
    }

    @RequestMapping("/examRoomUpload")
    @ResponseBody
    public String examRoomUpload(@RequestParam MultipartFile file) throws IOException {
        return fileService.examRoomUpload(file);
    }

}

