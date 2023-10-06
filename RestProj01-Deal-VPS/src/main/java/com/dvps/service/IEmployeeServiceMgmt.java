//IEmployeeServiceMgmt.java

/*
 * This interface defines the user-defined CURD operation methods
 * which will be used to perform various CURD operation in this application.
 * */
package com.dvps.service;

import java.util.List;

import com.dvps.entity.Employee;
import com.dvps.error.EmployeeNotFoundException;

public interface IEmployeeServiceMgmt {
	
	//This method saves employee info
	public String enrollEmployeeData(Employee employee);
	
	//This method fetches and returns all employee data available in the db
	public List<Employee> fetchAllEmployees();
	
	/*This method fetches and returns only single employee data depending on the input id values passed and 
	also throws exception if employee not found or invalid id.*/
	public Employee fetchEmployeeById(Integer id) throws EmployeeNotFoundException;

}//interface
