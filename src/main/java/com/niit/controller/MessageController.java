package com.niit.controller;

import com.niit.entity.Message;
import com.niit.entity.Notice;
import com.niit.service.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @description:
 * @author: zcq
 * @time: 2022/11/18 16:28
 */
@Controller
@RequestMapping("message")
public class MessageController {

    @Resource
    MessageService messageService;


    /**
     * 学生查询所有未申请的招聘信息
     *
     * @param model   模型
     * @param session 一场
     * @return {@link String}
     */
    @RequestMapping(value = "message_info")
    public String messageInfo(Model model, HttpSession session){
        String studentId = "";
        studentId = session.getAttribute("studentId").toString();
        //查询未申请过的招聘信息
        List<Message> allMessage = messageService.findAllMessage(studentId);
        model.addAttribute("messageList", allMessage);

        return "index/recruitment-hall";
    }
    /**
     * 管理员通过审核
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("/passMessage")
    public String passMessage(Model model, String id) {
        Message message = messageService.findMessageById(id);
        System.out.println("通过编号查找出来的通知"+id+message);
        message.setPass("是");
        messageService.updateMessage(message);
        System.out.println("这里是updateMessage里面的message"+message);
        return "redirect:/student/allStudent";
    }

    /**
     * 管理员驳回
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("/rejectMessage")
    public String rejectMessage(Model model, String id, HttpServletRequest request,HttpSession session) {
        Message message = messageService.findMessageById(id);
        System.out.println("通过编号查找出来的通知"+id+message);
        System.out.println("管理员的姓名"+session.getAttribute("admin"));
        //开始对notice表进行操作
        Notice notice = new Notice();
        //uuid生成主键
        String resumeId = UUID.randomUUID().toString();
        System.out.println("生成的uuid+++++++++"+resumeId);
        //生成通知时间
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
        System.out.println("生成的时间+"+date);

        notice.setNoticeId(resumeId);
        notice.setContent("未通过审批：");
        notice.setCause(request.getParameter("cause"));
        //获取messag
        notice.setUserId(message.getEmployerId());
        notice.setCreatedBy((String) session.getAttribute("admin"));
        notice.setNoticeTitle(message.getPosition());
        //2表示部门的通知
        notice.setType(2);
        notice.setCreatedAt(date);
        //执行添加Notice

        System.out.println("这里是updateMessage里面的message"+message);
        return "redirect:/student/allStudent";
    }


    @GetMapping("toAddMessage")
    public String toAddMessage(){

        return "index/post-job";
    }

    //增加通知
    @PostMapping("saveMessage")
//    @ResponseBody
    public String addMessage(Message message){

        messageService.addMessage(message);

        return "messageList";
//        id重复 格式不对
//
    }
    //跳转到通知列表
    @RequestMapping("toAllMessage")
    public String toAllStudent(){
        return "messageList";
    }
    @RequestMapping("allMessage")
    public String allStudent(Model model){

        List<Message> list =messageService.findAllMessage("121");

        model.addAttribute("list", list);
        System.out.println("从后端查出来的通知列表"+list);
        return "messageList";
    }
    @RequestMapping("/toUpdateMessage")
    public String toUpdateStudent(Model model, String id) {
        Message message = messageService.findMessageById(id);
        System.out.println("通过编号查找出来的通知"+id+message);
//        model.addAttribute("message",message);
////        return "bookList";
//        return "messageModify";
        messageService.updateMessage(message);
        System.out.println("这里是updateMessage里面的message"+message);
//        studentService.updateStudent(student);
//        Student student1 = studentService.findStudentById(student.getStudentId());
//        model.addAttribute("student1", student1);
        return "redirect:/message/allMessage";
    }
    //
    @RequestMapping("/updateMessage/{MessageId}")
    public String updateStudent(Message message) {
//        Message message = new Message();
//        message.setId(Integer.valueOf(request.getParameter("studentID")));
//        student.setName(request.getParameter("name"));
//        student.setPassword(request.getParameter("passWord"));
//        if (request.getParameter("age")!=""){
//            student.setAge(Integer.valueOf(request.getParameter("age")));
//        }

        messageService.updateMessage(message);
        System.out.println("这里是updateMessage里面的message"+message);
//        studentService.updateStudent(student);
//        Student student1 = studentService.findStudentById(student.getStudentId());
//        model.addAttribute("student1", student1);
        return "redirect:/message/allMessage";
    }

    /**
     * 发布工作
     *
     * @param message 招聘信息
     * @param session 会话
     * @return {@link String}
     */
    @RequestMapping(value = "post_job")
    public String postJob(Message message, HttpSession session){
        message.setPass("待审核");
        message.setMessageId(UUID.randomUUID().toString());
         String employerId = session.getAttribute("studentId").toString();
        System.out.println("");
         String name = session.getAttribute("name").toString();
         message.setEmployerId(Integer.parseInt(employerId));
         message.setEmployerName(name);
//        message.setEmployerId(Integer.parseInt("11211"));
//        message.setEmployerName("张三");



        messageService.addMessage(message);

        return "index/index1";
    }



}
