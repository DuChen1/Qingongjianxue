package com.niit.entity;


import javax.persistence.*;
import java.util.Date;

/**
 * 通知表
 *
 *
 * @date 2022/12/12
 */
@Entity
@Table(name = "notice")
public class Notice {

  /**
   * 通知id
   */
  @Id
  @Column(name = "notice_id")
  private String noticeId;
  /**
   * 创建人
   */
  @Column(name = "created_by")
  private String createdBy;
  /**
   * 通知标题
   */
  @Column(name = "notice_title")
  private String noticeTitle;
  /**
   * 类型 1学生 2部门
   */
  @Column(name = "type")
  private Integer type;
  /**
   * 内容
   */
  @Column(name = "content")
  private String content;

  /**
   * 创建时间
   */
  @Column(name = "created_at")
  private String createdAt;
  /**
   * 用户id
   */
  @Column(name = "user_id")
  private Integer userId;
  /**
   * 内容
   */
  @Column(name = "cause")
  private String cause;
  public String getCause() {
    return cause;
  }

  public void setCause(String cause) {
    this.cause = cause;
  }




  public String getNoticeId() {
    return noticeId;
  }

  public void setNoticeId(String noticeId) {
    this.noticeId = noticeId;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }


  public String getNoticeTitle() {
    return noticeTitle;
  }

  public void setNoticeTitle(String noticeTitle) {
    this.noticeTitle = noticeTitle;
  }


  public long getType() {
    return type;
  }

  public void setType(Integer type) {
    this.type = type;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public long getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

}
