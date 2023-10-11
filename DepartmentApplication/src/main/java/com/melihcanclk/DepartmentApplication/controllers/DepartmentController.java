package com.melihcanclk.DepartmentApplication.controllers;

import com.melihcanclk.DepartmentApplication.entities.Department;
import com.melihcanclk.DepartmentApplication.services.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("")
    public Department save(@Valid @RequestBody Department department) {
        return departmentService.save(department);
    }

    @GetMapping("")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable Long id) {
        return departmentService.getDepartmentById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartmentById(@PathVariable Long id) {
        departmentService.deleteDepartmentById(id);
    }

    @PutMapping("/{id}")
    public Department updateDepartment(@PathVariable Long id ,@RequestBody Department department) {
        return departmentService.updateDepartment(id,department);
    }

    // get department by name
    @GetMapping("/name/{name}")
    public Department getDepartmentByName(@PathVariable String name) {
        return departmentService.getDepartmentByName(name);
    }


}
