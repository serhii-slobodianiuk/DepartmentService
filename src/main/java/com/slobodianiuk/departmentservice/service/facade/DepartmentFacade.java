package com.slobodianiuk.departmentservice.service.facade;

import com.slobodianiuk.departmentservice.dto.DepartmentDto;
import com.slobodianiuk.departmentservice.service.BaseCrudService;

public interface DepartmentFacade extends BaseCrudService<DepartmentDto> {
    DepartmentDto getByName(String name);
}