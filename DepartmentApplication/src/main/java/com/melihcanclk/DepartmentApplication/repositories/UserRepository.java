package com.melihcanclk.DepartmentApplication.repositories;

import com.melihcanclk.DepartmentApplication.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean findByEmail(String email);
}
