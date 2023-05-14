package com.niit.dao.impl;

import com.niit.dao.MessageDao;
import com.niit.entity.Message;
import com.niit.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 类描述: 实现类
 *
 * @Author: 杨扬
 * @Date: 2022/12/14 22:28
 */
@Component("messageDao")
public class MessageDaoImpl implements MessageDao {
    /**
     * 添加招聘信息
     *
     * @param message 招聘信息
     */
    @Override
    public void addMessage(Message message) {
        Session session = HibernateUtil.getCurrentSession();
        Transaction ts = session.beginTransaction();
        session.save(message);
        ts.commit();
    }

    /**
     * 删除招聘信息
     *
     * @param messageId 招聘信息id
     */
    @Override
    public void deleteMessage(String messageId) {
        Session session = HibernateUtil.getCurrentSession();
        Transaction ts = session.beginTransaction();
        //先查后删
        Message message = session.get(Message.class, messageId);
        session.delete(message);
        ts.commit();

    }

    /**
     * 更新招聘信息
     *
     * @param message 招聘信息
     */
    @Override
    public void updateMessage(Message message) {
        Session session = HibernateUtil.getCurrentSession();
        Transaction ts = session.beginTransaction();
        session.update(message);
        ts.commit();

    }

    /**
     * 查找所有未申请的招聘信息
     *
     * @param studentId 学生id
     * @return {@link List}<{@link Message}>
     */
    @Override
    public List<Message> findAllMessage(String studentId) {
        Session session = HibernateUtil.getCurrentSession();
        Transaction ts = session.beginTransaction();
        //查询未申请的招聘信息
        String hql = "from Message where messageId not in\n" +
                " (select messageId from MessageResume where studentId = :studentId)";

        Query query = session.createQuery(hql);
        //设置参数
        query.setParameter("studentId", Integer.parseInt(studentId));

        List<Message> allMessage = (List<Message>)query.list();
        ts.commit();
        return allMessage;
    }

    /**
     * 按id查找招聘信息
     *
     * @param messageId 招聘信息id
     * @return {@link Message}
     */
    @Override
    public Message findMessageById(String messageId) {
        Session session = HibernateUtil.getCurrentSession();
        Transaction ts = session.beginTransaction();

        String hql = "FROM Message WHERE messageId = :messageId";
        Query query = session.createQuery(hql);
        query.setParameter("messageId", messageId);
        List<Message> list = (List<Message>) query.list();
        Message message = list.get(0);
        ts.commit();
        return message;
    }
}
