package com.niit.dao;

import com.niit.entity.MessageResume;
import com.niit.entity.MessageState;
import com.niit.entity.Resume;
import com.niit.entity.Student;

import java.util.List;

/**
 * 类描述: 学生接口，定义操作数据库的方法
 *
 * @Author: 杨扬
 * @Date: 2022/11/8 21:19
 */

public interface StudentDao {

    List<MessageState> findResumeStateByStudentId(String studentId);
    void addStudent(Student student);

    void deleteStudent(Integer studentId);

    void updateStudent(Student student);

    List<Student> findAllStudent();

    Student findStudentById(int studentId);

    MessageResume findAllResumeMessage();
    //查看某个学生简历的申请情况
    List <Resume> findPersonalResume(String studentId);

//    Student findStudentById(Integer studentId);
}
