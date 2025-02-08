package com.example.ItmoAdvancedFeatures.extended.service;

import com.example.ItmoAdvancedFeatures.extended.model.dto.requests.CarDataRequest;
import com.example.ItmoAdvancedFeatures.extended.model.dto.responses.CarDataResponse;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface CarService {

    CarDataResponse getCarById(Long id);

    CarDataResponse addCar(CarDataRequest carDataRequest);

    CarDataResponse updateCar(Long id, CarDataRequest carDataRequest);

    void deleteCar(Long id);

    List<CarDataResponse> getAllCarById();

    CarDataResponse getCarWithParams(String brand, Integer year);
}