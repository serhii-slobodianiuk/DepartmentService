package com.slobodianiuk.departmentservice.repository;

import com.slobodianiuk.departmentservice.model.Department;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Integer> {

    @Query("select d from Department d where d.name = ?1")
    Optional<Department> findByName(String name);
}