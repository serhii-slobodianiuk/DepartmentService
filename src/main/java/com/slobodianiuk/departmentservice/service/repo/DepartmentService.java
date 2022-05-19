package com.slobodianiuk.departmentservice.service.repo;

import com.slobodianiuk.departmentservice.model.Department;
import com.slobodianiuk.departmentservice.service.BaseCrudService;

public interface DepartmentService extends BaseCrudService<Department> {

    Department getByName(String name);
}
