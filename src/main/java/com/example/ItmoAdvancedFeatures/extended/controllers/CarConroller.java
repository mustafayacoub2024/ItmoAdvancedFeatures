package com.example.ItmoAdvancedFeatures.extended.controllers;

import com.example.ItmoAdvancedFeatures.extended.model.dto.requests.CarDataRequest;
import com.example.ItmoAdvancedFeatures.extended.model.dto.responses.CarDataResponse;
import com.example.ItmoAdvancedFeatures.extended.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<CarDataResponse> getAllCarById(){
        return carService.getAllCarById();
    }

    @GetMapping
    public CarDataResponse getCarWithParams(@RequestParam String brand, @RequestParam Integer year){
        return carService.getCarWithParams(brand, year);
    }
}