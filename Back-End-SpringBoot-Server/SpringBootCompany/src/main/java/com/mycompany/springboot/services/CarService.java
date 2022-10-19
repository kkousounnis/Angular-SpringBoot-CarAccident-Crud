package com.mycompany.springboot.services;

import java.util.List;
import com.mycompany.springboot.entities.Car;

public interface CarService {

    List<Car> get();

    Car get(int id);

    void save(Car car);

    void delete(int id);

}
