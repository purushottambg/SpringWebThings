package com.week2WebApplication.SpringWebThings.DTO;

public class EmployeeDTO {
    private  String name;
    private  int EmployeeID;
    private  String Email;
    private  boolean isActive;

    public EmployeeDTO(){}
    public EmployeeDTO(String name, int employeeID, String email, boolean isActive) {
        this.name = name;
        this.EmployeeID = employeeID;
        this.Email = email;
        this.isActive = isActive;
    }

    public String getName() {
        return name;
    }

    public int getEmployeeID() {
        return EmployeeID;
    }

    public String getEmail() {
        return Email;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployeeID(int employeeID) {
        EmployeeID = employeeID;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
