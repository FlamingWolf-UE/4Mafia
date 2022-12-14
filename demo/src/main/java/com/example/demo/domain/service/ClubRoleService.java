package com.example.demo.domain.service;

import com.example.demo.domain.model.ClubRole;
import com.example.demo.domain.repository.ClubRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClubRoleService {
    @Autowired
    private final ClubRoleRepository repository;
    public ClubRoleService(ClubRoleRepository clubroleRepository) {
        this.repository=clubroleRepository;
    }

    public List<ClubRole> getAll()
    {
        return repository.findAll();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void Add(ClubRole clubrole)
    {
        repository.save(clubrole);
    }

    public Optional<ClubRole> GetByID(Integer id)
    {
        return repository.findById(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void Delete(Integer id)
    {
        repository.deleteById(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void Update(ClubRole clubrole)
    {
        repository.save(clubrole);
    }
}
