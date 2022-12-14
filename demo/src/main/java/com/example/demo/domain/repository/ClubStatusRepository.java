package com.example.demo.domain.repository;

import com.example.demo.domain.model.ClubStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Transactional(propagation = Propagation.REQUIRED)
public interface ClubStatusRepository extends JpaRepository<ClubStatus,Integer> {
}
