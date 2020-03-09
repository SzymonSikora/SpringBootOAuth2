package com.webservice.dexter_service.Security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.Set;

public class CustomUserDetail extends User {

    private Set<Integer> permissions;

    public Set<Integer> getPermissions() {
        return permissions;
    }

    public CustomUserDetail(String username, String password, Collection<? extends GrantedAuthority> authorities, Set<Integer> permissions) {
        super(username, password, authorities);
        this.permissions = permissions;
    }
}
