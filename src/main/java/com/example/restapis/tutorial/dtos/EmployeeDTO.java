package com.example.restapis.tutorial.dtos;

import java.time.LocalDate;

public class EmployeeDTO {

    private Long id;
    private String name;
    private LocalDate dateOfJoining;
    private boolean active;
    private double salary;

    public EmployeeDTO() {}

    public EmployeeDTO(Long id, String name, LocalDate dateOfJoining, boolean active, double salary) {
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
