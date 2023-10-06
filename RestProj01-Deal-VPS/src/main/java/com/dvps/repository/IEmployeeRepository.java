//IEmployeeRepository.java
/*This interface acts as Repository interface and extends from one pre-defined repository interface 
 * implementing all the methods of jpa interface  
 * */
package com.dvps.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dvps.entity.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

}//interface
