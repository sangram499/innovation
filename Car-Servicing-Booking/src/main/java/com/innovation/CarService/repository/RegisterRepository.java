package com.innovation.CarService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.innovation.CarService.model.Register;

@Repository
public interface RegisterRepository extends JpaRepository<Register, Long> {
    Register findByEmail(String email); // For login or validation purposes
}
