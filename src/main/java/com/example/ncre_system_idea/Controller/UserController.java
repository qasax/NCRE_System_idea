package com.example.ncre_system_idea.Controller;

import com.example.ncre_system_idea.Service.UserService;
import com.example.ncre_system_idea.pojo.User;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin(origins = "http://localhost:8088", allowCredentials = "true")
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("/allUser")
    @ResponseBody
    public PageInfo<User> selectALL(int pageNum, int pageSize, String sortProp, String sortOrder, boolean isSearch, String optionValue, String searchValue){

        return userService.selectAll(pageNum,pageSize,sortProp,sortOrder,isSearch,optionValue,searchValue);
    }
    @RequestMapping("/deleteOne")
    @ResponseBody
    public String deleteOne(int userID){

        return userService.deleteOne(userID);
    }
    @RequestMapping("/update")
    @ResponseBody
    public String update(@RequestBody User user){

        return userService.update(user);
    }
    @RequestMapping("/addOne")
    @ResponseBody
    public String addOne(@RequestBody User user){

        return userService.addOne(user);
    }
}
