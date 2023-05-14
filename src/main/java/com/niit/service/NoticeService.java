package com.niit.service;

import com.niit.entity.Message;
import com.niit.entity.Notice;

import java.util.List;

public interface NoticeService {
    public List<Message> adminFindAllMessage();

    public void addNotice(Notice notice);

    public Notice findNoticeById(int noticeId);

    public List<Notice> findAllNotice();

    public void updateNotice(Notice notice);

    public void deleteNotice(Integer noticeId);
}
