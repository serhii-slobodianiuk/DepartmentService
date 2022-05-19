package com.slobodianiuk.departmentservice.controller.employee;

import com.slobodianiuk.departmentservice.dto.EmployeeDto;

import com.slobodianiuk.departmentservice.service.facade.DepartmentFacade;
import com.slobodianiuk.departmentservice.service.facade.EmployeeFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private EmployeeFacade employeeFacade;
    private DepartmentFacade departmentFacade;

    @GetMapping(value = "/show_create_form")
    public ModelAndView showCreateForm() {
        ModelAndView model = new ModelAndView("/employee/create_employee", "employeeDto", new EmployeeDto());
        model.addObject("departments", departmentFacade.getAll());
        return model;
    }

    @PostMapping(value = "/create_employee")
    public ModelAndView createEmployee(@Valid EmployeeDto employeeDto, BindingResult bindingResult, ModelAndView model) {

        if (bindingResult.hasErrors()) {
            model.addObject("errors", bindingResult);
            model.setViewName("/employee/create_employee");
            model.addObject("general_error_message", "The Error Occurred");
            model.addObject("employeeDto", employeeDto);
            model.addObject("departments", departmentFacade.getAll());
            return model;
        }
        model.addObject("departments", departmentFacade.getAll());
        employeeFacade.create(employeeDto);
        model.setViewName("redirect:/employee/display_employees");
        model.addObject("employees", employeeFacade.getAll());
        return model;
    }

    @GetMapping(value = "/display_employees")
    public ModelAndView displayEmployee(ModelAndView model) {
        model.addObject("employees", employeeFacade.getAll());
        model.setViewName("/employee/display_employees");
        return model;
    }

    @GetMapping(value = "/display_employees_by_dep_id")
    public ModelAndView displayEmployeeByDepId(@RequestParam(value = "id") Integer id, ModelAndView model) {
        model.addObject("employees", employeeFacade.getAllByDepId(id));
        model.setViewName("/employee/display_employees");
        return model;
    }

    @GetMapping(value = "/show_edit_form")
    public ModelAndView showEditForm(@RequestParam(value = "id") Integer id) {
        ModelAndView model = new ModelAndView();
        EmployeeDto employeeDto = employeeFacade.getById(id);
        model.addObject("employee", new EmployeeDto());
        model.setViewName("/employee/edit_employee");
        //for placeholder on .jsp
        model.addObject("id", id);
        model.addObject("employeeDto", employeeDto);
        model.addObject("departmentDtos", departmentFacade.getAll());
        return model;
    }

    @PostMapping(value = "/edit_employee")
    public ModelAndView editEmployee(@Valid EmployeeDto employeeDto, BindingResult bindingResult, ModelAndView model) {
        if (bindingResult.hasErrors()) {
            model.addObject("errors", bindingResult);
            model.setViewName("/employee/edit_employee");
            model.addObject("general_error_message", "The Error Occurred");
            model.addObject("id", employeeDto.getId());
            return model;
        }
        model.addObject("departmentDtos", departmentFacade.getAll());
        employeeFacade.edit(employeeDto);
        return new ModelAndView("redirect:/employee/display_employees");
    }

    @GetMapping(value = "/delete_employee")
    public ModelAndView deleteEmployee(@RequestParam(value = "id") Integer id, ModelAndView model) {
        employeeFacade.deleteById(id);
        model.addObject("employees", employeeFacade.getAll());
        model.setViewName("redirect:/employee/display_employees");
        return model;
    }

    @Autowired
    public void setEmployeeFacade(EmployeeFacade employeeFacade) {
        this.employeeFacade = employeeFacade;
    }

    @Autowired
    public void setDepartmentFacade(DepartmentFacade departmentFacade) {
        this.departmentFacade = departmentFacade;
    }
}