package com.mycompany.springboot.entities.dtos.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mycompany.springboot.entities.Car;
import java.util.List;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarResponse extends Response {

    private List<Car> cars;
    
    private Car car;
    
    private Integer carId;

    public CarResponse(List<Car> cars) {
        this.cars = cars;
    }

}
