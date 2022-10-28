package com.mycompany.springboot.dao;

import com.mycompany.springboot.entities.Car;

import java.util.List;

public interface MechanicDao {

    List<Car> get();

    Car get(int id);

    void save(Car car);

    void delete(int id);
    
    

}
