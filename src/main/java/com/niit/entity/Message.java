package com.niit.entity;


import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

/**
 * 招聘信息
 *
 * @author Jason
 * @date 2022/11/14
 */
@Entity
@Table(name = "message")
public class Message {
  @Id
  @Column(name = "message_id")
  private String messageId;

  /**
   * 招聘信息id
   */
//  @Column
//  private Integer messageId;
  /**
   * 招聘职位
   */
  @Column
  private String position;
  /**
   * 要求
   */
  @Column
  private String requirement;
  /**
   * 地址
   */
  @Column
  private String address;
  /**
   * 电话
   */
  @Column
  private String phone;
  /**
   * 招聘单位id
   */
  @Column(name = "employer_id")
  private Integer employerId;
  /**
   * 招聘单位名字
   */
  @Column(name = "employer_name")
  private String employerName;
  /**
   * 工资
   */
  @Column
  private String salary;
  /**
   * 时间
   */
  @Column
  private String time;

  @Column
  private String pass;

  public String getPass() {
    return pass;
  }

  public void setPass(String pass) {
    this.pass = pass;
  }

  public String getMessageId() {
    return messageId;
  }

  public void setMessageId(String messageId) {
    this.messageId = messageId;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }


  public String getRequirement() {
    return requirement;
  }

  public void setRequirement(String requirement) {
    this.requirement = requirement;
  }


  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }


  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }


  public Integer getEmployerId() {
    return employerId;
  }

  public void setEmployerId(Integer employerId) {
    this.employerId = employerId;
  }


  public String getEmployerName() {
    return employerName;
  }

  public void setEmployerName(String employerName) {
    this.employerName = employerName;
  }


  public String getSalary() {
    return salary;
  }

  public void setSalary(String salary) {
    this.salary = salary;
  }


  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  @Override
  public String toString() {
    return "Message{" +
            "messageId='" + messageId + '\'' +
            ", position='" + position + '\'' +
            ", requirement='" + requirement + '\'' +
            ", address='" + address + '\'' +
            ", phone='" + phone + '\'' +
            ", employerId=" + employerId +
            ", employerName='" + employerName + '\'' +
            ", salary='" + salary + '\'' +
            ", time='" + time + '\'' +
            ", pass='" + pass + '\'' +
            '}';
  }
}
