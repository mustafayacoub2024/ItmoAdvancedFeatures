package com.example.ItmoAdvancedFeatures.extended.controllers;

import com.example.ItmoAdvancedFeatures.extended.model.dto.requests.CarDataRequest;
import com.example.ItmoAdvancedFeatures.extended.model.dto.responses.CarDataResponse;
import com.example.ItmoAdvancedFeatures.extended.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarConroller {

    private final CarService carService;

    @GetMapping("/{id}")
    public CarDataResponse getCarById(@PathVariable Long id) {
        return carService.getCarById(id);
    }

    @PostMapping
    public CarDataResponse addCar(@RequestBody CarDataRequest carDataRequest) {
        return carService.addCar(carDataRequest);
    }

    @PutMapping("/{id}")
    public CarDataResponse updateCar(@PathVariable Long id, @RequestBody CarDataRequest carDataRequest) {
        return carService.updateCar(id, carDataRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
    }

    @GetMapping("/all")
    public Page<CarDataResponse> getAllCars(@RequestParam(defaultValue = "1") Integer page,
                                               @RequestParam(defaultValue = "10") Integer perPage,
                                               @RequestParam(defaultValue = "brand") String sort,
                                               @RequestParam(defaultValue = "ASC") Sort.Direction order,
                                               @RequestParam(required = false) String filter
    ) {
        return carService.getAllCars(page, perPage, sort, order, filter);
    }

    @GetMapping
    public CarDataResponse getCarWithParams(@RequestParam String brand, @RequestParam Integer year){
        return carService.getCarWithParams(brand, year);
    }

    @PostMapping("/linkCarAndUser/{carId}/{userId}")
    public CarDataResponse linkCarAndUser(@PathVariable Long carId, @PathVariable Long userId){
        return carService.linkCarAndUser(carId, userId);
    }
}