package com.melihcanclk.DepartmentApplication.event.listeners;

import com.melihcanclk.DepartmentApplication.entities.User;
import com.melihcanclk.DepartmentApplication.event.PasswordResetCompleteEvent;
import com.melihcanclk.DepartmentApplication.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class PasswordResetCompleteEventListener implements ApplicationListener<PasswordResetCompleteEvent> {
    @Autowired
    private UserService userService;

    @Override
    public void onApplicationEvent(PasswordResetCompleteEvent event) {
        // create verification token
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        // save token
        userService.savePasswordResetToken(user, token);
        String url = event.getApplicationUrl() + "/savePassword?token=" + token;
        // TODO: send email method
        log.info("Password Reset Verification URL: " + url);
    }
}
