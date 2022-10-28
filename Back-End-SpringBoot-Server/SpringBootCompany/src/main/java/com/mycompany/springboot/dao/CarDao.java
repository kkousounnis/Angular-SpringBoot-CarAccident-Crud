package com.mycompany.springboot.dao;

import com.mycompany.springboot.services.*;
import java.util.List;
import com.mycompany.springboot.entities.Car;

public interface CarDao {

    List<Car> get();

    Car get(int id);

    Car save(Car car);

    void delete(int id);
    
    

}
