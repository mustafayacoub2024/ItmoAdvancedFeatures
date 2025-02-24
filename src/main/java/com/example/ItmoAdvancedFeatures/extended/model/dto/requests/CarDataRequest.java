package com.example.ItmoAdvancedFeatures.extended.model.dto.requests;

import com.example.ItmoAdvancedFeatures.extended.model.enums.CarType;
import com.example.ItmoAdvancedFeatures.extended.model.enums.Color;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@FieldNameConstants
@JsonIgnoreProperties(ignoreUnknown = true)
public class CarDataRequest {
    @NotEmpty
    @Schema(description = "Бренд")
    private String brand;

    @NotEmpty
    @Schema(description = "Модель")
    private String model;


    @Schema(description = "Цвет")
    private Color color;

    @NotNull
    @Schema(description = "Год выпуска")
    private Integer year;

    @NotNull
    @Schema(description = "Цена")
    private Long price;


    @Schema(description = "Состояние")
    private Boolean isNew;


    @Schema(description = "Кузов")
    private CarType type;
}