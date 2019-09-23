package com.edu.controller;

import com.edu.pojo.Powers;
import com.edu.pojo.Student;
import com.edu.pojo.Users;
import com.edu.service.*;
import org.apache.catalina.connector.Response;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.security.auth.message.callback.PrivateKeyCallback;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @Auther: 王玺瑞
 * @Date: 2019/9/11 18:09
 * @Description:
 */
@Controller
public class UserController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private UserService userService;
    @Autowired
    private R_P_Service r_p_service;
    @Autowired
    private U_R_Service u_r_service;
    @Autowired
    private PowersService powersService;
    @Autowired
    private HttpSession session;
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String showLoginForm(){
        return "login";
    }
    @RequestMapping("Login2")
    public String loginshow(Users user, Model model){
        String userName=user.getUserName();
        String password=user.getPassword();
        session.setAttribute("user",user);
        if (userName.equals("") || password.equals("")){
            return "error";
        }
        try {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
            subject.login(token);
            if(subject.isAuthenticated()){
                return "redirect:qp";
            }
        }catch (AuthenticationException e){
            e.printStackTrace();
        }
        return "login";
    }
    @RequestMapping("qp")
    public  String outFind(Model model){
        Users user = (Users)session.getAttribute("user");
        String userName=user.getUserName();
        Users users=userService.findUserByName(userName);
        int userId=users.getUserId();
        int roleId=u_r_service.loadRidbyUid(userId);
        List<Integer> poId=r_p_service.loadPidByRid(roleId);
        List<Powers> power=powersService.loadPowerByPid(poId);
        model.addAttribute("power",power);
        return "main";
    }
    //用户退出时
    @RequestMapping("/logout")
    public String logout(){
        try {
            Subject subject = SecurityUtils.getSubject();
            //用户登录(清除用户在shiro中的驻留信息)
            subject.logout();
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:login";
    }
    //权限功能分离
    @RequestMapping("caozuo")
    public String caoZuo(String poName){
        //学生管理表单
        if (poName.equals("学生管理")){
            return "redirect:stuview";
        }
        //教师管理
        if (poName.equals("教师管理")){
            return "redirect:teaview";
        }
        //教务管理
        if (poName.equals("教务管理")){
            return "redirect:acaview";
        }
        //教师出勤
        if (poName.equals("教师出勤")){
            return "redirect:attview";
        }
        //学生出勤
        if (poName.equals("学生出勤")){
            return "redirect:Astuview";
        }
        //请假申请
        if (poName.equals("请假申请")){
            return "redirect:vacview";
        }
        //离职申请
        //薪资补助
        //后勤报销
        //人力申请
        //成绩管理
        //权限管理
        return "error";
    }
   /* @RequestMapping("stuview")
    public String stuview(Model model){
        String poName="学生管理";
        List<Student> stuall=studentService.loadAllStu();
        model.addAttribute("stuall",stuall);
        String stu=powersService.findAdressByName(poName);
        return stu;
    }*/
}
