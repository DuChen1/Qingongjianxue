package com.niit.dao.impl;

import com.niit.dao.AdminDao;
import com.niit.entity.Admin;
import com.niit.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类描述:
 *
 * @Author: 张传奇
 * @Date: 2022/11/14 20:26
 */
@Component("adminDao")
// @Service
public class AdminDaoImpl implements AdminDao {

    // 获取session对象
    Session session = HibernateUtil.getCurrentSession();

    public void add(Admin admin) {
        // Session session = factory.getCurrentSession();
        Transaction ts = session.beginTransaction();
        session.save(admin);
        ts.commit();
    }

    public void delete(Integer id) {
        // Session session = factory.openSession();
        Transaction ts = session.beginTransaction();
        //先查后删除
        Admin admin = session.get(Admin.class, id);
        //未找到则不执行操作
        if (admin != null) {
            session.delete(admin);
            ts.commit();
        }

    }

    public void update(Admin admin) {
        // Session session = factory.openSession();
        Transaction ts = session.beginTransaction();

        //先查后改
        Admin admin1 = session.get(Admin.class, admin.getAssessorId());

        if (admin != null) {
            admin1.setName(admin.getName());
            admin1.setCollege(admin.getCollege());
            admin1.setPosition(admin.getPosition());
            admin1.setPhone(admin.getPhone());
            session.update(admin1);
            ts.commit();
        }

    }

    public List<Admin> findAllAdmin() {
        Transaction ts = session.beginTransaction();
        List<Admin> list = session.createQuery("FROM Admin").list();
        ts.commit();
        return list;

    }

    @Override
    public Admin findAdminById(int id) {
        Transaction ts = session.beginTransaction();
        Admin admin = session.get(Admin.class, id);
        ts.commit();
        return admin;
    }


}
