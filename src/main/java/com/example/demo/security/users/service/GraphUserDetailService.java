package com.example.demo.security.users.service;

import com.example.demo.security.CustomUserDetails;
import com.example.demo.security.users.model.User;
import com.example.demo.security.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class GraphUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findUser(username);
        return new CustomUserDetails(user);
    }

    public User findUser(String username) {
        return userRepository.findByUsername(username);
    }
}
