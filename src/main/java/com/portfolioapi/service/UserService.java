package com.portfolioapi.service;

import com.portfolioapi.entity.User;
import com.portfolioapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    // Used to check if username exists
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // Used to save a new user
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Used by Spring Security during login
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                Collections.emptyList()
        );
    }
}
