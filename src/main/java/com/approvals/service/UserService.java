package com.approvals.service;

import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import com.approvals.model.WebUser;
import com.approvals.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        WebUser user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword()) // debe estar encriptado con BCrypt
                .roles(user.getRole().name())
                .build();
    }
}
