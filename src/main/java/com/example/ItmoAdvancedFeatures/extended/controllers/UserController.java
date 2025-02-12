package com.example.ItmoAdvancedFeatures.extended.controllers;

import com.example.ItmoAdvancedFeatures.extended.model.dto.requests.UserDataRequest;
import com.example.ItmoAdvancedFeatures.extended.model.dto.responses.UserDataResponse;
import com.example.ItmoAdvancedFeatures.extended.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/all")
    public List<UserDataResponse> getAllUsers() {
        return userService.getAllUsers();
    }

//    @GetMapping
//    public UserDataResponse getUsersWithParams(@RequestParam String email, @RequestParam String firstName){
//        return userService.getUsersWithParams(email, firstName);
//    }
}