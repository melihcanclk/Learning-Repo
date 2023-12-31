package com.melihcanclk.DepartmentApplication.services;

import com.melihcanclk.DepartmentApplication.entities.Department;
import com.melihcanclk.DepartmentApplication.errors.DepartmentNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartmentService {
    Department save(Department department);

    List<Department> getAllDepartments();

    Department getDepartmentById(Long id) throws DepartmentNotFoundException;

    void deleteDepartmentById(Long id);

    Department updateDepartment(Long id, Department department);

    Department getDepartmentByName(String name);
}
