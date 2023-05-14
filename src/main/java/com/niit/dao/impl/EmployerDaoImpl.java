package com.niit.dao.impl;

import com.niit.dao.EmployerDao;
//import com.niit.dao.EmployerDao;
//import com.niit.entity.Employer;
import com.niit.entity.Employer;
import com.niit.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 类描述: EmployerDao实现类，部门信息的增删改查的具体实现
 */
@Component("employerDao")
//@Repository("employerDao")
public class EmployerDaoImpl implements EmployerDao {

//    @Autowired
//    SessionFactory factory;

    //等价于 先session factory  然后Session  session =  factory.getCurrentSession
//    Session session =  HibernateUtil.getCurrentSession();


    /**
     * 方法描述: 新增Employer用户
     */
    @Override
    public void addEmployer(Employer employer) {

        Session session1 =  HibernateUtil.getCurrentSession();
        Transaction ts = session1.beginTransaction();
        session1.save(employer);
        ts.commit();
        System.out.println("输出部门"+employer);
        System.out.println("插入成功");

    }



    @Override
    public List<Employer> findAllEmployer() {

        //方法3  杨师傅
        Session session1 =  HibernateUtil.getCurrentSession();
        Transaction ts = session1.beginTransaction();


        List<Employer> list =  session1.createQuery("FROM Employer",Employer.class).list();
        System.out.println("dao层查询结果"+list);
        ts.commit();
        return list;
    }
    /**
     * 方法描述: 查询返回指定学号的部门信息
     * @param employerId 学号
     */

    @Override
    public Employer findEmployerById(int employerId) {
        Session session1 =  HibernateUtil.getCurrentSession();
        Transaction ts = session1.beginTransaction();
        Employer employer = session1.get(Employer.class, employerId);
        ts.commit();
        return employer;
    }


    /**
     * 方法描述: 删除指定学号的部门信息
     * @param employerId 学号
     */
    @Override
    public void deleteEmployer(Integer employerId) {
        Session session1 =  HibernateUtil.getCurrentSession();
        Transaction ts = session1.beginTransaction();
        Employer employer = session1.get(Employer.class, employerId);
        session1.delete(employer);
        ts.commit();

    }
    /**
     * 方法描述: 修改部门信息
     * @param employer employer对象
     */
    @Override
    public void updateEmployer(Employer employer) {
        Session session1 =  HibernateUtil.getCurrentSession();
        Integer id = employer.getEmployerId();
        Transaction ts = session1.beginTransaction();
//        Employer employer1 = session1.get(Employer.class, id);
        System.out.println("从前端传来的部门号"+id);
//        employer1.setEmployerName(employer.getEmployerName());
//        employer1.set (employer.getAge());
//        employer1.setSex(employer.getSex());
//        employer1.setAddress(employer.getAddress());
//        employer1.setCollege(employer.getCollege());
//        employer1.setSpeciality(employer.getSpeciality());
        session1.update(employer);
        ts.commit();
    }
//    /**
//     * 方法描述: 查询返回所有部门信息
//     */
//    @Override
//    public List<Employer> findAllEmployer() {
//        Transaction ts = session.beginTransaction();
//        Query query = session.createQuery("FROM Employer");
//        List<Employer> list = query.list();
//        ts.commit();
//        return list;
//    }

}
