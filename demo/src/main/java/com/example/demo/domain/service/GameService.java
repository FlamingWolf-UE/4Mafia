package com.example.demo.domain.service;


import com.example.demo.domain.entityModel.GameModel;
import com.example.demo.domain.entityModel.PageModel;
import com.example.demo.domain.model.Game;
import com.example.demo.domain.repository.GameRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class GameService {
    @Autowired
    private final GameRepository repository;
    public GameService(GameRepository GameRepository) {
        this.repository = GameRepository;
    }

    public Page<Game> getAll(Pageable pageable)
    {
        return repository.findAll(pageable);
    }
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public void add(@NotNull Game Game) throws Exception {
        if (repository.findById(Game.getId()).isEmpty())
            repository.save(Game);
        else
            throw new Exception(Game.class.getName() +" class entity with id " + Game.getId() + " is already exist");
    }
    public Optional<Game> getByID(Integer id)
    {
        return repository.findById(id);
    }
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class, NoSuchElementException.class})
    public void deleteDetachedGameById(Integer id) throws Exception {
        Optional<Game> game = repository.findById(id);
        if(game.isEmpty()) throw new NoSuchElementException();
        if(game.get().getMembers().isEmpty())
            repository.deleteById(id);
        else
            throw new Exception(Game.class.getName() +" class entity with id " + id + " is already attached to Member entity");
    }
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {NoSuchElementException.class})
    public void deleteById(Integer id)
    {
        Optional<Game> game = repository.findById(id);
        if(game.isEmpty())
            throw new NoSuchElementException();
        else
            repository.deleteById(id);
    }
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public void update(@NotNull Game Game) throws Exception {
        if (repository.findById(Game.getId()).isPresent())
            repository.save(Game);
        else
            throw new Exception(Game.class.getName() +" class entity with id " + Game.getId() + " does not exist");
    }
    @Transactional
    public PageModel<GameModel> getAllGamesArhived(Pageable pageable)
    {
        var page = getAll(pageable);
        List<Game> games = page.getContent();
        List<GameModel> gm = new ArrayList<>();
        for (Game game:games) {
            GameModel model = new GameModel();
            model.setId(game.getId());
            model.setGameType(game.getType().getDescription());
            model.setDate(game.getDate());
            model.setIsChecked(game.getIsChecked());
            model.setResult(game.getResult().getDescription());
            model.setPlace(game.getPlace().getDescription());
            model.setGameNumber(game.getGameNumber());
            gm.add(model);
        }
        return new PageModel<>(gm,page.getTotalPages());
    }

}
