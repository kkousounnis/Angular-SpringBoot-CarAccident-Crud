package com.mycompany.springboot.controllers;

import com.mycompany.springboot.entities.Car;
import com.mycompany.springboot.entities.dtos.responses.CarResponse;
import com.mycompany.springboot.services.CarServiceImpl;
import com.mycompany.springboot.entities.dtos.requests.CarRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("/api")
public class CarController {

    @Autowired
    private CarServiceImpl employeeServiceImpl;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/employee")
    public List<Car> get() {

        return (new CarResponse(employeeServiceImpl.get()).getEmployees());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/employee")
    public Car save(@RequestBody CarRequest employee) {  //to change to CarRequest issue with angular    
        System.out.println(employee.getEmployee());
        employeeServiceImpl.save(employee.getEmployee());
        return (employee.getEmployee());
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/employee/{id}")
    public ResponseEntity<Car> get(@PathVariable int id) {
        Car employee = employeeServiceImpl.get(id);
        return ResponseEntity.ok(employee);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Map<String, Boolean>> delete(@PathVariable int id) {
        employeeServiceImpl.delete(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/employee/{id}")
    public ResponseEntity<Car> update(@PathVariable int id, @RequestBody Car employeeDetails) {
        Car employee = employeeServiceImpl.get(id);

        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());
        employee.setEmailId(employeeDetails.getEmailId());

        employeeServiceImpl.save(employee);
        return ResponseEntity.ok(employee);
    }

}
