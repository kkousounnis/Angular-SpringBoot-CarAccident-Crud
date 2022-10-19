package com.mycompany.springboot.entities.dtos.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mycompany.springboot.entities.Car;
import java.util.List;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarResponse extends Response {

    private List<Car> employees;
    private Car employee;
    private Integer employeeId;

    public CarResponse(List<Car> employees) {
        this.employees = employees;
    }

}
