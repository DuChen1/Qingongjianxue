package com.niit.entity;


import javax.persistence.*;

/**
 * 简历
 *
 * @author Jason
 * @date 2022/11/14
 */
@Entity
@Table(name = "resume")
public class Resume {

    /**
     * 简历id
     */
    @Id
    @Column(name = "resume_id")
    private String resumeId;
    /**
     * 学生id
     */
    @Column(name = "student_id")
    private Integer studentId;
    /**
     * 学生姓名
     */
    @Column(name = "name")
    private String name;
    /**
     * 性别
     */
    @Column(name = "sex")
    private String sex;
    /**
     * 年龄
     */
    @Column(name = "age")
    private Integer age;
    /**
     * 学院
     */
    @Column(name = "college")
    private String college;
    /**
     * 电话
     */
    @Column(name = "phone")
    private String phone;
    /**
     * 特长
     */
    @Column(name = "speciality")
    private String speciality;
    /**
     * 经验
     */
    @Column(name = "experience")
    private String experience;

    /**
     * 简历是否通过，默认否
     */
    @Column(name = "pass")
    private String pass;

    public String getResumeId() {
        return resumeId;
    }

    public void setResumeId(String resumeId) {
        this.resumeId = resumeId;
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


    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }


    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "resumeId=" + resumeId +
                ", studentId=" + studentId +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", college='" + college + '\'' +
                ", phone='" + phone + '\'' +
                ", speciality='" + speciality + '\'' +
                ", experience='" + experience + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
