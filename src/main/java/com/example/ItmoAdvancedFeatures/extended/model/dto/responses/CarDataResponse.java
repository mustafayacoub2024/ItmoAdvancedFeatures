package com.example.ItmoAdvancedFeatures.extended.model.dto.responses;

import com.example.ItmoAdvancedFeatures.extended.model.dto.requests.CarDataRequest;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class CarDataResponse extends CarDataRequest {
    private Long id;
}