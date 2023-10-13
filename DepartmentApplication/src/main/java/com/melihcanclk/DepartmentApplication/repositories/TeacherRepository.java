package com.melihcanclk.DepartmentApplication.repositories;

import com.melihcanclk.DepartmentApplication.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
