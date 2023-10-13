package com.melihcanclk.DepartmentApplication.event;

import com.melihcanclk.DepartmentApplication.entities.User;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class RegistrationCompleteEvent extends ApplicationEvent {

    private User user;
    private String applicationUrl;

    public RegistrationCompleteEvent(User user,String applicationUrl) {
        super(user);
        this.user = user;
        this.applicationUrl = applicationUrl;
    }
}
