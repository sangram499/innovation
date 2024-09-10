package com.innovation.CarService.service;

import com.innovation.CarService.model.Register;
import java.util.List;

public interface RegisterService {
    Register registerUser(Register register);
    List<Register> getAllRegistrations();
    Register getRegistrationById(Long id);
    void deleteRegistrationById(Long id);
}
