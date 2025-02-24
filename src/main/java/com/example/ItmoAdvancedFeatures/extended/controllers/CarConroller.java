package com.example.ItmoAdvancedFeatures.extended.controllers;

import com.example.ItmoAdvancedFeatures.extended.model.dto.requests.CarDataRequest;
import com.example.ItmoAdvancedFeatures.extended.model.dto.responses.CarDataResponse;
import com.example.ItmoAdvancedFeatures.extended.service.CarService;
import io.swagger.v3.oas.annotations.Operation;
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

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarConroller {

    private final CarService carService;

    @GetMapping("/{id}")
    @Operation(summary = "Получить автомобиль по ID")
    public CarDataResponse getCarById(@PathVariable Long id) {
        return carService.getCarById(id);
    }

    @PostMapping
    @Operation(summary = "Создать автомобиль")
    public CarDataResponse addCar(@RequestBody @Valid CarDataRequest carDataRequest) {
        return carService.addCar(carDataRequest);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Обновить данные автомобиля по ID")
    public CarDataResponse updateCar(@PathVariable @Valid Long id, @RequestBody @Valid CarDataRequest carDataRequest) {
        return carService.updateCar(id, carDataRequest);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удалить автомобиль по ID")
    public void deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
    }

    @GetMapping("/all")
    @Operation(summary = "Получить список автомобилей")
    public Page<CarDataResponse> getAllCars(@RequestParam(defaultValue = "1") Integer page,
                                               @RequestParam(defaultValue = "10") Integer perPage,
                                               @RequestParam(defaultValue = "brand") String sort,
                                               @RequestParam(defaultValue = "ASC") Sort.Direction order,
                                               @RequestParam(required = false) String filter
    ) {
        return carService.getAllCars(page, perPage, sort, order, filter);
    }

    @GetMapping
    @Operation(summary = "Получить автомобиль по бренду и году выпуска")
    public CarDataResponse getCarWithParams(@RequestParam @Valid String brand, @RequestParam @Valid Integer year){
        return carService.getCarWithParams(brand, year);
    }

    @PostMapping("/linkCarAndUser/{carId}/{userId}")
    @Operation(summary = "Создать привязку автомобиле и пользователя по их ID")
    public CarDataResponse linkCarAndUser(@PathVariable Long carId, @PathVariable Long userId){
        return carService.linkCarAndUser(carId, userId);
    }

    @GetMapping("/user/{userId}")
    @Operation(summary = "Получить список автомобилей по ID пользователя")
    public List<CarDataResponse> getCarsByUserId(@PathVariable Long userId) {
        return carService.getCarsByUserId(userId);
    }
}