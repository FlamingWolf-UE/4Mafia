package com.example.demo.domain.service;

import com.example.demo.domain.model.City;
import com.example.demo.domain.model.Place;
import com.example.demo.domain.repository.PlaceRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PlaceService {
    @Autowired
    private final PlaceRepository repository;

    public PlaceService(PlaceRepository PlaceRepository) {
        this.repository = PlaceRepository;
    }

    public List<Place> getAll()
    {
        return repository.findAll();
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public void add(@NotNull Place Place) throws Exception {
        if (repository.findById(Place.getId()).isEmpty())
            repository.save(Place);
        else
            throw new Exception(Place.class.getName() +" class entity with id " + Place.getId() + " is already exist");
    }

    public Optional<Place> getByID(Integer id)
    {
        return repository.findById(id);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class, NoSuchElementException.class})
    public void deleteDetachedPlaceById(Integer id) throws Exception {
        Optional<Place> place = repository.findById(id);
        if(place.isEmpty()) throw new NoSuchElementException();
        if(place.get().getGamesInThisPlace().isEmpty())
            repository.deleteById(id);
        else
            throw new Exception(Place.class.getName() +" class entity with id " + id + " is already attached to Game entity");
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public void update(@NotNull Place Place) throws Exception {
        if (repository.findById(Place.getId()).isPresent())
            repository.save(Place);
        else
            throw new Exception(Place.class.getName() +" class entity with id " + Place.getId() + " does not exist");
    }
}
