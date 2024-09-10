package com.innovation.CarService.repository;

import com.innovation.CarService.model.Mechanic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MechanicRepository extends JpaRepository<Mechanic, Long> {
    // Add custom query methods if needed
}
