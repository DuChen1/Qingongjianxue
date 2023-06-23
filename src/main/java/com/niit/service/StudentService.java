package com.niit.service;

import com.niit.entity.MessageState;
import com.niit.entity.Student;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface StudentService {
    public List<MessageState> findResumeStateByStudentId(String studentId);

    public void addStudent(Student student);

    public Student findStudentById(int studentId);

    public List<Student> findAllStudent();

    public void updateStudent(Student student);

    public void deleteStudent(Integer studentId);

    public  void findAllResumeMessage();
}
