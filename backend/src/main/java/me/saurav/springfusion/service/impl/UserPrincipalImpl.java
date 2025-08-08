package me.saurav.springfusion.service.impl;

import java.time.Instant;
import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.RequiredArgsConstructor;
import me.saurav.springfusion.modal.User;

@RequiredArgsConstructor
public class UserPrincipalImpl implements UserDetails {

    private final User user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    public String getName() {
        return user.getUsername();
    }

    public Instant createdAt() {
        return user.getCreatedAt();
    }

    public Instant updatedAt() {
        return user.getUpdatedAt();
    }
}