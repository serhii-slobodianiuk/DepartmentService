package com.slobodianiuk.departmentservice.service.facade;

import com.slobodianiuk.departmentservice.dto.EmployeeDto;
import com.slobodianiuk.departmentservice.service.BaseCrudService;

import java.util.List;

public interface EmployeeFacade extends BaseCrudService<EmployeeDto> {

    List<EmployeeDto> getAllByDepId(Integer id);
}
