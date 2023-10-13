package com.melihcanclk.DepartmentApplication.repositories;

import com.melihcanclk.DepartmentApplication.entities.PasswordResetToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long> {
    PasswordResetToken findByToken(String token);
}
