package com.example.demo.domain.service;

import com.example.demo.domain.model.City;
import com.example.demo.domain.model.Club;
import com.example.demo.domain.repository.CityRepository;
import com.example.demo.domain.repository.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClubService {
    @Autowired
    private final ClubRepository repository;

    public ClubService(ClubRepository clubRepository) {
        this.repository=clubRepository;
    }
    @Transactional
    public List<Club> getAll()
    {
        return repository.findAll();
    }
    @Transactional
    public void AddHero(Club club) {repository.save(club);}
    @Transactional
    public Optional<Club> GetByID(Integer id)
    {
        return repository.findById(id);
    }
    @Transactional
    public void Delete(Integer id)
    {
        repository.deleteById(id);
    }
    @Transactional
    public void Update(Club club)
    {
        repository.save(club);
    }
}
