package com.mycompany.springboot.repositories;

import com.mycompany.springboot.entities.Mechanic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MechanicRepository extends JpaRepository<Mechanic, Integer> {

}
