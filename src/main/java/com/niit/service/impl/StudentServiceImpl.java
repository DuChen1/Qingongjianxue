 package com.niit.service.impl;

 import com.niit.dao.StudentDao;
 import com.niit.dao.impl.StudentDaoImpl;
 import com.niit.entity.Student;
 import com.niit.service.StudentService;
 import org.springframework.stereotype.Service;
 import org.springframework.transaction.annotation.Transactional;
 import javax.annotation.Resource;
 import java.util.List;

 /**
  * 类描述:
  *
  * @Author: 杨扬
  * @Date: 2022/11/14 20:17
  */
 @Service("studentService")
 public class StudentServiceImpl implements StudentService {
//     @Resource
     StudentDao studentDao = new StudentDaoImpl();

//     @Transactional
     @Override
     public void addStudent(Student student) {
         studentDao.addStudent(student);
     }

     @Override
     public Student findStudentById(int studentId) {
         return  studentDao.findStudentById(studentId);
     }

     @Override
     public List<Student> findAllStudent() {
         return studentDao.findAllStudent();
     }

     @Override
     public void updateStudent(Student student) {
         studentDao.updateStudent(student);
     }

     @Override
     public void deleteStudent(Integer studentId) {
         studentDao.deleteStudent(studentId);
     }
 }
