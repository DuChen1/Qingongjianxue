package com.niit.entity;


import javax.persistence.*;

/**
 * 管理员
 *
 * @author Jason
 * @date 2022/11/14
 */
@Entity
@Table(name = "admin")
public class Admin {

  /**
   * 管理员ID
   */
  @Id
  @Column(name = "assessor_id")
  private Integer assessorId;
  /**
   * 名字
   */
  @Column(name = "name")
  private String name;
  /**
   * 密码
   */
  @Column(name = "password")
  private String password;
  /**
   * 学院
   */
  @Column(name = "college")
  private String college;
  /**
   * 职位
   */
  @Column(name = "position")
  private String position;
  /**
   * 电话
   */
  @Column(name = "phone")
  private String phone;


  public Integer getAssessorId() {
    return assessorId;
  }

  public void setAssessorId(Integer assessorId) {
    this.assessorId = assessorId;
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


  public String getCollege() {
    return college;
  }

  public void setCollege(String college) {
    this.college = college;
  }


  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }


  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  @Override
  public String toString() {
    return "Admin{" +
            "assessorId=" + assessorId +
            ", name='" + name + '\'' +
            ", password='" + password + '\'' +
            ", college='" + college + '\'' +
            ", position='" + position + '\'' +
            ", phone='" + phone + '\'' +
            '}';
  }
}
