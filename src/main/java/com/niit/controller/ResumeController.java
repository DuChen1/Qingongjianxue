package com.niit.controller;

import com.niit.entity.Resume;
import com.niit.entity.Student;
import com.niit.service.ResumeService;
import com.niit.service.StudentService;
import com.niit.service.impl.ResumeServiceImpl;
import com.niit.service.impl.StudentServiceImpl;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.UUID;

/**
 * 类描述: 简历控制层
 * 点击申请时：①后台获取message数据的id②页面显示当前学生基本数据（student)③转发到apply页面
 * 点击提交时：执行controller层的add方法，存入数据库，同时pass为 否
 *
 * 活动记录：①标题为：messageTitle,createdAt 内容为简历信息
 *          ②查询当前用户所有的简历，查询简历对应的message部分内容（时间去掉）
 */
@Controller
@RequestMapping(value = "resume")
public class ResumeController {
    ResumeService resumeService = new ResumeServiceImpl();
    StudentService studentService = new StudentServiceImpl();

    /**
     * 管理员审核学生简历check student 2023/6/23
     */
    @RequestMapping(value = "checkResume")
    public String emoloyerPassResume(Model model, HttpSession session,String resumeId,String flag) {
        System.out.println("这里是Resume Controller 中的pass_stu中的flag" + flag);
        System.out.println("这里是Resume Controller 中的pass_stu中的Resumeid" + resumeId  );
//        这里，1为通过，0为不通过
        resumeService.updateResumePassOrNot(resumeId,flag);

        return "redirect:/notice/employerAllMessages";
    }
    /**
     * 管理员查询对应岗位的全部学生简历check student 2023/6/23
     */
    @RequestMapping(value = "check_stu")
    public String emoloyerCheckResume(Model model, HttpSession session, String messageId) {
        System.out.println("这里是Resume Controller 中的check_stu中的messageid" + messageId);
//        这里是根据messageId查询出所有的简历
        List<Resume> allResume = resumeService.findAllResumeByMessageId(messageId);
        model.addAttribute("resumeList", allResume);
        return "index/recruitment-checkstu";
    }
    /**
     * 显示学生信息
     *
     * @param model   模型
     * @param session session会话
     * @return {@link Model}
     */
    @RequestMapping(value = "stu_info")
    public String showStuInfo(Model model, HttpSession session, String messageId) {
        int studentId = 0;
        studentId = Integer.parseInt(session.getAttribute("studentId").toString());
        session.setAttribute("messageId",messageId);
        // Student student = studentService.findStudentById(studentId);
        Student student = studentService.findStudentById(studentId);
        if (student != null) {
            model.addAttribute("studentId", student.getStudentId());
            model.addAttribute("name", student.getName());
            model.addAttribute("sex", student.getSex());
            model.addAttribute("age", student.getAge());
            model.addAttribute("college", student.getCollege());
            model.addAttribute("phone", student.getPhone());
            model.addAttribute("speciality", student.getSpeciality());
        }
        return "index/apply";
    }

    /**
     * 添加简历
     *
     * @param resume   简历

     * @return {@link String}
     */
    @RequestMapping(value = "add")
    public String addResume(Resume resume, HttpSession session) {
        String messageId = session.getAttribute("messageId").toString();
        Integer studentId = resume.getStudentId();
        //uuid生成主键
        String resumeId = UUID.randomUUID().toString();
        System.out.println(messageId + " " + studentId + " " + resumeId);
        //中间表记录
        resumeService.addRecord(messageId, resumeId, studentId);
        // 页面获取数据，保存数据库
        //设置主键
        resume.setResumeId(resumeId);
        resume.setPass("待审核");
        // resume.setPass("否");
        resumeService.addResume(resume);

        return "index/index";
    }

    @RequestMapping(value = "all_resume")
    public String allResume(Model model, HttpSession session){
        //获取当前登录用户
        String studentId = session.getAttribute("studentId").toString();
        //查询当前用户申请过的所有职位
        List<Resume> allResume = resumeService.findAllResume(studentId);
        List<String> allPosition = resumeService.findAllPosition(studentId);
        model.addAttribute("positions",allPosition);
        model.addAttribute("resumes",allResume);

        return "index/resume";
    }


    // public String findAll

    @RequestMapping(value = "to_resume")
    public String toResume() {
        return "index/resume";
    }


    @RequestMapping(value = "to_home")
    public String home() {
        return "index/index";
    }


}
