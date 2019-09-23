package com.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: 王玺瑞
 * @Date: 2019/9/11 18:10
 * @Description:
 */
@Controller
public class ViewController {
    @RequestMapping("opop")
    public String opop(){
        return "login";
    }
    @RequestMapping("welcomeview")
    public String welcomeview(){
        return "welcome";
    }
    @RequestMapping("addStuview")
    public String addStuview(){
        return "addStu";
    }
    @RequestMapping("addTeaview")
    public String addTeaview(){
        return "addTea";
    }
    @RequestMapping("addAcaview")
    public String addAcaview(){
        return "addAca";
    }
    @RequestMapping("addAttview")
    public String addAttview(){
        return "addAtt";
    }
    @RequestMapping("addAStuview")
    public String addAStuview(){
        return "addAStu";
    }
    @RequestMapping("addVacview")
    public String addVacview(){
        return "addVac";
    }
}
