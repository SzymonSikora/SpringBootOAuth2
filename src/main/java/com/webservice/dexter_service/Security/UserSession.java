package com.webservice.dexter_service.Security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public abstract class UserSession {

    public static CustomUserDetail getUserSession(){
        Object userSession = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (userSession != null && userSession instanceof UserDetails) {
            return ((CustomUserDetail)userSession);
        } else {
            return null;
        }
    }
}
