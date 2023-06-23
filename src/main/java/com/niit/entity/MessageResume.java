package com.niit.entity;


import javax.persistence.*;

/**
 * 简历-招聘信息表
 * ①查询显示所有未通过的message信息(0) ②点击审批通过：message pass=1 ③驳回：驳回原因：
 *
 * @author Jason
 * @date 2022/11/14
 */
@Entity
@Table(name = "message_resume")
public class MessageResume {


  @ManyToOne
  @JoinColumn(name = "message_id")
  private Message message;
  /**
   * id
   */
  @Id
  private String id;
  /**
   * 招聘信息id
   */
  @Column(name = "message_id",insertable = false, updatable = false)
  private String messageId;
  /**
   * 简历id
   */
  @Column(name = "resume_id")
  private String resumeId;

  /**
   * 学生id
   */
  @Column(name = "student_id")
  private  Integer studentId;

  /**
   * 简历状态
   */
  @Column(name = "pass")
  private String pass;

  public Integer getStudentId() {
    return studentId;
  }

  public void setStudentId(Integer studentId) {
    this.studentId = studentId;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getMessageId() {
    return messageId;
  }

  public void setMessageId(String messageId) {
    this.messageId = messageId;
  }

  public String getResumeId() {
    return resumeId;
  }

  public void setResumeId(String resumeId) {
    this.resumeId = resumeId;
  }

  public String getPass() {
    return pass;
  }

  public void setPass(String pass) {
    this.pass = pass;
  }
}
