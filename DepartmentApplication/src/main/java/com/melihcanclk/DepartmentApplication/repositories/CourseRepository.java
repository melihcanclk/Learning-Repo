package com.melihcanclk.DepartmentApplication.repositories;

import com.melihcanclk.DepartmentApplication.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
