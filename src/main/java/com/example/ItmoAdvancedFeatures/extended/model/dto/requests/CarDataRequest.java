package com.example.ItmoAdvancedFeatures.extended.model.dto.requests;

import com.example.ItmoAdvancedFeatures.extended.model.enums.CarType;
import com.example.ItmoAdvancedFeatures.extended.model.enums.Color;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class CarDataRequest {
    private String brand;
    private String model;
    private Color color;
    private Integer year;
    private Long price;
    private Boolean isNew;
    private CarType type;
}