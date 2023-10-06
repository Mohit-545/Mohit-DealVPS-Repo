//EmployeeNotFoundException.java
/*This is a user-defined exception class to throw an instance of runtime exception. */
package com.dvps.error;

public class EmployeeNotFoundException extends RuntimeException {
	
	public EmployeeNotFoundException() {
		super();
	}//noarg-constructor()

	public EmployeeNotFoundException(String msg) {
		super(msg);
	}//arg-contructor()
	
}//class
