package com.mycompany.springboot.controllers;

import com.mycompany.springboot.entities.Car;
import com.mycompany.springboot.entities.Mechanic;
import com.mycompany.springboot.services.CarServiceImpl;
import com.mycompany.springboot.services.MechanicServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    private MechanicServiceImpl mechanicServiceImpl;

    @Autowired
    private CarServiceImpl carServiceImpl;


    @GetMapping("/mechanic-cars-sorted")
    public HashMap<String, List<Car>> get() {
        List<Car> cars = carServiceImpl.get();
        List<Car> carsWithSameMechanic = new ArrayList<>();
        /**
         * Sort cars with Comparator by Cost Field.
         * Related Github link
         * https://github.com/albertattard/sorting-objects-using-comparator
         */
        Collections.sort(cars);
        HashMap<String, List<Car>> mechanicCarsSorted = new HashMap<>();
        for (Car car : cars) {
            String name = findStringName(car.getId());
            /**
             * Add in the car list if String name is the same.
             * Hashmap add value inside list
             * https://stackoverflow.com/questions/12134687/how-to-add-element-into-arraylist-in-hashmap
             */
            //To be implemented one mistake when name is the same.
            mechanicCarsSorted.computeIfAbsent(name, k -> new ArrayList<>()).add(car);

        }

        return (mechanicCarsSorted);
    }

    public String findStringName(int id) {
        for (Mechanic mechanic : mechanicServiceImpl.get()) {
            for (Car car : mechanic.getCarAccidents()) {
                if (car.getId() == id) {
                    /**
                     * Return String with MechanicsID+MechanicName so even if full name is the same id is 
                     * different.
                     */
                    return (mechanic.getMechanicId()+mechanic.getMechanicName());
                }
            }
        }
        return "No mechanic yet.";
    }

}
