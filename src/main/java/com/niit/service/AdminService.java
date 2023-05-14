package com.niit.service;

import com.niit.entity.Admin;

import java.util.List;

public interface AdminService {
    void add(Admin obj);

    void delete(String id);

    void update(Admin obj);

    List<Admin> findAll();

    public Admin findAdminById(int id);
}
