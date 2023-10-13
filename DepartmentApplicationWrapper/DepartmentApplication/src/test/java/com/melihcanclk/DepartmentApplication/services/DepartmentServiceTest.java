package com.melihcanclk.DepartmentApplication.services;

import com.melihcanclk.DepartmentApplication.entities.Department;
import com.melihcanclk.DepartmentApplication.repositories.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .name("IT")
                .address("Istanbul")
                .code("IT-01")
                .id(1L)
                .build();

        Mockito.when(departmentRepository.findByName("IT"))
                .thenReturn(department);
    }

    @Test
    @DisplayName("Get Data based on Valid Department Name")
    public void whenValidDepartmentName_thenDepartmentShouldFound() {
        String name = "IT";
        Department found = departmentService.getDepartmentByName(name);
        assertEquals(name, found.getName());
    }
}