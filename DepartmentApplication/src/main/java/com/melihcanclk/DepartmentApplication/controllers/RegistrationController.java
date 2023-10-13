package com.melihcanclk.DepartmentApplication.controllers;

import com.melihcanclk.DepartmentApplication.entities.User;
import com.melihcanclk.DepartmentApplication.entities.VerificationToken;
import com.melihcanclk.DepartmentApplication.event.RegistrationCompleteEvent;
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

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }

    private static String getApplicationPath(HttpServletRequest request) {
        return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }
}
