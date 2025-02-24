package com.example.ItmoAdvancedFeatures.extended.service;

import com.example.ItmoAdvancedFeatures.extended.model.db.entity.User;
import com.example.ItmoAdvancedFeatures.extended.model.dto.requests.UserDataRequest;
import com.example.ItmoAdvancedFeatures.extended.model.dto.responses.CarDataResponse;
import com.example.ItmoAdvancedFeatures.extended.model.dto.responses.UserDataResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface UserService {

    User getUserFromDB(Long id);

    UserDataResponse getUsers(Long id);

    UserDataRequest postUser(UserDataRequest userDataRequest);

    UserDataResponse putUser(UserDataRequest userDataRequest, Long id);

    void deleteUser(Long id);

    Page<UserDataResponse> getAllUsers(Integer page, Integer perPage, String sort, Sort.Direction order, String filter);

    UserDataResponse getUsersWithParams(String email, String firstName);

    User updateCarList(User user);

    void invalidateSessions();
}