package com.slobodianiuk.departmentservice.dto;

import com.slobodianiuk.departmentservice.model.Employee;
import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;

import java.util.List;
import java.util.Objects;

public class DepartmentDto {

    @NotNull(message = "Name can't be null")
    @NotEmpty(message = "Name can't be empty")
    public String name;
    public List<Employee> employees;
    Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DepartmentDto)) return false;
        DepartmentDto that = (DepartmentDto) o;
        return getId().equals(that.getId())
                && getName().equals(that.getName())
                && Objects.equals(getEmployees(), that.getEmployees());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getEmployees());
    }
}