package com.melihcanclk.DepartmentApplication.event;

import com.melihcanclk.DepartmentApplication.entities.User;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter

public class PasswordResetCompleteEvent extends ApplicationEvent {

    private User user;
    private String applicationUrl;


    public PasswordResetCompleteEvent(User user, String applicationPath) {
        super(user);
        this.user = user;
        this.applicationUrl = applicationPath;
    }

}
