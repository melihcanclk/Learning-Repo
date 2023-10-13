package com.melihcanclk.DepartmentApplication.services;

import com.melihcanclk.DepartmentApplication.entities.User;
import com.melihcanclk.DepartmentApplication.entities.VerificationToken;
import com.melihcanclk.DepartmentApplication.model.UserModel;
import com.melihcanclk.DepartmentApplication.repositories.UserRepository;
import com.melihcanclk.DepartmentApplication.repositories.VerificationTokenRepository;
import jakarta.transaction.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private VerificationTokenRepository verificationTokenRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User register(UserModel userModel) {
        User user = new User();
        user.setName(userModel.getName());
        user.setSurname(userModel.getSurname());
        user.setEmail(userModel.getEmail());
        user.setRole("USER");

        // check password and matchingPassword  are equal
        if (!userModel.getPassword().equals(userModel.getMatchingPassword())) {
            return null;
        }

        // encode password
        user.setPassword(passwordEncoder.encode(userModel.getPassword()));
        // save user
        userRepository.save(user);
        return user;
    }

    @Override
    public void saveVerificationToken(User user, String token) {
        VerificationToken verificationToken = new VerificationToken(
                user, token
        );
        verificationTokenRepository.save(verificationToken);
    }

    @Override
    @Transactional
    public boolean verifyRegistration(String token) {
        VerificationToken verificationToken = verificationTokenRepository.findByToken(token);
        if (verificationToken == null) {
            return false;
        }
        User user = verificationToken.getUser();
        Calendar calendar = Calendar.getInstance();
        if ((verificationToken.getExpiryDate().getTime() - calendar.getTime().getTime()) <= 0) {
            verificationTokenRepository.delete(verificationToken);
            return false;
        }

        if (verificationToken.isVerified()) {
            System.out.println("Already verified");
            return false;
        }

        user.setEnabled(true);
        verificationToken.setVerified(true);
        userRepository.save(user);
        return true;
    }

    @Override
    public VerificationToken getVerificationToken(String oldToken) {
        VerificationToken verificationToken = verificationTokenRepository.findByToken(oldToken);
        if (verificationToken == null) {
            return null;
        }
        verificationTokenRepository.delete(verificationToken);
        return verificationToken;
    }
}
