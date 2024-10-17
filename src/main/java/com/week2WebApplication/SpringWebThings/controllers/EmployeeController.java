package com.week2WebApplication.SpringWebThings.Controllers; //This is from pull request, need to overwrite

import com.week2WebApplication.SpringWebThings.DTO.EmployeeDTO;
import com.week2WebApplication.SpringWebThings.Repositories.EmployeeRepo;
import com.week2WebApplication.SpringWebThings.entities.EmployeeEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//her we can write a logic for employee controller
@RestController
public class EmployeeController {

    private final EmployeeRepo employeeRepo;

    public EmployeeController(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @GetMapping(path="/SecretMessage")    //Receive the data from software
    public String FirstMessage(){
        return "This is the first Message";
    }
    @GetMapping(path = "/{empid}")   //Receive the data from software
    public EmployeeEntity EmployeeID(@PathVariable int empid) {
       return employeeRepo.findById(empid).orElse(null);
    }
    @PutMapping(path = "/PutRequest")  //Update existing data
    public String PutReq(){
        return "Hello from Put";
    }
    @PostMapping(path = "/postMappinng")  //Create new data
    public EmployeeEntity CreateEmployee(@RequestParam EmployeeEntity inputEmployee){
        return  employeeRepo.save(inputEmployee);
    }
    @PatchMapping (path = "/patchMapping")   //Partially Update existing data
    public String PatchMapping(){
        return "Hello from Patching";
    }
    @DeleteMapping(path = "deleteMapping")    //Delete the data
    public String DeleteMapping(){
        return "Hello From Delete";
    }
}