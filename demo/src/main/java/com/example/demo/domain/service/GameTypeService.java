package com.example.demo.domain.service;

import com.example.demo.domain.model.GameRole;
import com.example.demo.domain.model.GameType;
import com.example.demo.domain.repository.GameRoleRepository;
import com.example.demo.domain.repository.GameTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameTypeService {
    @Autowired
    private final GameTypeRepository repository;
    public GameTypeService(GameTypeRepository GameTypeRepository) {
        this.repository = GameTypeRepository;
    }

    public List<GameType> getAll()
    {
        return repository.findAll();
    }

    public void AddHero(GameType GameType) {repository.save(GameType);}

    public Optional<GameType> GetByID(Integer id)
    {
        return repository.findById(id);
    }

    public void Delete(Integer id)
    {
        repository.deleteById(id);
    }

    public void Update(GameType GameType)
    {
        repository.save(GameType);
    }
}
