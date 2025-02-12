package com.example.restapis.tutorial.repositories;

import com.example.restapis.tutorial.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long>{
}
