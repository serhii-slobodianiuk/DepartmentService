package com.slobodianiuk.departmentservice.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "EMPLOYEES")
public class Employee {

    private Integer id;
    private Double salary;
    private Date birthday;
    private String name;
    private String phoneNumber;
    private String email;
    private Department dept;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "salary")
    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Basic
    @Column(name = "birthday")
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "phoneNumber")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Basic
    @Column(name = "e_mail")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @ManyToOne
    @JoinColumn(name = "dep_id", referencedColumnName = "id")
    public Department getDept() {
        return dept;
    }

    public void setDept(Department departmentsByDepId) {
        this.dept = departmentsByDepId;
    }
}
