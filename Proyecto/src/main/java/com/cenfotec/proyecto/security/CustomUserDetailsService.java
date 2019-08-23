package com.cenfotec.proyecto.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.cenfotec.proyecto.repository.UserRepository;

@Component
public class CustomUserDetailsService implements UserDetailsService{
    private UserRepository users;

    public CustomUserDetailsService(UserRepository users) {
        this.users = users;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return this.users.findByUsername(email)
            .orElseThrow(() -> new UsernameNotFoundException("Username: " + email + " not found"));
    }
}