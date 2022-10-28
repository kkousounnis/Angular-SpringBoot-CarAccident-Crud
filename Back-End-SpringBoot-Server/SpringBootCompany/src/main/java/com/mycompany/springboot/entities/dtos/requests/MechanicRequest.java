package com.mycompany.springboot.entities.dtos.requests;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mycompany.springboot.entities.Car;
import com.mycompany.springboot.entities.Mechanic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MechanicRequest {

    private Mechanic mechanic;
}
