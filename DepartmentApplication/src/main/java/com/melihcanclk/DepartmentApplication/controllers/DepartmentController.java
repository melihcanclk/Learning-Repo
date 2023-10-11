package com.melihcanclk.DepartmentApplication.controllers;

import com.melihcanclk.DepartmentApplication.entities.Department;
import com.melihcanclk.DepartmentApplication.errors.DepartmentNotFoundException;
import com.melihcanclk.DepartmentApplication.services.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {

    private final DepartmentService departmentService;
    private final Logger LOGGER = Logger.getLogger(DepartmentController.class.getName());

    @Value("${some.config}")
    private String someConfigInApplicationProperties;

    DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("")
    public Department save(@Valid @RequestBody Department department) {
        LOGGER.info("Inside save method of DepartmentController");
        return departmentService.save(department);
    }

    @GetMapping("")
    public List<Department> getAllDepartments() {
        LOGGER.info("Inside getAllDepartments method of DepartmentController");
        return departmentService.getAllDepartments();
    }

    @GetMapping("/some-config")
    public String getSomeConfigInApplicationProperties() {
        return someConfigInApplicationProperties;
    }

    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable Long id) throws DepartmentNotFoundException {
        LOGGER.info("Inside getDepartmentById method of DepartmentController");
        return departmentService.getDepartmentById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartmentById(@PathVariable Long id) {
        LOGGER.info("Inside deleteDepartmentById method of DepartmentController");
        departmentService.deleteDepartmentById(id);
    }

    @PutMapping("/{id}")
    public Department updateDepartment(@PathVariable Long id ,@RequestBody Department department) {
        LOGGER.info("Inside updateDepartment method of DepartmentController");
        return departmentService.updateDepartment(id,department);
    }

    // get department by name
    @GetMapping("/name/{name}")
    public Department getDepartmentByName(@PathVariable String name) {
        LOGGER.info("Inside getDepartmentByName method of DepartmentController");
        return departmentService.getDepartmentByName(name);
    }
}
