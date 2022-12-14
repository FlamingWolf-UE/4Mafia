package com.example.demo.domain.repository;

import com.example.demo.domain.model.GameRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRoleRepository extends JpaRepository<GameRole, Integer> {
}
