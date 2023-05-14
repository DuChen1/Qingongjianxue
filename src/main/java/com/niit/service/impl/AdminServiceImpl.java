package com.niit.service.impl;

import com.niit.dao.AdminDao;
import com.niit.dao.impl.AdminDaoImpl;
import com.niit.entity.Admin;
import com.niit.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类描述: 管理员实现类
 *
 * @Author: 杨扬
 * @Date: 2022/11/14 20:18
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService {
//    @Autowired
    AdminDao adminDao = new AdminDaoImpl();
    @Override
    public void add(Admin obj) {
        adminDao.add(obj);
    }

    @Override
    public void delete(String id) {
        //页面获取到的id为String类型，转为integer
        int adminId = Integer.parseInt(id);
        adminDao.delete(adminId);
    }

    @Override
    public void update(Admin obj) {

        adminDao.update(obj);
    }

    @Override
    public List<Admin> findAll() {

        return adminDao.findAllAdmin();
    }

    @Override
    public Admin findAdminById(int id) {
        //页面获取到的id为String类型，转为integer

        return adminDao.findAdminById(id);
    }
}
