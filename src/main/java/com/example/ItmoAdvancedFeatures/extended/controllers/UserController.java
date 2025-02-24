package com.example.ItmoAdvancedFeatures.extended.controllers;

import com.example.ItmoAdvancedFeatures.extended.model.dto.requests.UserDataRequest;
import com.example.ItmoAdvancedFeatures.extended.model.dto.responses.CarDataResponse;
import com.example.ItmoAdvancedFeatures.extended.model.dto.responses.UserDataResponse;
import com.example.ItmoAdvancedFeatures.extended.service.UserService;
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
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    @Operation(summary = "Получить пользователя по ID")
    public UserDataResponse getUsers(@PathVariable  Long id) {
        return userService.getUsers(id);
    }

    @PostMapping
    @Operation(summary = "Создать пользователя")
    public UserDataRequest postUser(@RequestBody @Valid UserDataRequest userDataRequest) {
        return userService.postUser(userDataRequest);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Обновить данные пользователя по ID")
    public UserDataResponse putUser(@RequestBody @Valid UserDataRequest userDataRequest, @PathVariable Long id) {
        return userService.putUser(userDataRequest, id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удалить пользователя по ID")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @GetMapping
    @Operation(summary = "Получить пользователя по электронной почты и фамилий")
    public UserDataResponse getUsersWithParams(@RequestParam @Valid String email, @RequestParam @Valid String firstName) {
        return userService.getUsersWithParams(email, firstName);
    }

    @GetMapping("/all")
    @Operation(summary = "Получить список пользователей")
    public Page<UserDataResponse> getAllUsers(@RequestParam(defaultValue = "1") Integer page,
                                              @RequestParam(defaultValue = "10") Integer perPage,
                                              @RequestParam(defaultValue = "lastName") String sort,
                                              @RequestParam(defaultValue = "ASC") Sort.Direction order,
                                              @RequestParam(required = false) String filter
                                              ) {
        return userService.getAllUsers(page, perPage, sort, order, filter);
    }
}