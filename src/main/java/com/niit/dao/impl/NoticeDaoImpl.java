package com.niit.dao.impl;

import com.niit.dao.NoticeDao;
import com.niit.entity.Message;
import com.niit.entity.Notice;
import com.niit.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 类描述: NoticeDao实现类，通知信息的增删改查的具体实现
 */
@Component("noticeDao")
//@Repository("noticeDao")
public class NoticeDaoImpl implements NoticeDao {

//    @Autowired
//    SessionFactory factory;

    //等价于 先session factory  然后Session  session =  factory.getCurrentSession
//    Session session =  HibernateUtil.getCurrentSession();


    /**
     * 方法描述: 新增Notice用户
     * @param notice notice对象
     */
    @Override
    public void addNotice(Notice notice) {
//        Session session = factory.openSession();
//        Transaction ts = session.beginTransaction();
//
//        session.save(notice);
//        ts.commit();
//        System.out.println("输出通知"+notice);
//        System.out.println("插入成功");
//        方法2 杨师傅
//        Transaction ts = session.beginTransaction();
        Session session1 =  HibernateUtil.getCurrentSession();
        Transaction ts = session1.beginTransaction();
        session1.save(notice);
        ts.commit();
        System.out.println("输出通知"+notice);
        System.out.println("插入成功");

    }

    @Override
    public List<Message> adminFindAllMessage() {
        Session session = HibernateUtil.getCurrentSession();
        Transaction ts = session.beginTransaction();
        //查询未申请的招聘信息
        String hql = " from Message where pass =?1";

        Query query = session.createQuery(hql);
        //设置参数
        query.setParameter(1, "待审核");

        System.out.println("daoceng Notice");
        List<Message> allMessage = (List<Message>)query.list();
        ts.commit();
        return allMessage;
    }

    @Override
    public List<Notice> findAllNotice() {
//        Session session = factory.openSession();
//        String HQL = " from Notice ";
//        Query query = session.createQuery(HQL);
//        List<Notice> list = query.list();
//        Transaction ts = session.beginTransaction();
//        ts.commit();
//        System.out.println(list);
//        session.close();
//        return list;
//方法2 sql语句
//        SQLQuery sqlQuery;

        //方法3  杨师傅
        Session session1 =  HibernateUtil.getCurrentSession();
        Transaction ts = session1.beginTransaction();


        List<Notice> list =  session1.createQuery("FROM Notice",Notice.class).list();
        System.out.println("dao层查询结果"+list);
        ts.commit();
        return list;
    }
    /**
     * 方法描述: 查询返回指定学号的通知信息
     * @param noticeId 学号
     */

    @Override
    public Notice findNoticeById(int noticeId) {
        Session session1 =  HibernateUtil.getCurrentSession();
        Transaction ts = session1.beginTransaction();
        Notice notice = session1.get(Notice.class, noticeId);
        ts.commit();
        return notice;
    }


    /**
     * 方法描述: 删除指定学号的通知信息
     * @param noticeId 学号
     */
    @Override
    public void deleteNotice(Integer noticeId) {
        Session session1 =  HibernateUtil.getCurrentSession();
        Transaction ts = session1.beginTransaction();
        Notice notice = session1.get(Notice.class, noticeId);
        session1.delete(notice);
        ts.commit();

    }
    /**
     * 方法描述: 修改通知信息
     * @param notice notice对象
     */
    @Override
    public void updateNotice(Notice notice) {
        Session session1 =  HibernateUtil.getCurrentSession();
//        Integer id = notice.getNoticeId();
//        Transaction ts = session1.beginTransaction();
//        Notice notice1 = session1.get(Notice.class, id);
//        System.out.println("从前端传来的通知学号"+id);
//        notice1.setName(notice.getName());
//        notice1.setAge(notice.getAge());
//        notice1.setSex(notice.getSex());
//        notice1.setAddress(notice.getAddress());
//        notice1.setCollege(notice.getCollege());
//        notice1.setSpeciality(notice.getSpeciality());
//        session1.update(notice1);
//        ts.commit();
    }
//    /**
//     * 方法描述: 查询返回所有通知信息
//     */
//    @Override
//    public List<Notice> findAllNotice() {
//        Transaction ts = session.beginTransaction();
//        Query query = session.createQuery("FROM Notice");
//        List<Notice> list = query.list();
//        ts.commit();
//        return list;
//    }

}
