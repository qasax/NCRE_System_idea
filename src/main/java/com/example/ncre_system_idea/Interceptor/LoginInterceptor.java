package com.example.ncre_system_idea.Interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * 登录检查
 * 1.配置到拦截器要拦截哪些请求
 * 2.把这些配置放在容器中
 *
 * 实现HandlerInterceptor接口
 */
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 目标方法执行之前
     * 登录检查写在这里，如果没有登录，就不执行目标方法
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//      获取进过拦截器的路径
        String requestURI = request.getRequestURI();
        System.out.println("拦截路径"+requestURI);
        //      登录检查逻辑
        HttpSession session = request.getSession();
        Object isLoginStatus =  session.getAttribute("isLoginStatus");
        Object userType = session.getAttribute("userType");
        System.out.println("拦截器判断用户是否登录"+isLoginStatus);
        if(isLoginStatus==null){//如果为null就说明该用户没有登录
            response.setContentType("application/json;charset=UTF-8");
            response.setStatus(401);
            response.getWriter().write("用户已经离线，请重新登录");
            System.out.println("拦截器拦截请求");
            return false;
        }
        //用户授权，限制不同类型用户所能访问的api
        if(Objects.equals(userType,"proctor")){
            //只能访问以下请求，其他请求拦截
            String[] proctorUrls = {
                    "/selectExamMsgByUsername",
                    "/autoAssignController/getSignUpOverStatus",
                    "/user/changPassword",
                    "/selectProctorByUsername"
            };

            for (String url : proctorUrls) {
                if (Objects.equals(requestURI, url)) {
                }else {
                    response.setContentType("application/json;charset=UTF-8");
                    response.setStatus(401);
                    response.getWriter().write("没有访问权限！");
                    System.out.println("拦截器拦截无权限请求"+requestURI);
                    return false;
                }
            }
        }
        if(Objects.equals(userType,"student")){
            String[] studentUrls = {
                    "/student/selectStudentByUsername",
                    "/student/updateStudent",
                    "/autoAssignController/getSignUpOverStatus",
                    "/autoAssignController/getSignUpStatus",
                    "/student/getIsSignUp",
                    "/student/selectSingUpOverStudent",
                    "/exam/selectAllExam"
            };

            for (String url : studentUrls) {
                if (Objects.equals(requestURI, url)) {
                }else{
                    response.setContentType("application/json;charset=UTF-8");
                    response.setStatus(401);
                    response.getWriter().write("没有访问权限！");
                    System.out.println("拦截器拦截无权限请求"+requestURI);
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 目标方法执行完成以后
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    /**
     * 页面渲染以后
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}