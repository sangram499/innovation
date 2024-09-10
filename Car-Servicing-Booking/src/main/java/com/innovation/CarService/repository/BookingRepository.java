package com.innovation.CarService.repository;

import com.innovation.CarService.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    // Additional query methods if needed
}
