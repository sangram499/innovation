package com.innovation.CarService.service;

import com.innovation.CarService.model.User;

import java.util.Optional;

public interface UserService {
	
    Optional<User> findByUsername(String username);
    void saveUser(User user);
    Optional<User> findById(Long id);
    void deleteUser(Long id);
}
