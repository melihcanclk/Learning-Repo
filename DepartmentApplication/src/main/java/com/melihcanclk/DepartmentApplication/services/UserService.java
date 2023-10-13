package com.melihcanclk.DepartmentApplication.services;

import com.melihcanclk.DepartmentApplication.entities.PasswordResetToken;
import com.melihcanclk.DepartmentApplication.entities.User;
import com.melihcanclk.DepartmentApplication.entities.VerificationToken;
import com.melihcanclk.DepartmentApplication.model.PasswordModel;
import com.melihcanclk.DepartmentApplication.model.UserModel;

public interface UserService {
    User register(UserModel userModel);

    void saveVerificationToken(User user, String token);

    boolean verifyRegistration(String token);

    VerificationToken getVerificationToken(String oldToken);

    User findUserByEmail(String email);

    PasswordResetToken savePasswordResetToken(User user, String token);

    PasswordResetToken getPasswordResetToken(String token);

    void changeUserPassword(PasswordResetToken passwordResetToken, PasswordModel passwordModel);
}
