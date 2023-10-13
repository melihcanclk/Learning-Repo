package com.melihcanclk.DepartmentApplication.services;

import com.melihcanclk.DepartmentApplication.entities.User;
import com.melihcanclk.DepartmentApplication.entities.VerificationToken;
import com.melihcanclk.DepartmentApplication.model.UserModel;

public interface UserService {
    User register(UserModel userModel);

    void saveVerificationToken(User user, String token);

    boolean verifyRegistration(String token);

    VerificationToken getVerificationToken(String oldToken);
}
