package com.slobodianiuk.departmentservice.service.facade.impl;

import com.slobodianiuk.departmentservice.convertor.Convertor;
import com.slobodianiuk.departmentservice.dto.EmployeeDto;
import com.slobodianiuk.departmentservice.model.Employee;
import com.slobodianiuk.departmentservice.service.facade.EmployeeFacade;
import com.slobodianiuk.departmentservice.service.repo.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeFacadeImpl implements EmployeeFacade {
    private Convertor<Employee, EmployeeDto> employeeModelConvertor;
    private EmployeeService employeeService;

    @Override
    public void create(EmployeeDto employeeDto) {
        employeeService.create(employeeModelConvertor.convertToModel(employeeDto));
    }

    @Override
    public List<EmployeeDto> getAll() {
        return getConvertedList(employeeService.getAll());
    }

    @Override
    public void edit(EmployeeDto employeeDto) {
        employeeService.edit(employeeModelConvertor.convertToModel(employeeDto));
    }

    @Override
    public void deleteById(Integer id) {
        employeeService.deleteById(id);
    }

    @Override
    public EmployeeDto getById(Integer id) {
        return employeeModelConvertor.convertFromModel(employeeService.getById(id));
    }

    @Override
    public List<EmployeeDto> getAllByDepId(Integer id) {
        return getConvertedList(employeeService.getAllByDepartmentId(id));
    }

    private List<EmployeeDto> getConvertedList(List<Employee> employeeList) {
        List<EmployeeDto> dtos = new ArrayList<>();
        for (Employee employee : employeeList) {
            dtos.add(employeeModelConvertor.convertFromModel(employee));
        }
        return dtos;
    }

    @Autowired
    public void setEmployeeModelConvertor(Convertor<Employee, EmployeeDto> employeeModelConvertor) {
        this.employeeModelConvertor = employeeModelConvertor;
    }

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
}