package com.week2WebApplication.SpringWebThings.controllers;

import com.week2WebApplication.SpringWebThings.entities.EmployeeEntity;
import com.week2WebApplication.SpringWebThings.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(path = "/")
public class EmployeeController {
    private final EmployeeRepository employeeRepository;
    public EmployeeController (EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }
    @GetMapping(path = "employees/{employeeID}")
    public boolean getEmployee(@PathVariable Long employeeID) {
        return employeeRepository.findAllById(Collections.singleton(employeeID)).remove(null);
    }
    @GetMapping
    public List<EmployeeEntity> getAllEmployees(@RequestParam(required = false, name = "inputAge") Integer age, @RequestParam(required = false) String sortBy) {
        return employeeRepository.findAll();
    }

    @GetMapping(path = "/error/{cnt}")
    public int error(@PathVariable int cnt){
        return cnt;
    }
    @GetMapping(path = "/employees")
    public String getAllEmployees(@RequestParam Integer Age){
        return "Hi age is: "+Age;
    }
    @PostMapping
    public EmployeeEntity createNewEmployee(@RequestBody EmployeeEntity inputEmployee){
        return employeeRepository.save(inputEmployee);
    }
}