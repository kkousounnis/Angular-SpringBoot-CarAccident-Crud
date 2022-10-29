package com.mycompany.springboot.controllers;

import com.mycompany.springboot.entities.Car;
import com.mycompany.springboot.entities.Mechanic;
import com.mycompany.springboot.entities.dtos.responses.CarResponse;
import com.mycompany.springboot.entities.dtos.responses.MechanicResponse;
import com.mycompany.springboot.services.CarServiceImpl;
import com.mycompany.springboot.services.MainServiceImpl;
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

    @Autowired
    private MainServiceImpl mainServiceImpl;

    @GetMapping("/mechanic-cars-sorted")
    public HashMap<String, List<Car>> get() {
        List<Car> cars = carServiceImpl.get();
        /**
         * Sort cars with Comparator by Cost Field.
         * Related Github link
         * https://github.com/albertattard/sorting-objects-using-comparator
         */
        Collections.sort(cars);
        HashMap<String, List<Car>> mechanicCarsSorted = new HashMap<>();

        String tmp = "";
        for (Car car : cars) {

            String name = findStringName(car.getId());
            List<Car> carsWithSameMechanic = new ArrayList<>();
            if (name.equals(tmp)) {
                carsWithSameMechanic.add(car);
            }
            mechanicCarsSorted.put()


        }
        mainServiceImpl.createHashMap(cars);
        return (null);
    }

    public String findStringName(int id) {
        for (Mechanic mechanic : mechanicServiceImpl.get()) {
            for (Car car : mechanic.getCarAccidents()) {
                if (car.getId() == id) {
                    return (mechanic.getMechanicName());
                }
            }
        }
        return "No mechanic yet.";
    }

}
