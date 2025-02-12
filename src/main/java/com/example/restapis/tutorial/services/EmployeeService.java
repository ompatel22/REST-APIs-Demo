package com.example.restapis.tutorial.services;

import com.example.restapis.tutorial.dtos.EmployeeDTO;
import com.example.restapis.tutorial.entities.EmployeeEntity;
import com.example.restapis.tutorial.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public EmployeeDTO getEmployeeById(Long id) {
        EmployeeEntity employeeEntity = employeeRepository.getById(id);
        return modelMapper.map(employeeEntity, EmployeeDTO.class);
        //return new EmployeeDTO(employeeEntity.getId(),employeeEntity.getName(),employeeEntity.getDateOfJoining(),employeeEntity.isActive(),employeeEntity.getSalary());
    }

    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO, EmployeeEntity.class);
        employeeEntity = employeeRepository.save(employeeEntity);
        return modelMapper.map(employeeEntity, EmployeeDTO.class);
    }

    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeDTO> employeeDTOS = employeeRepository
                .findAll()
                .stream()
                .map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class))
                .collect(Collectors.toList());
        return employeeDTOS;
    }

    public boolean deleteEmployee(Long id) {
        boolean exists = employeeRepository.existsById(id);
        if(exists) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public EmployeeDTO updateEmployee(Long empId, EmployeeDTO employeeDTO) {
        // Fetch the existing employee
        EmployeeEntity employeeEntity = employeeRepository.findById(empId)
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + empId));

        employeeEntity.setName(employeeDTO.getName());
        employeeEntity.setSalary(employeeDTO.getSalary());
        employeeEntity.setDateOfJoining(employeeDTO.getDateOfJoining());
        employeeEntity.setActive(employeeDTO.isActive());

        // Save the updated entity
        EmployeeEntity updatedEntity = employeeRepository.save(employeeEntity);

        // Convert back to DTO and return
        return modelMapper.map(updatedEntity, EmployeeDTO.class);
    }
}
