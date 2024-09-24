package com.week2WebApplication.SpringWebThings.repositories;

import com.week2WebApplication.SpringWebThings.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository <EmployeeEntity, Long> {

}
