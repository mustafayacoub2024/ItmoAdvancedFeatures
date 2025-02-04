package com.example.ItmoAdvancedFeatures.extended.model.dto.responses;

import com.example.ItmoAdvancedFeatures.extended.model.dto.requests.UserDataRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class UserDataResponse extends UserDataRequest {
    private Long id;
}
