package com.mycompany.springboot.services;

import com.mycompany.springboot.entities.Car;

import java.util.List;

public interface MechanicService {

    List<Car> get();

    Car get(int id);

    void save(Car car);

    void delete(int id);

}
