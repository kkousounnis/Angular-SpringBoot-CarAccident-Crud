package com.mycompany.springboot.controllers;

import com.mycompany.springboot.entities.Car;
import com.mycompany.springboot.entities.dtos.responses.CarResponse;
import com.mycompany.springboot.services.CarServiceImpl;
import com.mycompany.springboot.entities.dtos.requests.CarRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class CarController {

    @Autowired
    private CarServiceImpl carServiceImpl;

    @GetMapping("/car")
    public List<Car> get() {

        return (new CarResponse(carServiceImpl.get()).getCars());
    }


    @PostMapping("/car")
    public ResponseEntity<Car> save(@RequestBody CarRequest car) {

        carServiceImpl.save(car.getCar());

        return new ResponseEntity("Car accident created with success.", HttpStatus.CREATED);
    }


    @GetMapping("/car/{id}")
    public ResponseEntity<Car> get(@PathVariable int id) {
        Car car = carServiceImpl.get(id);
        return new ResponseEntity("Success", HttpStatus.OK);
    }


    @DeleteMapping("/car/{id}")
    public ResponseEntity<Map<String, Boolean>> delete(@PathVariable int id) {
        carServiceImpl.delete(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return new ResponseEntity("Deleted with success.", HttpStatus.OK);
    }


    @PutMapping("/car/{id}")
    public ResponseEntity<Car> update(@PathVariable int id, @RequestBody CarRequest employeeDetails) {
        Car car = carServiceImpl.get(id);
        employeeDetails.getCar().setId(car.getId());
        System.err.println("Errors" + employeeDetails.getCar().getBrand());
        carServiceImpl.save(employeeDetails.getCar());
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
