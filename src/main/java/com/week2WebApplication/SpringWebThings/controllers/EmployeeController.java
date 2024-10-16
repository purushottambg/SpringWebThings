package com.week2WebApplication.SpringWebThings.Controllers; //This is from pull request, need to overwrite

import com.week2WebApplication.SpringWebThings.DTO.EmployeeDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
//her we can write a logic for employee controller
@RestController
public class EmployeeController {
    @GetMapping(path="/SecretMessage")
    public String FirstMessage(){
        return "This is the first Message";
    }
    @GetMapping(path = "/EmployeesId")
    public String EmployeeDetails(){
        return "So you're here for employee details,\t Kindly enter the Employee Id of specific employee and retry";
    }
    @GetMapping(path = "/{empid}")
    public EmployeeDTO EmployeeID(@PathVariable int empid){
        return new EmployeeDTO(empid, "7666947497", "Pallavi Purushottam", "Pallavis Heart", 27000, "pediatricks", "DrPallavi.Darade@pgutthe.com" );
    }
}