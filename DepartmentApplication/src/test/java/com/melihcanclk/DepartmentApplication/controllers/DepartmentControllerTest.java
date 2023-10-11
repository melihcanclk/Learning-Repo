package com.melihcanclk.DepartmentApplication.controllers;

import com.melihcanclk.DepartmentApplication.entities.Department;
import com.melihcanclk.DepartmentApplication.services.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setUp() {
        department = Department.builder()
                .name("Mechanical Engineering")
                .address("Istanbul")
                .code("ME-01")
                .id(1L)
                .build();
    }

    @Test
    @DisplayName("Save Department")
    void save() throws Exception {
        Department inputDepartment = Department.builder()
                .name("Mechanical Engineering")
                .address("Istanbul")
                .code("ME-01")
                .build();

        Mockito.when(departmentService.save(inputDepartment)).thenReturn(department);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/api/v1/departments")
                .content("""
                        {
                            "id": 1,
                            "name": "Mechanical Engineering",
                            "address": "Istanbul",
                            "code": "ME-01"
                        }""")
                .contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers
                                .status()
                                .isOk()
                );

    }

    @Test
    @DisplayName("Get All Departments")
    void getAllDepartments() throws Exception {
        Mockito.when(departmentService.getAllDepartments()).thenReturn(java.util.List.of(department));

        // the reason in MockMvcResultMatchers jsonPath we use $[0] is because we are returning a list of departments,
        // and we are expecting the first element of the list to be equal to the department object we created above
        mockMvc.perform(
                MockMvcRequestBuilders.get("/api/v1/departments")
                .contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers
                                .status()
                                .isOk()
                ).andExpect(
                        MockMvcResultMatchers
                                .jsonPath("$[0].id")
                                .value(department.getId())
                ).andExpect(
                        MockMvcResultMatchers
                                .jsonPath("$[0].name")
                                .value(department.getName())
                ).andExpect(
                        MockMvcResultMatchers
                                .jsonPath("$[0].address")
                                .value(department.getAddress())
                ).andExpect(
                        MockMvcResultMatchers
                                .jsonPath("$[0].code")
                                .value(department.getCode())
                );

    }

}