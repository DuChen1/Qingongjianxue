package com.niit.service;

import com.niit.entity.Employer;

import java.util.List;

public interface EmployerService {
    public void addEmployer(Employer employer);

    public Employer findEmployerById(int employerId);

    public List<Employer> findAllEmployer();

    public void updateEmployer(Employer employer);

    public void deleteEmployer(Integer employerId);
}
