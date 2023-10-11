package com.melihcanclk.DepartmentApplication.repositories;

import com.melihcanclk.DepartmentApplication.entities.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager entityManager;


    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .name("Mechanical Engineering")
                .address("Istanbul")
                .code("ME-01")
                .build();

        entityManager.persist(department);
    }

    @Test
    public void whenFindById_thenReturnDepartment() {
        Department found = departmentRepository.findById(1L).get();
        assertEquals(found.getName(), "Mechanical Engineering");
    }
}