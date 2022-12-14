package com.example.demo.domain.repository;

import com.example.demo.domain.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place,Integer> {
}
