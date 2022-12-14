package com.example.demo.domain.repository;

import com.example.demo.domain.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface GameRepository extends JpaRepository<Game,Integer> {

}

