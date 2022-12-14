package com.example.demo.domain.repository;

import com.example.demo.domain.model.CompositeKeys.GameMemberPK;
import com.example.demo.domain.model.GameMember;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

public interface GameMemberRepository extends JpaRepository<GameMember, Integer> {

    @Transactional
    public Optional<GameMember> findById(GameMemberPK gameMemberPK);

    @Transactional
    public List<GameMember> findAllById_GameId(Integer gameId);

    @Transactional
    public List<GameMember> findAllById_UserId(Integer userId);
}
