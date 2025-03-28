package com.example.repository;

import com.example.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Date;

@Repository
public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {

    List<Manufacturer> findAllByYear(Integer year);

    List<Manufacturer> findAllByInitialDate(Date initialDate);

    @Query(name = "Manufacturer.countById")
    Long countById(@Param("id") Long id);
}
