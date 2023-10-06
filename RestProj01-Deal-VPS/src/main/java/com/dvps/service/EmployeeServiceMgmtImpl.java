//EmployeeServiceMgmtImpl.java
/*
 * This is Service class holds the b.methods and logics for all the CURD based operation to be performed
 * inside the methods defined for various operations.
 * It internally uses hibernate to generate and run various SQL Queries.
 * */
package com.dvps.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dvps.entity.Employee;
import com.dvps.error.EmployeeNotFoundException;
import com.dvps.repository.IEmployeeRepository;

@Service("empService")
public class EmployeeServiceMgmtImpl implements IEmployeeServiceMgmt {
	//Injecting repository interface to use its pre-defined methods
	@Autowired
	private IEmployeeRepository empRepo;

	/*This method saves all employee data into the database*/
	@Override
	public String enrollEmployeeData(Employee employee) {
		// adding the employee details to the database
		return "Employee Details are saved with generated Id :: "+empRepo.save(employee).getEid();
	}//method

	/*This method gets all employee data at once from the database*/
	@Override
	public List<Employee> fetchAllEmployees() {
		// getting all employees data from database
		return empRepo.findAll();
	}//class

	/*This method gets only single employee data based on the id passed from the database*/
	@Override
	public Employee fetchEmployeeById(Integer id) throws EmployeeNotFoundException {
		// getting a single employee details from database using the given input employee id
		return empRepo.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Invalid Employee Id / Employee Not Found......!!!!!!"));
	}//method

}//class
