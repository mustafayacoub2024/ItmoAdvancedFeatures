package com.example.ItmoAdvancedFeatures.extended.controllers;

import com.example.ItmoAdvancedFeatures.extended.model.dto.requests.UserDataRequest;
import com.example.ItmoAdvancedFeatures.extended.model.dto.responses.CarDataResponse;
import com.example.ItmoAdvancedFeatures.extended.model.dto.responses.UserDataResponse;
import com.example.ItmoAdvancedFeatures.extended.service.UserService;
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


import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public UserDataResponse getUsers(@PathVariable Long id) {
        return userService.getUsers(id);
    }

    @PostMapping
    public UserDataRequest postUser(@RequestBody UserDataRequest userDataRequest) {
        return userService.postUser(userDataRequest);
    }

    @PutMapping("/{id}")
    public UserDataResponse putUser(@RequestBody UserDataRequest userDataRequest, @PathVariable Long id) {
        return userService.putUser(userDataRequest, id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @GetMapping
    public UserDataResponse getUsersWithParams(@RequestParam String email, @RequestParam String firstName) {
        return userService.getUsersWithParams(email, firstName);
    }

    @GetMapping("/{id}/cars")
    public List<CarDataResponse> getUsersWithCars(@PathVariable Long id) {
        return userService.getUserCars(id);
    }

    @GetMapping("/all")
    public Page<UserDataResponse> getAllUsers(@RequestParam(defaultValue = "1") Integer page,
                                              @RequestParam(defaultValue = "10") Integer perPage,
                                              @RequestParam(defaultValue = "lastName") String sort,
                                              @RequestParam(defaultValue = "ASC") Sort.Direction order,
                                              @RequestParam(required = false) String filter
                                              ) {
        return userService.getAllUsers(page, perPage, sort, order, filter);
    }
}