package com.innovation.CarService.service;

import com.innovation.CarService.model.Mechanic;
import java.util.List;

public interface MechanicService {
    Mechanic getMechanicById(Long id);
    List<Mechanic> getAllMechanics();
    Mechanic createMechanic(Mechanic mechanic);
    Mechanic updateMechanic(Mechanic mechanic);
    void deleteMechanic(Long id);
}
