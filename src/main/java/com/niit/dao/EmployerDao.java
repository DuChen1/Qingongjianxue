package com.niit.dao;

//import com.niit.entity.Student;

import com.niit.entity.Employer;

import java.util.List;

/**
 * 类描述: 学生接口，定义操作数据库的方法
 *
 * @Author: 杨扬
 * @Date: 2022/11/8 21:19
 */

public interface EmployerDao {


    void addEmployer(Employer employer);

    void deleteEmployer(Integer employerId);

    void updateEmployer(Employer employer);

    List<Employer> findAllEmployer();

    Employer findEmployerById(int employerId);

//    Student findStudentById(Integer studentId);
}
