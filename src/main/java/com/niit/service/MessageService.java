package com.niit.service;

import com.niit.entity.Message;

import java.util.List;

/**
 *
 * 接口描述: 招聘信息接口
 *
 */
public interface MessageService {

    List<Message> findMessageByEmployerId(int employerId);
    /**
     * 添加招聘信息
     *
     * @param message 招聘信息
     */
    void addMessage(Message message);

    /**
     * 删除招聘信息
     *
     * @param messageId 招聘信息id
     */
    void deleteMessage(String messageId);

    /**
     * 更新招聘信息
     *
     * @param message 招聘信息
     */
    void updateMessage(Message message);

    /**
     * 查找所有招聘信息
     *
     * @param studentId 学生id
     * @return {@link List}<{@link Message}>
     */
    List<Message> findAllMessage(String studentId);

    /**
     * 按邮件id查找招聘信息
     *
     * @param messageId 招聘信息id
     * @return {@link Message}
     */
    Message findMessageById(String messageId);


}
