package com.niit.service.impl;

import com.niit.dao.ResumeDao;
import com.niit.dao.impl.ResumeDaoImpl;
import com.niit.entity.Resume;
import com.niit.service.ResumeService;

import java.util.List;

/**
 * 类描述: 简历接口实现类
 *
 * @Date: 2022/12/13 8:47
 */
public class ResumeServiceImpl implements ResumeService {

    ResumeDao resumeDao = new ResumeDaoImpl();

    /**
     * 添加简历
     *
     * @param resume 简历
     */
    @Override
    public void addResume(Resume resume) {
        resumeDao.add(resume);
    }

    /**
     * 添加记录
     *
     * @param messageId 招聘id
     * @param resumeId  简历id
     * @param studentId 学号
     */
    @Override
    public void addRecord(String messageId, String resumeId, Integer studentId) {
        resumeDao.addRecord(messageId, resumeId, studentId);
    }


    /**
     * 删除简历
     *
     * @param id 简历编号
     */
    @Override
    public void deleteResume(Integer id) {
        resumeDao.delete(id);
    }

    /**
     * 更新简历
     *
     * @param resume 简历
     * @return {@link Resume}
     */
    @Override
    public void updateResume(Resume resume) {
        resumeDao.update(resume);
    }

    /**
     * 查找所有简历
     *
     * @return {@link List}<{@link Resume}>
     */
    @Override
    public List<Resume> findAllResume(String studentId) {
        return resumeDao.findAllResume(studentId);
    }

    /**
     * 查找当前用户申请的所有职位
     *
     * @param studentId 学生id
     * @return {@link List}<{@link String}>
     */
    @Override
    public List<String> findAllPosition(String studentId) {
        return resumeDao.findAllPosition(studentId);
    }


}
