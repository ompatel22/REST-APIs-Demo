package com.example.restapis.tutorial.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="employees")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate dateOfJoining;
    private boolean active;
    private double salary;

    public EmployeeEntity() {
    }

    public EmployeeEntity(Long id, String name, LocalDate dateOfJoining, boolean active, double salary) {
        this.id = id;
        this.name = name;
        this.dateOfJoining = dateOfJoining;
        this.active = active;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
