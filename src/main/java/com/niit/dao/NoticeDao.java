package com.niit.dao;

import com.niit.entity.Message;
import com.niit.entity.Notice;

import java.util.List;

/**
 * 类描述: 接口，定义操作数据库的方法
 *
 * @Author: 张传奇
 * @Date: 2022/11/8 21:19
 */

public interface NoticeDao {
    public List<Message> adminFindAllMessage();

    void addNotice(Notice notice);

    void deleteNotice(Integer noticeId);


    void updateNotice(Notice notice);

    List<Notice> findAllNotice();

    Notice findNoticeById(int noticeId);

//    Notice findNoticeById(Integer noticeId);
}
