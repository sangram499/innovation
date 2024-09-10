package com.innovation.CarService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.innovation.CarService.model.Booking;

@Service
public interface BookingService {
    Booking saveBooking(Booking booking);
    Booking createBooking(Booking booking);
    Optional<Booking> getBookingById(Long id);
    List<Booking> getAllBookings();
    Booking updateBooking(Booking booking);
}
