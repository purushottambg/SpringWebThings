package com.week2WebApplication.SpringWebThings.Repositories;

import com.week2WebApplication.SpringWebThings.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Integer> {

}
