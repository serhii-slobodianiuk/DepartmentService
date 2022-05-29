package com.slobodianiuk.departmentservice.convertor;

import com.slobodianiuk.departmentservice.dto.EmployeeDto;
import com.slobodianiuk.departmentservice.model.Employee;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.text.SimpleDateFormat;

@Component
public class EmployeeModelConvertor implements Convertor<Employee, EmployeeDto> {

    @Override
    public Employee convertToModel(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setId(employeeDto.getId() == null ? Integer.valueOf(0) : employeeDto.getId());
        employee.setDept(employeeDto.getDept());
        employee.setName(employeeDto.getName());
        employee.setPhoneNumber(employeeDto.getPhoneNumber());
        employee.setEmail(employeeDto.getEmail());
        employee.setBirthday(employeeDto.getBirthday());
        employee.setSalary(employeeDto.getSalary());
        return employee;
    }

    @Override
    public EmployeeDto convertFromModel(Employee empl) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(empl.getId());
        employeeDto.setName(empl.getName());
        employeeDto.setPhoneNumber(empl.getPhoneNumber());
        employeeDto.setEmail(empl.getEmail());
        employeeDto.setBirthday(Date.valueOf(formatter.format(empl.getBirthday())));
        employeeDto.setSalary(empl.getSalary());
        employeeDto.setDept(empl.getDept());
        return employeeDto;
    }
}