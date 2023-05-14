 package com.niit.service.impl;

 import com.niit.dao.NoticeDao;
 import com.niit.dao.impl.NoticeDaoImpl;
 import com.niit.entity.Message;
 import com.niit.entity.Notice;
 import com.niit.service.NoticeService;
 import org.springframework.stereotype.Service;

 import java.util.List;

 /**
  * 类描述:
  *
  * @Author: 张传奇
  * @Date: 2022/11/14 20:17
  */
 @Service("noticeService")
 public class NoticeServiceImpl implements NoticeService {
//     @Resource
     NoticeDao noticeDao = new NoticeDaoImpl();

//     @Transactional
    @Override
    public List<Message> adminFindAllMessage() {
        System.out.println("++++++++++++++");
            return noticeDao.adminFindAllMessage();
        }

     @Override
     public void addNotice(Notice notice) {
         noticeDao.addNotice(notice);
     }

     @Override
     public Notice findNoticeById(int noticeId) {
         return  noticeDao.findNoticeById(noticeId);
     }

     @Override
     public List<Notice> findAllNotice() {
         return noticeDao.findAllNotice();
     }

     @Override
     public void updateNotice(Notice notice) {
         noticeDao.updateNotice(notice);
     }

     @Override
     public void deleteNotice(Integer noticeId) {
         noticeDao.deleteNotice(noticeId);
     }
 }
