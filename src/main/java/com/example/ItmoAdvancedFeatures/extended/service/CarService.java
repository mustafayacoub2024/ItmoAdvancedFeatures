package com.example.ItmoAdvancedFeatures.extended.service;

import com.example.ItmoAdvancedFeatures.extended.model.dto.requests.CarDataRequest;
import com.example.ItmoAdvancedFeatures.extended.model.dto.responses.CarDataResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface CarService {

    CarDataResponse getCarById(Long id);

    CarDataResponse addCar(CarDataRequest carDataRequest);

    CarDataResponse updateCar(Long id, CarDataRequest carDataRequest);

    void deleteCar(Long id);

    List<CarDataResponse> getAllCarById();

    CarDataResponse getCarWithParams(String brand, Integer year);

    CarDataResponse linkCarAndUser(Long userId, Long carId);

    Page<CarDataResponse> getAllCars(Integer page, Integer perPage, String sort, Sort.Direction order, String filter);

    List<CarDataResponse> getCarsByUserId(Long userId);
}