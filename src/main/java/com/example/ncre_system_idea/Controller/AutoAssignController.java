package com.example.ncre_system_idea.Controller;

import com.example.ncre_system_idea.Service.AutoAssignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin(origins = "http://localhost:8088", allowCredentials = "true")
@RequestMapping("/autoAssignController")
public class AutoAssignController {
    @Autowired
    AutoAssignService autoAssignService;
    @RequestMapping("/autoAssignStudent")
    @ResponseBody
    public String autoAssign(){
        return     autoAssignService.AutoAssignStudent();

    }
    @RequestMapping("/autoAssignProctor")
    @ResponseBody
    public List<String> AutoAssignProctor(){
        return  autoAssignService.AutoAssignProctor();
    }
}
