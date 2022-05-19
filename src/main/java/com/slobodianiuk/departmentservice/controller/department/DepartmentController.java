package com.slobodianiuk.departmentservice.controller.department;

import com.slobodianiuk.departmentservice.dto.DepartmentDto;
import com.slobodianiuk.departmentservice.service.BaseCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private BaseCrudService<DepartmentDto> departmentFacade;

    @GetMapping(value = "/show_create_form")
    public ModelAndView showCreateForm() {
        return new ModelAndView("/department/create_department", "departmentDto", new DepartmentDto());
    }

    @PostMapping(value = "/create_department")
    public ModelAndView createDepartment(@Valid DepartmentDto departmentDto, BindingResult bindingResult, ModelAndView model) {
        if (bindingResult.hasErrors()) {
            model.addObject("errors", bindingResult);
            model.addObject("general_error_message", "The Error Occurred");
            model.setViewName("/department/create_department");
            return model;
        }
        departmentFacade.create(departmentDto);
        model.setViewName("redirect:/department/display_departments");
        model.addObject("departments", departmentFacade.getAll());
        return model;
    }

    @GetMapping(value = "/display_departments")
    public ModelAndView displayDepartment(ModelAndView model) {
        model.setViewName("/department/display_departments");
        model.addObject("departments", departmentFacade.getAll());
        return model;
    }

    @GetMapping(value = "/show_edit_form")
    public ModelAndView showEditForm(@RequestParam(value = "id") Integer id) {
        ModelAndView model = new ModelAndView();
        model.setViewName("/department/edit_department");
        model.addObject("departmentDto", new DepartmentDto());
        model.addObject("dep_id", id);
        //for placeholder on .jsp
        model.addObject("dep_name", departmentFacade.getById(id).getName());
        return model;
    }

    @PostMapping(value = "/edit_department")
    public ModelAndView editDepartment(@Valid DepartmentDto departmentDto, BindingResult bindingResult, ModelAndView model) {
        if (bindingResult.hasErrors()) {
            model.addObject("errors", bindingResult);
            model.setViewName("/department/edit_department");
            model.addObject("general_error_message", "The Error Occurred");
            model.addObject("dep_id", departmentDto.getId());
            return model;
        }
        departmentFacade.edit(departmentDto);
        return new ModelAndView("redirect:/department/display_departments");
    }

    @GetMapping(value = "/delete_department")
    public ModelAndView deleteDepartment(@RequestParam(value = "id") Integer id) {
        ModelAndView model = new ModelAndView();
        departmentFacade.deleteById(id);
        model.setViewName("redirect:/department/display_departments");
        model.addObject("departments", departmentFacade.getAll());
        return model;
    }

    @Autowired
    public void setDepartmentFacade(BaseCrudService<DepartmentDto> departmentFacade) {
        this.departmentFacade = departmentFacade;
    }
}