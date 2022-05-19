package com.slobodianiuk.departmentservice.service.facade.impl;

import com.slobodianiuk.departmentservice.convertor.Convertor;
import com.slobodianiuk.departmentservice.dto.DepartmentDto;
import com.slobodianiuk.departmentservice.model.Department;
import com.slobodianiuk.departmentservice.service.facade.DepartmentFacade;
import com.slobodianiuk.departmentservice.service.repo.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentFacadeImpl implements DepartmentFacade {
    private Convertor<Department, DepartmentDto> departmentModelConvertor;
    private DepartmentService departmentService;

    @Override
    public void create(DepartmentDto departmentDto) {
        departmentService.create(departmentModelConvertor.convertToModel(departmentDto));
    }

    @Override
    public void edit(DepartmentDto departmentDto) {
        departmentService.edit(departmentModelConvertor.convertToModel(departmentDto));
    }

    @Override
    public List<DepartmentDto> getAll() {
        return getConvertedList(departmentService.getAll());
    }

    @Override
    public void deleteById(Integer id) {
        departmentService.deleteById(id);
    }

    @Override
    public DepartmentDto getById(Integer id) {
        return departmentModelConvertor.convertFromModel(departmentService.getById(id));
    }

    @Override
    public DepartmentDto getByName(String name) {
        return departmentModelConvertor.convertFromModel(departmentService.getByName(name));
    }

    private List<DepartmentDto> getConvertedList(List<Department> departmentList) {
        List<DepartmentDto> dtos = new ArrayList<>();
        for (Department department : departmentList) {
            dtos.add(departmentModelConvertor.convertFromModel(department));
        }
        return dtos;
    }

    @Autowired
    public void setDepartmentModelConvertor(Convertor<Department, DepartmentDto> departmentModelConvertor) {
        this.departmentModelConvertor = departmentModelConvertor;
    }

    @Autowired
    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
}