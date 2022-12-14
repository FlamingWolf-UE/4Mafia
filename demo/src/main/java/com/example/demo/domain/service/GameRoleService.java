package com.example.demo.domain.service;

import com.example.demo.domain.model.GameResult;
import com.example.demo.domain.model.GameRole;
import com.example.demo.domain.repository.GameResultRepository;
import com.example.demo.domain.repository.GameRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameRoleService {
    @Autowired
    private final GameRoleRepository repository;
    public GameRoleService(GameRoleRepository GameRoleRepository) {
        this.repository = GameRoleRepository;
    }

    public List<GameRole> getAll()
    {
        return repository.findAll();
    }

    public void AddHero(GameRole GameRole) {repository.save(GameRole);}

    public Optional<GameRole> GetByID(Integer id)
    {
        return repository.findById(id);
    }

    public void Delete(Integer id)
    {
        repository.deleteById(id);
    }

    public void Update(GameRole GameRole)
    {
        repository.save(GameRole);
    }
}
