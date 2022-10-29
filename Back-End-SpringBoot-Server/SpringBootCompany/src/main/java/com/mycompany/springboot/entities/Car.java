package com.mycompany.springboot.entities;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cars")
public class Car implements Serializable, Comparable<Car> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Auto increment
    @Column(nullable = false)
    private Integer id;

    @Column(length = 255)
    private String brand;

    @Column
    private int cost;

    @Column
    private int speed;

    public Car() {
    }

    public Car(Integer id, String brand, int cost, int speed) {
        this.id = id;
        this.brand = brand;
        this.cost = cost;
        this.speed = speed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    
    @Override
    public int compareTo(Car other) {
        return this.cost - other.cost;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Car{");
        sb.append("id=").append(id);
        sb.append(", brand='").append(brand).append('\'');
        sb.append(", cost=").append(cost);
        sb.append(", speed=").append(speed);
        sb.append('}');
        return sb.toString();
    }
}
