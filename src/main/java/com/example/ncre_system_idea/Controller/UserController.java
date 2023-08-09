package com.example.ncre_system_idea.Controller;

import com.example.ncre_system_idea.Service.UserService;
import com.example.ncre_system_idea.pojo.Proctor;
import com.example.ncre_system_idea.pojo.Student;
import com.example.ncre_system_idea.pojo.User;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    /**
     * 查询全部用户
     *分页查询，关键词查询，排序
     * @return
     */
    @RequestMapping("/allUser")
    @ResponseBody
    public PageInfo<User> selectALL(int pageNum, int pageSize, String sortProp, String sortOrder, boolean isSearch, String optionValue, String searchValue){

        return userService.selectAll(pageNum,pageSize,sortProp,sortOrder,isSearch,optionValue,searchValue);
    }
    /**
     * 根据用户id，删除对应信息
     *
     * @return
     */
    @RequestMapping("/deleteOne")
    @ResponseBody
    public String deleteOne(int userID){

        return userService.deleteOne(userID);
    }
    /**
     * 根据用户id，更新某条信息
     *
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public String update(@RequestBody User user){

        return userService.update(user);
    }
    /**
     * 为用户表添加某条信息
     *
     * @return
     */
    @RequestMapping("/addOne")
    @ResponseBody
    public String addOne(@RequestBody User user){

        return userService.addOne(user);
    }
    /**
     * 查询在user表中没有对应信息的proctor
     *
     * @return
     */
    @RequestMapping("/findProctors")//寻找数据库中user表没有对应信息的proctor
    @ResponseBody
    public List<Proctor> findProctors(){

        return userService.findProctors();
    }
    /**
     * 查询在student表中没有对应信息的student
     *
     * @return
     */
    @RequestMapping("/findStudents")//寻找数据库中user表没有对应信息的Student
    @ResponseBody
    public List<Student> findStudents(){

        return userService.findStudents();
    }
    /**
     * 用户在注册时，查询是否存在重名用户
     *
     * @return
     */
    @RequestMapping("/selectUsername")
    @ResponseBody
    public int selectUsername(String username){

        return userService.selectUsername(username);
    }
    /**
     * 用户修改密码的api接口
     *
     * @return
     */
    @RequestMapping("/changPassword")
    @ResponseBody
    public int changPassword(@RequestBody User user){
        return userService.changPassword(user.getPassword(),user.getUsername());
    }
}
