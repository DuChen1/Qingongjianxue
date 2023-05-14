package com.niit.entity;

import javax.persistence.*;

/**
 * 学生
 *
 * @author Jason
 * @date 2022/11/14
 */

@Entity
@Table(name = "student")
public class Student {
  /**
   * 学生id
   */
  @Id
  @Column(name = "student_id")
  private Integer studentId;
  /**
   * 姓名
   */
  @Column
  private String name;
  /**
   * 密码
   */
  @Column
  private String password;
  /**
   * 性别
   */
  @Column
  private String sex;
  /**
   * 年龄
   */
  @Column
  private Integer age;
  /**
   * 电话
   */
  @Column
  private String phone;
  /**
   * 住址
   */
  @Column
  private String address;
  /**
   * 学院
   */
  @Column
  private String college;
  /**
   * 特长
   */
  @Column
  private String speciality;
  @Column(name = "type")
  private Integer type = 1;  //学生（1） 部门2

  public Integer getType() {
    return type;
  }

  public void setType(Integer type) {
    this.type = type;
  }

  public Integer getStudentId() {
    return studentId;
  }

  public void setStudentId(Integer studentId) {
    this.studentId = studentId;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }


  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }


  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }


  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }


  public String getCollege() {
    return college;
  }

  public void setCollege(String college) {
    this.college = college;
  }


  public String getSpeciality() {
    return speciality;
  }

  public void setSpeciality(String speciality) {
    this.speciality = speciality;
  }

  @Override
  public String toString() {
    return "Student{" +
            "studentId=" + studentId +
            ", name='" + name + '\'' +
            '}';
  }
}
