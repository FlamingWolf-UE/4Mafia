package com.example.demo.domain.service;

import com.example.demo.domain.model.Game;
import com.example.demo.domain.model.GameResult;
import com.example.demo.domain.repository.GameRepository;
import com.example.demo.domain.repository.GameResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameResultService {
    @Autowired
    private final GameResultRepository repository;
    public GameResultService(GameResultRepository GameResultRepository) {
        this.repository = GameResultRepository;
    }

    public List<GameResult> getAll()
    {
        return repository.findAll();
    }

    public void AddHero(GameResult GameResult) {repository.save(GameResult);}

    public Optional<GameResult> GetByID(Integer id)
    {
        return repository.findById(id);
    }

    public void Delete(Integer id)
    {
        repository.deleteById(id);
    }

    public void Update(GameResult GameResult)
    {
        repository.save(GameResult);
    }
}
