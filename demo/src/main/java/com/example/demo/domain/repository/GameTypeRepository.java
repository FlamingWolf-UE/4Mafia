package com.example.demo.domain.repository;

import com.example.demo.domain.model.GameType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameTypeRepository extends JpaRepository<GameType, Integer> {
}
