package com.mycompany.springboot.repositories;

import com.mycompany.springboot.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {

}
