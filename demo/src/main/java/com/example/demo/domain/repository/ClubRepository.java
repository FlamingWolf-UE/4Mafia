package com.example.demo.domain.repository;

import com.example.demo.domain.model.Club;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubRepository extends JpaRepository<Club,Integer> {
}
