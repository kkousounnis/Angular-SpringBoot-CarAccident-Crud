package com.mycompany.springboot.controllers;

import com.mycompany.springboot.entities.Car;
import com.mycompany.springboot.entities.Mechanic;
import com.mycompany.springboot.entities.dtos.requests.MechanicRequest;
import com.mycompany.springboot.entities.dtos.responses.MechanicResponse;
import com.mycompany.springboot.services.CarServiceImpl;
import com.mycompany.springboot.services.MechanicServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class MechanicController {
    @Autowired
    private MechanicServiceImpl MechanicServiceImpl;

    @Autowired
    private CarServiceImpl carServiceImpl;

    @GetMapping("/mechanic")
    public List<Mechanic> get() {

        return (new MechanicResponse(MechanicServiceImpl.get()).getMechanics());
    }


    @PostMapping("/mechanic")
    public ResponseEntity<Mechanic> save(@RequestBody MechanicRequest mechanic) {
        //update car accident id
        int index = 0;
        //Save every car accident in the list
        for (Car car : mechanic.getMechanic().getCarAccidents()) {
            Car carCreated = carServiceImpl.save(car);
            //update car accident id
            mechanic.getMechanic().getCarAccidents().get(index).setId(carCreated.getId());
            index++;
        }
        MechanicServiceImpl.save(mechanic.getMechanic());

        return new ResponseEntity("Mechanic created with success.", HttpStatus.CREATED);
    }


    @GetMapping("/mechanic/{id}")
    public ResponseEntity<Mechanic> get(@PathVariable int id) {
        Mechanic Mechanic = MechanicServiceImpl.get(id);
        return new ResponseEntity("Success", HttpStatus.OK);
    }


    @DeleteMapping("/mechanic/{id}")
    public ResponseEntity<Map<String, Boolean>> delete(@PathVariable int id) {
        MechanicServiceImpl.delete(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return new ResponseEntity("Deleted with success.", HttpStatus.OK);
    }


    @PutMapping("/mechanic/{id}")
    public ResponseEntity<Mechanic> update(@PathVariable int id, @RequestBody MechanicRequest mechanicDetails) {
        Mechanic Mechanic = MechanicServiceImpl.get(id);
        mechanicDetails.getMechanic().setMechanicId(Mechanic.getMechanicId());
        MechanicServiceImpl.save(mechanicDetails.getMechanic());
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
