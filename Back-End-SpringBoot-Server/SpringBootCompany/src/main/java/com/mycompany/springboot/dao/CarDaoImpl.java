package com.mycompany.springboot.dao;

import com.mycompany.springboot.entities.Car;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.mycompany.springboot.repositories.CarRepository;

@Repository
public class CarDaoImpl implements CarDao {

    @Autowired
    private CarRepository employeeRepository;

    @Override
    public List<Car> get() {
        return employeeRepository.findAll();
    }

    @Override
    public Car get(int id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public void save(Car employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }

}
