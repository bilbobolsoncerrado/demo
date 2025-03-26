package com.example.service;

import com.example.model.Manufacturer;
import com.example.repository.ManufacturerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Date;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {


    private final ManufacturerRepository repository;

    public ManufacturerServiceImpl(ManufacturerRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Manufacturer> findAll() {
        return this.repository.findAll();
    }

    @Override
    public List<Manufacturer> findAllByYear(Integer year) {
        Objects.requireNonNull(year);
        return this.repository.findAllByYear(year);
    }
    @Override
    public List<Manufacturer> findAllByYearRequest(Integer year) {
        Objects.requireNonNull(year);
        return this.repository.findAllByYear(year);
    }
    @Override
    public List<Manufacturer> findAllByInitialDate(Date initialDate) {
        Objects.requireNonNull(initialDate);
        return this.repository.findAllByInitialDate(initialDate);
    }
    @Override
    public Optional<Manufacturer> findById(Long id) {
        return this.repository.findById(id);
    }

    @Override
    public Optional<Manufacturer> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public Manufacturer save(Manufacturer manufacturer) {
        this.repository.save(manufacturer);
        return manufacturer;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void deleteAll() {

    }
}
