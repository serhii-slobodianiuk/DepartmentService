package com.slobodianiuk.departmentservice.service.repo.impl;

import com.google.common.collect.Lists;
import com.slobodianiuk.departmentservice.model.Employee;
import com.slobodianiuk.departmentservice.repository.EmployeeRepository;
import com.slobodianiuk.departmentservice.service.repo.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository repository;

    public List<Employee> getAll() {
        return Lists.newArrayList(repository.findAll());
    }

    public List<Employee> getAllByDepartmentId(Integer id) {
        return repository.getByDepartmentId(id);
    }

    public void create(Employee employee) {
        repository.save(employee);
    }

    public void edit(Employee employee) {
        repository.save(employee);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Employee getById(Integer id) {
        return repository.findById(id).orElseThrow();
    }

    @Autowired
    public void setRepository(EmployeeRepository repository) {
        this.repository = repository;
    }
}