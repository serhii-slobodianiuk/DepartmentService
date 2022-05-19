package com.slobodianiuk.departmentservice.repository;

import com.slobodianiuk.departmentservice.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    @Query("select e from Employee e where e.dept.id = ?1")
    List<Employee> getByDepartmentId(Integer id);
}
