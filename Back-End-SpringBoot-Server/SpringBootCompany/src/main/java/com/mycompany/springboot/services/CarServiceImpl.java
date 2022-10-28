package com.mycompany.springboot.services;

import com.mycompany.springboot.entities.Car;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.mycompany.springboot.dao.CarDao;

@Repository
public class CarServiceImpl implements CarService {

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
    public Car save(Car car) {

        return (dao.save(car));
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }

}
