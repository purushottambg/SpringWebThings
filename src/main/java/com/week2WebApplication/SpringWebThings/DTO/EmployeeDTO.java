package com.week2WebApplication.SpringWebThings.DTO;

import org.springframework.stereotype.Component;

@Component
public class EmployeeDTO {
    int ID;
    String Number;
    String Name, Address, Department, Email;
    Float Salary;
    public EmployeeDTO() {
    }

    public EmployeeDTO(int id, String number, String name, String address, float salary, String department, String email) {
        ID = id;
        Number = number;
        Name = name;
        Address = address;
        Salary = salary;
        Department = department;
        Email = email;
    }

    public int getId() {
        return ID;
    }

    public void setId(int id) {
        ID = id;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Float getSalary() {
        return Salary;
    }

    public void setSalary(Float salary) {
        Salary = salary;
    }
}
