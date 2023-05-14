package com.niit.service.impl;

import com.niit.dao.EmployerDao;
import com.niit.dao.impl.EmployerDaoImpl;
import com.niit.entity.Employer;
import com.niit.service.EmployerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.List;

/**
 * 类描述:
 *
 * @Author: 杨扬
 * @Date: 2022/11/14 20:17
 */
@Service("employerService")
public class EmployerServiceImpl implements EmployerService {
    //     @Resource
    EmployerDao employerDao = new EmployerDaoImpl();

    //     @Transactional
    @Override
    public void addEmployer(Employer employer) {
        employerDao.addEmployer(employer);
    }

    @Override
    public Employer findEmployerById(int employerId) {
        return  employerDao.findEmployerById(employerId);
    }

    @Override
    public List<Employer> findAllEmployer() {
        return employerDao.findAllEmployer();
    }

    @Override
    public void updateEmployer(Employer employer) {
        employerDao.updateEmployer(employer);
    }

    @Override
    public void deleteEmployer(Integer employerId) {
        employerDao.deleteEmployer(employerId);
    }
}
