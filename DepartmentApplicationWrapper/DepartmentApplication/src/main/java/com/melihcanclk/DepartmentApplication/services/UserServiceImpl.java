package com.melihcanclk.DepartmentApplication.services;

import com.melihcanclk.DepartmentApplication.entities.PasswordResetToken;
import com.melihcanclk.DepartmentApplication.entities.User;
import com.melihcanclk.DepartmentApplication.entities.VerificationToken;
import com.melihcanclk.DepartmentApplication.model.PasswordModel;
import com.melihcanclk.DepartmentApplication.model.UserModel;
import com.melihcanclk.DepartmentApplication.repositories.PasswordResetTokenRepository;
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

    @Autowired
    private PasswordResetTokenRepository passwordResetTokenRepository;

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

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public PasswordResetToken savePasswordResetToken(User user, String token) {
        PasswordResetToken passwordResetToken = new PasswordResetToken(
                user, token
        );


        passwordResetTokenRepository.save(passwordResetToken);
        return passwordResetToken;
    }

    @Override
        public PasswordResetToken getPasswordResetToken(String oldToken) {
        return passwordResetTokenRepository.findByToken(oldToken);

    }

    @Override
    public void changeUserPassword(PasswordResetToken passwordResetToken, PasswordModel passwordModel) {
        User user = passwordResetToken.getUser();
        // check password and matchingPassword  are equal
        if (!passwordModel.getPassword().equals(passwordModel.getPasswordConfirm())) {
            System.out.println("Password and passwordConfirm are not equal");
            return;
        }

        // encode password
        user.setPassword(passwordEncoder.encode(passwordModel.getPassword()));

        userRepository.save(user);
        passwordResetTokenRepository.delete(passwordResetToken);
    }
}
