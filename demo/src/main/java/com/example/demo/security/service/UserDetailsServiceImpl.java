package com.example.demo.security.service;

import com.example.demo.domain.model.UserAdditional;
import com.example.demo.domain.repository.UserAdditionalRepository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserAdditionalRepository userRepository;
    public UserDetailsServiceImpl(UserAdditionalRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserAdditional user = userRepository.findByUsername(userName);
        if (user == null) {
            System.out.println("User is not Found");
            throw new UsernameNotFoundException("User is not Found");
        }

       return user;
    }
}