package com.mycompany.springboot.dao;

import com.mycompany.springboot.services.*;
import java.util.List;
import com.mycompany.springboot.entities.Car;

public interface CarDao {

    List<Car> get();

    Car get(int id);

    void save(Car employee);

    void delete(int id);
    
    

}
