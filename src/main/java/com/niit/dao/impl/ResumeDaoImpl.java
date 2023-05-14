package com.niit.dao.impl;

import com.niit.dao.ResumeDao;
import com.niit.entity.MessageResume;
import com.niit.entity.Resume;
import com.niit.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.UUID;

/**
 * 类描述: 接口实现类
 *
 * @Date: 2022/12/12 15:21
 */
public class ResumeDaoImpl implements ResumeDao {


    Session session = HibernateUtil.getCurrentSession();


    /**
     * 添加
     *
     * @param resume 简历
     */
    @Override
    public void add(Resume resume) {
        Session session = HibernateUtil.getCurrentSession();

        Transaction ts = session.beginTransaction();
        session.save(resume);
        ts.commit();
    }


    /**
     * 删除
     *
     * @param resumeId 简历编号
     */
    @Override
    public void delete(Integer resumeId) {
        Session session = HibernateUtil.getCurrentSession();

        Transaction ts = session.beginTransaction();
        Resume resume = session.get(Resume.class, resumeId);
        if (resume != null) {
            session.delete(resume);
            ts.commit();
        }
    }

    /**
     * 修改
     *
     * @param resume 简历
     */
    @Override
    public void update(Resume resume) {
        Session session = HibernateUtil.getCurrentSession();


        Transaction ts = session.beginTransaction();
        //先查后改
        Resume resume1 = session.get(Resume.class, resume.getResumeId());
        if (resume1 != null) {
            resume1.setStudentId(resume.getStudentId());
            resume1.setPhone(resume.getPhone());
            resume1.setCollege(resume.getCollege());
            resume1.setAge(resume.getAge());
            resume1.setName(resume.getName());
            resume1.setExperience(resume.getExperience());
            resume1.setSex(resume.getSex());
            resume1.setSpeciality(resume.getSpeciality());
            session.update(resume1);
            ts.commit();
        }

    }

    /**
     * 按学生id查找
     *
     * @param studentId 学生id
     * @return {@link Resume}
     */
    @Override
    public Resume findByStudentId(Integer studentId) {
        Session session = HibernateUtil.getCurrentSession();

        Transaction ts = session.beginTransaction();
        String hql = "from Resume where studentId = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id", studentId);
        List<Resume> list = (List<Resume>) query.list();
        Resume resume = list.get(0);
        ts.commit();
        return resume;
    }

    /**
     * 添加记录，关联简历和招聘信息
     *
     * @param messageId 消息id
     * @param resumeId  简历id
     * @param studentId 学生id
     */
    @Override
    public void addRecord(String messageId, String resumeId, Integer studentId) {
        Session session = HibernateUtil.getCurrentSession();

        Transaction ts = session.beginTransaction();
        //关联简历-招聘信息
        MessageResume messageResume = new MessageResume();
        messageResume.setId(UUID.randomUUID().toString());
        messageResume.setResumeId(resumeId);
        messageResume.setMessageId(messageId);
        //用来判断该招聘信息是否被申请
        messageResume.setStudentId(studentId);
        session.save(messageResume);
        ts.commit();
    }


    /**
     * 查找所有简历
     *
     * @return {@link List}<{@link Resume}>
     */
    @Override
    public List<Resume> findAllResume(String studentId) {
        Session session = HibernateUtil.getCurrentSession();
        Transaction tx = session.beginTransaction();

        String hql = "FROM Resume WHERE studentId  = :studentId";
        //查询当前用户所有招聘的简历信息
        Query query = session.createQuery(hql);
        //设置参数
        query.setParameter("studentId", Integer.parseInt(studentId));

        List<Resume> resumeList = (List<Resume>) query.list();

        tx.commit();
        return resumeList;
    }

    @Override
    public List<String> findAllPosition(String studentId) {
        Session session = HibernateUtil.getCurrentSession();
        Transaction ts = session.beginTransaction();


        //查询当前学生申请过的所有招聘信息
        String hql = "SELECT position FROM Message WHERE messageId in (SELECT messageId FROM MessageResume WHERE studentId = :studentId)";
        //查询当前用户申请过的职位名称
        Query query = session.createQuery(hql);


        //设置参数
        query.setParameter("studentId", Integer.parseInt(studentId));
        List<String> positionList = (List<String>) query.list();

        ts.commit();
        return positionList;
    }

}
