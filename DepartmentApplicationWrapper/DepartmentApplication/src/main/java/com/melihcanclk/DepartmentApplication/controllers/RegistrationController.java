package com.melihcanclk.DepartmentApplication.controllers;

import com.melihcanclk.DepartmentApplication.entities.PasswordResetToken;
import com.melihcanclk.DepartmentApplication.entities.User;
import com.melihcanclk.DepartmentApplication.entities.VerificationToken;
import com.melihcanclk.DepartmentApplication.event.PasswordResetCompleteEvent;
import com.melihcanclk.DepartmentApplication.event.RegistrationCompleteEvent;
import com.melihcanclk.DepartmentApplication.model.PasswordModel;
import com.melihcanclk.DepartmentApplication.model.ResetPasswordInputDTO;
import com.melihcanclk.DepartmentApplication.model.UserModel;
import com.melihcanclk.DepartmentApplication.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class RegistrationController {

    private final UserService userService;

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String register(@RequestBody UserModel userModel, final HttpServletRequest request) {
        User user = userService.register(userModel);
        if (user == null) {
            return "Error";
        }

        eventPublisher.publishEvent(new RegistrationCompleteEvent(
                user,
                getApplicationPath(request)
        ));

        return "Success";
    }

    @GetMapping("/verifyRegistration")
    public String registrationVerification(@RequestParam(name = "token") String token) {
        boolean result = userService.verifyRegistration(token);
        return result ? "Successfully Verified" : "Could not verify";
    }

    @GetMapping("/resendVerification")
    public String generateNewVerificationTokenFromOldToken(@RequestParam(name = "token") String oldToken,
                                                           final HttpServletRequest request) {
        VerificationToken verificationToken = userService.getVerificationToken(oldToken);
        if (verificationToken == null) {
            return "Invalid token";
        }

        User user = verificationToken.getUser();
        eventPublisher.publishEvent(new RegistrationCompleteEvent(
                user,
                getApplicationPath(request)
        ));
        return "Verification mail has been sent to your email address";
    }

    @PostMapping("/resetPassword")
    public String resetPassword(@RequestBody ResetPasswordInputDTO resetPasswordInputDTO, final HttpServletRequest request) {
        User user = userService.findUserByEmail(resetPasswordInputDTO.getEmail());
        if (user == null) {
            return "Error: User not found";
        }
        eventPublisher.publishEvent(new PasswordResetCompleteEvent(
                user,
                getApplicationPath(request)
        ));
        return "Password reset mail has been sent to your email address";
    }

    @PostMapping("/savePassword")
    public String savePassword(@RequestParam String token, @RequestBody PasswordModel passwordModel){
        PasswordResetToken passwordResetToken = userService.getPasswordResetToken(token);
        if (passwordResetToken == null) {
            return "Error: Password reset token is not found";
        }

        User user = passwordResetToken.getUser();
        if (user == null) {
            return "Error: User not found";
        }

        userService.changeUserPassword(passwordResetToken, passwordModel);
        return "Password has been changed successfully";

    }

    private String passwordResetTokenMail(User user, HttpServletRequest request) {
        eventPublisher.publishEvent(new PasswordResetCompleteEvent(
                user,
                getApplicationPath(request)
        ));
        return "Password reset mail has been sent to your email address";
    }


    @GetMapping("/api/hello")
    public String hello() {
        return "Hello";
    }

    private static String getApplicationPath(HttpServletRequest request) {
        return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }
}
