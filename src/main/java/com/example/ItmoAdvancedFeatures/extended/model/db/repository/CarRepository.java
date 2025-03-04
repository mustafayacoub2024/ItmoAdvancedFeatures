package com.example.ItmoAdvancedFeatures.extended.model.db.repository;

import com.example.ItmoAdvancedFeatures.extended.model.db.entity.Car;
import com.example.ItmoAdvancedFeatures.extended.model.enums.Color;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Long> {

    Car getCarByBrandAndYear(String brand, Integer year);

    @Query("select c from User c where c.firstName like %:filter% or c.lastName like %:filter% ")
    List<Car> findAllFiltered(Pageable pageRequest, String filter);

    Optional<Car> findCarByBrandAndYearAndColor(String brand, Integer year, Color color);
}