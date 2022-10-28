package com.mycompany.springboot.dao;

import com.mycompany.springboot.entities.Car;
import com.mycompany.springboot.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MechanicDaoImpl implements CarDao {

    @Autowired
    private CarRepository carRepository;

    @Override
    public List<Car> get() {
        return carRepository.findAll();
    }

    @Override
    public Car get(int id) {
        return carRepository.findById(id).get();
    }

    @Override
    public void save(Car employee) {
        carRepository.save(employee);
    }

    @Override
    public void delete(int id) {
        carRepository.deleteById(id);
    }

}
