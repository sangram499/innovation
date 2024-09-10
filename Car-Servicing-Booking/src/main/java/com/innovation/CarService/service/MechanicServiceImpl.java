package com.innovation.CarService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovation.CarService.model.Mechanic;
import com.innovation.CarService.repository.MechanicRepository;

@Service
public class MechanicServiceImpl implements MechanicService {

    @Autowired
    private MechanicRepository mechanicRepository;

    @Override
    public Mechanic getMechanicById(Long id) {
        return mechanicRepository.findById(id).orElse(null);
    }

    @Override
    public List<Mechanic> getAllMechanics() {
        return mechanicRepository.findAll();
    }

    @Override
    public Mechanic createMechanic(Mechanic mechanic) {
        return mechanicRepository.save(mechanic);
    }

    @Override
    public Mechanic updateMechanic(Mechanic mechanic) {
        return mechanicRepository.save(mechanic);
    }

    @Override
    public void deleteMechanic(Long id) {
        mechanicRepository.deleteById(id);
    }
}
