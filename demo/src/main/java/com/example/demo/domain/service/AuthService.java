
package com.example.demo.domain.service;

import com.example.demo.domain.entityModel.UserAdditionalModel;
import com.example.demo.domain.model.ClubRole;
import com.example.demo.domain.model.UserAdditional;
import com.example.demo.domain.repository.UserAdditionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthService {
    @Autowired
    private UserAdditionalRepository repository;

    public AuthService(UserAdditionalRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public UserAdditional GetAuthentificatedUserData()
    {
        var user = (UserAdditional) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return  repository.findById(user.getId()).get();
    }

    @Transactional(readOnly = true)
    public Integer GetAuthentificatedUserId()
    {
        var user = (UserAdditional) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user.getId();
    }

    @Transactional(readOnly = true)
    public List<String> GetAuthentificatedUserRoles()
    {
        var user = (UserAdditional) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return user.getRoles().stream().map(ClubRole::getDescription).collect(Collectors.toList());
    }

}

