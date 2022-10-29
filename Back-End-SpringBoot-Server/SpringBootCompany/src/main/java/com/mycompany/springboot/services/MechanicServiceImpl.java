package com.mycompany.springboot.services;

import com.mycompany.springboot.dao.MechanicDao;
import com.mycompany.springboot.entities.Mechanic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MechanicServiceImpl implements MechanicService {

    @Autowired
    private MechanicDao dao;

    @Override
    public List<Mechanic> get() {
        return dao.get();
    }

    @Override
    public Mechanic get(int id) {
        return dao.get(id);
    }

    @Override
    public void save(Mechanic mechanic) {
        dao.save(mechanic);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }

}
