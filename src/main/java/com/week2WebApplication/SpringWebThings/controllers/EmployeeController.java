package com.week2WebApplication.SpringWebThings.Controllers; //This is from pull request, need to overwrite

import com.week2WebApplication.SpringWebThings.DTO.EmployeeDTO;
import com.week2WebApplication.SpringWebThings.Repositories.EmployeeRepo;
import com.week2WebApplication.SpringWebThings.entities.EmployeeEntity;
import com.week2WebApplication.SpringWebThings.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path="/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController (EmployeeService employeeService) { //Constructor based dependency injection
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/{empid}")   //Receive the data from software
    public ResponseEntity<EmployeeDTO> EmployeeID(@PathVariable int empid) {
        Optional<EmployeeDTO> employeeDTO = employeeService.getEmployeeByID(empid);
        return employeeDTO
                .map(employeeDTO1 -> ResponseEntity.ok(employeeDTO1))
                .orElse(ResponseEntity.notFound().build());
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
    public ResponseEntity<EmployeeDTO> CreateEmployee(@Valid @RequestBody EmployeeDTO inputEmployee){
        EmployeeDTO employeeDTO =employeeService.createNewEmployee(inputEmployee);
        return new ResponseEntity<>(employeeDTO, HttpStatus.CREATED);
    }

    @PatchMapping (path = "/patchMapping/{empid}")   //Partially Update existing data
    public ResponseEntity<EmployeeDTO> updateUserPartiallyByPatchMapping(@Valid @RequestBody Map<String, Object> updates, @PathVariable int empid){
        return ResponseEntity.ok(employeeService.updatePartiallyUser(empid, updates));
    }

    @DeleteMapping(path = "/deleteEmployee/{empid}")    //Delete the data
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable int empid){
        boolean isDeleted = employeeService.deleteEmployeeByID(empid);
        if(isDeleted)
            return ResponseEntity.ok(true);
        return ResponseEntity.notFound().build();
    }
}