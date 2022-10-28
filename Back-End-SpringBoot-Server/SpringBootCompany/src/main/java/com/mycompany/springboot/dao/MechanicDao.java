package com.mycompany.springboot.dao;

import com.mycompany.springboot.entities.Mechanic;

import java.util.List;

public interface MechanicDao {

    List<Mechanic> get();

    Mechanic get(int id);

    void save(Mechanic mechanic);

    void delete(int id);
    
    

}
