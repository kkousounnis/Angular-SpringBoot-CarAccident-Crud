package com.mycompany.springboot.dao;

import com.mycompany.springboot.entities.Mechanic;
import com.mycompany.springboot.repositories.MechanicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MechanicDaoImpl implements MechanicDao {

    @Autowired
    private MechanicRepository MechanicRepository;

    @Override
    public List<Mechanic> get() {
        return MechanicRepository.findAll();
    }

    @Override
    public Mechanic get(int id) {
        return MechanicRepository.findById(id).get();
    }

    @Override
    public void save(Mechanic mechanic) {
        MechanicRepository.save(mechanic);
    }

    @Override
    public void delete(int id) {
        MechanicRepository.deleteById(id);
    }

}
