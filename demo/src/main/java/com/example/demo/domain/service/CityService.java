package com.example.demo.domain.service;

import com.example.demo.domain.model.City;
import com.example.demo.domain.model.Place;
import com.example.demo.domain.repository.CityRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CityService {
    @Autowired
    private final CityRepository repository;
    public CityService(CityRepository cityRepository) {
        this.repository=cityRepository;
    }

    public List<City> getAll()
    {
        return repository.findAll();
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public void add(@NotNull City city) throws Exception {
        if (repository.findById(city.getId()).isEmpty())
            repository.save(city);
        else
            throw new Exception(City.class.getName() +" class entity with id " + city.getId() + " is already exist");
    }

    public Optional<City> getByID(Integer id)
    {
        return repository.findById(id);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class, NoSuchElementException.class})
    public void deleteDetachedCityById(Integer id) throws Exception {
        Optional<City> city = repository.findById(id);
        if(city.isEmpty()) throw new NoSuchElementException();
        if(city.get().getPlacesOfCity().isEmpty() || city.get().getClubsOfCity().isEmpty())
            repository.deleteById(id);
        else
            throw new Exception(City.class.getName() +" class entity with id " + id + " is already attached to Place or Club entity");
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public void update(@NotNull City city) throws Exception {
        if (repository.findById(city.getId()).isPresent())
            repository.save(city);
        else
            throw new Exception(Place.class.getName() +" class entity with id " + city.getId() + " does not exist");
    }
}
