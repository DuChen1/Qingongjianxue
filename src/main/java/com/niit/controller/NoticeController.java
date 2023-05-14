package com.niit.controller;

import com.niit.entity.Message;
import com.niit.entity.Notice;
import com.niit.entity.Resume;
import com.niit.entity.Student;
import com.niit.service.MessageService;
import com.niit.service.NoticeService;
import com.niit.service.ResumeService;
import com.niit.service.impl.ResumeServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @description:
 * @author: ASUS
 * @time: 2022/11/18 16:28
 */
@Controller
@RequestMapping("notice")
public class NoticeController {
    @Resource
    MessageService messageService;
    @Resource
    NoticeService noticeService;
//    @Resource
    ResumeService resumeService = new ResumeServiceImpl();

    @RequestMapping("adminAllNotices")
    public String allNotice(Model model){
        List<Message> list =noticeService.adminFindAllMessage();

        model.addAttribute("list", list);
        System.out.println("从后端查出来的管理员message列表"+list);
        return "back-end/info-check";
    }
    /**
     * 管理员通过审核
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("/adminPassMessage")
    public String passMessage(Model model,  String id, HttpSession session) {
        Message message = messageService.findMessageById(id);
        System.out.println("通过编号查找出来的通知"+id+message);
        message.setPass("是");
        messageService.updateMessage(message);
        System.out.println("这里是adminPassMessage里面的message"+message);
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
        notice.setContent("通过审批");
        //获取messag
        notice.setUserId(message.getEmployerId());
        notice.setCreatedBy((String) session.getAttribute("admin"));
        notice.setNoticeTitle(message.getPosition());
        //2表示部门的通知
        notice.setType(2);
        notice.setCreatedAt(date);
        //执行添加Notice
        noticeService.addNotice(notice);
        return "redirect:/notice/adminAllNotices";
    }

    /**
     * 管理员驳回
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("/adminRejectMessage")
    public String rejectMessage(Model model, String id, HttpServletRequest request,HttpSession session) {
        Message message = messageService.findMessageById(id);
        System.out.println("通过编号查找出来的通知"+id+message);
        message.setPass("否");
        messageService.updateMessage(message);


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
        noticeService.addNotice(notice);

        System.out.println("这里是updateMessage里面的message"+message);
        return "redirect:/notice/adminAllNotices";
    }

//    /**
//     * 部门通过简历审核
//     * @param model
//     * @param id
//     * @return
//     */
//    @RequestMapping("/passResume")
//        public String passResume(Model model,  String id, HttpSession session) {
//        Resume resume = resumeService.findResumeById(id);
//        System.out.println("通过编号查找出来的通知"+id+resume);
//        resume.setPass("是");
//        resumeService.updateResume(resume);
//        System.out.println("这里是adminPassMessage里面的message"+resume);
//        //开始对notice表进行操作
//        Notice notice = new Notice();
//        //uuid生成主键
//        String resumeId = UUID.randomUUID().toString();
//        System.out.println("生成的uuid+++++++++"+resumeId);
//        //生成通知时间
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//        String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
//        System.out.println("生成的时间+"+date);
//
//        notice.setNoticeId(resumeId);
//        notice.setContent("通过审批");
//        //获取messag
//        notice.setUserId(resume.getStudentId());
//        notice.setCreatedBy((String) session.getAttribute("user"));
////        notice.setNoticeTitle(resume.get());
//        //2表示部门的通知
//        notice.setType(1);
//        notice.setCreatedAt(date);
//        //执行添加Notice
//        noticeService.addNotice(notice);
//        return "redirect:/notice/adminAllNotices";
//    }
//
//    /**
//     * 部门驳回
//     * @param model
//     * @param id
//     * @return
//     */
//    @RequestMapping("/rejectResume")
//    public String rejectResume(Model model, String id, HttpServletRequest request,HttpSession session) {
//        Message message = messageService.findMessageById(id);
//        System.out.println("通过编号查找出来的通知"+id+message);
//        message.setPass("否");
//        messageService.updateMessage(message);
//
//
//        System.out.println("管理员的姓名"+session.getAttribute("admin"));
//        //开始对notice表进行操作
//        Notice notice = new Notice();
//        //uuid生成主键
//        String resumeId = UUID.randomUUID().toString();
//        System.out.println("生成的uuid+++++++++"+resumeId);
//        //生成通知时间
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//        String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
//        System.out.println("生成的时间+"+date);
//
//        notice.setNoticeId(resumeId);
//        notice.setContent("未通过审批：");
//        notice.setCause(request.getParameter("cause"));
//        //获取messag
//        notice.setUserId(message.getEmployerId());
//        notice.setCreatedBy((String) session.getAttribute("user"));
//        notice.setNoticeTitle(message.getPosition());
//        //2表示部门的通知
//        notice.setType(2);
//        notice.setCreatedAt(date);
//        //执行添加Notice
//        noticeService.addNotice(notice);
//
//        System.out.println("这里是updateMessage里面的message"+message);
//        return "redirect:/notice/adminAllNotices";
//    }
}
