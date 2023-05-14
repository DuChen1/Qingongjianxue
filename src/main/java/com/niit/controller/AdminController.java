package com.niit.controller;

import com.niit.entity.Admin;
import com.niit.entity.Student;
import com.niit.service.AdminService;
import com.niit.service.StudentService;
import com.niit.service.impl.AdminServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;


/**
 * @description:
 * @author: ASUS
 * @time: 2022/11/18 16:28
 */
@Controller
@RequestMapping("/admin")
public class AdminController {


    @Resource
    AdminService adminService;
    //跳转修改密码界面
    @RequestMapping("/jumpAdminUpdate")
    public String jumpAdminUpdate() throws Exception {
        return "back-end/modify-pwd";
    }


    //修改密码
    @RequestMapping("/adminUpdate")
    public String adminUpdate(HttpSession session) throws Exception {

        session.invalidate();
        return "back-end/modify-pwd";
    }
    //跳转登陆界面
    @RequestMapping("/jumpAdminLogin")
    public String jumpAdminLogin() throws Exception {
        return "back-end/login";
    }
    //进行登陆验证
    @RequestMapping("/adminLogin")
    public String adminLogin(Model model,String adminUsername,String pwd,HttpSession session) throws Exception {
        //判断是否输入为空
        if (adminUsername.equals("")){
            session.setAttribute("message","请输入管理员账号");
            return "back-end/login";
        }

        Admin admin = adminService.findAdminById(Integer.parseInt(adminUsername));
        System.out.println("从dao返回来的admin:"+admin);
        System.out.println(adminUsername+"*******前端传来的密码："+pwd);
        //第一种情况 查不出来
        if (admin==null){
            System.out.println("为空");
            session.setAttribute("message","管理员不存在");
            return "back-end/login";
        }
        //第二种情况  登陆成功
        if (admin.getAssessorId().equals(Integer.parseInt(adminUsername))&&admin.getPassword().equals(pwd)){
            System.out.println("从数据里查到该用户啦~");
            session.setAttribute("admin", admin.getName());
            return "redirect:/student/allStudent";
        }
        //第三情况 账户或密码错误
        else {
            System.out.println("最后一种情况");
            session.setAttribute("message","用户名或密码错误");
            return "back-end/login";
        }



    }
}
