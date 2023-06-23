package com.niit.service.impl;

import com.niit.dao.MessageDao;
import com.niit.dao.impl.MessageDaoImpl;
import com.niit.entity.Message;
import com.niit.service.MessageService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类描述: 实现类
 *
 */
@Service("messageService")
public class MessageServiceImpl implements MessageService {

    MessageDao messageDao = new MessageDaoImpl();

    /**
     * 查看某个公司全部的简历信息 2023/6/22 10:46
     * @param employerId
     * @return
     */
    @Override
    public List<Message> findMessageByEmployerId(int employerId) {
        return messageDao.findMessageByEmployerId(employerId);
    }

    /**
     * 添加招聘信息
     *
     * @param message 招聘信息
     */
    @Override
    public void addMessage(Message message) {
        messageDao.addMessage(message);
    }

    /**
     * 删除招聘信息
     *
     * @param messageId 招聘信息id
     */
    @Override
    public void deleteMessage(String messageId) {
        messageDao.deleteMessage(messageId);
    }

    /**
     * 更新招聘信息
     *
     * @param message 招聘信息
     */
    @Override
    public void updateMessage(Message message) {
        messageDao.updateMessage(message);
    }

    /**
     * 查找所有招聘信息
     *
     * @param studentId 学生id
     * @return {@link List}<{@link Message}>
     */
    @Override
    public List<Message> findAllMessage(String studentId) {
        return messageDao.findAllMessage(studentId);
    }

    /**
     * 按邮件id查找招聘信息
     *
     * @param messageId 招聘信息id
     * @return {@link Message}
     */
    @Override
    public Message findMessageById(String messageId) {
        return messageDao.findMessageById(messageId);
    }
}
