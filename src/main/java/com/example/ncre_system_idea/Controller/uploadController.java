package com.example.ncre_system_idea.Controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.UUID;

@Controller
@CrossOrigin(origins = {"http://localhost:8088","http://localhost:8089"})
@RequestMapping("/file")
public class uploadController {
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
}

