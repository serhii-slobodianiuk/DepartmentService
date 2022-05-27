package com.slobodianiuk.departmentservice.dto;

import com.slobodianiuk.departmentservice.model.Department;
import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;

import java.sql.Date;
import java.util.Objects;

public class EmployeeDto {
    Integer id;
    String birthday;
    double salary;

    @NotNull(message = "Name can't be null")
    @NotEmpty(message = "Name can't be empty")
    public String name;

    @NotNull(message = "Phone number can't be null")
    @NotEmpty(message = "Phone number can't be empty")
    String phoneNumber;

    @NotNull(message = "Email can't be null")
    @NotEmpty(message = "Email can't be empty")
    String email;

    @NotNull(message = "Department can't be null")
    Department dept;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getBirthday() {
        return Date.valueOf(birthday);
    }

    public void setBirthday(Date birthday) {
        this.birthday = String.valueOf(birthday);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeDto that = (EmployeeDto) o;
        return Double.compare(that.salary, salary) == 0
                && Objects.equals(id, that.id)
                && Objects.equals(birthday, that.birthday)
                && Objects.equals(name, that.name)
                && Objects.equals(phoneNumber, that.phoneNumber)
                && Objects.equals(email, that.email)
                && Objects.equals(dept, that.dept);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, birthday, salary, name, phoneNumber, email, dept);
    }
}

