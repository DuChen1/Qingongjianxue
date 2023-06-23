package com.niit.controller;

import com.niit.entity.Employer;
import com.niit.entity.Student;
import com.niit.service.EmployerService;
import com.niit.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @description:
 * @author: ASUS
 * @time: 2022/11/18 16:28
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Resource
    StudentService studentService;
    @Resource
    EmployerService employerService;

    @GetMapping("toListDemo")
    public String toListDemo(){
        return "listDemo";
    }

    @GetMapping("toAddStudent")
    public String toAddStudent() {

        return "back-end/reg";
    }

    @RequestMapping("destory")
    public String destorySession(HttpSession session){
        session.invalidate();
        return "back-end/login";

    }

    @PostMapping("saveStudent")
    public String addStudnt(Student student) {

        studentService.addStudent(student);
//        判断一下有没有添加成功

        return "back-end/login";
//        id重复 格式不对
//
    }

    //跳转到登陆页面
    @RequestMapping("/toStudentLogin")
    public String jumpLogin() throws Exception {
        return "back-end/login";
    }

    @RequestMapping("/studentLogin")
    public String studentLogin(HttpSession session,String username,String pwd,HttpServletRequest request) {
        System.out.println("密码是：");
        System.out.println(pwd);

        if (username.equals("")){
            session.setAttribute("message","请输入用户名");
            return "back-end/login";
        }
        if (pwd.equals("")){
            session.setAttribute("message","请输入密码");
            return "back-end/login";
        }
        //验证学生登陆
        Student student = studentService.findStudentById(Integer.valueOf(username));
        Employer employer = employerService.findEmployerById(Integer.valueOf(username));
        int id = Integer.valueOf(username);
//        String pwd = request.getParameter("passWord");
        System.out.println("前端传来的student" + student);
        //判断是否为学生
        if (student== null) {
            //如果不是学生，判断是否为部门
            if (employer== null){
            session.setAttribute("message", "用户名不存在");
            return "back-end/login";}
            if (employer.getEmployerId().equals(id)&&employer.getPassword().equals(pwd)){
                System.out.println("部门验证通过");
                session.setAttribute("name",employer.getEmployerName());
                session.setAttribute("employerId",employer.getEmployerId());
                return "index/index1";
            }
            else {
                System.out.println("最后一种情况");
                session.setAttribute("message", "用户名或密码错误,请重新输入");
                return "back-end/login";
            }
        }
        if (student.getStudentId().equals(id) && student.getPassword().equals(pwd)) {
            System.out.println("学生验证通过！");
            session.setAttribute("name",student.getName());
            session.setAttribute("studentId",student.getStudentId());
            return "index/index";
        } else {
            System.out.println("最后一种情况");
            session.setAttribute("message", "用户名或密码错误,请重新输入");
            return "back-end/login";
        }


    }
}
