package com.week2WebApplication.SpringWebThings.DTO;

import com.week2WebApplication.SpringWebThings.CustomAnnotations.DecideDept;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.validator.constraints.Length;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    private int ID;

    @Length(min = 10, max = 10, message = "Contact number is strictly 1o digits only")
    private String Number;
    @NotEmpty(message = "Don't let it empty")
    @Length(min = 3, max = 12, message = "name must have at least 3 and max 12 letters")
    private String Name;
    private String Address;
    @DecideDept   //Manually done this Annotation
    private String Department;
    @NotBlank(message = "Email of the employee cannot be blank")
    @jakarta.validation.constraints.Email(message = "Email should be a valid email")
    private String Email;
    @PositiveOrZero(message = "Salary can be only in positive range")
    private Float Salary;
}
