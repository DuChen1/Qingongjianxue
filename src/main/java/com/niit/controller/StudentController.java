package com.niit.controller;

import com.niit.entity.MessageResume;
import com.niit.entity.MessageState;
import com.niit.entity.Student;
import com.niit.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @description:
 * @author: ASUS
 * @time: 2022/11/18 16:28
 */
@Controller
@RequestMapping("student")
public class StudentController {

    @Resource
    StudentService studentService;

    /**
     * 学生查询所有已经申请的招聘信息的状态 2023.6.23
     * @return
     */
    @GetMapping("allWork")
    public String allWork(Model model,HttpSession session){
        String studentId =session.getAttribute("studentId").toString();
        List<MessageState> list =studentService.findResumeStateByStudentId(studentId);
        System.out.println("这里要进行简历状态查询的学生id是"+studentId);
        for (MessageState messageState : list) {
            System.out.println("这是该学生简历的状态信息"+messageState);
        }
        return "index/index";
//        List<Student> list =studentService.findAllStudent();
//
//        model.addAttribute("list", list);
//        System.out.println("从后端查出来的学生列表"+list);
//        return "back-end/student";
    }

    @GetMapping("toAddStudent")
    public String toAddStudent(){

        return "back-end/add-student";
    }


    @PostMapping("saveStudent")
    public String addStudnt(Student student){

        System.out.println("前端传来的student"+student);
        studentService.addStudent(student);
//        判断一下有没有添加成功

        return "back-end/login";
//        id重复 格式不对
//
    }

    @GetMapping("toAllStudent")
    public String toAllStudent(){
        return "back-end/reg";
    }
    @GetMapping("allStudent")
    public String allStudent(Model model){

        List<Student> list =studentService.findAllStudent();

        model.addAttribute("list", list);
        System.out.println("从后端查出来的学生列表"+list);
        return "back-end/student";
    }
    @RequestMapping("/toUpdateStudent")
    public String toUpdateStudent(Model model, int id) {
        Student student = studentService.findStudentById(id);
        System.out.println("通过学号查找出来的学生"+id+student);
        model.addAttribute("student",student);
//        return "bookList";
        return "back-end/update-student";
    }

    @RequestMapping("/updateStudent")
    public String updateStudent(Student student) {


        studentService.updateStudent(student);
//        System.out.println("这里是updatestudent里面的student"+student);
//        studentService.updateStudent(student);
//        Student student1 = studentService.findStudentById(student.getStudentId());
//        model.addAttribute("student1", student1);
        return "redirect:/student/allStudent";
    }


    @RequestMapping("/del/{StudentId}")
    public String deleteStudent(@PathVariable("StudentId") int id) {
        studentService.deleteStudent(id);
        return "redirect:/student/allStudent";
    }

    //前端个人信息.
    @RequestMapping(value = "student_info")
    public String student(HttpSession session, Model model){
        String studentId = session.getAttribute("studentId").toString();
        //查询当前用户信息
        Student student = studentService.findStudentById(Integer.parseInt(studentId));
        model.addAttribute("studentId",student.getStudentId());
        model.addAttribute("name",student.getName());
        model.addAttribute("sex",student.getSex());
        model.addAttribute("age",student.getAge());
        model.addAttribute("college",student.getCollege());
        model.addAttribute("phone",student.getPhone());
        model.addAttribute("address",student.getAddress());
        model.addAttribute("speciality",student.getSpeciality());
        // model.addAttribute("student",student);
        return "index/personal_information";
    }

    @RequestMapping(value = "updateStudent_index")
    public String update(Student student){
        studentService.updateStudent(student);
        return "redirect:/student/student_info";
    }


}
