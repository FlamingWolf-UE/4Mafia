package com.example.demo.domain.service;

import com.example.demo.domain.model.CompositeKeys.GameMemberPK;
import com.example.demo.domain.model.Game;
import com.example.demo.domain.model.GameMember;
import com.example.demo.domain.repository.GameMemberRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class GameMemberService {
    @Autowired
    private final GameMemberRepository repository;

    public GameMemberService(GameMemberRepository GameMemberRepository) {
        this.repository = GameMemberRepository;
    }

    public List<GameMember> getAll()
    {
        return repository.findAll();
    }

    @Transactional
    public List<GameMember> getByGameID(@NotNull Integer id)
    {
        return repository.findAllById_GameId(id);
    }
    @Transactional
    public List<GameMember> getByUserID(@NotNull Integer id)
    {
        return repository.findAllById_UserId(id);
    }

    @Transactional(propagation=Propagation.REQUIRED, rollbackFor = {Exception.class})
    public void add(@NotNull GameMember GameMember) throws Exception {
        if(repository.findById(GameMember.getId()).isPresent()) throw new Exception("Entity GameMember with id (UserId="+GameMember.getId().getUserId()+", GameId="+GameMember.getId().getUserId()+") is already exist");
        repository.save(GameMember);
    }

    public void update(@NotNull GameMember GameMember) throws Exception {
        if(repository.findById(GameMember.getId()).isEmpty()) throw new Exception("Entity GameMember with id (UserId="+GameMember.getId().getUserId()+", GameId="+GameMember.getId().getUserId()+") does not exist exist");

        repository.save(GameMember);
    }

    @Transactional
    public Optional<GameMember> getById(GameMemberPK gameMemberPK)
    {
       return repository.findById(gameMemberPK);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {NoSuchElementException.class})
    public void delete(@NotNull GameMember GameMember)
    {
        Optional<GameMember> member = repository.findById(GameMember.getId());
        if(member.isEmpty())
            throw new NoSuchElementException();
        else
            repository.delete(GameMember);
    }


}
