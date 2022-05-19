package com.slobodianiuk.departmentservice.service.repo.impl;

import com.google.common.collect.Lists;
import com.slobodianiuk.departmentservice.model.Department;
import com.slobodianiuk.departmentservice.repository.DepartmentRepository;
import com.slobodianiuk.departmentservice.service.repo.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository repository;

    @Override
    public void create(Department department) {
        repository.save(department);
    }

    public List<Department> getAll() {
        return Lists.newArrayList(repository.findAll());
    }

    @Override
    public Department getById(Integer id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public void edit(Department department) {
        repository.save(department);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Department getByName(String name) {
        return repository.findByName(name).orElseThrow();
    }

    @Autowired
    public void setRepository(DepartmentRepository repository) {
        this.repository = repository;
    }
}