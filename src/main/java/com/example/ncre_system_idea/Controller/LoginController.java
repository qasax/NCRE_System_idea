package com.example.ncre_system_idea.Controller;

import com.example.ncre_system_idea.tils.IdentifyCodeUtils;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.image.BufferedImage;
import java.util.Objects;

@Controller
@CrossOrigin
public class LoginController {

    @GetMapping("/identifyImage")
    @ResponseBody
    public void identifyImage(HttpServletResponse response, HttpSession session){
        //创建随机验证码
        IdentifyCodeUtils utils = new IdentifyCodeUtils();
        String identifyCode = utils.getIdentifyCode();
        //session存入验证码
        session.setAttribute("identifyCode", identifyCode);
        //根据验证码创建图片
        BufferedImage identifyImage = utils.getIdentifyImage(identifyCode);
        //回传给前端
        utils.responseIdentifyImg(identifyImage,response);

    }


    @RequestMapping("/sessionState")
    @ResponseBody
    public boolean login(HttpSession session){
        System.out.println(session.getAttribute("isLoginStatus"));
        if(session.getAttribute("isLoginStatus")!= null) {
            return (boolean) session.getAttribute("isLoginStatus");
        }
        return false;
    }
    @RequestMapping("/logout")
    @ResponseBody
    public String logout(HttpSession session){
        session.setAttribute("isLoginStatus",false);
        session.invalidate();
        return "ok";
    }
}
