package com.example.ncre_system_idea.Controller;

import com.example.ncre_system_idea.Service.LoginService;
import com.example.ncre_system_idea.pojo.LoginBody;
import com.example.ncre_system_idea.pojo.User;
import com.example.ncre_system_idea.Utils.AesUtil;
import com.example.ncre_system_idea.Utils.IdentifyCodeUtils;

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
    public void identifyImage(HttpServletResponse response, HttpSession session) {//创建随机验证码
        IdentifyCodeUtils utils = new IdentifyCodeUtils();
        String identifyCode = utils.getIdentifyCode();
        //session存入验证码
        session.setAttribute("identifyCode", identifyCode);
        System.out.println("sessionId" + session.getId());
        //根据验证码创建图片
        BufferedImage identifyImage = utils.getIdentifyImage(identifyCode);
        //回传给前端
        utils.responseIdentifyImg(identifyImage, response);

    }

    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestBody LoginBody loginBody, HttpSession session) {
        System.out.println("用户名:" + loginBody.getLoginName());
        System.out.println("密码:" + loginBody.getPassword());
        System.out.println("验证码:" + loginBody.getIdentifyCode());
        //从session中取出验证码
        String sessionCode = (String) session.getAttribute("identifyCode");
        System.out.println("session中验证码:" + sessionCode);
        System.out.println("sessionId" + session.getId());
        if (loginBody.getIdentifyCode().equalsIgnoreCase(sessionCode)) {
            System.out.println("验证码正确");
            //进行登录判断的逻辑大家自己写，这里就不演示了
            User user = loginService.selectOne(loginBody.getLoginName());
            System.out.println("本次为"+loginBody.getUserType()+"登录");
            System.out.println("登录的用户账户类型是："+user.getUserType()+"账户");
            System.out.println(!loginBody.getUserType().equals(user.getUserType()));
            if (user != null) {//在java中，字符串的值进行对比必须使用equals，在javascript中则使用===即可
                if ( "admin".equals(loginBody.getUserType()) && loginBody.getUserType().equals(user.getUserType())) {//说明是管理员后台登录，而且账户类型是管理员，回应请求
                    String realpassword = AesUtil.decryptAes(user.getPassword(), user.getAesKey());//对数据库中的密码进行解密，获取真正的密码以进行比对
                    if (Objects.equals(realpassword, loginBody.getPassword())) {
                        session.setAttribute("isLoginStatus", true);
                        session.setAttribute("loginName", loginBody.getLoginName());
                        session.setAttribute("userType", user.getUserType());
                        session.setAttribute("password", loginBody.getPassword());
                        System.out.println(1);
                        return "登录成功";
                    } else {//与数据库中进行密码验证时发生错误
                        return "用户名或密码错误";
                    }
                } else if ("admin".equals(loginBody.getUserType())  && !loginBody.getUserType().equals(user.getUserType())) {//说明是管理员后台登录，但是登录的账户类型不是管理员，拒绝请求
                    return "用户名或密码错误";
                } else if (!"admin".equals(user.getUserType())) {//以上两个条件不满足的条件下，而且登录用户的类型不是admin，说明是考生或监考员前台申请登录，同意请求
                    String realpassword = AesUtil.decryptAes(user.getPassword(), user.getAesKey());//对数据库中的密码进行解密，获取真正的密码以进行比对
                    if (Objects.equals(realpassword, loginBody.getPassword())) {
                        session.setAttribute("isLoginStatus", true);
                        session.setAttribute("loginName", loginBody.getLoginName());
                        session.setAttribute("userType", user.getUserType());
                        session.setAttribute("password", loginBody.getPassword());
                        System.out.println(2);
                        return "登录成功";
                    } else {//与数据库中进行密码验证时发生错误
                        return "用户名或密码错误";
                    }
                } else {//此时说明考生或监考员前台登录了管理员账户，拒绝请求
                    return "用户名或密码错误";
                }

            } else {
                return "用户名或密码错误";
            }
        } else {
            System.out.println("验证码错误");
            //重定向到登录画面
            return "验证码错误";
        }

    }

    @RequestMapping("/sessionState")
    @ResponseBody
    public boolean login(HttpSession session) {
        System.out.println("是否处于登录状态" + session.getAttribute("isLoginStatus"));
        if (session.getAttribute("isLoginStatus") != null) {
            return (boolean) session.getAttribute("isLoginStatus");
        }
        return false;
    }

    @RequestMapping("/logout")
    @ResponseBody
    public String logout(HttpSession session) {
        session.setAttribute("isLoginStatus", false);
        session.invalidate();
        return "ok";
    }

    @RequestMapping("/getSessionUser")
    @ResponseBody
    public User getSessionUser(HttpSession session) {
        User user = new User();
        user.setUsername((String) session.getAttribute("loginName"));
        user.setUserType((String) session.getAttribute("userType"));
        user.setPassword((String) session.getAttribute("password"));
        return user;
    }
}
