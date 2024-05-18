package com.example.ems.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.ems.model.employee;

@Repository
public interface EmployeeRepository extends CrudRepository<employee, Integer>{

	

}
