package com.example.ItmoAdvancedFeatures.extended.model.db.repository;

import com.example.ItmoAdvancedFeatures.extended.model.db.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {

    Car getCarByBrandAndYear(String brand, Integer year);
}