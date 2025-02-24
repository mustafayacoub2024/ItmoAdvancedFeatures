package com.example.ItmoAdvancedFeatures.extended.model.dto.requests;

import com.example.ItmoAdvancedFeatures.extended.model.enums.Gender;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldNameConstants;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@FieldNameConstants
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDataRequest {
    @NotEmpty
    @Email
    @Schema(description = "email")
    private String email;

    @NotEmpty
    @Schema(description = "Пароль")
    private String password;

    @NotEmpty
    @Schema(description = "Фамилия")
    private String firstName;

    @NotEmpty
    @Schema(description = "Имя")
    private String lastName;

    @NotEmpty
    @Schema(description = "Отчество")
    private String middleName;

    @NotNull
    @Schema(description = "Возраст")
    private Integer age;

    private Gender gender;
}
