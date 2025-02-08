package com.example.ItmoAdvancedFeatures.extended.service.impl;

import com.example.ItmoAdvancedFeatures.extended.model.dto.requests.CarDataRequest;
import com.example.ItmoAdvancedFeatures.extended.model.dto.responses.CarDataResponse;
import com.example.ItmoAdvancedFeatures.extended.model.enums.CarType;
import com.example.ItmoAdvancedFeatures.extended.model.enums.Color;
import com.example.ItmoAdvancedFeatures.extended.service.CarService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CarServiceImpl implements CarService {

    private final ObjectMapper objectMapper;

    @Override
    public CarDataResponse getCarById(Long id) {
        return CarDataResponse.builder()
                .id(1L)
                .brand("BMW")
                .color(Color.BLACK)
                .model("X5")
                .year(2025)
                .price(1500000L)
                .isNew(true)
                .type(CarType.OVERLAND)
                .build();
    }

    @Override
    public CarDataResponse addCar(CarDataRequest carDataRequest) {
        CarDataResponse carDataResponse = objectMapper.convertValue(carDataRequest, CarDataResponse.class);
        carDataResponse.setId(2L);
        return carDataResponse;
    }

    @Override
    public CarDataResponse updateCar(Long id, CarDataRequest carDataRequest) {
        if (id != 1L) {
            log.error("Автомобиль с id {} не найден", id);
            return null;
        }
        return CarDataResponse.builder()
                .id(1L)
                .brand("BMW")
                .color(Color.WHITE)
                .model("X1")
                .year(2000)
                .price(500000L)
                .isNew(true)
                .type(CarType.SEDAN)
                .build();
    }

    @Override
    public void deleteCar(Long id) {
        if (id != 1L) {
            log.error("Автомобиль с id {} не найден", id);
            return;
        }
        log.error("Автомобиль с id {} удален", id);
    }

    @Override
    public List<CarDataResponse> getAllCarById() {
        return List.of(CarDataResponse.builder()
                .id(1L)
                .brand("BMW")
                .color(Color.BLACK)
                .model("X5")
                .year(2025)
                .price(1500000L)
                .isNew(true)
                .type(CarType.OVERLAND)
                .build());
    }

    @Override
    public CarDataResponse getCarWithParams(String brand, Integer year) {
        return getCarById(1L);
    }
}