package com.niit.dao;

import com.niit.entity.Student;

import java.util.List;

/**
 * 类描述: 学生接口，定义操作数据库的方法
 *
 * @Author: 杨扬
 * @Date: 2022/11/8 21:19
 */

public interface StudentDao {


    void addStudent(Student student);

    void deleteStudent(Integer studentId);

    void updateStudent(Student student);

    List<Student> findAllStudent();

    Student findStudentById(int studentId);

//    Student findStudentById(Integer studentId);
}
