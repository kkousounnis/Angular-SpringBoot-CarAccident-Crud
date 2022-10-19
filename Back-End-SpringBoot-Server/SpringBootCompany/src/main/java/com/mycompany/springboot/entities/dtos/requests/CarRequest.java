package com.mycompany.springboot.entities.dtos.requests;

import com.mycompany.springboot.entities.Car;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarRequest {

    private Car employee;
}
