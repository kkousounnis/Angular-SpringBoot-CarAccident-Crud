package com.mycompany.springboot.services;

import com.mycompany.springboot.entities.Car;

import java.util.HashMap;
import java.util.List;

public interface MainService {

    public HashMap<String, List<Car>> createHashMap(List<Car> cars);
}
