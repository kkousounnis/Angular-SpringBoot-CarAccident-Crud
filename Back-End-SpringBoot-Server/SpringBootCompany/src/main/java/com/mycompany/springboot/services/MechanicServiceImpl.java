package com.mycompany.springboot.services;

import com.mycompany.springboot.dao.CarDao;
import com.mycompany.springboot.entities.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MechanicServiceImpl implements CarService {

    @Autowired
    private CarDao dao;

    @Override
    public List<Car> get() {
        return dao.get();
    }

    @Override
    public Car get(int id) {
        return dao.get(id);
    }

    @Override
    public void save(Car car) {
        dao.save(car);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }

}
