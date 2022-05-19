package com.slobodianiuk.departmentservice.service.repo;

import com.slobodianiuk.departmentservice.model.Employee;
import com.slobodianiuk.departmentservice.service.BaseCrudService;

import java.util.List;

public interface EmployeeService extends BaseCrudService<Employee> {
    List<Employee> getAllByDepartmentId(Integer id);
}
