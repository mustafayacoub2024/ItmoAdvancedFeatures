package com.example.ItmoAdvancedFeatures.extended.service.impl;

import com.example.ItmoAdvancedFeatures.extended.model.db.entity.User;
import com.example.ItmoAdvancedFeatures.extended.model.db.repository.UserRepository;
import com.example.ItmoAdvancedFeatures.extended.model.dto.requests.UserDataRequest;
import com.example.ItmoAdvancedFeatures.extended.model.dto.responses.UserDataResponse;
import com.example.ItmoAdvancedFeatures.extended.model.enums.UserStatus;
import com.example.ItmoAdvancedFeatures.extended.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final ObjectMapper objectMapper;
    private final UserRepository userRepository;

    private User getUserFromDB(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElse(new User());
    }

    @Override
    public UserDataResponse getUsers(Long id) {
        User user = getUserFromDB(id);
        return objectMapper.convertValue(user, UserDataResponse.class);
    }

    @Override
    public UserDataRequest postUser(UserDataRequest userDataRequest) {
        User user = objectMapper.convertValue(userDataRequest, User.class);
        user.setStatus(UserStatus.CREATED);

        User savedUser = userRepository.save(user);
        return objectMapper.convertValue(savedUser, UserDataRequest.class);
    }

    @Override
    public UserDataResponse putUser(UserDataRequest userDataRequest, Long id) {
        User user = getUserFromDB(id);
        if (user.getId() != null) {
            return objectMapper.convertValue(user, UserDataResponse.class);
        }
        User updatedUser = objectMapper.convertValue(userDataRequest, User.class);

        user.setEmail(updatedUser.getEmail() == null ? user.getEmail() : updatedUser.getEmail());
        user.setPassword(updatedUser.getPassword() == null ? user.getPassword() : updatedUser.getPassword());
        user.setFirstName(updatedUser.getFirstName() == null ? user.getFirstName() : updatedUser.getFirstName());
        user.setLastName(updatedUser.getLastName() == null ? user.getLastName() : updatedUser.getLastName());
        user.setMiddleName(updatedUser.getMiddleName() == null ? user.getMiddleName() : updatedUser.getMiddleName());
        user.setGender(updatedUser.getGender() == null ? user.getGender() : updatedUser.getGender());
        user.setAge(updatedUser.getAge() == null ? user.getAge() : updatedUser.getAge());

        user = userRepository.save(user);
        return objectMapper.convertValue(user, UserDataResponse.class);

    }

    @Override
    public void deleteUser(Long id) {
        User user = getUserFromDB(id);
        if (user.getId() == null) {
            log.error("Пользователь с id{} не найден", id);
            return;
        }

        user.setStatus(UserStatus.DELETED);
        userRepository.save(user);
    }

    @Override
    public List<UserDataResponse> getAllUsers() {
        return userRepository.findAll().stream()
                .map(user -> objectMapper.convertValue(user, UserDataResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDataResponse getUsersWithParams(String email, String firstName) {
        User user = userRepository.getUserByAgeAndEmailAndStatus(email, firstName);
        return objectMapper.convertValue(user, UserDataResponse.class);

    }
}