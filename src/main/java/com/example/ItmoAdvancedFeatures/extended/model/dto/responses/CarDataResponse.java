package com.example.ItmoAdvancedFeatures.extended.model.dto.responses;

import com.example.ItmoAdvancedFeatures.extended.model.db.entity.User;
import com.example.ItmoAdvancedFeatures.extended.model.dto.requests.CarDataRequest;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarDataResponse extends CarDataRequest {
    private Long id;
    private UserDataResponse user;
}