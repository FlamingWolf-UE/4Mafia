package com.example.demo.domain.repository;

import com.example.demo.domain.model.GameResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameResultRepository extends JpaRepository<GameResult,Integer> {
}
