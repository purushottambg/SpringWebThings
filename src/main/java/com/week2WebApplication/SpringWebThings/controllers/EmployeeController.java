package com.week2WebApplication.SpringWebThings.Controllers; //This is from pull request, need to overwrite

import com.week2WebApplication.SpringWebThings.DTO.EmployeeDTO;
import com.week2WebApplication.SpringWebThings.Repositories.EmployeeRepo;
import com.week2WebApplication.SpringWebThings.entities.EmployeeEntity;
import com.week2WebApplication.SpringWebThings.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path="/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController (EmployeeService employeeService) { //Constructor based dependency injection
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/{empid}")   //Receive the data from software
    public EmployeeDTO EmployeeID(@PathVariable int empid) {
       return employeeService.getEmployeeByID(empid);
    }
    @GetMapping(path = "/allEmployees")   //Receive the data from software
    public List<EmployeeDTO> AllEmployees() {
        return employeeService.getAllEmployee();
    }

    @PutMapping(path = "/updateEmployee/{empid}")  //Update existing data or create new one if not exist
    public EmployeeDTO updateEmployee(@RequestBody EmployeeDTO employeeDTO, @PathVariable int empid){
        return employeeService.updateEmployee(employeeDTO, empid);
    }

    @PostMapping(path = "/createNewEmployee")  //Create new data
    public EmployeeDTO CreateEmployee(@RequestBody EmployeeEntity inputEmployee){
        return  employeeService.save(inputEmployee);
    }

    @PatchMapping (path = "/patchMapping/{empid}")   //Partially Update existing data
    public EmployeeDTO updateUserPartiallyByPatchMapping(@RequestBody Map<String, Object> updates, @PathVariable int empid){
        return employeeService.updatePartiallyUser(empid, updates);
    }

    @DeleteMapping(path = "/deleteEmployee/{empid}")    //Delete the data
    public boolean deleteEmployee(@PathVariable int empid){
        return employeeService.deleteEmployeeByID(empid);
    }
}