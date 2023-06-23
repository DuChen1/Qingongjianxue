package com.niit.dao;

import com.niit.entity.Resume;

import java.util.List;

/**
 * 类描述: 简历接口
 *
 */
public interface ResumeDao {

    void updateResumePassOrNot(String resumeId, String passOrNot);
    List<Resume> findAllResumeByMessageId(String messageId);
    List<Resume> findResumeByPositionId(String positionId);

    void add(Resume resume);

    void delete(Integer id);

    void update(Resume resume);

    Resume findByStudentId(Integer id);

    /**
     * 添加记录
     *
     * @param messageId 招聘id
     * @param resumeId  简历id
     * @param studentId 学生id
     */
    void addRecord(String messageId, String resumeId, Integer studentId);

    List<Resume> findAllResume(String studentId);

    List<String> findAllPosition(String studentId);
}
