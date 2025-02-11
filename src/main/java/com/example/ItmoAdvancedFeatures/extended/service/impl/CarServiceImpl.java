package com.example.ItmoAdvancedFeatures.extended.service.impl;

import com.example.ItmoAdvancedFeatures.extended.model.db.entity.Car;
import com.example.ItmoAdvancedFeatures.extended.model.db.repository.CarRepository;
import com.example.ItmoAdvancedFeatures.extended.model.dto.requests.CarDataRequest;
import com.example.ItmoAdvancedFeatures.extended.model.dto.responses.CarDataResponse;
import com.example.ItmoAdvancedFeatures.extended.model.enums.CarStatus;
import com.example.ItmoAdvancedFeatures.extended.service.CarService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CarServiceImpl implements CarService {

    private final ObjectMapper objectMapper;
    private final CarRepository carRepository;

    private Car getCatFromDB(Long Id) {
        Optional<Car> optionalCar = carRepository.findById(Id);
        return optionalCar.orElse(new Car());
    }

    @Override
    public CarDataResponse getCarById(Long id) {
        Car car = getCatFromDB(id);
        return objectMapper.convertValue(car, CarDataResponse.class);
    }

    @Override
    public CarDataResponse addCar(CarDataRequest carDataRequest) {
        Car car = objectMapper.convertValue(carDataRequest, Car.class);
        car.setStatus(CarStatus.CREATED);

        Car savedCar = carRepository.save(car);
        return objectMapper.convertValue(savedCar, CarDataResponse.class);
    }


    @Override
    public CarDataResponse updateCar(Long id, CarDataRequest carDataRequest) {
        Car car = getCatFromDB(id);
        if (car.getId() != null) {
            return objectMapper.convertValue(car, CarDataResponse.class);
        }

        Car carRequest = objectMapper.convertValue(carDataRequest, Car.class);

        car.setBrand(carRequest.getBrand() == null ? car.getBrand() : carRequest.getBrand());
        car.setModel(carRequest.getModel() == null ? car.getModel() : carRequest.getModel());
        car.setBrand(carRequest.getBrand() == null ? car.getBrand() : carRequest.getBrand());
        car.setColor(carRequest.getColor() == null ? car.getColor() : carRequest.getColor());
        car.setYear(carRequest.getYear() == null ? car.getYear() : carRequest.getYear());
        car.setPrice(carRequest.getPrice() == null ? car.getPrice() : carRequest.getPrice());
//        car.setNew(carRequest.isNew() == false ? car.isNew() : carRequest.isNew()); не уверен, а нужно ли это добавлять
        car.setType(carRequest.getType() == null ? car.getType() : carRequest.getType());

        car = carRepository.save(car);
        return objectMapper.convertValue(car, CarDataResponse.class);
    }

    @Override
    public void deleteCar(Long id) {
        Car car = getCatFromDB(id);
        if (car == null) {
            log.error("Автомобиль с id {} не найден", id);
            return;
        }

        car.setStatus(CarStatus.DELETED);
        carRepository.save(car);
    }

    @Override
    public List<CarDataResponse> getAllCarById() {
        return carRepository.findAll().stream()
                .map(car -> objectMapper.convertValue(car, CarDataResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public CarDataResponse getCarWithParams(String brand, Integer year) {
        Car car = carRepository.getCarByBrandAndYear(brand, year);
        return objectMapper.convertValue(car, CarDataResponse.class);
    }
}