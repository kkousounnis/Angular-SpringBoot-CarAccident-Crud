package com.mycompany.springboot.entities.dtos.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mycompany.springboot.entities.Mechanic;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MechanicResponse extends Response {

    private List<Mechanic> mechanics;

    private Mechanic mechanic;

    private Integer mechanicId;

    public MechanicResponse(List<Mechanic> mechanics) {
        this.mechanics = mechanics;
    }

}
