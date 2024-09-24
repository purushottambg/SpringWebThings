package com.week2WebApplication.SpringWebThings.Controllers;

import com.week2WebApplication.SpringWebThings.DTO.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(path = "/")
public class EmployeeController {
    @GetMapping(path = "employees/{employeeID}")
    public EmployeeDTO getEmployee(@PathVariable int employeeID) {
        return new EmployeeDTO("Purushottam", 1, "purushottamgutthe6767@gmail.com", true, 25);
    }
    @GetMapping("/error")
    public String showName(){
        return "ran in to error";
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
    public String postMapping(){
        return "Hello From Postmapping";
    }
}