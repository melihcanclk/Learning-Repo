package com.melihcanclk.OauthServer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.melihcanclk.OauthServer.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByEmail(String email);
}
