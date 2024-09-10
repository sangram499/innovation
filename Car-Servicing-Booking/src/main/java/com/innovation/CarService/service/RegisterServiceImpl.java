package com.innovation.CarService.service;

import com.innovation.CarService.model.Register;
import com.innovation.CarService.repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private RegisterRepository registerRepository;

    @Override
    public Register registerUser(Register register) {
        return registerRepository.save(register);
    }

    @Override
    public List<Register> getAllRegistrations() {
        return registerRepository.findAll();
    }

    @Override
    public Register getRegistrationById(Long id) {
        return registerRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteRegistrationById(Long id) {
        registerRepository.deleteById(id);
    }
}
