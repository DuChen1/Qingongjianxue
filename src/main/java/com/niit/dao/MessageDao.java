package com.niit.dao;

import com.niit.entity.Message;

import java.util.List;

/**
 *
 * 类描述: 招聘信息接口
 *
 * @Author: 杨扬
 * @Date: 2022/12/14 22:16
 */
public interface MessageDao {

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
     * @return {@link List}<{@link Message}>
     */
    List<Message> findAllMessage(String studentId);

    /**
     * 按id查找招聘信息
     *
     * @return {@link Message}
     */
    Message findMessageById(String messageId);

}
