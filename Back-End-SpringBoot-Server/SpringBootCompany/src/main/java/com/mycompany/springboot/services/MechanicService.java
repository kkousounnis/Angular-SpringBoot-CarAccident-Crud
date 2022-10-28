package com.mycompany.springboot.services;

import com.mycompany.springboot.entities.Mechanic;

import java.util.List;

public interface MechanicService {

    List<Mechanic> get();

    Mechanic get(int id);

    void save(Mechanic mechanic);

    void delete(int id);

}
