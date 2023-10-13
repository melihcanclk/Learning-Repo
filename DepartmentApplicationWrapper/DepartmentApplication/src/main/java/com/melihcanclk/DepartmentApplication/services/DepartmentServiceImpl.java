package com.melihcanclk.DepartmentApplication.services;

import com.melihcanclk.DepartmentApplication.entities.Department;
import com.melihcanclk.DepartmentApplication.errors.DepartmentNotFoundException;
import com.melihcanclk.DepartmentApplication.repositories.DepartmentRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long id) throws DepartmentNotFoundException {
        return departmentRepository.findById(id).orElseThrow(
                () -> new DepartmentNotFoundException("Department not found for id: " + id)
        );
    }

    @Override
    public void deleteDepartmentById(Long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public Department updateDepartment(Long id, Department department) {
        Department departmentToUpdate = departmentRepository.findById(id).orElse(null);

        if(departmentToUpdate == null) {
            throw new RuntimeException("Department not found for id: " + id);
        }

        departmentToUpdate.setName(department.getName());
        departmentToUpdate.setAddress(department.getAddress());
        departmentToUpdate.setCode(department.getCode());

        return departmentRepository.save(departmentToUpdate);
    }

    @Override
    public Department getDepartmentByName(String name) {
        Department department = departmentRepository.findByName(name);

        if(department == null) {
            throw new RuntimeException("Department not found for name: " + name);
        }
        return department;

    }
}
