package com.example.ItmoAdvancedFeatures.extended.model.dto.requests;

import com.example.ItmoAdvancedFeatures.extended.model.enums.Gender;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class UserDataRequest {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String middleName;
    private Integer age;
    private Gender gender;
}
