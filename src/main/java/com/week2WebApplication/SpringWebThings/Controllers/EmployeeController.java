package com.week2WebApplication.SpringWebThings.Controllers;

import com.week2WebApplication.SpringWebThings.DTO.EmployeeDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping(path = "/")
public class EmployeeController {
    @GetMapping(path = "employees/{employeeID}")
    public EmployeeDTO getEmployee(@PathVariable int employeeID) {
        return new EmployeeDTO("Purushottam", 1, "purushottamgutthe6767@gmail.com", true);
    }
    @GetMapping(path = "/ShowName")
    public String showName(){
        return "Written by Purushottam";
    }

}
