package com.controller;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.basicMicrosarviceProject.Employee;

@RestController
public class EmployeController {
	
@Autowired								// conf file intialze automatically
SessionFactory sessionfactory;

@GetMapping("/getEmployee")
Employee getEmployee() {
	Session session = sessionfactory.openSession();
	Employee employee = session.get(Employee.class, 1);
	return employee; 
}
	
	@PostMapping("/addEmployee")
	String addEmployee() {
		Session session = sessionfactory.openSession();
		Employee employee = new Employee(6,"pall",24);
		session.save(employee);
		session.beginTransaction().commit();
		return "Employee added "; 
	}
	
		@DeleteMapping("/deletEmployee")
		String deletEmployee() {
			Session session = sessionfactory.openSession();
			Employee employee = new Employee(6,"pall",24);
			session.save(employee);
			session.beginTransaction().commit();
			return "Employee deleted "; 
		}
}		
		
		
