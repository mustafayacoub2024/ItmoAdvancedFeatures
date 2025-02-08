package com.example.ItmoAdvancedFeatures.extended.service.impl;

import com.example.ItmoAdvancedFeatures.extended.model.dto.requests.UserDataRequest;
import com.example.ItmoAdvancedFeatures.extended.model.dto.responses.UserDataResponse;
import com.example.ItmoAdvancedFeatures.extended.model.enums.Gender;
import com.example.ItmoAdvancedFeatures.extended.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final ObjectMapper objectMapper;

    @Override
    public UserDataResponse getUsers(Long id) {
        return UserDataResponse.builder()
                .id(1L)
                .email("test@test.ru")
                .age(40)
                .firstName("Ivan")
                .lastName("Ivanov")
                .middleName("Ivanovich")
                .gender(Gender.MALE)
                .password("12345")
                .build();
    }

    @Override
    public UserDataRequest postUser(UserDataRequest userDataRequest) {
        UserDataResponse userDataResponse = objectMapper.convertValue(userDataRequest, UserDataResponse.class);
        userDataResponse.setId(2L);
        return userDataResponse;
    }

    @Override
    public UserDataRequest putUser(UserDataRequest userDataRequest, Long id) {
        if (id != 1L) {
            log.error("Пользователь с id{} не найден", id);
            return null;
        }

        return UserDataResponse.builder()
                .id(1L)
                .email("itmo@test.ru")
                .age(40)
                .firstName("Petr")
                .lastName("Petrov")
                .middleName("Petrovich")
                .gender(Gender.MALE)
                .password("****")
                .build();
    }

    @Override
    public void deleteUser(Long id) {
        if (id != 1L) {
            log.error("Пользователь с id{} не найден", id);
            return;
        }
        log.info("Пользователь с id{} удалён", id);
    }

    @Override
    public List<UserDataResponse> getAllUsers() {
        return List.of(UserDataResponse.builder()
                .id(1L)
                .email("itmo@test.ru")
                .age(40)
                .firstName("Petr")
                .lastName("Petrov")
                .middleName("Petrovich")
                .gender(Gender.MALE)
                .password("****")
                .build()
        );
    }

    @Override
    public UserDataResponse getUsersWithParams(String email, String firstName) {
        return getUsers(1L);

    }
}