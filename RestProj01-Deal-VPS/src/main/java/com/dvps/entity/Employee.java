//Employee.java
package com.dvps.entity;
/* 
 * This entity is a helper java bean class that holds the different values of employee and stores into the oracel database 
 * 
 * */
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "DEAL_VPS_REST_EMPLOYEE_TABLE")
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	@Id		//This id annotation generated id dynamically into the db
	@GeneratedValue(strategy = GenerationType.AUTO)	//This annotation generated the sequence dynamically into the db
	private Integer eid;

	@Column(length = 20)
	private String eName;
	
	@Column(length = 15)
	private String eCity;
	
	@Column(length = 20)
	private String eDept;
	
	@Column
	private Double eSalary;
	


}//class
