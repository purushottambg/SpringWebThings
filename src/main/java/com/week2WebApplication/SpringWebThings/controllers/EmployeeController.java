package com.week2WebApplication.SpringWebThings.Controllers; //This is from pull request, need to overwrite

import com.week2WebApplication.SpringWebThings.DTO.EmployeeDTO;
import com.week2WebApplication.SpringWebThings.Repositories.EmployeeRepo;
import com.week2WebApplication.SpringWebThings.entities.EmployeeEntity;
import com.week2WebApplication.SpringWebThings.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController (EmployeeService employeeService) { //Constructor based dependency injection
        this.employeeService = employeeService;
    }

    @GetMapping(path="/SecretMessage")    //Receive the data from software
    public String FirstMessage(){
        return "This is the first Message";
    }

    @GetMapping(path = "/{empid}")   //Receive the data from software
    public EmployeeDTO EmployeeID(@PathVariable int empid) {
       return employeeService.getEmployeeByID(empid);
    }
    @GetMapping(path = "/allEmployees")   //Receive the data from software
    public List<EmployeeDTO> AllEmployees() {
        return employeeService.getAllEmployee();
    }

    @PutMapping(path = "/putRequest")  //Update existing data
    public String PutReq(){
        return "Hello from Put";
    }

    @PostMapping(path = "/createNewEmployee")  //Create new data
    public EmployeeDTO CreateEmployee(@RequestBody EmployeeEntity inputEmployee){
        return  employeeService.save(inputEmployee);
    }

    @PatchMapping (path = "/patchMapping")   //Partially Update existing data
    public String PatchMapping(){
        return "Hello from Patching";
    }

    @DeleteMapping(path = "/deleteMapping")    //Delete the data
    public String DeleteMapping(){
        return "Hello From Delete";
    }
}