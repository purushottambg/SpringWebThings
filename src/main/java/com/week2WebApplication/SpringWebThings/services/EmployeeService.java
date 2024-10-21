package com.week2WebApplication.SpringWebThings.services;


import com.week2WebApplication.SpringWebThings.DTO.EmployeeDTO;
import com.week2WebApplication.SpringWebThings.Repositories.EmployeeRepo;
import com.week2WebApplication.SpringWebThings.configs.MapperConfig;
import com.week2WebApplication.SpringWebThings.entities.EmployeeEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo; //Declared instances of Repository
    private final ModelMapper modelMapper; //Declared instances of Mapper

    public EmployeeService (EmployeeRepo employeeRepo, ModelMapper mapperConfig){   //Initialization of an instances
        this.modelMapper=mapperConfig;
        this.employeeRepo=employeeRepo;
    }


    public List<EmployeeDTO> getAllEmployee() {   //Function that accept no input and provides output with all the employees
        List<EmployeeEntity> employeeEntities = employeeRepo.findAll();
        return employeeEntities.stream()
                .map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    public EmployeeDTO getEmployeeByID(int empid){   //Function should return only one employee who's empid matches to the input parameter
        EmployeeEntity employeeEntity = employeeRepo.findById(empid).orElse(null);
        return modelMapper.map(employeeEntity, EmployeeDTO.class);
    }

    public EmployeeDTO save(EmployeeEntity inputEmployee) {
        EmployeeEntity createNewEmployee = modelMapper.map(inputEmployee, EmployeeEntity.class);
        EmployeeEntity employeeEntity1= employeeRepo.save(createNewEmployee);
        return modelMapper.map(employeeEntity1, EmployeeDTO.class);
    }
}