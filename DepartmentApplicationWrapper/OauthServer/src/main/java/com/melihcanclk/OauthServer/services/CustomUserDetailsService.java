package com.melihcanclk.OauthServer.services;

import com.melihcanclk.OauthServer.entities.User;
import com.melihcanclk.OauthServer.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findUserByEmail(username);
        if(user != null)
            return org.springframework.security.core.userdetails.User
                    .withUsername(username)
                    .password(user.getPassword())
                    .authorities(getAuthorities(user.getRole()))
                    .disabled(!user.isEnabled())
                    .accountExpired(false)
                    .accountLocked(false)
                    .credentialsExpired(false)
                    .build();
        else
            throw new UsernameNotFoundException("User not found");
    }

    private Collection<? extends GrantedAuthority> getAuthorities(String role) {
        return List.of(() -> role);
    }
}
