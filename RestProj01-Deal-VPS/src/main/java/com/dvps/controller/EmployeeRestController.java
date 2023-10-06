//EmployeeRestController.java
/*This is a Rest Controller class holding the properties of Controller and Response Body.
 * It is the used to capture the request based on the method path and return the resules simultaneously.*/
package com.dvps.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dvps.entity.Employee;
import com.dvps.service.IEmployeeServiceMgmt;

@RestController
@RequestMapping("/employeeApi")	//Global Path of rest application
public class EmployeeRestController {
	@Autowired
	private IEmployeeServiceMgmt empService;

	
	//Employee Registration method
	@PostMapping("/register-employee") //b.method specific path
	public ResponseEntity<String> registerEmployeeDetails(@RequestBody Employee employee){
		try {
			//adding employee details by using service class enroll method
			String msg = empService.enrollEmployeeData(employee);
			System.out.println(employee);
			//returning the added employee id with confirmation message and http confirm status via Response body
			return new ResponseEntity<String>(msg, HttpStatus.CREATED);			
		}//try
		catch (Exception e) {
			// catching the exception generated while unsuccessful employee registration
			return new ResponseEntity<String>("Please try after sometime....some Internal Error...!!!!!", HttpStatus.INTERNAL_SERVER_ERROR);
		}//catch
	}//method
	
	//All Employees details fetching method
	@GetMapping("/getAll-employees")
	public ResponseEntity<?> getAllEmployeesData(){
		try {
			//using Service class method to fetch all employee data available in the database
			List<Employee> list = empService.fetchAllEmployees();
			
			//returning all employees data 
			return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
		}//try
		catch (RuntimeException re) {
			// catching the exception if employee details not found
			return new ResponseEntity<String>("Internal Error...Please try after sometime...!!!!!", HttpStatus.INTERNAL_SERVER_ERROR);
		}//catch	
	}//method
	
	//Single Employee Details fetching method
	@GetMapping("/getEmp-ById/{id}")
	public ResponseEntity<?> getEmployeeById(@PathVariable Integer id){
		try {
			//using Service class method to get single employee data
			Employee emp = empService.fetchEmployeeById(id);
			
			//returning single employee data
			return new ResponseEntity<Employee>(emp, HttpStatus.OK);
		}//try
		catch (RuntimeException re) {
			// catching the exception if employee not found by the input id
			return new ResponseEntity<String>(re.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}//catch
	}//method

}//class
