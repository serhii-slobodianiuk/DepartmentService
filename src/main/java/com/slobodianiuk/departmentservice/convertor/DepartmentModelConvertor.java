package com.slobodianiuk.departmentservice.convertor;

import com.slobodianiuk.departmentservice.dto.DepartmentDto;
import com.slobodianiuk.departmentservice.model.Department;
import org.springframework.stereotype.Component;

@Component
public class DepartmentModelConvertor implements Convertor<Department, DepartmentDto> {

    @Override
    public Department convertToModel(DepartmentDto departmentDto) {
        Department department = new Department();
        if (departmentDto.getId() == null) {
            department.setId(0);
        } else {
            department.setId(departmentDto.getId());
        }
        department.setName(departmentDto.getName());
        return department;
    }

    @Override
    public DepartmentDto convertFromModel(Department departmentModel) {
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setId(departmentModel.getId());
        departmentDto.setName(departmentModel.getName());
        return departmentDto;
    }
}