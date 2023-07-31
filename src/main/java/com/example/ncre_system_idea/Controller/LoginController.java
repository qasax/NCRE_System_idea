package com.example.ncre_system_idea.Controller;

import com.example.ncre_system_idea.Service.LoginService;
import com.example.ncre_system_idea.pojo.Admin;
import com.example.ncre_system_idea.pojo.LoginBody;
import com.example.ncre_system_idea.pojo.User;
import com.example.ncre_system_idea.tils.AesUtil;
import com.example.ncre_system_idea.tils.IdentifyCodeUtils;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.image.BufferedImage;
import java.util.Objects;

@Controller

public class LoginController {
@Autowired
    LoginService loginService;
    @GetMapping("/identifyImage")
    @ResponseBody//
    public void identifyImage(HttpServletResponse response, HttpSession session){//创建随机验证码
        IdentifyCodeUtils utils = new IdentifyCodeUtils();
        String identifyCode = utils.getIdentifyCode();
        //session存入验证码
        session.setAttribute("identifyCode", identifyCode);
        System.out.println("sessionId"+session.getId());
        //根据验证码创建图片
        BufferedImage identifyImage = utils.getIdentifyImage(identifyCode);
        //回传给前端
        utils.responseIdentifyImg(identifyImage,response);

    }
    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestBody LoginBody loginBody, HttpSession session){
        System.out.println("用户名:"+loginBody.getLoginName());
        System.out.println("密码:"+loginBody.getPassword());
        System.out.println("验证码:"+loginBody.getIdentifyCode());
        //从session中取出验证码
        String sessionCode = (String)session.getAttribute("identifyCode");
        System.out.println("session中验证码:"+sessionCode);
        System.out.println("sessionId"+session.getId());
        if (loginBody.getIdentifyCode().equalsIgnoreCase(sessionCode)){
            System.out.println("验证码正确");
            //进行登录判断的逻辑大家自己写，这里就不演示了
            User user=loginService.selectOne(loginBody.getLoginName());
            if(user!=null){
               String realpassword= AesUtil.decryptAes(user.getPassword(),user.getAesKey());//对数据库中的密码进行解密，获取真正的密码以进行比对
                if(Objects.equals(realpassword,loginBody.getPassword())){
                    session.setAttribute("isLoginStatus", true);
                    session.setAttribute("loginName",loginBody.getLoginName());
                    session.setAttribute("userType",user.getUserType());
                    session.setAttribute("password",loginBody.getPassword());
                    return "登录成功";
                }else {
                    return "用户名或密码错误";
                }
            }else {
                return "用户名或密码错误";
            }
        }else{
            System.out.println("验证码错误");
            //重定向到登录画面
            return "验证码错误";
        }

    }

    @RequestMapping("/sessionState")
    @ResponseBody
    public boolean login(HttpSession session){
        System.out.println("是否处于登录状态"+session.getAttribute("isLoginStatus"));
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
    @RequestMapping("/getUserName")
    @ResponseBody
    public User getUserName(HttpSession session){
            User user =new User();
            user.setUsername((String) session.getAttribute("loginName"));
            user.setUserType((String) session.getAttribute("userType"));
        return user;
    }
}
