package com.mycompany.springboot.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "mechanics")
public class Mechanic implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Auto increment
    @Column(nullable = false)
    private Integer mechanicId;

    @Column(nullable = false)
    private String mechanicName;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, targetEntity = Car.class)
    @JoinTable(name = "mechanics_cars", joinColumns = {@JoinColumn(name = "mechanic_id")}, inverseJoinColumns = {@JoinColumn(name = "car_id")})
    private List<Car> carAccidents;

    @Transient
    @JsonIgnore
    private float avgSpeed;

    public Mechanic() {
    }

    public Mechanic(Integer mechanicId, String mechanicName, List<Car> carAccidents, float avgSpeed) {
        this.mechanicId = mechanicId;
        this.mechanicName = mechanicName;
        this.carAccidents = carAccidents;
        this.avgSpeed = avgSpeed;
    }

    public static float calculateAvgSpeed(List<Car> carAccidents) {
        int sum = 0;
        for (Car car : carAccidents) {
            sum = sum + car.getSpeed();
        }
        return sum / carAccidents.size();
    }

    public Integer getMechanicId() {
        return mechanicId;
    }

    public void setMechanicId(Integer id) {
        this.mechanicId = id;
    }

    public String getMechanicName() {
        return mechanicName;
    }

    public void setMechanicName(String mechanicName) {
        this.mechanicName = mechanicName;
    }

    public List<Car> getCarAccidents() {
        return carAccidents;
    }

    public void setCarAccidents(List<Car> carAccidents) {
        this.carAccidents = carAccidents;
    }

    public float getAvgSpeed() {
        return avgSpeed;
    }

    public void setAvgSpeed(float avgSpeed) {
        this.avgSpeed = avgSpeed;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Mechanic{");
        sb.append("id=").append(mechanicId);
        sb.append(", mechanicName='").append(mechanicName).append('\'');
        sb.append(", carAccidents=").append(carAccidents);
        sb.append(", avgSpeed=").append(avgSpeed);
        sb.append('}');
        return sb.toString();
    }
}
