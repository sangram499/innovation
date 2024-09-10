package com.innovation.CarService.service;

import com.innovation.CarService.model.Admin;

import java.util.Optional;

public interface AdminService {
    Optional<Admin> findByUsername(String username);
    void saveAdmin(Admin admin);
    Optional<Admin> findById(Long id);
    void deleteAdmin(Long id);
}
