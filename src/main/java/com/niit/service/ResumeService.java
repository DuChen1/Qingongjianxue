package com.niit.service;

import com.niit.entity.Resume;

import java.util.List;

/**
 * 恢复服务
 * 接口描述:
 *
 * @author Jason
 * @Date: 2022/12/13 8:42
 * @date 2022/12/13
 */
public interface ResumeService {

    void updateResumePassOrNot(String resumeId, String passOrNot);

    List<Resume> findAllResumeByMessageId(String messageId);
    /**
     * 查看对指定岗位投递的简历
     *
     */
    List<Resume> findResumeByPositionId(String positionId);

    /**
     * 添加简历
     *
     * @param resume 简历
     */
    void addResume(Resume resume);


    /**
     * 添加记录
     *
     * @param messageId 招聘id
     * @param resumeId  简历id
     * @param studentId  学号
     */
    void addRecord(String messageId, String resumeId, Integer studentId);
    /**
     * 删除简历
     *
     * @param resumeId 简历编号
     */
    void deleteResume(Integer resumeId);

    /**
     * 更新简历
     *
     * @param resume 简历
     * @return {@link Resume}
     */
    void updateResume(Resume resume);

    /**
     * 查找所有简历
     *
     * @return {@link List}<{@link Resume}>
     */
    List<Resume> findAllResume(String studentId);

    /**
     * 查找当前用户申请的所有职位
     *
     * @param studentId 学生id
     * @return {@link List}<{@link String}>
     */
    List<String> findAllPosition(String studentId);

}
