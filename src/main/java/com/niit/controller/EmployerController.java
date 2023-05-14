package com.niit.controller;

import com.niit.entity.Employer;
import com.niit.service.EmployerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @description:
 * @author: ASUS
 * @time: 2022/11/18 16:28
 */
@Controller
@RequestMapping("employer")
public class EmployerController {

    @Resource
    EmployerService employerService;



    @GetMapping("toAddEmployer")
    public String toAddEmployer(){

        return "back-end/add-employer";
    }


    @PostMapping("saveEmployer")
    public String addStudnt(Employer employer){
//        Employer employer = new Employer();
//        employer.setName(request.getParameter("name"));
//        employer.setEmployerId(Integer.valueOf(request.getParameter("employerID")));
//        employer.setPassword(request.getParameter("passWord"));
//        employer.setAge(Integer.valueOf(request.getParameter("age")));
        System.out.println("前端传来的employer"+employer);
        employerService.addEmployer(employer);
//        判断一下有没有添加成功

        return "redirect:/employer/allEmployer";
//        id重复 格式不对
//
    }

    @GetMapping("toAllEmployer")
    public String toAllEmployer(){
        return "employerList";
    }
    @GetMapping("allEmployer")
    public String allEmployer(Model model){

        List<Employer> list =employerService.findAllEmployer();

        model.addAttribute("list1", list);
        System.out.println("从后端查出来的部门列表"+list);
        return "back-end/employer";
    }
    @RequestMapping("/toUpdateEmployer")
    public String toUpdateEmployer(Model model, int id) {
        Employer employer = employerService.findEmployerById(id);
        System.out.println("通过学号查找出来的部门"+id+employer);
        model.addAttribute("employer",employer);
//        return "bookList";
        return "back-end/update-employer";
    }

    @RequestMapping("/updateEmployer")
    public String updateEmployer(HttpServletRequest request,Employer employer) {


        employerService.updateEmployer(employer);
        System.out.println("这里是updateemployer里面的employer"+employer);
//        employerService.updateEmployer(employer);
//        Employer employer1 = employerService.findEmployerById(employer.getEmployerId());
//        model.addAttribute("employer1", employer1);
        return "redirect:/employer/allEmployer";
    }


    @RequestMapping("/del/{EmployerId}")
    public String deleteEmployer(@PathVariable("EmployerId") int id) {
        employerService.deleteEmployer(id);
        return "redirect:/employer/allEmployer";
    }



}
