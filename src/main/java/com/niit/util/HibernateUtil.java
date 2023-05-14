package com.niit.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//初始化SessionFactory对象
public class HibernateUtil {

    //创建一个 SessionFactory 用来获取 Session 连接对象
    static SessionFactory sessionFactory;



    static {
        //加载hibernate.cfg.xml文件
        Configuration configuration = new Configuration().configure();
        // 实例化SessionFactory对象
        sessionFactory = configuration.buildSessionFactory();
    }

    //获取SessionFactory对象
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    //获取session 连接对象
    public static Session getCurrentSession() {
        if(sessionFactory !=null ) {
            return sessionFactory.getCurrentSession();
        }
        return null;
    }
// static SessionFactory sf;
    // static {
    //     sf = new Configuration().configure()
    //             .buildSessionFactory();
    // }
    //
    // public static SessionFactory getSessionFactory() {
    //     return sf;
    // }
    //
    // public static Session getSession() {
    //     return sf.openSession();
    // }

}
