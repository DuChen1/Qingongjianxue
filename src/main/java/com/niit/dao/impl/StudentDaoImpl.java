package com.niit.dao.impl;

import com.niit.dao.StudentDao;
import com.niit.entity.Student;
import com.niit.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 类描述: StudentDao实现类，学生信息的增删改查的具体实现
 */
@Component("studentDao")
//@Repository("studentDao")
public class StudentDaoImpl implements StudentDao {

//    @Autowired
//    SessionFactory factory;

    //等价于 先session factory  然后Session  session =  factory.getCurrentSession
//    Session session =  HibernateUtil.getCurrentSession();


    /**
     * 方法描述: 新增Student用户
     * @param student student对象
     */
    @Override
    public void addStudent(Student student) {

        Session session1 =  HibernateUtil.getCurrentSession();
        Transaction ts = session1.beginTransaction();
        session1.save(student);
        ts.commit();
        System.out.println("输出学生"+student);
        System.out.println("插入成功");

    }



    @Override
    public List<Student> findAllStudent() {
//        Session session = factory.openSession();
//        String HQL = " from Student ";
//        Query query = session.createQuery(HQL);
//        List<Student> list = query.list();
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


        List<Student> list =  session1.createQuery("FROM Student",Student.class).list();
        System.out.println("dao层查询结果"+list);
        ts.commit();
        return list;
    }
    /**
     * 方法描述: 查询返回指定学号的学生信息
     * @param studentId 学号
     */

    @Override
    public Student findStudentById(int studentId) {
        Session session1 =  HibernateUtil.getCurrentSession();
        Transaction ts = session1.beginTransaction();
        Student student = session1.get(Student.class, studentId);
        ts.commit();
        return student;
    }


    /**
     * 方法描述: 删除指定学号的学生信息
     * @param studentId 学号
     */
    @Override
    public void deleteStudent(Integer studentId) {
        Session session1 =  HibernateUtil.getCurrentSession();
        Transaction ts = session1.beginTransaction();
        Student student = session1.get(Student.class, studentId);
        session1.delete(student);
        ts.commit();

    }
    /**
     * 方法描述: 修改学生信息
     * @param student student对象
     */
    @Override
    public void updateStudent(Student student) {
        Session session1 =  HibernateUtil.getCurrentSession();
        Integer id = student.getStudentId();
        Transaction ts = session1.beginTransaction();
//        Student student1 = session1.get(Student.class, id);
//        System.out.println("从前端传来的学生学号"+id);
//        student1.setName(student.getName());
//        student1.setAge(student.getAge());
//        student1.setSex(student.getSex());
//        student1.setAddress(student.getAddress());
//        student1.setCollege(student.getCollege());
//        student1.setSpeciality(student.getSpeciality());
        session1.update(student);
        ts.commit();
    }
//    /**
//     * 方法描述: 查询返回所有学生信息
//     */
//    @Override
//    public List<Student> findAllStudent() {
//        Transaction ts = session.beginTransaction();
//        Query query = session.createQuery("FROM Student");
//        List<Student> list = query.list();
//        ts.commit();
//        return list;
//    }

}
