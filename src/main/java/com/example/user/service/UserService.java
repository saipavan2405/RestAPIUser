package com.example.user.service;

import com.example.user.dto.UserDto;
import com.example.user.model.User;

import java.util.List;

public interface UserService {

    UserDto getUser(long id);

    List<User> getAllUsers();

    User save(User user);

    String delete(long id);
}
