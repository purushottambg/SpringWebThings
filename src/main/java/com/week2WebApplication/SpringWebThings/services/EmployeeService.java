package com.week2WebApplication.SpringWebThings.services;


import com.week2WebApplication.SpringWebThings.DTO.EmployeeDTO;
import com.week2WebApplication.SpringWebThings.Repositories.EmployeeRepo;
import com.week2WebApplication.SpringWebThings.entities.EmployeeEntity;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.data.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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

    public Optional<EmployeeDTO> getEmployeeByID(int empid){   //Function should return only one employee who's empid matches to the input parameter
        EmployeeEntity employeeEntity = employeeRepo.findById(empid).orElse(null);
        return employeeRepo.findById(empid).map(employeeEntity1 -> modelMapper.map(employeeRepo, EmployeeDTO.class));
    }

    public EmployeeDTO save(EmployeeDTO inputEmployee) {
        EmployeeEntity createNewEmployee = modelMapper.map(inputEmployee, EmployeeEntity.class);
        EmployeeEntity employeeEntity1= employeeRepo.save(createNewEmployee);
        return modelMapper.map(employeeEntity1, EmployeeDTO.class);
    }
    private boolean existence(int empid){
        return employeeRepo.existsById(empid);
    }

    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO, int empid) {  //Update Employee or save if new
        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO, EmployeeEntity.class);
        employeeEntity.setID(empid);
        EmployeeEntity savedEmployeeEntity = employeeRepo.save(employeeEntity);
        return modelMapper.map(savedEmployeeEntity, EmployeeDTO.class);
    }

    public boolean deleteEmployeeByID(int empid) {
        boolean exist = existence(empid);
        if(!exist) return false;
        employeeRepo.deleteById(empid);
        return true;
    }
    public EmployeeDTO updatePartiallyUser(int empid, Map<String, Object> updates){
        boolean exist = existence(empid);
        if(!exist) return null;
        EmployeeEntity employeeEntity = employeeRepo.findById(empid).get();
        updates.forEach((field, value)->{
            Field filedToBeUpdated = ReflectionUtils.findRequiredField(EmployeeDTO.class, field);
            filedToBeUpdated.setAccessible(true);
            ReflectionUtils.setField(filedToBeUpdated, employeeEntity, value);
        });
        return modelMapper.map(employeeRepo.save(employeeEntity), EmployeeDTO.class);
    }

    public EmployeeDTO createNewEmployee(@Valid EmployeeDTO inputEmployee) {
        EmployeeEntity toSaveEmployeeEntity = modelMapper.map(inputEmployee, EmployeeEntity.class);
        EmployeeEntity savedEmployeeEntity = employeeRepo.save(toSaveEmployeeEntity);
        return  modelMapper.map(savedEmployeeEntity, EmployeeDTO.class);
    }
}
