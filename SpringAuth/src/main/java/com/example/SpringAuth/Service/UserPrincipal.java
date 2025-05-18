package com.example.SpringAuth.Service;

import com.example.SpringAuth.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;


public class UserPrincipal implements UserDetails {
    @Autowired
    private  User user;

    public UserPrincipal(User user) {
        this.user = user;
    }

    public UserPrincipal() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return List.of();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
