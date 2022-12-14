package com.example.demo.domain.repository;

import com.example.demo.domain.model.UserAdditional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface UserAdditionalRepository extends JpaRepository<UserAdditional,Integer> {
    @Transactional
    UserAdditional findByUsername(String username);
    
}
