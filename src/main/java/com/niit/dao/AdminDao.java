package com.niit.dao;

import com.niit.entity.Admin;

import java.util.List;

/**
 * 接口描述:
 *
 * @Date: 2022/11/14 20:25
 */
public interface AdminDao {

    void add(Admin admin);

    void delete(Integer id);

    void update(Admin admin);

    List<Admin> findAllAdmin();

    Admin findAdminById(int id);
}
