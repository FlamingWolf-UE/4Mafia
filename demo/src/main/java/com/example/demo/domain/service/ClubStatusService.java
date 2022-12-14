package com.example.demo.domain.service;

import com.example.demo.domain.model.ClubStatus;
import com.example.demo.domain.repository.ClubStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClubStatusService {
    @Autowired
    private final ClubStatusRepository repository;
    public ClubStatusService(ClubStatusRepository ClubStatusRepository) {
        this.repository=ClubStatusRepository;
    }

    public List<ClubStatus> getAll()
    {
        return repository.findAll();
    }

    public void AddHero(ClubStatus ClubStatus) {repository.save(ClubStatus);}

    public Optional<ClubStatus> GetByID(Integer id)
    {
        return repository.findById(id);
    }

    public void Delete(Integer id)
    {
        repository.deleteById(id);
    }

    public void Update(ClubStatus ClubStatus)
    {
        repository.save(ClubStatus);
    }
}
