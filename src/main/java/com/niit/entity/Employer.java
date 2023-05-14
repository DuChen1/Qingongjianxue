package com.niit.entity;

import javax.persistence.*;

/**
 * 用人单位
 *
 * @author Jason
 * @date 2022/11/14
 */
@Entity
@Table(name = "employer")
public class Employer {
  /**
   * 用人单位id
   */
  @Id
  @Column(name = "employer_id")
  private Integer employerId;
  /**
   * 密码
   */
  @Column
  private String password;
  /**
   * 雇主名字
   */
  @Column(name = "employer_name")
  private String employerName;
  /**
   * 单位职能
   */
  @Column(name= "function1")
  private String function1;
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
   * 用户类型
   */
  @Column(name = "type")
  private Integer type = 2;

  public Integer getType() {
    return type;
  }

  public void setType(Integer type) {
    this.type = type;
  }

  public Integer getEmployerId() {
    return employerId;
  }

  public void setEmployerId(Integer employerId) {
    this.employerId = employerId;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public String getEmployerName() {
    return employerName;
  }

  public void setEmployerName(String employerName) {
    this.employerName = employerName;
  }


  public String getFunction1() {
    return function1;
  }

  public void setFunction1(String function1) {
    this.function1 = function1;
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

  @Override
  public String toString() {
    return "Employer{" +
            "employerId=" + employerId +
            ", password='" + password + '\'' +
            ", employerName='" + employerName + '\'' +
            ", function1='" + function1 + '\'' +
            ", address='" + address + '\'' +
            ", phone='" + phone + '\'' +
            ", type=" + type +
            '}';
  }
}
