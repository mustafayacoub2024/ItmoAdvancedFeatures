package com.example.ItmoAdvancedFeatures.extended.service;

import com.example.ItmoAdvancedFeatures.extended.model.dto.requests.UserDataRequest;
import com.example.ItmoAdvancedFeatures.extended.model.dto.responses.UserDataResponse;

import java.util.List;

public interface UserService {

    UserDataResponse getUsers(Long id);

    UserDataRequest postUser(UserDataRequest userDataRequest);

    UserDataResponse putUser(UserDataRequest userDataRequest, Long id);

    void deleteUser(Long id);

    List<UserDataResponse> getAllUsers();

    UserDataResponse getUsersWithParams(String email, String firstName);
}