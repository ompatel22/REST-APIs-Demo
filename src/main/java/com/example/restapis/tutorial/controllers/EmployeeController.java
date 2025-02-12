package com.example.restapis.tutorial.controllers;

import com.example.restapis.tutorial.dtos.EmployeeDTO;
import com.example.restapis.tutorial.services.EmployeeService;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path="/get/employee/{id}")
    public EmployeeDTO getEmployee(@PathVariable("id") Long empId) {
        //return new EmployeeDTO(empId,"om", LocalDate.of(2024,12,22),true,100000.00);
        return employeeService.getEmployeeById(empId);
    }

//    @GetMapping(path="/get/employees")
//    public String getData(@PathParam("sortBy") String sortBy,
//                          @PathParam("limit") Integer limit) {
//        return "get Employees "+sortBy+" "+limit;
//    }

    @GetMapping(path="/get/employees")
    public List<EmployeeDTO> getEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping(path="/add/employee")
    public EmployeeDTO addEmployee(@RequestBody EmployeeDTO employeeDTO) {
       return employeeService.createEmployee(employeeDTO);
    }

    @DeleteMapping(path = "/delete/employee/{id}")
    public boolean removeEmployee(@PathVariable("id") Long empId) {
        return employeeService.deleteEmployee(empId);
    }

    @PutMapping(path="/update/employee/{id}")
    public EmployeeDTO updateEmployee(@PathVariable("id") Long empId,@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.updateEmployee(empId,employeeDTO);
    }
}
